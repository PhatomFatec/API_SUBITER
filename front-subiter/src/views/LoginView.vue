<template>
  <div class="login">
    <div class="login-esquerda">
      <div class="form">
        <input type="email" name="" id="user" placeholder="username"/>
        <input type="password" name="" id="password" placeholder="password"/>
        <button v-on:click="login()">entra</button>
      </div>

      <p>Alcance o invisível, Subiter</p>
    </div>
    <div class="login-direita">
      <img src="@/assets/Computer login-bro.png" alt="" />
    </div>
  </div>
</template>

<script>
import axios from "axios";

export default {
  name: "LoginView",
  methods: {
    login() {
      var user = document.getElementById("user").value;
      var password = document.getElementById("password").value;
      // console.log("user: "+user)
      // console.log("password: "+password)

      axios
        .post("/login", {
          nome: user,
          senha: password,
        })
        .then((res) => {
          let token = res.data.token;
          localStorage.setItem("SavedToken","Bearer "+token);
          axios.defaults.headers.common["Authorization"] = `Bearer ${token}`;
          this.$router.push({ name: "home" });
          // console.log(res.data);
          // localStorage.setItem('token', res.data.token);
        })
        .catch((error) => console.log(error));
    },
  },
};
</script>

<style scoped>
@import "@/sass/pages/login.css";
</style>