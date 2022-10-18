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
      <h3>Cadastro de Cliente</h3>
      <fieldset id="fieldNome">
        <legend id="legendNome">Nome</legend>
        <input type="text" placeholder="" id="nomeClient" />
      </fieldset>
      <fieldset id="fieldCpf">
        <legend id="legendCpf">CPF</legend>
        <input type="text" placeholder="" id="cpfClient" />
      </fieldset>
      <fieldset id="fieldTelefone">
        <legend id="legendTelefone">Telefone</legend>
        <input type="tel" placeholder="" id="telClient" />
      </fieldset>
      <fieldset id="fieldRazaoSocial">
        <legend id="legendRazaoSocial">Razão Social</legend>
        <input type="text" placeholder="" id="socialreasonClient" />
      </fieldset>
      <fieldset id="fieldCnpj">
        <legend id="legendCnpj">CNPJ</legend>
        <input type="text" placeholder="" id="cnpjClient" />
      </fieldset>
      <fieldset id="fieldEmail">
        <legend id="legendEmail">E-mail</legend>
        <input type="email" placeholder="" id="emailClient" />
      </fieldset>
      <fieldset id="fieldSenha">
        <legend id="legendSenha">Senha</legend>
        <input type="password" placeholder="" id="passClient" />
      </fieldset>
      <fieldset>
        <legend>Role</legend>
        <select name="roles" id="rolesClient">
          <option value="ROLE_ADMIN">Administrador</option>
          <option value="ROLE_CLIENT">Cliente</option>
          <option value="ROLE_SUPPORT">Suporte</option>
        </select>
      </fieldset>
      <div class="buttons">
        <button id="cancelar" v-on:click="closeModal()">Cancelar</button>
        <button id="criar" v-on:click="createClient()">Criar</button>
      </div>
    </div>
  </div>
</template>
  
<script>
// import axios from "axios";

export default {
  name: "FormCliente",
  methods: {
    // CHANGE COLOR ******************************************************************
    backFieldBlue(x) {
      document.getElementById(x).style.borderColor = "#2196F3";
      document.getElementById(x).style.background = "#fff";
    },
    backLegendBlue(x) {
      document.getElementById(x).style.color = "#2196F3";
    },
    backBlue(f, l) {
      this.backFieldBlue(f);
      this.backLegendBlue(l);
    },
    backAllBlue() {
      this.backBlue("fieldNome", "legendNome");
      this.backBlue("fieldCpf", "legendCpf");
      this.backBlue("fieldTelefone", "legendTelefone");
      this.backBlue("fieldRazaoSocial", "legendRazaoSocial");
      this.backBlue("fieldCnpj", "legendCnpj");
      this.backBlue("fieldEmail", "legendEmail");
      this.backBlue("fieldSenha", "legendSenha");
    },
    // CHANGE COLOR END **************************************************************
    //CLOSE MODAL ********************************************************************
    closeModal() {
      var modal = document.getElementById("modal");
      var inputs = modal.querySelectorAll("input, textarea");
      modal.style.display = "none";
      inputs.forEach((input) => {
        input.value = "";
      });
      this.backAllBlue();
    },
    //CLOSE MODAL END ****************************************************************
    //CREATE CLIENT ******************************************************************
    createClient() {
      var nome = document.getElementById("nomeClient").value;
      var cpf = document.getElementById("cpfClient").value;
      var tel = document.getElementById("telClient").value;
      var razaoSocial = document.getElementById("socialreasonClient").value;
      var cnpj = document.getElementById("cnpjClient").value;
      var email = document.getElementById("emailClient").value;
      var password = document.getElementById("passClient").value;
      var roles = document.getElementById("rolesClient").value;
      var token = localStorage.getItem("SavedToken");

      this.backAllBlue();

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

      if (nome.trim() == "") {
        turnRed("fieldNome", "legendNome", "nomeClient");
      }
      if (cpf.trim() == "") {
        turnRed("fieldCpf", "legendCpf", "cpfClient");
      }
      if (tel.trim() == "") {
        turnRed("fieldTelefone", "legendTelefone", "telClient");
      }
      if (razaoSocial.trim() == "") {
        turnRed("fieldRazaoSocial", "legendRazaoSocial", "socialreasonClient");
      }
      if (cnpj.trim() == "") {
        turnRed("fieldCnpj", "legendCnpj", "cnpjClient");
      }
      if (email.trim() == "") {
        turnRed("fieldEmail", "legendEmail", "emailClient");
      }
      if (password.trim() == "") {
        turnRed("fieldSenha", "legendSenha", "passClient");
      }
      if (
        nome.trim() != "" &&
        cpf.trim() != "" &&
        tel.trim() != "" &&
        razaoSocial.trim() != "" &&
        cnpj.trim() != "" &&
        email.trim() != "" &&
        password.trim() != ""
      ) {
        var myHeaders = new Headers();
        myHeaders.append("Content-Type", "application/json");
        myHeaders.append("Authorization", `${token}`);

        var raw = JSON.stringify({
          email: email,
          password: password,
          roles: roles,
          cpf: cpf,
          telefone: tel,
          nome: nome,
          razaoSocial: razaoSocial,
          cnpj: cnpj,
        });

        var requestOptions = {
          method: "POST",
          headers: myHeaders,
          body: raw,
          redirect: "follow",
        };

        fetch("https://subiter.azurewebsites.net/users", requestOptions)
          .then((response) => response.text())
          .then((result) => console.log(result))
          .catch((error) => console.log("error", error));

        var modal = document.getElementById("modal");
        var inputs = modal.querySelectorAll("input, textarea");
        modal.style.display = "none";
        inputs.forEach((input) => {
          input.value = "";
        });
      }
    },
    //CREATE CLIENT END **************************************************************
  },
};
</script>