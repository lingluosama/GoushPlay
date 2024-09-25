<script setup>
const props= defineProps({
  cover:String,
  name:String,
  author:String,
})
</script>

<template>
  <div class="w-56 h-72">
    <mdui-card  class="w-full h-full">
      <img class="w-full h-56 object-cover" :src="props.cover" alt="">
      <div class="flex w-full flex-col ml-3">
        <div class="font-serif text-lg text-nowrap truncate" >{{props.name}}</div>
        <div class="text-gray-500">{{props.author}}</div>
      </div>
    </mdui-card>
  </div>

</template>

<style scoped>

</style>
