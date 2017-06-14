package dev.raju.changescene;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import dev.raju.lib.changescene.ChangeSceneLayout;


/*
 * Created by RajuSE on 6/14/2017.
 */
public class MainActivity extends AppCompatActivity {

    ChangeSceneLayout mScene;
    TextView tvLoadChats;
    TextView tvHome;
    TextView tvError;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mScene = (ChangeSceneLayout) findViewById(R.id.rootView);
        tvLoadChats = (TextView) findViewById(R.id.tvLoadChats);
        tvHome = (TextView) findViewById(R.id.tvHome);
        tvError = (TextView) findViewById(R.id.tvError);

        tvLoadChats.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                mScene.showProgressScene("Loading chats..");
                Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        mScene.changeScene(R.layout.chat_scene);
                    }
                }, 3000);
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
