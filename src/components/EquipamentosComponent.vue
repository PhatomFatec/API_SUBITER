<template>
  <v-card>
    <v-card-title>
      Lista de acesso aos chamados
      <v-spacer></v-spacer>
      <v-text-field v-model="search" append-icon="mdi-magnify" label="Pesquisar" single-line hide-details>
      </v-text-field>
    </v-card-title>
    <v-data-table :headers="headers" :items="equipamento" :search="search"></v-data-table>
  </v-card>
</template>


<script>
export default {
  name: "EquipamentoView",
  props: {
    equipamento: Array,
  },
}

</script>

<style scoped>
@import "@/sass/components/vuetify/table.css";
</style>