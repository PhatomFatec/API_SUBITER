<template>
  <div class="login">
    <div class="login-esquerda">
      <form action="">
        <img src="@/assets/logo_Subiter_sn.png" alt="" />
        <h1>Subiter</h1>
        <h2>Log-in</h2>
        <input type="text" placeholder="User" />
        <input type="password" placeholder="Password" />
        <button>Entrar</button>
      </form>
      <p>Alcance o invisível, Subiter</p>
    </div>
    <div class="login-direita">
      <img src="@/assets/Computer login-bro.png" alt="" />
    </div>
  </div>
</template>

<script>
export default {
  name: "LoginView",
};
</script>

<style scoped>
@import "@/sass/pages/login.css";
</style>