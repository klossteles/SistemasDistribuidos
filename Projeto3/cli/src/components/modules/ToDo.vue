<template lang="pug">
  transition(name='el-zoom-in-top')
    .content-wrapper
      // Content Header (Page header)
      section.content-header
        h1
          | ToDo Apps
          small
            i.ti-heart
            i.ti-export
            i.ti-printer
        ol.breadcrumb
          li
            router-link(to='/')
              i.ti-home
          li
            a(href='#') Apps
          li.active To Do
      // Main content
      section.content
        .todo-devin
          .row
            .col-md-3
              .side-todo
                ul
                  li.clearfix
                    img(src='http://api.randomuser.me/portraits/men/22.jpg' alt='avatar')
                    .about
                      .name Vincent Porter
                      .status
                        i.fa.fa-circle.online
                        |  online
                  li.completed
                    | Complete task
                    b {{todos.filter(todo =&gt; {return todo.done === true}).length}}
                  li.pending
                    | Pending task
                    b {{todos.filter(todo =&gt; {return todo.done === false}).length}}
                create-todo(v-on:create-todo='createTodo')
            .col-md-9
              todo-list(v-bind:todos='todos')
      // /.content

</template>
<script>
import sweetalert from 'sweetalert'
import TodoList from './todo/TodoList.vue'
import CreateTodo from './todo/CreateTodo.vue'
export default {
  name: 'ToDo',
  components: {
    TodoList,
    CreateTodo
  },
  data: function () {
    return {
      todos: [{
        title: 'Bug Fixed V 1.0.4',
        project: 'Are we meeting today? Project has been already finished and I have results to show you.',
        done: true
      }, {
        title: 'Udate Notification',
        project: 'Used to show feedback after an activity. The difference with Notification is that the latter is often used to show a system level passive notification',
        done: true
      }, {
        title: 'Radio Function',
        project: 'Radio should not have too many options. Otherwise, use the Select component instead',
        done: false
      }, {
        title: 'Table fix',
        project: 'Display multiple data with similar format. You can sort, filter, compare your data in a table.',
        done: false
      }]
    }
  },
  methods: {
    createTodo: function (newTodo) {
      this.todos.push(newTodo)
      sweetalert('Success!', 'To-Do created!', 'success')
    }
  }
}
</script>
