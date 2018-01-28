package com.pomelo.errorview;

import android.app.Application;
import android.util.Log;

import com.pomelo.varyview.VaryViewHelper;


/**
 * Created by pomelo on 2017/8/28.
 */

public class App extends Application {

    private String TAG = "application";

    @Override
    public void onCreate() {
        super.onCreate();
        Log.e(TAG, "onCreate: 执行了");

        /**
         * 可以自定义 空界面,错误界面,加载界面
         */
        VaryViewHelper
                .Builder
                .getInstantiate()
                .setEmptyViewId(R.layout.layout_emptyview)
                .setLoadingViewId(R.layout.layout_loadingview)
                .setErrorViewId(R.layout.layout_errorview, R.id.vv_error_refresh);

    }
}
