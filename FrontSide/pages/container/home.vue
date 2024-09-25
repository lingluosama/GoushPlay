<script setup lang="ts">
const PageData= reactive({
  PList:["https://ts1.cn.mm.bing.net/th/id/R-C.14f27bec3b0f031dc1fde230dca1665a?rik=lmDGqpct7kWJEA&riu=http%3a%2f%2fwww.wustars.com%2fUploadFiles%2f2023-10%2fcike%2fggvgioozsod.jpg&ehk=pn0nKASTLA8hKdPi1D4txgpCV9xBF8mgJjEBexbvv6Q%3d&risl=&pid=ImgRaw&r=0"
    ,"https://www.rollingstone.com/wp-content/uploads/2010/10/TaylorSwiftSpeakNow.jpg",
    "https://www.billboard.com/wp-content/uploads/2023/02/02-taylor-swift-2023-grammys-red-carpet-billboard-1548.jpg?w=942&h=623&crop=1"
  ],
})

</script>

<template>
  <div class="w-full h-full flex-col flex justify-center items-center">
    <div class="w-3/5 mt-24">
      <el-carousel :interval="4000" type="card" height="200px">
        <el-carousel-item v-for=" item in PageData.PList" :key="item">
          <div>
            <img class="h-full w-full bg-auto" :src="item" alt="">
          </div>
        </el-carousel-item>
      </el-carousel>
    </div>
    <el-divider></el-divider>
    <div class="w-full">
      <album :name="'MidNight'" :author=" 'Taylor'" :cover="PageData.PList[1]"></album>
    </div>
  </div>
</template>

<style scoped>

</style>
