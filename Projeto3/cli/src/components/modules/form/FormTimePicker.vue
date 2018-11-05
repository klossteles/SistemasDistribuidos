<template lang="pug">
  transition(name='el-zoom-in-center')
    .content-wrapper
      // Content Header (Page header)
      section.content-header
        h1
          | Forms Timepicker
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
          li.active Timepicker
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
            h4 Fixed time picker
            p Provide a list of fixed time for users to choose
            el-time-select(v-model='value1' :picker-options="{\
          start: '08:30',\
          step: '00:15',\
          end: '18:30'\
          }" placeholder='Select time')
          // /.box-body
        .box
          .box-header
            .box-tools.pull-right
              button.btn.btn-box-tool(type='button' data-widget='collapse' data-toggle='tooltip' title='Collapse')
                i.ti-minus
              button.btn.btn-box-tool(type='button' data-widget='remove' data-toggle='tooltip' title='Remove')
                i.ti-close
          .box-body
            h4.box-title Arbitrary time picker
            p Can pick an arbitrary time.
            el-time-picker(v-model='value2' :picker-options="{\
          selectableRange: '18:30:00 - 20:30:00'\
          }" placeholder='Arbitrary time')
          // /.box-body
        .box
          .box-header
            .box-tools.pull-right
              button.btn.btn-box-tool(type='button' data-widget='collapse' data-toggle='tooltip' title='Collapse')
                i.ti-minus
              button.btn.btn-box-tool(type='button' data-widget='remove' data-toggle='tooltip' title='Remove')
                i.ti-close
          .box-body
            h4 Fixed time range
            p f start time is picked at first, then the end time will change accordingly.
            el-time-select(placeholder='Start time' v-model='startTime' :picker-options="{\
          start: '08:30',\
          step: '00:15',\
          end: '18:30'\
          }")
            el-time-select(placeholder='End time' v-model='endTime' :picker-options="{\
          start: '08:30',\
          step: '00:15',\
          end: '18:30',\
          minTime: startTime\
          }")
          // /.box-body
        .box
          .box-header
            .box-tools.pull-right
              button.btn.btn-box-tool(type='button' data-widget='collapse' data-toggle='tooltip' title='Collapse')
                i.ti-minus
              button.btn.btn-box-tool(type='button' data-widget='remove' data-toggle='tooltip' title='Remove')
                i.ti-close
          .box-body
            h4.box-title Arbitrary time range
            p Can pick an arbitrary time range.
            el-time-picker(is-range='' v-model='value3' placeholder='Pick a time range')
          // /.box-body
      // /.content

</template>
<script>
  export default {
    name: 'FormTimePicker',
    data () {
      return {
        value1: '',
        value2: new Date(2016, 9, 10, 18, 40),
        value3: [new Date(2016, 9, 10, 8, 40), new Date(2016, 9, 10, 9, 40)],
        startTime: '',
        endTime: ''
      }
    }
  }
</script>
