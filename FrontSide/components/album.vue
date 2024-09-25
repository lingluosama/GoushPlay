<script setup>
const props= defineProps({
  cover:String,
  name:String,
  author:String,
})
</script>

<template>
  <div class="w-52 h-52 flex justify-center items-center flex-row">
    <mdui-card  >
      <img class="w-4/5 h-4/5 bg-auto" :src="props.cover" alt="">
      <div>{{props.name}}</div>
      <div>{{props.author}}</div>
    </mdui-card>
  </div>

</template>

<style scoped>

</style>
