<template lang="pug">
  transition(name='el-zoom-in-top')
    .content-wrapper
      // Content Header (Page header)
      section.content-header
        h1
          | Expandable Table
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
          li.active Expandable Table
      // Main content
      section.content
        // Expandable Table
        .box
          .box-header.with-border
            h3.box-title Expandable Table
            .box-tools.pull-right
              button.btn.btn-box-tool(type='button' data-widget='collapse' data-toggle='tooltip' title='Collapse')
                i.ti-minus
              button.btn.btn-box-tool(type='button' data-widget='remove' data-toggle='tooltip' title='Remove')
                i.ti-close
          .box-body
            el-table(:data='tableData3' style='width: 100%')
              el-table-column(type='expand')
                template(scope='props')
                  p State: {{ props.row.state }}
                  p City: {{ props.row.city }}
                  p Address: {{ props.row.address }}
                  p Zip: {{ props.row.zip }}
              el-table-column(label='Date' prop='date')
              el-table-column(label='Name' prop='name')
        // End of Expandable Table
        // Expandable Table
        .box
          .box-header.with-border
            h3.box-title Sorting Table
            .box-tools.pull-right
              button.btn.btn-box-tool(type='button' data-widget='collapse' data-toggle='tooltip' title='Collapse')
                i.ti-minus
              button.btn.btn-box-tool(type='button' data-widget='remove' data-toggle='tooltip' title='Remove')
                i.ti-close
          .box-body
            el-table(:data='tableData' border='' :default-sort="{prop: 'date', order: 'descending'}" style='width: 100%')
              el-table-column(prop='date' label='Date' sortable='' width='180')
              el-table-column(prop='name' label='Name' width='180')
              el-table-column(prop='address' label='Address' :formatter='formatter')
        // End of Expandable Table
      // /.content

</template>
<script>
    export default {
      name: 'SelectTable',
      data: function () {
        return {
          tableData3: [{
            date: '2016-05-03',
            name: 'Tom',
            state: 'California',
            city: 'Los Angeles',
            address: 'No. 189, Grove St, Los Angeles',
            zip: 'CA 90036'
          }, {
            date: '2016-05-02',
            name: 'Tom',
            state: 'California',
            city: 'Los Angeles',
            address: 'No. 189, Grove St, Los Angeles',
            zip: 'CA 90036'
          }, {
            date: '2016-05-04',
            name: 'Tom',
            state: 'California',
            city: 'Los Angeles',
            address: 'No. 189, Grove St, Los Angeles',
            zip: 'CA 90036'
          }, {
            date: '2016-05-01',
            name: 'Tom',
            state: 'California',
            city: 'Los Angeles',
            address: 'No. 189, Grove St, Los Angeles',
            zip: 'CA 90036'
          }, {
            date: '2016-05-08',
            name: 'Tom',
            state: 'California',
            city: 'Los Angeles',
            address: 'No. 189, Grove St, Los Angeles',
            zip: 'CA 90036'
          }, {
            date: '2016-05-06',
            name: 'Tom',
            state: 'California',
            city: 'Los Angeles',
            address: 'No. 189, Grove St, Los Angeles',
            zip: 'CA 90036'
          }, {
            date: '2016-05-07',
            name: 'Tom',
            state: 'California',
            city: 'Los Angeles',
            address: 'No. 189, Grove St, Los Angeles',
            zip: 'CA 90036'
          }],
          tableData: [{
            date: '2016-05-03',
            name: 'Agus',
            address: 'Los Angeles'
          }, {
            date: '2016-05-02',
            name: 'Yudha',
            address: 'New York'
          }, {
            date: '2016-05-04',
            name: 'Ucil',
            address: 'Texas'
          }, {
            date: '2016-05-01',
            name: 'Jhonny',
            address: 'Alaska'
          }]
        }
      }
    }
</script>
