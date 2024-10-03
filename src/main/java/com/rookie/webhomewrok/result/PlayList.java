package com.rookie.webhomewrok.result;

import com.rookie.webhomewrok.entity.SangsTable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.checkerframework.checker.units.qual.A;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PlayList {
    public List<SangsTable> playlist;
}
