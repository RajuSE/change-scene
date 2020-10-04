package dev.raju.changescene;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import dev.raju.lib.changescene.ChangeSceneConstraintLayout;
import dev.raju.lib.changescene.ChangeSceneLayout;
import dev.raju.lib.changescene.ChangeSceneLinearLayout;

public class MainActivity extends AppCompatActivity {

    ChangeSceneConstraintLayout mScene;
    Button mBtnLoadChats;
    TextView tvHome;
    TextView tvError;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mScene = (ChangeSceneConstraintLayout) findViewById(R.id.rootView);
        mBtnLoadChats = (Button) findViewById(R.id.btnLoadChats);
        tvHome = (TextView) findViewById(R.id.tvHome);
        tvError = (TextView) findViewById(R.id.tvError);

        mBtnLoadChats.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                mScene.showProgressScene("Loading chats..");
                Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        mScene.changeScene(R.layout.chat_scene);
                    }
                }, 1500);
            }
        });

        tvHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                mScene.showContentScene();

            }
        });

        tvError.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                mScene.showProgressScene("Loading chats..");
                Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        mScene.changeScene(R.layout.error_scene);
                    }
                }, 3000);
            }
        });
    }
}
