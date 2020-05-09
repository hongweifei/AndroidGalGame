package com.fly.widget;


import android.graphics.Canvas;
import android.graphics.Paint;


public class Widget
{
    static int TYPE_WIDGET = 0;
    static int TYPE_LABEL = 1;
    static int TYPE_BUTTON = 2;

    protected int type = TYPE_WIDGET;

    protected float x = 0;
    protected float y = 0;
    protected float width = 0;
    protected float height = 0;

    protected Paint paint = new Paint();

    public Widget() { this(0f,0f); }
    public Widget(float x,float y) { this(x,y,0f,0f); }
    public Widget(float x,float y,float w,float h)
    {
        this.x = x;
        this.y = y;
        this.width = w;
        this.height = h;
    }

    static public Boolean Collision(Widget widget,float x,float y,float width,float height)
    {
        float widget_right = widget.x + widget.width;
        float widget_bottom = widget.y + widget.height;
        float right = x + width;
        float bottom = y + height;

        if (widget.x < right && widget.x > x && widget.y < bottom && widget_bottom > y)
            return true;
        if (widget_right > x && widget_right < right && widget_bottom > y && widget_bottom < bottom)
            return true;

        return false;
    }

    public Paint GetPaint() { return this.paint; }

    public void Render(Canvas canvas) {}
    public void Click(Canvas canvas) {}
}




