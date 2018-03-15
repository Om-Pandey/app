package com.example.kiit.custom.button;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.widget.AppCompatButton;
import android.util.AttributeSet;

import com.example.kiit.custom.R;

/**
 * Created by KIIT on 07-03-2018.
 */

public class Button extends AppCompatButton {
    public Button(Context context) {
        super(context);
    }
    Context context;
    public Button(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public Button(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }
    public void init(Context context1)
    {
    context = context1;
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        setTextColor(Color.parseColor("77ffaa"));
        setBackgroundDrawable(context.getResources().getDrawable(R.drawable.draw_button,null));
    }

}
