<script setup lang="js">
import { ref, reactive, onMounted } from 'vue';
import { getColorFromImage } from "mdui";

const img = ref(null);
const route = useRoute();
const { $mitt } = useNuxtApp();
const PageData = reactive({
  aid: "1",
  sangs: null,
  cover: "",
  title: "",
  description: "",
  author: "",
  color: '#fff',
  currentHover:-1,
  currentMenu:-1,
});

onMounted(async () => {
  PageData.aid = route.query.aid;
  const res = await GetAlbumDetail({ aid: PageData.aid });
  PageData.sangs = res.data.sangslist;
  PageData.cover = res.data.album.cover;
  PageData.title = res.data.album.title;
  PageData.description = res.data.album.description;
  PageData.author = res.data.album.author;

  img.value.addEventListener('load', async () => {
    PageData.color = await getColorFromImage(img.value);
  });

});

const ChSang=(index)=>{
  $mitt.emit('rep',PageData.sangs[index])
  AddToPlayListTop({uid:"1",sid:PageData.sangs[index].id})
}
const addToPlayList= (index)=>{
  ElMessage.success("已添加到播放队列")
  $mitt.emit('add',PageData.sangs[index])
  AddToPlayList({uid:"1",sid:PageData.Single[index].id})
}
const moveToTop=  (index)=>{
  ElMessage.success("已添加到下一首播放")
  $mitt.emit('top',PageData.sangs[index])
  AddToPlayListNext({uid:"1",sid:PageData.sangs[index].id})
}
</script>

