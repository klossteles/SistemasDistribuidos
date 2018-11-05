<template lang="pug">
  transition(name='el-zoom-in-top')
    .content-wrapper
      // Content Header (Page header)
      section.content-header
        h1
          | Shop Item Page
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
          li.active Shop Item
      // Main content
      section.content
        .box(style='padding:30px;')
          .heading-cart.cf
            h1 My Cart
            a(href='#') Continue Shopping
          ul.cart-items.width-100.pull-left.pl-60.pr-30.pb-0.pt-0.container-fluid
            li.cart-items-labels.visible-lg-block.visible-md-block.row
              span.col-md-6.text-muted.small product
              span.col-md-2.text-muted.small.text-center quantity
              span.col-md-4.text-muted.small.text-right price
            li.row
              span.cart-image.col-xs-12.col-sm-12.col-md-2
                a(href='#')
                  img(alt='product description' src='http://thymetheme.pl/vega/v102/assets/img/products/product-03.jpg')
              .cart-item-right.col-md-10.col-xs-12.col-sm-12
                .row
                  span.cart-description.col-xs-12.col-md-5
                    a.h5(href='#') Product name
                    span.cart-item-price.h5.text-muted $ 33.00
                  span.col-md-2.col-sm-12
                    input.text-center.form-control(type='text' value='10')
                  span.col-md-5.col-sm-12.text-right
                    span.cart-price.pull-right
                      | $330.00
                      a.cart-remove(href='#')
                        span.ti-trash.icon.pull-right.mt-5.ml-10
            li.row
              span.cart-image.col-xs-12.col-sm-12.col-md-2
                a(href='#')
                  img(alt='product description' src='http://thymetheme.pl/vega/v102/assets/img/products/product-03.jpg')
              .cart-item-right.col-md-10.col-xs-12.col-sm-12
                .row
                  span.cart-description.col-xs-12.col-md-5
                    a.h5(href='#') Product name
                    span.cart-item-price.h5.text-muted $ 33.00
                  span.col-md-2.col-sm-12
                    input.text-center.form-control(type='text' value='10')
                  span.col-md-5.col-sm-12.text-right
                    span.cart-price.pull-right
                      | $330.00
                      a.cart-remove(href='#')
                        span.ti-trash.icon.pull-right.mt-5.ml-10
            li.row
              span.cart-image.col-xs-12.col-sm-12.col-md-2
                a(href='#')
                  img(alt='product description' src='http://thymetheme.pl/vega/v102/assets/img/products/product-03.jpg')
              .cart-item-right.col-md-10.col-xs-12.col-sm-12
                .row
                  span.cart-description.col-xs-12.col-md-5
                    a.h5(href='#') Product name
                    span.cart-item-price.h5.text-muted $ 33.00
                  span.col-md-2.col-sm-12
                    input.text-center.form-control(type='text' value='10')
                  span.col-md-5.col-sm-12.text-right
                    span.cart-price.pull-right
                      | $330.00
                      a.cart-remove(href='#')
                        span.ti-trash.icon.pull-right.mt-5.ml-10
          .width-100.pr-45.checkout-devin
            ul
              li.totalRow
                span.label Subtotal
                span.value $35.00
              li.totalRow
                span.label Shipping
                span.value $5.00
              li.totalRow
                span.label Tax
                span.value $4.00
              li.totalRow.final
                span.label Total
                span.value $44.00
              li.totalRow
                a(href='#') Checkout
          div(style='clear:both')
        // /.content

</template>
<script>
  export default {
    name: 'ShopItem'
  }
</script>
