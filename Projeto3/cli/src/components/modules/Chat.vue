<template lang="pug">
  transition(name='el-zoom-in-top')
    .content-wrapper
      // Content Header (Page header)
      section.content-header
        h1
          | Chat App
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
          li.active Chat App
      // Main content
      section.content
        .container-chat.clearfix
          #people-list.people-list
            .search
              input(type='text' placeholder='search')
              i.fa.fa-search
            ul.list
              li.clearfix
                img(src='http://api.randomuser.me/portraits/men/22.jpg' alt='avatar')
                .about
                  .name Vincent Porter
                  .status
                    i.fa.fa-circle.online
                    |  online
              li.clearfix
                img(src='http://api.randomuser.me/portraits/men/23.jpg' alt='avatar')
                .about
                  .name Aiden Chavez
                  .status
                    i.fa.fa-circle.offline
                    |  left 7 mins ago
              li.clearfix
                img(src='http://api.randomuser.me/portraits/men/24.jpg' alt='avatar')
                .about
                  .name Mike Thomas
                  .status
                    i.fa.fa-circle.online
                    |  online
              li.clearfix
                img(src='http://api.randomuser.me/portraits/women/25.jpg' alt='avatar')
                .about
                  .name Erica Hughes
                  .status
                    i.fa.fa-circle.online
                    |  online
              li.clearfix
                img(src='http://api.randomuser.me/portraits/women/26.jpg' alt='avatar')
                .about
                  .name Ginger Johnston
                  .status
                    i.fa.fa-circle.online
                    |  online
              li.clearfix
                img(src='http://api.randomuser.me/portraits/women/27.jpg' alt='avatar')
                .about
                  .name Tracy Carpenter
                  .status
                    i.fa.fa-circle.offline
                    |  left 30 mins ago
              li.clearfix
                img(src='http://api.randomuser.me/portraits/men/28.jpg' alt='avatar')
                .about
                  .name Christian Kelly
                  .status
                    i.fa.fa-circle.offline
                    |  left 10 hours ago
              li.clearfix
                img(src='http://api.randomuser.me/portraits/women/29.jpg' alt='avatar')
                .about
                  .name Monica Ward
                  .status
                    i.fa.fa-circle.online
                    |  online
              li.clearfix
                img(src='http://api.randomuser.me/portraits/men/30.jpg' alt='avatar')
                .about
                  .name Dean Henry
                  .status
                    i.fa.fa-circle.offline
                    |  offline since Oct 28
              li.clearfix
                img(src='http://api.randomuser.me/portraits/women/31.jpg' alt='avatar')
                .about
                  .name Peyton Mckinney
                  .status
                    i.fa.fa-circle.online
                    |  online
          .chat
            .chat-header.clearfix
              img(src='http://api.randomuser.me/portraits/men/32.jpg' alt='avatar')
              .chat-about
                .chat-with Chat with Vincent Porter
                .chat-num-messages already 1 902 messages
              i.fa.fa-star
            // end chat-header
            .chat-history
              ul
                li.clearfix
                  .message-data.align-right
                    span.message-data-time 10:10 AM, Today
                    span.message-data-name Olia
                    i.fa.fa-circle.me
                  .message.other-message.float-right  Hi Vincent, how are you? How is the project coming along?
                li
                  .message-data
                    span.message-data-name
                      i.fa.fa-circle.online
                      |  Vincent
                    span.message-data-time 10:12 AM, Today
                  .message.my-message
                    | Are we meeting today? Project has been already finished and I have results to show you.
                li.clearfix
                  .message-data.align-right
                    span.message-data-time 10:14 AM, Today
                    span.message-data-name Olia
                    i.fa.fa-circle.me
                  .message.other-message.float-right
                    | Well I am not sure. The rest of the team is not here yet. Maybe in an hour or so? Have you faced any problems at the last phase of the project?
                li
                  .message-data
                    span.message-data-name
                      i.fa.fa-circle.online
                      |  Vincent
                    span.message-data-time 10:20 AM, Today
                  .message.my-message  Actually everything was fine. I&apos;m very excited to show this to our team.
                li
                  .message-data
                    span.message-data-name
                      i.fa.fa-circle.online
                      |  Vincent
                    span.message-data-time 10:31 AM, Today
                  i.fa.fa-circle.online
                  i.fa.fa-circle.online(style='color: #AED2A6')
                  i.fa.fa-circle.online(style='color:#DAE9DA')
            // end chat-history
            .chat-message.clearfix
              textarea#message-to-send(name='message-to-send' placeholder='Type your message' rows='3')
              i.fa.fa-file-o
              i.fa.fa-file-image-o
              button Send
            // end chat-message
          // end chat
        // end container
      // /.content

</template>
<script>
  export default {
    name: 'Chat'
  }
</script>
