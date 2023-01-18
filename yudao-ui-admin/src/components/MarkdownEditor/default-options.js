export default {
  previewStyle: 'vertical', // tab, vertical
  theme: 'dark',
  initialEditType: 'wysiwyg', // markdown, wysiwyg
  height: '500px', // 300px | auto
  //minHeight: '300px',
  language: 'en_US',
  useDefaultHTMLSanitizer: true,
  useCommandShortcut: true,
  usageStatistics: false,
  toolbarItems: [
    ['heading', 'bold', 'italic', 'strike'],
    ['hr', 'quote'],
    ['ul', 'ol', 'task', 'indent', 'outdent'],
    ['table', 'image', 'link'],
    ['code', 'codeblock']
  ],
  hideModeSwitch: false,
  customConvertor: null
}
