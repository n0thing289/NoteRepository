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
      prefix: "codeNotes/",
      link: "codeNotes/",
      children: [
        { text: "前端", prefix: "前端/", children: "structure", collapsible: true },
        { text: "后端", prefix: "后端/", children: "structure", collapsible: true },
        {
          text: "项目笔记", prefix: "项目/", children: [
            { text: "苍穹外卖", prefix: "苍穹外卖/", children: "structure", collapsible: true },
            { text: "动力云客", prefix: "动力云客/", children: "structure", collapsible: true },
          ], collapsible: true
        },
        { text: "VuePress迁移笔记", link: "vuepress笔记.md" },
      ],
    },
    {
      text: "读书笔记",
      icon: "book",
      prefix: "readingNotes/",
      link: "readingNotes/",
      children: "structure",
    },
    // {
    //   text: "go",
    //   icon: "book",
    //   prefix: "插本/",
    //   link: "插本/",
    //   children: "structure",
    // },
    "intro",
  ],
});
