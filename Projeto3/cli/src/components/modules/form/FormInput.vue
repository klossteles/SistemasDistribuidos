<template lang="pug">
  transition(name='el-zoom-in-center')
    .content-wrapper
      // Content Header (Page header)
      section.content-header
        h1
          | Forms Input
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
          li.active Input
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
            h4 Basic
            el-input(placeholder='Please input' v-model='input')
            hr
            h4 Disabled
            p
              | Disable the Input with the
              code disabled
              |  attribute.
            el-input(placeholder='Please input' v-model='input1' :disabled='true')
            hr
            h4 Input with Icon
            p
              | You can add an icon at the end of Input by setting the
              code icon
              |  attribute and use
              code on-icon-click
              |  hook to complete some work after clicking the icon.
            el-input(placeholder='Pick a date' icon='search' v-model='input2' :on-icon-click='handleIconClick')
            hr
            h4 Text Area
            p
              | Resizable for entering multiple lines of text information. Add attribute
              code type=&quot;textarea&quot;
              |  to change
              code input
              |  into native
              code textarea
              | .
            p
              | Control the height by setting the
              code rows
              |  prop.
            el-input(type='textarea' :rows='4' placeholder='Please input' v-model='textarea')
            hr
            h4 Mixed input
            p Prepend or append an element, generally a label or a button.
            div
              el-input(placeholder='Please input' v-model='input3')
                template(slot='prepend') Http://
            div(style='margin-top: 15px;')
              el-input(placeholder='Please input' v-model='input4')
                template(slot='append') .com
            div(style='margin-top: 15px;')
              el-input(placeholder='Please input' v-model='input5')
                el-select(v-model='select' slot='prepend' placeholder='Select')
                  el-option(label='Restaurant' value='1')
                  el-option(label='Order No.' value='2')
                  el-option(label='Tel' value='3')
                el-button(slot='append' icon='search')
            hr
          // /.box-body
        // /.box
        // Default box
        .box
          .box-header
            .box-tools.pull-right
              button.btn.btn-box-tool(type='button' data-widget='collapse' data-toggle='tooltip' title='Collapse')
                i.ti-minus
              button.btn.btn-box-tool(type='button' data-widget='remove' data-toggle='tooltip' title='Remove')
                i.ti-close
          .box-body
            h4 Input Number
            p
            p
              | Bind a variable to
              code v-model
              |  in
              code &lt;el-input-number&gt;
              |  element and you are set.
            p
            el-input-number(v-model='num1' @change='handleChange' :min='1' :max='10')
            el-input-number(v-model='num3' :step='2')
          // /.box-body
      // /.content

</template>
<script>
  export default {
    name: 'FormInput',
    data () {
      return {
        input: '',
        num1: 1
      }
    }
  }
</script>
