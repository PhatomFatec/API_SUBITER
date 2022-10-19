<template>
  <div class="login">
    <div class="login-esquerda">
      <div class="form">
        <input type="email" name="" id="user" placeholder="username"/>
        <input type="password" name="" id="password" placeholder="password"/>
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
          console.log("res")
          console.log(res)
          let token = res.data.token;
          console.log(res.data)
          localStorage.setItem("SavedToken","Bearer "+token);
          localStorage.setItem("User", res.data.nome)
          localStorage.setItem("Role", res.data.autorizacao)
          axios.defaults.headers.common["Authorization"] = `Bearer ${token}`;
          setTimeout(function () {location.replace("/")}, 1000);
          //this.$router.push({ name: "home" });
          // console.log(res.data);
          // localStorage.setItem('token', res.data.token);
        })
        .catch((error) => {console.log(error); document.getElementById("warning").style.display = "block"});
        
        
        // setTimeout(function () {location.replace("/")}, 1000);
    },
  },
};
</script>

<style scoped>
@import "@/sass/pages/login.css";
button#login-btn{
  background: #2196f3;
  color: #fff;
  font-weight: 700;
  width:100px;
  height: 30px;
  border-radius: 10px;
}
</style>