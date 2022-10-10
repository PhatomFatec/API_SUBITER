<template>
  <div class="produtos">
    <div class="sub-menu"></div>
    <FormProduto @change="load"/>
    <ProdutosView :produtos="produtos" />
  </div>
</template>

<script>
import FormProduto from "@/components/forms/FormProduto.vue";
import ProdutosView from "@/components/ProdutosComponent.vue";
import axios from "axios";

export default {
  name: "ProdutosComponents",
  components: {
    FormProduto,
    ProdutosView,
  },
  data() {
    return {
      produtos: [],
    };
  },
  methods: {
    formProduto() {
      var form = document.getElementById("modal");
      form.style.display = "flex";
    },
    closeModal() {
      var form = document.getElementById("modal");
      form.style.display = "flex";
    },
    load() {
      axios
        .get("/products")
        .then((res) => {
          console.log(res.data);
          this.chamados = res.data;
        })
        .catch((error) => console.log(error));
    },
  },
  created() {
    this.load()
    setTimeout(function () {
      var fatherElement =
        document.getElementsByClassName("v-input__control")[0];
      var searchElement = fatherElement.children[0];
      var searchSVG =
        "<svg viewBox='0 0 24 24' width='20' height='20' stroke='currentColor' stroke-width='2' fill='none' stroke-linecap='round' stroke-linejoin='round' class='css-1hy7qas'><circle cx='11' cy='11' r='8'></circle><line x1='21' y1='21' x2='16.65' y2='16.65'></line></svg>";
      var areaSearch = document.getElementsByClassName("v-card__title")[0];
      searchElement.insertAdjacentHTML("beforebegin", searchSVG);
      areaSearch.children[0].insertAdjacentHTML(
        "beforebegin",
        `<button class='creationButton' onclick="var modal = document.getElementById('modal');modal.style.display = 'flex';modal.style.zIndex = '10';">CRIAR PRODUTO<button>`
      );
    }, 1);
  },
};
</script>
