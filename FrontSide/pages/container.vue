<script setup lang="js">
import {ref} from "vue";
import Play from "~/pages/container/play.vue"
import { useRoute } from 'vue-router';
const route = useRoute();
const { $mitt } = useNuxtApp();
import bus from "~/plugins/bus.js";
const isContainer=ref(true)
const theme=ref("mdui-theme-dark")
const themeState=useState('dark',()=>true)
onMounted(async ()=>{
  isContainer.value = route.fullPath === "/container";
  if(!localStorage.getItem("theme")){
    localStorage.setItem("theme","mdui-theme-dark");
      themeState.value=true
  }
  else {
    theme.value=localStorage.getItem("theme");
    if(theme.value==="mudio-theme-dark"){themeState.value=true}
    else themeState.value=true
  }
})


const ChTheme=()=>{
  themeState.value=!themeState.value
  if(localStorage.getItem("theme")==="mdui-theme-dark"){
    localStorage.setItem("theme","mdui-theme-light");
  }else{
    localStorage.setItem("theme","mdui-theme-dark");
  }
  theme.value=localStorage.getItem("theme");

}

const changeroute=()=>{
  isContainer.value=false
  $mitt.emit('route')
}


</script>

<template>
  <div :class="theme">
  <div class="h-full w-full flex flex-row ">
    <div class="">
      <mdui-navigation-rail  divider contained>
        <mdui-navigation-rail-item icon="home" @click="changeroute();navigateTo({ path:'/container/home'})">Home</mdui-navigation-rail-item>
        <mdui-navigation-rail-item icon="stop" @click="isContainer=true;navigateTo({path:'/container'})">Play</mdui-navigation-rail-item>
        <mdui-navigation-rail-item icon="upload" @click="changeroute();navigateTo({path:'/container/upload'})">Upload</mdui-navigation-rail-item>
        <mdui-navigation-rail-item icon="person" @click="changeroute();navigateTo({path:'/container/manager'})">Manage</mdui-navigation-rail-item>
        <mdui-navigation-rail-item icon="settings" >Setting</mdui-navigation-rail-item>
          <svg v-if="theme==='mdui-theme-dark'" t="1729136264455" class="absolute bottom-1/4 cursor-pointer" @click="ChTheme" viewBox="0 0 1024 1024" version="1.1" xmlns="http://www.w3.org/2000/svg" p-id="4404" id="mx_n_1729136264457" width="32" height="32"><path d="M712.6 197.87a55.505 55.505 0 0 1-28.74 28.75l-47.46 20.64c-5.1 2.19-8.4 7.2-8.4 12.74s3.3 10.55 8.4 12.74l47.46 20.67a55.54 55.54 0 0 1 28.77 28.72l20.64 47.47c2.18 5.1 7.19 8.4 12.73 8.4s10.55-3.3 12.73-8.4l20.67-47.47a55.505 55.505 0 0 1 28.74-28.75l47.46-20.64c5.1-2.19 8.4-7.2 8.4-12.74s-3.3-10.55-8.4-12.74l-47.46-20.67c-12.88-5.6-23.17-15.86-28.77-28.72l-20.64-47.47A13.84 13.84 0 0 0 746 142c-5.54 0-10.55 3.3-12.73 8.4l-20.67 47.47z" p-id="4405" fill="#e6e6e6"></path><path d="M739.11 496.22c63.7 0 111.62-26.66 141.52-50.2 19.41-12.26 44.76 1.41 45.18 24.36C927.63 485.33 929 500.4 929 512c0 230.3-186.7 417-417 417S95 742.3 95 512 281.7 95 512 95c6.06 0 13.47 0.38 21.24 0.95 21.17-0.03 34.4 22.9 23.79 41.22C536.31 167.42 512 214.54 512 269.11c0 125.43 101.68 227.11 227.11 227.11zM438 269.11c0-32.87 5.1-64.58 15.31-95.11C291.84 201.84 169 342.58 169 512c0 189.43 153.57 343 343 343 177.32 0 323.21-134.55 341.15-307.12-36.19 14.89-74.2 22.34-114.04 22.34-166.3 0-301.11-134.81-301.11-301.11z" p-id="4406" fill="#e6e6e6"></path></svg>
        <svg v-if="theme!=='mdui-theme-dark'" t="1729136264455" class="absolute bottom-1/4 cursor-pointer" @click="ChTheme" viewBox="0 0 1024 1024" version="1.1" xmlns="http://www.w3.org/2000/svg" p-id="4404" id="mx_n_1729136264457" width="32" height="32"><path d="M712.6 197.87a55.505 55.505 0 0 1-28.74 28.75l-47.46 20.64c-5.1 2.19-8.4 7.2-8.4 12.74s3.3 10.55 8.4 12.74l47.46 20.67a55.54 55.54 0 0 1 28.77 28.72l20.64 47.47c2.18 5.1 7.19 8.4 12.73 8.4s10.55-3.3 12.73-8.4l20.67-47.47a55.505 55.505 0 0 1 28.74-28.75l47.46-20.64c5.1-2.19 8.4-7.2 8.4-12.74s-3.3-10.55-8.4-12.74l-47.46-20.67c-12.88-5.6-23.17-15.86-28.77-28.72l-20.64-47.47A13.84 13.84 0 0 0 746 142c-5.54 0-10.55 3.3-12.73 8.4l-20.67 47.47z" p-id="4405" fill="#2c2c2c"></path><path d="M739.11 496.22c63.7 0 111.62-26.66 141.52-50.2 19.41-12.26 44.76 1.41 45.18 24.36C927.63 485.33 929 500.4 929 512c0 230.3-186.7 417-417 417S95 742.3 95 512 281.7 95 512 95c6.06 0 13.47 0.38 21.24 0.95 21.17-0.03 34.4 22.9 23.79 41.22C536.31 167.42 512 214.54 512 269.11c0 125.43 101.68 227.11 227.11 227.11zM438 269.11c0-32.87 5.1-64.58 15.31-95.11C291.84 201.84 169 342.58 169 512c0 189.43 153.57 343 343 343 177.32 0 323.21-134.55 341.15-307.12-36.19 14.89-74.2 22.34-114.04 22.34-166.3 0-301.11-134.81-301.11-301.11z" p-id="4406" fill="#2c2c2c"></path></svg>
      </mdui-navigation-rail>
    </div>
      <keep-alive>
        <play :class="{'hidden':!isContainer,'flex':isContainer}" >
        </play>
      </keep-alive>
      <NuxtPage>
      </NuxtPage>
  </div>
  </div>
</template>

<style scoped>

</style>
