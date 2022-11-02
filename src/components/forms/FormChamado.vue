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

      <fieldset>
        <legend>Título do Chamado</legend>
        <input type="text" placeholder="" id="titulo" />
      </fieldset>

      <fieldset>
        <legend>Descrição</legend>
        <textarea type="text" id="descricao" />
      </fieldset>

      <fieldset>
        <legend>Serviço</legend>
        <select id="servico">
          <option v-for="produto in produtos" :key="produto.id">
            {{ produto.model }}
          </option>
        </select>
      </fieldset>
      <fieldset>
        <legend>Imagem</legend>
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
    createCall() {
      var token = localStorage.getItem("Token");
      var titulo = document.getElementById("titulo").value;
      var descricao = document.getElementById("descricao").value;
      var servico = document.getElementById("servico").value
      var imagem = document.getElementById("imagem").value;
      var usuario = localStorage.getItem("Id");
      var myHeaders = new Headers();
      myHeaders.append("Content-Type", "application/json");
      myHeaders.append("Authorization", `${token}`);
      var servicosLista = this.produtos
      var serv = null
      var cont = 0
      while (cont < servicosLista.length) {
          if (servicosLista[cont].model == servico) {
            serv = servicosLista[cont].id
            console.log(serv)
          }
          cont++;
        }


      var raw = JSON.stringify({
        title: titulo,
        description: descricao,
        imgUrl: imagem,
        status: "Pendente",
        product: {
          id: serv
        },
        user: {
          id: usuario
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
        .catch((error) => console.log("error", error));

      var modal = document.getElementById("modal");
      var inputs = modal.querySelectorAll("input, textarea");
      modal.style.display = "none";
      inputs.forEach((input) => {
        input.value = "";
      });
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
  