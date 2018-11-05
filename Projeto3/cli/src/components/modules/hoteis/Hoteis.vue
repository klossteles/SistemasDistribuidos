<template lang="pug">
  transition(name="el-zoom-in-top")
    .content-wrapper
      section.content-header
        h1 Hotéis
      ol.breadcrumb
        li
          router-link(to="/")
          i.ti-home
        li
          a(href='#') Apps
        li.active Hotéis

      section.content
        .box
          v-data-table.elevation-1(:headers='headers' :items='passagens' hide-actions='')
            template(slot='items', slot-scope='passagem')
              td {{ passagem.item.destino }}
              td {{ passagem.item.origem }}
              td {{ passagem.item.num_pessoas }}
              td R$ {{ passagem.item.preco }}
              td.justify-center.layout.px-0
                v-icon(small, @click='comprarPassagem(passagem.item)') fa-shopping-cart
            template(slot='no-data')
              v-alert(:value='true', color='error', icon='warning') Sem passgaens !

</template>

<script>
  export default {
    name: 'hoteis',
    data () {
      return {
        headers: [
          {
            text: 'Destino',
            align: 'center',
            sortable: true,
            value: 'destino'
          }, {
            text: 'Origem',
            align: 'center',
            sortable: true,
            value: 'origem'
          }, {
            text: 'Num. Pessoas',
            align: 'center',
            sortable: false,
            value: 'num_pessoas'
          }, {
            text: 'Preço',
            align: 'center',
            sortable: true,
            value: 'preco'
          }, {
            text: '',
            value: 'name',
            sortable: false
          }
        ],
        passagens: [
          {
            destino: 'São Paulo',
            origem: 'Curitiba',
            num_pessoas: 120,
            preco: 150.00
          }, {
            destino: 'Rio de Janeiro',
            origem: 'Curitiba',
            num_pessoas: 120,
            preco: 100.00
          }
        ]
      }
    }
  }
</script>

<style scoped>

</style>
