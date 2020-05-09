package com.fly.widget;

import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.RectF;
import android.util.Log;

import java.io.IOException;

public class ImageButton extends Widget
{
    Bitmap bitmap = null;

    public ImageButton() { this(0f,0f); }
    public ImageButton(float x,float y) { this(x,y,0f,0f); }
    public ImageButton(float x,float y,float w,float h) { super(x, y, w, h);this.type = Widget.TYPE_BUTTON; }

    public ImageButton(String bitmap_path) { this(bitmap_path,0f,0f); }
    public ImageButton(String bitmap_path,float x,float y) { this(bitmap_path,x,y,0f,0f); }
    public ImageButton(String bitmap_path,float x,float y,float w,float h)
    {
        super(x, y, w, h);
        this.bitmap = BitmapFactory.decodeFile(bitmap_path);
        this.type = Widget.TYPE_BUTTON;
    }

    public ImageButton(String bitmap_path, AssetManager asset_manager) throws IOException { this(bitmap_path,asset_manager,0f,0f); }
    public ImageButton(String bitmap_path, AssetManager asset_manager,float x,float y) throws IOException { this(bitmap_path,asset_manager,x,y,0f,0f); }
    public ImageButton(String bitmap_path, AssetManager asset_manager,float x,float y,float w,float h) throws IOException
    {
        super(x, y, w, h);
        this.bitmap = BitmapFactory.decodeStream(asset_manager.open(bitmap_path));
        this.type = Widget.TYPE_BUTTON;
    }


    @Override public void Render(Canvas canvas)
    {
        float right = x + width;
        float bottom = y + height;

        if (bitmap != null)
            canvas.drawBitmap(bitmap,null, new RectF(x,y,right,bottom),paint);
        else
        {

        }
    }

    @Override public void Click(Canvas canvas) {
        Log.v("ImageButton","Click");
    }
}













