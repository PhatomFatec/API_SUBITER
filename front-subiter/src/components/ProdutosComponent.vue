<template>
  <div class="content">
    <h2>Lista de acesso aos Produtos</h2>
    <table>
      <tr>
        <th>Código</th>
        <th>Produto</th>
        <th>Núm. de Série</th>
        <th>Descrição</th>
        <th>Data de Fabricação</th>
      </tr>
      <tr v-for="(produto, index) in produtos" v-bind:key="index">
        <td>{{produto.id}}</td>
        <td>{{produto.modelo}}</td>
        <td>{{produto.numeroDeSerie}}</td>
        <td>{{produto.descricao}}</td>
        <!-- <td>{{produto.dataCadastro}}</td> -->
        <td>{{produto.dataFabricacao}}</td>
      </tr>
    </table>
  </div>
</template>


<script>
//import axios from 'axios'
export default {
  name: 'ProdutosView',
  props: { produtos: Array }
}
</script>