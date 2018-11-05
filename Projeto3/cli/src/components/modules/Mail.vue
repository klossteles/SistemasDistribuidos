<template lang="pug">
  transition(name='el-zoom-in-top')
    .content-wrapper
      // Content Header (Page header)
      section.content-header
        h1
          | Mail Page
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
          li.active Mail Page
      section.content
        // Default box
        // /.box
        // Default box
        .box
          .row
            .col-md-3
              .compose
                ul
                  li
                    i.ti-pencil-alt
                    span Compose
                  li
                    i.ti-import
                    | Inbox
                    span (2,343)
                  li
                    i.ti-new-window
                    | Sent Mail
                  li
                    i.ti-pin-alt
                    | Important
                  li
                    i.ti-zip
                    | Draft
                  li
                    i.ti-trash
                    | Trash
                br
                ul
                  li.text-orange
                    i.ti-control-record
                    a(href='#') Family
                  li.text-red
                    i.ti-control-record
                    a(href='#') Friend
                  li.text-blue
                    i.ti-control-record
                    a(href='#') Office
                  li.text-aqua
                    i.ti-control-record
                    a(href='#') Social
                  li.text-dark-blue
                    i.ti-control-record
                    a(href='#') Unknown
            .col-md-9
              .inbox-nest
                ul
                  li
                    .inbox-header
                      ul
                        li
                          span.ti-reload
                          |  Refresh
                        li
                          span.ti-export
                          |  Reply
                        li
                          span.ti-share
                          |  Reply All
                        li
                          span.ti-trash
                          |  Trash
                        li.right
                          a(href='#') 1-50 of 10,976
                  li
                    img.img-circle.star(alt='' src='http://api.randomuser.me/portraits/thumb/men/22.jpg')
                    b David L. Moore
                    i.icon-attachment
                    i.text-orange.fontello-record
                    small Today, 09:21 PM
                    h5 Will You Be Our Valentine?
                    p
                      | Hi, John i just want to know about my email that i,ve sending yesterday. Dou you read it? ...
                  li
                    img.img-circle.star(alt='' src='http://api.randomuser.me/portraits/thumb/women/23.jpg')
                    b Helen D. Murray
                    i.text-blue.fontello-record
                    small 20 Minute ago
                    h5 World Recod
                    p
                      | Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aliquam erat nunc, vestibulum eu venenatis ut, feugiat sit amet elit. Donec convallis ornare odio. Donec ac est eget lacus molestie imperdiet vitae ac nunc. Suspendisse odio justo ...
                  li
                    a.star.bg-red(href='#')
                      span.fa.fa-google-plus
                    b Google+ (DesignByHuman)
                    i.text-aqua.fontello-record
                    small 1 Hour Ago
                    h5 Berbagi pos - &quot;This #DOTD by Viviana Gonz&aacute;lez makes us ..
                    p
                      | Donec sed mi sem. Maecenas posuere justo dapibus fermentum porttitor. Phasellus ornare lectus a neque molestie sodales. Pellentesque consectetur sed nisl vitae tempor. Duis et odio ut ligula accumsan interdum. ...
                  li
                    img.img-circle.star(alt='' src='http://api.randomuser.me/portraits/thumb/women/25.jpg')
                    b Deanna G. Rumph
                    i.icon-attachment
                    i.text-red.fontello-record
                    small Yesterday, 09:21 PM
                    h5 A new rating has been received for Aurelo Resume
                    p
                      | Etiam cursus feugiat nibh eu efficitur. Praesent lobortis imperdiet neque in tempor. Praesent eu molestie urna, nec dapibus mi. Etiam blandit convallis ligula, sodales sodales nulla scelerisque ac ...
                  li
                    a.star.bg-blue(href='#')
                      span.fa.fa-twitter
                    b Twitter (@Themesmile)
                    i.text-aqua.fontello-record
                    small 11 November
                    h5 Latest tweet from Beyonce
                    p
                      | Suspendisse cursus purus eget magna molestie, a finibus odio malesuada. Maecenas sodales quam a egestas maximus. Donec ultricies nibh eros, non sagittis odio convallis posuere. Nam dolor velit, tincidunt in libero vel ...
                  li
                    a.star.bg-dark-blue(href='#')
                      span.fa.fa-facebook
                    b Facebook ( Gifta Kamilia Putri)
                    i.text-aqua.fontello-record
                    small 10 November
                    h5 People that may you know!
                    p
                      | Fusce eros lectus, hendrerit sit amet nibh et, accumsan sollicitudin urna. Maecenas ac ex id velit imperdiet tincidunt consectetur vel neque. Morbi ornare nibh sapien, sit amet tempus risus dapibus vitae. Donec volutpat, libero sit amet faucibus placerat ...
                  li
                    img.img-circle.star(alt='' src='http://api.randomuser.me/portraits/thumb/men/40.jpg')
                    b James B. Miller
                    i.icon-attachment
                    i.text-orange.fontello-record
                    small 10 November
                    h5 Will You Be Our Valentine?
                    p
                      | Hi, John i just want to know about my email that i,ve sending yesterday. Dou you read it? ...
                  li
                    img.img-circle.star(alt='' src='http://api.randomuser.me/portraits/thumb/men/41.jpg')
                    b John P. McCarthy
                    i.text-blue.fontello-record
                    small 09 November
                    h5 World Recod
                    p
                      | Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aliquam erat nunc, vestibulum eu venenatis ut, feugiat sit amet elit. Donec convallis ornare odio. Donec ac est eget lacus molestie imperdiet vitae ac nunc. Suspendisse odio justo ...
                  li
                    a.star.bg-yellow(href='#')
                      span.fa.fa-dribbble
                    b Dribbble (Matt Wulleang)
                    i.text-aqua.fontello-record
                    small 09 November
                    h5 Berbagi pos - &quot;This #DOTD by Viviana Gonz&aacute;lez makes us ..
                    p
                      | Donec sed mi sem. Maecenas posuere justo dapibus fermentum porttitor. Phasellus ornare lectus a neque molestie sodales. Pellentesque consectetur sed nisl vitae tempor. Duis et odio ut ligula accumsan interdum. ...
                  li
                    .inbox-header
                      ul
                        li
                          span.ti-reload
                          |  Refresh
                        li
                          span.ti-export
                          |  Reply
                        li
                          span.ti-share
                          |  Reply All
                        li
                          span.ti-trash
                          |  Trash
                        li.right
                          a(href='#') 1-50 of 10,976
      // /.content
</template>
<script>
  export default {
    name: 'Mail',
    data () {
      return {
        input: '',
        num1: 1
      }
    }
  }
</script>
