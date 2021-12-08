<template>
  <div class="about">
    <h1>This is an about page</h1>
    <p>Context: {{ ip }}</p>
    <button v-on:click="click">show ip</button>
  </div>
</template>
<script>
import axios from "axios";

export default {
  data() {
    return {ip: "0.0.0.0"}
  },
  methods: {
    click() {
      axios.get("https://httpbin.org/ip")
          .then(res => {
            this.ip = res.data.origin
          })
          .catch(err => {
            console.log(err)
            this.ip = "error"
          })
    }
  }
}

</script>
