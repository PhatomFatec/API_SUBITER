<template>
  <div class="alertas">
    <div class="alert" id="alert">{{ titulo }} {{acao}}</div>
    <div class="alert erro" id="alertErro">{{ titulo }} não {{acao}}</div>
  </div>
</template>

<script>
export default {
  name: "AlertComponent",
  props: {
    titulo: String,
    acao: String
  },
  methods: {
    cadastra() {
      var alert = document.getElementById("alert");
      alert.style.top = "10px";

      setTimeout(() => {
        alert.style.top = "-100px";
      }, "3000");
    },
    naoCadastra() {
      var alert = document.getElementById("alert");
      alert.style.top = "10px";

      setTimeout(() => {
        alert.style.top = "-100px";
      }, "3000");
    },
  },
};
</script>

<style scoped>
.alert {
  width: 300px;
  height: 70px;
  background: #8fde62;
  display: flex;
  justify-content: center;
  align-items: center;
  color: #182e0b;
  font-size: 20px;
  font-weight: 600;
  border-radius: 10px;
  font-family: sans-serif;
  border: solid 2px #509627;
  position: absolute;
  top: -100px;
  transition: 0.5s;
  left: calc(50% - 150px);
}
.erro {
  background: #f05446;
  border-color: #c92010;
  color: #400500;
}
</style>