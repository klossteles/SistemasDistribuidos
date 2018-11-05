<template lang="pug">
  transition(name='el-zoom-in-center')
    .content-wrapper
      // Content Header (Page header)
      section.content-header
        h1
          | Forms Switch
          small
            i.ti-heart
            i.ti-export
            i.ti-printer
        ol.breadcrumb
          li
            router-link(to='/')
              i.ti-home
          li
            a(href='#') Forms
          li.active Switch
      // Main content
      section.content
        // Default box
        // /.box
        // Default box
        .box
          .box-header
            h3.box-title
              | Basic usage
              small Switch is used for switching between two opposing states.
            .box-tools.pull-right
              button.btn.btn-box-tool(type='button' data-widget='collapse' data-toggle='tooltip' title='Collapse')
                i.ti-minus
              button.btn.btn-box-tool(type='button' data-widget='remove' data-toggle='tooltip' title='Remove')
                i.ti-close
          .box-body
            el-switch(v-model='value1' on-text='' off-text='')
            hr
            el-switch(v-model='value2' on-color='#13ce66' off-color='#ff4949')
          // /.box-body
        .box
          .box-header
            h3.box-title Extended value types
            .box-tools.pull-right
              button.btn.btn-box-tool(type='button' data-widget='collapse' data-toggle='tooltip' title='Collapse')
                i.ti-minus
              button.btn.btn-box-tool(type='button' data-widget='remove' data-toggle='tooltip' title='Remove')
                i.ti-close
          .box-body
            p
              | You can set
              code on-value
              |  and
              code off-value
              |  attributes. They both receive a
              code Boolean
              | ,
              code String
              |  or
              code Number
              |  typed value.
            br
            el-tooltip(:content="'Switch value: ' + value5" placement='right')
              el-switch(v-model='value5' on-color='#13ce66' off-color='#ff4949' on-value='100' off-value='0')
          // /.box-body
        .box
          .box-header
            h3.box-title Disabled
            .box-tools.pull-right
              button.btn.btn-box-tool(type='button' data-widget='collapse' data-toggle='tooltip' title='Collapse')
                i.ti-minus
              button.btn.btn-box-tool(type='button' data-widget='remove' data-toggle='tooltip' title='Remove')
                i.ti-close
          .box-body
            el-switch(v-model='value4' on-text='' off-text='' disabled='')
            el-switch(v-model='value4' disabled='')
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
