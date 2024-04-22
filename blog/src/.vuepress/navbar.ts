import { navbar } from "vuepress-theme-hope";

export default navbar([
  "/",
  // "/demo/",
  // "/posts/",
  {
    text: "代码笔记",
    icon: "pen-to-square",
    link: "/posts/",
  },
  {
    text: "V2 文档",
    icon: "book",
    link: "https://theme-hope.vuejs.press/zh/",
  },
]);
