<template lang="pug">
  transition(name='el-zoom-in-top')
    .content-wrapper
      // Content Header (Page header)
      section.content-header
        h1
          | Select Table
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
          li.active Select Table
      // Main content
      section.content
        // Basic Tables
        .box
          .box-header.with-border
            h3.box-title Single select
            .box-tools.pull-right
              button.btn.btn-box-tool(type='button' data-widget='collapse' data-toggle='tooltip' title='Collapse')
                i.ti-minus
              button.btn.btn-box-tool(type='button' data-widget='remove' data-toggle='tooltip' title='Remove')
                i.ti-close
          .box-body(style='min-height:400px;')
            el-table(ref='singleTable' :data='tableData' highlight-current-row='' @current-change='handleCurrentChange' style='width: 100%')
              el-table-column(type='index' width='50')
              el-table-column(property='date' label='Date' width='120')
              el-table-column(property='name' label='Name' width='120')
              el-table-column(property='address' label='Address')
            div(style='margin-top: 20px')
              el-button(@click='setCurrent(tableData[1])') Select second row
              el-button(@click='setCurrent()') Clear selection
        // End of Basic Tables
        // Multiple select
        .box
          .box-header.with-border
            h3.box-title Multiple Select
            .box-tools.pull-right
              button.btn.btn-box-tool(type='button' data-widget='collapse' data-toggle='tooltip' title='Collapse')
                i.ti-minus
              button.btn.btn-box-tool(type='button' data-widget='remove' data-toggle='tooltip' title='Remove')
                i.ti-close
          .box-body(style='min-height:400px;')
            el-table(ref='multipleTable' :data='tableData3' border='' style='width: 100%' @selection-change='handleSelectionChange')
              el-table-column(type='selection' width='55')
              el-table-column(label='Date' width='120')
                template(scope='scope') {{ scope.row.date }}
              el-table-column(property='name' label='Name' width='120')
              el-table-column(property='address' label='Address' show-overflow-tooltip='')
            div(style='margin-top: 20px')
              el-button(@click='toggleSelection([tableData3[1], tableData3[2]])') Toggle selection status of second and third rows
              el-button(@click='toggleSelection()') Clear selection
        // End of Multiple select
      // /.content

</template>
<script>
    export default {
      name: 'SelectTable',
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
          }],
          tableData3: [{
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
            date: '2016-05-01',
            name: 'Tom',
            address: 'No. 189, Grove St, Los Angeles'
          }, {
            date: '2016-05-08',
            name: 'Tom',
            address: 'No. 189, Grove St, Los Angeles'
          }, {
            date: '2016-05-06',
            name: 'Tom',
            address: 'No. 189, Grove St, Los Angeles'
          }, {
            date: '2016-05-07',
            name: 'Tom',
            address: 'No. 189, Grove St, Los Angeles'
          }],
          currentRow: null,
          multipleSelection: []
        }
      },

      methods: {
        setCurrent: function (row) {
          this.$refs.singleTable.setCurrentRow(row)
        },
        handleCurrentChange: function (val) {
          this.currentRow = val
        },
        // multiselect
        toggleSelection: function (rows) {
          if (rows) {
            rows.forEach(row => {
              this.$refs.multipleTable.toggleRowSelection(row)
            })
          } else {
            this.$refs.multipleTable.clearSelection()
          }
        },
        handleSelectionChange: function (val) {
          this.multipleSelection = val
        }
      }
    }
</script>
