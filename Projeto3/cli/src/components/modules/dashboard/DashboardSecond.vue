<template lang="pug">
  transition(name='el-zoom-in-top')
    .content-wrapper.dashboard-wrapper
      // Main content
      section.content
        // end of New User
        .row
          .col-md-4.col-xl-4
            .box
              // /.box-header
              .box-body.no-pad.padding-fifthin(style='display: block;')
                .events-nest
                  .wrap-no-pad.padding-fifthin
                    .row
                      .col-sm-6.bor-right.bor-bottom
                        .devin-table-dash.centered.pad-box
                          i.palette-Pink-500.bg.ti-shopping-cart-full
                          .palette-Pink-500.text.value 648
                          .label Items Sold
                      .col-sm-6.bor-bottom
                        .devin-table-dash.centered.pad-box
                          i.palette-Purple-500.bg.ti-link
                          .palette-Purple-500.text.value
                            | 47.5
                            strong K
                          .label Followers
                    .row
                      .col-sm-6.bor-right
                        .devin-table-dash.centered.pad-box
                          i.palette-Deep-Purple-500.bg.ti-wallet
                          .value.palette-Deep-Purple-500.text
                            strong $
                            | 764
                          .label Daily Earnings
                      .col-sm-6
                        .devin-table-dash.centered.pad-box
                          i.ti-bag.palette-Light-Blue-500.bg
                          .value.palette-Light-Blue-500.text 256
                          .label Products
          .col-md-4.col-xl-4
            .box
              // /.box-header
              .box-body.no-pad.padding-fifthin(style='display: block;')
                .events-nest
                  .wrap-no-pad.padding-fifthin
                    .pad-box
                      .devin-table-dash.bigger
                        .value 3059
                        .trending.trending-up.palette-Amber-500.bg
                          span 15%
                        .label Products Sold
                      hr
                      br
                      .el-chart-w
                        bars(:data='[1, 2, 5, 9, 5, 10, 3, 5, 2, 5, 1, 8, 2, 9, 10, 0]' :gradient="['#3bd6c6', '#3b5998']")
                      br
          .col-md-4.col-xl-4
            .box
              // /.box-header
              .box-body.no-pad.padding-fifthin(style='display: block;')
                .events-nest
                  .wrap-no-pad.padding-fifthin
                    .pad-box
                      .element-info-with-icon.smaller
                        .element-info-text
                          h5 Monthly Revenue
                          div Calculated every month
                      .devin-progress-bar
                        el-progress.circle-one(type='circle' :percentage='63' :width='50' :stroke-width='2' status='success')
                        el-progress.bor-left.bor-right(style='padding: 0 10px;' type='circle' :percentage='75' :width='125' :stroke-width='6')
                        el-progress.circle-two(type='circle' :percentage='89' :width='50' :stroke-width='2' status='exception')
                      .os-progress-bar.primary
        // Second
        .row
          .col-md-6.col-xl-6
            .food
              .cover(style='background-image: url(https://source.unsplash.com/category/food/800x600)')
                label
                  i.ti-medall-alt
                  font CULINARY
                a.download(href='#')
                  i.ti-truck
              .info
                a.recipe(href='#')
                  i.ti-pencil-alt
                  font
                    h3 76.5%
                .content-food
                  ul
                    li
                      strong Sweetness
                      el-progress(:text-inside='true' :stroke-width='15' :percentage='85')
                    li
                      strong Acidity
                      el-progress(:text-inside='true' :stroke-width='15' :percentage='60')
          // widget two
          .col-md-6.col-xl-6
            .container-widget-two
              .widget-two
                .section.section-graph
                  .graph-info
                    i.ti-home
                    span.graph-info-big 454.757
                    span.graph-info-small +5.78 (5.71%)
                  #graph
                    bars(:data='[1, 2, 5, 9, 5, 10, 3, 5, 2, 5, 1, 8, 2, 9, 10, 8, 9, 5, 9 ]' :gradient="['#ffffff', '#ffffff']")
                .section.section-info
                  span.info-time Today 2:25 PM
                  h3.info-title Salt Lake City, Utah
                  .info-block
                    dl
                      dt
                        i.ti-stats-up
                      dt 13.5 M
                      dd Shares Traded
                  .info-block.last
                    dl
                      dt
                        i.ti-stats-down
                      dt 28.44
                      dd Market Cap
                .section
        br
        // Third
        .row
          .col-md-7.col-xl-7.col-sm-12
            #weather
              .panelLeft
                .top-cal-devin
                  p JUNY 21, 2017
                img(src='https://source.unsplash.com/collection/431862/800x600' alt='')
                .bottom
                  .temp
                    p 10&deg;
                    p New York City
              .panelRight
                .customHeight
                  p Statistics
                  hr
                  ul
                    li
                      i.wi.wi-thermometer
                      p 35%
                    li
                      i.wi.wi-day-rain-mix
                      p Easterly
                    li
                      i.wi.wi-cloudy-gusts
                      p 7 mph
                .remainingHeight
                  ul.inline
                    li.active Today
                    li Week
                  ul.forecast
                    li
                      span.time Now
                      span.temp 24&deg;C
                      span.conditions Cloudy
                    li
                      span.time 6 AM
                      span.temp 23&deg;C
                      span.conditions Cloudy
                    li
                      span.time 6:59 AM
                      span.temp Sunrise
                      span.conditions Cloudy
                    li
                      span.time 7 AM
                      span.temp 24&deg;C
                      span.conditions Partly Cloudy
          .col-md-5.col-xl-5.col-sm-12
            .widget
              .widget__header
                h2.widget__header-title
                  | DNTM
                  span.widget__header-author
                    | by Abine
                .nav
                  a.nav__item(href='#')
                    i.fa.fa-cubes
                  a.nav__item(href='#')
                    i.fa.fa-check-circle-o
                  a.nav__item(href='#')
                    i.fa.fa-gear
              .widget__body
                .flash
                  strong All 6
                  |  companies blocked now
                .accordion
                  .accordion__item
                    .accordion__header
                      i.fa.fa-minus.accordion__state-icon
                      h2 Social Networks
                    .accordion__body
                      .accordion__body-item
                        i.fa.ti-facebook
                        |  Facebook
                      .accordion__body-item
                        i.fa.ti-twitter
                        |  Twitter
                      .accordion__body-item
                        i.fa.ti-instagram
                        |  Instagram
        br
        br
        br
      // /.content
</template>
<script>
  export default {
    name: 'DashboardSecond'
  }
</script>
<style>
    .padding-fifthin{
            padding: 15px!important;
    }
</style>
