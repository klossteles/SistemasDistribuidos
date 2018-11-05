<template lang="pug">
  .todo-content
    div(v-show='!isEditing')
      h2 {{ todo.title }}
      p  {{ todo.project }}
      .task-action
        span(v-on:click='showForm')
          i.ti-pencil
        span(v-on:click='deleteTodo(todo)')
          i.ti-trash
    .content-todo-devin(v-show='isEditing')
      div
        div
          label Title
          p
            el-input(placeholder='Please input' v-model='todo.title' type='text')
        .field
          label Project
          p
            el-input(v-model='todo.project' type='textarea' :rows='4' placeholder='Please input')
        div
          el-button(v-on:click='hideForm' type='danger') Close
    .todo-completed(v-show='!isEditing &&todo.done' disabled='')  Completed
    .todo-pending(v-on:click='completeTodo(todo)' v-show='!isEditing && !todo.done')  Pending

</template>
<script>
  export default {
    props: ['todo'],
    data: function () {
      return {
        isEditing: false
      }
    },
    methods: {
      completeTodo: function (todo) {
        this.$emit('complete-todo', todo)
      },
      deleteTodo: function (todo) {
        this.$emit('delete-todo', todo)
      },
      showForm: function () {
        this.isEditing = true
      },
      hideForm: function () {
        this.isEditing = false
      }
    }
  }
</script>
