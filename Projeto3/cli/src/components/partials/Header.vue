<template lang="pug">
  header.main-header
    // Logo
    router-link.logo(to='/passagens')
      // mini logo for sidebar mini 50x50 pixels
      span.logo-mini
        b
          img(src='static/img/logo_utfpr_negativo.png')
      // logo for regular state and mobile devices
      span.logo-lg
        img(src='static/img/logo_utfpr_negativo.png')
        | Projeto 3
    // Header Navbar: style can be found in header.less
    nav.navbar.navbar-static-top
      // Sidebar toggle button
      a.sidebar-toggle(href='#' data-toggle='offcanvas' role='button')
        span.sr-only Toggle navigation
        span.icon-bar
        span.icon-bar
        span.icon-bar
      <!--.pull-left-search-->
        <!--form#demo-2-->
          <!--input.devin-search(type='search')-->
      <!--.navbar-custom-menu-->
        <!--ul.nav.navbar-nav-->
          <!--// Messages: style can be found in dropdown.less-->
          <!--li-->
            <!--el-dropdown.header-dropdown-devin(trigger='click')-->
              <!--span.el-dropdown-link-->
                <!--el-badge.item(:value='20' :max='9')-->
                  <!--el-button(type='text' size='small')-->
                    <!--i.ti-email-->
              <!--el-dropdown-menu(slot='dropdown')-->
                <!--ul.dropdown-menu-devin-->
                  <!--li.header You have 10+ Message-->
                  <!--// inner menu: contains the actual data-->
                  <!--li-->
                    <!--ul.menu-->
                      <!--li-->
                        <!--a(href='#')-->
                          <!--h3-->
                            <!--| Announcements-->
                            <!--span Just Now !-->
                          <!--p Pok ame ame belalang kupu kupu-->
                      <!--li-->
                        <!--a(href='#')-->
                          <!--h3-->
                            <!--| Complete your profile-->
                            <!--span 2 Min Ago-->
                          <!--p Siang makan nasi kalo malam minum susu-->
                      <!--li-->
                        <!--a(href='#')-->
                          <!--h3-->
                            <!--| New Schedule Realease-->
                            <!--span 30 Min ago-->
                          <!--p Bintang kecil dilangit yang tinggi-->
                      <!--li-->
                        <!--a(href='#')-->
                          <!--h3-->
                            <!--| New Student Data-->
                            <!--span 1 Hour ago-->
                          <!--p Amat banyak menghias angkasa-->
                      <!--li-->
                        <!--a(href='#')-->
                          <!--h3-->
                            <!--| Graduate Student List-->
                            <!--span 2 Days ago-->
                          <!--p Aku ingin terbang dan melayang, jauh tinggi ke tempat kau berada-->
                  <!--li.footer-->
                    <!--a(href='#') View all-->
          // Notifications: style can be found in dropdown.less
          <!--li-->
            <!--el-dropdown.header-dropdown-devin(trigger='click')-->
              <!--span.el-dropdown-link-->
                <!--el-badge.item(is-dot='')-->
                  <!--el-button(type='text' size='small')-->
                    <!--i.ti-bell-->
              <!--el-dropdown-menu(slot='dropdown')-->
                <!--ul.dropdown-menu-devin-->
                  <!--li.header You have 10 notifications-->
                  <!--li-->
                    <!--// inner menu: contains the actual data-->
                    <!--ul.menu-->
                      <!--li-->
                        <!--i.ti-announcement-->
                        <!--a(href='#')-->
                          <!--h3-->
                            <!--| Announcements-->
                            <!--span.text-green.fontello-record-->
                          <!--p Just Now !-->
                      <!--li-->
                        <!--i.ti-user-->
                        <!--a(href='#')-->
                          <!--h3-->
                            <!--| Complete your profile-->
                            <!--span.text-yellow.fontello-record-->
                          <!--p 2 Min Ago-->
                      <!--li-->
                        <!--i.ti-notepad-->
                        <!--a(href='#')-->
                          <!--h3-->
                            <!--| New Schedule Realease-->
                            <!--span.text-yellow.fontello-record-->
                          <!--p 30 Min ago-->
                      <!--li-->
                        <!--i.ti-agenda-->
                        <!--a(href='#')-->
                          <!--h3-->
                            <!--| New User Data-->
                            <!--span.text-orange.fontello-record-->
                          <!--p 1 Hour ago-->
                      <!--li-->
                        <!--i.ti-package-->
                        <!--a(href='#')-->
                          <!--h3-->
                            <!--| New User List-->
                            <!--span.fontello-record-->
                          <!--p 2 Days ago-->
                  <!--li.footer-->
                    <!--a(href='#') View all-->
          // Control Sidebar Toggle Button
          <!--li-->
            <!--el-dropdown.header-dropdown-devin(trigger='click')-->
              <!--span.el-dropdown-link-->
                <!--el-button(data-toggle='control-sidebar' type='text' size='small')-->
                  <!--i.dripicons-swap-->

</template>
<script>
  export default {
    name: 'DashboardHeader',
    mounted: function () {

    }
  }
</script>
