#开源的RippleLayout，点击产生波浪涟漪效果
有些app点击ListView的条目或按钮或页面会有波浪的涟漪效果，本文使用一个自定义View实现这个效果，这个自定义View是继承了FrameLayout，里面只能放一个布局或控件，否则会报错！
效果：
![1](http://i.imgur.com/UAS5lQx.gif)
虽然谷歌也有了点击产生涟漪效果的API和资源文件，但是需要最低5.0的SDK等级（21）才能使用，注意是最低，不是正在编译的版本的等级。反正Eclipse中是不能识别这个资源了，Studio就不知道了。
网上也有很多这个开源的View的设计，有的是直接继承View，有的是继承Relativelayout，但是，有些是存在问题的，比如，我之前试过一个它会阻断了ListView的Item点击回调的监听！
这个开源的RippleLayout使用起来也是非常简单的，可以直接把它当作一个FrameLayout使用，就会有点击后产生波浪涟漪效果了，当然也是可以设置一些属性。
#使用：
导入一个自定义View的类RippleLayout，代码太多，就不贴出来了
添加attrs的自定义属性

##使用示例1，什么都不设置：
```
<?xml version="1.0" encoding="utf-8"?>
  <!--注意是自定义View的导入-->
<com.example.ripples.RippleLayout
        xmlns:android="http://schemas.android.com/apk/res/android"
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        >
    <RelativeLayout xmlns:android="http://schemas.android.com/apk/res/android"
                    android:layout_width="match_parent"
                    android:layout_height="50dp">
        <TextView
                android:layout_width="wrap_content"
                android:layout_height="wrap_content"
                android:id="@+id/text"
                android:layout_centerInParent="true"
                />
        <ImageView
                android:layout_width="wrap_content"
                android:layout_height="wrap_content"
                android:src="@drawable/ic_launcher"
                />
    </RelativeLayout>
</com.example.ripples.RippleLayout>
```

##使用示例2，设置一些属性：
```
<?xml version="1.0" encoding="utf-8"?>
   <com.example.ripples.RippleLayout
			xmlns:android="http://schemas.android.com/apk/res/android"
            xmlns:app="http://schemas.android.com/apk/res-auto"
            android:layout_width="match_parent"
            android:layout_height="60dp"

            app:mrl_rippleColor="#ffffff00"  //设置波浪涟漪的颜色
            app:mrl_rippleDimension="10dp"   //涟漪刚开始产生的范围大小，。。dp
            app:mrl_rippleOverlay="true"	//涟漪产生的波纹是否会覆盖，默认false
            app:mrl_rippleAlpha="0.5"		//涟漪产生的波纹的透明度，1表示完全显示，0就不显示，0.2就显示很浅的一点
            app:mrl_rippleDuration="2000"		//涟漪产生的时间长短，毫秒数
            app:mrl_rippleFadeDuration="1000"	//涟漪消失过程的时间长短，毫秒数
            app:mrl_rippleHover="true"			//涟漪是否盘旋显示，好像没啥效果
            app:mrl_rippleBackground="#ff00"	//背景颜色,和backgroud一样
            app:mrl_rippleDelayClick="true"		//是否延迟点击，没啥作用
            app:mrl_ripplePersistent="false"	//是否是显示涟漪后的效果，就是颜色变了一直保持那种颜色
            app:mrl_rippleRoundedCorners="1dp"	//涟漪图形的圆角大小，一般也不用

            >
        <TextView
                android:layout_width="match_parent"
                android:layout_height="40dp"
                android:gravity="center"
                android:textSize="25sp"
                android:clickable="true"
                android:onClick="clickText"
                android:layout_margin="10dp"
                android:text="页面底部的按钮"
                />
    </com.example.ripples.RippleLayout>

```
当然你也可以在RippleLayout类里面修改一些属性，让所有的点击效果都一样，就不用在多个自定义布局中设置属性了！