---
title: Element-Plus笔记
tags: elementplus
categories: 前端
date: 2024-03-20
---



# element-plus

- 搭建环境

  1. 安装依赖

  ```sh
  yarn add element-plus
  yarn add @element-plus/icons-vue
  ```

  2. 导入到main.js(含图标库)

  ```js
  import ElementPlus from 'element-plus'
  import 'element-plus/dist/index.css'
  import * as icons from '@element-plus/icons-vue'
  
  app.use(ElementPlus)
  for (const [key, component] of Object.entries(icons)) {
      app.component(key, component)
  }
  ```

  3. 可装插件

     Element UI Snippets

## 基本组件

### 布局容器el-container

```html
<el-container>//相当于一个div!
	可以放进来el-aside el-header el-main el-footer
    重点: el-aside是水平的, header main footer 都是垂直的
</el-container>
```



### 导航条el-menu（template #title插槽）

```html
//1.router属性：开启路由模式，index属性相当于router-link里的to属性，写路由路径
//2.mode属性：菜单的排布方式
//3.菜单(不管一级多级)里使用el-menu-item包裹
//4.二级菜单使用el-sub-menu包裹（三级四级以此类推）
//5.二级菜单开始，标题需要使用<template #title>标题</template>标签
<el-menu mode="horizontal" :router="true">
    <el-menu-item>
    <img style="width: 100px" src="../assets/element-plus-logo.svg" alt="">
	</el-menu-item>
	
	<el-menu-item index="/">主页面</el-menu-item>
	
    <el-sub-menu>
        <template #title>Workspace</template>
        <el-menu-item index="/container">布局容器</el-menu-item>
        <el-menu-item index="/form">表单</el-menu-item>
        <el-menu-item index="/table">表格</el-menu-item>
    </el-sub-menu>
</el-menu>
```

小细节：

router属性最好写成:router

每一个菜单标签都写index, 可以随便写





### 表单el-form (label和placeholder)

- el-input

  ```html
  <el-input 
            v-model="form.name" 
            placeholder="请输入您的姓名" 
            type="textarea"/>
  ```

- el-select

  ```html
  <el-select v-model="form.sex" placeholder="请选择您的性别">
      <el-option label="男" value="0" />
      <el-option label="女" value="1" />
  </el-select>
  ```

- el-date-picker

  ```html
  <el-date-picker 
                  v-model="form.birth" 
                  type="date" 
                  placeholder="选择出生日期"/>
  ```

- el-switch

  ```html
  <el-switch 
             v-model="form.single" 
             :active-value="true" 
             :inactive-value="false"
             active-text="是"
             inactive-text="否"/>
  ```

- el-radio

  ```html
   <el-radio 
             v-model="form.receiveOrtherLand" 
             label="接受" 
             value="true"/>
              
  <el-radio 
            v-model="form.receiveOrtherLand" 
            label="不接受" 
            value="false"/>
  ```

- el-button

  ```html
  <el-button 
  		   type="primary" 
             size="default" 
             @click="onsubmit()">提交</el-button>
  ```

- el-checkbox

  ```html
  <el-checkbox-group v-model="form.interest">
      <el-checkbox label="抽烟" value="抽烟" />
      <el-checkbox label="喝酒" value="喝酒" />
      <el-checkbox label="吃肥肉" value="吃肥肉" />
      <el-checkbox label="看美女" value="看美女" />
  </el-checkbox-group>
  ```

el-form

```html
<el-form ref="form" :model="addUserform" :rules="rules" label-position="right">
1.表单组件需要<el-form-item></el-form-item>包裹
2.表单组件有 el-input el-select el-date-picker
3.lebal属性: elfi|radio|checkbox|option上使用, 渲染为当前表单组件最左边的文字
4.placeholder属性: input|select|textarea使用, 渲染默认文本
```

- 表单验证规则，elform 绑定rules elfi写上prop，在data里编写rules规则

### 表格el-table

```html
//1.el-table的data属性, 绑一个数组
//2.表格里每一列使用el-table-column,props绑数组中元素对象的属性
//3.el-table-column的label是表头的标记
//4.row-key属性必须填, 和v-for的key是一个东西
<el-table :data="forms" :row-key="col=>col.id">
    <el-table-column type="index" label="序号"/>
    <el-table-column prop="name" label="姓名" />
    <el-table-column prop="sex" label="性别" />
    <el-table-column prop="age" label="年龄" />
    <el-table-column prop="birth" label="生日" />
    <el-table-column prop="isSingle" label="是否单身" />
    <el-table-column prop="interest" label="兴趣爱好" />
    <el-table-column prop="receiveOrtherLand" label="接受异地" />
    <el-table-column prop="desc" label="个人简介" />
    <el-table-column label="操作"/>
</el-table>
//1.el-table-column自动递增序号type="index"
```

小细节:

align属性可以设置对齐方式

### 对话框el-dialog

```html
//1.el-dialog的v-model: 控制显示
//2.el-dialog的title: 对话框的标题
//3.el-dialog划分三个区域标题, body, footer
<el-dialog v-model="dialogVisible" title="111" center>
    //body
    
    //脚注固定写法
    <template #footer>
        <div>
            <el-button @click="dialogVisible1 = false">Cancel</el-button>
            <el-button type="primary" @click="dialogVisible1 = false">
                Confirm
            </el-button>
        </div>
    </template>
</el-dialog>
```





## 获取行内数据

```html
<template v-slot="scope">
    <el-button type="primary" @click="getUserById(scope.row)">详情</el-button>
    <el-button type="danger">删除</el-button>
</template>
```

## 表单验证规则

```vue
//1.
<template>
<el-form :rules="rules" ref="form"></el-form>
<el-form-item prop="propName"></el-form-item>
</template>
<script>
    //2.
    data(){
	return {
		relus:{
			propName:[{required:true,message:'必填'}]
		}
	}
}
//3.验证事件
this.$refs.form.validate((validated)=>{
	if(validated){
		
	}
})
</script>
```



## 带复选框的表格

```html
//每次勾选复选框触发一个事件, 参数是勾选的对象的数组
<el-table @selection-change="handleSelectionChange(val)"></el-table>
//复选框出现
<el-table-column type="selection" width="55" />
```



## 文件上传

```js
this.$refs.uploadRef.submit()
会调用http-request="(param)=>{}"的函数
```





## 模糊查询-前端
