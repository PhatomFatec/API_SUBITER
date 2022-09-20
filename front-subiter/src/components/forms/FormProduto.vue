<template>
  <div class="modal" id="modal">
    <div class="box">
      <svg
        v-on:click="closeModal()"
        viewBox="0 0 24 24"
        width="24"
        height="24"
        stroke="currentColor"
        stroke-width="2"
        fill="none"
        stroke-linecap="round"
        stroke-linejoin="round"
        class="css-i6dzq1"
      >
        <line x1="18" y1="6" x2="6" y2="18"></line>
        <line x1="6" y1="6" x2="18" y2="18"></line>
      </svg>
      <h3>Cadastro de Produtos</h3>
      <fieldset>
        <legend>Modelo do produto</legend>
        <input
          type="text"
          placeholder="Exemplo: Embarcação"
          id="modelProduct"
        />
      </fieldset>
      <fieldset>
        <legend>Número de série</legend>
        <input
          type="text"
          placeholder="Exemplo: 11, 12, 13"
          id="serialnumberProduct"
        />
      </fieldset>
      <fieldset>
        <legend>Descrição</legend>
        <textarea type="text" id="descriptionProduct" />
      </fieldset>
      <hr />
      <fieldset>
        <legend>Data de fabricação</legend>
        <input type="date" id="fabdateProduct" />
      </fieldset>
      <div class="buttons">
        <button id="cancelar" v-on:click="closeModal()">Cancelar</button>
        <button id="criar" v-on:click="createProduct()">Criar</button>
      </div>
    </div>
  </div>
</template>

<script>
import axios from "axios";

export default {
  name: "FormProduto",
  methods: {
    closeModal() {
      var modal = document.getElementById("modal");
      var inputs = modal.querySelectorAll("input, textarea");
      modal.style.display = "none";
      inputs.forEach((input) => {
        input.value = "";
      });
    },
    createProduct() {
      var modelo = document.getElementById("modelProduct").value;
      var numeroDeSerie = document.getElementById("serialnumberProduct").value;
      var descricao = document.getElementById("descriptionProduct").value;
      var dataFabricacao = document.getElementById("fabdateProduct").value;

      axios
        .post("/products", {
          modelo: modelo,
          numeroDeSerie: numeroDeSerie,
          dataFabricacao: dataFabricacao,
          descricao: descricao,
        })
        .then((res) => {
          console.log(res);
        })
        .catch((error) => console.log(error));
    },
  },
};
</script>
