package com.rookie.webhomewrok.result;

import com.rookie.webhomewrok.entity.AlbumTable;
import com.rookie.webhomewrok.entity.SangsTable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AlbumDetail {
    
    List<SangsTable> sangslist;
    AlbumTable album;

    public List<SangsTable> getSangslist() {
        return sangslist;
    }

    public void setSangslist(List<SangsTable> sangslist) {
        this.sangslist = sangslist;
    }

    public AlbumTable getAlbum() {
        return album;
    }

    public void setAlbum(AlbumTable album) {
        this.album = album;
    }
}
