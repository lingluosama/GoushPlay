<script setup lang="js">
import {navigateTo} from "#app/composables/router.js";

const PageData=reactive({
  albums:[],
})
onMounted(async ()=>{
  await InSearch("")
})
const InSearch= async (keyword)=>{
  const res = await SearchAlbum({keyword:keyword});
  PageData.albums=res.data.albumlist;
}
const GoAlbumPage=(index)=>{
  navigateTo({path:"/container/album",query:{aid:PageData.albums[index].id}})
}
const GoEditPage=(index)=>{
  if(index!==null)navigateTo({path:"/container/edit",query:{aid:PageData.albums[index].id}})
  else navigateTo({path:"/container/edit",query:{aid:'-1'}})
}
</script>

<template>
<div class="w-full min-h-screen items-center flex flex-col ">
  <div class="w-5/6 flex flex-row items-center">
    <mdui-text-field label="Typing to search" class="w-1/4   mt-8" @keydown.enter="InSearch($event.target.value)">
      <mdui-button-icon slot="icon" icon="search"></mdui-button-icon>
    </mdui-text-field>
  </div>
  <mdui-divider inset class="w-5/6 mt-12"></mdui-divider>
  <mdui-list class="w-5/6" slot="custom">
    <mdui-list-subheader>
      <div class="flex w-full items-center justify-between flex-row">
        <div class="w-1/3">Title</div>
        <div class="w-1/6">Author</div>
        <div class="w-1/6">AlbumId</div>
        <div class="w-1/6"></div>
      </div>
    </mdui-list-subheader>
    <div v-for="(item,index) in PageData.albums">
      <mdui-list-item slot="custom" @click="GoEditPage(index)">
        <div class="flex w-full items-center justify-between flex-row">
          <div class="w-1/3 truncate">{{item.title}}</div>
          <div class="w-1/6">{{item.author}}</div>
          <div class="w-1/6">{{item.id}}</div>
          <div class="w-1/6 flex flex-row justify-between">
            <mdui-button icon="delete">Delete</mdui-button>
            <mdui-button icon="edit">Edit</mdui-button>
          </div>
        </div>
      </mdui-list-item>
    </div>
    <mdui-list-item @click="GoEditPage(null)">
      <mdui-icon slot="icon" name="add"></mdui-icon>
      <div>Add New Album</div>
    </mdui-list-item>
  </mdui-list>
</div>
</template>

<style scoped>

</style>
