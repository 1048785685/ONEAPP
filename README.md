# 仿ONE客户端的制作
## 运行截图
进入APP的第一个页面，通过百度定位获取当前的城市，并Toast提示
<br/>![](/First_Term/Liuyang/p.jpg)
进入之后的主页面
<br/>![](/First_Term/Liuyang/p.jpg)
第一个页面是Viewpager，这是侧滑之后的页面
<br/>![](/First_Term/Liuyang/p.jpg)
最后一个item是跳转到viewpager下一个fragment的按钮
<br/>![](/First_Term/Liuyang/p.jpg)
下面是点击搜索之后的界面
<br/>![](/First_Term/Liuyang/p.jpg)
这是侧滑的页面（PS:没有实现夜间模式）
<br/>![](/First_Term/Liuyang/p.jpg)
这是第一次点击，阅读，音乐，影视的网络加载的跳转页面
<br/>![](/First_Term/Liuyang/p.jpg)
这是根据定位来获取本地的天气预报的页面
<br/>![](/First_Term/Liuyang/p.jpg)
这两个是点击进去的页面
<br/>![](/First_Term/Liuyang/p.jpg)
<br/>![](/First_Term/Liuyang/p.jpg)



## 使用到的技术
*  GSON解析
*  Acache缓存
*  Okhttp3的网络框架
*  侧滑
*  自定义Toolbar
*  Fragment中嵌套Viewpager
*  动态加载Fragment
*  fragment与fragment,activity之间的跳转传值
*  百度地图的定位功能，通过定位获取当前城市的天气预报
*  recyclerview的多重布局，上拉加载，下拉刷新
*  Progerssdialog的使用
*  WebView控件的使用
*  Glide的使用
*  延迟任务


## 收获
* 学会了基础的百度地图定位功能，自定义Toolbar。
* 侧滑功能的熟练，Acache的使用，Gson的熟练，progressDialog的使用，webview的基本使用，Gilde的基本使用。
* 在进行网络请求的时候，在主方法中网络请求后面的代码会先执行，导致bug，数据为null。后来，发现是因为进行网络请求需要耗时，会导致网络请求后的代码先执行，之后设置了延时任务，解决了BUG。
* 动态加载fragment的时候，不像Activity一样直接进行intent的跳转，而是运用到show，hide，repalce方法去隐藏，显示，或者取代fragment。
* 以前从未写过recyclerView的多种布局，这次因为第一个页面的需要，所以就看着杜兰特学长recyclerViewDEMO的代码，学会并且将recyclerView的多种布局加入了进去。
* 写代码能力的提升，以及对上面的功能加深了自己的理解。
* 还有在说不出的，在写代码过程中的提升。 