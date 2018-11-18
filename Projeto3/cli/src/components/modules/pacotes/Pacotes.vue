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
                el-option(v-for='item in form.hospedagens', :key='item.id', :label='item.DESTINO', :value='item.id')
            el-form-item(label='Passagens')
              el-select(v-model='form.idPassagem', clearable, placeholder='Passagens')
                el-option(v-for='item in form.passagens', :key='item.id', :label='item.DESTINO', :value='item.id')
            div.btn-center
              button.btn.btn.btn-primary.btm-sm(@click='cadastrarPacote') Cadastrar Pacote

        .box
          v-data-table.elevation-1(:headers='headers' :items='pacotes' hide-actions='')
            template(slot='items', slot-scope='pacote')
              td {{ pacote.item.id}}
              td {{ pacote.item.ID_PASSAGEM }}
              td {{ pacote.item.ID_HOSPEDAGEM }}
              td {{ pacote.item.DESTINO }}
              td R$ {{ pacote.item.PRECO.toFixed(2) }}
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
        pacotes: [],
        form: {
          idPassagem: '',
          idHospedagem: '',
          passagens: [],
          hospedagens: []
        },
        headers: [
          {
            text: 'Id. pacote',
            align: 'center',
            sortable: true,
            value: 'id'
          }, {
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
            text: 'Destino',
            align: 'center',
            sortable: true,
            value: 'DESTINO'
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
        ]
      }
    },
    created: function () {
      this.user = localStorage.getItem('user')
      if (this.user === undefined || this.user === '') {
        this.$router.push('/login')
      } else {
        this.reloadFields()
      }
    },
    methods: {
      reloadFields: function () {
        this.consultarPassagens()
        this.consultarHospedagens()
        this.consultarPacotes()
      },
      comprarPacote: function (pacote) {
        let data = {
          'id_pacote': pacote.id
        }
        this.$http.post('comprar_pacote', data).then(response => {
          Toastr.success('Pacote comprado')
        }, error => {
          Toastr.error(error.statusText)
        })
      },
      consultarPacotes: function () {
        this.$http.get('consultar_pacotes').then(response => {
          return response.json()
        }, error => {
          console.log(error)
        }).then(data => {
          const result = []
          for (let key in data) {
            result.push(data[key])
          }
          this.pacotes = result
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
          this.form.hospedagens = result
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
          this.form.passagens = result
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
        var json = {
          'id_hospedagem': this.form.idHospedagem,
          'id_passagem': this.form.idPassagem
        }
        this.$http.post('cadastrar_pacote', json).then(response => {
          Toastr.success('Pacote cadastrado')
          this.reloadFields()
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
