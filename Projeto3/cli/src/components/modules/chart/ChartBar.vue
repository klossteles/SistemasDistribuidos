<template lang="pug">
  .content-wrapper
    // Content Header (Page header)
    section.content-header
      h1
        | EChartBar
        small
          i.ti-heart
          i.ti-export
          i.ti-printer
      ol.breadcrumb
        li
          router-link(to='/')
            i.ti-home
        li
          a(href='#') Charts
        li.active EChart Bar
    // Main content
    section.content
      .row
        .col-md-12
          // Default box
          .box
            .box-body
              div
                .echarts
                  iecharts(:option='bar' :loading='loading')
            // /.box-body
    // /.content

</template>
<script>
  import IEcharts from 'vue-echarts-v3/src/full.vue'
export default {
    data () {
      return {
        loading: false,
        bar: {
          title: {
            text: 'ECharts'
          },
          tooltip: {},
          xAxis: {
            data: ['JAN', 'FEB', 'MAR', 'APR', 'MAY', 'JUN']
          },
          yAxis: {},
          series: [{
            name: 'Sales',
            type: 'bar',
            color: ['#94C2ED'],
            data: [5, 20, 36, 10, 10, 20]
          }]
        }
      }
    },
    components: {
      IEcharts
    }
}
</script>

<style scoped>
  .echarts {
    width: 100%;
    height: 400px;
  }
</style>
