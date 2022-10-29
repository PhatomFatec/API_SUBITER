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
        <legend>Nome do produto</legend>
        <input type="text" placeholder="Exemplo: Embarcação" id="modelo" />
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
        <textarea type="text" id="descricao" />
      </fieldset>
      <hr />
      <fieldset>
        <legend>Data de fabricação</legend>
        <input type="date" id="dataFabricacao" />
      </fieldset>
      <div class="buttons">
        <button id="cancelar" v-on:click="closeModal()">Cancelar</button>
        <button id="criar" v-on:click="createProduct()">Criar</button>
      </div>
    </div>
  </div>
</template>

<script>
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
      console.log("1");
      var modelo = document.getElementById("modelo").value;
      console.log("2");
      var numeroDeSerie = document.getElementById("serialnumberProduct").value;
      console.log("3");
      var descricao = document.getElementById("descricao").value;
      console.log("4");
      var dataFabricacao = document.getElementById("dataFabricacao").value;
      console.log("5");
      var token = localStorage.getItem("SavedToken");
      console.log("6");
      // var date = new Date()
      // var dateFormated = date.toLocaleString("pt-BR")

      var myHeaders = new Headers();
      myHeaders.append("Content-Type", "application/json");
      myHeaders.append("Authorization", `${token}`);

      var raw = JSON.stringify({
        modelo: modelo,
        numeroDeSerie: numeroDeSerie,
        descricao: descricao,
        dataFabricacao: dataFabricacao,
      });

      var requestOptions = {
        method: "POST",
        headers: myHeaders,
        body: raw,
        redirect: "follow",
      };

      fetch("https://subiter.azurewebsites.net/products", requestOptions)
        .then((response) => response.text())
        .then((result) => console.log(result))
        .catch((error) => console.log("error", error));

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
