<script setup lang="js">

const PageData=reactive({
  password:"",
  username:"",
  repeatPassword:"",
  islogin:true,
})

const Login=async ()=>{
  const res = await UserLogin({password:PageData.password,username:PageData.username});
  if(res.success){
    navigateTo({path:"/container/home"})
  }
}
const Register=async ()=>{
  const res = await UserRegister({password:PageData.password,username:PageData.username});
  if(res.success){
    navigateTo({path:"/container/home"})
  }
}

</script>

<template>
<div class="w-screen flex h-screen">

  <div class="fixed top-0 right-0 w-1/2 h-screen bg-white  rounded-2xl bg-opacity-50 z-20 flex flex-col items-center justify-items-center">
    <div class="flex items-center flex-row w-auto">
      <svg height="180" node-id="1" sillyvg="true" template-height="280" template-width="280" version="1.1" viewBox="0 0 280 280" width="280" xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink"><defs node-id="31"></defs><path d="M 222.10 138.70 L 221.80 145.20 L 221.10 151.60 L 219.80 157.70 L 218.10 163.70 L 215.90 169.50 L 213.30 175.10 L 210.30 180.40 L 206.80 185.40 L 203.00 190.20 L 198.90 194.60 L 194.50 198.80 L 189.70 202.60 L 184.60 206.00 L 179.30 209.00 L 173.80 211.60 L 168.00 213.80 L 162.00 215.50 L 155.90 216.80 L 149.50 217.60 L 142.90 217.80 L 136.40 217.60 L 130.00 216.80 L 123.90 215.50 L 117.90 213.80 L 112.10 211.60 L 106.50 209.00 L 101.20 206.00 L 96.20 202.60 L 91.40 198.80 L 86.90 194.60 L 82.80 190.20 L 79.00 185.40 L 75.60 180.40 L 72.60 175.10 L 70.00 169.50 L 67.80 163.70 L 66.10 157.70 L 64.80 151.60 L 64.00 145.20 L 63.70 138.70 L 64.00 132.10 L 64.80 125.70 L 66.10 119.60 L 67.80 113.60 L 70.00 107.80 L 72.60 102.20 L 75.60 96.90 L 79.00 91.90 L 82.80 87.10 L 86.90 82.70 L 91.40 78.50 L 96.20 74.70 L 101.20 71.30 L 106.50 68.30 L 112.10 65.70 L 117.90 63.50 L 123.90 61.80 L 130.00 60.50 L 136.40 59.70 L 142.90 59.50 L 149.50 59.70 L 155.90 60.50 L 162.00 61.80 L 168.00 63.50 L 173.80 65.70 L 179.30 68.30 L 184.60 71.30 L 189.70 74.70 L 194.50 78.50 L 198.90 82.70 L 203.00 87.10 L 206.80 91.90 L 210.30 96.90 L 213.30 102.20 L 215.90 107.80 L 218.10 113.60 L 219.80 119.60 L 221.10 125.70 L 221.80 132.10 L 222.10 138.70 Z" fill="#717070" fill-rule="nonzero" node-id="33" stroke="#52120e" stroke-linecap="butt" stroke-width="5" target-height="158.3" target-width="158.40001" target-x="63.7" target-y="59.5"/><path d="M 142.90 169.10 L 138.70 168.80 L 134.80 168.00 L 131.10 166.70 L 127.50 164.90 L 124.30 162.80 L 121.40 160.20 L 118.80 157.30 L 116.70 154.00 L 114.90 150.50 L 113.60 146.80 L 112.80 142.80 L 112.50 138.70 L 112.80 134.50 L 113.60 130.50 L 114.90 126.80 L 116.70 123.30 L 118.80 120.00 L 121.40 117.10 L 124.30 114.50 L 127.50 112.40 L 131.10 110.60 L 134.80 109.30 L 138.70 108.50 L 142.90 108.20 L 147.10 108.50 L 151.10 109.30 L 154.80 110.60 L 158.30 112.40 L 161.50 114.50 L 164.50 117.10 L 167.00 120.00 L 169.20 123.30 L 171.00 126.80 L 172.30 130.50 L 173.10 134.50 L 173.40 138.70 L 173.10 142.80 L 172.30 146.80 L 171.00 150.50 L 169.20 154.00 L 167.00 157.20 L 164.50 160.20 L 161.50 162.70 L 158.30 164.90 L 154.80 166.70 L 151.00 168.00 L 147.10 168.80 L 142.90 169.10 Z" fill="#e1717a" fill-rule="nonzero" node-id="35" stroke="none" target-height="60.90001" target-width="60.899994" target-x="112.5" target-y="108.2"/><path d="M 142.90 110.70 L 146.70 111.00 L 150.30 111.70 L 153.70 112.90 L 156.90 114.50 L 159.90 116.50 L 162.70 118.80 L 165.10 121.60 L 167.10 124.60 L 168.80 128.00 L 170.00 131.50 L 170.70 135.10 L 170.90 138.70 L 170.70 142.30 L 170.00 145.90 L 168.80 149.30 L 167.20 152.50 L 165.20 155.60 L 162.70 158.40 L 159.90 160.90 L 156.80 162.90 L 153.60 164.50 L 150.10 165.70 L 146.60 166.40 L 143.00 166.60 L 139.40 166.40 L 135.80 165.70 L 132.30 164.50 L 128.90 162.80 L 125.90 160.80 L 123.10 158.40 L 120.80 155.60 L 118.80 152.70 L 117.10 149.40 L 116.00 146.00 L 115.30 142.40 L 115.00 138.70 L 115.30 134.80 L 116.00 131.20 L 117.20 127.80 L 118.80 124.50 L 120.80 121.60 L 123.20 118.90 L 125.90 116.50 L 128.80 114.50 L 132.10 112.90 L 135.50 111.70 L 139.10 111.00 L 142.90 110.70 M 142.90 105.70 L 138.50 106.00 L 134.30 106.90 L 130.30 108.20 L 126.40 110.10 L 122.90 112.50 L 119.70 115.30 L 116.90 118.50 L 114.50 122.10 L 112.50 126.10 L 111.10 130.30 L 110.30 134.50 L 110.00 138.70 L 110.30 143.00 L 111.10 147.10 L 112.50 151.20 L 114.30 155.00 L 116.70 158.60 L 119.60 162.00 L 123.00 164.90 L 126.60 167.30 L 130.40 169.10 L 134.50 170.50 L 138.60 171.30 L 142.90 171.60 L 147.10 171.30 L 151.40 170.50 L 155.60 169.10 L 159.50 167.10 L 163.10 164.70 L 166.30 161.90 L 169.10 158.70 L 171.50 155.20 L 173.40 151.30 L 174.70 147.30 L 175.60 143.10 L 175.90 138.70 L 175.60 134.10 L 174.70 129.90 L 173.30 125.80 L 171.40 122.00 L 169.00 118.50 L 166.20 115.40 L 163.10 112.60 L 159.60 110.20 L 155.80 108.30 L 151.70 106.90 L 147.50 106.00 L 142.90 105.70 Z" fill="#52120e" fill-rule="nonzero" node-id="37" stroke="none" target-height="65.90001" target-width="65.899994" target-x="110" target-y="105.7"/><path d="M 142.90 155.60 L 139.80 155.40 L 137.00 154.60 L 134.30 153.30 L 132.00 151.60 L 129.90 149.60 L 128.30 147.20 L 127.00 144.60 L 126.20 141.70 L 125.90 138.60 L 126.20 135.50 L 127.00 132.70 L 128.30 130.10 L 129.90 127.70 L 132.00 125.70 L 134.30 124.00 L 137.00 122.70 L 139.80 121.90 L 142.90 121.60 L 146.00 121.90 L 148.90 122.70 L 151.50 124.00 L 153.90 125.70 L 155.90 127.70 L 157.60 130.10 L 158.90 132.70 L 159.60 135.50 L 159.90 138.60 L 159.60 141.70 L 158.90 144.60 L 157.60 147.20 L 155.90 149.60 L 153.90 151.60 L 151.50 153.30 L 148.90 154.60 L 146.00 155.40 L 142.90 155.60 Z" fill="#ffffff" fill-rule="nonzero" node-id="39" stroke="none" target-height="34.000008" target-width="33.999992" target-x="125.9" target-y="121.6"/><path d="M 142.90 124.20 L 145.80 124.50 L 148.50 125.30 L 151.00 126.60 L 153.20 128.40 L 154.90 130.50 L 156.30 133.10 L 157.20 135.90 L 157.40 138.70 L 157.20 141.50 L 156.30 144.20 L 155.00 146.60 L 153.20 148.90 L 150.90 150.80 L 148.50 152.10 L 145.80 152.90 L 143.00 153.20 L 140.20 152.90 L 137.40 152.00 L 134.80 150.70 L 132.70 148.90 L 130.90 146.70 L 129.60 144.20 L 128.70 141.60 L 128.50 138.70 L 128.70 136.00 L 129.40 133.60 L 130.40 131.30 L 131.90 129.30 L 133.60 127.60 L 135.60 126.10 L 137.90 125.10 L 140.30 124.40 L 142.90 124.20 M 142.90 119.20 L 140.30 119.30 L 135.40 120.70 L 133.20 121.80 L 129.20 124.80 L 126.10 128.90 L 124.90 131.20 L 123.60 136.20 L 123.40 138.70 L 124.10 143.70 L 126.00 148.40 L 127.40 150.50 L 129.20 152.40 L 133.20 155.60 L 135.50 156.70 L 140.40 158.00 L 145.40 158.00 L 147.90 157.50 L 150.40 156.70 L 154.90 154.10 L 158.40 150.50 L 160.90 146.20 L 162.20 141.30 L 162.40 138.70 L 162.10 135.10 L 161.20 131.80 L 159.80 128.80 L 157.80 126.10 L 155.50 123.80 L 152.80 121.80 L 149.70 120.40 L 146.50 119.50 L 142.90 119.20 Z" fill="#52120e" fill-rule="nonzero" node-id="41" stroke="none" target-height="38.800003" target-width="38.999992" target-x="123.4" target-y="119.2"/><path d="M 142.90 148.00 L 139.70 147.40 L 138.20 146.70 L 136.30 145.30 L 134.90 143.40 L 134.20 141.90 L 133.60 138.70 L 134.20 135.40 L 134.90 134.00 L 136.30 132.10 L 138.20 130.70 L 141.20 129.50 L 142.90 129.40 L 146.20 130.00 L 147.60 130.70 L 149.50 132.10 L 151.00 134.00 L 151.70 135.40 L 152.20 138.70 L 151.70 141.90 L 151.00 143.40 L 149.50 145.30 L 147.60 146.70 L 146.20 147.40 L 142.90 148.00 Z" fill="#121839" fill-rule="nonzero" node-id="43" stroke="none" target-height="18.600006" target-width="18.59999" target-x="133.6" target-y="129.4"/><path d="M 142.90 131.90 L 144.90 132.10 L 146.70 133.00 L 148.20 134.30 L 149.20 136.00 L 149.70 138.00 L 149.60 140.00 L 149.00 141.80 L 147.80 143.50 L 146.10 144.70 L 144.30 145.30 L 142.30 145.40 L 140.30 144.90 L 138.60 143.90 L 137.30 142.40 L 136.40 140.70 L 136.10 138.70 L 136.40 136.80 L 137.10 135.20 L 138.10 133.80 L 139.50 132.80 L 141.10 132.10 L 142.90 131.90 M 142.90 126.90 L 140.60 127.10 L 138.40 127.80 L 136.40 128.80 L 134.60 130.30 L 133.20 132.00 L 132.00 134.10 L 131.30 136.40 L 131.10 138.70 L 131.30 141.00 L 132.00 143.20 L 133.10 145.20 L 134.60 147.00 L 136.40 148.50 L 138.40 149.60 L 140.60 150.20 L 142.90 150.50 L 145.20 150.30 L 147.50 149.60 L 149.60 148.40 L 151.30 147.00 L 152.80 145.20 L 153.80 143.20 L 154.50 141.00 L 154.70 138.70 L 154.00 134.50 L 153.10 132.70 L 150.50 129.60 L 147.10 127.60 L 142.90 126.90 Z" fill="#ffffff" fill-rule="nonzero" node-id="45" stroke="none" target-height="23.599998" target-width="23.59999" target-x="131.1" target-y="126.9"/><path d="M 120.00 201.80 L 124.90 204.20 L 129.90 206.00 L 135.10 207.20 L 140.30 207.80 L 145.60 207.80 L 150.80 207.20 L 156.00 206.00 L 161.00 204.20 L 165.90 201.80" fill="none" node-id="47" stroke="#121839" stroke-linecap="butt" stroke-width="2" target-height="6" target-width="45.899994" target-x="120" target-y="201.8"/><path d="M 120.00 201.80 L 124.90 204.20 L 129.90 206.00 L 135.10 207.20 L 140.30 207.80 L 145.60 207.80 L 150.80 207.20 L 156.00 206.00 L 161.00 204.20 L 165.90 201.80" fill="none" node-id="49" stroke="#52120e" stroke-linecap="butt" stroke-width="3.75" target-height="6" target-width="45.899994" target-x="120" target-y="201.8"/><path d="M 161.40 194.10 L 157.50 196.00 L 153.50 197.50 L 149.30 198.50 L 145.00 198.90 L 140.80 198.90 L 136.60 198.50 L 132.40 197.50 L 128.40 196.00 L 124.40 194.10" fill="none" node-id="51" stroke="#121839" stroke-linecap="butt" stroke-width="2" target-height="4.799988" target-width="36.999992" target-x="124.4" target-y="194.1"/><path d="M 161.40 194.10 L 157.50 196.00 L 153.50 197.50 L 149.30 198.50 L 145.00 198.90 L 140.80 198.90 L 136.60 198.50 L 132.40 197.50 L 128.40 196.00 L 124.40 194.10" fill="none" node-id="53" stroke="#52120e" stroke-linecap="butt" stroke-width="3.75" target-height="4.799988" target-width="36.999992" target-x="124.4" target-y="194.1"/><path d="M 128.90 186.40 L 134.90 189.00 L 141.30 190.10 L 147.80 189.70 L 150.90 189.00 L 157.00 186.40" fill="none" node-id="55" stroke="#121839" stroke-linecap="butt" stroke-width="2" target-height="3.7000122" target-width="28.100006" target-x="128.9" target-y="186.4"/><path d="M 128.90 186.40 L 134.90 189.00 L 141.30 190.10 L 147.80 189.70 L 150.90 189.00 L 157.00 186.40" fill="none" node-id="57" stroke="#52120e" stroke-linecap="butt" stroke-width="1.25" target-height="3.7000122" target-width="28.100006" target-x="128.9" target-y="186.4"/><path d="M 152.50 178.70 L 149.40 180.10 L 146.20 180.90 L 142.90 181.20 L 139.60 180.90 L 136.40 180.10 L 133.30 178.70" fill="none" node-id="59" stroke="#121839" stroke-linecap="butt" stroke-width="2" target-height="2.5" target-width="19.199997" target-x="133.3" target-y="178.7"/><path d="M 152.50 178.70 L 149.40 180.10 L 146.20 180.90 L 142.90 181.20 L 139.60 180.90 L 136.40 180.10 L 133.30 178.70" fill="none" node-id="61" stroke="#52120e" stroke-linecap="butt" stroke-width="1.25" target-height="2.5" target-width="19.199997" target-x="133.3" target-y="178.7"/><path d="M 166.80 75.20 L 163.00 73.30 L 155.20 70.50 L 151.10 69.60 L 145.70 68.90 L 140.20 68.90 L 134.70 69.60 L 130.70 70.50 L 122.90 73.30 L 119.10 75.20" fill="none" node-id="63" stroke="#121839" stroke-linecap="butt" stroke-width="2" target-height="6.2999954" target-width="47.700005" target-x="119.1" target-y="68.9"/><path d="M 166.80 75.20 L 163.00 73.30 L 155.20 70.50 L 151.10 69.60 L 145.70 68.90 L 140.20 68.90 L 134.70 69.60 L 130.70 70.50 L 122.90 73.30 L 119.10 75.20" fill="none" node-id="65" stroke="#52120e" stroke-linecap="butt" stroke-width="3.75" target-height="6.2999954" target-width="47.700005" target-x="119.1" target-y="68.9"/><path d="M 123.70 83.20 L 127.80 81.20 L 132.00 79.70 L 136.30 78.70 L 140.70 78.20 L 145.10 78.20 L 149.50 78.70 L 153.90 79.70 L 158.10 81.20 L 162.20 83.20" fill="none" node-id="67" stroke="#121839" stroke-linecap="butt" stroke-width="2" target-height="5" target-width="38.5" target-x="123.7" target-y="78.2"/><path d="M 123.70 83.20 L 127.80 81.20 L 132.00 79.70 L 136.30 78.70 L 140.70 78.20 L 145.10 78.20 L 149.50 78.70 L 153.90 79.70 L 158.10 81.20 L 162.20 83.20" fill="none" node-id="69" stroke="#52120e" stroke-linecap="butt" stroke-width="3.75" target-height="5" target-width="38.5" target-x="123.7" target-y="78.2"/><path d="M 157.50 91.20 L 151.20 88.60 L 148.00 87.80 L 141.30 87.40 L 134.60 88.60 L 128.30 91.20" fill="none" node-id="71" stroke="#121839" stroke-linecap="butt" stroke-width="2" target-height="3.7999954" target-width="29.199997" target-x="128.3" target-y="87.4"/><path d="M 157.50 91.20 L 151.20 88.60 L 148.00 87.80 L 141.30 87.40 L 134.60 88.60 L 128.30 91.20" fill="none" node-id="73" stroke="#52120e" stroke-linecap="butt" stroke-width="1.25" target-height="3.7999954" target-width="29.199997" target-x="128.3" target-y="87.4"/><path d="M 133.00 99.20 L 136.20 97.80 L 139.50 96.90 L 143.00 96.60 L 146.40 96.90 L 149.70 97.80 L 152.90 99.20" fill="none" node-id="75" stroke="#121839" stroke-linecap="butt" stroke-width="2" target-height="2.5999985" target-width="19.899994" target-x="133" target-y="96.6"/><path d="M 133.00 99.20 L 136.20 97.80 L 139.50 96.90 L 143.00 96.60 L 146.40 96.90 L 149.70 97.80 L 152.90 99.20" fill="none" node-id="77" stroke="#52120e" stroke-linecap="butt" stroke-width="1.25" target-height="2.5999985" target-width="19.899994" target-x="133" target-y="96.6"/></svg>
      <div class="text-4xl font-mono mr-32">{{PageData.islogin?'登陆':'注册'}}到Goush</div>
    </div>
      <div v-if="PageData.islogin" class="flex flex-col w-full space-y-8 items-center bg-gray-200 bg-opacity-40 rounded-xl border-4 border-gray-200 border-opacity-40 ">
        <div class=" w-3/6 mt-12 flex flex-row items-center ">
          <div class="flex flex-col w-1/4 space-y-8">
            <div>用户名:</div>
            <div>密码:</div>
          </div>
          <div class="flex flex-col w-full space-y-8">
            <input v-model="PageData.username" class="border-b border-black bg-transparent focus:outline-none focus:border-black placeholder-transparent">
            <input v-model="PageData.password" type="password" class="border-b border-black bg-transparent focus:outline-none focus:border-black placeholder-transparent">
          </div>
        </div>
        <div class="w-3/12  flex flex-row justify-between">
          <el-button v-if="PageData.islogin" type="primary" @click="Login">登陆</el-button>
          <el-button v-else @click="Register">注册</el-button>
          <el-button v-if="PageData.islogin" text @click="PageData.islogin=false">去注册</el-button>
          <el-button  v-else text @click="PageData.islogin=true">去登陆</el-button>
        </div>
      </div>
    <div v-else class="flex flex-col w-full space-y-8 items-center bg-gray-200 bg-opacity-40 rounded-xl border-4 border-gray-200 border-opacity-40 ">
      <div class=" w-3/6 mt-12 flex flex-row items-center ">
        <div class="flex flex-col w-1/4 space-y-8">
          <div>用户名:</div>
          <div>密码:</div>
          <div>确认密码:</div>
        </div>
        <div class="flex flex-col w-full space-y-8">
          <input v-model="PageData.username" class="border-b border-black bg-transparent focus:outline-none focus:border-black placeholder-transparent">
          <input v-model="PageData.password" type="password"  class="border-b border-black bg-transparent focus:outline-none focus:border-black placeholder-transparent">
          <input v-model="PageData.repeatPassword" type="password"  class="border-b border-black bg-transparent focus:outline-none focus:border-black placeholder-transparent">
        </div>
      </div>
      <div class="w-3/12  flex flex-row justify-between">
        <el-button v-if="PageData.islogin" type="primary" @click="Login()">登陆</el-button>
        <el-button v-else type="success" @click="Register()">注册</el-button>
        <el-button v-if="PageData.islogin" text @click="PageData.islogin=false">去注册</el-button>
        <el-button  v-else text @click="PageData.islogin=true">去登陆</el-button>

      </div>
    </div>
  </div>
    <img src="https://pic2.zhimg.com/v2-70910d6b319c28326e5a9ab50ee31d2c_r.jpg" alt="img" class="w-full h-screen z-0">
  <div class=" fixed top-1/2 text-white items-center text-8xl">
    <div class="w-full flex-row">
      <div>Welcome To</div>
    </div>
    <div class="fixed right-1/2 top-1/3">
        Goush Play
    </div>
  </div>
</div>
</template>

<style scoped>

</style>
