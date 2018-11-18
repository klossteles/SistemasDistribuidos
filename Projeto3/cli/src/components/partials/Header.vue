<template lang="pug">
  header.main-header
    router-link.logo(to='/passagens')
      span.logo-mini
        b
          img(src='static/img/logo_utfpr_negativo.png')
      span.logo-lg
        img(src='static/img/logo_utfpr_negativo.png')
        | Projeto 3
    nav.navbar.navbar-static-top
      // Sidebar toggle button
      a.sidebar-toggle(href='#' data-toggle='offcanvas' role='button')
        span.sr-only Toggle navigation
        span.icon-bar
        span.icon-bar
        span.icon-bar
</template>
<script>
  export default {
    name: 'DashboardHeader',
    mounted: function () {

    }
  }
</script>
