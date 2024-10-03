package com.rookie.webhomewrok.entity;

import com.mybatisflex.annotation.Id;
import com.mybatisflex.annotation.KeyType;
import com.mybatisflex.annotation.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table("user")
public class UserTable {
    @Id(keyType = KeyType.Generator)
    private Integer id;
    private String icon;
    private String name;
    private String password;
}
