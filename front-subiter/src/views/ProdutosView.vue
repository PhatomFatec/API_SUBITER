<template>
  <div class="produtos">
    <div class="sub-menu">
      <SearchComponent ph="Pesquisar" />
      <CriarButtonComponent txt="CRIAR PRODUTO" @click.native="formProduto()" />
    </div>
    <FormProduto />
    <ProdutosView  :p = "produtos"/>
  </div>
</template>

<script>
import SearchComponent from "@/components/SearchComponent.vue";
import CriarButtonComponent from "@/components/CriarButtonComponent.vue";
import FormProduto from "@/components/FormProduto.vue";
import ProdutosView from "@/components/ProdutosComponent.vue";
import axios from 'axios'

export default {
  name: "ProdutosComponents",
  components: {
    SearchComponent,
    CriarButtonComponent,
    FormProduto,
    ProdutosView,
  },
  data() {
    return {
      produtos: []
    }
  },
  methods: {
    formProduto() {
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
       .get("/users")
       .then((res) => {
        
         console.log(res.data);
       this.produtos = res.data;
    })
       .catch((error) => console.log(error));
   },
};
</script>
