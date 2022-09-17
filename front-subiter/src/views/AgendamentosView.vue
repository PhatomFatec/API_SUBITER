<template>
    <div class="agendamentos">
        <div class="sub-menu">
            <SearchComponent ph="Pesquisar" />
            <CriarButtonComponent txt="CRIAR AGENDAMENTOS" @click.native="formAgendamento()" />
        </div>
        <FormAgendamento />
        <AgendamentosView :agendamentos="agendamentos" />
    </div>
</template>
  
<script>
import SearchComponent from '@/components/SearchComponent.vue';
import CriarButtonComponent from '@/components/CriarButtonComponent.vue';
import AgendamentosView from "@/components/AgendamentosComponent.vue";
import axios from 'axios';
import FormAgendamento from '@/components/forms/FormAgendamento.vue';

export default {
    name: 'AgendamentosComponents',
    components: {
        SearchComponent,
        CriarButtonComponent,
        AgendamentosView,
        FormAgendamento
    },
    data() {
        return {
            agendamentos: []
        }
    },
    methods: {
        formAgendamento() {
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
            .get("/schedule")
            .then((res) => {

                console.log(res.data);
                this.agendamentos = res.data;
            })
            .catch((error) => console.log(error));
    },
}
</script>
  