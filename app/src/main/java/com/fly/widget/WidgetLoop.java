package com.fly.widget;


import android.graphics.Canvas;
import android.util.Log;

import java.util.ArrayList;
import java.util.Arrays;

public class WidgetLoop
{
    private ArrayList<Widget> widgets = new ArrayList<Widget>();
    private float touch_x = -1000;
    private float touch_y = -1000;
    private float last_touch_x = 0;
    private float last_touch_y = 0;

    public WidgetLoop() { }

    public WidgetLoop(Widget... widget) { this.widgets.addAll(Arrays.asList(widget)); }


    public void AddWidgetToLoop(Widget widget) { this.widgets.add(widget); }
    public void AddWidgetToLoop(Widget... widget) {this.widgets.addAll(Arrays.asList(widget)); }

    public void RemoveWidgetInLoop(int index) { this.widgets.remove(index); }
    public void RemoveWidgetInLoop(Widget widget) { this.widgets.remove(widget); }


    public void WidgetMainLoop(Canvas canvas)
    {
        for (Widget widget : this.widgets)
        {
            if (widget.type == Widget.TYPE_BUTTON && last_touch_x != touch_x || last_touch_y != touch_y)
            {
                Log.v("WidgetMainLoop","touch");
                if (Widget.Collision(widget,touch_x,touch_y,1,1))
                    widget.Click(canvas);

                last_touch_x = touch_x;
                last_touch_y = touch_y;
            }

            widget.Render(canvas);
        }
    }


    public void SetTouchPosition(float x,float y){ this.touch_x = x; this.touch_y = y; }

}








