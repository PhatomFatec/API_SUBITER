<template>
  <div class="content">
    <h2>Lista de acesso aos Produtos</h2>
    <table>
      <tr>
        <th>Código</th>
        <th>Título</th>
        <th>Cliente</th>
        <th>Criação</th>
      </tr>
      <tr>
        <td>{{produtos[0].numeroDeSerie}}</td>
        <td>{{produtos[0].descricao}}</td>
        <td>{{produtos[0].user.nome}}</td>
        <td>{{produtos[0].dataCadastro}}</td>
      </tr>
    </table>
  </div>
</template>


<script>
//import axios from 'axios'
export default {
  name: 'ProdutosView',
  props: { produtos:Array }
}
</script>