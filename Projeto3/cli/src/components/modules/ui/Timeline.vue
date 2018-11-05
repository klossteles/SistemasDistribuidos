<template lang="pug">
  transition(name='el-zoom-in-top')
    .content-wrapper
      // Content Header (Page header)
      section.content-header
        h1
          | Blank Page
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
          li.active Blank Page
      // Main content
      section.content
        .box
          .box-header
            h3.box-title Timeline Page
            .box-tools.pull-right
              button.btn.btn-box-tool(type='button' data-widget='collapse' data-toggle='tooltip' title='Collapse')
                i.ti-minus
              button.btn.btn-box-tool(type='button' data-widget='remove' data-toggle='tooltip' title='Remove')
                i.ti-close
          .box-body(style='min-height:400px;')
            .container-timeline
              .header-timeline
                svg(xmlns='http://www.w3.org/2000/svg' height='64' width='64')
                  defs
                    lineargradient#verlauf(x1='0%' y1='0%' x2='100%' y2='100%')
                      stop(offset='0%' stop-color='orange')
                      stop(offset='100%' stop-color='chocolate')
                  path(fill='url(#verlauf)' d='M63.04 39.74C58.764 56.885 41.4 67.318 24.256 63.043 7.12 58.768-3.313 41.404.962 24.262 5.234 7.117 22.597-3.318 39.737.957 56.88 5.23 67.313 22.597 63.04 39.74z')
                  path(fill='#FFF' d='M46.11 27.44c.636-4.257-2.606-6.546-7.04-8.073l1.44-5.768-3.512-.876-1.4 5.616c-.923-.23-1.87-.447-2.813-.662l1.41-5.653-3.51-.875-1.438 5.766c-.764-.174-1.514-.346-2.242-.527l.004-.02-4.843-1.208-.934 3.75s2.605.597 2.55.634c1.422.355 1.68 1.296 1.636 2.042l-1.64 6.57c.1.026.226.062.366.118l-.37-.092-2.297 9.205c-.175.43-.616 1.08-1.61.833.035.05-2.552-.637-2.552-.637l-1.743 4.02 4.57 1.138c.85.213 1.682.436 2.502.646l-1.453 5.834 3.507.875 1.44-5.773c.958.26 1.888.5 2.798.726l-1.434 5.745 3.51.875 1.454-5.823c5.987 1.133 10.49.676 12.384-4.74 1.527-4.36-.076-6.874-3.226-8.514 2.294-.53 4.022-2.038 4.483-5.155zm-8.023 11.25c-1.085 4.36-8.426 2.003-10.806 1.412l1.93-7.73c2.38.595 10.01 1.77 8.877 6.318zm1.086-11.312c-.99 3.966-7.1 1.95-9.082 1.457l1.75-7.01c1.98.494 8.364 1.416 7.333 5.553z')
                h1 History of bitcoin
                h2 A timeline that shows bitcoin History from the idea all the way to present day.
              .item-timeline
                #timeline
                  div
                    section.year
                      h3 2007
                      section
                        ul
                          li Satoshi Nakamoto began working on the Bitcoin concept.
                    section.year
                      h3 2008
                      section
                        h4 August
                        ul
                          li
                            | Neal Kin, Vladimir Oksman, and Charles Bry file an application for an encryption patent application.
                          li
                            | Bitcoin.org was registered at
                            a(href='https://anonymousspeech.com/') anonymousspeech.com
                            | .
                      section
                        h4 October
                        ul
                          li
                            | Nakamoto describes the Bitcoin currency and solves the problem of double spending.
                      section
                        h4 November
                        ul
                          li
                            | The Bitcoin project is registered on
                            a(href='https://sourceforge.net/') SourceForge.net
                            | .
                    section.year
                      h3 2009
                      section
                        h4 January
                        ul
                          li Block 0 is established.
                          li Version 0.1 of Bitcoin is released.
                          li The first Bitcoin transaction.
                      section
                        h4 October
                        ul
                          li An exchange rate is established.
                      section
                        h4 December
                        ul
                          li Version 0.2 is released.
                          li The difficulty increases.
                    section.year
                      h3 2010
                      section
                        h4 February
                        ul
                          li The Bitcoin Market is established as a Bitcoin currency exchange.
                          li Encryption patent is published.
                      section
                        h4 May
                        ul
                          li The first real-world transaction using 10,000 BTC spent on pizza.
                      section
                        h4 July
                        ul
                          li Version 0.3 released.
                          li
                            | In five days, the price grew 1000%, rising from
                            span.price $0.008
                            |  to
                            span.price $0.08
                            |  for 1 bitcoin.
                          li The MtGox Bitcoin currency exchange market is established.
                      section
                        h4 August
                        ul
                          li Exploit generates 184 billion Bitcoins.
                      section
                        h4 October
                        ul
                          li Financial task force issues warning.
                          li The first public version of an OpenCL miner is released.
                      section
                        h4 November
                        ul
                          li Market cap exceeds $1 million USD.
                      section
                        h4 December
                        ul
                          li Bitcoind compiled for Nokia N900.
                          li First mobile Bitcoin transaction.
                          li Difficulty increases.
                    section.year
                      h3 2011
                      section
                        h4 January
                        ul
                          li Silk Road opens for business.
                          li 25% of total Bitcoins generated.
                      section
                        h4 February
                        ul
                          li Bitcoin reaches parity with US dollar.
                          li
                            a(href='https://weusecoins.com/') WeUseCoins.com
                            |  is created.
                      section
                        h4 March
                        ul
                          li Second largest decrease in difficulty.
                          li Britcoin opens for trading.
                          li Bitcoin Brasil opens.
                      section
                        h4 April
                        ul
                          li Bitcoin passes parity with Euro.
                          li Difficulty surpasses 100,000.
                      section
                        h4 June
                        ul
                          li Bitcoin Market drops PayPal.
                          li
                            | The largest percentage price decrease to-date became known as the Great Bubble of 2011. Top of bubble at
                            span.price $31.
                          li WikiLeaks starts accepting Bitcoin.
                          li Major breach of security at MtGox.
                          li Difficulty passes 1 million.
                      section
                        h4 August
                        ul
                          li Bitcoin Conference and World Expo in New York City, NY.
                          li P2Pool mines its first block.
                          li Back-to-back drop in difficulty.
                      section
                        h4 September
                        ul
                          li Casascius coins mint physical Bitcoins.
                      section
                        h4 November
                        ul
                          li Bitcoin &amp; Future Technology European Conference in Prague, Czech Republic.
                      section
                        h4 December
                        ul
                          li
                            span.price $2
                            |  minimum price after the first price drop.
                    section.year
                      h3 2012
                      section
                        h4 September
                        ul
                          li London 2012 Bitcoin Conference.
                          li Bitcoin Foundation begins.
                      section
                        h4 December
                        ul
                          li
                            | Slowly rising for a year. Price at
                            span.price $13.
                    section.year
                      h3 2013
                      section
                        h4 February
                        ul
                          li Version 0.8 released.
                          li
                            | Bitcoin goes up to
                            span.price $30.
                      section
                        h4 March
                        ul
                          li Bitcoin spikes to $74.90.
                          li Market cap reaches $1 billion.
                      section
                        h4 April
                        ul
                          li
                            | Bitcoin surpasses
                            span.price $100.
                          li
                            | Price hits an all-time high of
                            span.price $266.
                          li Bitcoin Central is hacked.
                      section
                        h4 May
                        ul
                          li First Bitcoin ATM unveiled.
                          li Bitcoin Central gets hacked again.
                      section
                        h4 October
                        ul
                          li FBI shuts down Silk Road.
                          li
                            | Bitcoin price drops from
                            span.price $139
                            |  to
                            span.price $109.71
                            |  in less than three hours after Silk Road closure, recovers.
                      section
                        h4 November
                        ul
                          li
                            | Bitcoin price surges to a new all-time record of
                            span.price $1242.
                      section
                        h4 December
                        ul
                          li
                            | Price crashed to
                            span.price $600
                            | , rebounded to
                            span.price $1000
                            | , crashed again to the
                            span.price $500
                            |  range. Stabilized in between.
                          li China&apos;s Central Bank bans Bitcoin transactions.
                          li The network exceeded 10 petahash/sec.
                    section.year
                      h3 2014
                      section
                        h4 January
                        ul
                          li
                            | Price spiked to
                            span.price $1000
                            | , then settled in the
                            span.price $800&ndash;$900
                            | range.
                      section
                        h4 March
                        ul
                          li Version 0.9 released.
                      section
                        h4 June
                        ul
                          li The network exceeded 100 petahash/sec.
                      section
                        h4 December
                        ul
                          li Microsoft began to accept bitcoin to buy Xbox games and Windows apps.
                    section.year
                      h3 2015
                      section
                        h4 February
                        ul
                          li Version 0.10 released.
                      section
                        h4 July
                        ul
                          li Version 0.11 released.
                      section
                        h4 November
                        ul
                          li
                            | 2015 record high of
                            span.price $504.
                    section.year
                      h3 2016
                      section
                        h4 January
                        ul
                          li
                            | Price at
                            span.price $1150
                            |  per bitcoin.
                          li
                            | Price fell 30% in a week, reaching a multi-month low of
                            span.price $750.
                          li The network exceeded 1 exahash/sec.
                      section
                        h4 February
                        ul
                          li Version 0.12 released.
                      section
                        h4 April
                        ul
                          li Steam started accepting bitcoin as payment.
                      section
                        h4 August
                        ul
                          li Version 0.13 released.
                      section
                        h4 September
                        ul
                          li There are 770 bitcoin ATMs worldwide.
                    section.year
                      h3 2017
                      section
                        h4 March
                        ul
                          li Version 0.14 released.
                          li
                            | The price of 1 bitcoin surpassed the spot price of an ounce of gold for the first time.
                          li The number of GitHub projects related to bitcoin passed 10,000.
                          li
                            | Price traded above
                            span.price $1290.
                      section
                        h4 Today
                        ul
                          li
                            | At the moment, one bitcoin cost:
                            span.price
                              #btcwidget
                              | .
      // /.content

</template>

<script>
  export default {
    name: 'BlankPage'
  }
</script>
