<template lang="pug">
  transition(name='el-zoom-in-top')
    .content-wrapper
      // Content Header (Page header)
      section.content-header
        h1
          | Blank Page
          small
            | It&apos;s all start from here
            i.ti-heart
            i.ti-export
            i.ti-printer
        ol.breadcrumb
          li
            router-link(to='/')
              i.ti-home
          li
            a(href='#') Apps
          li.active Blank Page
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
          .box-body(style='min-height:400px;')
            // Table
            el-button(:plain='true' @click='dialogTableVisible = true') opens a Table nested Dialog
            el-dialog(title='Shipping address' :visible.sync='dialogTableVisible')
              el-table(:data='gridData')
                el-table-column(property='date' label='Date' width='150')
                el-table-column(property='name' label='Name' width='200')
                el-table-column(property='address' label='Address')
            br
            br
            // Form
            el-button(:plain='true' @click='dialogFormVisible = true') open a Form nested Dialog
            el-dialog(title='Shipping address' :visible.sync='dialogFormVisible')
              el-form(:model='form')
                el-form-item(label='Promotion name' :label-width='formLabelWidth')
                  el-input(v-model='form.name' auto-complete='off')
                el-form-item(label='Zones' :label-width='formLabelWidth')
                  el-select(v-model='form.region' placeholder='Please select a zone')
                    el-option(label='Zone No.1' value='shanghai')
                    el-option(label='Zone No.2' value='beijing')
              span.dialog-footer(slot='footer')
                el-button(@click='dialogFormVisible = false') Cancel
                el-button(type='primary' @click='dialogFormVisible = false') Confirm
            br
            br
            hr
            h5 Message
            p
              | Used to show feedback after an activity. The difference with Notification
              br
              |  is that the latter is often used to show a system level passive notification.
            el-button(:plain='true' @click='open5') message
            el-button(:plain='true' @click='open6') success
            el-button(:plain='true' @click='open7') warning
            el-button(:plain='true' @click='open8') error
      // /.content

</template>
<script>
  export default {
    data: function () {
      return {
        gridData: [{
          date: '2016-05-02',
          name: 'John Smith',
          address: 'No.1518,  Jinshajiang Road, Putuo District'
        }, {
          date: '2016-05-04',
          name: 'John Smith',
          address: 'No.1518,  Jinshajiang Road, Putuo District'
        }, {
          date: '2016-05-01',
          name: 'John Smith',
          address: 'No.1518,  Jinshajiang Road, Putuo District'
        }, {
          date: '2016-05-03',
          name: 'John Smith',
          address: 'No.1518,  Jinshajiang Road, Putuo District'
        }],
        dialogTableVisible: false,
        dialogFormVisible: false,
        form: {
          name: '',
          region: '',
          date1: '',
          date2: '',
          delivery: false,
          type: [],
          resource: '',
          desc: ''
        },
        formLabelWidth: '120px'
      }
    }
  }
</script>
