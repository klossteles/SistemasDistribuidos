<template lang="pug">
  transition(name='el-zoom-in-top')
    .content-wrapper
      // Content Header (Page header)
      section.content-header
        h1
          | Blank Page
          small
            | It&apos;s all start from here
            i.ti-heart
            i.ti-export
            i.ti-printer
        ol.breadcrumb
          li
            router-link(to='/')
              i.ti-home
          li
            a(href='#') Apps
          li.active Blank Page
      // Main content
      section.content
        .box
          .box-header.with-border
            h3.box-title Basic
            .box-tools.pull-right
              button.btn.btn-box-tool(type='button' data-widget='collapse' data-toggle='tooltip' title='Collapse')
                i.ti-minus
              button.btn.btn-box-tool(type='button' data-widget='remove' data-toggle='tooltip' title='Remove')
                i.ti-close
          .box-body(style='min-height:400px;')
            h4 Basic usage
            p Content Goes Here
      // /.content

</template>
<script>
  export default {
    name: 'BlankPage'
  }
</script>
