# ErrorView
错误的界面，成功界面，空界面


##	什么都不说，先亮效果图
<img src="image/succeed.png" width="320" height="480">
<img src="image/error.png" width="320" height="480">
<img src="image/empty.png" width="320" height="480">
<img src="image/loading.png" width="320" height="480">

##	使用方式

* 添加依赖
* 复制[VaryViewUtil](https://github.com/oneQuanta/ErrorView/blob/master/app/src/main/java/com/pomelo/errorview/VaryViewUtil.java)到项目中
* [可以在BaseActivity 中的onCreate 方法中创建 创建VaryViewHelper的对象并实现两个方法](https://github.com/oneQuanta/ErrorView/blob/master/app/src/main/java/com/pomelo/errorview/MainActivity.java) 记得释放资源
* 自定义UI,只要在VaryViewUtil里替换布局文件就好了