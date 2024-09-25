<script setup lang="ts">
const props=defineProps({
  url:String,
  name:String,
  author:String,
})
</script>

<template>
  <div class="w-52 h-20">
    <mdui-card class="w-full h-full flex flex-row">
      <img  class=" w-20  h-full object-cover rounded-xl" :src="props.url" alt="OIP-C.jpg" title="OIP-C.jpg" />
      <div class="h-full w-full flex items-center justify-items-center">
        <div class="flex flex-col  w-full h-2/3 ml-2  justify-items-center">
          <div class="text-xl">{{props.name}}</div>
          <div class="text-sm">{{props.author}}</div>
        </div>
      </div>

    </mdui-card>
  </div>
</template>

<style scoped>

</style>