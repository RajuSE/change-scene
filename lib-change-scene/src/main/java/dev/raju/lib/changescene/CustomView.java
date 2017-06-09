package dev.raju.lib.changescene;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;


public class CustomView extends RelativeLayout {


    LayoutInflater mInflater;
    public CustomView(Context context) {
        super(context);
        mInflater = LayoutInflater.from(context);
        init();

    }
    public CustomView(Context context, AttributeSet attrs, int defStyle)
    {
        super(context, attrs, defStyle);
        mInflater = LayoutInflater.from(context);
        init();
    }
    public CustomView(Context context, AttributeSet attrs) {
        super(context, attrs);
        mInflater = LayoutInflater.from(context);
        init();
    }
    public void init()
    {
        View v = mInflater.inflate(R.layout.custom_view, this, true);
        TextView tv = (TextView) v.findViewById(R.id.textView1);
        tv.setText(" Custom RelativeLayout");
    }
}
