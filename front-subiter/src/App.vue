<template>
  <div id="app">
    <NavbarComponent />
    <MenuComponent />
    <!-- <router-view/> -->
  </div>
</template>

<script>
import NavbarComponent from "./components/NavbarComponent.vue";
import MenuComponent from "./components/MenuComponent.vue";
export default {
  name: "App",
  components: {
    NavbarComponent,
    MenuComponent,
  },
};
</script>

<style>
@import "sass/pages/default.css";
</style>
