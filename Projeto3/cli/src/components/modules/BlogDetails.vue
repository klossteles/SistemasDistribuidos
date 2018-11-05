<template lang="pug">
  transition(name='el-zoom-in-top')
    .content-wrapper
      // Content Header (Page header)
      section.content-header
        h1
          | Blog Details
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
          li.active Blog Detail Page
      // Main content
      section.content
        .box(style='padding:30px;')
          .row
            // BLOG CONTENT
            .col-sm-8
              .blog-list-nest
                .vendor
                  img.img-responsive-media(src='https://source.unsplash.com/collection/190727/1600x900' alt='')
                .blog-list-content
                  h2 Favright
                  ul.list-inline.blog-devin-tag
                    li
                      a(href='#')
                        span.ti-pencil
                        | &nbsp;2 Days Ago
                    li
                      a(href='#')
                        span.ti-comment-alt
                        | &nbsp;2 Comments
                    li
                      a(href='#')
                        span.ti-rss-alt
                        | &nbsp;14 Shares
                  p
                    | Lorem ipsum dolor sit amet, consectetur adipiscing elit. Etiam condimentum sollicitudin mi, vitae vehicula justo venenatis at. Morbi tempor fermentum velit non pretium. Phasellus at lacus turpis. Curabitur dapibus pulvinar velit eu rutrum. Nulla adipiscing sapien orci, ac iaculis justo euismod vitae. Fusce tincidunt accumsan erat, a molestie eros auctor a. Suspendisse vel nibh vulputate, porttitor neque in, pellentesque lectus. Pellentesque aliquet diam sed placerat scelerisque. Suspendisse eleifend sem urna, eget viverra nunc interdum quis. Nam porta nunc turpis. Pellentesque ut adipiscing mi, eu facilisis turpis.
                  p
                    | Nunc ac erat semper, ultrices lorem eu, pretium urna. Etiam nibh nibh, laoreet id pharetra sit amet, interdum at sapien. Fusce venenatis velit in diam auctor tempus. Duis feugiat consectetur urna vel suscipit. In in lorem placerat, tempus velit ac, aliquam diam. Cras vestibulum velit posuere, elementum enim sed, imperdiet nisl. Etiam scelerisque purus tempus, fringilla dolor at, sodales nibh. Morbi molestie porta nunc, ut tincidunt ante euismod vitae. Mauris vehicula augue augue, ut placerat sapien porta vel. Curabitur laoreet odio et nibh hendrerit consequat. Quisque aliquet orci est, condimentum dignissim felis tempus eget. Morbi ac bibendum velit, eget aliquam nisi. Integer posuere consequat purus non mollis. Integer posuere vitae massa a posuere. Vivamus at lectus at elit aliquam pulvinar porta nec turpis.
                  p
                    | Vestibulum eu scelerisque ante, eget molestie tellus. Aenean eget sagittis massa. Fusce et ligula ultricies, venenatis leo et, posuere orci. Aenean euismod augue id orci consequat, eget lobortis ante blandit. Nulla tempus viverra mattis. Maecenas volutpat ut massa pellentesque tristique. Morbi erat enim, dapibus ornare laoreet non, auctor sit amet lorem. Integer nec lorem a risus tristique viverra. Quisque aliquam nisl eu ante pretium, vel volutpat leo tempus. Nam velit arcu, tincidunt eget viverra vitae, auctor ac neque.
                  hr
                  p.pull-left
                    el-tag(type='gray') Music
                    el-tag(type='gray') Video
                    el-tag(type='gray') Typhography
                  div(style='clear:both;')
              .comment-nest
                h1 Leave a Comment:
                el-input(type='textarea' :rows='5' placeholder='Please input' v-model='textarea')
                br
                br
                el-button Submit
                hr
                ul.media-list
                  li.media
                    a.pull-left(href='#')
                      img.media-object.img-circle(data-src='holder.js/64x64' alt='64x64' src='http://api.randomuser.me/portraits/thumb/women/21.jpg' style='width: 64px; height: 64px;')
                    .media-body
                      .social-profile
                        h3
                          a.link-comment(href='#') Destya Susilowati
                          span
                            i.entypo-globe
                            | &nbsp;1 hours ago
                          span
                            a.link-comment(href='#')
                              i.fontawesome-share
                              | &nbsp;Reply
                      p
                        | Cras sit amet nibh libero, in gravida nulla. Nulla vel metus scelerisque ante sollicitudin commodo. Cras purus odio, vestibulum in vulputate at, tempus viverra turpis.
                      // Nested media object
                      hr
                      .media
                        a.pull-left(href='#')
                          img.media-object.img-circle(data-src='holder.js/64x64' alt='64x64' src='http://api.randomuser.me/portraits/thumb/men/40.jpg' style='width: 64px; height: 64px;')
                        .media-body
                          .social-profile
                            h3
                              a.link-comment(href='#') Awangizm
                              span
                                i.entypo-globe
                                | &nbsp;1 hours ago
                              span
                                a.link-comment(href='#')
                                  i.fontawesome-share
                                  | &nbsp;Reply
                          p
                            | Cras sit amet nibh libero, in gravida nulla. Nulla vel metus scelerisque ante sollicitudin commodo. Cras purus odio, vestibulum in vulputate at, tempus viverra turpis.
                          // Nested media object
                          hr
                          .media
                            a.pull-left(href='#')
                              img.media-object.img-circle(data-src='holder.js/64x64' alt='64x64' src='http://api.randomuser.me/portraits/thumb/women/21.jpg' style='width: 64px; height: 64px;')
                            .media-body
                              .social-profile
                                h3
                                  a.link-comment(href='#') Symponia
                                  span
                                    i.entypo-globe
                                    | &nbsp;1 hours ago
                                  span
                                    a.link-comment(href='#')
                                      i.fontawesome-share
                                      | &nbsp;Reply
                              p
                                | Cras sit amet nibh libero, in gravida nulla. Nulla vel metus scelerisque ante sollicitudin commodo. Cras purus odio, vestibulum in vulputate at, tempus viverra turpis.
                      // Nested media object
                      hr
                      .media
                        a.pull-left(href='#')
                          img.media-object.img-circle(data-src='holder.js/64x64' alt='64x64' src='http://api.randomuser.me/portraits/thumb/men/55.jpg' style='width: 64px; height: 64px;')
                        .media-body
                          .social-profile
                            h3
                              a.link-comment(href='#') Agus Berontazk
                              span
                                i.entypo-globe
                                | &nbsp;12 minute ago
                              span
                                a.link-comment(href='#')
                                  i.fontawesome-share
                                  | &nbsp;Reply
                          p
                            | Cras sit amet nibh libero, in gravida nulla. Nulla vel metus scelerisque ante sollicitudin commodo. Cras purus odio, vestibulum in vulputate at, tempus viverra turpis.
              ul.pager.success
                li.previous
                  a(href='#') &larr; Older
                li.next.disabled
                  a(href='#') Newer &rarr;
            // END OF BLOG CONTENT
            // BLOG SIDE CONTENT
            .col-sm-4
              .panel.panel-default
                img.media-object.img-circle.blog-profile(data-src='holder.js/64x64' alt='64x64' src='http://api.randomuser.me/portraits/thumb/men/10.jpg')
                hr(style='margin:0;')
                .panel-body
                  p.lead.text-center Dave Mattew
                  p.tex-center.social-blog-profile
                    a(href='#')
                      span.entypo-facebook-circled
                    a.tweet-link(href='#')
                      span.entypo-twitter-circled
                    a.gplus-textcolor(href='#')
                      span.entypo-instagrem
                  p.social-follower.text-center A graphics designer, a web developer, a boyfriend, a friend, a son
              .blog-side-nest
                h4.text-center JOIN NEWSLETTER
                p.text-center Sign up for our daily Newslatter
                form(role='form')
                  .row
                    .col-xs-8
                      .form-group
                        input.form-control(type='email' placeholder='Enter email')
                    // /.col-xs-8
                    .col-xs-4.col-full-width-left
                      button.btn.btn-info.btn-block(type='submit') Sign up
                    // /.col-xs-4
                  // /.row
              .blog-side-nest
                h4.text-left POPULAR POST
                hr(style='margin:0')
                .media
                  a.pull-left(href='#')
                    img.media-object.img-responsive-media(data-src='holder.js/64x64' alt='64x64' src='http://api.randomuser.me/portraits/men/17.jpg')
                  .media-body
                    h5.media-heading Cras sit amet nibh Lorem ipsum dolor si amet
                    a.link-comment.recentpost-link(style='margin:-10px 0 10px' href='#') 88 Views
                .media
                  a.pull-left(href='#')
                    img.media-object.img-responsive-media(data-src='holder.js/64x64' alt='64x64' src='http://api.randomuser.me/portraits/men/21.jpg')
                  .media-body
                    h5.media-heading Cras sit amet nibh Lorem ipsum dolor si amet
                    a.link-comment.recentpost-link(style='margin:-10px 0 10px' href='#') 90 Views
                .media
                  a.pull-left(href='#')
                    img.media-object.img-responsive-media(data-src='holder.js/64x64' alt='64x64' src='http://api.randomuser.me/portraits/men/20.jpg')
                  .media-body
                    h5.media-heading Cras sit amet nibh Lorem ipsum dolor si amet
                    a.link-comment.recentpost-link(style='margin:-10px 0 10px' href='#') 42 Views
                .media
                  a.pull-left(href='#')
                    img.media-object.img-responsive-media(data-src='holder.js/64x64' alt='64x64' src='http://api.randomuser.me/portraits/men/19.jpg')
                  .media-body
                    h5.media-heading Cras sit amet nibh Lorem ipsum dolor si amet
                    a.link-comment.recentpost-link(style='margin:-10px 0 10px' href='#') 111 Views
                .media
                  a.pull-left(href='#')
                    img.media-object.img-responsive-media(data-src='holder.js/64x64' alt='64x64' src='http://api.randomuser.me/portraits/men/18.jpg')
                  .media-body
                    h5.media-heading Cras sit amet nibh Lorem ipsum dolor si amet
                    a.link-comment.recentpost-link(style='margin:-10px 0 10px' href='#') 123 Views
                br
              .blog-side-nest
                h4.text-left TAG
                hr(style='margin:0')
                el-tag(type='gray') Admin
                el-tag(type='gray') Fleet
                el-tag(type='gray') Music
                el-tag(type='gray') Video
                el-tag(type='gray') Typhography
                el-tag(type='gray') Computer
                el-tag(type='gray') Web Design
                el-tag(type='gray') Movie
            // END OF BLOG SIDE CONTENT
      // /.content

</template>
<script>
  export default {
    name: 'BlogDetails'
  }
</script>
