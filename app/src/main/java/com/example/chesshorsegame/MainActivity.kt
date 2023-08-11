package com.example.chesshorsegame

import android.graphics.Point
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.TypedValue
import android.view.View
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TableRow

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initScreenGame()

    }

    private fun initScreenGame(){
        setSizeBoard()
        hideMessage()
    }

    private fun setSizeBoard(){
        var iv: ImageView;
        var display = windowManager.defaultDisplay
        val size = Point()
        display.getSize(size)
        val width = size.x

        var widthdp = (width/resources.displayMetrics.density)

        var lateralMarginDP = 0
        val widthcell = (widthdp - lateralMarginDP)/8
        var heigthCell = widthcell

        for (i in 0..7) {
            for(j in 0..7){
                iv = findViewById(resources.getIdentifier("c$i$j","id", packageName))

                var height = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, heigthCell, resources.displayMetrics).toInt()
                var width = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, widthcell, resources.displayMetrics).toInt()
                iv.layoutParams.height = height
                iv.layoutParams.width = width
            }
            
        }
    }

    private fun hideMessage(){
        val message: LinearLayout = findViewById(R.id.lyMessage)
        message.visibility = View.INVISIBLE
    }
}