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
      :items="agendamentos"
      :search="search"
    ></v-data-table>
  </v-card>
</template>
  
  
<script>
//import axios from 'axios'
export default {
  name: "AgendamentosView",
  props: { agendamentos: Array },
  data(agendamentos) {
    console.log(agendamentos);
    return {
      search: "",
      headers: [
        {
          text: "Código",
          align: "start",
          sortable: false,
          value: "calories",
        },
        { text: "Título do chamado", value: "name" },
        { text: "Cliente", value: "fat" },
        { text: "Produto", value: "carbs" },
        { text: "Criação", value: "protein" },
        { text: "Situação", value: "iron" },
      ],
    };
  },
};
</script>