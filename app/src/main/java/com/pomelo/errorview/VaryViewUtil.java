package com.pomelo.errorview;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;

import com.plmelo.varyview.VaryViewHelper;

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

    /**
     * 记得在Activity 的 onDestroy 中 销毁释放资源 调用 releaseVaryView();
     * @param context
     * @param varyView
     * @return
     */
    public static VaryViewHelper newInstance(Context context, final VaryView varyView) {
        VaryViewHelper mVaryViewHelper = new VaryViewHelper.Builder()
                .setDataView(varyView.getVaryView())//放数据的父布局，逻辑处理在该Activity中处理
                .setLoadingView(LayoutInflater.from(context).inflate(R.layout.layout_loadingview, null))//加载页，无实际逻辑处理
                .setEmptyView(LayoutInflater.from(context).inflate(R.layout.layout_emptyview, null))//空页面，无实际逻辑处理
                .setErrorView(LayoutInflater.from(context).inflate(R.layout.layout_errorview, null))//错误页面
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
