<script setup lang="js">
import {SearchSangs} from "~/composables/apis";
import {navigateTo} from "#app/composables/router.js";
const { $mitt } = useNuxtApp();
const router = useRouter();
const PageData= reactive({
  PList:["https://ts1.cn.mm.bing.net/th/id/R-C.14f27bec3b0f031dc1fde230dca1665a?rik=lmDGqpct7kWJEA&riu=http%3a%2f%2fwww.wustars.com%2fUploadFiles%2f2023-10%2fcike%2fggvgioozsod.jpg&ehk=pn0nKASTLA8hKdPi1D4txgpCV9xBF8mgJjEBexbvv6Q%3d&risl=&pid=ImgRaw&r=0"
    ,"https://www.rollingstone.com/wp-content/uploads/2010/10/TaylorSwiftSpeakNow.jpg",
    "https://www.billboard.com/wp-content/uploads/2023/02/02-taylor-swift-2023-grammys-red-carpet-billboard-1548.jpg?w=942&h=623&crop=1"
  ],
  Album:[],
  Search:"",
  Single:[],
  isSearch:false,
  keyword:"",
  choose:-1,
})
onMounted(async ()=>{
  let res= await SearchSangs({keyword:""})
  PageData.Single=res.data.playlist;
  res=await SearchAlbum({keyword:""})
  PageData.Album=res.data.albumlist;
})
const InSearch= async ()=>{
  PageData.isSearch=true;
  const res= await SearchSangs({keyword:PageData.keyword})
  PageData.Single=res.data.playlist;
}
const addToPlayList= (index)=>{
  ElMessage.success("已添加到播放队列")
   $mitt.emit('add',PageData.Single[index])
  AddToPlayList({uid:"1",sid:PageData.Single[index].id})
}
const moveToTop=  (index)=>{
  ElMessage.success("已添加到下一首播放")
  $mitt.emit('top',PageData.Single[index])
  AddToPlayListNext({uid:"1",sid:PageData.Single[index].id})
}
const replacePlayList= (index)=>{

  $mitt.emit('rep',PageData.Single[index])
  AddToPlayListTop({uid:"1",sid:PageData.Single[index].id})

}
const GoAlbumPage=(index)=>{
  navigateTo({path:"/container/album",query:{aid:PageData.Album[index].id}})
}


</script>

