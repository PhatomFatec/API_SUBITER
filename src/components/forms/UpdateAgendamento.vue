<template>
  <div class="modal" id="update">
    <div class="box">
      <svg
        v-on:click="closeUpdate()"
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
      <h3>Atualizar Agendamento</h3>
      <fieldset>
        <legend>Cliente</legend>
        <select @change="atualiza()" id="codAgendamentoUpdate">
          <option>Selecione o Cliente</option>
          <option v-for="cli in agendamentoList" :key="cli.id">
            {{ cli.id }} - {{ cli.serviceProvided }}
          </option>
        </select>
      </fieldset>
      <fieldset>
        <input type="date" name="" id="dateUpdate" />
      </fieldset>
      <div class="buttons">
        <button id="cancelar" v-on:click="closeUpdate()">Cancelar</button>
        <button id="criar" v-on:click="UpdateCliente()">Update</button>
      </div>
    </div>
  </div>
</template>


<script>
//import axios from 'axios'
export default {
  name: "UpdateCliente",
  props: {
    clientes: Array,
  },
  methods: {
    closeUpdate() {
      var modal = document.getElementById("update");
      var inputs = modal.querySelectorAll("input, textarea");
      modal.style.display = "none";
      inputs.forEach((input) => {
        input.value = "";
      });
    },
    atualiza() {
      var codAgendamentoUpdate = document
        .getElementById("codAgendamentoUpdate")
        .value.split(" ")[0];

      var cont = 0;
      while (cont < this.agendamentoList.length) {
        if (this.agendamentoList[cont].id == codAgendamentoUpdate) {
          document.getElementById("dateUpdate").value =
            this.agendamentoList[cont].date;
        }
        if (codAgendamentoUpdate == "Selecione") {
          document.getElementById("dateUpdate").value = "";
        }
        cont++;
      }
    },
    UpdateCliente() {
      var enderecoAgend = null;
      var cidadeAgend = null;
      var serviceProvided = null;
      var estadoAgend = null;
      var cepAgend = null;
      var chamadoAgend = null;

      var myHeaders = new Headers();
      var token = localStorage.getItem("Token");
      myHeaders.append("Content-Type", "application/json");
      myHeaders.append("Authorization", `${token}`);

      var codAgendamentoUpdate = document
        .getElementById("codAgendamentoUpdate")
        .value.split(" ")[0];
      var dataAtualizada = document.getElementById("dateUpdate").value;

      var cont = 0;
      while (cont < this.agendamentoList.length) {
        if (this.agendamentoList[cont].id == codAgendamentoUpdate) {
          enderecoAgend = this.agendamentoList[cont].address;
          cidadeAgend = this.agendamentoList[cont].city;
          serviceProvided = this.agendamentoList[cont].serviceProvided;
          estadoAgend = this.agendamentoList[cont].state;
          cepAgend = this.agendamentoList[cont].zipcode;
          chamadoAgend = this.agendamentoList[cont].request.id;
        }
        cont++;
      }

      var raw = JSON.stringify({
        address: enderecoAgend,
        city: cidadeAgend,
        date: dataAtualizada,
        serviceProvided: serviceProvided,
        state: estadoAgend,
        zipcode: cepAgend,
        appointment: "string",
        request: {
          id: chamadoAgend,
        },
      });

      var requestOptions = {
        method: "PUT",
        headers: myHeaders,
        body: raw,
        redirect: "follow",
      };

      fetch(
        `https://subiter.herokuapp.com/schedule/${codAgendamentoUpdate}`,
        requestOptions
      )
        .then((response) => response.text())
        .then((result) => console.log(result))
        .catch((error) => console.log("error", error));
    },
  },
  data() {
    return {
      agendamentoList: [],
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

    fetch("https://subiter.herokuapp.com/schedule", requestOptions)
      .then((response) => response.text())
      .then((result) => {
        // console.log(result);
        this.agendamentoList = JSON.parse(result);
      });
  },
};
</script>
