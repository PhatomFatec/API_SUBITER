<template>
  <div class="home">
    <div class="sub-menu"></div>
    <FormChamado @change="load" />
    <ChamadosView :chamados="chamados" />
  </div>
</template>

<script>
import ChamadosView from "@/components/ChamadosComponent.vue";
import FormChamado from "@/components/forms/FormChamado.vue";
// import axios from "axios";

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
    load() {
      var myHeaders = new Headers();
      var token = localStorage.getItem("SavedToken");
      myHeaders.append("Content-Type", "application/json");
      myHeaders.append("Authorization", `${token}`);

      var requestOptions = {
        method: "GET",
        headers: myHeaders,
        redirect: "follow",
      };

      fetch("https://subiter.azurewebsites.net/calleds", requestOptions)
        .then((response) => response.text())
        .then((result) => console.log(result))
        .catch((error) => console.log("error", error));
    },
  },
  created() {
    this.load();
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
        `
        <button class='subMenuButton creationButton' onclick="var modal = document.getElementById('modal');modal.style.display = 'flex';modal.style.zIndex = '10';"><svg viewBox="0 0 24 24" width="24" height="24" stroke="currentColor" stroke-width="2" fill="none" stroke-linecap="round" stroke-linejoin="round" class="css-i6dzq1"><line x1="12" y1="5" x2="12" y2="19"></line><line x1="5" y1="12" x2="19" y2="12"></line></svg></button>
        <button class='subMenuButton deleteButton' onclick="var delet = document.getElementById('delete');delet.style.display = 'flex';delet.style.zIndex = '10';"><svg viewBox="0 0 24 24" width="24" height="24" stroke="currentColor" stroke-width="2" fill="none" stroke-linecap="round" stroke-linejoin="round" class="css-i6dzq1"><polyline points="3 6 5 6 21 6"></polyline><path d="M19 6v14a2 2 0 0 1-2 2H7a2 2 0 0 1-2-2V6m3 0V4a2 2 0 0 1 2-2h4a2 2 0 0 1 2 2v2"></path></svg></button>
        <button class='subMenuButton editButton' onclick=""><svg viewBox="0 0 24 24" width="24" height="24" stroke="currentColor" stroke-width="2" fill="none" stroke-linecap="round" stroke-linejoin="round" class="css-i6dzq1"><path d="M17 3a2.828 2.828 0 1 1 4 4L7.5 20.5 2 22l1.5-5.5L17 3z"></path></svg></button
        `
      );
    }, 1);
  },
};
</script>

<style>
@import "../sass/components/sub-menu.css";
</style>