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
      <h3>Atualizar Produto</h3>
      <fieldset>
        <legend>Serviço</legend>
        <select @change="atualiza()" id="codProdutoUpdate">
          <option>Selecione o Serviço</option>
          <option v-for="serv in servicoList" :key="serv.id">
            {{ serv.id }} - {{ serv.model }}
          </option>
        </select>
      </fieldset>
      <fieldset>
        <legend>Serviço cadastrado</legend>
        <input type="text" id="servicoNomeUpdate" />
      </fieldset>
      <fieldset>
        <legend>Descrição do Serviço</legend>
        <textarea
          name="servicoDesc"
          id="descricaoUpdate"
          cols="10"
          rows="5"
        ></textarea>
      </fieldset>
      <div class="buttons">
        <button id="cancelar" v-on:click="closeUpdate()">Cancelar</button>
        <button id="criar" v-on:click="updateProduto()">Update</button>
      </div>
    </div>
  </div>
</template>


<script>
//import axios from 'axios'
export default {
  name: "UpdateProduto",
  props: {
    produtos: Array,
  },
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
    closeUpdate() {
      var modal = document.getElementById("update");
      var inputs = modal.querySelectorAll("input, textarea");
      modal.style.display = "none";
      inputs.forEach((input) => {
        input.value = "";
      });
    },
    atualiza() {
      var codProdutoUpdate = document
        .getElementById("codProdutoUpdate")
        .value.split(" ")[0];

      var cont = 0;
      while (cont < this.servicoList.length) {
        if (this.servicoList[cont].id == codProdutoUpdate) {
          document.getElementById("servicoNomeUpdate").value =
            this.servicoList[cont].model;
          document.getElementById("descricaoUpdate").value =
            this.servicoList[cont].description;
        }
        if (codProdutoUpdate == "Selecione") {
          document.getElementById("servicoNomeUpdate").value = "";
          document.getElementById("descricaoUpdate").value = "";
        }
        cont++;
      }
    },
    updateProduto() {
      var myHeaders = new Headers();
      var token = localStorage.getItem("Token");
      myHeaders.append("Content-Type", "application/json");
      myHeaders.append("Authorization", `${token}`);

      var codProdutoUpdate = document
        .getElementById("codProdutoUpdate")
        .value.split(" ")[0];
      var servicoNomeUpdate =
        document.getElementById("servicoNomeUpdate").value;
      var descricaoUpdate = document.getElementById("descricaoUpdate").value;

      var raw = JSON.stringify({
        model: servicoNomeUpdate,
        description: descricaoUpdate,
      });

      var requestOptions = {
        method: "PUT",
        headers: myHeaders,
        body: raw,
        redirect: "follow",
      };

      fetch(
        `https://subiter.herokuapp.com/products/${codProdutoUpdate}`,
        requestOptions
      )
        .then((response) => {
          response.text()
          this.closeUpdate()
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
      servicoList: [],
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

    fetch("https://subiter.herokuapp.com/products", requestOptions)
      .then((response) => response.text())
      .then((result) => {
        // console.log(result);
        this.servicoList = JSON.parse(result);
      });
  },
};
</script>
