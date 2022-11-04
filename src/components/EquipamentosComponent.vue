<template>
  <v-card>
    <v-card-title>
      Lista de acesso aos equipamento
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
      :items="equipamento"
      :search="search"
    ></v-data-table>
  </v-card>
</template>

<script>
export default {
  name: "equipamentoComponent",
  props: {
    equipamento: Array,
  },
  data(equipamento) {
    console.log("aquimesmo");
    console.log(equipamento);
    console.log("aquimesmo");
    return {
      search: "",
      headers: [
        {
          text: "Código",
          align: "start",
          sortable: false,
          value: "id",
        },
        { text: "Nome do equipamento", value: "name" },
        { text: "Descrição", value: "description" },
        { text: "Número de série", value: "serialNumber" },
        { text: "Disponibilidade", value: "availability" },
        { text: "Data de fabricação", value: "date" },
      ],
    };
  },
};
</script>

<style scoped>
@import "@/sass/components/vuetify/table.css";
</style>