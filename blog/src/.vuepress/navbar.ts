import { navbar } from "vuepress-theme-hope";

export default navbar([
  "/",
  "/demo/",
  // "/posts/",
  {
    text: "前端",
    icon: "pen-to-square",
    prefix: "/posts/",
    children: [
      { text: 'AJAX', link: "/前端/1-Ajax笔记/AJAX.md" }
    ],
  },
  {
    text: "V2 文档",
    icon: "book",
    link: "https://theme-hope.vuejs.press/zh/",
  },
]);
