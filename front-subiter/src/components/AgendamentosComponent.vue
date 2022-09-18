<template>
    <div class="content">
        <h2>Lista de acesso aos Agendamentos</h2>
        <table>
            <tr>
                <th>Código</th>
                <th>Horario</th>
                <th>Endereço</th>
                <th>Cidade</th>
                <th>CEP</th>
                <th>Estado</th>
            </tr>
            <tr v-for="(agendamento, index) in agendamentos" v-bind:key="index">
                <td>{{agendamento.id}}</td>
                <td>{{agendamento.horario}}</td>
                <td>{{agendamento.endereco}}</td>
                <td>{{agendamento.cidade}}</td>
                <td>{{agendamento.cep}}</td>
                <td>{{agendamento.estado}}</td>
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