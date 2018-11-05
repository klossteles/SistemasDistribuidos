<template lang="pug">
  .content-wrapper
    // Content Header (Page header)
    section.content-header
      h1
        | 500 Error Page
      ol.breadcrumb
        li
          a(href='#')
            i.fa.fa-dashboard
            |  Home
        li
          a(href='#') Examples
        li.active 500 error
    main.wrapper-404
      .error-404
        .error-number
          span 5
          span
            img.icon.has-animation(src='https://image.flaticon.com/icons/svg/179/179595.svg' alt='')
          span
            img.icon.has-animation(src='https://image.flaticon.com/icons/svg/179/179595.svg' alt='')
        h1
          vue-typer(:text='["Oops! Page not found","We could not find the page you were looking for", "Meanwhile", "you may return to dashboard", "or try using the search form."]' :repeat='Infinity' :shuffle='false' initial-action='typing' :pre-type-delay='70' :type-delay='70' :pre-erase-delay='2000' :erase-delay='250' erase-style='clear' :erase-on-complete='false' caret-animation='solid')
    .moon

</template>
<script>
export default {
  name: 'NotFoundSecond'
}
</script>
