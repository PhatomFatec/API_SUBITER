<template>
  <div class="login">
    <div class="login-esquerda">
      <div class="form">
        <input type="email" name="" id="user" placeholder="username" />
        <input type="password" name="" id="password" placeholder="password" />
        <p id="warning">Usuário e/ou senha inválidos</p>
        <button v-on:click="login()" id="login-btn">Login</button>
      </div>
      <p id="text">Alcance o invisível, Subiter</p>
    </div>
    <div class="login-direita">
      <img src="@/assets/Computer login-bro.png" alt="" />
    </div>
  </div>
</template>

<script>
// import axios from "axios";

export default {
  name: "LoginView",
  methods: {
    login() {
      var user = document.getElementById("user").value;
      var password = document.getElementById("password").value;

      var myHeaders = new Headers();
      myHeaders.append("Content-Type", "application/json");

      var raw = JSON.stringify({
        name: user,
        senha: password,
      });

      var requestOptions = {
        method: "POST",
        headers: myHeaders,
        body: raw,
        redirect: "follow",
      };

      fetch("https://subiter.herokuapp.com/login", requestOptions)
        .then((response) => response.text())
        .then((result) => {
          var res = JSON.parse(result);
          
          console.log(typeof res);

          localStorage.setItem("User", res.name);
          localStorage.setItem("Role", res.autorizacao);
          localStorage.setItem("Token", "Bearer " + res.token);

          if (res.status == null) {
            window.location.replace("/");
          }
          else{
            document.getElementById("warning").style.display = "block"
          }
        })
        .catch((error) => console.log("error", error));
    },
  },
};
</script>

<style scoped>
@import "@/sass/pages/login.css";

button#login-btn {
  background: #2196f3;
  color: #fff;
  font-weight: 700;
  width: 100px;
  height: 30px;
  border-radius: 10px;
}
</style>
<style>
.iconChat {
  display: none !important;
}
</style>