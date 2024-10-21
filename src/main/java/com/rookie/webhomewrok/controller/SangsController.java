package com.rookie.webhomewrok.controller;

import com.mybatisflex.core.query.QueryChain;
import com.rookie.webhomewrok.config.MinioConfigProp;
import com.rookie.webhomewrok.entity.SangsTable;
import com.rookie.webhomewrok.result.PlayList;
import com.rookie.webhomewrok.result.Result;
import com.rookie.webhomewrok.service.SangsService;
import com.rookie.webhomewrok.utils.RedisUtils;
import io.minio.MinioClient;
import io.minio.PutObjectArgs;
import io.minio.errors.*;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletRequest;
import org.apache.ibatis.jdbc.Null;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

import static com.rookie.webhomewrok.entity.table.SangsTableTableDef.SANGS_TABLE;

@RestController
public class SangsController {
    @Resource
    RedisUtils redisUtils;
    @Resource
    SangsService sangsService;
    @Resource
    MinioClient minioClient;
    
    
    @PostMapping("/upload/sangs")
    public Result<Null> uploadSangs(
            @RequestParam("mp3") MultipartFile mp3,
            @RequestParam("img") MultipartFile img,
            @RequestParam("title") String title,
            @RequestParam("author")String author
            ) throws IOException, ServerException, InsufficientDataException, ErrorResponseException, NoSuchAlgorithmException, InvalidKeyException, InvalidResponseException, XmlParserException, InternalException {
        String originalMp3Name = mp3.getOriginalFilename();
        String originalImageName = img.getOriginalFilename();
        var mp3Suffix = originalMp3Name != null ? originalMp3Name.substring(originalMp3Name.lastIndexOf(".") + 1) : "mp3";
        var imgSuffix = originalImageName != null ? originalImageName.substring(originalImageName.lastIndexOf(".") + 1) : "png";

        var mp3FIleName= UUID.randomUUID().toString()+"."+mp3Suffix;
        var imgFIleName= UUID.randomUUID().toString()+"."+imgSuffix;
        InputStream mp3InputStream = mp3.getInputStream();
        InputStream imgInputStream = img.getInputStream();
        minioClient.putObject(PutObjectArgs.builder()
                .bucket("sangs")
                .object(mp3FIleName)
                .stream(mp3InputStream,mp3.getSize(),-1)
                .build());
        minioClient.putObject(PutObjectArgs.builder()
                .bucket("cover")
                .object(imgFIleName)
                .stream(imgInputStream,img.getSize(),-1)
                .build());

        SangsTable sangsTable = new SangsTable();
        sangsTable.setUrl(MinioConfigProp.MinioEndpoint+"/sangs/"+mp3FIleName);
        sangsTable.setImg(MinioConfigProp.MinioEndpoint+"/cover/"+imgFIleName);
        sangsTable.setTitle(title);
        sangsTable.setAuthor(author);
        sangsService.save(sangsTable);
        return Result.success(null);
    }
    @GetMapping("/sangs/search")
    public Result<PlayList> searchSangs(HttpServletRequest req){
        String keyword = req.getParameter("keyword");
        PlayList playList = new PlayList();
        List<SangsTable> list;
        if(!Objects.equals(keyword, "")) {
            list = QueryChain.of(sangsService.getMapper())
                    .where(SANGS_TABLE.AUTHOR.like(keyword))
                    .or(SANGS_TABLE.TITLE.like(keyword)).list();
        }else{
            list = QueryChain.of(sangsService.getMapper()).orderBy(SANGS_TABLE.ID.desc()).list();
        }
        playList.setPlaylist(list);
        return Result.success(playList);
    }
    
    @GetMapping("/playlist/get")
    public Result<PlayList> getPlaylist(HttpServletRequest req) {
        String uid = req.getParameter("uid");
        PlayList playList = redisUtils.getValue(uid, PlayList.class);
        return Result.success(playList);
    }
    
    @PostMapping("/playlist/add")
    public Result<Null> AddPlayList(HttpServletRequest req) {
        String uid = req.getParameter("uid");
        String cid = req.getParameter("sid");
        if (redisUtils.exists(uid)) {
            boolean isExists = false;
            PlayList value = redisUtils.getValue(uid, PlayList.class);

            for (SangsTable item : value.getPlaylist()) {
                if (item.getId().equals(Integer.parseInt(cid))) {
                    isExists = true;
                    break;
                }
            }

            if (!isExists) {
                SangsTable sang = sangsService.getById(Integer.parseInt(cid));
                List<SangsTable> playlist = value.getPlaylist();
                playlist.add(sang);
                value.setPlaylist(playlist);
                redisUtils.setValue(uid, value, 114514);
            }
        }else{
            PlayList list=new PlayList();
            List<SangsTable> playlist=new ArrayList<>();
            SangsTable sangsTable = sangsService.getById(Integer.parseInt(cid));
            playlist.add(sangsTable);
            list.setPlaylist(playlist);
            redisUtils.setValue(uid,list,114514);
        }
        return Result.success(null);
    }
    @PostMapping("/playlist/delete")
    public Result<Null> DeletePlayList(HttpServletRequest req) {
        String uid = req.getParameter("uid");
        String sid = req.getParameter("sid");
        PlayList playList = redisUtils.getValue(uid, PlayList.class);
        List<SangsTable> newlist = new ArrayList<>();
        playList.getPlaylist().forEach(it ->{
            if(it==null)return;
            if(!it.getId().toString().equals(sid)){
                newlist.add(it);
            }
        });
        playList.setPlaylist(newlist);
        redisUtils.setValue(uid,playList,114514);
        return Result.success(null);
    }
    @PostMapping("/playlist/addtop")
    public Result<Null> AddPlayListTop(HttpServletRequest req) {
        String uid = req.getParameter("uid");
        String sid = req.getParameter("sid");
        PlayList playList = redisUtils.getValue(uid, PlayList.class);
        SangsTable SangTable = sangsService.getById(sid);
        List<SangsTable> newlist = new ArrayList<>();
        newlist.add(SangTable);
        for (int i = 1; i < playList.getPlaylist().size(); i++) {
            if(Integer.parseInt(sid) != playList.getPlaylist().get(i).getId())
                newlist.add(playList.getPlaylist().get(i));
        }
        playList.setPlaylist(newlist);
        redisUtils.setValue(uid,playList,114514);
        return Result.success(null);
    }
    @PostMapping("/playlist/addtonext")
    public Result<Null> AddPlayListNext(HttpServletRequest req) {
        String uid = req.getParameter("uid");
        String sid = req.getParameter("sid");

        PlayList playList = redisUtils.getValue(uid, PlayList.class);

        SangsTable sangTable = sangsService.getById(sid);

        List<SangsTable> newlist = new ArrayList<>();

        if (playList.getPlaylist() != null && !playList.getPlaylist().isEmpty()) {
            newlist.add(playList.getPlaylist().getFirst());
            newlist.add(sangTable);
            for (int i = 1; i < playList.getPlaylist().size(); i++) {
                newlist.add(playList.getPlaylist().get(i));
            }
        } else {
            newlist.add(sangTable);
        }

        playList.setPlaylist(newlist);

        redisUtils.setValue(uid, playList, 114514);

        return Result.success(null);
    }
    


}
