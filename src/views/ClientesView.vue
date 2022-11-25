<template>
  <div class="clientes">
    <div class="sub-menu"></div>
    <FormCliente @change="load" />
    <DeleteCliente @change="load" />
    <UpdateCliente @change="load" />
    <ClientesComponent :clientes="clientes" />
    <AlertComponent />
  </div>
</template>

<script>
import ClientesComponent from "@/components/ClientesComponent.vue";
import FormCliente from "@/components/forms/FormCliente.vue";
import DeleteCliente from "@/components/forms/DeleteCliente.vue";
import UpdateCliente from "@/components/forms/UpdateCliente.vue";
import AlertComponent from "@/components/alerts/AlertsComponent.vue"

export default {
  name: "ClientesView",
  components: {
    ClientesComponent,
    FormCliente,
    DeleteCliente,
    UpdateCliente,
    AlertComponent
  },
  data() {
    return {
      clientes: [],
    };
  },
  methods: {
    //faz o get da tabela
    load() {
      var myHeaders = new Headers();
      var token = localStorage.getItem("Token");
      console.log(token);
      myHeaders.append("Content-Type", "application/json");
      myHeaders.append("Authorization", `${token}`);

      var requestOptions = {
        method: "GET",
        headers: myHeaders,
        redirect: "follow",
      };

      fetch("https://subiter.herokuapp.com/users", requestOptions)
        .then((response) => response.text())
        .then((result) => (this.clientes = JSON.parse(result)))
        .catch((error) => console.log("error", error));
    },
  },
  //executa assim que a tela é carregada
  created() {
    //redireciona para a página de login
    // if(localStorage.length == 0){
    //   window.location.replace("/login")
    // }
    //chama a função que carrega o get da tabela
    this.load();
    //insere botões responsáveis pelas funções do CRUD
    setTimeout(function () {
      var fatherElement =
        document.getElementsByClassName("v-input__control")[0];
      var searchElement = fatherElement.children[0];
      var searchSVG =
        "<svg viewBox='0 0 24 24' width='20' height='20' stroke='currentColor' stroke-width='2' fill='none' stroke-linecap='round' stroke-linejoin='round' class='css-1hy7qas'><circle cx='11' cy='11' r='8'></circle><line x1='21' y1='21' x2='16.65' y2='16.65'></line></svg>";
      var areaSearch = document.getElementsByClassName("v-card__title")[0];
      searchElement.insertAdjacentHTML("beforebegin", searchSVG);
      areaSearch.children[0].insertAdjacentHTML(
        "beforebegin",
        `
        <button id="btn1"  class='subMenuButton creationButton' onclick="var modal = document.getElementById('modal');modal.style.display = 'flex';modal.style.zIndex = '10';"><svg viewBox="0 0 24 24" width="24" height="24" stroke="currentColor" stroke-width="2" fill="none" stroke-linecap="round" stroke-linejoin="round" class="css-i6dzq1"><line x1="12" y1="5" x2="12" y2="19"></line><line x1="5" y1="12" x2="19" y2="12"></line></svg></button>
        <button id="btn2"  class='subMenuButton deleteButton' onclick="var delet = document.getElementById('delete');delet.style.display = 'flex';delet.style.zIndex = '10';"><svg viewBox="0 0 24 24" width="24" height="24" stroke="currentColor" stroke-width="2" fill="none" stroke-linecap="round" stroke-linejoin="round" class="css-i6dzq1"><polyline points="3 6 5 6 21 6"></polyline><path d="M19 6v14a2 2 0 0 1-2 2H7a2 2 0 0 1-2-2V6m3 0V4a2 2 0 0 1 2-2h4a2 2 0 0 1 2 2v2"></path></svg></button>
        <button id="btn3"  class='subMenuButton editButton' onclick="var update = document.getElementById('update');update.style.display = 'flex';update.style.zIndex = '10';"><svg viewBox="0 0 24 24" width="24" height="24" stroke="currentColor" stroke-width="2" fill="none" stroke-linecap="round" stroke-linejoin="round" class="css-i6dzq1"><path d="M17 3a2.828 2.828 0 1 1 4 4L7.5 20.5 2 22l1.5-5.5L17 3z"></path></svg></button
        `
      );
    }, 1);
    //remove os botões do CRUD para usuários sem acesso
    // setTimeout(function () {
    //   if (localStorage.getItem("Role") != "ROLE_ADMIN") {
    //     document.getElementById("btn1").style.display = "none";
    //     document.getElementById("btn2").style.display = "none";
    //     document.getElementById("btn3").style.display = "none";

    //     var styles = `.v-card .v-input{right:10%;}`;

    //     var styleSheet = document.createElement("style");
    //     styleSheet.innerText = styles;
    //     document.head.appendChild(styleSheet);
    //   }
    // }, 10);
  },
};
</script>
