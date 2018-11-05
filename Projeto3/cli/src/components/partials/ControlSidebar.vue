<template lang="pug">
  div
    aside.control-sidebar.control-sidebar-light
      ul.nav.navbar-stacked
        li
          a(href='#')
            span.palette-Black-100.bg.ti-menu-alt
            | Notifications
        li
          a(href='#')
            span.palette-Deep-Purple-100.bg.ti-menu-alt
            i.ti-more-alt
            span.palette-Deep-Purple-200.bg.ti-shopping-cart-full
            i.ti-more-alt
            span.palette-Deep-Purple-400.bg.ti-gift
            i.ti-more-alt
            span.palette-Deep-Purple-600.bg.ti-truck
            i.ti-more-alt
            span.palette-Deep-Purple-800.bg.ti-home
            | Shipping proses of
            strong Robert Langdon
            |  is completed!
            small 1m
        li
          a(href='#')
            span.palette-Blue-A100.bg.ti-user
            | Meet new user
            strong Lilian Meirs
            small 23m
        li
          a(href='#')
            span.palette-Red-A400.bg.ti-cloud-down
            strong Robert
            |  added new request for ne item for refund
            small 34m
        li
          a(href='#')
            span.palette-Orange-200.bg.ti-menu-alt
            i.ti-more-alt
            span.palette-Orange-400.bg.ti-shopping-cart-full
            i.ti-more-alt
            span.palette-Orange-600.bg.ti-gift
            br
            | Shipping proses of
            strong Robert Langdon
            |  is completed!
            small 40m
        li
          a(href='#')
            span.palette-Amber-500.bg.ti-comment-alt
            | Mike Nilson commented Post
            br
            | Like this one! Keep going!
            small 50m
        li
          a(href='#')
            span.palette-Cyan-300.bg.ti-shopping-cart-full
            | Amazing!
            strong Mike Nilson
            |  just purchased Your item
            small 1h
        li
          a(href='#')
            span.palette-Light-Green-500.bg.ti-image
            strong Lilian Meirs
            |  Posting new image cover, and just got 2.000 likes
            br
            img(alt='' src='https://source.unsplash.com/category/technology/500x200')
            small 1h 12m
        li
          a(href='#')
            span.palette-Amber-500.bg.ti-comment-alt
            | Mike Nilson commented Post
            br
            | Like this one! Keep going!
            small 1h 39
        li
          a(href='#')
            span.palette-Cyan-300.bg.ti-shopping-cart-full
            | Amazing!
            strong Mike Nilson
            |  just purchased Your item
            br
            img(alt='' src='https://source.unsplash.com/category/food/500x200')
            small 1h 45m
        li
          a(href='#')
            span.palette-Cyan-300.bg.ti-shopping-cart-full
            | Amazing!
            strong Mike Nilson
            |  just purchased Your item
            small 23m
        li
          a(href='#')
            span.palette-Amber-500.bg.ti-comment-alt
            | Mike Nilson commented Post
            br
            | Like this one! Keep going!
            small 2h
    // /.control-sidebar
    //
      Add the sidebar's background. This div must be placed
      immediately after the control sidebar

</template>
<script>
export default {
  name: 'ControlSidebar',
  mounted: function () {
    $(document).ready(function ($) {
      $('.navbar-stacked').slimScroll({
        position: 'right',
        size: '3px',
        height: '95vh'
      })
    })
  }
}
</script>
<style lang="scss">
    /* Off Canvas settings */

    .off-canvas.position-right {
        border-left: 1px solid #ddd;
    }

    .nav.navbar-stacked {
        overflow: hidden;
        padding: 0;
        margin: 0;
        list-style: none;
        position: fixed;
        background: #fff;
        li {
            border-bottom: 1px solid #eee;
            position: relative;
            padding: 15px 10px 15px 35px;
            border-bottom: 1px solid #eee;
            position: relative;
            a {
                padding: 10px 0 !important;
                color: #555 !important;
                text-indent: -40px;
                margin-left: 25px;
                display: block;
                span {
                    color: #fff;
                    border-radius: 50%;
                    line-height: 30px;
                    text-align: center;
                    margin: 0 10px 0 0;
                    padding: 8px;
                }
                i {
                    color: #ccc;
                    font-size: 10px !important;
                    position: relative;
                    left: -5px;
                }
                small {
                    text-align: right;
                    background: #fff;
                    color: #ccc;
                    border: 1px solid #ddd;
                    padding: 3px 7px;
                    border-radius: 15px;
                    margin: 0 0 0 7px;
                    font-size: 10px;
                }
                img {
                    width: 95%;
                    padding: 0;
                    border-radius: 4px;
                    margin: 10px 0;
                }
            }
        }
        &.sidebar-right-content {
            padding-bottom: 150px;
        }
    }
</style>
