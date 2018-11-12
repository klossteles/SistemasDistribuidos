<template lang="pug">
  transition(name="el-zoom-in-top")
    .content-wrapper
      section.content-header
        h1 Pacotes
      ol.breadcrumb
        li
          router-link(to="/")
          i.ti-home
        li
          a(href='#') Apps
        li.active Pacotes

      section.content
        .box
          el-form(ref='form' :model='form' label-width='120px', v-if='user === "admin"')
            el-form-item(label='Hospedagens')
              el-select(v-model='form.idHospedagem' clearable, placeholder='Hospedagens')
                el-option(v-for='item in form.hospedagens', :key='item.idHospedagem', :label='item.destino', :value='item.idHospedagem')
            el-form-item(label='Passagens')
              el-select(v-model='form.idPassagem', clearable, placeholder='Passagens')
                el-option(v-for='item in form.passagens', :key='item.idPassagem', :label='item.destino', :value='item.idPassagem')
            el-button(type='primary', size='small', @click='cadastrarPacote') Cadastrar Pacote

        .box
          v-data-table.elevation-1(:headers='headers' :items='pacotes' hide-actions='')
            template(slot='items', slot-scope='pacote')
              td {{ pacote.item.id_passagem }}
              td {{ pacote.item.id_hospedagem }}
              td.justify-center.layout.px-0
                v-icon(small, @click='comprarPacote(pacote.item)') fa-shopping-cart
            template(slot='no-data')
              v-alert(:value='true', color='error', icon='warning') Sem pacotes !

</template>

<script>
  import Toastr from 'toastr'
  export default {
    name: 'pacotes',
    data () {
      return {
        user: '',
        form: {
          idPassagem: '',
          idHospedagem: '',
          pacotes: [],
          passagens: [
            {
              idPassagem: '1542062754',
              destino: 'São Paulo',
              origem: 'Curitiba',
              ida: 1,
              volta: 1,
              data_ida: '11/03/2018 14:15:16',
              data_volta: '11/04/2018',
              num_pessoas: 120,
              preco: 150.00
            }, {
              idPassagem: '1542062779',
              destino: 'Rio de Janeiro',
              origem: 'Curitiba',
              ida: 1,
              volta: 0,
              data_ida: '03/11/2018',
              data_volta: '',
              num_pessoas: 120,
              preco: 100.00
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
        },
        headers: [
          {
            text: 'Id. passagem',
            align: 'center',
            sortable: true,
            value: 'id_passagem'
          }, {
            text: 'Id. hospedagem',
            align: 'center',
            sortable: true,
            value: 'id_hospedagem'
          }, {
            text: '',
            value: 'name',
            sortable: false
          }
        ]
      }
    },
    created: function () {
      this.user = localStorage.getItem('user')
      // this.consultarHospedagens()
      // this.consultarPassagens()
      // this.consultarPacotes()
    },
    methods: {
      comprarPacote: function (pacote) {
        const data = new window.FormData()
        data.append('id', pacote.id)
        this.$http.post('http://sd1projeto3-myurb.a3c1.starter-us-west-1.openshiftapps.com/projeto3/agencia', data).then(function (response) {
          if (response.data.error !== 'error') {
            Toastr.success('Pacote comprado')
          } else {
            Toastr.success(response.data.error)
          }
        })
      },
      consultarPacotes: function () {
        this.$http.get('http://sd1projeto3-myurb.a3c1.starter-us-west-1.openshiftapps.com/projeto3/agencia/consultar_pacotes').then(function (response) {
          if (response.ok) {
            this.pacotes = response.body
          }
        })
      },
      consultarHospedagens: function () {
        this.$http.get('http://sd1projeto3-myurb.a3c1.starter-us-west-1.openshiftapps.com/projeto3/agencia/consultar_hospedagens').then(function (response) {
          if (response.ok) {
            this.form.hospedagens = response.body
          }
        })
      },
      consultarPassagens: function () {
        this.$http.get('http://sd1projeto3-myurb.a3c1.starter-us-west-1.openshiftapps.com/projeto3/agencia/consultar_passagens').then(function (response) {
          if (response.ok) {
            this.form.passagens = response.body
          }
        })
      },
      cadastrarPacote: function () {
        if (this.form.idHospedagem === '' || this.form.idHospedagem === undefined) {
          Toastr.error('Necessário informar o identificador da hospedagem.')
          return
        }
        if (this.form.idPassagem === '' || this.form.idPassagem === undefined) {
          Toastr.error('Necessário informar o identificador da passagem.')
          return
        }
        var json = JSON.stringify({id_hospedagem: this.form.idHospedagem, id_passagem: this.form.idPassagem})
        // http://jsonplaceholder.typicode.com/posts
        this.$http.post('http://sd1projeto3-myurb.a3c1.starter-us-west-1.openshiftapps.com/projeto3/agencia/cadastrar_pacote', json, {
          'Content-Type': 'application/json'
        }).then(function (response) {
          if (response.data.error !== 'error') {
            Toastr.success('Pacote cadastrado')
            this.consultarPacotes()
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
