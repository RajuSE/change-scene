package dev.raju.changescene

import android.os.Bundle
import android.os.Handler
import android.support.v7.app.AppCompatActivity
import android.widget.Button
import android.widget.TextView
import dev.raju.lib.changescene.ChangeSceneConstraintLayout

class MainActivity : AppCompatActivity() {
    var mScene: ChangeSceneConstraintLayout? = null
    var mBtnLoadChats: Button? = null
    var tvHome: TextView? = null
    var tvError: TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mScene = findViewById(R.id.rootView) as ChangeSceneConstraintLayout
        mBtnLoadChats = findViewById(R.id.btnLoadChats) as Button
        tvHome = findViewById(R.id.tvHome) as TextView
        tvError = findViewById(R.id.tvError) as TextView
        mBtnLoadChats!!.setOnClickListener {
            mScene!!.showProgressScene("Loading chats..")
            val handler = Handler()
            handler.postDelayed({ mScene!!.changeScene(R.layout.chat_scene) }, 1500)
        }
        tvHome!!.setOnClickListener { mScene!!.showContentScene() }
        tvError!!.setOnClickListener {
            mScene!!.showProgressScene("Loading chats..")
            val handler = Handler()
            handler.postDelayed({ mScene!!.changeScene(R.layout.error_scene) }, 3000)
        }
    }
}