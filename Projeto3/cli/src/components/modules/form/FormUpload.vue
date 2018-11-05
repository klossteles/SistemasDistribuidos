<template lang="pug">
  transition(name='el-zoom-in-center')
    .content-wrapper
      // Content Header (Page header)
      section.content-header
        h1
          | Form Form Upload
          small Input data using mouse or keyboard.
        ol.breadcrumb
          li
            a(href='#')
              i.fa.fa-dashboard
              |  Home
          li
            a(href='#') Examples
          li.active Blank page
      // Main content
      section.content
        // Default box
        // /.box
        // Default box
        .box
          .box-header.with-border
            h3.box-title Input Number
            .box-tools.pull-right
              button.btn.btn-box-tool(type='button' data-widget='collapse' data-toggle='tooltip' title='Collapse')
                i.fa.fa-minus
              button.btn.btn-box-tool(type='button' data-widget='remove' data-toggle='tooltip' title='Remove')
                i.fa.fa-times
          .box-body
            h4 Basic usage
            p
            p
              | Bind a variable to
              code v-model
              |  in
              code &lt;el-input-number&gt;
              |  element and you are set.
            p
            el-input-number(v-model='num1' @change='handleChange' :min='1' :max='10')
            el-input-number(v-model='num3' :step='2')
          // /.box-body
      // /.content

</template>
<script>
  export default {
    name: 'FormUpload',
    data () {
      return {
        input: '',
        num1: 1
      }
    }
  }
</script>
