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
      <h3>Cadastro de Chamado</h3>

      <fieldset id="fieldTitulo">
        <legend id="legendTitulo">Título do Chamado</legend>
        <input type="text" placeholder="" id="titulo" />
      </fieldset>

      <fieldset id="fieldDescricao">
        <legend id="legendDescricao">Descrição</legend>
        <textarea type="text" id="descricao" />
      </fieldset>

      <fieldset id="fieldServico">
        <legend id="legendServico">Serviço</legend>
        <select id="servico">
          <option v-for="produto in produtos" :key="produto.id">
            {{ produto.model }}
          </option>
        </select>
      </fieldset>
      <fieldset id="fieldImagem">
        <legend id="legendImagem">Imagem</legend>
        <input id="imagem" type="file" />
      </fieldset>

      <div class="buttons">
        <button id="cancelar" v-on:click="closeModal()">Cancelar</button>
        <button id="criar" v-on:click="createCall()">Criar</button>
      </div>
    </div>
  </div>
</template>
  
<script>
// import axios from "axios";

export default {
  name: "FormChamado",
  props: {},
  methods: {
    closeModal() {
      var modal = document.getElementById("modal");
      var inputs = modal.querySelectorAll("input, textarea");
      modal.style.display = "none";
      inputs.forEach((input) => {
        input.value = "";
      });
    },
    createCall() {
      var token = localStorage.getItem("Token");
      var titulo = document.getElementById("titulo").value;
      var descricao = document.getElementById("descricao").value;
      var servico = document.getElementById("servico").value;
      var imagem = document.getElementById("imagem").value;
      var usuario = localStorage.getItem("Id");
      var myHeaders = new Headers();

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

      if (titulo.trim() == "") {
        turnRed("fieldTitulo", "legendTitulo", "modelo");
      }

      if (descricao.trim() == "") {
        turnRed("fieldDescricao", "legendDescricao", "descricao");
      }

      if (servico.trim() == "Serviço") {
        turnRed("fieldServico", "legendServico", "servico");
      }

      if (imagem.trim() == "") {
        turnRed("fieldImagem", "legendImagem", "imagem");
      }

      if (
        //verificações antes do post
        titulo.trim() != "" &&
        descricao.trim() != "" &&
        servico.trim() != "" &&
        imagem.trim() != ""
      ) {
        myHeaders.append("Content-Type", "application/json");
        myHeaders.append("Authorization", `${token}`);
        var servicosLista = this.produtos;
        var serv = null;
        var cont = 0;
        while (cont < servicosLista.length) {
          if (servicosLista[cont].model == servico) {
            serv = servicosLista[cont].id;
          }
          cont++;
        }

        var raw = JSON.stringify({
          title: titulo,
          description: descricao,
          imgUrl: imagem,
          status: "Pendente",
          product: {
            id: serv,
          },
          user: {
            id: usuario,
          },
        });

        var requestOptions = {
          method: "POST",
          headers: myHeaders,
          body: raw,
          redirect: "follow",
        };

        fetch("https://subiter.herokuapp.com/requests", requestOptions)
          .then((response) => response.text())
          // .then((result) => console.log(result))
          .then(this.closeModal())
          .then(this.$emit("change"))
          .catch((error) => console.log("error", error));

        var modal = document.getElementById("modal");
        var inputs = modal.querySelectorAll("input, textarea");
        modal.style.display = "none";
        inputs.forEach((input) => {
          input.value = "";
        });

        // get do ultmo chamado -> settimeout 3s
        // criar uma comparação pelos campos encontrados do último request
        setTimeout(function () {
          var id = usuario.id;
          var requestOptions2 = {
            method: "GET",
            headers: myHeaders,
            redirect: "follow",
          };
          fetch(`https://subiter.herokuapp.com/requests/${id}`, requestOptions2) // mudar endpoint
            .then((response) => response.text())
            .catch((error) => console.log("error", error));
        }, 3000);

        setTimeout(function () {
          var raw2 = JSON.stringify({
            imgUrl: imagem,
          });
          var requestOptions2 = {
            method: "POST",
            headers: myHeaders,
            body: raw2,
            redirect: "follow",
          };
          fetch(
            "https://subiter.herokuapp.com/requests/upload",
            requestOptions2
          ) // mudar endpoint
            .then((response) => response.text())
            // .then((result) => console.log(result))
            .catch((error) => console.log("error", error));
          // var modal = document.getElementById("modal");
          // var inputs = modal.querySelectorAll("input, textarea");
        }, 6000);
      }
    },
  },
  data() {
    return {
      produtos: [],
    };
  },
  created() {
    // Pegando ID do usuário logado
    var usuarios = Object;
    var myHeaders = new Headers();
    var token = localStorage.getItem("Token");
    myHeaders.append("Content-Type", "application/json");
    myHeaders.append("Authorization", `${token}`);

    var requestOptions = {
      method: "GET",
      headers: myHeaders,
      redirect: "follow",
    };

    fetch("https://subiter.herokuapp.com/users", requestOptions)
      .then((response) => response.text())
      .then((result) => {
        usuarios = JSON.parse(result);
        // console.log(usuarios);
        var cont = 0;
        var user_id = null;
        // console.log("aqui");
        // console.log(usuarios[0]);
        while (cont < usuarios.length) {
          if (usuarios[cont].email == localStorage.getItem("User")) {
            localStorage.setItem("Id", usuarios[cont].id);
          }
          cont++;
        }
        console.log(user_id);
      });
    // ------------------------------------------------------------
    // Pegando lista de serviços

    fetch("https://subiter.herokuapp.com/products", requestOptions)
      .then((response) => response.text())
      .then((result) => {
        // console.log("aopa");
        // console.log(result);
        this.produtos = JSON.parse(result);
        // console.log(this.produtos);
      })
      .catch((error) => console.log("error", error));
  },
};
</script>
  