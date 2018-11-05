<template lang="pug">
  transition(name='el-zoom-in-top')
    .content-wrapper
      // Content Header (Page header)
      section.content-header
        h1
          | Blog Mansory Page
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
          li.active Blog Mansory Page
      // Main content
      section.content
        .row-mansory
          // VIDEO
          .col-md-4
            .well-media
              .vendor
                .fluid-width-video-wrapper.embed-responsive.embed-responsive-16by9
                  iframe#fitvid741674.embed-responsive-item(src='http://www.youtube.com/embed/BO03CROMVjo' frameborder='0' allowfullscreen='')
              .video-text
                h2
                  | Baby Shark Dance | Sing and Dance! | Animal Songs | PINKFONG Songs for Children
                p
                  | Lorem ipsum dolor sit amet, consectetur adipiscing elit. Phasellus et dui id justo rhoncus consequat. Aliquam porttitor, arcu quis ornare ultricies, augue neque fringilla turpis.
              .tag-nest
                i angel
                i dark
                i mistic
              .video-category-bg
                h3 Video
                a.link-media.pull-right(href='#')
                  span.fontawesome-film
                .triangle-white
                .triangle-video-right
          // END OF VIDEO
          // PHOTO
          .col-md-4
            .well-media
              .vendor
                a.fancybox(rel='group' href='#')
                  img.img-responsive-media(src='https://source.unsplash.com/collection/190727/1500x900' alt='')
              .video-text
                h2 Black Angel
                p Lorem ipsum dolor sit amet, consectetur adipiscing elit.
              .tag-nest
                i angel
                i dark
                i mistic
              .photo-category-bg
                h3 Photo
                a.link-media.pull-right(href='#')
                  span.fontawesome-picture
                .triangle-white
                .triangle-photo-right
          // END OF PHOTO
          // AUDIO
          .col-md-4
            .well-media
              .vendor.embed-responsive.embed-responsive-16by9
                iframe#fitvid741674.embed-responsive-item(src='http://www.youtube.com/embed/dqb4o3ycv4k' frameborder='0' allowfullscreen='')
              .video-text
                h2 Coldplay ft The Chainsmokers - Look What You Made Me Do
                p
                  | I do not own the music and the background.
                  | Copyright Disclaimer Under Section 107 of the Copyright Act 1976
              .tag-nest
                i patah
                i hati
                i music
              .audio-category-bg
                h3 audio
                a.link-media.pull-right(href='#')
                  span.entypo-note-beamed
                .triangle-white
                .triangle-audio-right
          // END OF AUDIO
          // PHOTO SET
          .col-md-4
            .well-media
              .vendor
                #carousel-example-generic.carousel.slide(data-ride='carousel')
                  ol.carousel-indicators
                    li(data-slide-to='0' data-target='#carousel-example-generic')
                    li.active(data-slide-to='1' data-target='#carousel-example-generic')
                    li(data-slide-to='2' data-target='#carousel-example-generic')
                  .carousel-inner
                    .item
                      img.img-responsive-media(alt='First slide' src='https://source.unsplash.com/collection/431862/800x600')
                    .item.active
                      img.img-responsive-media(alt='Second slide' src='https://source.unsplash.com/collection/474045/800x600')
                    .item
                      img.img-responsive-media(alt='Third slide' src='https://source.unsplash.com/collection/981639/800x600')
                  a.left.carousel-control(data-slide='prev' href='#carousel-example-generic')
                    span.devin-panel-car.ti-arrow-circle-left
                  a.right.carousel-control(data-slide='next' href='#carousel-example-generic')
                    span.devin-panel-car.ti-arrow-circle-right
              .video-text
                h2 Holyday
                p It ws may last summer holyday
              .tag-nest
                i angel
                i dark
                i mistic
              .album-category-bg
                h3 Photoset
                a.link-media.pull-right(href='#')
                  span.entypo-picture
                .triangle-white
                .triangle-album-right
          // END OF PHOTO SET
          // VIDEO
          .col-md-4
            .well-media
              .vendor
                .fluid-width-video-wrapper.embed-responsive.embed-responsive-16by9
                  iframe#fitvid892886.embed-responsive-item(src='//www.youtube.com/embed/ICAisYcDNqw' frameborder='0' allowfullscreen='')
              .video-text
                h2 Black Angel
                p
                  | Lorem ipsum dolor sit amet, consectetur adipiscing elit. Phasellus et dui id justo rhoncus consequat. Aliquam porttitor, arcu quis ornare ultricies, augue neque fringilla turpis.
              .tag-nest
                i angel
                i dark
                i mistic
              .video-category-bg
                h3 Video
                a.link-media.pull-right(href='#')
                  span.fontawesome-film
                .triangle-white
                .triangle-video-right
          // END OF VIDEO
          // PHOTO
          .col-md-4
            .well-media
              .vendor
                a(rel='group' href='#')
                  img.img-responsive-media(src='http://lorempixel.com/output/food-h-c-350-450-8.jpg' alt='')
              .video-text
                h2 Black Angel
                p Lorem ipsum dolor sit amet, consectetur adipiscing elit.
              .tag-nest
                i angel
                i dark
                i mistic
              .photo-category-bg
                h3 Photo
                a.link-media.pull-right(href='#')
                  span.fontawesome-picture
                .triangle-white
                .triangle-photo-right
          // END OF PHOTO
          // AUDIO
          .col-md-4
            .well-media
              .vendor
                iframe(width='100%' height='166' scrolling='no' frameborder='no' src='https://w.soundcloud.com/player/?url=https%3A//api.soundcloud.com/tracks/88278446&color=ff5500&auto_play=false&hide_related=false&show_artwork=true')
              .video-text
                h2 Favright
                p Favright - Taking Over (feat. Cassandra Kay)
              .tag-nest
                i patah
                i hati
                i music
              .audio-category-bg
                h3 audio
                a.link-media.pull-right(href='#')
                  span.entypo-note-beamed
                .triangle-white
                .triangle-audio-right
          // END OF AUDIO
          // PHOTO SET
          .col-md-4
            .well-media
              .vendor
                #carousel-dua.carousel.slide(data-ride='carousel')
                  ol.carousel-indicators
                    li(data-slide-to='0' data-target='#carousel-dua')
                    li(data-slide-to='1' data-target='#carousel-dua')
                    li.active(data-slide-to='2' data-target='#carousel-dua')
                  .carousel-inner
                    .item
                      img.img-responsive-media(alt='First slide' data-src='holder.js/900x500/auto/#777:#555/text:First slide' src='http://placehold.it/350x250')
                    .item
                      img.img-responsive-media(alt='Second slide' data-src='holder.js/900x500/auto/#666:#444/text:Second slide' src='http://placehold.it/350x250')
                    .item.active
                      img.img-responsive-media(alt='Third slide' data-src='holder.js/900x500/auto/#555:#333/text:Third slide' src='http://placehold.it/350x250')
                  a.left.carousel-control(data-slide='prev' href='#carousel-dua')
                    span.glyphicon.glyphicon-chevron-left
                  a.right.carousel-control(data-slide='next' href='#carousel-dua')
                    span.glyphicon.glyphicon-chevron-right
              .video-text
                h2 Holyday
                p It ws may last summer holyday
              .tag-nest
                i angel
                i dark
                i mistic
              .album-category-bg
                h3 Photoset
                a.link-media.pull-right(href='#')
                  span.entypo-picture
                .triangle-white
                .triangle-album-right
          // END OF PHOTO SET
          // AUDIO
          .col-md-4
            .well-media
              .vendor
                iframe(width='100%' height='166' scrolling='no' frameborder='no' src='https://w.soundcloud.com/player/?url=https%3A//api.soundcloud.com/tracks/149950304&color=ff5500&auto_play=false&hide_related=false&show_artwork=true')
              .video-text
                h2 Terlatih Patah Hati
                p Lorem ipsum dolor sit amet, consectetur adipiscing elit.
              .tag-nest
                i patah
                i hati
                i music
              .audio-category-bg
                h3 audio
                a.link-media.pull-right(href='#')
                  span.entypo-note-beamed
                .triangle-white
                .triangle-audio-right
          // END OF AUDIO
      // /.content

</template>
<script>
  export default {
    name: 'BlogMansory'
  }
</script>
