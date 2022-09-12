<template>
  <div class="produtos">
    <div class="sub-menu">
      <SearchComponent ph="Pesquisar" />
      <CriarButtonComponent txt="CRIAR PRODUTO" @click.native="formProduto()" />
    </div>
  </div>
</template>

<script>
import SearchComponent from '@/components/SearchComponent.vue';
import CriarButtonComponent from '@/components/CriarButtonComponent.vue';


export default {
  name: 'ProdutosComponents',
  components: {
    SearchComponent,
    CriarButtonComponent,
  },
  methods: {
    formProduto() {
      alert("produto")
    }
  }
}
</script>
