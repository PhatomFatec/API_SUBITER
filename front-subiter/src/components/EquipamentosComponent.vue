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
      :items="equipamento"
      :search="search"
    ></v-data-table>
  </v-card>
</template>


<script>
//import axios from 'axios'
export default {
  name: "EquipamentoView",
  props: {
    equipamento: Array,
  },
  // data() {
  //   return {
  //     search: "",
  //     headers: [
  //       {
  //         text: "Código",
  //         align: "start",
  //         sortable: false,
  //         value: "id",
  //       },
  //       { text: "Nome do Equipamento", value: "nome" },
  //       { text: "Número de série", value: "numeroDeSerie" },
  //       { text: "Descrição", value: "descricao" },
  //       { text: "Data de Fabricação", value: "dataFabricacao" },
  //       { text: "Data de Cadastro", value: "dataCadastro" },
  //       { text: "Status", value: "status" }, 
  //     ],

  //      desserts: [
  //       {
  //         name: "Frozen Yogurt",
  //         calories: 159,
  //         fat: 6.0,
  //         carbs: 24,
  //         protein: 4.0,
  //         iron: "1%",
  //       },
  //       {
  //         name: "Ice cream sandwich",
  //         calories: 237,
  //         fat: 9.0,
  //         carbs: 37,
  //         protein: 4.3,
  //         iron: "1%",
  //       },
  //       {
  //         name: "Eclair",
  //         calories: 262,
  //         fat: 16.0,
  //         carbs: 23,
  //         protein: 6.0,
  //         iron: "7%",
  //       },
  //       {
  //         name: "Cupcake",
  //         calories: 305,
  //         fat: 3.7,
  //         carbs: 67,
  //         protein: 4.3,
  //         iron: "8%",
  //       }
  //     }
  //   }
  }
    
</script>

<style scoped>
@import "@/sass/components/vuetify/table.css";
</style>