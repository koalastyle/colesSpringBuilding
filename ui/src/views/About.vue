<template>
  <div class="about">
    <h1>This is an about page</h1>
    <div class="test">
      Context: {{ context }}
    </div>
  </div>
</template>
<script>
import axios from "axios";

export default {
  name: "test",
  data() {
    return {context: "1"}
  },
  mounted() {
    setInterval(() => {
      get()
    }, 1000)
  }
}

function get() {
  axios.get("https://httpbin.org/ip")
      .then(function (response) {
            console.log(response)
          }
      )
      .catch(function (error) {
        console.log(error)
      })
}
</script>
