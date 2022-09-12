<template>
    <div class="search">
        <svg viewBox="0 0 24 24" width="20" height="20" stroke="currentColor" stroke-width="2" fill="none"
            stroke-linecap="round" stroke-linejoin="round" class="css-1hy7qas">
            <circle cx="11" cy="11" r="8"></circle>
            <line x1="21" y1="21" x2="16.65" y2="16.65"></line>
        </svg>
        <input type="search" name="search" id="search" v-bind:placeholder="ph">
    </div>
</template>

<script>
export default {
    name: 'SearchComponent',
    props:{
        ph: String
    }
}
</script>