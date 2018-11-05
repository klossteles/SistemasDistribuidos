<template lang="pug">
  transition(name='el-zoom-in-top')
    .content-wrapper.dashboard-wrapper
      // Main content
      section.content
        .row
          .col-md-3
            // New User
            .box.palette-Pink-300.bg
              .box-header.palette-Pink-300.bg
                // tools box
                .pull-right.text-white.box-tools
                  span.text-white.box-btn
                    i.circle-nest-medium.ti-user
                h3.box-title
                  span.text-white &nbsp;&nbsp;&nbsp;NEW USER
              // /.box-header
              .box-body.no-pad(style='display: block;')
                .events-nest
                  .wrap-no-pad.text-white
                    bars(:data='[1, 2, 5, 9, 5, 10, 3, 5, 2, 5, 1, 8, 2, 9, 0]' :gradient="['#ffffff', '#ffffff']")
                    h1.text-white
                      strong
                        animate-number(from='1' to='45' duration='9000' easing='easeOutQuad' :formatter='formatter')
                    span Active Users
                    p 65%
                    br
              // /.box-body
            // end of New User
          .col-md-3
            // facebook
            .box.palette-Cyan-400.bg
              .box-header.palette-Cyan-400.bg
                // tools box
                .pull-right.text-white.box-tools
                  span.text-white.box-btn
                    i.circle-nest-medium.ti-stats-up
                h3.box-title
                  span.text-white &nbsp;&nbsp;&nbsp;PAGE VIEWS
              // /.box-header
              .box-body.no-pad(style='display: block;')
                .events-nest
                  .wrap-no-pad.text-white
                    bars(:data='[1, 2, 5, 9, 5, 10, 3, 5, 2, 5, 1, 8, 2, 9, 0]' :gradient="['#ffffff', '#ffffff']")
                    h1.text-white
                      strong
                        animate-number(from='45575' to='744' duration='9000' easing='easeOutQuad' :formatter='formatter')
                    span PerWeek Views
                    p 65%
                    br
              // /.box-body
            // end of facebook
          .col-md-3
            // facebook
            .box.palette-Deep-Purple-300.bg
              .box-header.palette-Deep-Purple-300.bg
                // tools box
                .pull-right.text-white.box-tools
                  span.text-white.box-btn
                    i.circle-nest-medium.dripicons-wallet
                h3.box-title
                  span.text-white &nbsp;&nbsp;&nbsp;DAILY SALES
              // /.box-header
              .box-body.no-pad(style='display: block;')
                .events-nest
                  .wrap-no-pad.text-white
                    bars(:data='[1, 2, 5, 9, 5, 10, 3, 5, 2, 5, 1, 8, 2, 9, 0]' :gradient="['#ffffff', '#ffffff']")
                    h1.text-white
                      strong
                        animate-number(from='0' to='13' duration='9000' easing='easeOutQuad' :formatter='formatter')
                    span Sales
                    p 15%
                    br
              // /.box-body
            // end of facebook
          .col-md-3
            // facebook
            .box.palette-Indigo-900.bg
              .box-header.palette-Indigo-900.bg
                // tools box
                .pull-right.text-white.box-tools
                  span.text-white.box-btn
                    i.circle-nest-medium.dripicons-basket
                h3.box-title
                  span.text-white &nbsp;&nbsp;&nbsp;TOTAL EARNINGS
              // /.box-header
              .box-body.no-pad(style='display: block;')
                .events-nest
                  .wrap-no-pad.text-white
                    bars(:data='[1, 2, 5, 9, 5, 10, 3, 5, 2, 5, 1, 8, 2, 9, 0]' :gradient="['#ffffff', '#ffffff']")
                    h1.text-white
                      strong
                        animate-number(from='1' to='3500' duration='9000' easing='easeOutQuad' :formatter='formatter')
                    span Dollars
                    p
                      animate-number(from='1' to='65' duration='9000' easing='easeOutQuad' :formatter='formatter')
                      | %
                    br
              // /.box-body
            // end of facebook
        .row
          .col-md-6
            .box.no-shadow
              // /.box-header
              .box-body(style='padding:0')
                .events-nest
                  .text-white.lastest-post-nest.palette-Blue-800.bg
                    .wrap
                      small.palette-Blue-400.bg
                        i.ti-facebook
                      .row
                        .col-md-2
                          h1.text-white
                            img.img-circle.palette-Grey-900.bg(alt='profile' src='http://api.randomuser.me/portraits/thumb/men/46.jpg')
                        .col-md-9
                          h3 D&apos;Agustino Gavin
                          p Pink and Blue: Coloring Inside the Lines of Gender
                          p
                            el-rate(v-model='value1')
                          b
                            i.ti-eye
                            |  121
                          b
                            i.ti-thumb-up
                            | 45
                          b
                            i.ti-comment-alt
                            |  8
              // /.box-body
          .col-md-6
            .box.no-shadow
              // /.box-header
              .box-body(style='padding:0')
                .events-nest
                  .text-white.lastest-post-nest-two.palette-Deep-Purple-500.bg
                    .wrap
                      small.palette-Blue-800.bg
                        i.ti-twitter-alt
                      .row
                        .col-md-2
                          h1.text-white
                            img.img-circle.palette-Grey-900.bg(alt='profile' src='http://api.randomuser.me/portraits/thumb/women/26.jpg')
                        .col-md-9
                          h3 Dewi Saraswati
                          p Pink and Blue: Coloring Inside the Lines of Gender
                          p
                            el-rate(v-model='value1')
                          b
                            i.ti-eye
                            |  121
                          b
                            i.ti-thumb-up
                            | 45
                          b
                            i.ti-comment-alt
                            |  8
              // /.box-body
        .row
          .col-md-6
            .box.box-no-shadow
              // /.box-header
              .box-body(style='display: block;')
                .row.summary-border-top(style='margin:0')
                  .col-md-6
                    .summary-nest
                      h2.text-black
                        span.counter-up 276.747
                        small.palette-Orange-700.bg K
                      p Sales
                  .col-md-6.summary-border-left
                    .summary-nest
                      h2.text-black
                        span.counter-up 3.219
                        small.palette-Pink-500.bg K
                      p Man
                .row(style='margin:0')
                  .col-md-12
                    .summary-nest.summary-pad-nest
                      bars(:data='[1, 2, 5, 9, 5, 10, 3, 5, 2, 5, 1, 8, 2, 9, 4]' :gradient="['#3b5998', '#3b5998']")
                      h4.text-center
                        span.counter-up 5
                        | /
                        span.counter-up 12
                        | /
                        span.counter-up 2013
                .row.summary-border-bottom(style='margin:0')
                  .col-md-6
                    .summary-nest.summary-pad-nest
                      h2.text-black
                        span.counter-up 82
                        small.palette-Lime-500.bg %
                      p Avarage Sales
                  .col-md-6.summary-border-left
                    .summary-nest.summary-pad-nest
                      h2.text-black
                        span.counter-up 24
                        small.palette-Teal-500.bg th
                      p Overall Rank
              // end .timeline
          .col-md-6
            .box.box-no-shadow.bg-widget-random
              // /.box-header
              .box-header.bg-transparent
                h3.box-title
                  i.text-white.ti-rss-alt
                  span.text-white LASTEST REPORT
              .box-body(style='margin:15px 0 0')
                .stats-wrap
                  h2
                    b.counter-up.text-white 65,800,587
                    span(style='background:#666;')
                      | +
                      b.counter-up 20
                      | %
                  p.text-grey
                    | Total students
                    small This Year
                  h4
                    b.counter-up.text-white 1,204
                    span(style='background:#888;')
                      | +
                      b.counter-up 5
                      | %
                  p
                    | Graduate
                    small This week
                  h4.text-white
                    b.counter-up 2,690
                    span
                      | +
                      b.counter-up 125
                  p
                    | New students
                    small This Month
                  .your-account
                    h4 Overall stats of sales and distribution
                    h6
                      | You must
                      strong complete
                      |  this issues.
                    ul
                      li
                        i.text-white.palette-Orange-700.bg.ti-pie-chart
                        |  2.789
                      li
                        i.text-white.palette-Pink-700.bg.ti-stats-down
                        | 4.365
                      li
                        i.palette-Cyan-700.bg.text-white.ti-bar-chart
                        | 9.860
              // /.box-body
        .row
          .col-md-12
      // /.content

</template>
<script>
  export default {
    name: 'dashboard-first'
  }
</script>
