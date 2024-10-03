<script setup lang="js">
import {ref} from "vue";

const props=defineProps({
  url:String,
  img:String,
  name:String,
  author:String,
  album:String,
  isPaused:Boolean,
})
const queue=ref([
    {
    author:"hello",
    url:"http://downsc.chinaz.net/Files/DownLoad/sound1/201906/11582.mp3",
    name:"test1",
    img:"https://ts1.cn.mm.bing.net/th/id/R-C.3a1b98d8aa749503cc2ff9c224bc8b40?rik=xxNkH0iChSUYqg&riu=http%3a%2f%2fd.ifengimg.com%2fq100%2fimg1.ugc.ifeng.com%2fnewugc%2f20190119%2f10%2fwemedia%2fabbab6554fa54232bec645b46e6e7bb3f0e4cc5b_size2326_w3000_h2000.JPG&ehk=UzIcp%2fHqCMHntTpDKBDEvAT%2bhhu8xR805ZL0enQCZ%2fY%3d&risl=1&pid=ImgRaw&r=0'",
    is_paused:true,
    album:"null" ,
  },
  {
    author:"hello",
    url:"http://downsc.chinaz.net/Files/DownLoad/sound1/201906/11582.mp3",
    name:"test1",
    img:"https://ts1.cn.mm.bing.net/th/id/R-C.3a1b98d8aa749503cc2ff9c224bc8b40?rik=xxNkH0iChSUYqg&riu=http%3a%2f%2fd.ifengimg.com%2fq100%2fimg1.ugc.ifeng.com%2fnewugc%2f20190119%2f10%2fwemedia%2fabbab6554fa54232bec645b46e6e7bb3f0e4cc5b_size2326_w3000_h2000.JPG&ehk=UzIcp%2fHqCMHntTpDKBDEvAT%2bhhu8xR805ZL0enQCZ%2fY%3d&risl=1&pid=ImgRaw&r=0'",
    is_paused:true,
    album:"null" ,
  },
  {
    author:"hello",
    url:"http://downsc.chinaz.net/Files/DownLoad/sound1/201906/11582.mp3",
    name:"test1",
    img:"https://ts1.cn.mm.bing.net/th/id/R-C.3a1b98d8aa749503cc2ff9c224bc8b40?rik=xxNkH0iChSUYqg&riu=http%3a%2f%2fd.ifengimg.com%2fq100%2fimg1.ugc.ifeng.com%2fnewugc%2f20190119%2f10%2fwemedia%2fabbab6554fa54232bec645b46e6e7bb3f0e4cc5b_size2326_w3000_h2000.JPG&ehk=UzIcp%2fHqCMHntTpDKBDEvAT%2bhhu8xR805ZL0enQCZ%2fY%3d&risl=1&pid=ImgRaw&r=0'",
    is_paused:true,
    album:"null" ,
  },
  {
    author:"hello",
    url:"http://downsc.chinaz.net/Files/DownLoad/sound1/201906/11582.mp3",
    name:"test1",
    img:"https://ts1.cn.mm.bing.net/th/id/R-C.3a1b98d8aa749503cc2ff9c224bc8b40?rik=xxNkH0iChSUYqg&riu=http%3a%2f%2fd.ifengimg.com%2fq100%2fimg1.ugc.ifeng.com%2fnewugc%2f20190119%2f10%2fwemedia%2fabbab6554fa54232bec645b46e6e7bb3f0e4cc5b_size2326_w3000_h2000.JPG&ehk=UzIcp%2fHqCMHntTpDKBDEvAT%2bhhu8xR805ZL0enQCZ%2fY%3d&risl=1&pid=ImgRaw&r=0'",
    is_paused:true,
    album:"null" ,
  },

])
const isPlay=ref(true)
const audioRef=ref(false)
const audioStart=ref("0:00")
const totalTime=ref("0:00")
const fileTime=ref(0)
const Volume=ref(80)
const currentProgress = ref(0.0);
onMounted( async ()=>{
  isPlay.value=props.isPaused;
  calculateDuration();
  const slider = await document.querySelector(".jindutiao");
  slider.labelFormatter = (value) => `${transTime(value)}`;
})
const changePlay=()=>{
  isPlay.value=!isPlay.value;
  if(isPlay.value){
    audioRef.value.pause();
  }else{
     audioRef.value.play();
  }
}
const calculateDuration=()=>{
  var myVid=audioRef.value;
  myVid.loop=true;
  myVid.src=props.url;
  myVid.addEventListener(
      "ended",
      function (){
        isPlay.value=false;
        currentProgress.value=0;
      },
      false
  );
  if(myVid !=null){
    myVid.oncanplay = function () {
      fileTime.value=myVid.duration;
      totalTime.value=transTime(myVid.duration);
    };
    myVid.volume = 0.8;
    if(isPlay.value)audioRef.value.play();
    else audioRef.value.pause();
  }
}
function transTime(duration) {
  const minutes = Math.floor(duration / 60);
  const seconds = Math.floor(duration % 60);
  const formattedMinutes = String(minutes).padStart(2, "0"); 
  const formattedSeconds = String(seconds).padStart(2, "0");
  return `${formattedMinutes}:${formattedSeconds}`;
}
const handleProgress=(val)=>{
  console.log(val);
  audioRef.value.currentTime=val
  
}

