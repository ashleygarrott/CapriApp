<template>
    <div>
        <b-modal id="modal-1" title="BootstrapVue">
          <p class="my-4">Hello from modal!</p>
        </b-modal>
      </div>
</template>

<script>
export default {
    name: "OrderModeModal",
    mounted() {
        this.showModal('modal-1')
    },
    methods: {
      showModal(id) {
        this.$bvModal.show(id)
      },
      hideModal(id) {
        this.$bvModal.show(id)
      }
    }
}
</script>