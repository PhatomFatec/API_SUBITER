<template>
  <div class="content">
    <h2>Lista de acesso aos Chamados</h2>
    <table>
      <tr>
        <th>Código</th>
        <th>Título do chamado</th>
        <th>Descrição</th>
        <th>Cliente</th>
        <!-- <th>Produto</th> -->
        <!-- <th>Criação</th> -->
        <!-- <th>Situação</th> -->
      </tr>
      <tr v-for="(chamado, index) in chamados" v-bind:key="index">
        <td>{{ chamado.id }}</td>
        <td>{{ chamado.titulo }}</td>
        <td>{{ chamado.descricao }}</td>
        <td>Lucas</td>
        <!-- <td>{{chamado.product.modelo}}</td> -->
        <!-- <td>{{chamado.dataChamado}}</td> -->
        <!-- <td>Pendente</td> -->
      </tr>
    </table>
  </div>
</template>


<script>
export default {
  name: "ChamadosView",
  props: { chamados: Array },
};
</script>