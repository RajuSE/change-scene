package dev.raju.lib.changescene

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView

class ChangeSceneLinearLayout : LinearLayout {
    var mInflater: LayoutInflater
    private var mContentScene: View? = null
    private var mProgressScene: View? = null
    private var mCustomScene: View? = null
    private var mCurrentScene: View? = null
    private var tvProgressMessage: TextView? = null

    constructor(context: Context) : super(context) {
        mInflater = LayoutInflater.from(context)
        init(context, null)
    }

    constructor(context: Context, attrs: AttributeSet?, defStyle: Int) : super(context, attrs, defStyle) {
        mInflater = LayoutInflater.from(context)
        init(context, attrs)
    }

    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs) {
        mInflater = LayoutInflater.from(context)
        init(context, attrs)
    }

    private fun init(context: Context, attrs: AttributeSet?) {
        initAllScenes()
        mProgressScene!!.visibility = View.GONE
        mCurrentScene = mContentScene
    }

    private fun initAllScenes() {
        mProgressScene = mInflater.inflate(R.layout.custom_scene_progress, this, false)
        tvProgressMessage = mProgressScene!!.findViewById(R.id.progressTextScene) as TextView
        addView(mProgressScene!!)
    }

    fun changeScene(sceneResId: Int) {
        mCustomScene = mInflater.inflate(sceneResId, this, false)
        modifyScene(mCustomScene)
        addView(mCustomScene!!)
    }

    fun showContentScene() {
        modifyScene(mContentScene)
    }

    @JvmOverloads
    fun showProgressScene(msg: String? = null) {
        if (msg != null) tvProgressMessage!!.text = msg
        modifyScene(mProgressScene)
    }

    private fun modifyScene(showScene: View?) {
        val hideScene = mCurrentScene
        if (hideScene === showScene) return
        if (hideScene != null) hideScene.visibility = View.GONE
        if (showScene != null) {
            mCurrentScene = showScene
            showScene.visibility = View.VISIBLE
        }
    }

    override fun addView(child: View) {
        doInitIfNoView(child)
        super.addView(child)
    }

    override fun addView(child: View, index: Int) {
        doInitIfNoView(child)
        super.addView(child, index)
    }

    override fun addView(child: View, index: Int, params: ViewGroup.LayoutParams) {
        doInitIfNoView(child)
        super.addView(child, index, params)
    }

    override fun addView(child: View, params: ViewGroup.LayoutParams) {
        doInitIfNoView(child)
        super.addView(child, params)
    }

    override fun addView(child: View, width: Int, height: Int) {
        doInitIfNoView(child)
        super.addView(child, width, height)
    }

    override fun addViewInLayout(child: View, index: Int, params: ViewGroup.LayoutParams): Boolean {
        doInitIfNoView(child)
        return super.addViewInLayout(child, index, params)
    }

    override fun addViewInLayout(child: View, index: Int, params: ViewGroup.LayoutParams, preventRequestLayout: Boolean): Boolean {
        doInitIfNoView(child)
        return super.addViewInLayout(child, index, params, preventRequestLayout)
    }

    private fun doInitIfNoView(child: View) {
        if (mContentScene == null && child !== mProgressScene && child !== mCustomScene) {
            mContentScene = child
            mCurrentScene = mContentScene
        }
    }
}