<script setup lang="js">

const PageData=reactive({
  Card:[
    {
      Name:"歌曲管理",
      Path:"",
      url:"https://is1-ssl.mzstatic.com/image/thumb/Music221/v4/4f/b3/fb/4fb3fb99-7c8b-f028-8683-6128f3e20caf/198588375464.jpg/1200x1200bb.webp",
    },
    {
      Name:"专辑管理",
      Path:"/container/chAlbum",
      url:"https://tse4-mm.cn.bing.net/th/id/OIP-C.nL9E8nXTzyENjPHEd83YLwHaHa?rs=1&pid=ImgDetMain",
    },
    {
      Name:"用户管理",
      Path:"",
      url:"https://tse1-mm.cn.bing.net/th/id/OIP-C.y538ME56rhu28IigG0P2XQHaHa?rs=1&pid=ImgDetMain",
    }
  ]


})


</script>

<template>
<div class="w-full min-h-screen flex flex-col" >
  <div class="text-5xl italic m-12">Welcome! Admin</div>
  <div class=" w-full h-auto flex flex-row ">
    <div v-for="(item,index) in PageData.Card" class="w-full justify-between flex flex-row ">
    <mdui-card @click="navigateTo({path:item.Path})" class="w-52 ml-32 h-52 flex flex-col items-center  justify-items-center" clickable >
      <img :src="item.url" alt="img" class="w-32 h-32 rounded-xl mt-4">
      <div class="mt-4">{{item.Name}}</div>
    </mdui-card>
    </div>
  </div>
</div>
</template>

<style scoped>

</style>
