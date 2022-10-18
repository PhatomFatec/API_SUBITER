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
      :items="chamados"
      :search="search"
    ></v-data-table>
  </v-card>
</template>

<script>
export default {
  name: "ChamadosView",
  props: {
    chamados: Array,
  },
  data(chamados) {
    console.log(chamados);
    return {
      search: "",
      headers: [
        {
          text: "Código",
          align: "start",
          sortable: false,
          value: "id",
        },
        { text: "Título do chamado", value: "titulo" },
        { text: "Cliente", value: "user" },
        { text: "Produto", value: "product" },
        { text: "Criação", value: "criacaoChamado" },
        { text: "Situação", value: "situacao" },
      ],
    };
  },
};
</script>

<style scoped>
@import "@/sass/components/vuetify/table.css";
</style>