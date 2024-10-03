<script setup lang="ts">

</script>

<template>
  <div class="h-full w-full flex flex-row">
    <div class="">
      <mdui-navigation-rail  divider contained>
        <mdui-navigation-rail-item icon="home" @click="navigateTo({ path:'/container/home'})">Home</mdui-navigation-rail-item>
        <mdui-navigation-rail-item icon="stop" @click="navigateTo({path:'/container/play'})">Play</mdui-navigation-rail-item>
        <mdui-navigation-rail-item icon="upload" @click="navigateTo({path:'/container/upload'})">Upload</mdui-navigation-rail-item>
        <mdui-navigation-rail-item icon="person">Personal</mdui-navigation-rail-item>
        <mdui-navigation-rail-item icon="settings" >Setting</mdui-navigation-rail-item>
      </mdui-navigation-rail>
    </div>
    <NuxtPage>
    </NuxtPage>
  </div>
</template>

<style scoped>

</style>
