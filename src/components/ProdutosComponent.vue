<template>
  <v-card>
    <v-card-title>
      Lista de acesso aos chamados
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
    console.log("aeee")
    console.log(produtos)
    console.log("aaaaaa")
    return {
      search: "",
      headers: [
        {
          text: "Código",
          align: "start",
          sortable: false,
          value: "id",
        },
        { text: "Nome do Produto", value: "modelo" },
        { text: "Número de série", value: "numeroDeSerie" },
        { text: "Descrição", value: "descricao" },
        { text: "Data de Fabricação", value: "dataFabricacao" },
        { text: "Data de Cadastro", value: "dataCadastro" },
      ],
    };
  },
};
</script>

<style scoped>
@import "@/sass/components/vuetify/table.css";
</style>