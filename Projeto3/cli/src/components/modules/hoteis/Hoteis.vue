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
          el-form(ref='form' :model='form' label-width='120px', v-if='user === "admin"')
            el-form-item(label='Destino')
              el-input(v-model='form.destino')
            el-form-item(label='Data Entrada/Saída')
              el-date-picker(type='date', placeholder='Selecione uma data', v-model='form.dataEntrada' style='width: 100%;')
              | -
              el-date-picker(type='date' placeholder='Selecione uma data' v-model='form.dataSaida' style='width: 100%;')
            el-form-item(label='Num. pessoas')
              el-input(type='number', v-model='form.numPessoas')
            el-form-item(label='Num. Quartos')
              el-input(type='number', v-model='form.numQuartos')
            el-form-item(label='Preço')
              el-input(type='number', v-model='form.preco', step='0.10')
            el-button(type='primary', size='small', @click='cadastrarHotel') Cadastrar Hotel
        .box
          v-data-table.elevation-1(:headers='headers' :items='hospedagens' hide-actions='')
            template(slot='items', slot-scope='hotel')
              td {{ hotel.item.destino }}
              td {{ hotel.item.dataEntrada }}
              td {{ hotel.item.dataSaida }}
              td {{ hotel.item.num_pessoas }}
              td {{ hotel.item.num_quartos }}
              td R$ {{ hotel.item.preco }}
              td.justify-center.layout.px-0
                v-icon(small, @click='comprarHospedagem(hotel.item)') fa-shopping-cart
            template(slot='no-data')
              v-alert(:value='true', color='error', icon='warning') Sem hospedagens !

</template>

<script>
  import Toastr from 'toastr'
  export default {
    name: 'hoteis',
    data () {
      return {user: '',
        form: {
          destino: 'Rio de Janeiro',
          dataEntrada: '12/11/2018',
          dataSaida: '13/11/2018',
          numPessoas: '3',
          numQuartos: '2',
          preco: '150'
        },
        headers: [
          {
            text: 'Destino',
            align: 'center',
            sortable: true,
            value: 'destino'
          }, {
            text: 'Data Entrada',
            align: 'center',
            sortable: true,
            value: 'dataEntrada'
          }, {
            text: 'Data Saída',
            align: 'center',
            sortable: true,
            value: 'dataSaida'
          }, {
            text: 'Num. Pessoas',
            align: 'center',
            sortable: false,
            value: 'num_pessoas'
          }, {
            text: 'Num. Quartos',
            align: 'center',
            sortable: true,
            value: 'num_quartos'
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
        hospedagens: [
          {
            idHospedagem: '1542062779',
            destino: 'São Paulo',
            origem: 'Curitiba',
            num_pessoas: 120,
            preco: 150.00
          }, {
            idHospedagem: '1542062779',
            destino: 'Rio de Janeiro',
            origem: 'Curitiba',
            num_pessoas: 120,
            preco: 100.00
          }
        ]
      }
    },
    created: function () {
      this.user = localStorage.getItem('user')
      this.consultarHoteis()
    },
    methods: {
      comprarHospedagem: function (hotel) {
        const data = new window.FormData()
        data.append('id', hotel.id)
        this.$http.post('http://sd1projeto3-myurb.a3c1.starter-us-west-1.openshiftapps.com/projeto3/agencia', data).then(function (response) {
          if (response.data.error !== 'error') {
            Toastr.success('Hotel comprada')
          } else {
            Toastr.success(response.data.error)
          }
        })
      },
      consultarHoteis: function () {
        Toastr.info('Realizando consulta')
        this.$http.get('http://sd1projeto3-myurb.a3c1.starter-us-west-1.openshiftapps.com/projeto3/agencia/consultar_hospedagens').then(function (response) {
          if (response.ok) {
            Toastr.success('Consulta realizada')
            this.hospedagens = response.body
          }
        })
      },
      cadastrarHotel: function () {
        let dataEntrada = new Date(this.form.dataEntrada)
        let dataSaida = new Date(this.form.dataSaida)
        var json = JSON.stringify({destino: this.form.destino, num_quartos: this.form.numQuartos, num_pessoas: this.form.numPessoas, data_entrada: dataEntrada, data_saida: dataSaida, preco: this.preco})
        console.log(json)
        // http://jsonplaceholder.typicode.com/posts
        this.$http.post('http://sd1projeto3-myurb.a3c1.starter-us-west-1.openshiftapps.com/projeto3/agencia/cadastrar_hospedagem', json, {
          'Content-Type': 'application/json'
        }).then(function (response) {
          if (response.data.error !== 'error') {
            Toastr.success('Hotel cadastrado')
            this.consultarHoteis()
          } else {
            Toastr.success(response.data.error)
          }
        })
      }
    }
  }
</script>

<style scoped>

</style>
