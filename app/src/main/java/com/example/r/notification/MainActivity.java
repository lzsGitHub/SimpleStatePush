package com.example.r.notification;

import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.media.RingtoneManager;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RemoteViews;

public class MainActivity extends Activity {
    private Button mNoticeTestBt;
    private Context mContext;
    private Notification mNotification;
    private NotificationManager mNotificationManager;
    private PendingIntent mPendingIntent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mContext=this;
        mNoticeTestBt = (Button) findViewById(R.id.notice_test_bt);
        mNotificationManager= (NotificationManager) getSystemService(NOTIFICATION_SERVICE);

        /**
         * PendingIntent
         */
        Intent intent=new Intent(mContext,NoticeUpActivity.class);
        mPendingIntent=PendingIntent.getActivity(mContext,1,intent,
                Intent.FLAG_ACTIVITY_NEW_TASK);

        mNoticeTestBt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                RemoteViews remoteViews= new RemoteViews(getPackageName(),R.layout.notice_layout);
                remoteViews.setTextViewText(R.id.contentTitle,"消息审核");
                mNotification=new Notification.Builder(mContext)
                        .setSmallIcon(R.mipmap.ic_launcher)
                        // 设置状态栏文本标题
                        .setTicker("你的系统有更新")
                        .setContent(remoteViews)
                        .setContentTitle("什么")
                        .setContentText("消息内容")
                        .setContentIntent(mPendingIntent)
                        .setSound(RingtoneManager.getActualDefaultRingtoneUri(
                                getBaseContext(),RingtoneManager.TYPE_NOTIFICATION
                        )).setAutoCancel(true)
                        .build();
                       /*
                 * 当API level 低于14的时候使用setContent()方法是没有用的
                 * 需要对contentView字段直接赋值才能生效
                 */
                if (Build.VERSION.SDK_INT < 14) {
                    mNotification.contentView = remoteViews;
                }
                mNotificationManager.notify(0,mNotification);
            }
        });

    }
}
