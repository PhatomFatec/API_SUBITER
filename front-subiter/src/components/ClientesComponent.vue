<template>
  <v-card>
    <v-card-title>
      Lista de acesso aos clientes
      <v-spacer></v-spacer>
      <v-text-field
        v-model="search"
        append-icon="mdi-magnify"
        label="Pesquisar"
        single-line
        hide-details
      ></v-text-field>
    </v-card-title>
    <v-data-table
      :headers="headers"
      :items="clientes"
      :search="search"
    ></v-data-table>
  </v-card>
</template>
  
  
<script>
//import axios from 'axios'
export default {
  name: "ClientesView",
  props: { clientes: Array },
  data(clientes) {
    console.log(clientes);
    return {
      search: "",
      headers: [
        {
          text: "Código",
          align: "start",
          sortable: false,
          value: "calories",
        },
        { text: "Nome do cliente", value: "nome" },
        { text: "CPF", value: "cpf" },
        { text: "Telefone", value: "telefone" },
        { text: "E-mail", value: "email" },
        { text: "Razão Social", value: "razaoSocial" },
        { text: "CNPJ", value: "cnpj" },
      ],
    };
  },
};
</script>