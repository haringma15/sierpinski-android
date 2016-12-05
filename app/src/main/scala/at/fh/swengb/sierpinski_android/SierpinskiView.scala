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
  val depth = 2

  override protected def onDraw(canvas: Canvas) {
    super.onDraw(canvas)

    val x = canvas.getWidth
    val y = Math.sqrt(x * x - x/2 * x/2).toFloat

    drawTriangle(canvas, x, y)
    drawSubTriangle(canvas, depth, x/2, x/4, x/4*3, y, y/2)
  }

  def drawTriangle(canvas: Canvas, x: Float, y: Float) = {
    canvas.drawLine(0, y, x, y, paint)
    canvas.drawLine(x, y, x/2, 0, paint)
    canvas.drawLine(0, y, x/2, 0, paint)
  }

  def drawSubTriangle(canvas: Canvas, depth: Int, a: Float, b: Float, c: Float, y1: Float, y2: Float): Unit = {
    if (depth > 0){
      canvas.drawLine(a, y1, b, y2, paint)
      canvas.drawLine(b, y2, c, y2, paint)
      canvas.drawLine(c, y2, a, y1, paint)
      val newDepth = depth - 1
      drawSubTriangle(canvas, newDepth, a/2, b/2, c/2, y1, y2/2*3)
      drawSubTriangle(canvas, newDepth, a/2*3, b/2*5, c/6*7, y1, y2/2*3)
      drawSubTriangle(canvas, newDepth, a, b/2*3, c/6*5, y2, y2/2)
    }
  }
}