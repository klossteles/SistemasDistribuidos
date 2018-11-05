<template lang="pug">
  transition(name='el-zoom-in-top')
    .content-wrapper
      // Content Header (Page header)
      section.content-header
        h1
          | Forms Checkbox
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
          li.active Checkbox
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
            h5 Basic usage
            p
              | Checkbox can be used alone to switch between two states. Disabled state for checkbox
            el-checkbox(v-model='checked') Option
            el-checkbox(v-model='checked1' disabled='') Option
            el-checkbox(v-model='checked2' disabled='') Option
            hr
            h5 Checkbox group
            p
              | It is used for multiple checkboxes which are bound in one group, and indicates whether one option is selected by checking if it is checked.
            br
            el-checkbox-group(v-model='checkList')
              el-checkbox(label='Option A')
              el-checkbox(label='Option B')
              el-checkbox(label='Option C')
              el-checkbox(label='disabled' disabled='')
              el-checkbox(label='selected and disabled' disabled='')
          // /.box-body
        // /.box
      // /.content
</template>

<script>
  export default {
    name: 'FormCheckbox',
    data () {
      return {
        checked: true,
        checked1: false,
        checked2: true
      }
    }
  }
</script>