const updateProgress=(e)=>{
  if(audioRef.value.play){
    currentProgress.value=e.target.currentTime;
    audioStart.value=transTime(audioRef.value.currentTime);
  }
  console.log(audioRef.value.currentTime);
  
}
const handleAudioVolume=(val )=>{
  audioRef.value.volume=val/100;
}
</script>

<template>    
<div class="w-full h-full flex flex-col items-center justify-items-center object-center">
  <audio style="display: none" controls ref="audioRef" @timeupdate="updateProgress">
    <source :src="props.url" type="audio/mpeg">
    您的浏览器不支持音频播放
  </audio>
  <div class="w-5/12 h-5/12 flex flex-col">
    <mdui-card class="w-full h-full flex flex-col justify-center items-center">
      <div class="w-full h-12"></div>
      <div class="w-4/5 h-full">
        <img class="w-full max-h-full object-cover rounded-xl" :src="props.img" alt="img">
      </div>
      <div class="w-full h-12"></div>
    </mdui-card>
    <div class="w-full mt-4 h-24 flex fle-row justify-items-center  items-center  ">
      <div class="flex flex-col w-1/2">
        <div class="text-3xl">{{props.name}}</div>
        <div class="flex flex-row gap-1">
          <div class="text-xl text-slate-600">{{props.author}}</div>
          <div>-</div>
          <div class="text-xl text-slate-600">{{props.album}}</div>
        </div>
      </div>
      <div class="space-x-8">
        <mdui-button variant="tonal" class="w-10 h-10 rounded-2xl">
          <svg t="1727403481365" class="icon" viewBox="0 0 1024 1024" version="1.1" xmlns="http://www.w3.org/2000/svg" p-id="2563" width="32" height="32"><path d="M896 304.7v414.6L618.41 512 896 304.7m37.67-101.62c-5.09 0-10.31 1.51-15.04 4.85L536.92 492.98c-12.71 9.49-12.71 28.54 0 38.03l381.72 285.06c4.73 3.34 9.95 4.85 15.04 4.85 13.62 0 26.33-10.8 26.33-26.28V229.36c-0.01-15.48-12.72-26.28-26.34-26.28zM432.62 304.7v414.6L155.03 512l277.59-207.3m37.67-101.62c-5.09 0-10.31 1.51-15.04 4.85L73.53 492.98c-12.71 9.49-12.71 28.54 0 38.03l381.72 285.06c4.73 3.34 9.95 4.85 15.04 4.85 13.62 0 26.33-10.8 26.33-26.28V229.36c0-15.48-12.71-26.28-26.33-26.28z" fill="#333333" p-id="2564"></path></svg>
        </mdui-button>
        <mdui-button  class="w-10 h-10 rounded-2xl" v-if="!isPlay" @click="changePlay()" variant="tonal">
          <svg t="1727404419427" class="icon" viewBox="0 0 1024 1024" version="1.1" xmlns="http://www.w3.org/2000/svg" p-id="6860" width="24" height="24"><path d="M268.97201558 114.31784297c73.21218086 0 132.56071902 59.34853814 132.56071901 132.560719v530.24287606c0 73.21218086-59.34853814 132.56071902-132.56071901 132.560719s-132.56071902-59.34853814-132.56071901-132.560719V246.87856197c0-73.21218086 59.34853814-132.56071902 132.56071901-132.560719z m486.05596884 0c73.21218086 0 132.56071902 59.34853814 132.56071901 132.560719v530.24287606c0 73.21218086-59.34853814 132.56071902-132.56071901 132.560719s-132.56071902-59.34853814-132.56071901-132.560719V246.87856197c0-73.21218086 59.34853814-132.56071902 132.56071901-132.560719z" p-id="6861"></path></svg>
        </mdui-button>
        <mdui-button v-if="isPlay" @click="changePlay()" variant="tonal" class="w-10 h-10 rounded-2xl">
          <svg t="1727403810491" class="icon" viewBox="0 0 1024 1024" version="1.1" xmlns="http://www.w3.org/2000/svg" p-id="3650" width="32" height="32"><path d="M864.5 516.2c-2.4-4.1-6.2-6.9-10.4-8.3L286.4 159c-8.9-5-20.3-2-25.5 6.6-2.1 3.6-2.8 7.5-2.3 11.3v697.5c-0.5 3.8 0.2 7.8 2.3 11.3 5.2 8.7 16.6 11.6 25.5 6.6l567.7-349c4.2-1.3 8-4.2 10.4-8.3 1.7-3 2.5-6.3 2.4-9.5 0.1-3-0.7-6.3-2.4-9.3z m-569-308.8l517.6 318.3L295.5 844V207.4z" p-id="3651"></path></svg>
        </mdui-button>
        <mdui-button variant="tonal" class="w-10 h-10 rounded-2xl">
          <svg t="1727404565230" class="icon" viewBox="0 0 1024 1024" version="1.1" xmlns="http://www.w3.org/2000/svg" p-id="7889" width="32" height="32"><path d="M128 304.7L405.59 512 128 719.3V304.7M90.33 203.08c-13.62 0-26.33 10.8-26.33 26.28v565.28c0 15.48 12.71 26.28 26.33 26.28 5.09 0 10.31-1.51 15.04-4.85l381.72-285.06c12.71-9.49 12.71-28.54 0-38.03L105.37 207.92c-4.73-3.33-9.95-4.84-15.04-4.84zM591.38 304.7L868.97 512 591.38 719.3V304.7m-37.67-101.62c-13.62 0-26.33 10.8-26.33 26.28v565.28c0 15.48 12.71 26.28 26.33 26.28 5.09 0 10.31-1.51 15.04-4.85l381.72-285.06c12.71-9.49 12.71-28.54 0-38.03L568.75 207.92c-4.73-3.33-9.95-4.84-15.04-4.84z" fill="#333333" p-id="7890"></path></svg>
        </mdui-button>
      </div>
    </div>
    <div class="flex-row flex items-center">
      <div>{{audioStart}}</div>
      <mdui-slider  class="jindutiao" :min="0" :max="fileTime" @input="console.log($event.target.value)" :value="currentProgress" @change="handleProgress($event.target.value)"></mdui-slider>
      <div>{{totalTime}}</div>
    </div>
    <div class="flex flex-row-reverse w-full items-center justify-items-center" >
      <mdui-slider   class="w-1/5" value="12" @input="handleAudioVolume($event.target.value)"></mdui-slider>
      <svg t="1727405681649" class="icon" viewBox="0 0 1024 1024" version="1.1" xmlns="http://www.w3.org/2000/svg" p-id="8921" width="24" height="24"><path d="M601.248 196.16c4.448 9.088 6.752 19.104 6.752 29.248v573.184C608 834.72 579.36 864 544 864c-9.92 0-19.744-2.368-28.608-6.912l-256-130.784A65.568 65.568 0 0 1 224 667.808v-311.584c0-24.768 13.696-47.424 35.392-58.496l256-130.816a63.36 63.36 0 0 1 85.856 29.248zM544 224l-256 131.456v313.12L544 800V224z m239.136 56.448c68.48 50.464 112.864 131.2 112.864 222.176 0 93.248-46.592 175.68-117.984 225.856l-44.8-44.32c60.512-38.208 100.64-105.248 100.64-181.536a214.4 214.4 0 0 0-95.264-178.08l44.544-44.096zM192 352v320H128V352h64z m503.264 18.208a153.28 153.28 0 0 1 76.48 132.416 153.472 153.472 0 0 1-81.024 135.04 221.408 221.408 0 0 1-28.8-54.56 92.064 92.064 0 0 0 47.68-80.48c0-33.44-18.016-62.72-44.928-78.912a222.72 222.72 0 0 1 30.592-53.504z" fill="#686C78" p-id="8922"></path></svg>
    </div>
  </div>

</div>
</template>

<style scoped>

</style>
