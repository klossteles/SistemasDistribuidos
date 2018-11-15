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
          el-form(ref='form' :model='form' label-width='120px', v-if='user === "admin"')
            el-form-item(label='Destino')
              el-input(v-model='form.destino', style='width: 45%')
            el-form-item(label='Origem')
              el-input(v-model='form.origem' style='width: 45%')
            el-form-item(label='Ida')
              el-date-picker(v-if='form.ida', type='datetime', placeholder='Selecione uma data e hora', v-model='form.dataIda', style='width: 40%; margin-left: 10px')
            el-form-item(label='Volta')
              el-switch(v-model='form.volta')
              el-date-picker(v-if='form.volta', type='datetime', placeholder='Selecione uma data e hora', v-model='form.dataVolta', style='width: 40%; margin-left: 10px')
            el-form-item(label='Num. pessoas')
              el-input(type='number', v-model='form.numPessoas', style='width: 20%;')
            el-form-item(label='Preço')
              el-input(type='number', v-model='form.preco', step='0.10', style='width: 20%;')
            div.btn-center
              button.btn.btn.btn-primary.btm-sm(@click='cadastrarPassagem') Cadastrar Passagem

        .box
          v-data-table.elevation-1(:headers='headers' :items='passagens' hide-actions='')
            template(slot='items', slot-scope='passagem')
              td {{ passagem.item.id }}
              td {{ passagem.item.DESTINO }}
              td {{ passagem.item.ORIGEM }}
              td {{ formataIdaVolta(passagem.item) }}
              td {{ formataData(passagem.item.DATA_IDA) }}
              td {{ formataData(passagem.item.DATA_VOLTA) }}
              td {{ passagem.item.NUM_PESSOAS }}
              td R$ {{ passagem.item.PRECO }}
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
        user: '',
        form: {
          destino: '',
          origem: '',
          numPessoas: '',
          ida: true,
          dataIda: '',
          horaIda: '',
          volta: false,
          dataVolta: '',
          horaVolta: '',
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
            text: 'Origem',
            align: 'center',
            sortable: true,
            value: 'ORIGEM'
          }, {
            text: 'Ida/Volta',
            align: 'center',
            sortable: true,
            value: 'IDA'
          }, {
            text: 'Data Ida',
            align: 'center',
            sortable: true,
            value: 'DATA_IDA'
          }, {
            text: 'Data Volta',
            align: 'center',
            sortable: true,
            value: 'DATA_VOLTA'
          }, {
            text: 'Num. Pessoas',
            align: 'center',
            sortable: false,
            value: 'NUM_PESSOAS'
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
        passagens: []
      }
    },
    created: function () {
      this.user = localStorage.getItem('user')
      if (this.user === undefined || this.user === '') {
        this.$router.push('/login')
      } else {
        this.consultarPassagens()
      }
    },
    methods: {
      formataData: function (data) {
        if (data === '' || data === undefined) {
          return ''
        }
        return new Date(data).toLocaleString('pt-BR', {timeZone: 'UTC'})
      },
      formataIdaVolta: function (passagem) {
        if (passagem.IDA === 1 && passagem.VOLTA === 1) {
          return 'Ida/Volta'
        } else if (passagem.IDA === 1) {
          return 'Ida'
        } else if (passagem.VOLTA === 1) {
          return 'Volta'
        } else {
          return 'Não informado'
        }
      },
      comprarPassagem: function (passagem) {
        let data = {
          'id_passagem': passagem.id
        }
        this.$http.post('comprar_passagem', data).then(response => {
          Toastr.success('Passagem comprada')
          this.consultarPassagens()
        }, error => {
          Toastr.error(error.body)
        })
      },
      consultarPassagens: function () {
        this.$http.get('consultar_passagens').then(response => {
          return response.json()
        }, error => {
          console.log(error)
        }).then(data => {
          const result = []
          for (let key in data) {
            result.push(data[key])
          }
          this.passagens = result
        })
      },
      cadastrarPassagem: function () {
        if (this.form.destino === undefined || this.form.destino === '') {
          Toastr.error('Necessário informar o destino')
          return
        }
        if (this.form.origem === undefined || this.form.origem === '') {
          Toastr.error('Necessário informar a origem')
          return
        }
        if (this.form.volta === undefined || this.form.volta === '') {
          Toastr.error('Necessário informar a data de ida')
          return
        }
        if (this.form.dataIda === undefined || this.form.dataIda === '') {
          Toastr.error('Necessário informar ')
          return
        }
        if (this.form.volta && (this.form.dataVolta === undefined || this.form.dataVolta === '')) {
          Toastr.error('Necessário informar a data de volta')
          return
        }
        if (this.form.numPessoas === undefined || this.form.numPessoas === '') {
          Toastr.error('Necessário informar o número de pessoas')
          return
        }
        if (this.form.preco === undefined || this.form.preco === '') {
          Toastr.error('Necessário informar o preço')
          return
        }
        let dataIda = new Date(this.form.dataIda)
        console.log(this.form.dataIda)
        let dataIdaFormat = dataIda.getUTCFullYear() + '-' + ('0' + dataIda.getUTCMonth()).slice(-2) + '-' + ('0' + dataIda.getUTCDate()).slice(-2) + 'T' + ('0' + dataIda.getHours()).slice(-2) + ':' + ('0' + dataIda.getMinutes()).slice(-2) + ':' + ('0' + dataIda.getSeconds()).slice(-2) + '.000Z'
        let dataVolta = new Date(this.form.dataIda)
        let dataVoltaFormat = dataVolta.getUTCFullYear() + '-' + ('0' + dataVolta.getUTCMonth()).slice(-2) + '-' + ('0' + dataVolta.getUTCDate()).slice(-2) + 'T' + ('0' + dataVolta.getHours()).slice(-2) + ':' + ('0' + dataVolta.getMinutes()).slice(-2) + ':' + ('0' + dataVolta.getSeconds()).slice(-2) + '.000Z'
        let json = {
          'destino': this.form.destino,
          'origem': this.form.origem,
          'ida': this.form.ida ? 1 : 0,
          'volta': this.form.volta ? 1 : 0,
          'data_ida': dataIdaFormat,
          'data_volta': dataVoltaFormat,
          'numero_pessoas': this.form.numPessoas,
          'preco': this.form.preco
        }
        console.log(json)
        this.$http.post('cadastrar_passagem', json).then(response => {
          Toastr.success('Passagem cadastrada')
          this.consultarPassagens()
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
