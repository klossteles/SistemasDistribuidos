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
              el-input(v-model='form.destino')
            el-form-item(label='Origem')
              el-input(v-model='form.origem')
            el-form-item(label='Ida')
              el-switch(v-model='form.ida')
            el-form-item(label='Data Ida', v-if='form.ida')
              el-col(:span='11')
                el-date-picker(type='date', placeholder='Selecione uma data', v-model='form.dataIda' style='width: 100%;')
                | -
                el-time-picker(type='fixed-time', v-model='form.horaIda', placeholder='Hora de ida', style='width: 100%;')
            el-form-item(label='Volta')
              el-switch(v-model='form.volta')

            el-form-item(label='Data Volta', v-if='form.volta')
              el-col(:span='11')
                el-date-picker(type='date' placeholder='Selecione uma data' v-model='form.dataVolta' style='width: 100%;')
                | -
                el-time-picker(type='fixed-time', v-model='form.horaVolta', placeholder='Hora de volta', style='width: 100%;')
            el-form-item(label='Preço')
              el-input(type='number', v-model='form.preco', step='0.10')
            el-button(type='primary', size='small', @click='cadastrarPassagem') Cadastrar Passagem

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
        user: '',
        form: {
          destino: 'Rio de Janeiro',
          origem: 'Curitiba',
          numPessoas: '15',
          ida: true,
          dataIda: '12/11/2018',
          horaIda: '18:30:00',
          volta: false,
          dataVolta: '',
          horaVolta: '',
          preco: '150'
        },
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
    created: function () {
      this.user = localStorage.getItem('user')
      this.consultarPassagens()
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
        const data = new window.FormData()
        data.append('id', passagem.id)
        this.$http.post('http://sd1projeto3-myurb.a3c1.starter-us-west-1.openshiftapps.com/projeto3/agencia', data).then(function (response) {
          if (response.data.error !== 'error') {
            Toastr.success('Passagem comprada')
          } else {
            Toastr.success(response.data.error)
          }
        })
      },
      consultarPassagens: function () {
        Toastr.info('Realizando consulta')
        this.$http.get('http://sd1projeto3-myurb.a3c1.starter-us-west-1.openshiftapps.com/projeto3/agencia/consultar_passagens').then(function (response) {
          if (response.ok) {
            Toastr.success('Consulta realizada')
            this.passagens = response.body
          }
        })
      },
      cadastrarPassagem: function () {
        let dataIda = new Date(this.form.dataIda)
        let dataVolta = new Date(this.form.dataVolta)
        // const data = new window.FormData()
        // data.append('destino', this.form.destino)
        // data.append('origem', this.form.origem)
        // data.append('ida', this.form.ida ? 1 : 0)
        // data.append('volta', this.form.volta ? 1 : 0)
        // data.append('data_ida', dataIda)
        // data.append('data_volta', dataVolta)
        // data.append('numero_pessoas', this.form.numPessoas)
        // data.append('preco', this.form.preco)
        var json = JSON.stringify({destino: this.form.destino, origem: this.form.origem, ida: this.form.ida ? 1 : 0, volta: this.form.volta, data_ida: dataIda, data_volta: dataVolta, numero_pessoas: this.form.numPessoas, preco: this.preco})
        console.log(json)
        // http://jsonplaceholder.typicode.com/posts
        this.$http.post('http://sd1projeto3-myurb.a3c1.starter-us-west-1.openshiftapps.com/projeto3/agencia/cadastrar_passagem', json, {
          'Content-Type': 'application/json'
        }).then(function (response) {
          if (response.data.error !== 'error') {
            Toastr.success('Passagem cadastrada')
            this.consultarPassagens()
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
