<template lang="pug">
  .content-wrapper
    // Content Header (Page header)
    section.content-header
      h1
        | Vue Chart Js
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
        li.active Vue Chart Js
    // Main content
    section.content
      .row
        .col-md-12
          // Default box
          .box
            .box-header
              h3.box-title Ring chart
              .box-tools.pull-right
                button.btn.btn-box-tool(type='button' data-widget='collapse' data-toggle='tooltip' title='Collapse')
                  i.fa.ti-minus
                button.btn.btn-box-tool(type='button' data-widget='remove' data-toggle='tooltip' title='Remove')
                  i.fa.ti-close
            .box-body
              div
                schart.chart-devin(:canvasid='canvasId' :type='type' :width='width' :height='height' :data='data' :options='options')
            // /.box-body
    // /.content

</template>
<script>
import Schart from 'vue-schart'

export default {
  name: 'hello',
  components: {
    Schart
  },
  data () {
    return {
      canvasId: 'myCanvas',
      type: 'ring',
      width: 500,
      height: 300,
      data: [
        {name: '1999', value: 109},
        {name: '2000 ', value: 102},
        {name: '2001 ', value: 102},
        {name: '2002 ', value: 98},
        {name: '2003 ', value: 85},
        {name: '2004 ', value: 95}
      ],
      options: {
        padding: 60,
        bgColor: '#ffffff', // the background color of chart. Default is '#ffffff'.
        fillColor: '#42f4df',    // the color of bar chart or line chart.
        titleColor: '#000000', // Title Color. Default is '#000000'.
        titlePosition: 'top', // String.Title position. Default is 'top'.
        legendColor: '#000000', // color of the legend text
        legendTop: 40, // Legend position of top. Default is 40.
        yEqual: 6  // The number of points on the Y axis.
      }
    }
  }
}
</script>
<style lang="scss">
    .chart-devin{
        canvas{
            width: 50%;
            margin: 0 auto;
        }
    }

</style>
