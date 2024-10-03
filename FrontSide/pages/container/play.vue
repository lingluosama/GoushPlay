<script setup lang="js" xmlns="">
import {ref} from "vue";

onMounted(async()=>{
  const [example] = await Promise.all([document.querySelector(".drawer")]);
  const navigationDrawer = example.querySelector("mdui-navigation-drawer")
  const openButton = example.querySelector(".open");
  const closeButton = example.querySelector(".close");
  openButton.addEventListener("click", () => navigationDrawer.open = true);
  closeButton.addEventListener("click", () => navigationDrawer.open = false);
  
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
</script>

<template>
<div class="w-screen h-screen flex flex-row  items-center justify-items-center">
  <player 
      :author="'hello'" 
      :url="'http://downsc.chinaz.net/Files/DownLoad/sound1/201906/11582.mp3'"
      :name="'test1'"
      :img="'https://ts1.cn.mm.bing.net/th/id/R-C.3a1b98d8aa749503cc2ff9c224bc8b40?rik=xxNkH0iChSUYqg&riu=http%3a%2f%2fd.ifengimg.com%2fq100%2fimg1.ugc.ifeng.com%2fnewugc%2f20190119%2f10%2fwemedia%2fabbab6554fa54232bec645b46e6e7bb3f0e4cc5b_size2326_w3000_h2000.JPG&ehk=UzIcp%2fHqCMHntTpDKBDEvAT%2bhhu8xR805ZL0enQCZ%2fY%3d&risl=1&pid=ImgRaw&r=0'"
      :is-paused="true"
      :album="'null'"
      class="mt-28"
  ></player>
  <div class="w-1/5 h-full absolute right-2">
    <div class="drawer">
        <mdui-navigation-drawer  class=" h-full " placement="right">
          <mdui-button class="close" variant="tonal">
            <svg t="1727492673543" class="icon" viewBox="0 0 1024 1024" version="1.1" xmlns="http://www.w3.org/2000/svg" p-id="5327" width="32" height="32"><path d="M972.8 188.16H51.2a40.32 40.32 0 0 1-40.32-40.32 40.32 40.32 0 0 1 40.32-40.32h921.6a40.32 40.32 0 0 1 40.32 40.32 40.32 40.32 0 0 1-40.32 40.32zM972.8 531.2H358.4a33.28 33.28 0 0 1 0-64h614.4a33.28 33.28 0 1 1 0 64zM972.8 888.32H51.2a40.32 40.32 0 0 1-40.32-40.32 40.32 40.32 0 0 1 40.32-40.32h921.6a40.32 40.32 0 0 1 40.32 40.32 40.32 40.32 0 0 1-40.32 40.32zM51.2 673.28a32.64 32.64 0 0 1-23.68-9.6 32.64 32.64 0 0 1 0-46.08L128 517.12 27.52 417.28a32.64 32.64 0 0 1 0-46.08 32 32 0 0 1 46.72 0l122.88 122.88a33.28 33.28 0 0 1 0 46.72l-122.88 122.88a32.64 32.64 0 0 1-23.04 9.6z" fill="#323333" p-id="5328"></path></svg>
          </mdui-button>
          <mdui-list>
            <mdui-list-subheader>播放列表</mdui-list-subheader>
            <div v-for="item in queue" :key="item.name">
              <mdui-list-item  class="flex  h-20 w-full">
                <div class="justify-items-center items-center w-full h-full flex flex-row space-x-3">
                  <img :src="item.img" class="h-16 w-16 rounded-2xl object-cover" alt="img">
                  <div class="w-auto flex flex-col">
                     <div class="text-lg font-medium">{{item.name}}</div>
                    <div class="text-slate-600 text-sm">{{item.author}}</div>
                  </div>
                  <div class="hover:underline">{{item.album}}</div>
                  <div></div>
                </div>
              </mdui-list-item>
            </div>
          </mdui-list>
        </mdui-navigation-drawer>
      <div class="absolute bottom-2.5">
      <mdui-button class="open" variant="tonal">
        <svg t="1727492455612" class="icon" viewBox="0 0 1024 1024" version="1.1" xmlns="http://www.w3.org/2000/svg" p-id="3448" width="32" height="32"><path d="M981.333333 533.333333a21.333333 21.333333 0 0 1-21.333333 21.333334H448a21.333333 21.333333 0 0 1 0-42.666667h512a21.333333 21.333333 0 0 1 21.333333 21.333333zM533.333333 170.666667h426.666667a21.333333 21.333333 0 0 0 0-42.666667H533.333333a21.333333 21.333333 0 0 0 0 42.666667z m426.666667 725.333333H64a21.333333 21.333333 0 0 0 0 42.666667h896a21.333333 21.333333 0 0 0 0-42.666667zM56.046667 663.333333C47.166667 649.333333 42.666667 634.3 42.666667 618.666667s4.5-30.666667 13.38-44.666667c8.053333-12.666667 19.333333-23.946667 33.613333-33.44C117.333333 522.146667 153.646667 512 192 512s74.7 10.146667 102.34 28.58c1.48 0.98 2.913333 2 4.326667 3.006667V64a21.333333 21.333333 0 0 1 42.626666-1.266667c1.073333 18.04 5.806667 52.666667 25.446667 82.08 7.713333 11.553333 16.846667 21.006667 27.153333 28.133334 13.853333 5.513333 26.453333 14.113333 37.493334 25.606666 22.813333 23.753333 32.966667 53.493333 37.466666 74.266667a21.333333 21.333333 0 0 1-41.706666 9.026667c-2.726667-12.586667-9.8-36.313333-26.533334-53.733334C393.433333 220.666667 385.373333 215.226667 376.666667 212a21.18 21.18 0 0 1-4.36-2.186667A140.893333 140.893333 0 0 1 341.333333 182v436.666667c0 15.633333-4.5 30.666667-13.38 44.666666-8.053333 12.666667-19.333333 23.946667-33.613333 33.44-27.64 18.433333-64 28.58-102.34 28.58s-74.666667-10.146667-102.34-28.58C75.406667 687.26 64.1 676 56.046667 663.333333zM85.333333 618.666667c0 20.82 17.54 35.62 28 42.586666 20.706667 13.806667 48.666667 21.413333 78.666667 21.413334s57.966667-7.606667 78.666667-21.413334c10.453333-6.966667 28-21.766667 28-42.586666s-17.54-35.62-28-42.586667C250 562.273333 222 554.666667 192 554.666667s-57.966667 7.606667-78.666667 21.413333c-10.46 6.966667-28 21.766667-28 42.586667z" fill="#5C5C66" p-id="3449"></path></svg>
      
      </mdui-button>
      </div>
    </div>
  </div>
    

</div>
</template>

<style scoped>
.close{
  position: absolute;
  bottom: 12px;
}
</style>
