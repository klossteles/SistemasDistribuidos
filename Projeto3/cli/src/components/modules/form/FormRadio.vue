<template lang="pug">
  transition(name='el-zoom-in-top')
    .content-wrapper
      // Content Header (Page header)
      section.content-header
        h1
          | Forms Radio
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
          li.active Radio
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
              | Radio should not have too many options. Otherwise, use the Select component instead.
            hr
            el-radio.radio(v-model='radio' label='1') optionA
            el-radio.radio(v-model='radio' label='2') optionB
            br
            hr
            br
            el-radio-group(v-model='radio3')
              el-radio-button(label='New York')
              el-radio-button(label='Washington')
              el-radio-button(label='Los Angeles')
              el-radio-button(label='Chicago')
            div(style='margin: 15px 0;')
            hr
            el-radio-group(v-model='radio4')
              el-radio-button(label='New York')
              el-radio-button(label='Washington' :disabled='true')
              el-radio-button(label='Los Angeles')
              el-radio-button(label='Chicago')
            div(style='margin: 15px 0;')
            hr
            el-radio-group(v-model='radio5' :disabled='true')
              el-radio-button(label='New York')
              el-radio-button(label='Washington')
              el-radio-button(label='Los Angeles')
              el-radio-button(label='Chicago')
          // /.box-body
        // /.box
      // /.content

</template>

<script>
  export default {
    name: 'FormRadio',
    data () {
      return {
        radio: '1',
        radio3: 'New York',
        radio4: 'New York',
        radio5: 'New York'
      }
    }
  }
</script>
