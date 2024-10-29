package com.rookie.webhomewrok.service;

import com.mybatisflex.spring.service.impl.ServiceImpl;
import com.rookie.webhomewrok.entity.SangsTable;
import com.rookie.webhomewrok.mapper.SangsMapper;
import org.springframework.stereotype.Service;

@Service
public class SangsService extends ServiceImpl<SangsMapper, SangsTable> implements ISangsService{
    
}
