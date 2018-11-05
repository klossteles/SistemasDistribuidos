<template lang="pug">
  transition(name='el-zoom-in-center')
    .content-wrapper
      // Content Header (Page header)
      section.content-header
        h1
          | Forms Slider
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
          li.active Slider
      // Main content
      section.content
        // Default box
        .box
          .box-header
            .box-tools.pull-right
              button.btn.btn-box-tool(type='button' data-widget='collapse' data-toggle='tooltip' title='Collapse')
                i.ti-minus
              button.btn.btn-box-tool(type='button' data-widget='remove' data-toggle='tooltip' title='Remove')
                i.ti-close
          .box-body
            .block
              span.demonstration Default value
              el-slider(v-model='value1')
            .block
              span.demonstration Customized initial value
              el-slider(v-model='value2')
            .block
              span.demonstration Hide Tooltip
              el-slider(v-model='value3' :show-tooltip='false')
            .block
              span.demonstration Format Tooltip
              el-slider(v-model='value4' :format-tooltip='formatTooltip')
            .block
              span.demonstration Disabled
              el-slider(v-model='value5' disabled='')
          // /.box-body
        // Default box
        .box
          .box-header
            .box-tools.pull-right
              button.btn.btn-box-tool(type='button' data-widget='collapse' data-toggle='tooltip' title='Collapse')
                i.ti-minus
              button.btn.btn-box-tool(type='button' data-widget='remove' data-toggle='tooltip' title='Remove')
                i.ti-close
          .box-body
            .block
              span.demonstration Breakpoints not displayed
              el-slider(v-model='value6' :step='10')
            .block
              span.demonstration Breakpoints displayed
              el-slider(v-model='value7' :step='10' show-stops='')
          // /.box-body
        // Default box
        .box
          .box-header
            .box-tools.pull-right
              button.btn.btn-box-tool(type='button' data-widget='collapse' data-toggle='tooltip' title='Collapse')
                i.ti-minus
              button.btn.btn-box-tool(type='button' data-widget='remove' data-toggle='tooltip' title='Remove')
                i.ti-close
          .box-body
            .block
              el-slider(v-model='value8' show-input='')
        // /.box-body
        // Default box
        .box
          .box-header
            .box-tools.pull-right
              button.btn.btn-box-tool(type='button' data-widget='collapse' data-toggle='tooltip' title='Collapse')
                i.ti-minus
              button.btn.btn-box-tool(type='button' data-widget='remove' data-toggle='tooltip' title='Remove')
                i.ti-close
          .box-body
            .block
              el-slider(v-model='value9' range='' show-stops='' :max='10')
        // /.box-body
        // Default box
        .box
          .box-header
            .box-tools.pull-right
              button.btn.btn-box-tool(type='button' data-widget='collapse' data-toggle='tooltip' title='Collapse')
                i.ti-minus
              button.btn.btn-box-tool(type='button' data-widget='remove' data-toggle='tooltip' title='Remove')
                i.ti-close
          .box-body
            .block
              el-slider(v-model='value10' vertical='' height='200px')
        // /.box-body
      // /.content

</template>
<script>
  export default {
    name: 'FormSlider',
    data () {
      return {
        value1: 0,
        value2: 50,
        value3: 36,
        value4: 48,
        value5: 42,
        value6: 0,
        value7: 0,
        value8: 0,
        value9: [4, 8],
        value10: 0
      }
    },
    methods: {
      formatTooltip (val) {
        return val / 100
      }
    }
  }
</script>
