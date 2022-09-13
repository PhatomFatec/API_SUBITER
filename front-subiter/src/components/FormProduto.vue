<template>
  <div class="modal" id="modal">
    <div class="box">
      <svg
        v-on:click="closeModal()"
        viewBox="0 0 24 24"
        width="24"
        height="24"
        stroke="currentColor"
        stroke-width="2"
        fill="none"
        stroke-linecap="round"
        stroke-linejoin="round"
        class="css-i6dzq1"
      >
        <line x1="18" y1="6" x2="6" y2="18"></line>
        <line x1="6" y1="6" x2="18" y2="18"></line>
      </svg>
      <h3>Cadastro de Produtos</h3>
      <fieldset>
        <legend>Modelo do produto</legend>
        <input type="text" placeholder="Exemplo: Embarcação" />
      </fieldset>
      <fieldset>
        <legend>Número de série</legend>
        <input type="text" placeholder="Exemplo: 11, 12, 13" />
      </fieldset>
      <fieldset>
        <legend>Descrição</legend>
        <textarea type="text" />
      </fieldset>
      <hr />
      <fieldset>
        <legend>Data de fabricação</legend>
        <input type="date" />
      </fieldset>
      <div class="buttons">
        <button id="cancelar" v-on:click="closeModal()">Cancelar</button>
        <button id="criar">Criar</button>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  name: "FormProduto",
  methods: {
    closeModal() {
      var modal = document.getElementById("modal");
      var inputs = modal.querySelectorAll("input, textarea")
      modal.style.display = "none";
      inputs.forEach((input) => {
        input.value = "";
      });
    },
  },
};
</script>
