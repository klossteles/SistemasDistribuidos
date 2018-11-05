<template lang="pug">
  transition(name='el-zoom-in-top')
    .content-wrapper
      // Content Header (Page header)
      section.content-header
        h1
          | Blog List
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
          li.active Blog List Page
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
                  h2 Article Heading
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
                    | Lorem ipsum dolor sit amet, consectetur adipiscing elit. Duis pharetra varius quam sit amet vulputate. Quisque mauris augue, molestie tincidunt condimentum vitae, gravida a libero. Aenean sit amet felis dolor, in sagittis nisi. Sed ac orci quis tortor imperdiet venenatis. Duis elementum auctor accumsan. Aliquam in felis sit amet augue.
                  hr
                  p.pull-left
                    el-tag(type='gray') Music
                    el-tag(type='gray') Video
                    el-tag(type='gray') Typhography
                  button.btn.btn-info.pull-right Read More
                  div(style='clear:both;')
              .blog-list-nest
                .vendor
                  img.img-responsive-media(src='https://source.unsplash.com/category/buildings/1024x764' alt='')
                .blog-list-content
                  h2 Godzilla
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
                    | Lorem ipsum dolor sit amet, consectetur adipiscing elit. Duis pharetra varius quam sit amet vulputate. Quisque mauris augue, molestie tincidunt condimentum vitae, gravida a libero. Aenean sit amet felis dolor, in sagittis nisi. Sed ac orci quis tortor imperdiet venenatis. Duis elementum auctor accumsan. Aliquam in felis sit amet augue.
                  hr
                  p.pull-left
                    el-tag(type='gray') Music
                    el-tag(type='gray') Video
                    el-tag(type='gray') Typhography
                  button.btn.btn-info.pull-right Read More
                  div(style='clear:both;')
              .blog-list-nest
                .vendor
                  blockquote
                    p &quot;How can we win when fools can be king&quot;
                    p
                      small Mattew Bellamy
                .blog-list-content
                  h2 Muse
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
                    | Lorem ipsum dolor sit amet, consectetur adipiscing elit. Duis pharetra varius quam sit amet vulputate. Quisque mauris augue, molestie tincidunt condimentum vitae, gravida a libero. Aenean sit amet felis dolor, in sagittis nisi. Sed ac orci quis tortor imperdiet venenatis. Duis elementum auctor accumsan. Aliquam in felis sit amet augue.
                  hr
                  p.pull-left
                    el-tag(type='gray') Music
                    el-tag(type='gray') Video
                    el-tag(type='gray') Typhography
                  button.btn.btn-info.pull-right Read More
                  div(style='clear:both;')
              .blog-list-nest
                .vendor
                  img.img-responsive-media(src='https://source.unsplash.com/category/people/1024x764' alt='')
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
                    | Lorem ipsum dolor sit amet, consectetur adipiscing elit. Duis pharetra varius quam sit amet vulputate. Quisque mauris augue, molestie tincidunt condimentum vitae, gravida a libero. Aenean sit amet felis dolor, in sagittis nisi. Sed ac orci quis tortor imperdiet venenatis. Duis elementum auctor accumsan. Aliquam in felis sit amet augue.
                  hr
                  p.pull-left
                    el-tag(type='gray') Music
                    el-tag(type='gray') Video
                    el-tag(type='gray') Typhography
                  button.btn.btn-info.pull-right Read More
                  div(style='clear:both;')
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
    name: 'BlogList'
  }
</script>
