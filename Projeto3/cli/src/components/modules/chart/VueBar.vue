<template lang="pug">
  .content-wrapper
    // Content Header (Page header)
    section.content-header
      h1
        | Vue Bar
        small
          | Input data using mouse or keyboard.
          i.ti-heart
          i.ti-export
          i.ti-printer
      ol.breadcrumb
        li
          router-link(to='/')
            i.ti-home
        li
          a(href='#') Charts
        li.active Vue Bar
    // Main content
    section.content
      .row
        .col-md-6
          // Default box
          .box
            .box-header.with-border
              h3.box-title VueBar Option 1
              .box-tools.pull-right
                button.btn.btn-box-tool(type='button' data-widget='collapse' data-toggle='tooltip' title='Collapse')
                  i.fa.ti-minus
                button.btn.btn-box-tool(type='button' data-widget='remove' data-toggle='tooltip' title='Remove')
                  i.fa.ti-close
            .box-body
              bars(:data='[1, 2, 5, 9, 5, 10, 3, 5, 2, 5, 1, 8, 2, 9, 0]' :gradient="['#000000', '#000000']")
            // /.box-body
        .col-md-6
          // Default box
          .box
            .box-header.with-border
              h3.box-title VueBar Option 2
              .box-tools.pull-right
                button.btn.btn-box-tool(type='button' data-widget='collapse' data-toggle='tooltip' title='Collapse')
                  i.fa.ti-minus
                button.btn.btn-box-tool(type='button' data-widget='remove' data-toggle='tooltip' title='Remove')
                  i.fa.ti-close
            .box-body
              bars(:data='[4, 2, 5, 9, 5, 10, 3, 5, 2, 5, 9, 8, 2, 9, 4, 5, 6, 9, 5, 9, 6, 4, 9, 6, 9, 5, 4, 6, 5, 4]' :gradient="['#6fa8dc', '#42b983']")
            // /.box-body
    // /.content

</template>
<script>
export default {
  name: 'FormSwitch',
  data () {
    return {
      value1: true,
      value2: true,
      value3: false,
      value4: false,
      value5: '100'
    }
  }
}
</script>
