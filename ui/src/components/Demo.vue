<template>
  <div id="counter">
    counter: {{ counter }}
  </div>
</template>

<script>
export default {
  name: "Demo",
  props: {
    // counter: Number
  },
  mounted() {
    setInterval(() => {
      this.counter++
    }, 1000)
  },
  data() {
    return {
      counter: 0
    }
  }
}
</script>

<style scoped>

</style>
