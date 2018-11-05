<template lang="pug">
  transition(name="el-zoom-in-top")
    .content-wrapper
      section.content-header
        h1 Pacotes
      ol.breadcrumb
        li
          router-link(to="/")
          i.ti-home
        li
          a(href='#') Apps
        li.active Pacotes
      section.content

</template>

<script>
  export default {
    name: 'pacotes',
    data () {
      return {
        pacotes: {
          passagem: '',
          hotel: ''
        }
      }
    }
  }
</script>

<style scoped>

</style>
