<template lang="pug">
  transition(name='el-zoom-in-top')
    .content-wrapper
      // Content Header (Page header)
      section.content-header
        h1
          | Calendar Page
          small
            i.ti-heart
            i.ti-export
            i.ti-printer
        ol.breadcrumb
          li
            router-link(to='/')
              i.ti-home
          li
            a(href='#') Apps
          li.active Calendar Page
      // Main content
      section.content
        vue-event-calendar(:events='demoEvents')
      // /.content

</template>
<script>
export default {
  name: 'Calendar',
  data () {
    return {
      demoEvents: [{
        date: '2017/12/15',
        title: 'FooFighter',
        desc: 'Conser Music'
      }, {
        date: '2017/11/12',
        desc: 'Conser Music',
        title: 'Bar'
      }, {
        date: '2017/10/3',
        desc: 'Conser Music',
        title: 'Bar'
      }]
    }
  }
}
</script>
