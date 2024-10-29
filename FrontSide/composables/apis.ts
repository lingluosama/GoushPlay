import {$http} from "~/composables/index.js";

export const UploadSangs=(data:{
    img:any,
    mp3:any,
    title:string,
    author:string

})=>{
    const formData = new FormData();
    formData.append('img', data.img);
    formData.append('mp3', data.mp3);
    formData.append('title', data.title);
    formData.append('author', data.author);
    return $http({
      data:data,
      method:"POST",
      url:"/upload/sangs",
        headers: {
            'Content-Type': 'multipart/form-data'
        },
    })
}
export const GetPlayList=(data:{
    uid:string
})=>{
    return $http({
        params:data,
        method:"GET",
        url:"playlist/get"
    })
}
export const AddToPlayList=(data:{
    uid:string,
    sid:string,
})=>{
    return $http({
        params:data,
        method:"POST",
        url:"playlist/add",
    })
}
export const DeletePlayList=(data:{
    uid:string,
    sid:string,
})=>{
    return $http({
        params:data,
        method:"POST",
        url:"playlist/delete",
    })

}

export const AddToPlayListTop=(data:{
    uid:string,
    sid:string,
})=>{
    return $http({
        params:data,
        method:"POST",
        url:"playlist/addtop",
    })

}
export const AddToPlayListNext=(data:{
    uid:string,
    sid:string,
})=>{
    return $http({
        params:data,
        method:"POST",
        url:"playlist/addtonext",
    })
}
export const SearchSangs=(data:{
    keyword:string,
})=>{
    return $http({
        params:data,
        method:"GET",
        url:"sangs/search",
    })

}
export const SearchAlbum=(data:{
    keyword:string,
})=>{
    return $http({
        params:data,
        method:"GET",
        url:"album/search"

    })

}
export const GetAlbumDetail=(data:{
    aid:string,
})=>{
    return $http({
        params:data,
        method:"GET",
        url:"album/detail",
    })
}
export const CreateAlbum=(data:{
    title:string,
    img:any,
    author:string,
    description:string,
    time:string,
})=>{
    return $http({
        data:data,
        method:"POST",
        url:"album/create",
    })
}
export const AddToAlbum=(data:{
    sid:string,
    aid:string
})=>{
    return $http({
        params:data,
        method:"POST",
        url:"album/add",
    })
}
export const UpdateAlbum=(data:{
    aid:string,
    title:string,
    img:any,
    author:string,
    description:string,
})=>{
    return $http({
        data:data,
        method:"POST",
        url:"album/update",
        headers: {
            'Content-Type': 'multipart/form-data'
        },
    })
}
export const DeleteFormAlbum=(data:{
    aid:string,
    sid:string
})=>{
    return $http({
        params:data,
        method:"POST",
        url:"album/delete"
    })

}

export const UserLogin=(data:{
    password:string,
    username:string
})=>{
    return $http({
        params:data,
        method:"GET",
        url:"user/login",
    })
}
export const UserRegister=(data:{
    username:string,
    password:string,
})=>{
    return $http({
        params:data,
        method:"POST",
        url:"user/register",
    })
}
