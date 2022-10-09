<template>
  <div class="agendamentos">
    <div class="sub-menu"></div>
    <FormAgendamento @change="load" />
    <AgendamentosView :agendamentos="agendamentos" />
  </div>
</template>
  
<script>
import AgendamentosView from "@/components/AgendamentosComponent.vue";
// import axios from "axios";
import FormAgendamento from "@/components/forms/FormAgendamento.vue";

export default {
  name: "AgendamentosComponents",
  components: {
    AgendamentosView,
    FormAgendamento,
  },
  data() {
    return {
      agendamentos: [],
    };
  },
  methods: {
    formAgendamento() {
      var form = document.getElementById("modal");
      form.style.display = "flex";
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

      fetch("http://localhost:8090/schedule", requestOptions)
        .then((response) => response.text())
        .then((result) => {
          this.agendamentos = JSON.parse(result);
          console.log(typeof result);
          console.log(JSON.parse(result))
          console.log("result")
        })
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
        `<button class='creationButton' onclick="var modal = document.getElementById('modal');modal.style.display = 'flex';modal.style.zIndex = '10';">CRIAR AGENDAMENTO<button>`
      );
    }, 1);
  },
};
</script>
  