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
      <h3>Cadastro de Equipamentos</h3>
      <fieldset>
        <legend>Nome do equipamento</legend>
        <input type="text" id="modelo" />
      </fieldset>
      <fieldset>
        <legend>Número de série</legend>
        <input
          type="text"
          id="serialnumberEquipamento"
        />
      </fieldset>
      <fieldset>
        <legend>Descrição</legend>
        <textarea type="text" id="descricao" />
      </fieldset>
      <fieldset>
        <legend>Data de fabricação</legend>
        <input type="date" id="dataFabricacao" />
      </fieldset>
      <div class="buttons">
        <button id="cancelar" v-on:click="closeModal()">Cancelar</button>
        <button id="criar" v-on:click="createEquipamento()">Criar</button>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  name: "FormEquipamento",
  methods: {
    closeModal() {
      var modal = document.getElementById("modal");
      var inputs = modal.querySelectorAll("input, textarea");
      modal.style.display = "none";
      inputs.forEach((input) => {
        input.value = "";
      });
    },
    createEquipamento() {
      var modelo = document.getElementById("modelo").value;
      var numeroDeSerie = document.getElementById("serialnumberEquipamento").value;
      var descricao = document.getElementById("descricao").value;
      var dataFabricacao = document.getElementById("dataFabricacao").value;
      var token = localStorage.getItem("Token");

      var myHeaders = new Headers();
      myHeaders.append("Content-Type", "application/json");
      myHeaders.append("Authorization", `${token}`);

      var raw = JSON.stringify({
        availability: true,
        name: modelo,
        serialNumber: numeroDeSerie,
        description: descricao,
        date: dataFabricacao,
      });

      var requestOptions = {
        method: "POST",
        headers: myHeaders,
        body: raw,
        redirect: "follow",
      };

      fetch("https://subiter.herokuapp.com/equipments", requestOptions)
        .then((response) => response.text())
        .then((result) => {console.log(result)})
        .catch((error) => {console.log(error)});

      var modal = document.getElementById("modal");
      var inputs = modal.querySelectorAll("input, textarea");
      modal.style.display = "none";
      inputs.forEach((input) => {
        input.value = "";
      });
    },
  },
};
</script>
