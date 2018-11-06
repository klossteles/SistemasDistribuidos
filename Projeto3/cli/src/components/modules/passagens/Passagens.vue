<template lang="pug">
  transition(name="el-zoom-in-top")
    .content-wrapper
      section.content-header
        h1 Passagens
      ol.breadcrumb
        li
          router-link(to="/")
          i.ti-home
        li
          a(href='#') Apps
        li.active Passagens

      section.content
        .box
          v-data-table.elevation-1(:headers='headers' :items='passagens' hide-actions='')
            template(slot='items', slot-scope='passagem')
              td {{ passagem.item.destino }}
              td {{ passagem.item.origem }}
              td {{ formataIdaVolta(passagem.item) }}
              td {{ formataData(passagem.item.data_ida) }}
              td {{ formataData(passagem.item.data_volta) }}
              td {{ passagem.item.num_pessoas }}
              td R$ {{ passagem.item.preco }}
              td.justify-center.layout.px-0
                v-icon(small, @click='comprarPassagem(passagem.item)') fa-shopping-cart
            template(slot='no-data')
              v-alert(:value='true', color='error', icon='warning') Sem passgaens !

</template>

<script>
  import Toastr from 'toastr'
  export default {
    name: 'passagens',
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
            text: 'Ida/Volta',
            align: 'center',
            sortable: true,
            value: 'ida'
          }, {
            text: 'Data Ida',
            align: 'center',
            sortable: true,
            value: 'data_ida'
          }, {
            text: 'Data Volta',
            align: 'center',
            sortable: true,
            value: 'data_volta'
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
            ida: 1,
            volta: 1,
            data_ida: '11/03/2018 14:15:16',
            data_volta: '11/04/2018',
            num_pessoas: 120,
            preco: 150.00
          }, {
            destino: 'Rio de Janeiro',
            origem: 'Curitiba',
            ida: 1,
            volta: 0,
            data_ida: '03/11/2018',
            data_volta: '',
            num_pessoas: 120,
            preco: 100.00
          }
        ]
      }
    },
    methods: {
      formataData: function (data) {
        if (data === '') {
          return ''
        }
        return new Date(data).toLocaleString('pt-BR', {timeZone: 'UTC'})
      },
      formataIdaVolta: function (passagem) {
        if (passagem.ida === 1 && passagem.volta === 1) {
          return 'Ida/Volta'
        } else if (passagem.ida === 1) {
          return 'Ida'
        } else if (passagem.volta === 1) {
          return 'Volta'
        } else {
          return 'Não informado'
        }
      },
      comprarPassagem: function (passagem) {
        this.passagens.push(passagem)
        Toastr.success('Passagem comprada')
      }
    }
  }
</script>

<style scoped>

</style>
