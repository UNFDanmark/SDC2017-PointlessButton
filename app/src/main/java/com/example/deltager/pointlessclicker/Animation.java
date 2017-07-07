package com.example.deltager.pointlessclicker;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by deltager on 07-07-17.
 */

public class Animation extends View {

    Bitmap redbut1, redbut2;
    Boolean skift;


    public Animation(Context context) {
        super(context);
        setup();
    }

    public Animation(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        setup();
    }

    public Animation(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        setup();
    }

    public void setup() {
        redbut1 = BitmapFactory.decodeResource(this.getResources(), R.drawable.red1);
        redbut2 = BitmapFactory.decodeResource(this.getResources(), R.drawable.red2);

        skift = true;

        postInvalidate();

    }
}
