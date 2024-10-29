package com.rookie.webhomewrok.service;


import com.rookie.webhomewrok.entity.AlbumTable;
import com.rookie.webhomewrok.mapper.AlbumMapper;
import com.mybatisflex.spring.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class AlbumService extends ServiceImpl<AlbumMapper, AlbumTable> implements IAlbumService{
}
