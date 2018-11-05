<template lang="pug">
  transition(name='el-zoom-in-top')
    .content-wrapper
      // Content Header (Page header)
      section.content-header
        h1
          | Tinymce Editor
          small
            i.ti-heart
            i.ti-export
            i.ti-printer
        ol.breadcrumb
          li
            router-link(to='/')
              i.ti-home
          li
            a(href='#') UI Element
          li.active Tinymce Editor
      // Main content
      section.content
        .box
          .box-header
            .box-tools.pull-right
              button.btn.btn-box-tool(type='button' data-widget='collapse' data-toggle='tooltip' title='Collapse')
                i.ti-minus
              button.btn.btn-box-tool(type='button' data-widget='remove' data-toggle='tooltip' title='Remove')
                i.ti-close
          .box-body
            vue-editor(v-model='content')
      // /.content

</template>
<script>
import { VueEditor } from 'vue2-editor'
export default {
  components: {
    VueEditor
  },
  data: function () {
    return {}
  }
}
</script>
