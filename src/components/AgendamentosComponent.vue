<template>
  <v-card>
    <v-card-title>
      Lista de acesso aos chamados
      <v-spacer></v-spacer>
      <v-text-field v-model="search" append-icon="mdi-magnify" label="Pesquisar" single-line hide-details>
      </v-text-field>
    </v-card-title>
    <v-data-table :headers="headers" :items="agendamentos" :search="search"></v-data-table>
  </v-card>
</template>
  
  
<script>
export default {
  name: "AgendamentosComponent",
  props: {
    agendamentos: Array,
  },
  data(agendamentos) {
    console.log(agendamentos);
    return {
      search: "",
      headers: [
        {
          text: "Código",
          align: "start",
          sortable: false,
          value: "id",
        },
        { text: "Tipo de Serviço", value: "serviceProvided" },
        { text: "Horario", value: "appointment" },
        { text: "Data", value: "data" },
        { text: "Endereço", value: "address" },
        { text: "Cidade", value: "city" },
        { text: "Estado", value: "state" },
        { text: "CEP", value: "zipcode" },
      ],
    };
  },
};
</script>