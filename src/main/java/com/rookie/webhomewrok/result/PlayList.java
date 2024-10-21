package com.rookie.webhomewrok.result;

import com.rookie.webhomewrok.entity.SangsTable;
import lombok.*;
import org.checkerframework.checker.units.qual.A;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class PlayList {
    public List<SangsTable> playlist;

    public List<SangsTable> getPlaylist() {
        return playlist;
    }

    public void setPlaylist(List<SangsTable> playlist) {
        this.playlist = playlist;
    }
}
