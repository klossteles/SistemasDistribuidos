<template lang="pug">
  transition(name='el-zoom-in-top')
    .content-wrapper
      // Content Header (Page header)
      section.content-header
        h1
          | Invoice Page
          small
            | This enhanced for printing
            i.ti-heart
            i.ti-export
            i.ti-printer
        ol.breadcrumb
          li
            router-link(to='/')
              i.ti-home
          li
            a(href='#') Apps
          li.active Invoice
      // Main content
      section.content
        .box
          .box-body(style='min-height:400px;')
            section.content.invoice
              // title row
              .row
                .col-xs-12.col-sm-12.col-xs-12.invoice-header
                  h2.page-header
                    i.fa.fa-globe
                    |  Devin, Inc.
                    small.pull-right Date: 8/03/2017
                // /.col
              // info row
              .row.invoice-info
                .col-sm-4.col-sm-12.col-xs-12.invoice-col
                  | From
                  address
                    strong Admin, Inc.
                    br
                    | 795 Folsom Ave, Suite 600
                    br
                    | San Francisco, CA 94107
                    br
                    | Phone: (804) 123-5432
                    br
                    | Email: info@almasaeedstudio.com
                // /.col
                .col-sm-4.col-sm-12.col-xs-12.invoice-col
                  | To
                  address
                    strong John Doe
                    br
                    | 795 Folsom Ave, Suite 600
                    br
                    | San Francisco, CA 94107
                    br
                    | Phone: (555) 539-1037
                    br
                    | Email: john.doe@example.com
                // /.col
                .col-sm-4.col-sm-12.col-xs-12.invoice-col
                  b Invoice #007612
                  br
                  br
                  b Order ID:
                  |  4F3S8J
                  br
                  b Payment Due:
                  |  2/22/2017
                  br
                  b Account:
                  |  968-34567
                // /.col
              // /.row
              // Table row
              .row
                .col-xs-12.table-responsive
                  table.table.table-striped
                    thead
                      tr
                        th Qty
                        th Product
                        th Serial #
                        th Description
                        th Subtotal
                    tbody
                      tr
                        td 1
                        td Call of Duty
                        td 455-981-221
                        td El snort testosterone trophy driving gloves handsome
                        td $64.50
                      tr
                        td 1
                        td Need for Speed IV
                        td 247-925-726
                        td Wes Anderson umami biodiesel
                        td $50.00
                      tr
                        td 1
                        td Monsters DVD
                        td 735-845-642
                        td Terry Richardson helvetica tousled street art master
                        td $10.70
                      tr
                        td 1
                        td Grown Ups Blue Ray
                        td 422-568-642
                        td Tousled lomo letterpress
                        td $25.99
                // /.col
              // /.row
              .row
                // accepted payments column
                .col-md-8.col-sm-12.col-xs-12
                  p.lead Payment Methods:
                  img(src='static/img/credit/visa.png' alt='Visa')
                  img(src='static/img/credit/mastercard.png' alt='Mastercard')
                  img(src='static/img/credit/american-express.png' alt='American Express')
                  img(src='static/img/credit/paypal2.png' alt='Paypal')
                  p.text-muted.well.well-sm.no-shadow(style='margin-top: 10px;')
                    | Etsy doostang zoodles disqus groupon greplin oooj voxy zoodles, weebly ning heekya handango imeem plugg dopplr jibjab, movity jajah plickers sifteo edmodo ifttt zimbra.
                // /.col
                .col-md-4.col-sm-12.col-xs-12
                  p.lead Amount Due 2/22/2017
                  .table-responsive
                    table.table
                      tbody
                        tr
                          th(style='width:50%') Subtotal:
                          td $250.30
                        tr
                          th Tax (9.3%)
                          td $10.34
                        tr
                          th Shipping:
                          td $5.80
                        tr
                          th Total:
                          td $265.24
                // /.col
              // /.row
              // this row will not appear when printing
              .row.no-print
                .col-xs-12
                  button.btn.btn-default(onclick='window.print();')
                    i.fa.fa-print
                    |  Print
                  button.btn.btn-success.pull-right
                    i.fa.fa-credit-card
                    |  Submit Payment
                  button.btn.btn-primary.pull-right(style='margin-right: 5px;')
                    i.fa.fa-download
                    |  Generate PDF
      // /.content
</template>
<script>
  export default {
    name: 'Invoice'
  }
</script>
