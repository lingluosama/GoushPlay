package com.rookie.webhomewrok.service;

import com.mybatisflex.spring.service.impl.ServiceImpl;
import com.rookie.webhomewrok.entity.UserTable;
import com.rookie.webhomewrok.mapper.UserMapper;
import org.springframework.stereotype.Service;

@Service
public class UserService extends ServiceImpl<UserMapper, UserTable> implements IUserService {
}
