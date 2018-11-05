<template lang="pug">
  transition(name='el-zoom-in-top')
    .content-wrapper
      // Content Header (Page header)
      section.content-header
        h1
          | Buttons
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
          li.active Buttons
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
          .box-body
            h4 Basic usage
            hr
            el-button Default Button
            el-button(type='primary') Primary Button
            el-button(type='text') Text Button
            br
            hr
            h4 Disabled Button
            p The disableds attribute determines if the button is disabled.
            el-button(:plain='true' :disabled='true') Default Button
            el-button(type='primary' disabled='') Primary Button
            el-button(type='text' disabled='') Text Button
            br
            hr
            h4 Color Indication
            p Different colors represent different meanings.
            el-button(type='success') Success
            el-button(type='warning') Warning
            el-button(type='danger') Danger
            el-button(type='info') Info
            br
            br
            el-button(:plain='true' type='success') Success
            el-button(:plain='true' type='warning') Warning
            el-button(:plain='true' type='danger') Danger
            el-button(:plain='true' type='info') Info
            br
            hr
            h4 Icon Button
            p
              | Use icons to add more meaning to Button. You can use icon alone to save some space, or with text together.
            el-button(type='primary' icon='edit')
            el-button.btn-rounded(type='primary' icon='share')
            el-button(type='primary' icon='delete')
            el-button(type='primary' icon='search') Search
            el-button(type='primary')
              | Upload
              i.el-icon-upload.el-icon-right
      // /.content

</template>
<script>
  export default {
    name: 'UIButtons'
  }
</script>
<style lang="scss">
    .btn-rounded{
        border-radius: 25px;
    }
</style>
