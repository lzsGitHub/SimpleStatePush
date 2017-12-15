# SimpleStatePush
>>怎么编写`README` http://blog.csdn.net/kaitiren/article/details/38513715

for app state bar push
实现状态栏推送的最基本效果
===
* 利用`Notification`

图片上传格式：`https://github.com/用户名/项目名/raw/分支/图片`
===

![gif](https://github.com/lzsGitHub/SimpleStatePush/raw/master/three215.jpg "嘿嘿")


```
<RelativeLayout xmlns:android="http://schemas.android.com/apk/res/android"
                android:layout_width="match_parent"
                android:layout_height="match_parent"
                >

    <ImageView
        android:id="@+id/largeIcon"
        android:layout_width="64dp"
        android:layout_height="64dp"
        android:src="@mipmap/ic_launcher"
        android:contentDescription="largeIcon" />

    <TextView
        android:id="@+id/contentTitle"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_toRightOf="@+id/largeIcon"
        android:layout_marginLeft="10dp"
        android:layout_marginTop="5dp"
        android:text="系统更新"/>

    <TextView
        android:id="@+id/contentText"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_alignLeft="@+id/contentTitle"
        android:layout_below="@+id/contentTitle"
        android:layout_marginTop="5dp"
        android:text="发现系统更新，点击查看详情"
        android:textSize="12sp"/>

    <TextView
        android:id="@+id/when"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_alignParentRight="true"
        android:layout_marginRight="5dp"
        android:text="11:00"/>

    <ImageView
        android:id="@+id/smallIcon"
        android:layout_width="15dp"
        android:layout_height="15dp"
        android:layout_alignRight="@+id/when"
        android:layout_alignTop="@+id/contentText"
        android:src="@mipmap/ic_launcher" />

    <TextView
        android:id="@+id/contentInfo"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_alignTop="@+id/smallIcon"
        android:layout_toLeftOf="@+id/smallIcon"
        android:text="信息"
        android:textSize="12sp" />

</RelativeLayout>
```
