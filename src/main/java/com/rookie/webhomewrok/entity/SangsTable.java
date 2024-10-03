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
@Table("sangs")
public class SangsTable {
    @Id(keyType = KeyType.Generator)
    private Integer id;
    private String url;
    private String title;
    private String author;
    private String img;
    
}
