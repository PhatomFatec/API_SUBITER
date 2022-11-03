<template>
  <div id="app">
    <NavbarComponent />
    <MenuComponent />
    <router-view />
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
  methods: {
    closeModal() {
      var modal = document.getElementById("modal");
      var inputs = modal.querySelectorAll("input, textarea");
      modal.style.display = "none";
      inputs.forEach((input) => {
        input.value = "";
      });
    },
  }
};
</script>

<style>
@import "sass/pages/default.css";
@import "sass/components/modal.css";
@import "sass/components/table.css";
@import "sass/components/sub-menu.css";
@import "sass/components/navbar.css";
@import "sass/components/menu.css";
</style>
