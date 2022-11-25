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
      <h3>Deletar Equipamento</h3>
      <fieldset>
        <legend>Equipamento</legend>
        <select id="codEquipamento">
          <option>Selecione o Equipamento</option>
          <option v-for="equi in equipamentosList" :key="equi.id">
            {{ equi.id }} - {{ equi.name }}
          </option>
        </select>
      </fieldset>
      <div class="buttons">
        <button id="cancelar" v-on:click="closeDelete()">Cancelar</button>
        <button id="criar" v-on:click="deleteEquipamento()">Delete</button>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  name: "DeleteEquipamento", //
  methods: {
    cadastra() {
      var alert = document.getElementById("alert");
      alert.style.top = "10px";

      setTimeout(() => {
        alert.style.top = "-100px";
      }, "3000");
    },
    naoCadastra() {
      var alert = document.getElementById("alert");
      alert.style.top = "10px";

      setTimeout(() => {
        alert.style.top = "-100px";
      }, "3000");
    },
    closeDelete() {
      var delet = document.getElementById("delete");
      var inputs = delet.querySelectorAll("input, textarea");
      delet.style.display = "none";
      inputs.forEach((input) => {
        input.value = "";
      });
    },
    deleteEquipamento() {
      //
      var myHeaders = new Headers();
      var codEquipamento = document
        .getElementById("codEquipamento")
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
        `https://subiter.herokuapp.com/equipments/${codEquipamento}`,
        requestOptions
      )
        .then((response) => {
          response.text();
          this.closeDelete();
          this.$emit("change");
          this.cadastra();
        })
        .catch((error) => {
          console.log("error", error)
          this.naoCadastra();
          });
    },
  },
  data() {
    return {
      equipamentosList: [],
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

    fetch("https://subiter.herokuapp.com/equipments", requestOptions)
      .then((response) => response.text())
      .then((result) => {
        // console.log(result);
        this.equipamentosList = JSON.parse(result);
      });
  },
};
</script>