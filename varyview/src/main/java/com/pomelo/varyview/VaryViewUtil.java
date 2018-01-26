package com.pomelo.varyview;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;

import com.plmelo.varyview.R;

/**
 * Created by Administrator on 2017/5/12.
 */

public class VaryViewUtil {

    public interface VaryView {
        /**
         * 返回要替换得View
         */
        View getVaryView();

        /**
         * 重新刷新得方法
         */
        void reGetData();
    }

    public static class ViewBuilder {
        public static ViewBuilder builder;

        public static ViewBuilder Builder() {
            if (builder == null) {
                builder = new ViewBuilder();
            }
            return builder;
        }

        public ViewBuilder setLoadingViewId(int loadingViewId) {
            ViewBuilder.loadingViewId = loadingViewId;
            return builder;
        }

        public ViewBuilder setErrorViewId(int errorViewId) {
            ViewBuilder.errorViewId = errorViewId;
            return builder;
        }

        public ViewBuilder setEmptyViewId(int emptyViewId) {
            ViewBuilder.emptyViewId = emptyViewId;
            return builder;
        }

        public static int loadingViewId = 0;
        public static int errorViewId = 0;
        public static int emptyViewId = 0;

    }

    /**
     * 记得在Activity 的 onDestroy 中 销毁释放资源 调用 releaseVaryView();
     *
     * @param context
     * @param varyView
     * @return
     */
    public static VaryViewHelper newInstance(Context context, final VaryView varyView) {

        if (ViewBuilder.loadingViewId == 0) {
            VaryViewUtil
                    .ViewBuilder
                    .Builder()
                    .setLoadingViewId(R.layout.layout_loadingview);
        }

        if (ViewBuilder.emptyViewId == 0) {
            VaryViewUtil
                    .ViewBuilder
                    .Builder()
                    .setEmptyViewId(R.layout.layout_emptyview);
        }

        if (ViewBuilder.errorViewId == 0) {
            VaryViewUtil
                    .ViewBuilder
                    .Builder()
                    .setErrorViewId(R.layout.layout_errorview);
        }

        VaryViewHelper mVaryViewHelper = new VaryViewHelper.Builder()
                .setDataView(varyView.getVaryView())//放数据的父布局，逻辑处理在该Activity中处理
                .setLoadingView(LayoutInflater.from(context).inflate(ViewBuilder.loadingViewId, null))//加载页，无实际逻辑处理
                .setEmptyView(LayoutInflater.from(context).inflate(ViewBuilder.emptyViewId, null))//空页面，无实际逻辑处理
                .setErrorView(LayoutInflater.from(context).inflate(ViewBuilder.errorViewId, null))//错误页面，无实际逻辑处理
                .setRefreshListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        varyView.reGetData();
                    }
                })//错误页点击刷新实现
                .build();

        return mVaryViewHelper;
    }
}
