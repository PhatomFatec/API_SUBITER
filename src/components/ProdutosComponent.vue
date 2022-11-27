<template>
  <v-card>
    <v-card-title>
      Lista de acesso aos serviços
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
      :items="produtos"
      :search="search"
    ></v-data-table>
  </v-card>
</template>


<script>
//import axios from 'axios'
export default {
  name: "ProdutosView",
  props: {
    produtos: Array,
  },
  data(produtos) {
    console.log(produtos)
    return {
      search: "",
      headers: [
        {
          text: "Código",
          align: "start",
          sortable: false,
          value: "id",
        },
        { text: "Nome do Serviço", value: "model" },
        { text: "Descrição", value: "description" },
        { text: "Data de Cadastro", value: "registerDate" },
      ],
    };
  },
};
</script>

<style scoped>
@import "@/sass/components/vuetify/table.css";
</style>