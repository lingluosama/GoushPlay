<script setup lang="js">
const musicInput = ref()
const CoverInput = ref()
const formData=reactive({
  title:"",
  author:"",
  album:""
})

</script>

<template>
<div class="w-screen h-screen flex items-center justify-items-center  flex-col">
  <mdui-card class="w-auto absolute bottom-1/2 ">
    <div class="space-y-5 justify-items-center flex flex-col items-center">
      <div></div>
      <div class="flex-row flex w-3/4">
        <div class="w-1/3">音频文件:</div>
        <input class="ml-3" ref="musicInput" type="file" />
      </div>
      <div class="flex-row flex w-3/4 ">
        <div class="w-1/3">封面图像:</div>
        <input class="ml-3" ref="CoverInput" type="file" />
      </div>
      <div class="flex-row  flex w-3/4">
        <div class="w-1/6">标题:</div>
        <el-input v-model="formData.title" class="h-1/2 w-auto"></el-input>
      </div>
      <div class="flex-row flex w-3/4">
        <div class="w-1/6">作者:</div>
        <el-input v-model="formData.author" class="h-1/2 w-auto"></el-input>
      </div>
      <div class="flex-row flex w-3/4">
        <div class="w-1/3">所属专辑:</div>
        <el-input v-model="formData.album" class="h-1/2"></el-input>
      </div>
      <div class="flex-row flex w-3/4">
        <div></div>
      </div>
      <div class="w-full flex flex-col justify-items-center items-center">
        <mdui-button>Upload</mdui-button>
      </div>
      <div></div>
    </div>
  </mdui-card>
</div>
  
  
</template>

<style scoped>

</style>