<template>

  <div class="w-full h-full flex-col flex justify-center items-center">
    <div class="w-full justify-items-start flex flex-row mt-8">
      <mdui-text-field label="Search Sangs" class="w-1/4 ml-12" @input="PageData.keyword=$event.target.value" @keydown.enter="InSearch()">
        <mdui-button-icon slot="icon" icon="search"></mdui-button-icon>
      </mdui-text-field>
      <div class="w-full justify-items-center items-center flex flex-row-reverse">
        <p>ICON</p>
      </div>
    </div>

    <div class="w-3/5 mt-24" v-if="!PageData.isSearch">
      <el-carousel :interval="4000" type="card" height="200px">
        <el-carousel-item v-for=" item in PageData.PList" :key="item">
          <div>
            <img class="h-full w-full bg-auto" :src="item" alt="">
          </div>
        </el-carousel-item>
      </el-carousel>
    </div>
    <div class="mt-8 flex flex-col space-y-12 w-1/3" v-if="PageData.isSearch">
      <div v-for="(item,index) in PageData.Single " :key="item.id">
        <div class="hover:scale-125 rounded-2xl   flex flex-row w-full justify-items-center h-full items-center" @mouseover="PageData.choose=index" @mouseleave="PageData.choose=-1">
          <single :name="item.title" :author="item.author" :url="item.img" class=""></single>
          <div class="flex flex-row space-x-5 justify-self-end items-end ml-24" v-if="PageData.choose===index">

            <svg t="1729492888681" v-if="useState('dark').value" @click="replacePlayList(index)" class="icon" viewBox="0 0 1024 1024" version="1.1" xmlns="http://www.w3.org/2000/svg" p-id="4137" width="32" height="32"><path d="M128 138.666667c0-47.232 33.322667-66.666667 74.176-43.562667l663.146667 374.954667c40.96 23.168 40.853333 60.8 0 83.882666L202.176 928.896C161.216 952.064 128 932.565333 128 885.333333v-746.666666z" fill="#ffffff" p-id="4138"></path></svg>
            <svg t="1728444414075" v-if="!useState('dark').value"  @click="replacePlayList(index)" class="icon" viewBox="0 0 1024 1024" version="1.1" xmlns="http://www.w3.org/2000/svg" p-id="6268" width="32" height="32"><path d="M772.7 217.7a32.2 32.1 0 1 0 64.4 0 32.2 32.1 0 1 0-64.4 0Z" fill="#4D4D4D" p-id="6269"></path><path d="M415.8 679.9c5.9 0 11.5-1.6 16.2-4.5l231.1-134.6c10.9-5.2 18.5-16.3 18.5-29.2 0-11.9-6.4-22.3-16-27.8L439.7 352.2c-5.8-6.7-14.4-10.9-23.9-10.9-17.6 0-31.8 14.4-31.8 32.1 0 0.6 0 1.2 0.1 1.8l-0.4 0.2 0.5 269c-0.1 1.1-0.2 2.2-0.2 3.4 0 17.7 14.3 32.1 31.8 32.1z" fill="#4D4D4D" p-id="6270"></path><path d="M909.8 306.6c-5.4-10.5-16.3-17.8-28.9-17.8-17.8 0-32.2 14.4-32.2 32.1 0 6 1.7 11.7 4.6 16.5l-0.1 0.1c26.9 52.4 42.1 111.8 42.1 174.7 0 211.6-171.6 383.2-383.2 383.2S128.8 723.8 128.8 512.2 300.4 129.1 512 129.1c62.5 0 121.5 15 173.6 41.5l0.2-0.4c4.6 2.6 10 4.1 15.7 4.1 17.8 0 32.2-14.4 32.2-32.1 0-13.1-7.9-24.4-19.3-29.4C653.6 81.9 584.9 64.5 512 64.5 264.7 64.5 64.3 265 64.3 512.2S264.7 959.9 512 959.9s447.7-200.4 447.7-447.7c0-74.1-18-144-49.9-205.6z" fill="#4D4D4D" p-id="6271"></path></svg>

            <svg t="1729493293380" @click="moveToTop(index)" v-if="useState('dark').value" class="icon" viewBox="0 0 1024 1024" version="1.1" xmlns="http://www.w3.org/2000/svg" p-id="7341" width="32" height="32"><path d="M512.302 444.497L158.75 798.051c-13.669 13.668-35.83 13.668-49.498 0s-13.668-35.83 0-49.498l363.551-363.55c21.815-21.816 57.185-21.816 79 0l363.551 363.55c13.668 13.669 13.668 35.83 0 49.498s-35.83 13.668-49.497 0L512.302 444.497zM123 318.045c-16.569 0-30-13.432-30-30 0-16.569 13.431-30 30-30h778c16.569 0 30 13.431 30 30 0 16.568-13.431 30-30 30H123z" fill="#ffffff" p-id="7342"></path></svg>
            <svg t="1729493293380" @click="moveToTop(index)" v-if="!useState('dark').value" class="icon" viewBox="0 0 1024 1024" version="1.1" xmlns="http://www.w3.org/2000/svg" p-id="7341" width="32" height="32"><path d="M512.302 444.497L158.75 798.051c-13.669 13.668-35.83 13.668-49.498 0s-13.668-35.83 0-49.498l363.551-363.55c21.815-21.816 57.185-21.816 79 0l363.551 363.55c13.668 13.669 13.668 35.83 0 49.498s-35.83 13.668-49.497 0L512.302 444.497zM123 318.045c-16.569 0-30-13.432-30-30 0-16.569 13.431-30 30-30h778c16.569 0 30 13.431 30 30 0 16.568-13.431 30-30 30H123z" fill="#2c2c2c" p-id="7342"></path></svg>

            <svg t="1729493130062" v-if="useState('dark').value"  class="icon" viewBox="0 0 1024 1024" version="1.1" xmlns="http://www.w3.org/2000/svg" p-id="5397" width="32" height="32"><path d="M544.256 480.256h307.2a32.256 32.256 0 0 1 0 64h-307.2v307.2a32.256 32.256 0 0 1-64 0v-307.2h-307.2a32.256 32.256 0 1 1 0-64h307.2v-307.2a32.256 32.256 0 1 1 64 0z" fill="#ffffff" p-id="5398"></path></svg>
            <svg t="1728443834042" v-if="!useState('dark').value" @click="addToPlayList(index)" class="icon" viewBox="0 0 1024 1024" version="1.1" xmlns="http://www.w3.org/2000/svg" p-id="5228" width="32" height="32"><path d="M512 73.142857c241.371429 0 438.857143 197.485714 438.857143 438.857143s-197.485714 438.857143-438.857143 438.857143-438.857143-197.485714-438.857143-438.857143 197.485714-438.857143 438.857143-438.857143m0-73.142857C226.742857 0 0 226.742857 0 512s226.742857 512 512 512 512-226.742857 512-512-226.742857-512-512-512z" p-id="5229"></path><path d="M512 219.428571c-21.942857 0-36.571429 14.628571-36.571429 36.571429v512c0 21.942857 14.628571 36.571429 36.571429 36.571429s36.571429-14.628571 36.571429-36.571429v-512c0-21.942857-14.628571-36.571429-36.571429-36.571429z" p-id="5230"></path><path d="M768 475.428571h-512c-21.942857 0-36.571429 14.628571-36.571429 36.571429s14.628571 36.571429 36.571429 36.571429h512c21.942857 0 36.571429-14.628571 36.571429-36.571429s-14.628571-36.571429-36.571429-36.571429z" p-id="5231"></path></svg>
          </div>
        </div>

      </div>
    </div>
    <el-divider></el-divider>
    <div class="w-full flex">
      <p class="text-xl ml-6 ">推荐专辑</p>
    </div>
    <div class="mt-8 max-w-full items-center justify-items-center ml-10 flex-wrap flex gap-20">
      <div v-for="(item,index) in PageData.Album" :key="item.name">
        <album @click="GoAlbumPage(index)" :name="item.title" :author="item.author" :cover="item.cover"></album>
      </div>
    </div>
    <div class="w-full flex mt-6" v-if="!PageData.isSearch">
      <p class="text-xl ml-6 ">定制单曲</p>
    </div>
    <div class="max-w-full  mt-8 flex flex-wrap ml-16  gap-10 flex-row" v-if="!PageData.isSearch">
      <div v-for="(item,index) in PageData.Single " :key="item.id">
        <single :name="item.title" :author="item.author" :url="item.img" :class=" {'ml-80':index%3!=0,'ml-10':index%3==0}"></single>
      </div>
    </div>
  </div>
</template>

<style scoped>

</style>
