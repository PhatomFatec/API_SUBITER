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
        <input type="email" required placeholder="" id="emailClient" />
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
export default {
  name: "FormCliente",
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
      var token = localStorage.getItem("Token");

      this.backAllBlue();

      function isValidCPF(cpf) {
        if (cpf.length == 11) {
          return true;
        } else return false;
      }

      function validaCNPJ(cnpj) {
        if (cnpj.length >= 14) {
          return true;
        } else return false;
      }

      function validaTel(tel) {
        if (tel.length == 11 && tel[2] == "9") {
          return true;
        } else return false;
      }

      var telValido = validaTel(tel);
      var cnpjValido = validaCNPJ(cnpj);
      var cpfValido = isValidCPF(cpf);

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
      } else if (cpfValido == false) {
        console.log("falso");
        document.getElementById("cpfClient").value = "";
        document.getElementById("cpfClient").placeholder =
          "Digite um CPF valido!";
        turnRed("fieldCpf", "legendCpf", "cpfClient");
      }

      if (tel.trim() == "") {
        turnRed("fieldTelefone", "legendTelefone", "telClient");
      } else if (telValido == false) {
        console.log("falso");
        document.getElementById("telClient").value = "";
        document.getElementById("telClient").placeholder =
          "Digite um Telefone valido!";
        turnRed("fieldTelefone", "legendTelefone", "telClient");
      }
      if (razaoSocial.trim() == "") {
        turnRed("fieldRazaoSocial", "legendRazaoSocial", "socialreasonClient");
      }
      if (cnpj.trim() == "") {
        turnRed("fieldCnpj", "legendCnpj", "cnpjClient");
      } else if (cnpjValido == false) {
        console.log("falso");
        document.getElementById("cnpjClient").value = "";
        document.getElementById("cnpjClient").placeholder =
          "Digite um CNPJ valido!";
        turnRed("fieldCnpj", "legendCnpj", "cnpjClient");
      }

      if (email.trim() == "") {
        turnRed("fieldEmail", "legendEmail", "emailClient");
      } else if (email.includes("@") == false) {
        document.getElementById("emailClient").value = "";
        document.getElementById("emailClient").placeholder =
          "Digite um email valido!";
        turnRed("fieldEmail", "legendEmail", "emailClient");
        var emailValido = false;
        return emailValido;
      }
      if (password.trim() == "") {
        turnRed("fieldSenha", "legendSenha", "passClient");
      } else if (password.length <= 8) {
        document.getElementById("passClient").value = "";
        document.getElementById("passClient").placeholder =
          "Digite uma Senha valida! (min: 8 caracteres)";
        turnRed("fieldSenha", "legendSenha", "passClient");
      }

      if (
        //verificações antes do post
        nome.trim() != "" &&
        cpf.trim() != "" &&
        cpfValido != false &&
        tel.trim() != "" &&
        telValido != false &&
        razaoSocial.trim() != "" &&
        cnpj.trim() != "" &&
        cnpjValido != false &&
        email.trim() != "" &&
        emailValido != false &&
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
          foneNumber: tel,
          name: nome,
          corporateName: razaoSocial,
          cnpj: cnpj,
        });

        var requestOptions = {
          method: "POST",
          headers: myHeaders,
          body: raw,
          redirect: "follow",
        };

        fetch("https://subiter.herokuapp.com/users", requestOptions)
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
    //CREATE CLIENT END **************************************************************
  },
};
</script>