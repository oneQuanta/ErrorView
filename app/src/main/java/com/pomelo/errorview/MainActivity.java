package com.pomelo.errorview;

import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

public class MainActivity extends BaseActivity implements View.OnClickListener {

    private Button btEmpty, btSucceed, btError, btLoading;
    private LinearLayout varyView;


    @Override
    protected void initData() {

    }

    @Override
    protected void initView() {
        setContentView(R.layout.activity_main);
        btEmpty = (Button) findViewById(R.id.bt_empty);
        btSucceed = (Button) findViewById(R.id.bt_succeed);
        btError = (Button) findViewById(R.id.bt_error);
        btLoading = (Button) findViewById(R.id.bt_loading);
        varyView = (LinearLayout) findViewById(R.id.ll_vary);

        btEmpty.setOnClickListener(this);
        btSucceed.setOnClickListener(this);
        btError.setOnClickListener(this);
        btLoading.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.bt_empty:
                //显示空的界面
                varyViewHelper.showEmptyView();
                break;
            case R.id.bt_succeed:
                //显示成功的界面
                varyViewHelper.showDataView();
                break;
            case R.id.bt_error:
                //显示错误的界面
                varyViewHelper.showErrorView();
                break;
            case R.id.bt_loading:
                //显示加载的界面
                varyViewHelper.showLoadingView();
                break;
        }
    }


    /**
     * @return 网络状态变化的View
     */
    @Override
    public View getVaryView() {
        //要替换的界面
        return varyView;
    }

    /**
     * 点击错误界面时调用的方法
     */
    @Override
    public void reGetData() {
        //TODO 调用刷新界面的接口
        Toast.makeText(this, "重新拉数据", Toast.LENGTH_SHORT).show();
    }
}
