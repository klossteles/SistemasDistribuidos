<template lang="pug">
  transition(name='el-zoom-in-top')
    .content-wrapper
      // Content Header (Page header)
      section.content-header
        h1
          | Tinymce Editor
          small
            i.ti-heart
            i.ti-export
            i.ti-printer
        ol.breadcrumb
          li
            router-link(to='/')
              i.ti-home
          li
            a(href='#') UI Element
          li.active Tinymce Editor
      // Main content
      section.content
        .box
          .box-header
            .box-tools.pull-right
              button.btn.btn-box-tool(type='button' data-widget='collapse' data-toggle='tooltip' title='Collapse')
                i.ti-minus
              button.btn.btn-box-tool(type='button' data-widget='remove' data-toggle='tooltip' title='Remove')
                i.ti-close
          .box-body
            h5 Click to upload files
            hr
            el-upload.upload-demo(action='https://jsonplaceholder.typicode.com/posts/' :on-preview='handlePreview' :on-remove='handleRemove' :file-list='fileList')
              el-button(size='small' type='primary') Click to upload
              .el-upload__tip(slot='tip') jpg/png files with a size less than 500kb
            br
            br
            h5 FileList with thumbnail
            hr
            el-upload.upload-demo(action='https://jsonplaceholder.typicode.com/posts/' :on-preview='handlePreview' :on-remove='handleRemove' :file-list='fileList2' list-type='picture')
              el-button(size='small' type='primary') Click to upload
              .el-upload__tip(slot='tip') jpg/png files with a size less than 500kb
            br
            br
            h5 FileList with thumbnail
            hr
            el-upload(action='https://jsonplaceholder.typicode.com/posts/' list-type='picture-card' :on-preview='handlePictureCardPreview' :on-remove='handleRemove')
              i.el-icon-plus
            el-dialog(v-model='dialogVisible' size='tiny')
              img(width='100%' :src='dialogImageUrl' alt='')
      // /.content

</template>
<script>
  export default {
    data: function () {
      return {
        fileList: [{name: 'food.jpeg', url: 'https://fuss10.elemecdn.com/3/63/4e7f3a15429bfda99bce42a18cdd1jpeg.jpeg?imageMogr2/thumbnail/360x360/format/webp/quality/100'}, {name: 'food2.jpeg', url: 'https://fuss10.elemecdn.com/3/63/4e7f3a15429bfda99bce42a18cdd1jpeg.jpeg?imageMogr2/thumbnail/360x360/format/webp/quality/100'}], fileList2: [{name: 'food.jpeg', url: 'https://fuss10.elemecdn.com/3/63/4e7f3a15429bfda99bce42a18cdd1jpeg.jpeg?imageMogr2/thumbnail/360x360/format/webp/quality/100'}, {name: 'food2.jpeg', url: 'https://fuss10.elemecdn.com/3/63/4e7f3a15429bfda99bce42a18cdd1jpeg.jpeg?imageMogr2/thumbnail/360x360/format/webp/quality/100'}]
      }
    },
    methods: {
      handleRemove: function (file, fileList) {
        console.log(file, fileList)
      },
      handlePreview: function (file) {
        console.log(file)
      }
    }
  }
</script>
<style lang="scss">
    .el-upload__input{
        display: none!important;
    }
</style>
