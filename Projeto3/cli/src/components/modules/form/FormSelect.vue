<template lang="pug">
  transition(name='el-zoom-in-center')
    .content-wrapper
      // Content Header (Page header)
      section.content-header
        h1
          | Forms Select
          small
            i.ti-heart
            i.ti-export
            i.ti-printer
        ol.breadcrumb
          li
            router-link(to='/')
              i.ti-home
          li
            a(href='#') Forms
          li.active Select
      // Main content
      section.content
        // Default box
        .box
          .box-header
            .box-tools.pull-right
              button.btn.btn-box-tool(type='button' data-widget='collapse' data-toggle='tooltip' title='Collapse')
                i.ti-minus
              button.btn.btn-box-tool(type='button' data-widget='remove' data-toggle='tooltip' title='Remove')
                i.ti-close
          .box-body
            h4 Basic Usage
            p
              code v-model
              |  is the value of
              code el-option
              |  that is currently selected.
            el-select(v-model='value' placeholder='Select')
              el-option(v-for='item in options' :key='item.value' :label='item.label' :value='item.value')
            hr
            h4 Disable Options
            p
              | Set the value of
              code disabled
              |  in
              code el-option
              |  to
              code true
              |  to disable this option.
            el-select(v-model='value2' placeholder='Select Disable Option')
              el-option(v-for='item in options2' :key='item.value' :label='item.label' :value='item.value' :disabled='item.disabled')
            hr
            h4 Grouping
            p
              | Use
              code el-option-group
              |  to group the options, and its
              code label
              |  attribute stands for the name of the group.
            el-select(v-model='value7' placeholder='Select')
              el-option-group(v-for='group in options3' :key='group.label' :label='group.label')
                el-option(v-for='item in group.options' :key='item.value' :label='item.label' :value='item.value')
            hr
            h4 Remote Search
            p Enter keywords and search data from server.
            p
              | Set the value of
              code filterable
              |  and
              code remote
              |  with
              code true
              |  to enable remote search, and you should pass the
              code remote-method
              | .
              code remote-method
              |  is a
              code Function
              |  that gets called when the input value changes, and its parameter is the current input value. Note that if
              code el-option
              |  is rendered with the
              code v-for
              |  directive, you should add the
              code key
              |  attribute for
              code el-option
              | . Its value needs to be unique, such as
              code item.value
              |  in the following example.
            el-select(v-model='value9' multiple='' filterable='' remote='' placeholder='Please enter a keyword' :remote-method='remoteMethod' :loading='loading')
              el-option(v-for='item in options4' :key='item.value' :label='item.label' :value='item.value')
          // /.box-body
        // /.box
      // /.content

</template>

<script>
  export default {
    name: 'FormSelect',
    data () {
      return {
        options: [{
          value: 'Option1',
          label: 'Option1'
        }, {
          value: 'Option2',
          label: 'Option2'
        }, {
          value: 'Option3',
          label: 'Option3'
        }, {
          value: 'Option4',
          label: 'Option4'
        }, {
          value: 'Option5',
          label: 'Option5'
        }],
        options2: [{
          value: 'Enable',
          label: 'Enable'
        }, {
          value: 'Disable',
          label: 'Disable',
          disabled: true
        }, {
          value: 'Enable',
          label: 'Enable'
        }, {
          value: 'Enable',
          label: 'Enable'
        }, {
          value: 'Enable',
          label: 'Enable'
        }],
        options3: [{
          label: 'Popular cities',
          options: [{
            value: 'Yogyakarta',
            label: 'Yogyakarta'
          }, {
            value: 'Depok',
            label: 'Depok'
          }]
        }, {
          label: 'City name',
          options: [{
            value: 'Sleman',
            label: 'Sleman'
          }, {
            value: 'Bantul',
            label: 'Bantul'
          }, {
            value: 'Gunung Kidul',
            label: 'Gunung Kidul'
          }, {
            value: 'Jogja',
            label: 'Jogja'
          }]
        }],
        value2: '',
        value: '',
        value7: '',
        options4: [],
        value9: [],
        list: [],
        loading: false,
        states: ['Alabama', 'Alaska', 'Arizona',
          'Arkansas', 'California', 'Colorado',
          'Connecticut', 'Delaware', 'Florida',
          'Georgia', 'Hawaii', 'Idaho', 'Illinois',
          'Indiana', 'Iowa', 'Kansas', 'Kentucky',
          'Louisiana', 'Maine', 'Maryland',
          'Massachusetts', 'Michigan', 'Minnesota',
          'Mississippi', 'Missouri', 'Montana',
          'Nebraska', 'Nevada', 'New Hampshire',
          'New Jersey', 'New Mexico', 'New York',
          'North Carolina', 'North Dakota', 'Ohio',
          'Oklahoma', 'Oregon', 'Pennsylvania',
          'Rhode Island', 'South Carolina',
          'South Dakota', 'Tennessee', 'Texas',
          'Utah', 'Vermont', 'Virginia',
          'Washington', 'West Virginia', 'Wisconsin',
          'Wyoming']
      }
    },
    mounted () {
      this.list = this.states.map(item => {
        return { value: item, label: item }
      })
    },
    methods: {
      remoteMethod (query) {
        if (query !== '') {
          this.loading = true
          setTimeout(() => {
            this.loading = false
            this.options4 = this.list.filter(item => {
              return item.label.toLowerCase()
                .indexOf(query.toLowerCase()) > -1
            })
          }, 200)
        } else {
          this.options4 = []
        }
      }
    }
  }

</script>
