package com.fly.widget;


import android.graphics.Canvas;
import android.util.Log;

import com.fly.graphic.Renderer;

public class Label extends Widget
{
    protected String text = "";

    public Label() { super(); this.type = Widget.TYPE_LABEL; }

    public Label(float x,float y) { super(x,y); this.type = Widget.TYPE_LABEL; }
    public Label(float x,float y,float w,float h) { super(x, y, w, h); this.type = Widget.TYPE_LABEL; }

    public Label(String text) { super(); this.text = text; this.type = Widget.TYPE_LABEL; }
    public Label(String text,float x,float y) { super(x, y); this.text = text; this.type = Widget.TYPE_LABEL; }
    public Label(String text,float x,float y,float w,float h) { super(x, y, w, h); this.text = text; this.type = Widget.TYPE_LABEL; }

    @Override public void Render(Canvas canvas)
    {
        canvas.drawText(this.text,this.x,this.y,paint);
    }
}




