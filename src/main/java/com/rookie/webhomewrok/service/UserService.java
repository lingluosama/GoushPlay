package com.rookie.webhomewrok.service;

import com.mybatisflex.spring.service.impl.ServiceImpl;
import com.rookie.webhomewrok.entity.UserTable;
import com.rookie.webhomewrok.mapper.UserMapper;

public class UserService extends ServiceImpl<UserMapper, UserTable> implements IUserService {
}
