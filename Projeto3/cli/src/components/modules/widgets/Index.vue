<template lang="pug">
  .content-wrapper
    // Content Header (Page header)
    section.content-header
      h1
        | Widgets
        small Preview page
      ol.breadcrumb
        li
          a(href='#')
            i.fa.fa-dashboard
            |  Home
        li.active Widgets
    // Main content
    section.content
      .row
        .col-md-3.col-sm-6.col-xs-12
          .info-box
            span.info-box-icon.bg-aqua
              i.fa.fa-envelope-o
            .info-box-content
              span.info-box-text Messages
              span.info-box-number 1,410
            // /.info-box-content
          // /.info-box
        // /.col
        .col-md-3.col-sm-6.col-xs-12
          .info-box
            span.info-box-icon.bg-green
              i.fa.fa-flag-o
            .info-box-content
              span.info-box-text Bookmarks
              span.info-box-number 410
            // /.info-box-content
          // /.info-box
        // /.col
        .col-md-3.col-sm-6.col-xs-12
          .info-box
            span.info-box-icon.bg-yellow
              i.fa.fa-files-o
            .info-box-content
              span.info-box-text Uploads
              span.info-box-number 13,648
            // /.info-box-content
          // /.info-box
        // /.col
        .col-md-3.col-sm-6.col-xs-12
          .info-box
            span.info-box-icon.bg-red
              i.fa.fa-star-o
            .info-box-content
              span.info-box-text Likes
              span.info-box-number 93,139
            // /.info-box-content
          // /.info-box
        // /.col
      // /.row
      // ===========================================================
      .row
        .col-md-3.col-sm-6.col-xs-12
          .info-box.bg-aqua
            span.info-box-icon
              i.fa.fa-bookmark-o
            .info-box-content
              span.info-box-text Bookmarks
              span.info-box-number 41,410
              .progress
                .progress-bar(style='width: 70%')
              span.progress-description
                | 70% Increase in 30 Days
            // /.info-box-content
          // /.info-box
        // /.col
        .col-md-3.col-sm-6.col-xs-12
          .info-box.bg-green
            span.info-box-icon
              i.fa.fa-thumbs-o-up
            .info-box-content
              span.info-box-text Likes
              span.info-box-number 41,410
              .progress
                .progress-bar(style='width: 70%')
              span.progress-description
                | 70% Increase in 30 Days
            // /.info-box-content
          // /.info-box
        // /.col
        .col-md-3.col-sm-6.col-xs-12
          .info-box.bg-yellow
            span.info-box-icon
              i.fa.fa-calendar
            .info-box-content
              span.info-box-text Events
              span.info-box-number 41,410
              .progress
                .progress-bar(style='width: 70%')
              span.progress-description
                | 70% Increase in 30 Days
            // /.info-box-content
          // /.info-box
        // /.col
        .col-md-3.col-sm-6.col-xs-12
          .info-box.bg-red
            span.info-box-icon
              i.fa.fa-comments-o
            .info-box-content
              span.info-box-text Comments
              span.info-box-number 41,410
              .progress
                .progress-bar(style='width: 70%')
              span.progress-description
                | 70% Increase in 30 Days
            // /.info-box-content
          // /.info-box
        // /.col
      // /.row
      // ===========================================================
      // Small boxes (Stat box)
      .row
        .col-lg-3.col-xs-6
          // small box
          .small-box.bg-aqua
            .inner
              h3 150
              p New Orders
            .icon
              i.fa.fa-shopping-cart
            a.small-box-footer(href='#')
              | More info
              i.fa.fa-arrow-circle-right
        // ./col
        .col-lg-3.col-xs-6
          // small box
          .small-box.bg-green
            .inner
              h3
                | 53
                sup(style='font-size: 20px') %
              p Bounce Rate
            .icon
              i.ion.ion-stats-bars
            a.small-box-footer(href='#')
              | More info
              i.fa.fa-arrow-circle-right
        // ./col
        .col-lg-3.col-xs-6
          // small box
          .small-box.bg-yellow
            .inner
              h3 44
              p User Registrations
            .icon
              i.ion.ion-person-add
            a.small-box-footer(href='#')
              | More info
              i.fa.fa-arrow-circle-right
        // ./col
        .col-lg-3.col-xs-6
          // small box
          .small-box.bg-red
            .inner
              h3 65
              p Unique Visitors
            .icon
              i.ion.ion-pie-graph
            a.small-box-footer(href='#')
              | More info
              i.fa.fa-arrow-circle-right
        // ./col
      // /.row
      // ===========================================================
      .row
        .col-md-3
          .box.box-default.collapsed-box
            .box-header.with-border
              h3.box-title Expandable
              .box-tools.pull-right
                button.btn.btn-box-tool(type='button' data-widget='collapse')
                  i.fa.fa-plus
              // /.box-tools
            // /.box-header
            .box-body
              | The body of the box
            // /.box-body
          // /.box
        // /.col
        .col-md-3
          .box.box-success
            .box-header.with-border
              h3.box-title Removable
              .box-tools.pull-right
                button.btn.btn-box-tool(type='button' data-widget='remove')
                  i.fa.fa-times
              // /.box-tools
            // /.box-header
            .box-body
              | The body of the box
            // /.box-body
          // /.box
        // /.col
        .col-md-3
          .box.box-warning
            .box-header.with-border
              h3.box-title Collapsable
              .box-tools.pull-right
                button.btn.btn-box-tool(type='button' data-widget='collapse')
                  i.fa.fa-minus
              // /.box-tools
            // /.box-header
            .box-body
              | The body of the box
            // /.box-body
          // /.box
        // /.col
        .col-md-3
          .box.box-danger
            .box-header
              h3.box-title Loading state
            .box-body
              | The body of the box
            // /.box-body
            // Loading (remove the following to stop the loading)
            .overlay
              i.fa.fa-refresh.fa-spin
            // end loading
          // /.box
        // /.col
      // /.row
      // ===========================================================
      .row
        .col-md-3
          .box.box-default.collapsed-box.box-solid
            .box-header.with-border
              h3.box-title Expandable
              .box-tools.pull-right
                button.btn.btn-box-tool(type='button' data-widget='collapse')
                  i.fa.fa-plus
              // /.box-tools
            // /.box-header
            .box-body
              | The body of the box
            // /.box-body
          // /.box
        // /.col
        .col-md-3
          .box.box-success.box-solid
            .box-header.with-border
              h3.box-title Removable
              .box-tools.pull-right
                button.btn.btn-box-tool(type='button' data-widget='remove')
                  i.fa.fa-times
              // /.box-tools
            // /.box-header
            .box-body
              | The body of the box
            // /.box-body
          // /.box
        // /.col
        .col-md-3
          .box.box-warning.box-solid
            .box-header.with-border
              h3.box-title Collapsable
              .box-tools.pull-right
                button.btn.btn-box-tool(type='button' data-widget='collapse')
                  i.fa.fa-minus
              // /.box-tools
            // /.box-header
            .box-body
              | The body of the box
            // /.box-body
          // /.box
        // /.col
        .col-md-3
          .box.box-danger.box-solid
            .box-header
              h3.box-title Loading state
            .box-body
              | The body of the box
            // /.box-body
            // Loading (remove the following to stop the loading)
            .overlay
              i.fa.fa-refresh.fa-spin
            // end loading
          // /.box
        // /.col
      // /.row
      // ===========================================================
      // Direct Chat
      .row
        .col-md-3
          // DIRECT CHAT PRIMARY
          .box.box-primary.direct-chat.direct-chat-primary
            .box-header.with-border
              h3.box-title Direct Chat
              .box-tools.pull-right
                span.badge.bg-light-blue(data-toggle='tooltip' title='3 New Messages') 3
                button.btn.btn-box-tool(type='button' data-widget='collapse')
                  i.fa.fa-minus
                button.btn.btn-box-tool(type='button' data-toggle='tooltip' title='Contacts' data-widget='chat-pane-toggle')
                  i.fa.fa-comments
                button.btn.btn-box-tool(type='button' data-widget='remove')
                  i.fa.fa-times
            // /.box-header
            .box-body
              // Conversations are loaded here
              .direct-chat-messages
                // Message. Default to the left
                .direct-chat-msg
                  .direct-chat-info.clearfix
                    span.direct-chat-name.pull-left Alexander Pierce
                    span.direct-chat-timestamp.pull-right 23 Jan 2:00 pm
                  // /.direct-chat-info
                  img.direct-chat-img(src='/static/img/user1-128x128.jpg' alt='Message User Image')
                  // /.direct-chat-img
                  .direct-chat-text
                    | Is this template really for free? That&apos;s unbelievable!
                  // /.direct-chat-text
                // /.direct-chat-msg
                // Message to the right
                .direct-chat-msg.right
                  .direct-chat-info.clearfix
                    span.direct-chat-name.pull-right Sarah Bullock
                    span.direct-chat-timestamp.pull-left 23 Jan 2:05 pm
                  // /.direct-chat-info
                  img.direct-chat-img(src='/static/img/user3-128x128.jpg' alt='Message User Image')
                  // /.direct-chat-img
                  .direct-chat-text
                    | You better believe it!
                  // /.direct-chat-text
                // /.direct-chat-msg
              // /.direct-chat-messages
              // Contacts are loaded here
              .direct-chat-contacts
                ul.contacts-list
                  li
                    a(href='#')
                      img.contacts-list-img(src='/static/img/user1-128x128.jpg' alt='User Image')
                      .contacts-list-info
                        span.contacts-list-name
                          | Count Dracula
                          small.contacts-list-date.pull-right 2/28/2015
                        span.contacts-list-msg How have you been? I was...
                      // /.contacts-list-info
                  // End Contact Item
                // /.contatcts-list
              // /.direct-chat-pane
            // /.box-body
            .box-footer
              form(action='#' method='post')
                .input-group
                  input.form-control(type='text' name='message' placeholder='Type Message ...')
                  span.input-group-btn
                    button.btn.btn-primary.btn-flat(type='submit') Send
            // /.box-footer
          // /.direct-chat
        // /.col
        .col-md-3
          // DIRECT CHAT SUCCESS
          .box.box-success.direct-chat.direct-chat-success
            .box-header.with-border
              h3.box-title Direct Chat
              .box-tools.pull-right
                span.badge.bg-green(data-toggle='tooltip' title='3 New Messages') 3
                button.btn.btn-box-tool(type='button' data-widget='collapse')
                  i.fa.fa-minus
                button.btn.btn-box-tool(type='button' data-toggle='tooltip' title='Contacts' data-widget='chat-pane-toggle')
                  i.fa.fa-comments
                button.btn.btn-box-tool(type='button' data-widget='remove')
                  i.fa.fa-times
            // /.box-header
            .box-body
              // Conversations are loaded here
              .direct-chat-messages
                // Message. Default to the left
                .direct-chat-msg
                  .direct-chat-info.clearfix
                    span.direct-chat-name.pull-left Alexander Pierce
                    span.direct-chat-timestamp.pull-right 23 Jan 2:00 pm
                  // /.direct-chat-info
                  img.direct-chat-img(src='/static/img/user1-128x128.jpg' alt='Message User Image')
                  // /.direct-chat-img
                  .direct-chat-text
                    | Is this template really for free? That&apos;s unbelievable!
                  // /.direct-chat-text
                // /.direct-chat-msg
                // Message to the right
                .direct-chat-msg.right
                  .direct-chat-info.clearfix
                    span.direct-chat-name.pull-right Sarah Bullock
                    span.direct-chat-timestamp.pull-left 23 Jan 2:05 pm
                  // /.direct-chat-info
                  img.direct-chat-img(src='/static/img/user3-128x128.jpg' alt='Message User Image')
                  // /.direct-chat-img
                  .direct-chat-text
                    | You better believe it!
                  // /.direct-chat-text
                // /.direct-chat-msg
              // /.direct-chat-messages
              // Contacts are loaded here
              .direct-chat-contacts
                ul.contacts-list
                  li
                    a(href='#')
                      img.contacts-list-img(src='/static/img/user1-128x128.jpg' alt='User Image')
                      .contacts-list-info
                        span.contacts-list-name
                          | Count Dracula
                          small.contacts-list-date.pull-right 2/28/2015
                        span.contacts-list-msg How have you been? I was...
                      // /.contacts-list-info
                  // End Contact Item
                // /.contatcts-list
              // /.direct-chat-pane
            // /.box-body
            .box-footer
              form(action='#' method='post')
                .input-group
                  input.form-control(type='text' name='message' placeholder='Type Message ...')
                  span.input-group-btn
                    button.btn.btn-success.btn-flat(type='submit') Send
            // /.box-footer
          // /.direct-chat
        // /.col
        .col-md-3
          // DIRECT CHAT WARNING
          .box.box-warning.direct-chat.direct-chat-warning
            .box-header.with-border
              h3.box-title Direct Chat
              .box-tools.pull-right
                span.badge.bg-yellow(data-toggle='tooltip' title='3 New Messages') 3
                button.btn.btn-box-tool(type='button' data-widget='collapse')
                  i.fa.fa-minus
                button.btn.btn-box-tool(type='button' data-toggle='tooltip' title='Contacts' data-widget='chat-pane-toggle')
                  i.fa.fa-comments
                button.btn.btn-box-tool(type='button' data-widget='remove')
                  i.fa.fa-times
            // /.box-header
            .box-body
              // Conversations are loaded here
              .direct-chat-messages
                // Message. Default to the left
                .direct-chat-msg
                  .direct-chat-info.clearfix
                    span.direct-chat-name.pull-left Alexander Pierce
                    span.direct-chat-timestamp.pull-right 23 Jan 2:00 pm
                  // /.direct-chat-info
                  img.direct-chat-img(src='/static/img/user1-128x128.jpg' alt='Message User Image')
                  // /.direct-chat-img
                  .direct-chat-text
                    | Is this template really for free? That&apos;s unbelievable!
                  // /.direct-chat-text
                // /.direct-chat-msg
                // Message to the right
                .direct-chat-msg.right
                  .direct-chat-info.clearfix
                    span.direct-chat-name.pull-right Sarah Bullock
                    span.direct-chat-timestamp.pull-left 23 Jan 2:05 pm
                  // /.direct-chat-info
                  img.direct-chat-img(src='/static/img/user3-128x128.jpg' alt='Message User Image')
                  // /.direct-chat-img
                  .direct-chat-text
                    | You better believe it!
                  // /.direct-chat-text
                // /.direct-chat-msg
              // /.direct-chat-messages
              // Contacts are loaded here
              .direct-chat-contacts
                ul.contacts-list
                  li
                    a(href='#')
                      img.contacts-list-img(src='/static/img/user1-128x128.jpg' alt='User Image')
                      .contacts-list-info
                        span.contacts-list-name
                          | Count Dracula
                          small.contacts-list-date.pull-right 2/28/2015
                        span.contacts-list-msg How have you been? I was...
                      // /.contacts-list-info
                  // End Contact Item
                // /.contatcts-list
              // /.direct-chat-pane
            // /.box-body
            .box-footer
              form(action='#' method='post')
                .input-group
                  input.form-control(type='text' name='message' placeholder='Type Message ...')
                  span.input-group-btn
                    button.btn.btn-warning.btn-flat(type='submit') Send
            // /.box-footer
          // /.direct-chat
        // /.col
        .col-md-3
          // DIRECT CHAT DANGER
          .box.box-danger.direct-chat.direct-chat-danger
            .box-header.with-border
              h3.box-title Direct Chat
              .box-tools.pull-right
                span.badge.bg-red(data-toggle='tooltip' title='3 New Messages') 3
                button.btn.btn-box-tool(type='button' data-widget='collapse')
                  i.fa.fa-minus
                button.btn.btn-box-tool(type='button' data-toggle='tooltip' title='Contacts' data-widget='chat-pane-toggle')
                  i.fa.fa-comments
                button.btn.btn-box-tool(type='button' data-widget='remove')
                  i.fa.fa-times
            // /.box-header
            .box-body
              // Conversations are loaded here
              .direct-chat-messages
                // Message. Default to the left
                .direct-chat-msg
                  .direct-chat-info.clearfix
                    span.direct-chat-name.pull-left Alexander Pierce
                    span.direct-chat-timestamp.pull-right 23 Jan 2:00 pm
                  // /.direct-chat-info
                  img.direct-chat-img(src='/static/img/user1-128x128.jpg' alt='Message User Image')
                  // /.direct-chat-img
                  .direct-chat-text
                    | Is this template really for free? That&apos;s unbelievable!
                  // /.direct-chat-text
                // /.direct-chat-msg
                // Message to the right
                .direct-chat-msg.right
                  .direct-chat-info.clearfix
                    span.direct-chat-name.pull-right Sarah Bullock
                    span.direct-chat-timestamp.pull-left 23 Jan 2:05 pm
                  // /.direct-chat-info
                  img.direct-chat-img(src='/static/img/user3-128x128.jpg' alt='Message User Image')
                  // /.direct-chat-img
                  .direct-chat-text
                    | You better believe it!
                  // /.direct-chat-text
                // /.direct-chat-msg
              // /.direct-chat-messages
              // Contacts are loaded here
              .direct-chat-contacts
                ul.contacts-list
                  li
                    a(href='#')
                      img.contacts-list-img(src='/static/img/user1-128x128.jpg' alt='User Image')
                      .contacts-list-info
                        span.contacts-list-name
                          | Count Dracula
                          small.contacts-list-date.pull-right 2/28/2015
                        span.contacts-list-msg How have you been? I was...
                      // /.contacts-list-info
                  // End Contact Item
                // /.contatcts-list
              // /.direct-chat-pane
            // /.box-body
            .box-footer
              form(action='#' method='post')
                .input-group
                  input.form-control(type='text' name='message' placeholder='Type Message ...')
                  span.input-group-btn
                    button.btn.btn-danger.btn-flat(type='submit') Send
            // /.box-footer
          // /.direct-chat
        // /.col
      // /.row
      h2.page-header Social Widgets
      .row
        .col-md-4
          // Widget: user widget style 1
          .box.box-widget.widget-user-2
            // Add the bg color to the header using any of the bg-* classes
            .widget-user-header.bg-yellow
              .widget-user-image
                img.img-circle(src='/static/img/user7-128x128.jpg' alt='User Avatar')
              // /.widget-user-image
              h3.widget-user-username Nadia Carmichael
              h5.widget-user-desc Lead Developer
            .box-footer.no-padding
              ul.nav.nav-stacked
                li
                  a(href='#')
                    | Projects
                    span.pull-right.badge.bg-blue 31
                li
                  a(href='#')
                    | Tasks
                    span.pull-right.badge.bg-aqua 5
                li
                  a(href='#')
                    | Completed Projects
                    span.pull-right.badge.bg-green 12
                li
                  a(href='#')
                    | Followers
                    span.pull-right.badge.bg-red 842
          // /.widget-user
        // /.col
        .col-md-4
          // Widget: user widget style 1
          .box.box-widget.widget-user
            // Add the bg color to the header using any of the bg-* classes
            .widget-user-header.bg-aqua-active
              h3.widget-user-username Alexander Pierce
              h5.widget-user-desc Founder &amp; CEO
            .widget-user-image
              img.img-circle(src='/static/img/user1-128x128.jpg' alt='User Avatar')
            .box-footer
              .row
                .col-sm-4.border-right
                  .description-block
                    h5.description-header 3,200
                    span.description-text SALES
                  // /.description-block
                // /.col
                .col-sm-4.border-right
                  .description-block
                    h5.description-header 13,000
                    span.description-text FOLLOWERS
                  // /.description-block
                // /.col
                .col-sm-4
                  .description-block
                    h5.description-header 35
                    span.description-text PRODUCTS
                  // /.description-block
                // /.col
              // /.row
          // /.widget-user
        // /.col
        .col-md-4
          // Widget: user widget style 1
          .box.box-widget.widget-user
            // Add the bg color to the header using any of the bg-* classes
            .widget-user-header.bg-black(style="background: url('/static/img/photo1.png') center center;")
              h3.widget-user-username Elizabeth Pierce
              h5.widget-user-desc Web Designer
            .widget-user-image
              img.img-circle(src='/static/img/user3-128x128.jpg' alt='User Avatar')
            .box-footer
              .row
                .col-sm-4.border-right
                  .description-block
                    h5.description-header 3,200
                    span.description-text SALES
                  // /.description-block
                // /.col
                .col-sm-4.border-right
                  .description-block
                    h5.description-header 13,000
                    span.description-text FOLLOWERS
                  // /.description-block
                // /.col
                .col-sm-4
                  .description-block
                    h5.description-header 35
                    span.description-text PRODUCTS
                  // /.description-block
                // /.col
              // /.row
          // /.widget-user
        // /.col
      // /.row
      .row
        .col-md-6
          // Box Comment
          .box.box-widget
            .box-header.with-border
              .user-block
                img.img-circle(src='/static/img/user1-128x128.jpg' alt='User Image')
                span.username
                  a(href='#') Jonathan Burke Jr.
                span.description Shared publicly - 7:30 PM Today
              // /.user-block
              .box-tools
                button.btn.btn-box-tool(type='button' data-toggle='tooltip' title='Mark as read')
                  i.fa.fa-circle-o
                button.btn.btn-box-tool(type='button' data-widget='collapse')
                  i.fa.fa-minus
                button.btn.btn-box-tool(type='button' data-widget='remove')
                  i.fa.fa-times
              // /.box-tools
            // /.box-header
            .box-body
              img.img-responsive.pad(src='/static/img/photo2.png' alt='Photo')
              p I took this photo this morning. What do you guys think?
              button.btn.btn-default.btn-xs(type='button')
                i.fa.fa-share
                |  Share
              button.btn.btn-default.btn-xs(type='button')
                i.fa.fa-thumbs-o-up
                |  Like
              span.pull-right.text-muted 127 likes - 3 comments
            // /.box-body
            .box-footer.box-comments
              .box-comment
                // User image
                img.img-circle.img-sm(src='/static/img/user3-128x128.jpg' alt='User Image')
                .comment-text
                  span.username
                    | Maria Gonzales
                    span.text-muted.pull-right 8:03 PM Today
                  // /.username
                  | It is a long established fact that a reader will be distracted
                  | by the readable content of a page when looking at its layout.
                // /.comment-text
              // /.box-comment
              .box-comment
                // User image
                img.img-circle.img-sm(src='/static/img/user4-128x128.jpg' alt='User Image')
                .comment-text
                  span.username
                    | Luna Stark
                    span.text-muted.pull-right 8:03 PM Today
                  // /.username
                  | It is a long established fact that a reader will be distracted
                  | by the readable content of a page when looking at its layout.
                // /.comment-text
              // /.box-comment
            // /.box-footer
            .box-footer
              form(action='#' method='post')
                img.img-responsive.img-circle.img-sm(src='/static/img/user4-128x128.jpg' alt='Alt Text')
                // .img-push is used to add margin to elements next to floating images
                .img-push
                  input.form-control.input-sm(type='text' placeholder='Press enter to post comment')
            // /.box-footer
          // /.box
        // /.col
        .col-md-6
          // Box Comment
          .box.box-widget
            .box-header.with-border
              .user-block
                img.img-circle(src='/static/img/user1-128x128.jpg' alt='User Image')
                span.username
                  a(href='#') Jonathan Burke Jr.
                span.description Shared publicly - 7:30 PM Today
              // /.user-block
              .box-tools
                button.btn.btn-box-tool(type='button' data-toggle='tooltip' title='Mark as read')
                  i.fa.fa-circle-o
                button.btn.btn-box-tool(type='button' data-widget='collapse')
                  i.fa.fa-minus
                button.btn.btn-box-tool(type='button' data-widget='remove')
                  i.fa.fa-times
              // /.box-tools
            // /.box-header
            .box-body
              // post text
              p
                | Far far away, behind the word mountains, far from the
                | countries Vokalia and Consonantia, there live the blind
                | texts. Separated they live in Bookmarksgrove right at
              p
                | the coast of the Semantics, a large language ocean.
                | A small river named Duden flows by their place and supplies
                | it with the necessary regelialia. It is a paradisematic
                | country, in which roasted parts of sentences fly into
                | your mouth.
              // Attachment
              .attachment-block.clearfix
                img.attachment-img(src='/static/img/photo1.png' alt='Attachment Image')
                .attachment-pushed
                  h4.attachment-heading
                    a(href='http://www.lipsum.com/') Lorem ipsum text generator
                  .attachment-text
                    | Description about the attachment can be placed here.
                    | Lorem Ipsum is simply dummy text of the printing and typesetting industry...
                    a(href='#') more
                  // /.attachment-text
                // /.attachment-pushed
              // /.attachment-block
              // Social sharing buttons
              button.btn.btn-default.btn-xs(type='button')
                i.fa.fa-share
                |  Share
              button.btn.btn-default.btn-xs(type='button')
                i.fa.fa-thumbs-o-up
                |  Like
              span.pull-right.text-muted 45 likes - 2 comments
            // /.box-body
            .box-footer.box-comments
              .box-comment
                // User image
                img.img-circle.img-sm(src='/static/img/user3-128x128.jpg' alt='User Image')
                .comment-text
                  span.username
                    | Maria Gonzales
                    span.text-muted.pull-right 8:03 PM Today
                  // /.username
                  | It is a long established fact that a reader will be distracted
                  | by the readable content of a page when looking at its layout.
                // /.comment-text
              // /.box-comment
              .box-comment
                // User image
                img.img-circle.img-sm(src='/static/img/user5-128x128.jpg' alt='User Image')
                .comment-text
                  span.username
                    | Nora Havisham
                    span.text-muted.pull-right 8:03 PM Today
                  // /.username
                  | The point of using Lorem Ipsum is that it has a more-or-less
                  | normal distribution of letters, as opposed to using
                  | &apos;Content here, content here&apos;, making it look like readable English.
                // /.comment-text
              // /.box-comment
            // /.box-footer
            .box-footer
              form(action='#' method='post')
                img.img-responsive.img-circle.img-sm(src='/static/img/user4-128x128.jpg' alt='Alt Text')
                // .img-push is used to add margin to elements next to floating images
                .img-push
                  input.form-control.input-sm(type='text' placeholder='Press enter to post comment')
            // /.box-footer
          // /.box
        // /.col
      // /.row
    // /.content

</template>

<script>
  export default {
    name: 'WidgetsIndex'
  }
</script>
