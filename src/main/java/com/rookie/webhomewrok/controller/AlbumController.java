package com.rookie.webhomewrok.controller;

import com.mybatisflex.core.query.QueryChain;
import com.mybatisflex.core.query.QueryWrapper;
import com.rookie.webhomewrok.config.MinioConfigProp;
import com.rookie.webhomewrok.entity.AlbumSangsTable;
import com.rookie.webhomewrok.entity.AlbumTable;
import com.rookie.webhomewrok.entity.SangsTable;
import com.rookie.webhomewrok.entity.table.AlbumSangsTableTableDef;
import com.rookie.webhomewrok.entity.table.AlbumTableTableDef;
import com.rookie.webhomewrok.mapper.AlbumMapper;
import com.rookie.webhomewrok.mapper.AlbumToSangMapper;
import com.rookie.webhomewrok.result.AlbumDetail;
import com.rookie.webhomewrok.result.AlbumList;
import com.rookie.webhomewrok.result.PlayList;
import com.rookie.webhomewrok.result.Result;
import com.rookie.webhomewrok.service.AlbumService;
import com.rookie.webhomewrok.service.AlbumToSangService;
import com.rookie.webhomewrok.service.SangsService;
import com.rookie.webhomewrok.utils.RedisUtils;
import io.minio.MinioClient;
import io.minio.PutObjectArgs;
import io.minio.errors.*;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletRequest;
import org.apache.ibatis.jdbc.Null;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static com.rookie.webhomewrok.entity.table.AlbumSangsTableTableDef.ALBUM_SANGS_TABLE;
import static com.rookie.webhomewrok.entity.table.AlbumTableTableDef.ALBUM_TABLE;
@RestController
public class AlbumController {
    @Resource
    RedisUtils redisUtils;
    @Resource
    SangsService sangsService;
    @Resource
    MinioClient minioClient;
    @Resource
    AlbumService albumService;
    @Resource
    AlbumToSangService albumToSangService;


    @PostMapping("/album/create")
    public Result<Null> CreateAlbum(
            @RequestParam("title") String title,
            @RequestParam("img") MultipartFile img,
            @RequestParam("author") String author,
            @RequestParam("description") String description,
            @RequestParam("time") String time) throws IOException, ServerException, InsufficientDataException, ErrorResponseException, NoSuchAlgorithmException, InvalidKeyException, InvalidResponseException, XmlParserException, InternalException {
        String originalFilename = img.getOriginalFilename();
        var imgSuffix = originalFilename != null ? originalFilename.substring(originalFilename.lastIndexOf(".") + 1) : "png";
        String fileName = UUID.randomUUID().toString()+"."+imgSuffix;
        InputStream imgInputStream = img.getInputStream();
        minioClient.putObject(PutObjectArgs.builder()
                        .bucket("album")
                        .object(fileName)
                        .stream(imgInputStream,img.getSize(),-1)
                        .build()
        );
        AlbumTable albumTable=new AlbumTable();
        albumTable.setCover(MinioConfigProp.MinioEndpoint+"/album/"+fileName);
        albumTable.setTitle(title);
        albumTable.setAuthor(author);
        albumTable.setDescription(description);
        albumService.save(albumTable);
        return Result.success(null);
    }
    @GetMapping("/album/search")
    public Result<AlbumList> SearchAlbum(
            HttpServletRequest req
    ){
        String keyword = req.getParameter("keyword");
        AlbumList albumList=new AlbumList();
        if(keyword.isEmpty()){
            List<AlbumTable> list = QueryChain.of(albumService.getMapper()).list();
            albumList.setAlbumlist(list);
        }else{
            List<AlbumTable> list = QueryChain.of(albumService.getMapper())
                    .where(ALBUM_TABLE.TITLE.like(keyword))
                    .or(ALBUM_TABLE.AUTHOR.like(keyword))
                    .list();
            albumList.setAlbumlist(list);
        }
        return Result.success(albumList);
    }
    @GetMapping("/album/detail")
    public Result<AlbumDetail> AlbumDetail(HttpServletRequest req){
        String aid = req.getParameter("aid");
        AlbumTable albumTable = albumService.getById(Integer.parseInt(aid));
        AlbumDetail res=new AlbumDetail();
        res.setAlbum(albumTable);
        List<AlbumSangsTable>  Reflexes= QueryChain.of(albumToSangService.getMapper()).where(ALBUM_SANGS_TABLE.AID.eq(Integer.parseInt(aid))).list();
        List<SangsTable> sangsTables=new ArrayList<>();
        Reflexes.forEach(it->{
            SangsTable sang = sangsService.getById(it.getSid());
            sangsTables.add(sang);
        });
        res.setSangslist(sangsTables);
        return Result.success(res);
    }
    @PostMapping("/album/add")
    public Result<Null> AddAlbum(HttpServletRequest req){
        String aid = req.getParameter("aid");
        String sid = req.getParameter("sid");
        AlbumSangsTable albumSangsTable=new AlbumSangsTable();
        albumSangsTable.setAid(Integer.parseInt(aid));
        albumSangsTable.setSid(Integer.parseInt(sid));
        albumToSangService.save(albumSangsTable);
        return Result.success(null);
    }
    @PostMapping("/album/delete")
    public Result<Null> DeleteAlbum(HttpServletRequest req){
        String aid = req.getParameter("aid");
        String sid = req.getParameter("sid");
        AlbumSangsTable one = QueryChain.of(albumToSangService.getMapper())
                .where(ALBUM_SANGS_TABLE.AID.eq(Integer.parseInt(aid)))
                .and(ALBUM_SANGS_TABLE.SID.eq(Integer.parseInt(sid))).one();
        albumToSangService.removeById(one.getId());
        return Result.success(null);
    }
    @PostMapping("/album/update")
    public  Result<Null> UpdateAlbum(
            @RequestParam("aid") String aid,
            @RequestParam("title") String title,
                @RequestParam("img") MultipartFile img,
            @RequestParam("author") String author,
            @RequestParam("description") String description
    ) throws IOException, ServerException, InsufficientDataException, ErrorResponseException, NoSuchAlgorithmException, InvalidKeyException, InvalidResponseException, XmlParserException, InternalException {
        String originalFilename = img.getOriginalFilename();
        var imgSuffix = originalFilename != null ? originalFilename.substring(originalFilename.lastIndexOf(".") + 1) : "png";

        AlbumTable oriAlbum = albumService.getById(Integer.parseInt(aid));
        String url = oriAlbum.getCover();

        String fileNameWithExtension = url.substring(url.lastIndexOf('/') + 1); // 提取路径中的文件名
        String fileNameWithoutExtension = fileNameWithExtension.substring(0, fileNameWithExtension.lastIndexOf('.')); // 去掉后缀

        String fileName = fileNameWithoutExtension +'.'+ imgSuffix;
        InputStream imgInputStream = img.getInputStream();

        minioClient.putObject(PutObjectArgs.builder()
                        .bucket("album")
                        .object(fileName)
                        .stream(imgInputStream,img.getSize(),-1)
                .build());
        oriAlbum.setAuthor(author);
        oriAlbum.setDescription(description);
        oriAlbum.setTitle(title);
        oriAlbum.setCover(MinioConfigProp.MinioEndpoint+"/album/"+fileName);
        albumService.update(oriAlbum, QueryWrapper.create().where(ALBUM_TABLE.ID.eq(Integer.parseInt(aid))));
        return Result.success(null);
    }

}
