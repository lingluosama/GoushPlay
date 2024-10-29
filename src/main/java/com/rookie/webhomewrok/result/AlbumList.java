package com.rookie.webhomewrok.result;

import com.rookie.webhomewrok.entity.AlbumTable;
import lombok.*;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class AlbumList {
    List<AlbumTable> albumlist;

    public List<AlbumTable> getAlbumlist() {
        return albumlist;
    }

    public void setAlbumlist(List<AlbumTable> albumlist) {
        this.albumlist = albumlist;
    }
}
