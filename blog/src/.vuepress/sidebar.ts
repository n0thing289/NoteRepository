import { sidebar } from "vuepress-theme-hope";

export default sidebar({
  "/": [
    // "",
    // {
    //   text: "如何使用",
    //   icon: "laptop-code",
    //   prefix: "demo/",
    //   link: "demo/",
    //   children: "structure",
    // },
    {
      text: "代码笔记",
      icon: "code",
      prefix: "posts/",
      link: "posts/",
      children: [
        { text: "前端", prefix: "前端/", children: "structure", collapsible: true },
        { text: "后端", prefix: "后端/", children: "structure", collapsible: true },
        { text: "VuePress迁移笔记", link: "vuepress笔记.md" },
        
      ],
    },
    "intro",
    {
      text: "幻灯片",
      icon: "person-chalkboard",
      link: "https://plugin-md-enhance.vuejs.press/zh/guide/content/revealjs/demo.html",
    },
    {
      text: "VuePress2官方文档",
      prefix: "vuepress2docs/",
      link: "vuepress2docs/",
      children: [
        { text: "指南", prefix: "guide/", children: "structure", collapsible: true },
      ],
    },
  ],
});
