<template lang="pug">
  .create-todo
    el-button(type='info' v-on:click='openForm' v-show='!isCreating')
      i.ti-pencil-alt
      | &nbsp;&nbsp;Add New Task
    div(v-show='isCreating')
      .content-todo-devin
        div
          label Title
          p
            el-input(placeholder='Please input' v-model='titleText' type='text')
        div
          label Project
          p
            el-input(v-model='projectText' type='textarea' :rows='4' placeholder='Please input')
        div
          el-button(v-on:click='sendForm()' type='info') Create
          el-button(v-on:click='closeForm' type='info') Cancel

</template>
<script>
export default {
  data: function () {
    return {
      titleText: '',
      projectText: '',
      isCreating: false
    }
  },
  methods: {
    openForm: function () {
      this.isCreating = true
    },
    closeForm: function () {
      this.isCreating = false
    },
    sendForm: function () {
      if (this.titleText.length > 0 && this.projectText.length > 0) {
        const title = this.titleText
        const project = this.projectText
        this.$emit('create-todo', {
          title,
          project,
          done: false
        })
        this.titleText = ''
        this.projectText = ''
        this.isCreating = false
      }
    }
  }
}
</script>
