<template>
  <div class="clientes">
    <div class="sub-menu"></div>
    <FormCliente />
    <ClientesView :clientes="clientes" />
  </div>
</template>
  
<script>
import ClientesView from "@/components/ClientesComponent.vue";
import FormCliente from "@/components/forms/FormCliente.vue";
import axios from "axios";

export default {
  name: "ClientesComponents",
  components: {
    ClientesView,
    FormCliente,
  },
  data() {
    return {
      clientes: [],
    };
  },
  methods: {
    formCliente() {
      var form = document.getElementById("modal");
      form.style.display = "flex";
    },
    closeModal() {
      var form = document.getElementById("modal");
      form.style.display = "flex";
    },
  },
  created() {
    axios
      .get("/users")
      .then((res) => {
        console.log(res.data);
        this.clientes = res.data;
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
        `<button class='creationButton' onclick="var modal = document.getElementById('modal');modal.style.display = 'flex';modal.style.zIndex = '10';">CRIAR CLIENTE<button>`
      );
    }, 1);
  },
};
</script>
  