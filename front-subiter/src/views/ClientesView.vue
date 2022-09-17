<template>
    <div class="clientes">
        <div class="sub-menu">
            <SearchComponent ph="Pesquisar" />
            <CriarButtonComponent txt="CRIAR CLIENTE" @click.native="formCliente()" />
        </div>
        <FormCliente />
        <ClientesView :clientes="clientes" />
    </div>
</template>
  
<script>
import SearchComponent from '@/components/SearchComponent.vue';
import CriarButtonComponent from '@/components/CriarButtonComponent.vue';
import ClientesView from "@/components/ClientesComponent.vue";
import FormCliente from '@/components/forms/FormCliente.vue';
import axios from 'axios'

export default {
    name: 'ClientesComponents',
    components: {
        SearchComponent,
        CriarButtonComponent,
        ClientesView,
        FormCliente,
    },
    data() {
        return {
            clientes: []
        }
    },
    methods: {
        formCliente() {
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
                this.clientes = res.data;
            })
            .catch((error) => console.log(error));
    },
}
</script>
  