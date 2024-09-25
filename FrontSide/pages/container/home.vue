<script setup lang="ts">
const PageData= reactive({
  PList:["https://ts1.cn.mm.bing.net/th/id/R-C.14f27bec3b0f031dc1fde230dca1665a?rik=lmDGqpct7kWJEA&riu=http%3a%2f%2fwww.wustars.com%2fUploadFiles%2f2023-10%2fcike%2fggvgioozsod.jpg&ehk=pn0nKASTLA8hKdPi1D4txgpCV9xBF8mgJjEBexbvv6Q%3d&risl=&pid=ImgRaw&r=0"
    ,"https://www.rollingstone.com/wp-content/uploads/2010/10/TaylorSwiftSpeakNow.jpg",
    "https://www.billboard.com/wp-content/uploads/2023/02/02-taylor-swift-2023-grammys-red-carpet-billboard-1548.jpg?w=942&h=623&crop=1"
  ],
  Album:[
    {
      name:"THE TORTURED POETS DEPARTMENT: THE ANTHOLOGY",
      author:"Taylor Swift",
      url:"https://storage.highresaudio.com/web/imgcache/b2a5a30f95ddafcf637b7d3e457fc154/64m9kr-thetorture-preview-m3_550x550.jpg",
      
    },
    {
      name:"THE TORTURED POETS DEPARTMENT: THE ANTHOLOGY",
      author:"Taylor Swift",
      url:"https://storage.highresaudio.com/web/imgcache/b2a5a30f95ddafcf637b7d3e457fc154/64m9kr-thetorture-preview-m3_550x550.jpg",

    },
    {
      name:"THE TORTURED POETS DEPARTMENT: THE ANTHOLOGY",
      author:"Taylor Swift",
      url:"https://storage.highresaudio.com/web/imgcache/b2a5a30f95ddafcf637b7d3e457fc154/64m9kr-thetorture-preview-m3_550x550.jpg",

    },
    {
      name:"THE TORTURED POETS DEPARTMENT: THE ANTHOLOGY",
      author:"Taylor Swift",
      url:"https://storage.highresaudio.com/web/imgcache/b2a5a30f95ddafcf637b7d3e457fc154/64m9kr-thetorture-preview-m3_550x550.jpg",

    },
    {
      name:"THE TORTURED POETS DEPARTMENT: THE ANTHOLOGY",
      author:"Taylor Swift",
      url:"https://storage.highresaudio.com/web/imgcache/b2a5a30f95ddafcf637b7d3e457fc154/64m9kr-thetorture-preview-m3_550x550.jpg",

    },
    {
      name:"THE TORTURED POETS DEPARTMENT: THE ANTHOLOGY",
      author:"Taylor Swift",
      url:"https://storage.highresaudio.com/web/imgcache/b2a5a30f95ddafcf637b7d3e457fc154/64m9kr-thetorture-preview-m3_550x550.jpg",

    },
      
  ],
  Search:"",
  Single:[
    {
      url:"https://img.picui.cn/free/2024/09/25/66f4224f569b5.jpg",
      author:"yorushika",
      name:"晴る",
    },
    {
      url:"https://img.picui.cn/free/2024/09/25/66f4224f569b5.jpg",
      author:"yorushika",
      name:"晴る",
    },
    {
      url:"https://img.picui.cn/free/2024/09/25/66f4224f569b5.jpg",
      author:"yorushika",
      name:"晴る",
    },
    {
      url:"https://wallpapercave.com/wp/wp8907816.png",
      author:"yorushika",
      name:"晴る",
    },
    {
      url:"https://img.picui.cn/free/2024/09/25/66f4224f569b5.jpg",
      author:"yorushika",
      name:"晴る",
    },
    {
      url:"https://img.picui.cn/free/2024/09/25/66f4224f569b5.jpg",
      author:"yorushika",
      name:"晴る",
    },
    {
      url:"https://img.picui.cn/free/2024/09/25/66f4224f569b5.jpg",
      author:"yorushika",
      name:"晴る",
    },
    {
      url:"https://wallpapercave.com/wp/wp8907816.png",
      author:"yorushika",
      name:"晴る",
    },
  ]
})

</script>

<template>
  <div class="w-full h-full flex-col flex justify-center items-center">
    <div class="w-full justify-items-start flex flex-row mt-8">
      <mdui-text-field label="Text Field" class="w-1/4 ml-12">
        <mdui-button-icon slot="icon" icon="search"></mdui-button-icon>
      </mdui-text-field>
      <div class="w-full justify-items-center items-center flex flex-row-reverse">
        <p>ICON</p>
      </div>
    </div>

    <div class="w-3/5 mt-24">
      <el-carousel :interval="4000" type="card" height="200px">
        <el-carousel-item v-for=" item in PageData.PList" :key="item">
          <div>
            <img class="h-full w-full bg-auto" :src="item" alt="">
          </div>
        </el-carousel-item>
      </el-carousel>
    </div>
    <el-divider></el-divider>
    <div class="w-full flex">
      <p class="text-xl ml-6 ">推荐专辑</p>
    </div>
    <div class="mt-8 max-w-full items-center justify-items-center ml-10 flex-wrap flex gap-20">
      <div v-for="item in PageData.Album" :key="item.name">
        <album :name="item.name" :author="item.author" :cover="item.url"></album>
      </div>
    </div>
    <div class="w-full flex mt-6">
      <p class="text-xl ml-6 ">定制单曲</p>
    </div>
    <div class="max-w-full  mt-8 flex flex-wrap ml-16  gap-10 flex-row  ">
      <div v-for="(item,index) in PageData.Single " :key="item.name">
        <single :name="item.name" :author="item.author" :url="item.url" :class=" {'ml-80':index%3!=0,'ml-10':index%3==0}"></single>
      </div>
    </div>
  </div>
</template>

<style scoped>

</style>
