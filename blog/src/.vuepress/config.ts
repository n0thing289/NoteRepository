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
  pagePatterns: ['**/*.md', '!.vuepress', '!node_modules'],//指定页面文件渲染 这些 Patterns 是相对于 Source 目录的
});
