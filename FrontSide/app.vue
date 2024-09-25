<template>
  <div class="h-full w-full flex flex-col">
    <NuxtPage class="w-full h-full">
    </NuxtPage>
  </div>
</template>
<script setup lang="ts">
import 'mdui/mdui.css';
import 'mdui';
import ElementPlus from 'element-plus'
import 'element-plus'
</script>
<style>
.page-enter-active,
.page-leave-active {
  transition: all 0.4s;
}
.page-enter-from,
.page-leave-to {
  opacity: 0;
  filter: blur(1rem);
}
</style>
