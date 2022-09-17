<template>
    <button>
        <!-- <svg viewBox="0 0 24 24" width="24" height="24" stroke="currentColor" stroke-width="2" fill="none"
            stroke-linecap="round" stroke-linejoin="round" class="css-i6dzq1">
            <line x1="12" y1="5" x2="12" y2="19"></line>
            <line x1="5" y1="12" x2="19" y2="12"></line>
        </svg> -->
        <p>{{txt}}</p>
    </button>
</template>
<script>
export default {
    name: 'CriarButtonComponent',
    props: {
        txt: String,
    }
}

</script>