<template lang="pug">
  transition(name='el-zoom-in-top')
    .content-wrapper
      // Content Header (Page header)
      section.content-header
        h1
          | Shop Page
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
          li.active Shop Page
      // Main content
      section.content
        .box(style='padding:30px;')
          .row
            .col-md-12
              // TABS
              ul.nav.nav-tabs.nav-tabs-shop-devin(role='tablist')
                li(data-wow-delay='0.6s')
                  a(href='#featured' data-toggle='tab' aria-expanded='false') featured
                li.active(data-wow-delay='0.4s')
                  a(href='#best' data-toggle='tab' aria-expanded='true') bestsellers
                li(data-wow-delay='0.2s')
                  a(href='#new' data-toggle='tab' aria-expanded='false') new
              .tab-content
                // TAB PANEL ITEM
                #featured.tab-pane.fade(role='tabpanel')
                  .row
                    // PRODUCT SINGLE
                    .col-md-3.col-sm-6
                      .product-item
                        .product-item-thumbnail.text-center.mb-15
                          a.product-item-thumbnail-link(href='#')
                          span.product-item-thumbnail-label new
                          img.img-responsive(src='http://thymetheme.pl/vega/v102/assets/img/products/product-01.jpg' alt='product image')
                          .product-item-thumbnail-overlay
                            a.btn.btn-default.pulse(href='#')
                              span.ti-heart.mr-0
                            a.btn.btn-primary(href='#') add to cart
                        .row
                          .col-xs-6
                            a.h5(href='#') Product name
                          .col-xs-6.text-right
                            del.h5.text-muted.product-item-price-old $99.00
                            span.h5.product-item-price $49.00
                    // / PRODUCT SINGLE
                    // PRODUCT SINGLE
                    .col-md-3.col-sm-6
                      .product-item
                        .product-item-thumbnail.text-center.mb-15
                          a.product-item-thumbnail-link(href='#')
                          span.product-item-thumbnail-label new
                          img.img-responsive(src='http://thymetheme.pl/vega/v102/assets/img/products/product-01.jpg' alt='product image')
                          .product-item-thumbnail-overlay
                            a.btn.btn-default.pulse(href='#')
                              span.ti-heart.mr-0
                            a.btn.btn-primary(href='#') add to cart
                        .row
                          .col-xs-6
                            a.h5(href='#') Product name
                          .col-xs-6.text-right
                            del.h5.text-muted.product-item-price-old $99.00
                            span.h5.product-item-price $49.00
                    // / PRODUCT SINGLE
                    // PRODUCT SINGLE
                    .col-md-3.col-sm-6
                      .product-item
                        .product-item-thumbnail.text-center.mb-15
                          a.product-item-thumbnail-link(href='#')
                          span.product-item-thumbnail-label new
                          img.img-responsive(src='http://thymetheme.pl/vega/v102/assets/img/products/product-01.jpg' alt='product image')
                          .product-item-thumbnail-overlay
                            a.btn.btn-default.pulse(href='#')
                              span.ti-heart.mr-0
                            a.btn.btn-primary(href='#') add to cart
                        .row
                          .col-xs-6
                            a.h5(href='#') Product name
                          .col-xs-6.text-right
                            del.h5.text-muted.product-item-price-old $99.00
                            span.h5.product-item-price $49.00
                    // / PRODUCT SINGLE
                    // PRODUCT SINGLE
                    .col-md-3.col-sm-6
                      .product-item
                        .product-item-thumbnail.text-center.mb-15
                          a.product-item-thumbnail-link(href='#')
                          span.product-item-thumbnail-label new
                          img.img-responsive(src='http://thymetheme.pl/vega/v102/assets/img/products/product-01.jpg' alt='product image')
                          .product-item-thumbnail-overlay
                            a.btn.btn-default.pulse(href='#')
                              span.ti-heart.mr-0
                            a.btn.btn-primary(href='#') add to cart
                        .row
                          .col-xs-6
                            a.h5(href='#') Product name
                          .col-xs-6.text-right
                            del.h5.text-muted.product-item-price-old $99.00
                            span.h5.product-item-price $49.00
                    // / PRODUCT SINGLE
                // / TAB PANEL ITEM
                // TAB PANEL ITEM
                #best.tab-pane.fade.active.in(role='tabpanel')
                  .row
                    // PRODUCT SINGLE
                    .col-md-3.col-sm-6
                      .product-item
                        .product-item-thumbnail.text-center.mb-15
                          a.product-item-thumbnail-link(href='#')
                          span.product-item-thumbnail-label new
                          img.img-responsive(src='http://thymetheme.pl/vega/v102/assets/img/products/product-02.jpg' alt='product image')
                          .product-item-thumbnail-overlay
                            a.btn.btn-default.pulse(href='#')
                              span.ti-heart.mr-0
                            a.btn.btn-primary(href='#') add to cart
                        .row
                          .col-xs-6
                            a.h5(href='#') Product name
                          .col-xs-6.text-right
                            del.h5.text-muted.product-item-price-old $99.00
                            span.h5.product-item-price $49.00
                    // / PRODUCT SINGLE
                    // PRODUCT SINGLE
                    .col-md-3.col-sm-6
                      .product-item
                        .product-item-thumbnail.text-center.mb-15
                          a.product-item-thumbnail-link(href='#')
                          span.product-item-thumbnail-label new
                          img.img-responsive(src='http://thymetheme.pl/vega/v102/assets/img/products/product-02.jpg' alt='product image')
                          .product-item-thumbnail-overlay
                            a.btn.btn-default.pulse(href='#')
                              span.ti-heart.mr-0
                            a.btn.btn-primary(href='#') add to cart
                        .row
                          .col-xs-6
                            a.h5(href='#') Product name
                          .col-xs-6.text-right
                            del.h5.text-muted.product-item-price-old $99.00
                            span.h5.product-item-price $49.00
                    // / PRODUCT SINGLE
                    // PRODUCT SINGLE
                    .col-md-3.col-sm-6
                      .product-item
                        .product-item-thumbnail.text-center.mb-15
                          a.product-item-thumbnail-link(href='#')
                          span.product-item-thumbnail-label new
                          img.img-responsive(src='http://thymetheme.pl/vega/v102/assets/img/products/product-02.jpg' alt='product image')
                          .product-item-thumbnail-overlay
                            a.btn.btn-default.pulse(href='#')
                              span.ti-heart.mr-0
                            a.btn.btn-primary(href='#') add to cart
                        .row
                          .col-xs-6
                            a.h5(href='#') Product name
                          .col-xs-6.text-right
                            del.h5.text-muted.product-item-price-old $99.00
                            span.h5.product-item-price $49.00
                    // / PRODUCT SINGLE
                    // PRODUCT SINGLE
                    .col-md-3.col-sm-6
                      .product-item
                        .product-item-thumbnail.text-center.mb-15
                          a.product-item-thumbnail-link(href='#')
                          span.product-item-thumbnail-label new
                          img.img-responsive(src='http://thymetheme.pl/vega/v102/assets/img/products/product-02.jpg' alt='product image')
                          .product-item-thumbnail-overlay
                            a.btn.btn-default.pulse(href='#')
                              span.ti-heart.mr-0
                            a.btn.btn-primary(href='#') add to cart
                        .row
                          .col-xs-6
                            a.h5(href='#') Product name
                          .col-xs-6.text-right
                            del.h5.text-muted.product-item-price-old $99.00
                            span.h5.product-item-price $49.00
                    // / PRODUCT SINGLE
                // / TAB PANEL ITEM
                // TAB PANEL ITEM
                #new.tab-pane.fade(role='tabpanel')
                  .row
                    // PRODUCT SINGLE
                    .col-md-3.col-sm-6
                      .product-item
                        .product-item-thumbnail.text-center.mb-15
                          a.product-item-thumbnail-link(href='#')
                          span.product-item-thumbnail-label new
                          img.img-responsive(src='http://thymetheme.pl/vega/v102/assets/img/products/product-03.jpg' alt='product image')
                          .product-item-thumbnail-overlay
                            a.btn.btn-default.pulse(href='#')
                              span.ti-heart.mr-0
                            a.btn.btn-primary(href='#') add to cart
                        .row
                          .col-xs-6
                            a.h5(href='#') Product name
                          .col-xs-6.text-right
                            del.h5.text-muted.product-item-price-old $99.00
                            span.h5.product-item-price $49.00
                    // / PRODUCT SINGLE
                    // PRODUCT SINGLE
                    .col-md-3.col-sm-6
                      .product-item
                        .product-item-thumbnail.text-center.mb-15
                          a.product-item-thumbnail-link(href='#')
                          span.product-item-thumbnail-label new
                          img.img-responsive(src='http://thymetheme.pl/vega/v102/assets/img/products/product-03.jpg' alt='product image')
                          .product-item-thumbnail-overlay
                            a.btn.btn-default.pulse(href='#')
                              span.ti-heart.mr-0
                            a.btn.btn-primary(href='#') add to cart
                        .row
                          .col-xs-6
                            a.h5(href='#') Product name
                          .col-xs-6.text-right
                            del.h5.text-muted.product-item-price-old $99.00
                            span.h5.product-item-price $49.00
                    // / PRODUCT SINGLE
                    // PRODUCT SINGLE
                    .col-md-3.col-sm-6
                      .product-item
                        .product-item-thumbnail.text-center.mb-15
                          a.product-item-thumbnail-link(href='#')
                          span.product-item-thumbnail-label new
                          img.img-responsive(src='http://thymetheme.pl/vega/v102/assets/img/products/product-03.jpg' alt='product image')
                          .product-item-thumbnail-overlay
                            a.btn.btn-default.pulse(href='#')
                              span.ti-heart.mr-0
                            a.btn.btn-primary(href='#') add to cart
                        .row
                          .col-xs-6
                            a.h5(href='#') Product name
                          .col-xs-6.text-right
                            del.h5.text-muted.product-item-price-old $99.00
                            span.h5.product-item-price $49.00
                    // / PRODUCT SINGLE
                    // PRODUCT SINGLE
                    .col-md-3.col-sm-6
                      .product-item
                        .product-item-thumbnail.text-center.mb-15
                          a.product-item-thumbnail-link(href='#')
                          span.product-item-thumbnail-label new
                          img.img-responsive(src='http://thymetheme.pl/vega/v102/assets/img/products/product-03.jpg' alt='product image')
                          .product-item-thumbnail-overlay
                            a.btn.btn-default.pulse(href='#')
                              span.ti-heart.mr-0
                            a.btn.btn-primary(href='#') add to cart
                        .row
                          .col-xs-6
                            a.h5(href='#') Product name
                          .col-xs-6.text-right
                            del.h5.text-muted.product-item-price-old $99.00
                            span.h5.product-item-price $49.00
                    // / PRODUCT SINGLE
                // / TAB PANEL ITEM
              // / TABS
          .row
            // PRODUCT SINGLE
            .col-md-3.col-sm-6
              .product-item
                .product-item-thumbnail.text-center.mb-15
                  a.product-item-thumbnail-link(href='#')
                  span.product-item-thumbnail-label new
                  img.img-responsive(src='http://thymetheme.pl/vega/v102/assets/img/products/product-01.jpg' alt='product image')
                  .product-item-thumbnail-overlay
                    a.btn.btn-default.pulse(href='#')
                      span.ti-heart.mr-0
                    a.btn.btn-primary(href='#') add to cart
                .row
                  .col-xs-6
                    a.h5(href='#') Product name
                  .col-xs-6.text-right
                    del.h5.text-muted.product-item-price-old $99.00
                    span.h5.product-item-price $49.00
            // / PRODUCT SINGLE
            // PRODUCT SINGLE
            .col-md-3.col-sm-6
              .product-item
                .product-item-thumbnail.text-center.mb-15
                  a.product-item-thumbnail-link(href='#')
                  img.img-responsive(src='http://thymetheme.pl/vega/v102/assets/img/products/product-01.jpg' alt='product image')
                  .product-item-thumbnail-overlay
                    a.btn.btn-default.pulse(href='#')
                      span.ti-heart.mr-0
                    a.btn.btn-primary(href='#') add to cart
                .row
                  .col-xs-6
                    a.h5(href='#') Product name
                  .col-xs-6.text-right
                    del.h5.text-muted.product-item-price-old $99.00
                    span.h5.product-item-price $49.00
            // / PRODUCT SINGLE
            // PRODUCT SINGLE
            .col-md-3.col-sm-6
              .product-item
                .product-item-thumbnail.text-center.mb-15
                  a.product-item-thumbnail-link(href='#')
                  span.product-item-thumbnail-label new
                  img.img-responsive(src='http://thymetheme.pl/vega/v102/assets/img/products/product-01.jpg' alt='product image')
                  .product-item-thumbnail-overlay
                    a.btn.btn-default.pulse(href='#')
                      span.ti-heart.mr-0
                    a.btn.btn-primary(href='#') add to cart
                .row
                  .col-xs-6
                    a.h5(href='#') Product name
                  .col-xs-6.text-right
                    del.h5.text-muted.product-item-price-old $99.00
                    span.h5.product-item-price $49.00
            // / PRODUCT SINGLE
            // PRODUCT SINGLE
            .col-md-3.col-sm-6
              .product-item
                .product-item-thumbnail.text-center.mb-15
                  a.product-item-thumbnail-link(href='#')
                  img.img-responsive(src='http://thymetheme.pl/vega/v102/assets/img/products/product-01.jpg' alt='product image')
                  .product-item-thumbnail-overlay
                    a.btn.btn-default.pulse(href='#')
                      span.ti-heart.mr-0
                    a.btn.btn-primary(href='#') add to cart
                .row
                  .col-xs-6
                    a.h5(href='#') Product name
                  .col-xs-6.text-right
                    del.h5.text-muted.product-item-price-old $99.00
                    span.h5.product-item-price $49.00
            // / PRODUCT SINGLE
      // /.content

</template>
<script>
  export default {
    name: 'ShopHome'
  }
</script>

