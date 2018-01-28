# ErrorView
错误的界面，成功界面，空界面，加载页面


##	什么都不说，先亮效果图
<img src="image/succeed.png" width="320" height="480">	<img src="image/error.png" width="320" height="480">

<img src="image/empty.png" width="320" height="480">	<img src="image/loading.png" width="320" height="480">


##	使用方式
* 添加依赖 compile 'com.github.oneQuanta:ErrorView:V1.3'
* 添加仓库 maven { url 'https://jitpack.io' }
* [可以在BaseActivity 中的onCreate 方法中创建 创建VaryViewHelper的对象并实现两个方法](https://github.com/oneQuanta/ErrorView/blob/master/app/src/main/java/com/pomelo/errorview/BaseActivity.java)  记得释放资源
* 自定义UI 只需在[app](https://github.com/oneQuanta/ErrorView/blob/master/app/src/main/java/com/pomelo/errorview/app.java)中添加
			
                VaryViewHelper
                        .Builder
                        .getInstantiate()
                        .setEmptyViewId(R.layout.layout_emptyview)
                        .setLoadingViewId(R.layout.layout_loadingview)
                        .setErrorViewId(R.layout.layout_errorview, R.id.vv_error_refresh);