<template>
  <div class="w-full h-full min-h-screen space-y-8 flex flex-col m-5 rounded-2xl"
       :style="{ background: `linear-gradient(to bottom, ${PageData.color}, rgba(255, 255, 255, 0))` }">
    <div class="w-full flex h-64 space-x-8 flex-row mt-12">
      <img
          ref="img"
          class="object-cover w-64 ml-8 rounded-2xl shadow-2xl"
          :src="PageData.cover"
          alt=""
          crossorigin="anonymous"
      />
      <div class="flex flex-col-reverse h-full">
        <div class="italic">{{ PageData.author }}, {{ PageData.sangs?.length }} 首歌曲</div>
        <div class="text-5xl font-bold">{{ PageData.title }}</div>
        <div class="text-xl">专辑</div>
      </div>
    </div>
    <div v-for="(item, index) in PageData.sangs" :key="index" class="pl-8 pr-8 flex w-full flex-col">
      <div v-if="index === 0" >
        <div class="flex flex-row items-center">
          <div class="w-12 ml-5">#</div>
          <div class="w-1/2">标题</div>
          <div class="w-1/3">播放量</div>
          <div>时长</div>
        </div>
        <el-divider></el-divider>
      </div>
      <div class="flex flex-row items-center hover:bg-white hover:bg-opacity-25 hover:rounded-xl hover:outline-8 outline-white" @mouseover="PageData.currentHover=index" @mouseleave="PageData.currentHover=-1" @dblclick="ChSang(index)">
        <div  class="w-12 ml-5">
          <div v-if="PageData.currentHover!==index">{{index+1}}</div>
          <div v-else-if="PageData.currentHover===index">
            <svg t="1729217656171" v-if="useState('dark').value" class="icon" viewBox="0 0 1024 1024" version="1.1" xmlns="http://www.w3.org/2000/svg" p-id="5590" width="16" height="16"><path d="M900.571429 529.700571L141.714286 951.405714c-17.700571 9.728-32 1.133714-32-18.870857v-841.142857c0-20.004571 14.299429-28.562286 32-18.870857l758.857143 421.705143c17.700571 9.728 17.700571 25.709714 0 35.437714z" fill="#ffffff" p-id="5591"></path></svg>
            <svg t="1729219838541" v-else-if="!useState('dark').value" class="icon" viewBox="0 0 1024 1024" version="1.1" xmlns="http://www.w3.org/2000/svg" p-id="5926" width="16" height="16"><path d="M900.571429 529.700571L141.714286 951.405714c-17.700571 9.728-32 1.133714-32-18.870857v-841.142857c0-20.004571 14.299429-28.562286 32-18.870857l758.857143 421.705143c17.700571 9.728 17.700571 25.709714 0 35.437714z" fill="" p-id="5927"></path></svg>
          </div>
        </div>
        <div class="flex flex-col w-1/2">
          <div class="text-xl font-semibold">{{ item.title }}</div>
          <div class="text-sm">{{ item.author }}</div>
        </div>
        <div class="w-1/3">114514</div>
        <div>3:14</div>
        <div class="absolute right-16 flex flex-col">
          <svg @click="PageData.currentMenu=index" v-if="!useState('dark').value" t="1729480029117" class="icon" viewBox="0 0 1024 1024" version="1.1" xmlns="http://www.w3.org/2000/svg" p-id="5145" width="32" height="32"><path d="M224 512m-80 0a80 80 0 1 0 160 0 80 80 0 1 0-160 0Z" fill="#000000" p-id="5146"></path><path d="M512 512m-80 0a80 80 0 1 0 160 0 80 80 0 1 0-160 0Z" fill="#000000" p-id="5147"></path><path d="M800 512m-80 0a80 80 0 1 0 160 0 80 80 0 1 0-160 0Z" fill="#000000" p-id="5148"></path></svg>
          <svg @click="PageData.currentMenu=index" v-if="useState('dark').value" t="1729480029117" class="icon" viewBox="0 0 1024 1024" version="1.1" xmlns="http://www.w3.org/2000/svg" p-id="5145" width="32" height="32"><path d="M224 512m-80 0a80 80 0 1 0 160 0 80 80 0 1 0-160 0Z" fill="#ffffff" p-id="5146"></path><path d="M512 512m-80 0a80 80 0 1 0 160 0 80 80 0 1 0-160 0Z" fill="#ffffff" p-id="5147"></path><path d="M800 512m-80 0a80 80 0 1 0 160 0 80 80 0 1 0-160 0Z" fill="#ffffff" p-id="5148"></path></svg>
        </div>
        <mdui-card v-if="PageData.currentMenu===index" class="w-32 right-12 bottom-0" @mouseleave="PageData.currentMenu=-1">
          <div @click="moveToTop(index)" class="flex flex-row hover:bg-white hover:bg-opacity-35">
            <svg v-if="!useState('dark').value" t="1729482061938" class="icon" viewBox="0 0 1024 1024" version="1.1" xmlns="http://www.w3.org/2000/svg" p-id="6555" width="24" height="24"><path d="M869.888 474.112h-324.096V150.016a34.304 34.304 0 0 0-68.608 0v324.096H154.112a34.304 34.304 0 0 0 0 68.608h324.096v324.096a34.304 34.304 0 0 0 68.608 0V542.72h324.096c18.944 0 34.304-15.36 34.304-34.304-1.024-18.944-16.384-34.304-35.328-34.304z" p-id="6556"></path></svg>
            <svg v-if="useState('dark').value" t="1729481313321" class="icon" viewBox="0 0 1024 1024" version="1.1" xmlns="http://www.w3.org/2000/svg" p-id="6217" width="24" height="24"><path d="M544.256 480.256h307.2a32.256 32.256 0 0 1 0 64h-307.2v307.2a32.256 32.256 0 0 1-64 0v-307.2h-307.2a32.256 32.256 0 1 1 0-64h307.2v-307.2a32.256 32.256 0 1 1 64 0z" fill="#ffffff" p-id="6218"></path></svg>
            <div>添加到下一首</div>
          </div>
          <div @click="addToPlayList" class="flex flex-row hover:bg-white hover:bg-opacity-35">
            <svg v-if="!useState('dark').value" t="1729482166901" class="icon" viewBox="0 0 1024 1024" version="1.1" xmlns="http://www.w3.org/2000/svg" p-id="7654" width="24" height="24"><path d="M938.8 555.5c-12.8-27.7-30.4-52.7-51.7-73.9-2.4-2.2-4.8-4.4-7.1-6.8-15.5-16-26.8-35.9-32.1-58.1-0.9-3.3-1.5-6.6-2-10-1.6-9.6-2.1-19.7-1.3-29.8 1.7-22.4 9.2-43 20.8-60.4-47.7 6.3-87.8 39.3-103.2 84.6-1.1 3.4-2.2 6.9-3 10.5l-22.2 290c-6.4-2.6-12.9-4.9-19.8-6.7-11.7-3.3-24.1-5.7-37-7.1-14.9-1.6-30.5-1.7-46.6-0.1-34.1 3.2-65.2 13.3-90.8 27.9-28.9 16.5-50.7 39-61.9 64.4-6.5 14.8-9.5 30.5-7.9 46.5 6.3 67.7 88.6 115.3 183.6 106.4 23.3-2.2 45.3-7.6 65-15.5 26.6-10.7 49.1-25.9 65.7-43.9 14.6-15.8 24.5-33.9 28.3-52.9 0.7-3.6 1.2-7.4 1.6-11.1 0.2 0 22-282.3 22-282.3 2.3 0.1 4.8 0.1 7.1 0.3 30.1 2.3 57 14.9 77.4 34.3 16.4 15.5 28.5 35.3 34.8 57.5-3.6-22.3-10.3-43.7-19.7-63.8z m-99.5-28.3zM105 169h798.2c22.1 0 40-17.9 40-40s-17.9-40-40-40H105c-22.1 0-40 17.9-40 40s17.9 40 40 40z" p-id="7655"></path><path d="M105 551.8h568.2c22.1 0 40-17.9 40-40s-17.9-40-40-40H105c-22.1 0-40 17.9-40 40s17.9 40 40 40zM417.2 854.6H105c-22.1 0-40 17.9-40 40s17.9 40 40 40h312.2c22.1 0 40-17.9 40-40s-17.9-40-40-40z" p-id="7656"></path></svg>
            <svg v-if="useState('dark').value" t="1729482166901" class="icon" viewBox="0 0 1024 1024" version="1.1" xmlns="http://www.w3.org/2000/svg" p-id="7654" width="24" height="24"><path d="M938.8 555.5c-12.8-27.7-30.4-52.7-51.7-73.9-2.4-2.2-4.8-4.4-7.1-6.8-15.5-16-26.8-35.9-32.1-58.1-0.9-3.3-1.5-6.6-2-10-1.6-9.6-2.1-19.7-1.3-29.8 1.7-22.4 9.2-43 20.8-60.4-47.7 6.3-87.8 39.3-103.2 84.6-1.1 3.4-2.2 6.9-3 10.5l-22.2 290c-6.4-2.6-12.9-4.9-19.8-6.7-11.7-3.3-24.1-5.7-37-7.1-14.9-1.6-30.5-1.7-46.6-0.1-34.1 3.2-65.2 13.3-90.8 27.9-28.9 16.5-50.7 39-61.9 64.4-6.5 14.8-9.5 30.5-7.9 46.5 6.3 67.7 88.6 115.3 183.6 106.4 23.3-2.2 45.3-7.6 65-15.5 26.6-10.7 49.1-25.9 65.7-43.9 14.6-15.8 24.5-33.9 28.3-52.9 0.7-3.6 1.2-7.4 1.6-11.1 0.2 0 22-282.3 22-282.3 2.3 0.1 4.8 0.1 7.1 0.3 30.1 2.3 57 14.9 77.4 34.3 16.4 15.5 28.5 35.3 34.8 57.5-3.6-22.3-10.3-43.7-19.7-63.8z m-99.5-28.3zM105 169h798.2c22.1 0 40-17.9 40-40s-17.9-40-40-40H105c-22.1 0-40 17.9-40 40s17.9 40 40 40z" p-id="7655" fill="#ffffff"></path><path d="M105 551.8h568.2c22.1 0 40-17.9 40-40s-17.9-40-40-40H105c-22.1 0-40 17.9-40 40s17.9 40 40 40zM417.2 854.6H105c-22.1 0-40 17.9-40 40s17.9 40 40 40h312.2c22.1 0 40-17.9 40-40s-17.9-40-40-40z" p-id="7656" fill="#ffffff"></path></svg>
            <div>添加到队列</div>
          </div>
        </mdui-card>
      </div>
    </div>

  </div>
</template>

<style scoped>
</style>
