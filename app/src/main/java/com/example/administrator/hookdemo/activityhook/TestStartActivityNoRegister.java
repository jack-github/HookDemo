package com.example.administrator.hookdemo.activityhook;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.example.administrator.hookdemo.App;
import com.example.administrator.hookdemo.R;
import com.example.administrator.hookdemo.hook.AMSHookUtil;
import com.example.administrator.hookdemo.hook.HookHelper;

public class TestStartActivityNoRegister extends AppCompatActivity {

    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(newBase);


    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_start_no_register);
    }

    public void onButtonClick(View v){
        switch (v.getId()){
            case R.id.btn_1:
                App.reset();
                try {
                    HookHelper.hookActivityManagerNative();
                    HookHelper.hookActivityThreadHandler();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                startActivity(new Intent(this,TargetActivity.class));
                break;
            case R.id.btn_2:
                App.reset();
                AMSHookUtil.hookStartActivity(this);
                startActivity(new Intent(this,TargetAppCompatActivity.class));
                break;
        }
    }
}