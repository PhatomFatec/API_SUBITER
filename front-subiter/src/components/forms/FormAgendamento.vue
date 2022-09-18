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
      <h3>Cadastro de Agendamento</h3>
      <!-- <fieldset>
        <legend>Título do Agendamento</legend>
        <input type="number" placeholder="" id="1" />
      </fieldset>
      <fieldset>
        <legend>Situação</legend>
        <input type="text" placeholder="" id="2" />
      </fieldset> -->
      <fieldset>
        <legend>Endereço</legend>
        <textarea type="text" placeholder="" id="addressSchedule" />
      </fieldset>
      <fieldset>
        <legend>Cidade</legend>
        <textarea type="text" placeholder="" id="citySchedule" />
      </fieldset>
      <fieldset>
        <legend>CEP</legend>
        <textarea type="text" placeholder="" id="cepSchedule" />
      </fieldset>
      <fieldset>
        <legend>Estado</legend>
        <textarea type="text" placeholder="" id="stateSchedule" />
      </fieldset>
      <div class="buttons">
        <button id="cancelar" v-on:click="closeModal()">Cancelar</button>
        <button id="criar" v-on:click="createSchedule()">Criar</button>
      </div>
    </div>
  </div>
</template>
  
<script>
import axios from "axios";

export default {
  name: "FormAgendamento",
  methods: {
    closeModal() {
      var modal = document.getElementById("modal");
      var inputs = modal.querySelectorAll("input, textarea");
      modal.style.display = "none";
      inputs.forEach((input) => {
        input.value = "";
      });
    },
    createSchedule() {
    //   var id = document.getElementById("1").value;
    //   var horario = document.getElementById("2").value;
      var endereco = document.getElementById("addressSchedule").value;
      var cidade = document.getElementById("citySchedule").value;
      var cep = document.getElementById("cepSchedule").value;
      var estado = document.getElementById("stateSchedule").value;

      axios
        .post("/schedule", {
        //   id: id,
        //   horario: horario,
          endereco: endereco,
          cidade: cidade,
          cep: cep,
          estado: estado
        })
        .then((res) => {
          console.log(res);
        })
        .catch((error) => console.log(error));
    },
  },
};
</script>
  