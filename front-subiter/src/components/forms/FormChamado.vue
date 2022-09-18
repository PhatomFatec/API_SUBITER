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
        <legend>Situação</legend>
        <input type="text" placeholder="" id="statusCall" />
      </fieldset>
      <fieldset>
        <legend>Comentários</legend>
        <textarea type="text" id="descriptionCall" />
      </fieldset>
      <div class="buttons">
        <button id="cancelar" v-on:click="closeModal()">Cancelar</button>
        <button id="criar">Criar</button>
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
      var title = document.getElementById("titleCall").value;
      var status = document.getElementById("statusCall").value;
      var description = document.getElementById("descriptionCall").value;

      axios
        .post("/calleds", {
          title: title,
          status: status,
          description: description,
        })
        .then((res) => {
          console.log(res);
        })
        .catch((error) => console.log(error));
    },
  },
};
</script>
  