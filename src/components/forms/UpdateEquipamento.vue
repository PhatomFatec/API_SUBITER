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
      <h3>Atualizar Equipamento</h3>
      <fieldset>
        <legend>Equipamentos</legend>
        <select @change="atualiza()" id="codequiUpdate">
          <option>Selecione o Equipamento</option>
          <option v-for="equi in equipamentList" :key="equi.id">
            {{ equi.id }} - {{ equi.name }}
          </option>
        </select>
      </fieldset>
      <fieldset>
        <legend>Nome do Equipamento</legend>
        <input type="text" id="equiNomeUpdate" />
      </fieldset>
      <fieldset>
        <legend>Descrição</legend>
        <textarea
          name="equiDesc"
          id="descricaoUpdate"
          cols="10"
          rows="5"
        ></textarea>
      </fieldset>
      <fieldset>
        <legend>Número de Série</legend>
        <input type="text" id="ndsUpdate" />
      </fieldset>
      <fieldset>
        <legend>Data de Fabricação</legend>
        <input type="text" id="fabdateUpdate" />
      </fieldset>
      <div class="buttons">
        <button id="cancelar" v-on:click="closeUpdate()">Cancelar</button>
        <button id="criar" v-on:click="updateEquipamento()">Update</button>
      </div>
    </div>
  </div>
</template>


<script>
//import axios from 'axios'
export default {
  name: "updateEquipamento",
  props: {
    equipamento: Array,
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
      var codequiUpdate = document
        .getElementById("codequiUpdate")
        .value.split(" ")[0];

      var cont = 0;
      while (cont < this.equipamentList.length) {
        if (this.equipamentList[cont].id == codequiUpdate) {
          document.getElementById("equiNomeUpdate").value =
            this.equipamentList[cont].name;
          document.getElementById("descricaoUpdate").value =
            this.equipamentList[cont].description;
          document.getElementById("ndsUpdate").value =
            this.equipamentList[cont].serialNumber;
          document.getElementById("fabdateUpdate").value =
            this.equipamentList[cont].date;
        }
        if (codequiUpdate == "Selecione") {
          document.getElementById("equiNomeUpdate").value = "";
          document.getElementById("descricaoUpdate").value = "";
          document.getElementById("ndsUpdate").value = "";
          document.getElementById("fabdateUpdate").value = "";
        }
        cont++;
      }
    },
    updateEquipamento() {
      var myHeaders = new Headers();
      var token = localStorage.getItem("Token");
      myHeaders.append("Content-Type", "application/json");
      myHeaders.append("Authorization", `${token}`);

      var codequiUpdate = document
        .getElementById("codequiUpdate")
        .value.split(" ")[0];
      var equiNomeUpdate = document.getElementById("equiNomeUpdate").value;
      var descricaoUpdate = document.getElementById("descricaoUpdate").value;
      var ndsUpdate = document.getElementById("ndsUpdate").value;
      var fabdateUpdate = document.getElementById("fabdateUpdate").value;

      var raw = JSON.stringify({
        name: equiNomeUpdate,
        description: descricaoUpdate,
        serialNumber: ndsUpdate,
        date: fabdateUpdate,
        availability: true,
      });

      var requestOptions = {
        method: "PUT",
        headers: myHeaders,
        body: raw,
        redirect: "follow",
      };

      fetch(
        `https://subiter.herokuapp.com/equipments/${codequiUpdate}`,
        requestOptions
      )
        .then((response) => {
          response.text()
          this.closeUpdate()
          this.$emit("change");
          })
        .catch((error) => console.log("error", error));
    },
  },
  data() {
    return {
      equipamentList: [],
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
        this.equipamentList = JSON.parse(result);
      });
  },
};
</script>
