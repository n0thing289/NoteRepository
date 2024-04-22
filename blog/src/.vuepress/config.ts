import { defineUserConfig } from "vuepress";
import theme from "./theme.js";
// import { hopeTheme } from "vuepress-theme-hope";

export default defineUserConfig({
  base: "/",

  lang: "zh-CN",
  title: "n0thing",
  description: "n0thing的博客",

  theme,

  // 和 PWA 一起启用
  // shouldPrefetch: false,

  //我添加的配置
  markdown: {
    headers: {
      level: [2, 3, 4, 5, 6, 7]
    }
  },
});
