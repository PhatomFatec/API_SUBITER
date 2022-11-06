<template>
  <div id="app">
    <NavbarComponent />
    <MenuComponent />
    <ChatComponent />
    <router-view />
  </div>
</template>

<script>
import NavbarComponent from "./components/NavbarComponent.vue";
import MenuComponent from "./components/MenuComponent.vue";
import ChatComponent from "./components/chat/ChatComponent.vue"
export default {
  name: "App",
  components: {
    NavbarComponent,
    MenuComponent,
    ChatComponent,
  },
  created() {
    setTimeout(function () {
      if (localStorage.getItem("Role") != "ROLE_ADMIN") {
        document.getElementById("menu2").style.display = "none";
        document.getElementById("menu3").style.display = "none";
        document.getElementById("menu4").style.display = "none";
        document.getElementById("menu5").style.display = "none";
      }
    }, 1);
  },
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
