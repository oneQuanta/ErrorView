package com.pomelo.errorview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.pomelo.varyview.VaryViewHelper;

/**
 * Created by Administrator on 2017/8/23.
 */

public abstract class BaseActivity extends AppCompatActivity implements VaryViewHelper.VaryViewCallBack{
    //varyViewHelper对象
    protected VaryViewHelper varyViewHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initView();
        //创建varyViewHelper对象
        varyViewHelper = VaryViewHelper.Builder.getInstantiate().build(this);
        initData();
    }

    protected abstract void initData();

    protected abstract void initView();

    @Override
    public abstract View getVaryView();

    @Override
    public abstract void reGetData();

    @Override
    protected void onDestroy() {
        super.onDestroy();
        //释放资源
        varyViewHelper.releaseVaryView();
    }
}
