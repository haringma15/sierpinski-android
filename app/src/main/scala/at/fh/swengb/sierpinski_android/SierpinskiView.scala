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

    val width = canvas.getWidth
    val height = Math.sqrt(width * width - width/2 * width/2).toFloat

    drawTriangle(canvas, width, height)
    drawSubTriangle(canvas, depth, width/2, height/2)
  }

  def drawTriangle(canvas: Canvas, width: Float, height: Float) = {
    canvas.drawLine(0, height, width, height, paint)
    canvas.drawLine(width, height, width/2, 0, paint)
    canvas.drawLine(0, height, width/2, 0, paint)
  }

  def drawSubTriangle(canvas: Canvas, depth: Int, width: Float, height: Float): Unit = {
    if (depth > 0){
      canvas.drawLine(0, depth, depth + 500, depth + 600, paint)
      canvas.drawLine(0, depth, depth + 500, depth + 600, paint)
      canvas.drawLine(0, depth, depth + 500, depth + 600, paint)
      val newDepth = depth - 1
      val newWidth = 1
      val newHeight = 1
      drawSubTriangle(canvas, newDepth, newWidth, newHeight)
    }
  }
}