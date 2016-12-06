package at.fh.swengb.sierpinski_android

import android.content.Context
import android.graphics.{Canvas, Paint}
import android.util.AttributeSet
import android.view.View

/**
  * Created by Martin H. on 05.12.2016.
  */
class SierpinskiView(val context: Context, val attrs: AttributeSet) extends View(context, attrs) {

  val paint = new Paint()
  val depth = 7

  override protected def onDraw(canvas: Canvas) {
    super.onDraw(canvas)

    val x = canvas.getWidth
    val y = Math.sqrt(x * x - x/2 * x/2).toFloat

    drawSierpinski(canvas, 0, y+50, x/2, 50, x, y+50)
  }

  def drawSierpinski(canvas: Canvas, x1: Float, y1: Float, x2: Float, y2: Float, x3: Float, y3: Float) = {
    canvas.drawLines(Array(x1, y1, x2, y2, x2, y2, x3, y3, x3, y3, x1, y1), paint)
    drawSubTriangle(canvas, depth, (x1 + x2)/2, (y1 + y2)/2, (x1 + x3)/2, (y1 + y3)/2, (x2 + x3)/2, (y2 + y3)/2)
  }

  def drawSubTriangle(canvas: Canvas, depth: Int, x1: Float, y1: Float, x2: Float, y2: Float, x3: Float, y3: Float): Unit = {
    if (depth > 0){
      canvas.drawLines(Array(x1, y1, x2, y2, x2, y2, x3, y3, x3, y3, x1, y1), paint)
      val newDepth = depth - 1
      drawSubTriangle(canvas, newDepth, (x1 + x2)/2 + (x2 - x3)/2, (y1 + y2)/2 + (y2 - y3)/2, (x1 + x2)/2 + (x1 - x3)/2, (y1 + y2)/2 + (y1 - y3)/2, (x1 + x2)/2, (y1 + y2)/2)
      drawSubTriangle(canvas, newDepth, (x3 + x2)/2 + (x2 - x1)/2, (y3 + y2)/2 + (y2 - y1)/2, (x3 + x2)/2 + (x3 - x1)/2, (y3 + y2)/2 + (y3 - y1)/2, (x3 + x2)/2, (y3 + y2)/2)
      drawSubTriangle(canvas, newDepth, (x1 + x3)/2 + (x3 - x2)/2, (y1 + y3)/2 + (y3 - y2)/2, (x1 + x3)/2 + (x1 - x2)/2, (y1 + y3)/2 + (y1 - y2)/2, (x1 + x3)/2, (y1 + y3)/2)
    }
  }
}