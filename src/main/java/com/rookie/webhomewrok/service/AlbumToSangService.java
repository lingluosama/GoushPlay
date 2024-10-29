package com.rookie.webhomewrok.service;

import com.mybatisflex.spring.service.impl.ServiceImpl;
import com.rookie.webhomewrok.entity.AlbumSangsTable;
import com.rookie.webhomewrok.mapper.AlbumToSangMapper;
import org.springframework.stereotype.Service;

@Service
public class AlbumToSangService extends ServiceImpl<AlbumToSangMapper, AlbumSangsTable> implements IAlbumToSangService{
}
