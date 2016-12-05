package at.fh.swengb.sierpinski_android

import android.app.Notification.Style
import android.content.Context
import android.graphics.{Canvas, Color, Paint, Path}
import android.util.AttributeSet
import android.view.View

/**
  * Created by Martin H. on 05.12.2016.
  */
class SierpinskiView(val context: Context, val attrs: AttributeSet) extends View(context, attrs) {

  val paint = new Paint()

  override protected def onDraw(canvas: Canvas) {
    super.onDraw(canvas)

    // drawACircle(canvas)
    drawTriangle(canvas)
    drawSubTrianlge(canvas)

  }

  /* drawing a circle, for testing purposes

  def drawACircle(canvas: Canvas) = {
    val x: Int = getWidth();
    val y: Int = getHeight();
    val radius: Int = 100;
    paint.setColor(Color.WHITE)
    paint.setStyle(Paint.Style.FILL)
    canvas.drawPaint(paint)
    paint.setColor(Color.parseColor("#CD5C5C"))
    canvas.drawCircle(x/2, y/2, radius, paint)
  } */

  def drawTriangle(canvas: Canvas) = {

    paint.setColor(Color.BLACK)

    val path = new Path()

    path.moveTo(0,0)
    path.lineTo(100,100)
    path.close()
    canvas.drawPath(path, paint)

  }

  def drawSubTrianlge(canvas: Canvas) = {

    paint.setColor(Color.BLUE)

    val path = new Path()

    path.moveTo(50,0)
    path.lineTo(0,50)
    path.close()
    canvas.drawPath(path, paint)
  }
}
