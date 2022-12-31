<template>
  <div class="app-container">
    <markdown-editor ref="markdownEditor" v-model="content"  height="500px" />

  </div>
</template>

<script>
import MarkdownEditor from '@/components/MarkdownEditor'
export default {
  name: "ApiAccessLog",
  components: {
    MarkdownEditor
  },
  data() {
    return {
      content: 'test'
    };
  },
  created() {
  },
  methods: {

  }
};
</script>
