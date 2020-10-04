package dev.raju.lib.changescene;

import android.content.Context;
import android.support.constraint.ConstraintLayout;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class ChangeSceneConstraintLayout extends ConstraintLayout {

    LayoutInflater mInflater;
    private View mContentScene;
    private View mProgressScene;
    private View mCustomScene;
    private View mCurrentScene;
    private TextView tvProgressMessage;

    public ChangeSceneConstraintLayout(Context context) {
        super(context);
        mInflater = LayoutInflater.from(context);
        init(context, null);
    }

    public ChangeSceneConstraintLayout(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        mInflater = LayoutInflater.from(context);
        init(context, attrs);
    }

    public ChangeSceneConstraintLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        mInflater = LayoutInflater.from(context);
        init(context, attrs);
    }

    private void init(Context context, AttributeSet attrs) {
        initAllScenes();
        mProgressScene.setVisibility(View.GONE);
        mCurrentScene = mContentScene;
    }

    private void initAllScenes() {
        mProgressScene = mInflater.inflate(R.layout.custom_scene_progress, this, false);
        tvProgressMessage = (TextView) mProgressScene.findViewById(R.id.progressTextScene);
        addView(mProgressScene);
    }

    public void changeScene(int sceneResId) {
        mCustomScene = mInflater.inflate(sceneResId, this, false);
        modifyScene(mCustomScene);
        addView(mCustomScene);
    }

    public void showContentScene() {
        modifyScene(mContentScene);
    }

    public void showProgressScene() {
        showProgressScene(null);
    }

    public void showProgressScene(String msg) {
        if (msg != null) tvProgressMessage.setText(msg);
        modifyScene(mProgressScene);
    }

    private void modifyScene(final View showScene) {
        final View hideScene = mCurrentScene;

        if (hideScene == showScene) return;
        if (hideScene != null) hideScene.setVisibility(GONE);

        if (showScene != null) {
            mCurrentScene = showScene;
            showScene.setVisibility(VISIBLE);
        }
    }

    @Override
    public void addView(View child) {
        doInitIfNoView(child);
        super.addView(child);
    }

    @Override
    public void addView(View child, int index) {
        doInitIfNoView(child);
        super.addView(child, index);
    }

    @Override
    public void addView(View child, int index, ViewGroup.LayoutParams params) {
        doInitIfNoView(child);
        super.addView(child, index, params);
    }

    @Override
    public void addView(View child, ViewGroup.LayoutParams params) {
        doInitIfNoView(child);
        super.addView(child, params);
    }

    @Override
    public void addView(View child, int width, int height) {
        doInitIfNoView(child);
        super.addView(child, width, height);
    }

    @Override
    protected boolean addViewInLayout(View child, int index, ViewGroup.LayoutParams params) {
        doInitIfNoView(child);
        return super.addViewInLayout(child, index, params);
    }

    @Override
    protected boolean addViewInLayout(View child, int index, ViewGroup.LayoutParams params, boolean preventRequestLayout) {
        doInitIfNoView(child);
        return super.addViewInLayout(child, index, params, preventRequestLayout);
    }

    private void doInitIfNoView(View child) {
        if (mContentScene == null && child != mProgressScene && child != mCustomScene) {
            mContentScene = child;
            mCurrentScene = mContentScene;
        }
    }
}
