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
      <fieldset id="fieldChamado">
        <legend id="legendChamado">Chamado</legend>
        <select name="" id="chamadoAgend">
          <option>---</option>
          <option v-for="cham in chamadosList" :key="cham.id">
            {{ cham.id }} - {{ cham.title }}
          </option>
        </select>
      </fieldset>
      <fieldset id="fieldCep">
        <legend id="legendCep">CEP</legend>
        <input type="number" name="" id="cepAgend" />
      </fieldset>
      <fieldset id="fieldData">
        <legend id="legendData">Data</legend>
        <input type="date" id="dataAgend" name="meeting-time" />
      </fieldset>
      <fieldset id="fieldEstado">
        <legend id="legendEstado">Estado</legend>
        <select id="estadoAgend">
          <option>AC</option>
          <option>AL</option>
          <option>AP</option>
          <option>AM</option>
          <option>BA</option>
          <option>CE</option>
          <option>DF</option>
          <option>ES</option>
          <option>GO</option>
          <option>MT</option>
          <option>MS</option>
          <option>MG</option>
          <option>PA</option>
          <option>PB</option>
          <option>PR</option>
          <option>PE</option>
          <option>PE</option>
          <option>PI</option>
          <option>RJ</option>
          <option>RN</option>
          <option>RS</option>
          <option>RO</option>
          <option>RR</option>
          <option>SC</option>
          <option>SP</option>
          <option>SE</option>
          <option>TO</option>
        </select>
      </fieldset>
      <fieldset id="fieldCidade">
        <legend id="legendCidade">Cidade</legend>
        <input type="text" name="" id="cidadeAgend" />
      </fieldset>
      <fieldset id="fieldEndereco">
        <legend id="legendEndereco">Endereço</legend>
        <input type="text" name="" id="enderecoAgend" />
      </fieldset>
      <div class="buttons">
        <button id="cancelar" v-on:click="closeModal()">Cancelar</button>
        <button id="criar" v-on:click="createSchedule()">Criar</button>
      </div>
    </div>
  </div>
</template>
  
<script>
// import axios from "axios";

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
      var token = localStorage.getItem("Token");
      var enderecoAgend = document.getElementById("enderecoAgend").value;
      var cidadeAgend = document.getElementById("cidadeAgend").value;
      var dataAgend = document.getElementById("dataAgend").value;
      var estadoAgend = document.getElementById("estadoAgend").value;
      var cepAgend = document.getElementById("cepAgend").value;
      var chamadoAgend = document.getElementById("chamadoAgend").value.split(" ")[0];

      function turnFieldRed(x) {
        document.getElementById(x).style.borderColor = "red";
        document.getElementById(x).style.background = "#ff00000f";
      }
      function turnLegendRed(x) {
        document.getElementById(x).style.color = "red";
      }
      function turnRed(f, l) {
        turnFieldRed(f);
        turnLegendRed(l);
      }

      if (chamadoAgend == "---") {
        turnRed("fieldChamado", "legendChamado", "chamadoAgend");
      }
      
      if (cepAgend.trim() == "") {
        turnRed("fieldCep", "legendCep", "cepAgend");
      }
      
      if (dataAgend.trim() == "") {
        turnRed("fieldData", "legendData", "dataAgend");
      }
      
      if (estadoAgend.trim() == "") {
        turnRed("fieldEstado", "legendEstado", "estadoAgend");
      }

      if (cidadeAgend.trim() == "") {
        turnRed("fieldCidade", "legendCidade", "cidadeAgend");
      }

      if (enderecoAgend.trim() == "") {
        turnRed("fieldEndereco", "legendEndereco", "enderecoAgend");
      }

      if (
        //verificações antes do post
        chamadoAgend.trim() != "" &&
        cepAgend.trim() != "" &&
        dataAgend.trim() != "" &&
        estadoAgend.trim() != "" && 
        cidadeAgend.trim() != "" && 
        enderecoAgend.trim() != ""  
      ) {

      var myHeaders = new Headers();
      myHeaders.append("Content-Type", "application/json");
      myHeaders.append("Authorization", `${token}`);

      var raw = JSON.stringify({
        address: enderecoAgend,
        appointment: "string",
        city: cidadeAgend,
        date: dataAgend,
        id: 0,
        serviceProvided: "string",
        state: estadoAgend,
        zipcode: cepAgend,
        request:{
          id: chamadoAgend
        }
      });

      var requestOptions = {
        method: "POST",
        headers: myHeaders,
        body: raw,
        redirect: "follow",
      };

      fetch("https://subiter.herokuapp.com/schedule", requestOptions)
        .then((response) => {
          response.text()
          this.closeModal()
          this.$emit("change");
          })
        .catch((error) => console.log("error", error));
    }
    },
  },
  data() {
    return {
      chamadosList: [],
    };
  },
  created() {
    var myHeaders = new Headers();
    var token = localStorage.getItem("Token");
    // console.log(token)
    myHeaders.append("Content-Type", "application/json");
    myHeaders.append("Authorization", `${token}`);

    var requestOptions = {
      method: "GET",
      headers: myHeaders,
      redirect: "follow",
    };

    fetch("https://subiter.herokuapp.com/requests", requestOptions)
      .then((response) => response.text())
      .then((result) => {
        // console.log(result);
        this.chamadosList = JSON.parse(result);
      });
  },
};
</script>
  