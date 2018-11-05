<template lang="pug">
  transition(name='el-zoom-in-top')
    .content-wrapper
      // Content Header (Page header)
      section.content-header
        h1
          | Icons Page
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
          li.active Icons Page
      // Main content
      section.content
        .box
          .box-body(style='min-height:400px;')
            el-tabs(v-model='activeName' @tab-click='handleClick')
              // Themify Icons
              el-tab-pane(label='Themify Icons' name='first')
                .entypo-tooltip
                  p WEB APP ICONS
                  ul
                    li.ti-wand
                    li.ti-save
                    li.ti-save-alt
                    li.ti-direction
                    li.ti-direction-alt
                    li.ti-user
                    li.ti-link
                    li.ti-unlink
                    li.ti-trash
                    li.ti-target
                    li.ti-tag
                    li.ti-desktop
                    li.ti-tablet
                    li.ti-mobile
                    li.ti-email
                    li.ti-star
                    li.ti-spray
                    li.ti-signal
                    li.ti-shopping-cart
                    li.ti-shopping-cart-full
                    li.ti-settings
                    li.ti-search
                    li.ti-zoom-in
                    li.ti-zoom-out
                    li.ti-cut
                    li.ti-ruler
                    li.ti-ruler-alt-2
                    li.ti-ruler-pencil
                    li.ti-ruler-alt
                    li.ti-bookmark
                    li.ti-bookmark-alt
                    li.ti-reload
                    li.ti-plus
                    li.ti-minus
                    li.ti-close
                    li.ti-pin
                    li.ti-pencil
                    li.ti-pencil-alt
                    li.ti-paint-roller
                    li.ti-paint-bucket
                    li.ti-na
                    li.ti-medall
                    li.ti-medall-alt
                    li.ti-marker
                    li.ti-marker-alt
                    li.ti-lock
                    li.ti-unlock
                    li.ti-location-arrow
                    li.ti-layout
                    li.ti-layers
                    li.ti-layers-alt
                    li.ti-key
                    li.ti-image
                    li.ti-heart
                    li.ti-heart-broken
                    li.ti-hand-stop
                    li.ti-hand-open
                    li.ti-hand-drag
                    li.ti-flag
                    li.ti-flag-alt
                    li.ti-flag-alt-2
                    li.ti-eye
                    li.ti-import
                    li.ti-export
                    li.ti-cup
                    li.ti-crown
                    li.ti-comments
                    li.ti-comment
                    li.ti-comment-alt
                    li.ti-thought
                    li.ti-clip
                    li.ti-check
                    li.ti-check-box
                    li.ti-camera
                    li.ti-announcement
                    li.ti-brush
                    li.ti-brush-alt
                    li.ti-palette
                    li.ti-briefcase
                    li.ti-bolt
                    li.ti-bolt-alt
                    li.ti-blackboard
                    li.ti-bag
                    li.ti-world
                    li.ti-wheelchair
                    li.ti-car
                    li.ti-truck
                    li.ti-timer
                    li.ti-ticket
                    li.ti-thumb-up
                    li.ti-thumb-down
                    li.ti-stats-up
                    li.ti-stats-down
                    li.ti-shine
                    li.ti-shift-right
                    li.ti-shift-left
                    li.ti-shift-right-alt
                    li.ti-shift-left-alt
                    li.ti-shield
                    li.ti-notepad
                    li.ti-server
                    li.ti-pulse
                    li.ti-printer
                    li.ti-power-off
                    li.ti-plug
                    li.ti-pie-chart
                    li.ti-panel
                    li.ti-package
                    li.ti-music
                    li.ti-music-alt
                    li.ti-mouse
                    li.ti-mouse-alt
                    li.ti-money
                    li.ti-microphone
                    li.ti-menu
                    li.ti-menu-alt
                    li.ti-map
                    li.ti-map-alt
                    li.ti-location-pin
                    li.ti-light-bulb
                    li.ti-info
                    li.ti-infinite
                    li.ti-id-badge
                    li.ti-hummer
                    li.ti-home
                    li.ti-help
                    li.ti-headphone
                    li.ti-harddrives
                    li.ti-harddrive
                    li.ti-gift
                    li.ti-game
                    li.ti-filter
                    li.ti-files
                    li.ti-file
                    li.ti-zip
                    li.ti-folder
                    li.ti-envelope
                    li.ti-dashboard
                    li.ti-cloud
                    li.ti-cloud-up
                    li.ti-cloud-down
                    li.ti-clipboard
                    li.ti-calendar
                    li.ti-book
                    li.ti-bell
                    li.ti-basketball
                    li.ti-bar-chart
                    li.ti-bar-chart-alt
                    li.ti-archive
                    li.ti-anchor
                    li.ti-alert
                    li.ti-alarm-clock
                    li.ti-agenda
                    li.ti-write
                    li.ti-wallet
                    li.ti-video-clapper
                    li.ti-video-camera
                    li.ti-vector
                    li.ti-support
                    li.ti-stamp
                    li.ti-slice
                    li.ti-shortcode
                    li.ti-receipt
                    li.ti-pin2
                    li.ti-pin-alt
                    li.ti-pencil-alt2
                    li.ti-eraser
                    li.ti-more
                    li.ti-more-alt
                    li.ti-microphone-alt
                    li.ti-magnet
                    li.ti-line-double
                    li.ti-line-dotted
                    li.ti-line-dashed
                    li.ti-ink-pen
                    li.ti-info-alt
                    li.ti-help-alt
                    li.ti-headphone-alt
                    li.ti-gallery
                    li.ti-face-smile
                    li.ti-face-sad
                    li.ti-credit-card
                    li.ti-comments-smiley
                    li.ti-time
                    li.ti-share
                    li.ti-share-alt
                    li.ti-rocket
                    li.ti-new-window
                    li.ti-rss
                    li.ti-rss-alt
                  hr
                  p LAYOUT ICONS
                  ul
                    li.ti-layout-width-full
                    li.ti-layout-width-default
                    li.ti-layout-width-default-alt
                    li.ti-layout-tab
                    li.ti-layout-tab-window
                    li.ti-layout-tab-v
                    li.ti-layout-tab-min
                    li.ti-layout-slider
                    li.ti-layout-slider-alt
                    li.ti-layout-sidebar-right
                    li.ti-layout-sidebar-none
                    li.ti-layout-sidebar-left
                    li.ti-layout-placeholder
                    li.ti-layout-menu
                    li.ti-layout-menu-v
                    li.ti-layout-menu-separated
                    li.ti-layout-menu-full
                    li.ti-layout-media-right
                    li.ti-layout-media-right-alt
                    li.ti-layout-media-overlay
                    li.ti-layout-media-overlay-alt
                    li.ti-layout-media-overlay-alt-2
                    li.ti-layout-media-left
                    li.ti-layout-media-left-alt
                    li.ti-layout-media-center
                    li.ti-layout-media-center-alt
                    li.ti-layout-list-thumb
                    li.ti-layout-list-thumb-alt
                    li.ti-layout-list-post
                    li.ti-layout-list-large-image
                    li.ti-layout-line-solid
                    li.ti-layout-grid4
                    li.ti-layout-grid3
                    li.ti-layout-grid2
                    li.ti-layout-grid2-thumb
                    li.ti-layout-cta-right
                    li.ti-layout-cta-left
                    li.ti-layout-cta-center
                    li.ti-layout-cta-btn-right
                    li.ti-layout-cta-btn-left
                    li.ti-layout-column4
                    li.ti-layout-column3
                    li.ti-layout-column2
                    li.ti-layout-accordion-separated
                    li.ti-layout-accordion-merged
                    li.ti-layout-accordion-list
                    li.ti-widgetized
                    li.ti-widget
                    li.ti-widget-alt
                    li.ti-view-list
                    li.ti-view-list-alt
                    li.ti-view-grid
                    li.ti-upload
                    li.ti-download
                    li.ti-loop
                    li.ti-layout-sidebar-2
                    li.ti-layout-grid4-alt
                    li.ti-layout-grid3-alt
                    li.ti-layout-grid2-alt
                    li.ti-layout-column4-alt
                    li.ti-layout-column3-alt
                    li.ti-layout-column2-alt
                  hr
                  p BRAND ICONS
                  ul
                    li.ti-flickr(data-toggle='tooltip' title='ti-flickr')
                    li.ti-flickr-alt
                    li.ti-instagram
                    li.ti-google
                    li.ti-github
                    li.ti-facebook
                    li.ti-dropbox
                    li.ti-dropbox-alt
                    li.ti-dribbble
                    li.ti-apple
                    li.ti-android
                    li.ti-yahoo
                    li.ti-trello
                    li.ti-stack-overflow
                    li.ti-soundcloud
                    li.ti-sharethis
                    li.ti-sharethis-alt
                    li.ti-reddit
                    li.ti-microsoft
                    li.ti-microsoft-alt
                    li.ti-linux
                    li.ti-jsfiddle
                    li.ti-joomla
                    li.ti-html5
                    li.ti-css3
                    li.ti-drupal
                    li.ti-wordpress
                    li.ti-tumblr
                    li.ti-tumblr-alt
                    li.ti-skype
                    li.ti-youtube
                    li.ti-vimeo
                    li.ti-vimeo-alt
                    li.ti-twitter
                    li.ti-twitter-alt
                    li.ti-linkedin
                    li.ti-pinterest
                    li.ti-pinterest-alt
                    li.ti-themify-logo
                    li.ti-themify-favicon
                    li.ti-themify-favicon-alt
              // End of Themify Icons
              el-tab-pane(label='Material Icons' name='second')
                .entypo-tooltip
                  p A
                  ul
                    li
                      i.material-icons 3d_rotation
                    li
                      i.material-icons ac_unit
                    li
                      i.material-icons access_alarm
                    li
                      i.material-icons access_alarms
                    li
                      i.material-icons access_time
                    li
                      i.material-icons accessibility
                    li
                      i.material-icons accessible
                    li
                      i.material-icons account_balance
                    li
                      i.material-icons account_balance_wallet
                    li
                      i.material-icons account_box
                    li
                      i.material-icons account_circle
                    li
                      i.material-icons adb
                    li
                      i.material-icons add
                    li
                      i.material-icons add_a_photo
                    li
                      i.material-icons add_alarm
                    li
                      i.material-icons add_alert
                    li
                      i.material-icons add_box
                    li
                      i.material-icons add_circle
                    li
                      i.material-icons add_circle_outline
                    li
                      i.material-icons add_location
                    li
                      i.material-icons add_shopping_cart
                    li
                      i.material-icons add_to_photos
                    li
                      i.material-icons add_to_queue
                    li
                      i.material-icons adjust
                    li
                      i.material-icons airline_seat_flat
                    li
                      i.material-icons airline_seat_flat_angled
                    li
                      i.material-icons airline_seat_individual_suite
                    li
                      i.material-icons airline_seat_legroom_extra
                    li
                      i.material-icons airline_seat_legroom_normal
                    li
                      i.material-icons airline_seat_legroom_reduced
                    li
                      i.material-icons airline_seat_recline_extra
                    li
                      i.material-icons airline_seat_recline_normal
                    li
                      i.material-icons airplanemode_active
                    li
                      i.material-icons airplanemode_inactive
                    li
                      i.material-icons airplay
                    li
                      i.material-icons airport_shuttle
                    li
                      i.material-icons alarm
                    li
                      i.material-icons alarm_add
                    li
                      i.material-icons alarm_off
                    li
                      i.material-icons alarm_on
                    li
                      i.material-icons album
                    li
                      i.material-icons all_inclusive
                    li
                      i.material-icons all_out
                    li
                      i.material-icons android
                    li
                      i.material-icons announcement
                    li
                      i.material-icons apps
                    li
                      i.material-icons archive
                    li
                      i.material-icons arrow_back
                    li
                      i.material-icons arrow_downward
                    li
                      i.material-icons arrow_drop_down
                    li
                      i.material-icons arrow_drop_down_circle
                    li
                      i.material-icons arrow_drop_up
                    li
                      i.material-icons arrow_forward
                    li
                      i.material-icons arrow_upward
                    li
                      i.material-icons art_track
                    li
                      i.material-icons aspect_ratio
                    li
                      i.material-icons assessment
                    li
                      i.material-icons assignment
                    li
                      i.material-icons assignment_ind
                    li
                      i.material-icons assignment_late
                    li
                      i.material-icons assignment_return
                    li
                      i.material-icons assignment_returned
                    li
                      i.material-icons assignment_turned_in
                    li
                      i.material-icons assistant
                    li
                      i.material-icons assistant_photo
                    li
                      i.material-icons attach_file
                    li
                      i.material-icons attach_money
                    li
                      i.material-icons attachment
                    li
                      i.material-icons audiotrack
                    li
                      i.material-icons autorenew
                    li
                      i.material-icons av_timer
                  hr
                  p B
                  ul
                    li
                      i.material-icons backspace
                    li
                      i.material-icons backup
                    li
                      i.material-icons battery_alert
                    li
                      i.material-icons battery_charging_full
                    li
                      i.material-icons battery_full
                    li
                      i.material-icons battery_std
                    li
                      i.material-icons battery_unknown
                    li
                      i.material-icons beach_access
                    li
                      i.material-icons beenhere
                    li
                      i.material-icons block
                    li
                      i.material-icons bluetooth
                    li
                      i.material-icons bluetooth_audio
                    li
                      i.material-icons bluetooth_connected
                    li
                      i.material-icons bluetooth_disabled
                    li
                      i.material-icons bluetooth_searching
                    li
                      i.material-icons blur_circular
                    li
                      i.material-icons blur_linear
                    li
                      i.material-icons blur_off
                    li
                      i.material-icons blur_on
                    li
                      i.material-icons book
                    li
                      i.material-icons bookmark
                    li
                      i.material-icons bookmark_border
                    li
                      i.material-icons border_all
                    li
                      i.material-icons border_bottom
                    li
                      i.material-icons border_clear
                    li
                      i.material-icons border_color
                    li
                      i.material-icons border_horizontal
                    li
                      i.material-icons border_inner
                    li
                      i.material-icons border_left
                    li
                      i.material-icons border_outer
                    li
                      i.material-icons border_right
                    li
                      i.material-icons border_style
                    li
                      i.material-icons border_top
                    li
                      i.material-icons border_vertical
                    li
                      i.material-icons branding_watermark
                    li
                      i.material-icons brightness_1
                    li
                      i.material-icons brightness_2
                    li
                      i.material-icons brightness_3
                    li
                      i.material-icons brightness_4
                    li
                      i.material-icons brightness_5
                    li
                      i.material-icons brightness_6
                    li
                      i.material-icons brightness_7
                    li
                      i.material-icons brightness_auto
                    li
                      i.material-icons brightness_high
                    li
                      i.material-icons brightness_low
                    li
                      i.material-icons brightness_medium
                    li
                      i.material-icons broken_image
                    li
                      i.material-icons brush
                    li
                      i.material-icons bubble_chart
                    li
                      i.material-icons bug_report
                    li
                      i.material-icons build
                    li
                      i.material-icons burst_mode
                    li
                      i.material-icons business
                    li
                      i.material-icons business_center
                  hr
                  p C
                  ul
                    li
                      i.material-icons cached
                    li
                      i.material-icons cake
                    li
                      i.material-icons call
                    li
                      i.material-icons call_end
                    li
                      i.material-icons call_made
                    li
                      i.material-icons call_merge
                    li
                      i.material-icons call_missed
                    li
                      i.material-icons call_missed_outgoing
                    li
                      i.material-icons call_received
                    li
                      i.material-icons call_split
                    li
                      i.material-icons call_to_action
                    li
                      i.material-icons camera
                    li
                      i.material-icons camera_alt
                    li
                      i.material-icons camera_enhance
                    li
                      i.material-icons camera_front
                    li
                      i.material-icons camera_rear
                    li
                      i.material-icons camera_roll
                    li
                      i.material-icons cancel
                    li
                      i.material-icons card_giftcard
                    li
                      i.material-icons card_membership
                    li
                      i.material-icons card_travel
                    li
                      i.material-icons casino
                    li
                      i.material-icons cast
                    li
                      i.material-icons cast_connected
                    li
                      i.material-icons center_focus_strong
                    li
                      i.material-icons center_focus_weak
                    li
                      i.material-icons change_history
                    li
                      i.material-icons chat
                    li
                      i.material-icons chat_bubble
                    li
                      i.material-icons chat_bubble_outline
                    li
                      i.material-icons check
                    li
                      i.material-icons check_box
                    li
                      i.material-icons check_box_outline_blank
                    li
                      i.material-icons check_circle
                    li
                      i.material-icons chevron_left
                    li
                      i.material-icons chevron_right
                    li
                      i.material-icons child_care
                    li
                      i.material-icons child_friendly
                    li
                      i.material-icons chrome_reader_mode
                    li
                      i.material-icons class
                    li
                      i.material-icons clear
                    li
                      i.material-icons clear_all
                    li
                      i.material-icons close
                    li
                      i.material-icons closed_caption
                    li
                      i.material-icons cloud
                    li
                      i.material-icons cloud_circle
                    li
                      i.material-icons cloud_done
                    li
                      i.material-icons cloud_download
                    li
                      i.material-icons cloud_off
                    li
                      i.material-icons cloud_queue
                    li
                      i.material-icons cloud_upload
                    li
                      i.material-icons code
                    li
                      i.material-icons collections
                    li
                      i.material-icons collections_bookmark
                    li
                      i.material-icons color_lens
                    li
                      i.material-icons colorize
                    li
                      i.material-icons comment
                    li
                      i.material-icons compare
                    li
                      i.material-icons compare_arrows
                    li
                      i.material-icons computer
                    li
                      i.material-icons confirmation_number
                    li
                      i.material-icons contact_mail
                    li
                      i.material-icons contact_phone
                    li
                      i.material-icons contacts
                    li
                      i.material-icons content_copy
                    li
                      i.material-icons content_cut
                    li
                      i.material-icons content_paste
                    li
                      i.material-icons control_point
                    li
                      i.material-icons control_point_duplicate
                    li
                      i.material-icons copyright
                    li
                      i.material-icons create
                    li
                      i.material-icons create_new_folder
                    li
                      i.material-icons credit_card
                    li
                      i.material-icons crop
                    li
                      i.material-icons crop_16_9
                    li
                      i.material-icons crop_3_2
                    li
                      i.material-icons crop_5_4
                    li
                      i.material-icons crop_7_5
                    li
                      i.material-icons crop_din
                    li
                      i.material-icons crop_free
                    li
                      i.material-icons crop_landscape
                    li
                      i.material-icons crop_original
                    li
                      i.material-icons crop_portrait
                    li
                      i.material-icons crop_rotate
                    li
                      i.material-icons crop_square
                  hr
                  p D
                  ul
                    li
                      i.material-icons dashboard
                    li
                      i.material-icons data_usage
                    li
                      i.material-icons date_range
                    li
                      i.material-icons dehaze
                    li
                      i.material-icons delete
                    li
                      i.material-icons delete_forever
                    li
                      i.material-icons delete_sweep
                    li
                      i.material-icons description
                    li
                      i.material-icons desktop_mac
                    li
                      i.material-icons desktop_windows
                    li
                      i.material-icons details
                    li
                      i.material-icons developer_board
                    li
                      i.material-icons developer_mode
                    li
                      i.material-icons device_hub
                    li
                      i.material-icons devices
                    li
                      i.material-icons devices_other
                    li
                      i.material-icons dialer_sip
                    li
                      i.material-icons dialpad
                    li
                      i.material-icons directions
                    li
                      i.material-icons directions_bike
                    li
                      i.material-icons directions_boat
                    li
                      i.material-icons directions_bus
                    li
                      i.material-icons directions_car
                    li
                      i.material-icons directions_railway
                    li
                      i.material-icons directions_run
                    li
                      i.material-icons directions_subway
                    li
                      i.material-icons directions_transit
                    li
                      i.material-icons directions_walk
                    li
                      i.material-icons disc_full
                    li
                      i.material-icons dns
                    li
                      i.material-icons do_not_disturb
                    li
                      i.material-icons do_not_disturb_alt
                    li
                      i.material-icons do_not_disturb_off
                    li
                      i.material-icons do_not_disturb_on
                    li
                      i.material-icons dock
                    li
                      i.material-icons domain
                    li
                      i.material-icons done
                    li
                      i.material-icons done_all
                    li
                      i.material-icons donut_large
                    li
                      i.material-icons donut_small
                    li
                      i.material-icons drafts
                    li
                      i.material-icons drag_handle
                    li
                      i.material-icons drive_eta
                    li
                      i.material-icons dvr
                  hr
                  p E
                  ul
                    li
                      i.material-icons edit
                    li
                      i.material-icons edit_location
                    li
                      i.material-icons eject
                    li
                      i.material-icons email
                    li
                      i.material-icons enhanced_encryption
                    li
                      i.material-icons equalizer
                    li
                      i.material-icons error
                    li
                      i.material-icons error_outline
                    li
                      i.material-icons euro_symbol
                    li
                      i.material-icons ev_station
                    li
                      i.material-icons event
                    li
                      i.material-icons event_available
                    li
                      i.material-icons event_busy
                    li
                      i.material-icons event_note
                    li
                      i.material-icons event_seat
                    li
                      i.material-icons exit_to_app
                    li
                      i.material-icons expand_less
                    li
                      i.material-icons expand_more
                    li
                      i.material-icons explicit
                    li
                      i.material-icons explore
                    li
                      i.material-icons exposure
                    li
                      i.material-icons exposure_neg_1
                    li
                      i.material-icons exposure_neg_2
                    li
                      i.material-icons exposure_plus_1
                    li
                      i.material-icons exposure_plus_2
                    li
                      i.material-icons exposure_zero
                    li
                      i.material-icons extension
                  hr
                  p F
                  ul
                    li
                      i.material-icons face
                    li
                      i.material-icons fast_forward
                    li
                      i.material-icons fast_rewind
                    li
                      i.material-icons favorite
                    li
                      i.material-icons favorite_border
                    li
                      i.material-icons featured_play_list
                    li
                      i.material-icons featured_video
                    li
                      i.material-icons feedback
                    li
                      i.material-icons fiber_dvr
                    li
                      i.material-icons fiber_manual_record
                    li
                      i.material-icons fiber_new
                    li
                      i.material-icons fiber_pin
                    li
                      i.material-icons fiber_smart_record
                    li
                      i.material-icons file_download
                    li
                      i.material-icons file_upload
                    li
                      i.material-icons filter
                    li
                      i.material-icons filter_1
                    li
                      i.material-icons filter_2
                    li
                      i.material-icons filter_3
                    li
                      i.material-icons filter_4
                    li
                      i.material-icons filter_5
                    li
                      i.material-icons filter_6
                    li
                      i.material-icons filter_7
                    li
                      i.material-icons filter_8
                    li
                      i.material-icons filter_9
                    li
                      i.material-icons filter_9_plus
                    li
                      i.material-icons filter_b_and_w
                    li
                      i.material-icons filter_center_focus
                    li
                      i.material-icons filter_drama
                    li
                      i.material-icons filter_frames
                    li
                      i.material-icons filter_hdr
                    li
                      i.material-icons filter_list
                    li
                      i.material-icons filter_none
                    li
                      i.material-icons filter_tilt_shift
                    li
                      i.material-icons filter_vintage
                    li
                      i.material-icons find_in_page
                    li
                      i.material-icons find_replace
                    li
                      i.material-icons fingerprint
                    li
                      i.material-icons first_page
                    li
                      i.material-icons fitness_center
                    li
                      i.material-icons flag
                    li
                      i.material-icons flare
                    li
                      i.material-icons flash_auto
                    li
                      i.material-icons flash_off
                    li
                      i.material-icons flash_on
                    li
                      i.material-icons flight
                    li
                      i.material-icons flight_land
                    li
                      i.material-icons flight_takeoff
                    li
                      i.material-icons flip
                    li
                      i.material-icons flip_to_back
                    li
                      i.material-icons flip_to_front
                    li
                      i.material-icons folder
                    li
                      i.material-icons folder_open
                    li
                      i.material-icons folder_shared
                    li
                      i.material-icons folder_special
                    li
                      i.material-icons font_download
                    li
                      i.material-icons format_align_center
                    li
                      i.material-icons format_align_justify
                    li
                      i.material-icons format_align_left
                    li
                      i.material-icons format_align_right
                    li
                      i.material-icons format_bold
                    li
                      i.material-icons format_clear
                    li
                      i.material-icons format_color_fill
                    li
                      i.material-icons format_color_reset
                    li
                      i.material-icons format_color_text
                    li
                      i.material-icons format_indent_decrease
                    li
                      i.material-icons format_indent_increase
                    li
                      i.material-icons format_italic
                    li
                      i.material-icons format_line_spacing
                    li
                      i.material-icons format_list_bulleted
                    li
                      i.material-icons format_list_numbered
                    li
                      i.material-icons format_paint
                    li
                      i.material-icons format_quote
                    li
                      i.material-icons format_shapes
                    li
                      i.material-icons format_size
                    li
                      i.material-icons format_strikethrough
                    li
                      i.material-icons format_textdirection_l_to_r
                    li
                      i.material-icons format_textdirection_r_to_l
                    li
                      i.material-icons format_underlined
                    li
                      i.material-icons forum
                    li
                      i.material-icons forward
                    li
                      i.material-icons forward_10
                    li
                      i.material-icons forward_30
                    li
                      i.material-icons forward_5
                    li
                      i.material-icons free_breakfast
                    li
                      i.material-icons fullscreen
                    li
                      i.material-icons fullscreen_exit
                    li
                      i.material-icons functions
                  hr
                  p G
                  ul
                    li
                      i.material-icons g_translate
                    li
                      i.material-icons gamepad
                    li
                      i.material-icons games
                    li
                      i.material-icons gavel
                    li
                      i.material-icons gesture
                    li
                      i.material-icons get_app
                    li
                      i.material-icons gif
                    li
                      i.material-icons golf_course
                    li
                      i.material-icons gps_fixed
                    li
                      i.material-icons gps_not_fixed
                    li
                      i.material-icons gps_off
                    li
                      i.material-icons grade
                    li
                      i.material-icons gradient
                    li
                      i.material-icons grain
                    li
                      i.material-icons graphic_eq
                    li
                      i.material-icons grid_off
                    li
                      i.material-icons grid_on
                    li
                      i.material-icons group
                    li
                      i.material-icons group_add
                    li
                      i.material-icons group_work
                  hr
                  p H
                  ul
                    li
                      i.material-icons hd
                    li
                      i.material-icons hdr_off
                    li
                      i.material-icons hdr_on
                    li
                      i.material-icons hdr_strong
                    li
                      i.material-icons hdr_weak
                    li
                      i.material-icons headset
                    li
                      i.material-icons headset_mic
                    li
                      i.material-icons healing
                    li
                      i.material-icons hearing
                    li
                      i.material-icons help
                    li
                      i.material-icons help_outline
                    li
                      i.material-icons high_quality
                    li
                      i.material-icons highlight
                    li
                      i.material-icons highlight_off
                    li
                      i.material-icons history
                    li
                      i.material-icons home
                    li
                      i.material-icons hot_tub
                    li
                      i.material-icons hotel
                    li
                      i.material-icons hourglass_empty
                    li
                      i.material-icons hourglass_full
                    li
                      i.material-icons http
                    li
                      i.material-icons https
                  hr
                  p I
                  ul
                    li
                      i.material-icons image
                    li
                      i.material-icons image_aspect_ratio
                    li
                      i.material-icons import_contacts
                    li
                      i.material-icons import_export
                    li
                      i.material-icons important_devices
                    li
                      i.material-icons inbox
                    li
                      i.material-icons indeterminate_check_box
                    li
                      i.material-icons info
                    li
                      i.material-icons info_outline
                    li
                      i.material-icons input
                    li
                      i.material-icons insert_chart
                    li
                      i.material-icons insert_comment
                    li
                      i.material-icons insert_drive_file
                    li
                      i.material-icons insert_emoticon
                    li
                      i.material-icons insert_invitation
                    li
                      i.material-icons insert_link
                    li
                      i.material-icons insert_photo
                    li
                      i.material-icons invert_colors
                    li
                      i.material-icons invert_colors_off
                    li
                      i.material-icons iso
                  hr
                  p K
                  ul
                    li
                      i.material-icons keyboard
                    li
                      i.material-icons keyboard_arrow_down
                    li
                      i.material-icons keyboard_arrow_left
                    li
                      i.material-icons keyboard_arrow_right
                    li
                      i.material-icons keyboard_arrow_up
                    li
                      i.material-icons keyboard_backspace
                    li
                      i.material-icons keyboard_capslock
                    li
                      i.material-icons keyboard_hide
                    li
                      i.material-icons keyboard_return
                    li
                      i.material-icons keyboard_tab
                    li
                      i.material-icons keyboard_voice
                    li
                      i.material-icons kitchen
                  hr
                  p L
                  ul
                    li
                      i.material-icons label
                    li
                      i.material-icons label_outline
                    li
                      i.material-icons landscape
                    li
                      i.material-icons language
                    li
                      i.material-icons laptop
                    li
                      i.material-icons laptop_chromebook
                    li
                      i.material-icons laptop_mac
                    li
                      i.material-icons laptop_windows
                    li
                      i.material-icons last_page
                    li
                      i.material-icons launch
                    li
                      i.material-icons layers
                    li
                      i.material-icons layers_clear
                    li
                      i.material-icons leak_add
                    li
                      i.material-icons leak_remove
                    li
                      i.material-icons lens
                    li
                      i.material-icons library_add
                    li
                      i.material-icons library_books
                    li
                      i.material-icons library_music
                    li
                      i.material-icons lightbulb_outline
                    li
                      i.material-icons line_style
                    li
                      i.material-icons line_weight
                    li
                      i.material-icons linear_scale
                    li
                      i.material-icons link
                    li
                      i.material-icons linked_camera
                    li
                      i.material-icons list
                    li
                      i.material-icons live_help
                    li
                      i.material-icons live_tv
                    li
                      i.material-icons local_activity
                    li
                      i.material-icons local_airport
                    li
                      i.material-icons local_atm
                    li
                      i.material-icons local_bar
                    li
                      i.material-icons local_cafe
                    li
                      i.material-icons local_car_wash
                    li
                      i.material-icons local_convenience_store
                    li
                      i.material-icons local_dining
                    li
                      i.material-icons local_drink
                    li
                      i.material-icons local_florist
                    li
                      i.material-icons local_gas_station
                    li
                      i.material-icons local_grocery_store
                    li
                      i.material-icons local_hospital
                    li
                      i.material-icons local_hotel
                    li
                      i.material-icons local_laundry_service
                    li
                      i.material-icons local_library
                    li
                      i.material-icons local_mall
                    li
                      i.material-icons local_movies
                    li
                      i.material-icons local_offer
                    li
                      i.material-icons local_parking
                    li
                      i.material-icons local_pharmacy
                    li
                      i.material-icons local_phone
                    li
                      i.material-icons local_pizza
                    li
                      i.material-icons local_play
                    li
                      i.material-icons local_post_office
                    li
                      i.material-icons local_printshop
                    li
                      i.material-icons local_see
                    li
                      i.material-icons local_shipping
                    li
                      i.material-icons local_taxi
                    li
                      i.material-icons location_city
                    li
                      i.material-icons location_disabled
                    li
                      i.material-icons location_off
                    li
                      i.material-icons location_on
                    li
                      i.material-icons location_searching
                    li
                      i.material-icons lock
                    |  &gt;
                    li
                      i.material-icons lock_open
                    li
                      i.material-icons lock_outline
                    li
                      i.material-icons looks
                    li
                      i.material-icons looks_3
                    li
                      i.material-icons looks_4
                    li
                      i.material-icons looks_5
                    li
                      i.material-icons looks_6
                    li
                      i.material-icons looks_one
                    li
                      i.material-icons looks_two
                    li
                      i.material-icons loop
                    li
                      i.material-icons loupe
                    li
                      i.material-icons low_priority
                    li
                      i.material-icons loyalty
                  hr
                  p M
                  ul
                    li
                      i.material-icons mail
                    li
                      i.material-icons mail_outline
                    li
                      i.material-icons map
                    li
                      i.material-icons markunread
                    li
                      i.material-icons markunread_mailbox
                    li
                      i.material-icons memory
                    li
                      i.material-icons menu
                    li
                      i.material-icons merge_type
                    li
                      i.material-icons message
                    li
                      i.material-icons mic
                    li
                      i.material-icons mic_none
                    li
                      i.material-icons mic_off
                    li
                      i.material-icons mms
                    li
                      i.material-icons mode_comment
                    li
                      i.material-icons mode_edit
                    li
                      i.material-icons monetization_on
                    li
                      i.material-icons money_off
                    li
                      i.material-icons monochrome_photos
                    li
                      i.material-icons mood
                    li
                      i.material-icons mood_bad
                    li
                      i.material-icons more
                    li
                      i.material-icons more_horiz
                    li
                      i.material-icons more_vert
                    li
                      i.material-icons motorcycle
                    li
                      i.material-icons mouse
                    li
                      i.material-icons move_to_inbox
                    li
                      i.material-icons movie
                    li
                      i.material-icons movie_creation
                    li
                      i.material-icons movie_filter
                    li
                      i.material-icons multiline_chart
                    li
                      i.material-icons music_note
                    li
                      i.material-icons music_video
                    li
                      i.material-icons my_location
                  hr
                  p N
                  ul
                    li
                      i.material-icons nature
                    li
                      i.material-icons nature_people
                    li
                      i.material-icons navigate_before
                    li
                      i.material-icons navigate_next
                    li
                      i.material-icons navigation
                    li
                      i.material-icons near_me
                    li
                      i.material-icons network_cell
                    li
                      i.material-icons network_check
                    li
                      i.material-icons network_locked
                    li
                      i.material-icons network_wifi
                    li
                      i.material-icons new_releases
                    li
                      i.material-icons next_week
                    li
                      i.material-icons nfc
                    li
                      i.material-icons no_encryption
                    li
                      i.material-icons no_sim
                    li
                      i.material-icons not_interested
                    li
                      i.material-icons note
                    li
                      i.material-icons note_add
                    li
                      i.material-icons notifications
                    li
                      i.material-icons notifications_active
                    li
                      i.material-icons notifications_none
                    li
                      i.material-icons notifications_off
                    li
                      i.material-icons notifications_paused
                  hr
                  p o
                  ul
                    li
                      i.material-icons offline_pin
                    li
                      i.material-icons ondemand_video
                    li
                      i.material-icons opacity
                    li
                      i.material-icons open_in_browser
                    li
                      i.material-icons open_in_new
                    li
                      i.material-icons open_with
                  hr
                  p P
                  ul
                    li
                      i.material-icons pages
                    li
                      i.material-icons pageview
                    li
                      i.material-icons palette
                    li
                      i.material-icons pan_tool
                    li
                      i.material-icons panorama
                    li
                      i.material-icons panorama_fish_eye
                    li
                      i.material-icons panorama_horizontal
                    li
                      i.material-icons panorama_vertical
                    li
                      i.material-icons panorama_wide_angle
                    li
                      i.material-icons party_mode
                    li
                      i.material-icons pause
                    li
                      i.material-icons pause_circle_filled
                    li
                      i.material-icons pause_circle_outline
                    li
                      i.material-icons payment
                    li
                      i.material-icons people
                    li
                      i.material-icons people_outline
                    li
                      i.material-icons perm_camera_mic
                    li
                      i.material-icons perm_contact_calendar
                    li
                      i.material-icons perm_data_setting
                    li
                      i.material-icons perm_device_information
                    li
                      i.material-icons perm_identity
                    li
                      i.material-icons perm_media
                    li
                      i.material-icons perm_phone_msg
                    li
                      i.material-icons perm_scan_wifi
                    li
                      i.material-icons person
                    li
                      i.material-icons person_add
                    li
                      i.material-icons person_outline
                    li
                      i.material-icons person_pin
                    li
                      i.material-icons person_pin_circle
                    li
                      i.material-icons personal_video
                    li
                      i.material-icons pets
                    li
                      i.material-icons phone
                    li
                      i.material-icons phone_android
                    li
                      i.material-icons phone_bluetooth_speaker
                    li
                      i.material-icons phone_forwarded
                    li
                      i.material-icons phone_in_talk
                    li
                      i.material-icons phone_iphone
                    li
                      i.material-icons phone_locked
                    li
                      i.material-icons phone_missed
                    li
                      i.material-icons phone_paused
                    li
                      i.material-icons phonelink
                    li
                      i.material-icons phonelink_erase
                    li
                      i.material-icons phonelink_lock
                    li
                      i.material-icons phonelink_off
                    li
                      i.material-icons phonelink_ring
                    li
                      i.material-icons phonelink_setup
                    li
                      i.material-icons photo
                    li
                      i.material-icons photo_album
                    li
                      i.material-icons photo_camera
                    li
                      i.material-icons photo_filter
                    li
                      i.material-icons photo_library
                    li
                      i.material-icons photo_size_select_actual
                    li
                      i.material-icons photo_size_select_large
                    li
                      i.material-icons photo_size_select_small
                    li
                      i.material-icons picture_as_pdf
                    li
                      i.material-icons picture_in_picture
                    li
                      i.material-icons picture_in_picture_alt
                    li
                      i.material-icons pie_chart
                    li
                      i.material-icons pie_chart_outlined
                    li
                      i.material-icons pin_drop
                    li
                      i.material-icons place
                    li
                      i.material-icons play_arrow
                    li
                      i.material-icons play_circle_filled
                    li
                      i.material-icons play_circle_outline
                    li
                      i.material-icons play_for_work
                    li
                      i.material-icons playlist_add
                    li
                      i.material-icons playlist_add_check
                    li
                      i.material-icons playlist_play
                    li
                      i.material-icons plus_one
                    li
                      i.material-icons poll
                    li
                      i.material-icons polymer
                    li
                      i.material-icons pool
                    li
                      i.material-icons portable_wifi_off
                    li
                      i.material-icons portrait
                    li
                      i.material-icons power
                    li
                      i.material-icons power_input
                    li
                      i.material-icons power_settings_new
                    li
                      i.material-icons pregnant_woman
                    li
                      i.material-icons present_to_all
                    li
                      i.material-icons print
                    li
                      i.material-icons priority_high
                    li
                      i.material-icons public
                    li
                      i.material-icons publish
                  hr
                  p Q -R
                  ul
                    li
                      i.material-icons query_builder
                    li
                      i.material-icons question_answer
                    li
                      i.material-icons queue
                    li
                      i.material-icons queue_music
                    li
                      i.material-icons queue_play_next
                    li
                      i.material-icons radio
                    li
                      i.material-icons radio_button_checked
                    li
                      i.material-icons radio_button_unchecked
                    li
                      i.material-icons rate_review
                    li
                      i.material-icons receipt
                    li
                      i.material-icons recent_actors
                    li
                      i.material-icons record_voice_over
                    li
                      i.material-icons redeem
                    li
                      i.material-icons redo
                    li
                      i.material-icons refresh
                    li
                      i.material-icons remove
                    li
                      i.material-icons remove_circle
                    li
                      i.material-icons remove_circle_outline
                    li
                      i.material-icons remove_from_queue
                    li
                      i.material-icons remove_red_eye
                    li
                      i.material-icons remove_shopping_cart
                    li
                      i.material-icons reorder
                    li
                      i.material-icons repeat
                    li
                      i.material-icons repeat_one
                    li
                      i.material-icons replay
                    li
                      i.material-icons replay_10
                    li
                      i.material-icons replay_30
                    li
                      i.material-icons replay_5
                    li
                      i.material-icons reply
                    li
                      i.material-icons reply_all
                    li
                      i.material-icons report
                    li
                      i.material-icons report_problem
                    li
                      i.material-icons restaurant
                    li
                      i.material-icons restaurant_menu
                    li
                      i.material-icons restore
                    li
                      i.material-icons restore_page
                    li
                      i.material-icons ring_volume
                    li
                      i.material-icons room
                    li
                      i.material-icons room_service
                    li
                      i.material-icons rotate_90_degrees_ccw
                    li
                      i.material-icons rotate_left
                    li
                      i.material-icons rotate_right
                    li
                      i.material-icons rounded_corner
                    li
                      i.material-icons router
                    li
                      i.material-icons rowing
                    li
                      i.material-icons rss_feed
                    li
                      i.material-icons rv_hookup
                  hr
                  p S
                  ul
                    li
                      i.material-icons satellite
                    li
                      i.material-icons save
                    li
                      i.material-icons scanner
                    li
                      i.material-icons schedule
                    li
                      i.material-icons school
                    li
                      i.material-icons screen_lock_landscape
                    li
                      i.material-icons screen_lock_portrait
                    li
                      i.material-icons screen_lock_rotation
                    li
                      i.material-icons screen_rotation
                    li
                      i.material-icons screen_share
                    li
                      i.material-icons sd_card
                    li
                      i.material-icons sd_storage
                    li
                      i.material-icons search
                    li
                      i.material-icons security
                    li
                      i.material-icons select_all
                    li
                      i.material-icons send
                    li
                      i.material-icons sentiment_dissatisfied
                    li
                      i.material-icons sentiment_neutral
                    li
                      i.material-icons sentiment_satisfied
                    li
                      i.material-icons sentiment_very_dissatisfied
                    li
                      i.material-icons sentiment_very_satisfied
                    li
                      i.material-icons settings
                    li
                      i.material-icons settings_applications
                    li
                      i.material-icons settings_backup_restore
                    li
                      i.material-icons settings_bluetooth
                    li
                      i.material-icons settings_brightness
                    li
                      i.material-icons settings_cell
                    li
                      i.material-icons settings_ethernet
                    li
                      i.material-icons settings_input_antenna
                    li
                      i.material-icons settings_input_component
                    li
                      i.material-icons settings_input_composite
                    li
                      i.material-icons settings_input_hdmi
                    li
                      i.material-icons settings_input_svideo
                    li
                      i.material-icons settings_overscan
                    li
                      i.material-icons settings_phone
                    li
                      i.material-icons settings_power
                    li
                      i.material-icons settings_remote
                    li
                      i.material-icons settings_system_daydream
                    li
                      i.material-icons settings_voice
                    li
                      i.material-icons share
                    li
                      i.material-icons shop
                    li
                      i.material-icons shop_two
                    li
                      i.material-icons shopping_basket
                    li
                      i.material-icons shopping_cart
                    li
                      i.material-icons short_text
                    li
                      i.material-icons show_chart
                    li
                      i.material-icons shuffle
                    li
                      i.material-icons signal_cellular_4_bar
                    li
                      i.material-icons signal_cellular_connected_no_internet_4_bar
                    li
                      i.material-icons signal_cellular_no_sim
                    li
                      i.material-icons signal_cellular_null
                    li
                      i.material-icons signal_cellular_off
                    li
                      i.material-icons signal_wifi_4_bar
                    li
                      i.material-icons signal_wifi_4_bar_lock
                    li
                      i.material-icons signal_wifi_off
                    li
                      i.material-icons sim_card
                    li
                      i.material-icons sim_card_alert
                    li
                      i.material-icons skip_next
                    li
                      i.material-icons skip_previous
                    li
                      i.material-icons slideshow
                    li
                      i.material-icons slow_motion_video
                    li
                      i.material-icons smartphone
                    li
                      i.material-icons smoke_free
                    li
                      i.material-icons smoking_rooms
                    li
                      i.material-icons sms
                    li
                      i.material-icons sms_failed
                    li
                      i.material-icons snooze
                    li
                      i.material-icons sort
                    li
                      i.material-icons sort_by_alpha
                    li
                      i.material-icons spa
                    li
                      i.material-icons space_bar
                    li
                      i.material-icons speaker
                    li
                      i.material-icons speaker_group
                    li
                      i.material-icons speaker_notes
                    li
                      i.material-icons speaker_notes_off
                    li
                      i.material-icons speaker_phone
                    li
                      i.material-icons spellcheck
                    li
                      i.material-icons star
                    li
                      i.material-icons star_border
                    li
                      i.material-icons star_half
                    li
                      i.material-icons stars
                    li
                      i.material-icons stay_current_landscape
                    li
                      i.material-icons stay_current_portrait
                    li
                      i.material-icons stay_primary_landscape
                    li
                      i.material-icons stay_primary_portrait
                    li
                      i.material-icons stop
                    li
                      i.material-icons stop_screen_share
                    li
                      i.material-icons storage
                    li
                      i.material-icons store
                    li
                      i.material-icons store_mall_directory
                    li
                      i.material-icons straighten
                    li
                      i.material-icons streetview
                    li
                      i.material-icons strikethrough_s
                    li
                      i.material-icons style
                    li
                      i.material-icons subdirectory_arrow_left
                    li
                      i.material-icons subdirectory_arrow_right
                    li
                      i.material-icons subject
                    li
                      i.material-icons subscriptions
                    li
                      i.material-icons subtitles
                    li
                      i.material-icons subway
                    li
                      i.material-icons supervisor_account
                    li
                      i.material-icons surround_sound
                    li
                      i.material-icons swap_calls
                    li
                      i.material-icons swap_horiz
                    li
                      i.material-icons swap_vert
                    li
                      i.material-icons swap_vertical_circle
                    li
                      i.material-icons switch_camera
                    li
                      i.material-icons switch_video
                    li
                      i.material-icons sync
                    li
                      i.material-icons sync_disabled
                    li
                      i.material-icons sync_problem
                    li
                      i.material-icons system_update
                    li
                      i.material-icons system_update_alt
                  hr
                  p T - Z
                  ul
                    li
                      i.material-icons tab
                    li
                      i.material-icons tab_unselected
                    li
                      i.material-icons tablet
                    li
                      i.material-icons tablet_android
                    li
                      i.material-icons tablet_mac
                    li
                      i.material-icons tag_faces
                    li
                      i.material-icons tap_and_play
                    li
                      i.material-icons terrain
                    li
                      i.material-icons text_fields
                    li
                      i.material-icons text_format
                    li
                      i.material-icons textsms
                    li
                      i.material-icons texture
                    li
                      i.material-icons theaters
                    li
                      i.material-icons thumb_down
                    li
                      i.material-icons thumb_up
                    li
                      i.material-icons thumbs_up_down
                    li
                      i.material-icons time_to_leave
                    li
                      i.material-icons timelapse
                    li
                      i.material-icons timeline
                    li
                      i.material-icons timer
                    li
                      i.material-icons timer_10
                    li
                      i.material-icons timer_3
                    li
                      i.material-icons timer_off
                    li
                      i.material-icons title
                    li
                      i.material-icons toc
                    li
                      i.material-icons today
                    li
                      i.material-icons toll
                    li
                      i.material-icons tonality
                    li
                      i.material-icons touch_app
                    li
                      i.material-icons toys
                    li
                      i.material-icons track_changes
                    li
                      i.material-icons traffic
                    li
                      i.material-icons train
                    li
                      i.material-icons tram
                    li
                      i.material-icons transfer_within_a_station
                    li
                      i.material-icons transform
                    li
                      i.material-icons translate
                    li
                      i.material-icons trending_down
                    li
                      i.material-icons trending_flat
                    li
                      i.material-icons trending_up
                    li
                      i.material-icons tune
                    li
                      i.material-icons turned_in
                    li
                      i.material-icons turned_in_not
                    li
                      i.material-icons tv
                    li
                      i.material-icons unarchive
                    li
                      i.material-icons undo
                    li
                      i.material-icons unfold_less
                    li
                      i.material-icons unfold_more
                    li
                      i.material-icons update
                    li
                      i.material-icons usb
                    li
                      i.material-icons verified_user
                    li
                      i.material-icons vertical_align_bottom
                    li
                      i.material-icons vertical_align_center
                    li
                      i.material-icons vertical_align_top
                    li
                      i.material-icons vibration
                    li
                      i.material-icons video_call
                    li
                      i.material-icons video_label
                    li
                      i.material-icons video_library
                    li
                      i.material-icons videocam
                    li
                      i.material-icons videocam_off
                    li
                      i.material-icons videogame_asset
                    li
                      i.material-icons view_agenda
                    li
                      i.material-icons view_array
                    li
                      i.material-icons view_carousel
                    li
                      i.material-icons view_column
                    li
                      i.material-icons view_comfy
                    li
                      i.material-icons view_compact
                    li
                      i.material-icons view_day
                    li
                      i.material-icons view_headline
                    li
                      i.material-icons view_list
                    li
                      i.material-icons view_module
                    li
                      i.material-icons view_quilt
                    li
                      i.material-icons view_stream
                    li
                      i.material-icons view_week
                    li
                      i.material-icons vignette
                    li
                      i.material-icons visibility
                    li
                      i.material-icons visibility_off
                    li
                      i.material-icons voice_chat
                    li
                      i.material-icons voicemail
                    li
                      i.material-icons volume_down
                    li
                      i.material-icons volume_mute
                    li
                      i.material-icons volume_off
                    li
                      i.material-icons volume_up
                    li
                      i.material-icons vpn_key
                    li
                      i.material-icons vpn_lock
                    li
                      i.material-icons wallpaper
                    li
                      i.material-icons warning
                    li
                      i.material-icons watch
                    li
                      i.material-icons watch_later
                    li
                      i.material-icons wb_auto
                    li
                      i.material-icons wb_cloudy
                    li
                      i.material-icons wb_incandescent
                    li
                      i.material-icons wb_iridescent
                    li
                      i.material-icons wb_sunny
                    li
                      i.material-icons wc
                    li
                      i.material-icons web
                    li
                      i.material-icons web_asset
                    li
                      i.material-icons weekend
                    li
                      i.material-icons whatshot
                    li
                      i.material-icons widgets
                    li
                      i.material-icons wifi
                    li
                      i.material-icons wifi_lock
                    li
                      i.material-icons wifi_tethering
                    li
                      i.material-icons work
                    li
                      i.material-icons wrap_text
                    li
                      i.material-icons youtube_searched_for
                    li
                      i.material-icons zoom_in
                    li
                      i.material-icons zoom_out
                    li
                      i.material-icons zoom_out_map
              el-tab-pane(label='Drip Icons 2.0' name='third')
                .entypo-tooltip
                  p WEB APP ICONS
                  ul
                    li.dripicons-alarm(v-tooltip.top="'alarm'")
                    li.dripicons-align-center(v-tooltip.top="'align-center'")
                    li.dripicons-align-justify(v-tooltip.top="'align-justify'")
                    li.dripicons-align-left(v-tooltip.top="'align-left'")
                    li.dripicons-align-right(v-tooltip.top="'align-right'")
                    li.dripicons-anchor(v-tooltip.top="'anchor'")
                    li.dripicons-archive(v-tooltip.top="'archive'")
                    li.dripicons-arrow-down(v-tooltip.top="'arrow-down'")
                    li.dripicons-arrow-left(v-tooltip.top="'arrow-left'")
                    li.dripicons-arrow-right(v-tooltip.top="'arrow-right'")
                    li.dripicons-arrow-thin-down(v-tooltip.top="'arrow-thin-down'")
                    li.dripicons-arrow-thin-left(v-tooltip.top="'arrow-thin-left'")
                    li.dripicons-arrow-thin-right(v-tooltip.top="'arrow-thin-right'")
                    li.dripicons-arrow-thin-up(v-tooltip.top="'arrow-thin-up'")
                    li.dripicons-arrow-up(v-tooltip.top="'arrow-up'")
                    li.dripicons-article(v-tooltip.top="'article'")
                    li.dripicons-backspace(v-tooltip.top="'backspace'")
                    li.dripicons-basket(v-tooltip.top="'basket'")
                    li.dripicons-basketball(v-tooltip.top="'basketball'")
                    li.dripicons-battery-empty(v-tooltip.top="'battery-empty'")
                    li.dripicons-battery-full(v-tooltip.top="'battery-full'")
                    li.dripicons-battery-low(v-tooltip.top="'battery-low'")
                    li.dripicons-battery-medium(v-tooltip.top="'battery-medium'")
                    li.dripicons-bell(v-tooltip.top="'bell'")
                    li.dripicons-blog(v-tooltip.top="'blog'")
                    li.dripicons-bluetooth(v-tooltip.top="'bluetooth'")
                    li.dripicons-bold(v-tooltip.top="'bold'")
                    li.dripicons-bookmark(v-tooltip.top="'bookmark'")
                    li.dripicons-bookmarks(v-tooltip.top="'bookmarks'")
                    li.dripicons-box(v-tooltip.top="'box'")
                    li.dripicons-briefcase(v-tooltip.top="'briefcase'")
                    li.dripicons-brightness-low(v-tooltip.top="'brightness-low'")
                    li.dripicons-brightness-max(v-tooltip.top="'brightness-max'")
                    li.dripicons-brightness-medium(v-tooltip.top="'brightness-medium'")
                    li.dripicons-broadcast(v-tooltip.top="'broadcast'")
                    li.dripicons-browser(v-tooltip.top="'browser'")
                    li.dripicons-browser-upload(v-tooltip.top="'browser-upload'")
                    li.dripicons-brush(v-tooltip.top="'brush'")
                    li.dripicons-calendar(v-tooltip.top="'calendar'")
                    li.dripicons-camcorder(v-tooltip.top="'camcorder'")
                    li.dripicons-camera(v-tooltip.top="'camera'")
                    li.dripicons-card(v-tooltip.top="'card'")
                    li.dripicons-cart(v-tooltip.top="'cart'")
                    li.dripicons-checklist(v-tooltip.top="'checklist'")
                    li.dripicons-checkmark(v-tooltip.top="'checkmark'")
                    li.dripicons-chevron-down(v-tooltip.top="'chevron-down'")
                    li.dripicons-chevron-left(v-tooltip.top="'chevron-left'")
                    li.dripicons-chevron-right(v-tooltip.top="'chevron-right'")
                    li.dripicons-chevron-up(v-tooltip.top="'chevron-up'")
                    li.dripicons-clipboard(v-tooltip.top="'clipboard'")
                    li.dripicons-clock(v-tooltip.top="'clock'")
                    li.dripicons-clockwise(v-tooltip.top="'clockwise'")
                    li.dripicons-cloud(v-tooltip.top="'cloud'")
                    li.dripicons-cloud-download(v-tooltip.top="'cloud-download'")
                    li.dripicons-cloud-upload(v-tooltip.top="'cloud-upload'")
                    li.dripicons-code(v-tooltip.top="'code'")
                    li.dripicons-contract(v-tooltip.top="'contract'")
                    li.dripicons-contract-2(v-tooltip.top="'contract-2'")
                    li.dripicons-conversation(v-tooltip.top="'conversation'")
                    li.dripicons-copy(v-tooltip.top="'copy'")
                    li.dripicons-crop(v-tooltip.top="'crop'")
                    li.dripicons-cross(v-tooltip.top="'cross'")
                    li.dripicons-crosshair(v-tooltip.top="'crosshair'")
                    li.dripicons-cutlery(v-tooltip.top="'cutlery'")
                    li.dripicons-device-desktop(v-tooltip.top="'device-desktop'")
                    li.dripicons-device-mobile(v-tooltip.top="'device-mobile'")
                    li.dripicons-device-tablet(v-tooltip.top="'device-tablet'")
                    li.dripicons-direction(v-tooltip.top="'direction'")
                    li.dripicons-disc(v-tooltip.top="'disc'")
                    li.dripicons-document(v-tooltip.top="'document'")
                    li.dripicons-document-delete(v-tooltip.top="'document-delete'")
                    li.dripicons-document-edit(v-tooltip.top="'document-edit'")
                    li.dripicons-document-new(v-tooltip.top="'document-new'")
                    li.dripicons-document-remove(v-tooltip.top="'document-remove'")
                    li.dripicons-dot(v-tooltip.top="'dot'")
                    li.dripicons-dots-2(v-tooltip.top="'dots-2'")
                    li.dripicons-dots-3(v-tooltip.top="'dots-3'")
                    li.dripicons-download(v-tooltip.top="'download'")
                    li.dripicons-duplicate(v-tooltip.top="'duplicate'")
                    li.dripicons-enter(v-tooltip.top="'enter'")
                    li.dripicons-exit(v-tooltip.top="'exit'")
                    li.dripicons-expand(v-tooltip.top="'expand'")
                    li.dripicons-expand-2(v-tooltip.top="'expand-2'")
                    li.dripicons-experiment(v-tooltip.top="'experiment'")
                    li.dripicons-export(v-tooltip.top="'export'")
                    li.dripicons-feed(v-tooltip.top="'feed'")
                    li.dripicons-flag(v-tooltip.top="'flag'")
                    li.dripicons-flashlight(v-tooltip.top="'flashlight'")
                    li.dripicons-folder(v-tooltip.top="'folder'")
                    li.dripicons-folder-open(v-tooltip.top="'folder-open'")
                    li.dripicons-forward(v-tooltip.top="'forward'")
                    li.dripicons-gaming(v-tooltip.top="'gaming'")
                    li.dripicons-gear(v-tooltip.top="'gear'")
                    li.dripicons-graduation(v-tooltip.top="'graduation'")
                    li.dripicons-graph-bar(v-tooltip.top="'graph-bar'")
                    li.dripicons-graph-line(v-tooltip.top="'graph-line'")
                    li.dripicons-graph-pie(v-tooltip.top="'graph-pie'")
                    li.dripicons-headset(v-tooltip.top="'headset'")
                    li.dripicons-heart(v-tooltip.top="'heart'")
                    li.dripicons-help(v-tooltip.top="'help'")
                    li.dripicons-home(v-tooltip.top="'home'")
                    li.dripicons-hourglass(v-tooltip.top="'hourglass'")
                    li.dripicons-inbox(v-tooltip.top="'inbox'")
                    li.dripicons-information(v-tooltip.top="'information'")
                    li.dripicons-italic(v-tooltip.top="'italic'")
                    li.dripicons-jewel(v-tooltip.top="'jewel'")
                    li.dripicons-lifting(v-tooltip.top="'lifting'")
                    li.dripicons-lightbulb(v-tooltip.top="'lightbulb'")
                    li.dripicons-link(v-tooltip.top="'link'")
                    li.dripicons-link-broken(v-tooltip.top="'link-broken'")
                    li.dripicons-list(v-tooltip.top="'list'")
                    li.dripicons-loading(v-tooltip.top="'loading'")
                    li.dripicons-location(v-tooltip.top="'location'")
                    li.dripicons-lock(v-tooltip.top="'lock'")
                    li.dripicons-lock-open(v-tooltip.top="'lock-open'")
                    li.dripicons-mail(v-tooltip.top="'mail'")
                    li.dripicons-map(v-tooltip.top="'map'")
                    li.dripicons-media-loop(v-tooltip.top="'media-loop'")
                    li.dripicons-media-next(v-tooltip.top="'media-next'")
                    li.dripicons-media-pause(v-tooltip.top="'media-pause'")
                    li.dripicons-media-play(v-tooltip.top="'media-play'")
                    li.dripicons-media-previous(v-tooltip.top="'media-previous'")
                    li.dripicons-media-record(v-tooltip.top="'media-record'")
                    li.dripicons-media-shuffle(v-tooltip.top="'media-shuffle'")
                    li.dripicons-media-stop(v-tooltip.top="'media-stop'")
                    li.dripicons-medical(v-tooltip.top="'medical'")
                    li.dripicons-menu(v-tooltip.top="'menu'")
                    li.dripicons-message(v-tooltip.top="'message'")
                    li.dripicons-meter(v-tooltip.top="'meter'")
                    li.dripicons-microphone(v-tooltip.top="'microphone'")
                    li.dripicons-minus(v-tooltip.top="'minus'")
                    li.dripicons-monitor(v-tooltip.top="'monitor'")
                    li.dripicons-move(v-tooltip.top="'move'")
                    li.dripicons-music(v-tooltip.top="'music'")
                    li.dripicons-network-1(v-tooltip.top="'network-1'")
                    li.dripicons-network-2(v-tooltip.top="'network-2'")
                    li.dripicons-network-3(v-tooltip.top="'network-3'")
                    li.dripicons-network-4(v-tooltip.top="'network-4'")
                    li.dripicons-network-5(v-tooltip.top="'network-5'")
                    li.dripicons-pamphlet(v-tooltip.top="'pamphlet'")
                    li.dripicons-paperclip(v-tooltip.top="'paperclip'")
                    li.dripicons-pencil(v-tooltip.top="'pencil'")
                    li.dripicons-phone(v-tooltip.top="'phone'")
                    li.dripicons-photo(v-tooltip.top="'photo'")
                    li.dripicons-photo-group(v-tooltip.top="'photo-group'")
                    li.dripicons-pill(v-tooltip.top="'pill'")
                    li.dripicons-pin(v-tooltip.top="'pin'")
                    li.dripicons-plus(v-tooltip.top="'plus'")
                    li.dripicons-power(v-tooltip.top="'power'")
                    li.dripicons-preview(v-tooltip.top="'preview'")
                    li.dripicons-print(v-tooltip.top="'print'")
                    li.dripicons-pulse(v-tooltip.top="'pulse'")
                    li.dripicons-question(v-tooltip.top="'question'")
                    li.dripicons-reply(v-tooltip.top="'reply'")
                    li.dripicons-reply-all(v-tooltip.top="'reply-all'")
                    li.dripicons-return(v-tooltip.top="'return'")
                    li.dripicons-retweet(v-tooltip.top="'retweet'")
                    li.dripicons-rocket(v-tooltip.top="'rocket'")
                    li.dripicons-scale(v-tooltip.top="'scale'")
                    li.dripicons-search(v-tooltip.top="'search'")
                    li.dripicons-shopping-bag(v-tooltip.top="'shopping-bag'")
                    li.dripicons-skip(v-tooltip.top="'skip'")
                    li.dripicons-stack(v-tooltip.top="'stack'")
                    li.dripicons-star(v-tooltip.top="'star'")
                    li.dripicons-stopwatch(v-tooltip.top="'stopwatch'")
                    li.dripicons-store(v-tooltip.top="'store'")
                    li.dripicons-suitcase(v-tooltip.top="'suitcase'")
                    li.dripicons-swap(v-tooltip.top="'swap'")
                    li.dripicons-tag(v-tooltip.top="'tag'")
                    li.dripicons-tag-delete(v-tooltip.top="'tag-delete'")
                    li.dripicons-tags(v-tooltip.top="'tags'")
                    li.dripicons-thumbs-down(v-tooltip.top="'thumbs-down'")
                    li.dripicons-thumbs-up(v-tooltip.top="'thumbs-up'")
                    li.dripicons-ticket(v-tooltip.top="'ticket'")
                    li.dripicons-time-reverse(v-tooltip.top="'time-reverse'")
                    li.dripicons-to-do(v-tooltip.top="'to-do'")
                    li.dripicons-toggles(v-tooltip.top="'toggles'")
                    li.dripicons-trash(v-tooltip.top="'trash'")
                    li.dripicons-trophy(v-tooltip.top="'trophy'")
                    li.dripicons-upload(v-tooltip.top="'upload'")
                    li.dripicons-user(v-tooltip.top="'user'")
                    li.dripicons-user-group(v-tooltip.top="'user-group'")
                    li.dripicons-user-id(v-tooltip.top="'user-id'")
                    li.dripicons-vibrate(v-tooltip.top="'vibrate'")
                    li.dripicons-view-apps(v-tooltip.top="'view-apps'")
                    li.dripicons-view-list(v-tooltip.top="'view-list'")
                    li.dripicons-view-list-large(v-tooltip.top="'view-list-large'")
                    li.dripicons-view-thumb(v-tooltip.top="'view-thumb'")
                    li.dripicons-volume-full(v-tooltip.top="'volume-full'")
                    li.dripicons-volume-low(v-tooltip.top="'volume-low'")
                    li.dripicons-volume-medium(v-tooltip.top="'volume-medium'")
                    li.dripicons-volume-off(v-tooltip.top="'volume-off'")
                    li.dripicons-wallet(v-tooltip.top="'wallet'")
                    li.dripicons-warning(v-tooltip.top="'warning'")
                    li.dripicons-web(v-tooltip.top="'web'")
                    li.dripicons-weight(v-tooltip.top="'weight'")
                    li.dripicons-wifi(v-tooltip.top="'wifi'")
                    li.dripicons-wrong(v-tooltip.top="'wrong'")
                    li.dripicons-zoom-in(v-tooltip.top="'zoom-in'")
                    li.dripicons-zoom-out(v-tooltip.top="'zoom-out'")
              // <el-tab-pane label="Task" name="fourth">Task</el-tab-pane>
      // /.content
</template>
<script>
  export default {
    name: 'Icons',
    data: function () {
      return {
        activeName: 'first'
      }
    },
    methods: {
      handleClick: function (tab, event) {
        console.log(tab, event)
      }
    }
  }
</script>
<style lang="scss">
    .entypo ul,
    .entypo-tooltip ul {
        margin: 0 0 40px 0;
        padding: 0;
    }

    .entypo li,
    .entypo-tooltip li {
        display: inline-block;
        height: 50px;
        padding: 0.5em;
        position: relative;
        text-align: center;
        -webkit-transition: all 0.5s ease;
        -moz-transition: all 0.5s ease;
        -o-transition: all 0.5s ease;
        -ms-transition: all 0.5s ease;
        transition: all 0.5s ease;
        width: 50px;
        list-style: none;
        font-size: 20px;
        color: #363E49;
    }
</style>
