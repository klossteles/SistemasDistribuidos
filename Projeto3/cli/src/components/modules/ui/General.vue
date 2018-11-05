<template lang="pug">
  transition(name='el-zoom-in-top')
    .content-wrapper
      // Content Header (Page header)
      section.content-header
        h1
          | General Page
          small
            i.ti-heart
            i.ti-export
            i.ti-printer
        ol.breadcrumb
          li
            router-link(to='/')
              i.ti-home
          li
            a(href='#') Apps
          li.active General Page
      // Main content
      section.content
        // Layout
        .box
          .box-header.with-border
            h3.box-title Basic layout
            .box-tools.pull-right
              button.btn.btn-box-tool(type='button' data-widget='collapse' data-toggle='tooltip' title='Collapse')
                i.ti-minus
              button.btn.btn-box-tool(type='button' data-widget='remove' data-toggle='tooltip' title='Remove')
                i.ti-close
          .box-body(style='min-height:400px;')
            h4 Basic usage
            p
              | Quickly and easily create layouts with the basic 24-column. Create basic grid layout using columns.
            p
              | With
              code row
              |  and
              code col
              | , we can easily manipulate the layout using the
              code span
              |  attribute.
            el-row
              el-col(:span='24')
                .grid-content.bg-purple-dark
            el-row
              el-col(:span='12')
                .grid-content.bg-purple
              el-col(:span='12')
                .grid-content.bg-purple-light
            el-row
              el-col(:span='8')
                .grid-content.bg-purple
              el-col(:span='8')
                .grid-content.bg-purple-light
              el-col(:span='8')
                .grid-content.bg-purple
            el-row
              el-col(:span='6')
                .grid-content.bg-purple
              el-col(:span='6')
                .grid-content.bg-purple-light
              el-col(:span='6')
                .grid-content.bg-purple
              el-col(:span='6')
                .grid-content.bg-purple-light
            el-row
              el-col(:span='4')
                .grid-content.bg-purple
              el-col(:span='4')
                .grid-content.bg-purple-light
              el-col(:span='4')
                .grid-content.bg-purple
              el-col(:span='4')
                .grid-content.bg-purple-light
              el-col(:span='4')
                .grid-content.bg-purple
              el-col(:span='4')
                .grid-content.bg-purple-light
            hr
            h5 Column Spacing
            p
              | Row provides
              code gutter
              |  attribute to specify spacings between columns, and its default value is 0.
            el-row(:gutter='20')
              el-col(:span='6')
                .grid-content.bg-purple
              el-col(:span='6')
                .grid-content.bg-purple
              el-col(:span='6')
                .grid-content.bg-purple
              el-col(:span='6')
                .grid-content.bg-purple
        // End of Layout
        // Color
        .box
          .box-header.with-border
            h3.box-title Alert
            .box-tools.pull-right
              button.btn.btn-box-tool(type='button' data-widget='collapse' data-toggle='tooltip' title='Collapse')
                i.ti-minus
              button.btn.btn-box-tool(type='button' data-widget='remove' data-toggle='tooltip' title='Remove')
                i.ti-close
          .box-body
            h4 Alert
            p
              | Alert components are non-overlay elements in the page that does not disappear automatically.
            br
            el-alert(title='success alert' type='success' show-icon='')
            br
            el-alert(title='info alert' type='info' show-icon='')
            br
            el-alert(title='warning alert' type='warning' show-icon='')
            br
            el-alert(title='error alert' type='error' show-icon='')
            hr
            h4 Customizable close button
            p Customize the close button as texts or other symbols.
            el-alert(title='unclosable alert' type='success' :closable='false')
            br
            el-alert(title='customized close-text' type='info' close-text='Gotcha')
            br
            el-alert(title='alert with callback' type='warning' @close='hello')
            hr
            h3 With icon and description
            p Description includes a message with more detailed information.
            el-alert(title='success alert' type='success' description='more text description' show-icon='')
            br
            el-alert(title='info alert' type='info' description='more text description' show-icon='')
            br
            el-alert(title='warning alert' type='warning' description='more text description' show-icon='')
            br
            el-alert(title='error alert' type='error' description='more text description' show-icon='')
        // end of Color
        // Typhography
        .box
          .box-header.with-border
            h3.box-title Typography
            .box-tools.pull-right
              button.btn.btn-box-tool(type='button' data-widget='collapse' data-toggle='tooltip' title='Collapse')
                i.ti-minus
              button.btn.btn-box-tool(type='button' data-widget='remove' data-toggle='tooltip' title='Remove')
                i.ti-close
          .box-body
            el-row(gutter='20')
              el-col(:span='6')
                h3
                  strong Heading
              el-col(:span='18')
                h1 h1. This is a very large header.
                h2 h2. This is a large header.
                h3 h3. This is a medium header.
                h4 h4. This is a moderate header.
                h5 h5. This is a small header.
                h6 h6. This is a tiny header.
            hr
            el-row(gutter='20')
              el-col(:span='6')
                p
                  strong Blockquote
              el-col(:span='18')
                blockquote
                  | Those people who think they know everything are a great annoyance to those of us who do.
                  cite Isaac Asimov
            hr
            el-row(gutter='20')
              el-col(:span='6')
                p
                  strong Code
              el-col(:span='18')
                code
                  | Those people who think they know everything are a great annoyance to those of us who do.
        // End of Typhography
      // /.content

</template>
<script>
  export default {
    name: 'GeneralPage'
  }
</script>
<style>
    .el-row {
        margin-bottom: 20px;
        &:last-child {
            margin-bottom: 0;
        }
    }

    .el-col {
        border-radius: 0!important;
    }

    .bg-purple-dark {
        background: #ddd;
    }

    .bg-purple {
        background: #ccc;
    }

    .bg-purple-light {
        background: #eee;
    }

    .grid-content {
        border-radius: 0;
        min-height: 36px;
    }

    .row-bg {
        padding: 15px 0;
        background-color: #ccc;
    }
</style>
