<script setup lang="js">


import {genFileId} from "element-plus";

const route = useRoute();
const uploadref=ref(null)
const fileBinaryList = ref([]);
const AuthorRef=ref(null)
const TitleRef=ref(null)
const DesRef=ref(null)
const PageData=reactive({
  aid:"",
  title:"",
  description:"",
  author:"",
  img:null,
  ImgUrl:"",
  sangs:[],
  ImgUploadData:[],
  SangsPtr:-1,
  SangsSearch:[],
  Dialog:false,
  keyword:"",
})

onMounted(async ()=>{
  PageData.aid=route.query.aid
  if(PageData.aid!==null||PageData.aid!==-1){
    const detail = await GetAlbumDetail({aid:PageData.aid});
    PageData.sangs=detail.data.sangslist
    PageData.description=detail.data.album.description
    PageData.author=detail.data.album.author
    PageData.title=detail.data.album.title
    PageData.ImgUrl=detail.data.album.cover

    AuthorRef.value=detail.data.album.author
    TitleRef.value=detail.data.album.title
    DesRef.value=detail.data.album.description
  }

})
const handleExceed = (files) => {
  uploadref.value.clearFiles();
  const file = files[0];
  file.uid = genFileId();
  uploadref.value.handleStart(file);
};
const test=()=>{
  console.log(PageData.ImgUploadData[0])
}
const handleChange = (file, files) => {
  PageData.ImgUploadData=files;
};
const goAlbumDetail=()=>{
  navigateTo({path:"/container/album",query:{aid:PageData.aid}});
}
const updateAlbum=async ()=>{
  const formData = new FormData();
  formData.append('aid', PageData.aid);
  formData.append('title', PageData.title);
  formData.append('description', PageData.description);
  formData.append('author', PageData.author);

  formData.append('img', PageData.ImgUploadData[0].raw);

  await UpdateAlbum(formData)

}

const InSearch=async ()=>{
  const res = await SearchSangs({keyword:PageData.keyword});
  PageData.SangsSearch=res.data.playlist;
}

const addToAlbum=async (sid)=>{
  const res = await AddToAlbum({aid:PageData.aid,sid:sid});
  if(res.success){
      ElMessage.success("添加成功")
  }
}
const deleteFromAlbum = async (sid) => {
  const res = await DeleteFormAlbum({ aid: PageData.aid, sid: sid });
  if (res.success) {
    PageData.sangs = PageData.sangs.filter(item => item.id !== sid);
  }
};


</script>

<template>
<div class="min-h-screen flex flex-col items-center w-full">
   <div class="fixed top-0 left-0 w-full h-screen bg-black bg-opacity-50 z-20 flex flex-col items-center"
        v-if="PageData.Dialog"
        @click="PageData.Dialog=false">
   >
     <div class="w-full items-center h-3/4 flex justify-center">
       <div
           class="w-5/12  bg-white rounded-2xl dark:bg-gray-800 items-center flex flex-col"
           @click.stop>
         <div class="w-full h-3 flex flex-row-reverse ">
           <mdui-icon  slot="icon" name="close" class="m-3" @click="PageData.Dialog=false" ></mdui-icon>
         </div>
         <div class=" w-5/6 flex flex-col space-y-8">
           <mdui-text-field class="w-1/2  mt-8" label="搜索歌曲" @keydown.enter="InSearch()" @input="PageData.keyword=$event.target.value"></mdui-text-field>
           <mdui-divider></mdui-divider>
           <mdui-list class="max-h-72 overflow-auto">
             <mdui-list-subheader>
               共找到了{{PageData.SangsSearch.length}}首歌曲
             </mdui-list-subheader>
             <div v-for="(item,index) in PageData.SangsSearch">
                <mdui-list-item slot="custom" nonclickable>
                  <div class="flex flex-row justify-between">
                    <div class="w-1/3">{{item.title}}</div>
                    <div class="w-1/4">{{item.author}}</div>
                    <mdui-icon v-if="PageData.sangs.find(sang=>sang.id===item.id)" slot="icon" name="check"></mdui-icon>
                    <mdui-icon  @click="addToAlbum(item.id)"   class="cursor-pointer" v-else slot="icon" name="add"></mdui-icon>
                  </div>
                </mdui-list-item>
             </div>
           </mdui-list>
         </div>
       </div>
     </div>
   </div>
  <div class="w-2/3 flex-col h-auto mt-12 space-y-8">
    <div v-if="PageData.aid!=='-1'">歌单id:{{PageData.aid}}</div>
    <div v-else>创建歌单</div>
    <el-divider></el-divider>
    <div class="flex w-full justify-between">
      <img v-if="PageData.ImgUrl" @click="goAlbumDetail" :src="PageData.ImgUrl" alt="img" class="w-52 h-52 object-cover rounded-2xl">
      <el-upload
           ref="uploadref"
          :limit="1"
          :on-exceed="handleExceed"
          class="upload-demo"
          :auto-upload="false"
           :on-change="handleChange"
          drag
          multiple
      >
        <div class="el-upload__text" style="height: 100px; width: 12rem">
          Drop file here or <em>click to upload</em>
          <p>limit one,new file will cover old file </p>
        </div>
      </el-upload>
    </div>
    <div class="w-full flex  space-x-16  flex-row">
      <div class="flex flex-col space-y-10">
        <div>Author:</div>
        <div>Title:</div>
        <div>Description:</div>
      </div>
      <div class="flex flex-col space-y-8 w-1/2">
        <el-input v-model="PageData.author"></el-input>
        <el-input v-model="PageData.title"></el-input>
        <el-input type="textarea" autosize v-model="PageData.description"></el-input>
      </div>
      <div class="flex flex-col-reverse">
        <mdui-button @click="updateAlbum()">保存</mdui-button>
      </div>
    </div>
    <el-divider></el-divider>
    <mdui-list>
      <mdui-list-item v-if="PageData.sangs.length===0" @click="PageData.Dialog=true">
        <mdui-icon  slot="icon" name="add"></mdui-icon>
        Add New Sang
      </mdui-list-item>
      <div v-for="(item,index) in PageData.sangs">
        <mdui-list-item slot="custom" @mouseover="PageData.SangsPtr=index" @mouseleave="PageData.SangsPtr=-1">
          <div class="justify-between items-center flex flex-row w-full">
            <img class=" w-16 h-16 object-cover rounded-2xl" :src="item.img" alt="img">
            <div class="w-1/3">{{item.title}}</div>
            <div class="w-1/6">{{item.author}}</div>
            <mdui-icon  @click="deleteFromAlbum(item.id)" class="absolute right-8" v-if="PageData.SangsPtr===index" slot="icon" name="delete"></mdui-icon>
          </div>
        </mdui-list-item>
        <mdui-list-item v-if="index===PageData.sangs.length-1" @click="PageData.Dialog=true">
          <mdui-icon  slot="icon" name="add"></mdui-icon>
          Add New Sang
        </mdui-list-item>
      </div>
    </mdui-list>
  </div>
</div>
</template>

<style scoped>

</style>
