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
      <h3>Cadastro de Chamado</h3>
      <fieldset>
        <legend>Título do Chamado</legend>
        <input type="text" placeholder="" id="titleCall" />
      </fieldset>
      <fieldset>
        <legend>Produto</legend>
        <input type="text" placeholder="" id="productCall" />
      </fieldset>
      <fieldset>
        <legend>Descrição</legend>
        <textarea type="text" id="descriptionCall" />
      </fieldset>
      <!-- <fieldset>
        <legend>Faça o upload de um arquivo:</legend>
        <input type="file" placeholder="" id="arquivoCall" />
      </fieldset> -->
      <div class="buttons">
        <button id="cancelar" v-on:click="closeModal()">Cancelar</button>
        <button id="criar" v-on:click="createCall()">Criar</button>
      </div>
    </div>
  </div>
</template>
  
<script>
import axios from "axios";

export default {
  name: "FormChamado",
  methods: {
    closeModal() {
      var modal = document.getElementById("modal");
      var inputs = modal.querySelectorAll("input, textarea");
      modal.style.display = "none";
      inputs.forEach((input) => {
        input.value = "";
      });
    },
    createCall() {
      var titulo = document.getElementById("titleCall").value;
      var descricao = document.getElementById("descriptionCall").value;
      // var product = document.getElementById("productCall").value;
      var imgUrl = document.getElementById("arquivoCall").value;
      //var user = document.getElementById("userCall").value;

      // var user = document.getElementById("userCall").value;

      axios
        .post("/calleds", {
          titulo: titulo,
          descricao: descricao,
          imgUrl: imgUrl,
          // user: user,
          product: {
            id: 1,
            modelo: "teste",
            numeroDeSerie: "nums",
            descricao: "mais um tetse",
          },
          user: {
            id: 1,
            email: "bob@gmail.com",
            password: "fff",
            acessType: "ADMIN",
            cpf: "23232323",
            telefone: "97979797",
            nome: "Bob",
          },
        })
        .then((res) => {
          console.log(res);
          this.$emit("change");
        })
        .catch((error) => console.log(error));
    },
  },
};
</script>
  