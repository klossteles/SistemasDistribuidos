<template lang="pug">
  #app.wrapper
    router-view

</template>

<script>
  import Toastr from 'toastr'

  export default {
    name: 'App',
    data () {
      return {

      }
    },
    mounted () {
      // Toastr options
      Toastr.options = {
        'closeButton': true,
        'debug': false,
        'newestOnTop': true,
        'progressBar': true,
        'positionClass': 'toast-top-right',
        'preventDuplicates': false,
        'onclick': null,
        'showDuration': '300',
        'hideDuration': '1000',
        'timeOut': '5000',
        'extendedTimeOut': '1000',
        'showEasing': 'swing',
        'hideEasing': 'linear',
        'showMethod': 'fadeIn',
        'hideMethod': 'fadeOut'
      }
    }
  }
</script>
<style lang="scss">
  @import "sass/main"
</style>
