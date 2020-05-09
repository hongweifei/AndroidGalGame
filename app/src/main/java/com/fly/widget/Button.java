package com.fly.widget;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.Log;

public class Button extends Label
{
    public Button() { this(0f,0f); }
    public Button(float x,float y) { this(x,y,0f,0f); }
    public Button(float x,float y,float w,float h) { super(x, y, w, h); this.type = Widget.TYPE_BUTTON; }

    public Button(String text) { this(text,0f,0f); }
    public Button(String text,float x,float y) { this(text,x,y,0f,0f); }
    public Button(String text,float x,float y,float w,float h) { super(x, y, w, h); this.text = text; this.type = Widget.TYPE_BUTTON; }

    @Override public void Render(Canvas canvas)
    {
        float right = x + width;
        float bottom = y + height;

        paint.setStyle(Paint.Style.STROKE);

        canvas.drawRect(x,y,right,bottom,paint);
        canvas.drawText(text,x,bottom - height / 2 + paint.getTextSize() / 2,paint);
    }

    @Override public void Click(Canvas canvas) {
        Log.v("Button","Click");
    }
}











