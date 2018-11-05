<template lang="pug">
  transition(name='el-zoom-in-top')
    .content-wrapper
      // Content Header (Page header)
      section.content-header
        h1
          | Profile Page
          small
            | It&apos;s all start from here
            i.ti-heart
            i.ti-export
            i.ti-printer
        ol.breadcrumb
          li
            router-link(to='/')
              i.ti-home
          li
            a(href='#') Apps
          li.active Profile
      // Main content
      section.content
        .box
          .box-body(style='min-height:400px;')
            .movie-card
              .container-movie
                a(href='#')
                  img.cover-profile(src='http://api.randomuser.me/portraits/men/32.jpg' alt='cover')
                .hero
                  .details-profile
                    .title1
                      | Dave Mattew
                      span Web Designer
                    .title2 The Battle of the Five Armies
                  // end details
                // end hero
                .description-profile
                  .column1.text-center
                    span.tag html5
                    span.tag php
                    span.tag javascript
                    span.tag css
                    span.tag photoshop
                  // end column1
                  .column2
                    p
                      | Bilbo Baggins is swept into a quest to reclaim the lost Dwarf Kingdom of Erebor from the fearsome dragon Smaug. Approached out of the blue by the wizard Gandalf the Grey, Bilbo finds himself joining a company
                    .row
                      .col-xs-12.col-sm-4.emphasis
                        h2
                          strong 20,7K
                        p
                          small Followers
                        button.btn.btn-success
                          span.fa.fa-plus-circle
                          | &nbsp;&nbsp;Follow
                      .col-xs-12.col-sm-4.emphasis
                        h2
                          strong 245
                        p
                          small Following
                        button.btn.btn-info
                          span.fa.fa-user
                          | &nbsp;&nbsp;View Profile
                      .col-sm-4.emphasis
                        h2
                          strong 43
                        p
                          small Likes
                        button.btn.btn-default
                          span.fa.fa-user
                          | &nbsp;&nbsp;Likes
                  // end column2
                // end description
              // end container
            // end movie-card
            .col-sm-12
              br
              br
              br
              .col-xs-12.col-sm-12.text-center
                ul.list-group
                  li.list-group-item.text-center
                    span.pull-left
                      strong Ratings
                    .ratings
                      a(href='#')
                        span.fa.fa-star
                      a(href='#')
                        span.fa.fa-star
                      a(href='#')
                        span.fa.fa-star
                      a(href='#')
                        span.fa.fa-star
                      a(href='#')
                        span.fa.fa-star-o
                  li.list-group-item.text-right
                    span.pull-left
                      strong Joined
                    | 2.13.2014
                  li.list-group-item.text-right
                    span.pull-left
                      strong Last seen
                    | Yesterday
                  li.list-group-item.text-right
                    span.pull-left
                      strong Nickname
                    | themesmile
              .col-xs-12.col-sm-12.profile-name
                h2
                  | Dave Mattew
                  span.pull-right.social-profile
                    i.entypo-facebook-circled
                    i.entypo-twitter-circled
                    i.entypo-linkedin-circled
                    i.entypo-github-circled
                    i.entypo-gplus-circled
                hr
                dl.dl-horizontal-profile
                  dt User Id
                  dd eko.sulis
                  dt Name
                  dd Eko Sulistyo
                  dt Email
                  dd eko.sulistyo@yahoo.com
                  dt Phone
                  dd 081 725 xxx
                  dt Active Periode
                  dd 02 Dec 2014
                  dt Last Update
                  dd 02 Apr 2014
                  dt About
                  dd Web Designer / UI
                  dt Hobbies
                  dd Read, out with friends, listen to music, draw and learn new things
                  dt Skills
                  dd
                    span.tags html5
                    span.tags css3
                    span.tags jquery
                    span.tags bootstrap3
      // /.content

</template>
<script>
  export default {
    name: 'Profile'
  }
</script>
