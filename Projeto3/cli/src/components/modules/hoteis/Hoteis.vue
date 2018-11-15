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
            el-form-item(label='Data')
              el-date-picker(type='daterange', placeholder='Selecione uma data', range-separator="até", start-placeholder='Data inicial',
                end-placeholder='Data final', v-model='form.dataRange', style='width: 100%;', format='dd/MM/yyyy')
            el-form-item(label='Num. pessoas')
              el-input(type='number', v-model='form.numPessoas')
            el-form-item(label='Num. Quartos')
              el-input(type='number', v-model='form.numQuartos')
            el-form-item(label='Preço')
              el-input(type='number', v-model='form.preco', step='0.10')
            div.btn-center
              button.btn.btn.btn-primary.btm-sm(@click='cadastrarHospedagem') Cadastrar Hospedagem
        .box
          v-data-table.elevation-1(:headers='headers' :items='hospedagens' hide-actions='')
            template(slot='items', slot-scope='hotel')
              td {{ hotel.item.id }}
              td {{ hotel.item.DESTINO }}
              td {{ hotel.item.DATA_ENTRADA }}
              td {{ hotel.item.DATA_SAIDA }}
              td {{ hotel.item.NUM_PESSOAS }}
              td {{ hotel.item.NUM_QUARTOS }}
              td R$ {{ hotel.item.PRECO }}
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
      return {
        user: '',
        form: {
          destino: '',
          dataRange: '',
          numPessoas: '',
          numQuartos: '',
          preco: ''
        },
        headers: [
          {
            text: 'Id.',
            align: 'center',
            sortable: true,
            value: 'id'
          }, {
            text: 'Destino',
            align: 'center',
            sortable: true,
            value: 'DESTINO'
          }, {
            text: 'Data Entrada',
            align: 'center',
            sortable: true,
            value: 'DATA_ENTRADA'
          }, {
            text: 'Data Saída',
            align: 'center',
            sortable: true,
            value: 'DATA_SAIDA'
          }, {
            text: 'Num. Pessoas',
            align: 'center',
            sortable: false,
            value: 'NUM_PESSOAS'
          }, {
            text: 'Num. Quartos',
            align: 'center',
            sortable: true,
            value: 'NUM_QUARTOS'
          }, {
            text: 'Preço',
            align: 'center',
            sortable: true,
            value: 'PRECO'
          }, {
            text: '',
            value: 'name',
            sortable: false
          }
        ],
        hospedagens: []
      }
    },
    created: function () {
      this.user = localStorage.getItem('user')
      if (this.user === undefined || this.user === '') {
        this.$router.push('/login')
      } else {
        this.consultarHospedagens()
      }
    },
    methods: {
      comprarHospedagem: function (hotel) {
        let data = {
          'id_hospedagem': hotel.id
        }
        this.$http.post('comprar_hospedagem', data).then(response => {
          Toastr.success('Hotel comprada')
          this.consultarHospedagens()
        }, error => {
          console.log(error)
        })
      },
      consultarHospedagens: function () {
        this.$http.get('consultar_hospedagens').then(response => {
          return response.json()
        }, error => {
          console.log(error)
        }).then(data => {
          const result = []
          for (let key in data) {
            result.push(data[key])
          }
          this.hospedagens = result
        })
      },
      cadastrarHospedagem: function () {
        let rangeArr = JSON.stringify(this.form.dataRange).split(',')
        let dataEntrada = rangeArr[0].slice(2, rangeArr[0].length - 1)
        let dataSaida = rangeArr[1].slice(1, rangeArr[1].length - 2)
        var json = {
          'destino': this.form.destino,
          'numero_quartos': this.form.numQuartos,
          'numero_pessoas': this.form.numPessoas,
          'data_entrada': dataEntrada,
          'data_saida': dataSaida,
          'preco': this.form.preco
        }
        this.$http.post('cadastrar_hospedagem', json).then(response => {
          Toastr.success('Hospedagem cadastrada')
          this.consultarHospedagens()
        }, error => {
          Toastr.error(error.body)
        })
      }
    }
  }
</script>

<style scoped>
  .btn-center {
    text-align: center;
  }
</style>
