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

  override protected def onDraw(canvas: Canvas) {
    super.onDraw(canvas)

    drawTriangle(canvas)
    drawSubTriangle(canvas)
  }

  def drawTriangle(canvas: Canvas) = {
    canvas.drawLine(0, Math.sqrt(canvas.getWidth * canvas.getWidth - canvas.getWidth/2 * canvas.getWidth/2).toFloat,canvas.getWidth(),Math.sqrt(canvas.getWidth * canvas.getWidth - canvas.getWidth/2 * canvas.getWidth/2).toFloat,paint)
    canvas.drawLine(canvas.getWidth(), Math.sqrt(canvas.getWidth * canvas.getWidth - canvas.getWidth/2 * canvas.getWidth/2).toFloat, canvas.getWidth/2, 0,paint)
    canvas.drawLine(0, Math.sqrt(canvas.getWidth * canvas.getWidth- canvas.getWidth/2 * canvas.getWidth/2).toFloat, canvas.getWidth/2, 0,paint)
  }

  def drawSubTriangle(canvas: Canvas) = {
    val counter = 0

  }
}
