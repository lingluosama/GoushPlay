package com.rookie.webhomewrok.controller;

import com.rookie.webhomewrok.entity.SangsTable;
import com.rookie.webhomewrok.result.BaseResult;
import com.rookie.webhomewrok.result.PlayList;
import com.rookie.webhomewrok.service.SangsService;
import com.rookie.webhomewrok.utils.RedisUtils;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletRequest;
import org.apache.ibatis.jdbc.Null;
import org.babyfish.jimmer.sql.ast.PropExpression;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;

@RestController
public class HwController {
    @Resource
    RedisUtils redisUtils;
    @Resource
    SangsService sangsService;
    
    @PostMapping("/upload/sangs")
    public BaseResult<Null> uploadSangs(@RequestPart("mp3") MultipartFile mp3,@RequestPart("img") MultipartFile img,HttpServletRequest req) {
        
        
    }
    
    @GetMapping("/playlist/get")
    public BaseResult<Null> getPlaylist(HttpServletRequest req) {}
    
    @PostMapping("/playlist/add")
    public BaseResult<Null> AddPlayList(HttpServletRequest req) {
        String uid = req.getParameter("uid");
        String cid = req.getParameter("cid");
        if(redisUtils.exists(uid)){
            PlayList value = redisUtils.getValue(uid, PlayList.class);
            SangsTable sang = sangsService.getById(Integer.parseInt(cid));
            List<SangsTable> playlist = value.getPlaylist();
            playlist.add(sang);
            value.setPlaylist(playlist);
            redisUtils.setValue(uid,value,114514);
        }else{
            PlayList list=new PlayList();
            List<SangsTable> playlist=new ArrayList<>();
            SangsTable sangsTable = sangsService.getById(Integer.parseInt(cid));
            playlist.add(sangsTable);
            list.setPlaylist(playlist);
            redisUtils.setValue(uid,list,114514);
        }
        return BaseResult.success();
    }
    @PostMapping("/playlist/delete")
    public BaseResult<Null> DeletePlayList(HttpServletRequest req) {
        String uid = req.getParameter("uid");
        String sid = req.getParameter("sid");
        PlayList playList = redisUtils.getValue(uid, PlayList.class);
        List<SangsTable> newlist = new ArrayList<>();
        playList.getPlaylist().forEach(it ->{
            if(!it.getId().toString().equals(sid)){
                newlist.add(it);
            }
        });
        redisUtils.setValue(uid,newlist,114514);
        return BaseResult.success();
    }
}
