<template lang="pug">
  transition(name='el-zoom-in-top')
    .content-wrapper
      section.content-header
        h1
          | Blank Page
        ol.breadcrumb
          li
            router-link(to='/')
              i.ti-home
          li
            a(href='#') Common Page
          li.active Login Page
      // Main content
      section.content
        el-dialog(v-if='!newUser', title='Login', :visible.sync='dialogVisible', size='tiny', visible='visible', :before-close='handleClose')
          .account-box
            form(role='form')
              .form-group
                label(for='inputUsernameEmail') Username or email
                input#inputUsernameEmail.form-control(type='text', v-model='user')
              .form-group
                label(for='inputPassword') Password
                input#inputPassword.form-control(type='password')
              .checkbox.pull-left
                label
                  input(type='checkbox')
                  | Remember me
              .row
                button.btn.btn.btn-primary.pull-right(type='submit', style='width:100%', @click='performLogin') Log In
                  <!--router-link(style='color:#fff' to='/passagens') Log In-->
              <!--hr-->
              <!--.row-->
                <!--button.btn.btn.btn-primary.pull-right(type='submit', style='width:100%', @click='newUser = true') Create new account-->

        <!--el-dialog(v-if='newUser', title='Novo Usuário', :visible.sync='dialogVisible', size='tiny', visible='visible', :before-close='handleClose')-->
          <!--.account-box-->
            <!--form(role='form')-->
              <!--.form-group-->
                <!--label Usuário-->
                <!--input.form-control(type='text', name='user', v-model='user', v-validate='required', placeholder='Usuário')-->
                <!--span(style='color: red') {{errors.first('user')}}-->
              <!--.form-group-->
                <!--label Email-->
                <!--input.form-control(type='email', name='email', v-model='email', v-validate='required', placeholder='Email')-->
                <!--span(style='color: red') {{ errors.first('email') }}-->
              <!--.form-group-->
                <!--label Senha-->
                <!--input.form-control(type='password', name='password', v-model='password', v-validate='required', ref='password', placeholder='Senha')-->
                <!--input.form-control(type='password', name='confirmed', v-validate='"required|confirmed:password"', placeholder='Confirme a senha')-->
                <!--span(style='color: red') {{ errors.first('password') }}-->
                <!--span(style='color: red') {{ errors.first('confirmed') }}-->
              <!--.row-block-->
                <!--.row-->
                  <!--button.btn.btn.btn-primary.pull-right(type='submit', style='width:100%', @click='registerUser()') Register-->

</template>
<script>
  import Toastr from 'toastr'

  export default {
    data: function () {
      return {
        dialogVisible: false,
        newUser: false,
        visible: false,
        user: ''
      }
    },
    methods: {
      handleClose: function (done) {
        this.$confirm('This will permanently delete the file. Continue?', 'Warning', {
          confirmButtonText: 'OK',
          cancelButtonText: 'Cancel',
          type: 'warning'
        })
      },
      registerUser: function () {
        Toastr.success('Usuário registrado')
        this.newUser = false
      },
      performLogin: function () {
        localStorage.setItem('user', this.user)
        this.$router.push('/passagens')
      }
    }
  }
</script>
