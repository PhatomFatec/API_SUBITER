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
      <h3>Atualizar Cliente</h3>
      <fieldset>
        <legend>Cliente</legend>
        <select @change="atualiza()" id="codClienteUpdate">
          <option>Selecione o Cliente</option>
          <option v-for="cli in clienteList" :key="cli.id">
            {{ cli.id }} - {{ cli.name }}
          </option>
        </select>
      </fieldset>
      <fieldset>
        <legend>Usuário cadastrado</legend>
        <input type="text" id="clienteNomeUpdate" />
      </fieldset>
      <fieldset id="fieldEmail">
        <legend id="legendEmail">E-mail</legend>
        <input type="text" id="emailUpdate" required />
      </fieldset>
      <fieldset id="fieldTelefone">
        <legend id="legendTelefone">Telefone</legend>
        <input type="text" id="fonenumberUpdate" />
      </fieldset>
      <div class="buttons">
        <button id="cancelar" v-on:click="closeUpdate()">Cancelar</button>
        <button id="criar" v-on:click="UpdateCliente()">Update</button>
      </div>
    </div>
  </div>
</template>


<script>
//import axios from 'axios'
export default {
  name: "UpdateCliente",
  props: {
    clientes: Array,
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
      var codClienteUpdate = document
        .getElementById("codClienteUpdate")
        .value.split(" ")[0];

      var cont = 0;
      while (cont < this.clienteList.length) {
        if (this.clienteList[cont].id == codClienteUpdate) {
          document.getElementById("clienteNomeUpdate").value =
            this.clienteList[cont].name;
          document.getElementById("emailUpdate").value =
            this.clienteList[cont].email;
          document.getElementById("fonenumberUpdate").value =
            this.clienteList[cont].foneNumber;
        }
        if (codClienteUpdate == "Selecione") {
          document.getElementById("clienteNomeUpdate").value = "";
          document.getElementById("emailUpdate").value = "";
          document.getElementById("fonenumberUpdate").value = "";
        }
        cont++;
      }
    },
    UpdateCliente() {
      var codClienteUpdate = document
        .getElementById("codClienteUpdate")
        .value.split(" ")[0];
      var clienteNomeUpdate =
        document.getElementById("clienteNomeUpdate").value;
      var emailUpdate = document.getElementById("emailUpdate").value;
      var fonenumberUpdate = document.getElementById("fonenumberUpdate").value;
      //var telValido = validaTel(fonenumberUpdate)

      var passwordCliente = null;
      var cnpjU = null;
      var corporateNameU = null;
      var cpfU = null;
      var rolesU = null;

      var myHeaders = new Headers();
      var token = localStorage.getItem("Token");
      myHeaders.append("Content-Type", "application/json");
      myHeaders.append("Authorization", `${token}`);

      function validaTel(tel) {
        if (tel.length == 11 && tel[2] == "9") {
          return true;
        } else return false;
      }

      let telefoneValido = validaTel(fonenumberUpdate);

      if (telefoneValido == false || fonenumberUpdate == "") {
        document.getElementById("fonenumberUpdate").value = "";
        document.getElementById("fonenumberUpdate").placeholder =
          "Digite um Telefone valido!";
      }
      if (emailUpdate == "" || emailUpdate.includes("@") == false) {
        document.getElementById("emailUpdate").value = "";
        document.getElementById("emailUpdate").placeholder =
          "Digite um Email valido!";
        var emailValido = false;
      }

      var cont = 0;
      while (cont < this.clienteList.length) {
        if (this.clienteList[cont].id == codClienteUpdate) {
          passwordCliente = this.clienteList[cont].password;
          cnpjU = this.clienteList[cont].cnpj;
          corporateNameU = this.clienteList[cont].corporateName;
          cpfU = this.clienteList[cont].cpf;
          rolesU = this.clienteList[cont].roles;
        }
        cont++;
      }

      if (telefoneValido != false && emailValido != false) {
        var raw = JSON.stringify({
          name: clienteNomeUpdate,
          email: emailUpdate,
          foneNumber: fonenumberUpdate,
          cnpj: cnpjU,
          corporateName: corporateNameU,
          cpf: cpfU,
          password: passwordCliente,
          roles: rolesU,
        });

        var requestOptions = {
          method: "PUT",
          headers: myHeaders,
          body: raw,
          redirect: "follow",
        };

        fetch(
          `https://subiter.herokuapp.com/users/${codClienteUpdate}`,
          requestOptions
        )
          .then((response) => {
            response.text();
            this.closeUpdate();
            this.$emit("change");
            this.cadastra();
          })
          .catch((error) => {
            console.log("error", error);
            this.naoCadastra();
          });
      }
    },
  },

  data() {
    return {
      clienteList: [],
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

    fetch("https://subiter.herokuapp.com/users", requestOptions)
      .then((response) => response.text())
      .then((result) => {
        // console.log(result);
        this.clienteList = JSON.parse(result);
      });
  },
};
</script>
