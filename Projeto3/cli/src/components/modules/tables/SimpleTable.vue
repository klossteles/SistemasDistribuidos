<template lang="pug">
  transition(name='el-zoom-in-top')
    .content-wrapper
      // Content Header (Page header)
      section.content-header
        h1
          | Simple Table
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
            a(href='#') Table
          li.active Simple Table
      // Main content
      section.content
        // Basic Tables
        .box
          .box-header.with-border
            h3.box-title Basic Tables
            .box-tools.pull-right
              button.btn.btn-box-tool(type='button' data-widget='collapse' data-toggle='tooltip' title='Collapse')
                i.ti-minus
              button.btn.btn-box-tool(type='button' data-widget='remove' data-toggle='tooltip' title='Remove')
                i.ti-close
          .box-body
            el-table(:data='tableData' style='width: 100%')
              el-table-column(prop='date' label='Date' width='180')
              el-table-column(prop='name' label='Name' width='180')
              el-table-column(prop='address' label='Address')
        // End of Basic Tables
        // Striped Table
        .box
          .box-header.with-border
            h3.box-title Striped Table
            .box-tools.pull-right
              button.btn.btn-box-tool(type='button' data-widget='collapse' data-toggle='tooltip' title='Collapse')
                i.ti-minus
              button.btn.btn-box-tool(type='button' data-widget='remove' data-toggle='tooltip' title='Remove')
                i.ti-close
          .box-body
            el-table(:data='tableData' stripe='' style='width: 100%')
              el-table-column(prop='date' label='Date' width='180')
              el-table-column(prop='name' label='Name' width='180')
              el-table-column(prop='address' label='Address')
        // End of Striped Table
        // Striped Table
        .box
          .box-header.with-border
            h3.box-title Table with fixed header
            .box-tools.pull-right
              button.btn.btn-box-tool(type='button' data-widget='collapse' data-toggle='tooltip' title='Collapse')
                i.ti-minus
              button.btn.btn-box-tool(type='button' data-widget='remove' data-toggle='tooltip' title='Remove')
                i.ti-close
          .box-body
            el-table(:data='tableData' height='250' border='' style='width: 100%')
              el-table-column(prop='date' label='Date' width='180')
              el-table-column(prop='name' label='Name' width='180')
              el-table-column(prop='address' label='Address')
        // End of Striped Table
      // /.content

</template>
<script>
    export default {
      name: 'SimpleTable',
      data: function () {
        return {
          tableData: [{
            date: '2016-05-03',
            name: 'Tom',
            address: 'No. 189, Grove St, Los Angeles'
          }, {
            date: '2016-05-02',
            name: 'Tom',
            address: 'No. 189, Grove St, Los Angeles'
          }, {
            date: '2016-05-04',
            name: 'Tom',
            address: 'No. 189, Grove St, Los Angeles'
          }, {
            date: '2016-05-04',
            name: 'Tom',
            address: 'No. 189, Grove St, Los Angeles'
          }, {
            date: '2016-05-04',
            name: 'Tom',
            address: 'No. 189, Grove St, Los Angeles'
          }, {
            date: '2016-05-01',
            name: 'Tom',
            address: 'No. 189, Grove St, Los Angeles'
          }]
        }
      }
    }
</script>
