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
      <h3>Atualizar Chamado</h3>
      <fieldset>
        <legend>Chamado</legend>
        <select @change="atualiza()" id="codChamadoUpdate">
          <option>Selecione o chamado</option>
          <option v-for="cham in chamados" :key="cham.id">
            {{ cham.id }} - {{ cham.title }}
          </option>
        </select>
      </fieldset>
      <fieldset>
        <legend>Título do Chamado</legend>
        <input type="text" placeholder="" id="tituloUpdate" />
      </fieldset>

      <fieldset>
        <legend>Descrição</legend>
        <textarea type="text" id="descricaoUpdate" />
      </fieldset>

      <fieldset>
        <legend>Serviço</legend>
        <select id="servicoUpdate">
          <option>---</option>
          <option v-for="produto in produtos" :key="produto.id">
            {{ produto.model }}
          </option>
        </select>
      </fieldset>
      <fieldset>
        <legend>Imagem</legend>
        <input id="imagemUpdate" type="file" />
      </fieldset>
      <fieldset>
        <legend>Situação</legend>
        <select id="situacao">
          <option>---</option>
          <option value="Pendente">Pendente</option>
          <option value="Em andamento">Em andamento</option>
          <option value="Fechado">Fechado</option>
        </select>
      </fieldset>
      <div class="buttons">
        <button id="cancelar" v-on:click="closeUpdate()">Cancelar</button>
        <button id="criar" v-on:click="updateChamado()">Update</button>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  name: "UpdateChamado",
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
      var codCham = document
        .getElementById("codChamadoUpdate")
        .value.split(" ")[0];
      var cont = 0;
      while (cont < this.chamados.length) {
        if (this.chamados[cont].id == codCham) {
          document.getElementById("tituloUpdate").value =
            this.chamados[cont].title;
          document.getElementById("descricaoUpdate").value =
            this.chamados[cont].description;
          document.getElementById("servicoUpdate").value =
            this.chamados[cont].product.model;
          document.getElementById("situacao").value =
            this.chamados[cont].status;
        }
        if (codCham == "Selecione") {
          document.getElementById("tituloUpdate").value = "";
          document.getElementById("descricaoUpdate").value = "";
          document.getElementById("servicoUpdate").value = "---";
          document.getElementById("situacao").value = "---";
        }
        cont++;
      }
    },
    updateChamado() {
      var myHeaders = new Headers();
      var token = localStorage.getItem("Token");
      myHeaders.append("Content-Type", "application/json");
      myHeaders.append("Authorization", `${token}`);

      var tituloUp = document.getElementById("tituloUpdate").value;
      var descUp = document.getElementById("descricaoUpdate").value;
      var servUp = document.getElementById("servicoUpdate").value;
      var sitUp = document.getElementById("situacao").value;
      var codCham = document
        .getElementById("codChamadoUpdate")
        .value.split(" ")[0];

      var servicosLista = this.produtos;
      var serv = null;
      var cont = 0;
      while (cont < servicosLista.length) {
        if (servicosLista[cont].model == servUp) {
          serv = servicosLista[cont].id;
        }
        cont++;
      }

      var raw = JSON.stringify({
        description: descUp,
        imgUrl: "string",
        product: {
          id: serv,
        },
        user: {
          id: localStorage.getItem("Id"),
        },
        status: sitUp,
        title: tituloUp,
      });

      var requestOptions = {
        method: "PUT",
        headers: myHeaders,
        body: raw,
        redirect: "follow",
      };

      fetch(`https://subiter.herokuapp.com/requests/${codCham}`, requestOptions)
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
      produtos: [],
      chamados: [],
    };
  },
  created() {
    // Pegando lista de serviços
    var myHeaders = new Headers();
    var token = localStorage.getItem("Token");
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
        this.produtos = JSON.parse(result);
      })
      .catch((error) => console.log("error", error));
    fetch("https://subiter.herokuapp.com/requests", requestOptions)
      .then((response) => response.text())
      .then((result) => {
        this.chamados = JSON.parse(result);
      })
      .catch((error) => console.log("error", error));
  },
};
</script>