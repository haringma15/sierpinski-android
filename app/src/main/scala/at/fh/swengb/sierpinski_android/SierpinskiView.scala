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
  val depth = 1

  override protected def onDraw(canvas: Canvas) {
    super.onDraw(canvas)

    val x = canvas.getWidth
    val y = Math.sqrt(x * x - x/2 * x/2).toFloat

    drawTriangle(canvas, x, y)
    drawSubTriangle(canvas, depth, x, y)
  }

  def drawTriangle(canvas: Canvas, x: Float, y: Float) = {
    canvas.drawLine(0, y, x, y, paint)
    canvas.drawLine(x, y, x/2, 0, paint)
    canvas.drawLine(0, y, x/2, 0, paint)
  }

  def drawSubTriangle(canvas: Canvas, depth: Int, x: Float, y: Float): Unit = {
    if (depth > 0){
      canvas.drawLine(x/2, y, x/4, y/2, paint)
      canvas.drawLine(x/2, y, x/4*3, y/2, paint)
      canvas.drawLine(x/4, y/2, x/4*3, y/2, paint)
      val newDepth = depth - 1
      val newWidth = 1
      val newHeight = 1
      drawSubTriangle(canvas, newDepth, newWidth, newHeight)
    }
  }
}