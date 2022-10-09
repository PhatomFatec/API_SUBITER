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
      <fieldset>
        <legend>Nome</legend>
        <input type="text" placeholder="" id="nomeClient" />
      </fieldset>
      <fieldset id="fieldCpf">
        <legend id="legendCpf">CPF</legend>
        <input type="text" placeholder="" id="cpfClient" />
      </fieldset>
      <fieldset>
        <legend>Telefone</legend>
        <input type="tel" placeholder="" id="telClient" />
      </fieldset>
      <fieldset>
        <legend>Razão Social</legend>
        <input type="text" placeholder="" id="socialreasonClient" />
      </fieldset>
      <fieldset>
        <legend>CNPJ</legend>
        <input type="text" placeholder="" id="cnpjClient" />
      </fieldset>
      <fieldset>
        <legend>E-mail</legend>
        <input type="email" placeholder="" id="emailClient" />
      </fieldset>
      <fieldset>
        <legend>Senha</legend>
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
    closeModal() {
      var modal = document.getElementById("modal");
      var inputs = modal.querySelectorAll("input, textarea");
      modal.style.display = "none";
      inputs.forEach((input) => {
        input.value = "";
      });
    },
    createClient() {
      var nome = document.getElementById("nomeClient").value;
      var cpf = document.getElementById("cpfClient").value;
      var tel = document.getElementById("telClient").value;
      var razaoSocial = document.getElementById("socialreasonClient").value;
      var cnpj = document.getElementById("cnpjClient").value;
      var email = document.getElementById("emailClient").value;
      var password = document.getElementById("passClient").value;
      var roles = document.getElementById("rolesClient").value;
      var token = localStorage.getItem("SavedToken")

      if (cpf.trim() == ''){
        document.getElementById("fieldCpf").style.borderColor = "red";
        document.getElementById("legendCpf").style.color = "red";
      }else{
var myHeaders = new Headers();
      myHeaders.append("Content-Type", "application/json");
      myHeaders.append(
        "Authorization",
        `${token}`
      );

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

      fetch("http://localhost:8090/users", requestOptions)
        .then((response) => response.text())
        .then((result) => console.log(result))
        .catch((error) => console.log("error", error));

      var modal = document.getElementById("modal");
      modal.style.display = "none";
      }

      
    },
  },
};
</script>
  