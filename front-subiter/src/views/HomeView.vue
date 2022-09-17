<template>
  <div class="home">
    <div class="sub-menu">
      <SearchComponent ph="Pesquisar" />
      <CriarButtonComponent txt="CRIAR CHAMADO" @click.native="formChamado()" />
    </div>
    <FormChamado />
    <ChamadosView :chamados="chamados" />
  </div>
</template>

<script>
import ChamadosView from '@/components/ChamadosComponent.vue';
import SearchComponent from '@/components/SearchComponent.vue';
import CriarButtonComponent from '@/components/CriarButtonComponent.vue';
import FormChamado from '@/components/forms/FormChamado.vue';
import axios from 'axios';

export default {
  name: 'HomeView',
  components: {
    ChamadosView,
    SearchComponent,
    CriarButtonComponent,
    FormChamado,
  },
  data() {
    return {
      chamados: []
    }
  },
  methods: {
    formChamado() {
      var form = document.getElementById("modal");
      form.style.display = "flex";
    },
    closeModal() {
      var form = document.getElementById("modal");
      form.style.display = "flex";
    },
  },
  created() {
    axios
      .get("/calleds")
      .then((res) => {

        console.log(res.data);
        this.chamados = res.data;
      })
      .catch((error) => console.log(error));
  },
}
</script>

<style>
@import '../sass/components/sub-menu.css'
</style>