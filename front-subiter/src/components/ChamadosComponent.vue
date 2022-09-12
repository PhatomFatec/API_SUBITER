<template>
  <div class="content">
    <h2>Lista de acesso aos Chamados</h2>
    <table>
      <tr>
        <th>Código</th>
        <th>Título</th>
        <th>Cliente</th>
        <th>Criação</th>
        <th>Status</th>
      </tr>
    </table>
  </div>
</template>


<script>
export default {
  name: 'ChamadosView',
  props: {
    msg: String
  }
}
</script>