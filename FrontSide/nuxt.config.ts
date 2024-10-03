// https://nuxt.com/docs/api/configuration/nuxt-config
export default defineNuxtConfig({

  compatibilityDate: '2024-04-03',
  css: ['~/assets/css/main.css',
    "~/assets/icons/filled.css",
    "~/assets/icons/outlined.css"],
  devtools: { enabled: false },
  modules: [
    '@element-plus/nuxt'
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
