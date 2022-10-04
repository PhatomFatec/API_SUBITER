<template>
  <div class="home">
    <div class="sub-menu"></div>
    <FormChamado />
    <ChamadosView :chamados="chamados" />
  </div>
</template>

<script>
import ChamadosView from "@/components/ChamadosComponent.vue";
import FormChamado from "@/components/forms/FormChamado.vue";
import axios from "axios";

export default {
  name: "HomeView",
  components: {
    ChamadosView,
    FormChamado,
  },
  data() {
    return {
      chamados: [],
    };
  },
  methods: {
    formChamado() {
      //var form = document.getElementById("modal");
      //form.style.display = "flex";
      console.log("teste");
    },
    closeModal() {
      var form = document.getElementById("modal");
      form.style.display = "flex";
    },
  },
  created() {
    axios
      .get("/calleds")
      .then((res) => {
        console.log(res.data);
        this.chamados = res.data;
      })
      .catch((error) => console.log(error));
    setTimeout(function () {
      var fatherElement =
        document.getElementsByClassName("v-input__control")[0];
      var searchElement = fatherElement.children[0];
      var searchSVG =
        "<svg viewBox='0 0 24 24' width='20' height='20' stroke='currentColor' stroke-width='2' fill='none' stroke-linecap='round' stroke-linejoin='round' class='css-1hy7qas'><circle cx='11' cy='11' r='8'></circle><line x1='21' y1='21' x2='16.65' y2='16.65'></line></svg>";
      var areaSearch = document.getElementsByClassName("v-card__title")[0];
      searchElement.insertAdjacentHTML("beforebegin", searchSVG);
      areaSearch.children[0].insertAdjacentHTML(
        "beforebegin",
        `<button class='creationButton' onclick="var modal = document.getElementById('modal');modal.style.display = 'flex';modal.style.zIndex = '10';">CRIAR CHAMADO<button>`
      );
    }, 1);
  },
};
</script>

<style>
@import "../sass/components/sub-menu.css";
</style>