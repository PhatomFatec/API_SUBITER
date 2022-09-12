<template>
    <div class="agendamentos">
        <div class="sub-menu">
            <SearchComponent ph="Pesquisar" />
            <CriarButtonComponent txt="CRIAR AGENDAMENTOS" @click.native="formAgendamento()" />
        </div>
    </div>
</template>
  
<script>
import SearchComponent from '@/components/SearchComponent.vue';
import CriarButtonComponent from '@/components/CriarButtonComponent.vue';


export default {
    name: 'AgendamentosComponents',
    components: {
        SearchComponent,
        CriarButtonComponent,
    },
    methods: {
        formAgendamento() {
            alert("agendamento")
        }
    }
}
</script>
  