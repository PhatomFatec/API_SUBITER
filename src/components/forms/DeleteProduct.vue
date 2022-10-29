<template>
  <div class="modal" id="delete">
    <div class="box">
      <svg v-on:click="closeDelete()" viewBox="0 0 24 24" width="24" height="24" stroke="currentColor" stroke-width="2"
        fill="none" stroke-linecap="round" stroke-linejoin="round" class="css-i6dzq1">
        <line x1="18" y1="6" x2="6" y2="18"></line>
        <line x1="6" y1="6" x2="18" y2="18"></line>
      </svg>
      <h3>Deletar Produto</h3>
      <fieldset>
        <legend>Código do Produto</legend>
        <input type="number" placeholder="" id="codProduct" />
      </fieldset>
      <div class="buttons">
        <button id="cancelar" v-on:click="closeDelete()">Cancelar</button>
        <button id="criar" v-on:click="deleteProduct()">Delete</button>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  name: "DeleteProduct",
  methods: {
    closeDelete() {
      var delet = document.getElementById("delete");
      var inputs = delet.querySelectorAll("input, textarea");
      delet.style.display = "none";
      inputs.forEach((input) => {
        input.value = "";
      });
    },
    deleteProduct() {
      //
      var myHeaders = new Headers();
      var codProduct = document.getElementById("codProduct").value; //
      var token = localStorage.getItem("SavedToken");
      myHeaders.append("Content-Type", "application/json");
      myHeaders.append("Authorization", `${token}`);

      var requestOptions = {
        method: "DELETE",
        headers: myHeaders,
        redirect: "follow",
      };

      fetch(
        `https://subiter.azurewebsites.net/products/${codProduct}`, //
        requestOptions
      )
        .then((response) => response.text())
        .then((result) => console.log(result))
        .catch((error) => console.log("error", error));
    },
  },
};
</script>