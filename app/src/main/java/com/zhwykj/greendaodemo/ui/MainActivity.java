package com.zhwykj.greendaodemo.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.zhwykj.greendaodemo.R;

public class MainActivity extends AppCompatActivity {
    Button btnGreenDao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*GreenDao使用步骤
        * 1.添加依赖
        *   1.1.在root的build.gradle中add plugin
        *   1.2.在你的app projects的build.gradle中apply plugin和add library以及添加greendao
        *   1.3.如果开启混淆，需要在混淆文件中配置
        * 2.使用
        *   2.1.新建实体类，等同于创建数据表
        *   2.2.Build -> Make Project
        *   2.3.在Application中配置
        *   2.4.数据库增、删、改、查
        * 3.数据库加密
        *   在Application中配置
        * 4.更新数据库
        *   参考：https://juejin.im/post/595b4de55188250d87650643
        * 5.数据库迁移
        *   参考：http://glanwang.com/2017/08/17/Android/SQLite%E8%BF%81%E7%A7%BB%E5%88%B0GreenDao
        * 6.进阶
        *   参考：https://juejin.im/post/595a12ba6fb9a06b9a5175bd*/

        initView();

    }

    private void initView() {
        btnGreenDao = (Button) findViewById(R.id.btn_main_green_dao);
        btnGreenDao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, GreenDaoActivity.class);
                startActivity(intent);
            }
        });
    }
}
