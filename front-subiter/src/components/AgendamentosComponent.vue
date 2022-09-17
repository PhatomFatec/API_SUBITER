<template>
    <div class="content">
        <h2>Lista de acesso aos Agendamentos</h2>
        <table>
            <tr>
                <th>Código</th>
                <th>Nome</th>
                <th>E-mail</th>
                <th>Razão Social</th>
                <th>Telefone</th>
            </tr>
            <tr v-for="(agendamento, index) in agendamentos" v-bind:key="index">
                <td>{{agendamento.id}}</td>
            </tr>
        </table>
    </div>
</template>
  
  
<script>
//import axios from 'axios'
export default {
    name: 'AgendamentosView',
    props: { agendamentos: Array }
}
</script>