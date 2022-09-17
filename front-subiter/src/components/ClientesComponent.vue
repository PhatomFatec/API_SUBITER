<template>
    <div class="content">
        <h2>Lista de acesso aos Clientes</h2>
        <table>
            <tr>
                <th>Código</th>
                <th>Nome</th>
                <th>E-mail</th>
                <th>Razão Social</th>
                <th>Telefone</th>
            </tr>
            <tr v-for="(cliente, index) in clientes" v-bind:key="index">
                <td>{{cliente.id}}</td>
                <td>{{cliente.nome}}</td>
                <td>{{cliente.email}}</td>
                <td>{{cliente.razaoSocial}}</td>
                <td>{{cliente.telefone}}</td>
            </tr>
        </table>
    </div>
</template>
  
  
<script>
//import axios from 'axios'
export default {
    name: 'ClientesView',
    props: { clientes: Array }
}
</script>