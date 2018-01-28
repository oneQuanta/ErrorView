package com.pomelo.varyview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;

import com.plmelo.varyview.R;
import com.pomelo.varyview.widget.ProgressWheel;

import java.io.IOException;
import java.net.HttpCookie;


/**
 * 功能：帮助切换错误，数据为空，正在加载的页面
 * 修改：
 */
public class VaryViewHelper {
    /**
     * 切换不同视图的帮助类
     */
    private OverlapViewHelper mViewHelper;
    /**
     * 错误页面
     */
    private View mErrorView;
    /**
     * 正在加载页面
     */
    private View mLoadingView;
    /**
     * 数据为空的页面
     */
    private View mEmptyView;
    /**
     * 正在加载页面的进度环
     */
    private ProgressWheel mLoadingProgress;

    private Context mContext;

    public VaryViewHelper(View view) {
        this(new OverlapViewHelper(view));
        mContext = view.getContext();
    }

    public VaryViewHelper(OverlapViewHelper helper) {
        this.mViewHelper = helper;
    }


    public void setUpEmptyView(View view) {
        mEmptyView = view;
        mEmptyView.setClickable(true);
    }

    public void setUpErrorView(View view, int mRefreshButtonId, View.OnClickListener listener) {
        mErrorView = view;
        mErrorView.setClickable(true);
        if (mRefreshButtonId != -1) {
            View btn = view.findViewById(mRefreshButtonId);
            if (btn != null) {
                btn.setOnClickListener(listener);
            }
        }
    }

    public void setUpLoadingView(View view) {
        mLoadingView = view;
        mLoadingView.setClickable(true);
        mLoadingProgress = (ProgressWheel) view.findViewById(R.id.vv_loading_progress);
    }

    public void showEmptyView() {
        mViewHelper.showCaseLayout(mEmptyView);
        stopProgressLoading();
    }

    public void showErrorView() {
        mViewHelper.showCaseLayout(mErrorView);
        stopProgressLoading();
    }

    public void showLoadingView() {
        mViewHelper.showCaseLayout(mLoadingView);
        startProgressLoading();
    }

    public void showDataView() {
        mViewHelper.restoreLayout();
        stopProgressLoading();
    }


    private void stopProgressLoading() {
        if (mLoadingProgress != null && mLoadingProgress.isSpinning()) {
            mLoadingProgress.stopSpinning();
        }
    }

    private void startProgressLoading() {
        if (mLoadingProgress != null && !mLoadingProgress.isSpinning()) {
            mLoadingProgress.spin();
        }
    }

    public void releaseVaryView() {
        mViewHelper = null;
    }


    public static class Builder {
        public static Builder builder;

        public static Builder getInstantiate() {
            if (builder == null) {
                builder = new Builder();
            }
            return builder;
        }

        private int loadingViewId = R.layout.layout_loadingview; //默认的loading界面
        private int emptyViewId = R.layout.layout_emptyview;//默认的empty界面
        private int errorViewId = R.layout.layout_errorview;//默认的error界面
        private int mRefreshButtonId = R.id.vv_error_refresh;//默认的refresh按钮
        private View mErrorView;

        private View mLoadingView;
        private View mEmptyView;

        public Builder setLoadingViewId(int loadingViewId) {
            this.loadingViewId = loadingViewId;
            return this;
        }

        public Builder setEmptyViewId(int emptyViewId) {
            this.emptyViewId = emptyViewId;
            return this;
        }

        public Builder setErrorViewId(int errorViewId,int mRefreshButtonId) {
            this.errorViewId = errorViewId;
            this.mRefreshButtonId = mRefreshButtonId;
            return this;
        }

        public VaryViewHelper build(final VaryViewCallBack callBack) {

            VaryViewHelper helper = new VaryViewHelper(callBack.getVaryView());

            if (mEmptyView == null) {
                mEmptyView = LayoutInflater.from(helper.mContext).inflate(emptyViewId, null);
            }

            if (mErrorView == null) {
                mErrorView = LayoutInflater.from(helper.mContext).inflate(errorViewId, null);
            }

            if (mLoadingView == null) {
                mLoadingView = LayoutInflater.from(helper.mContext).inflate(loadingViewId, null);
            }

            helper.setUpLoadingView(mLoadingView);
            helper.setUpEmptyView(mEmptyView);
            helper.setUpErrorView(mErrorView, mRefreshButtonId, new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    callBack.reGetData();
                }
            });
            return helper;
        }
    }

    public interface VaryViewCallBack {
        /**
         * 返回要替换得View
         */
        View getVaryView();

        /**
         * 重新刷新得方法
         */
        void reGetData();
    }

}
