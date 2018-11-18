<template lang="pug">
  aside.main-sidebar
    div
      section.sidebar
        ul.sidebar-menu
          li
            router-link(to='/passagens')
              i.ti-ticket
              span Passagens
          li
            router-link(to='/hoteis')
              i.ti-location-pin
              span Hoteis
          li
            router-link(to='/pacotes')
              i.ti-package
              span Pacotes
          li
            br
            br
            br

</template>
<script>
import Avatar from 'vue-avatar/dist/Avatar'
export default {
  name: 'DashboardSidebar',
  mounted: function () {
    $(document).ready(function ($) {
      $('.main-sidebar > div').slimScroll({
        width: '230px',
        position: 'left',
        size: '3px',
        height: '95vh'
      })
    })
  },
  components: {
    Avatar
  }
}
</script>
