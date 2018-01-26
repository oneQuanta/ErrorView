package com.pomelo.errorview;

import android.app.Application;
import android.util.Log;

import com.pomelo.varyview.VaryViewUtil;


/**
 * Created by Administrator on 2017/8/28.
 */

public class app extends Application {

    private String TAG = "application";

    @Override
    public void onCreate() {
        super.onCreate();
        Log.d(TAG, "onCreate: 执行了");

//        /**
//         * 可以自定义 空界面 ， 错误界面 ，加载界面
//         */
        VaryViewUtil
                .ViewBuilder
                .Builder()
                .setEmptyViewId(R.layout.layout_emptyview)
                .setErrorViewId(R.layout.layout_errorview)
                .setLoadingViewId(R.layout.layout_loadingview);

    }
}
