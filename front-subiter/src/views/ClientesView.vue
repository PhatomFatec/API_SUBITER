<template>
  <div class="clientes">
    <div class="sub-menu"></div>
    <FormCliente @change="load" />
    <DeleteCliente @change="load" />
    <ClientesView :clientes="clientes" />
  </div>
</template>
  
<script>
import ClientesView from "@/components/ClientesComponent.vue";
import FormCliente from "@/components/forms/FormCliente.vue";
import DeleteCliente from "@/components/forms/DeleteCliente.vue";
// import axios from "axios";

export default {
  name: "ClientesComponents",
  components: {
    ClientesView,
    FormCliente,
    DeleteCliente,
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
    deleteCliente() {
      var form = document.getElementById("delete");
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

      fetch("http://localhost:8090/users", requestOptions)
        .then((response) => response.text())
        .then((result) => {
          this.clientes = JSON.parse(result);
          console.log(typeof result);
          console.log(JSON.parse(result));
          console.log("result");
          console.log(typeof JSON.parse(result));
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
        `
        <button class='creationButton' onclick="var modal = document.getElementById('modal');modal.style.display = 'flex';modal.style.zIndex = '10';">CRIAR CLIENTE</button>
        <button class='deleteButton' style="z-index:2;background:red;" onclick="var delet = document.getElementById('delete');delet.style.display = 'flex';delet.style.zIndex = '10';">delete</button>
        `
      );
    }, 1);
  },
};
</script>
  