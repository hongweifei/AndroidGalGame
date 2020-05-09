package com.fly.galgame

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.content.pm.ActivityInfo
import android.graphics.BitmapFactory
import android.graphics.Canvas
import android.graphics.RectF
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.DisplayMetrics
import android.view.View
import android.view.WindowManager
import com.fly.game.Game
import com.fly.graphic.Renderer
import com.fly.graphic.SceneRenderer
import kotlinx.android.synthetic.main.activity_main.*

@SuppressLint("Registered")
class MainActivity : AppCompatActivity(), View.OnClickListener
{
    @SuppressLint("SourceLockedOrientationActivity")
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE

        val wm = getSystemService(Context.WINDOW_SERVICE) as WindowManager
        val dm = DisplayMetrics()
        wm.defaultDisplay.getMetrics(dm)


        StartButton.setOnClickListener(this)
        ExitButton.setOnClickListener(this)


        val bitmap = BitmapFactory.decodeStream(assets.open("title/WorldMap.png"))
        main_scene.SetSceneRenderer(SceneRenderer());
        main_scene.SetRender() { renderer: Renderer, canvas: Canvas ->
            renderer.DrawBitmap(canvas,bitmap,null, RectF(0f,0f,main_scene.GetSceneWidth(),main_scene.GetSceneHeight()));
        }
    }

    override fun onClick(v: View?)
    {
        if (v != null)
        {
            when (v.id)
            {
                R.id.StartButton -> StartGame()
                R.id.ExitButton -> ExitGame()
            }
        }
    }

    fun StartGame()
    {
        val intent = Intent(this, Game::class.java)
        startActivity(intent);  //开始跳转
    }

    fun ExitGame()
    {
        this.finish();
    }
}


