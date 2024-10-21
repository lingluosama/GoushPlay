// https://nuxt.com/docs/api/configuration/nuxt-config
export default defineNuxtConfig({
  head: {
    script: [
      {
        src: 'https://cdnjs.cloudflare.com/ajax/libs/color-thief/2.3.0/color-thief.min.js',
        defer: true
      }
    ]
  },
  compatibilityDate: '2024-04-03',
  css: ['~/assets/css/main.css',
    "~/assets/icons/filled.css",
    "~/assets/icons/outlined.css"],
  devtools: { enabled: false },
  modules: [
    '@element-plus/nuxt',
      
  ],

  plugins: [
    {src:'@/plugins/bus',ssr: false},
    {src:'@/plugins/mitt'},
    {src:'@/plugins/color-thief'},
  ],

  app: {
    pageTransition: { name: 'page', mode: 'out-in' }
  },
  postcss: {
    plugins: {
      tailwindcss: {},
      autoprefixer: {},
    },
  },
})
