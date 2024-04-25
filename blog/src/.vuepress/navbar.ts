import { navbar } from "vuepress-theme-hope";
/**
 * 和vue路由写法差不多，
 *  普通路由/xx 子路由/不写
 *  只写结尾的/， 而不写成/README.md是合法sheng
 */
export default navbar([
  "/",
  // "/demo/",
  // "/posts/",
  {
    text: "代码笔记",
    icon: "code",
    link: "/posts/",
  },
  {
    text: "VuePress文档",
    icon: "https://v2.vuepress.vuejs.org/images/icons/favicon-32x32.png",
    link: "https://v2.vuepress.vuejs.org/zh/guide/introduction.html",
  },
  {
    text: "VuePressThemeHope文档",
    icon: "https://theme-hope.vuejs.press/favicon.ico",
    link: "https://theme-hope.vuejs.press/zh/guide/",
  },
]);
