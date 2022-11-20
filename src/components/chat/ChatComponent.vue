<template>
  <div class="chat">
    <div class="iconChat" id="iconChat">
      <svg
        v-on:click="abreChat()"
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
        <path
          d="M21 11.5a8.38 8.38 0 0 1-.9 3.8 8.5 8.5 0 0 1-7.6 4.7 8.38 8.38 0 0 1-3.8-.9L3 21l1.9-5.7a8.38 8.38 0 0 1-.9-3.8 8.5 8.5 0 0 1 4.7-7.6 8.38 8.38 0 0 1 3.8-.9h.5a8.48 8.48 0 0 1 8 8v.5z"
        ></path>
      </svg>
    </div>
    <div class="chatField" id="chatField">
      <div class="choseRequest" id="choseRequest">
        <select id="requestIdChat" @change="atualizaChat()">
          <option>Selecione o chamado</option>
          <option v-for="c in chatChamados" :key="c.id">
            {{ c.id }} - {{ c.title }}
          </option>
        </select>
        <div class="fechaChat">
          <svg
            v-on:click="fechaChat()"
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
        </div>
      </div>
      <div class="mensagens" id="mensagens">
        <div class="mensagem" v-for="m in chatComentariosAtual" :key="m.id">
          <div class="nome">
            {{ m.user.name }} 
            <div v-if="m.user.roles === 'ROLE_ADMIN'">&nbsp; Admin</div>
            <div v-else-if="m.user.roles === 'ROLE_SUPPORT'">&nbsp; Suporte</div>
            <div v-else-if="m.user.roles === 'ROLE_CLIENT'">&nbsp; Cliente</div>
          </div>
          <div class="texto">{{ m.comment }}</div>
        </div>
      </div>
      <div class="caixaTexto">
        <input type="text" id="textoMensagem" placeholder="Mensagem" />
        <div class="iconSend">
          <svg
            v-on:click="enviaMensagem()"
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
            <line x1="22" y1="2" x2="11" y2="13"></line>
            <polygon points="22 2 15 22 11 13 2 9 22 2"></polygon>
          </svg>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  name: "ChatComponent",
  data() {
    return {
      chatChamados: [],
      chatComentarios: [],
      chatComentariosAtual: [],
    };
  },
  methods: {
    fechaChat() {
      document.getElementById("chatField").style.height = "0px";
    },
    abreChat() {
      document.getElementById("chatField").style.height = "400px";
    },
    atualizaChat() {
      this.chatComentariosAtual = [];
      var myHeaders = new Headers();
      var token = localStorage.getItem("Token");
      myHeaders.append("Content-Type", "application/json");
      myHeaders.append("Authorization", `${token}`);

      var requestOptions = {
        method: "GET",
        headers: myHeaders,
        redirect: "follow",
      };

      fetch("https://subiter.herokuapp.com/comments", requestOptions)
        .then((response) => response.text())
        .then((result) => {
          this.chatComentarios = JSON.parse(result);

          var requestIdChat = document
            .getElementById("requestIdChat")
            .value.split(" ")[0];
          var cont = 0;
          while (cont < this.chatComentarios.length) {
            if (this.chatComentarios[cont].request.id == requestIdChat) {
              this.chatComentariosAtual.push(this.chatComentarios[cont]);
              console.log(this.chatComentariosAtual);
              this.chatComentariosAtual.sort(function (a, b) {
                return a.id - b.id;
              });
            }
            cont++;
          }
        });
    },
    enviaMensagem() {
      var requestIdChat = document
        .getElementById("requestIdChat")
        .value.split(" ")[0];
      var textoMensagem = document.getElementById("textoMensagem").value;
      var token = localStorage.getItem("Token");
      var myHeaders = new Headers();
      myHeaders.append("Content-Type", "application/json");
      myHeaders.append("Authorization", `${token}`);

      var raw = JSON.stringify({
        comment: textoMensagem,
        request: {
          id: requestIdChat,
        },
        user: {
          id: localStorage.getItem("Id"),
        },
      });

      var requestOptions = {
        method: "POST",
        headers: myHeaders,
        body: raw,
        redirect: "follow",
      };

      fetch("https://subiter.herokuapp.com/comments", requestOptions)
        .then((response) => response.text())
        .then(this.atualizaChat)
        .then((document.getElementById("textoMensagem").value = ""))
        .catch((error) => console.log("error", error));
    },
  },
  created() {
    var myHeaders = new Headers();
    var token = localStorage.getItem("Token");
    myHeaders.append("Content-Type", "application/json");
    myHeaders.append("Authorization", `${token}`);

    var requestOptions = {
      method: "GET",
      headers: myHeaders,
      redirect: "follow",
    };

    fetch("https://subiter.herokuapp.com/requests", requestOptions)
      .then((response) => response.text())
      .then((result) => {
        this.chatChamados = JSON.parse(result);
      });
  },
};
</script>

<style>
@import "@/sass/components/chat.css";
</style>