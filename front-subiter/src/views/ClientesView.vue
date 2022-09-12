<template>
    <div class="clientes">
        <div class="sub-menu">
            <SearchComponent ph="Pesquisar" />
            <CriarButtonComponent txt="CRIAR CLIENTE" @click.native="formCliente()" />
        </div>
    </div>
</template>
  
<script>
import SearchComponent from '@/components/SearchComponent.vue';
import CriarButtonComponent from '@/components/CriarButtonComponent.vue';


export default {
    name: 'ClientesComponents',
    components: {
        SearchComponent,
        CriarButtonComponent,
    },
    methods: {
        formCliente() {
            alert("cliente")
        }
    }
}
</script>
  