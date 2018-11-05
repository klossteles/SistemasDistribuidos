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
                .echarts
                  iecharts(:option='line' :loading='loading' @ready='onReady' @click='onClick')
                  button(@click='doRandom') Random
            // /.box-body
    // /.content

</template>
<script>
  import IEcharts from 'vue-echarts-v3/src/full.vue'
  export default {
    name: 'view',
    components: {
      IEcharts
    },
    props: {
    },
    data: () => ({
      loading: false,
      line: {
        title: {
          text: 'ECharts Hello World'
        },
        tooltip: {},
        xAxis: {
          data: ['Shirt', 'Sweater', 'Chiffon Shirt', 'Pants', 'High Heels', 'Socks', 'hat', 'Suit']
        },
        yAxis: {},
        series: [{
          name: 'Sales',
          type: 'line',
          data: [5, 20, 36, 10, 10, 20, 30, 50, 10]
        }]
      }
    }),
    methods: {
      doRandom: function () {
        const that = this
        let data = []
        for (let i = 0, min = 5, max = 99; i < 6; i++) {
          data.push(Math.floor(Math.random() * (max + 1 - min) + min))
        }
        that.loading = !that.loading
        that.bar.series[0].data = data
      },
      onReady: function (instance) {
        console.log(instance)
      },
      onClick: function (event, instance, echarts) {
        console.log(arguments)
      }
    }
  }
</script>

<style scoped>
  .echarts {
    width: 100%;
    height: 400px;
  }
</style>
