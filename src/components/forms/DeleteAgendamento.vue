<template>
  <div class="modal" id="delete">
    <div class="box">
      <svg
        v-on:click="closeDelete()"
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
      <h3>Deletar Agendamentoo</h3>
      <fieldset>
        <legend>Agendamento</legend>
        <select id="codAgendamento">
          <option>Selecione o Agendamento</option>
          <option v-for="ag in agendamentosList" :key="ag.id">
            {{ ag.id }} - {{ ag.serviceProvided }}
          </option>
        </select>
      </fieldset>
      <div class="buttons">
        <button id="cancelar" v-on:click="closeDelete()">Cancelar</button>
        <button id="criar" v-on:click="deleteAgendamento()">Delete</button>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  name: "deleteAgendamento", //
  methods: {
    closeDelete() {
      var delet = document.getElementById("delete");
      var inputs = delet.querySelectorAll("input, textarea");
      delet.style.display = "none";
      inputs.forEach((input) => {
        input.value = "";
      });
    },
    deleteAgendamento() {
      //
      var myHeaders = new Headers();
      var codAgendamento = document
        .getElementById("codAgendamento")
        .value.split(" ")[0];
      var token = localStorage.getItem("Token");
      myHeaders.append("Authorization", `${token}`);

      var raw = "";

      var requestOptions = {
        method: "DELETE",
        headers: myHeaders,
        body: raw,
        redirect: "follow",
      };

      fetch(
        `https://subiter.herokuapp.com/schedule/${codAgendamento}`,
        requestOptions
      )
        .then((response) => {
          response.text()
          this.closeDelete()
          this.$emit("change");
          })
        .catch((error) => console.log("error", error));
    },
  },
  data() {
    return {
      agendamentosList: [],
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
        this.agendamentosList = JSON.parse(result);
      });
  },
};
</script>