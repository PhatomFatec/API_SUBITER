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
      <h3>Cadastro de Serviço</h3>
      <fieldset id="fieldNome">
        <legend id="legendNome">Nome do serviço</legend>
        <input type="text" id="modelo" />
      </fieldset>
      <fieldset id="fieldDescricao">
        <legend id="legendDescricao">Descrição</legend>
        <textarea type="text" id="descricao" />
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
    closeModal() {
      var modal = document.getElementById("modal");
      var inputs = modal.querySelectorAll("input, textarea");
      modal.style.display = "none";
      inputs.forEach((input) => {
        input.value = "";
      });
    },
    createProduct() {
      var modelo = document.getElementById("modelo").value;
      var descricao = document.getElementById("descricao").value;
      var token = localStorage.getItem("Token");
      // var date = new Date()
      // var dateFormated = date.toLocaleString("pt-BR")

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

      if (modelo.trim() == "") {
        turnRed("fieldNome", "legendNome", "modelo");
      }

      if (descricao.trim() == "") {
        turnRed("fieldDescricao", "legendDescricao", "descricao");
      }

      if (
        //verificações antes do post
        modelo.trim() != "" &&
        descricao.trim() != ""
      ) {
        var myHeaders = new Headers();
        myHeaders.append("Content-Type", "application/json");
        myHeaders.append("Authorization", `${token}`);

        var raw = JSON.stringify({
          model: modelo,
          serialNumber: "string",
          description: descricao,
          manufactureDate: "string",
        });

        var requestOptions = {
          method: "POST",
          headers: myHeaders,
          body: raw,
          redirect: "follow",
        };

        fetch("https://subiter.herokuapp.com/products", requestOptions)
          .then((response) => {
            response.text();
            this.closeModal();
            this.$emit("change");
            this.cadastra();
          })
          .catch((error) => {
            console.log("error", error);
            this.naoCadastra();
          });

        var modal = document.getElementById("modal");
        var inputs = modal.querySelectorAll("input, textarea");
        modal.style.display = "none";
        inputs.forEach((input) => {
          input.value = "";
        });
      }
    },
  },
};
</script>
