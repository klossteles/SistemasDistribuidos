<template lang="pug">
  .todo-list
    todo(v-on:delete-todo='deleteTodo' v-on:complete-todo='completeTodo' v-for='todo in todos' :todo.sync='todo')
</template>

<script>
import sweetalert from 'sweetalert'
import Todo from './Todo.vue'

export default {
  props: ['todos'],
  components: {
    Todo
  },
  methods: {
    deleteTodo: function (todo) {
      sweetalert({
        title: 'Are you sure?',
        text: 'This To-Do will be permanently deleted!',
        type: 'warning',
        showCancelButton: true,
        confirmButtonColor: '#DD6B55',
        confirmButtonText: 'Yes, delete it!',
        closeOnConfirm: false
      },
      () => {
        const todoIndex = this.todos.indexOf(todo)
        this.todos.splice(todoIndex, 1)
        sweetalert('Deleted!', 'Your To-Do has been deleted.', 'success')
      })
    },
    completeTodo: function (todo) {
      const todoIndex = this.todos.indexOf(todo)
      this.todos[todoIndex].done = true
      sweetalert('Success!', 'To-Do completed!', 'success')
    }
  }
}
</script>



