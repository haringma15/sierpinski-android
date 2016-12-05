package at.fh.swengb.sierpinski_android

import android.content.Context
import android.graphics.{Canvas, Color, Paint, Path}
import android.util.AttributeSet
import android.view.View

/**
  * Created by Martin H. on 05.12.2016.
  */
class SierpinskiView(val context: Context, val attrs: AttributeSet) extends View(context, attrs) {

  override protected def onDraw(canvas: Canvas) {
    super.onDraw(canvas)

    drawTriangle(canvas)
    drawSubTrianlge(canvas)

  }

  def drawTriangle(canvas: Canvas) = {

    val paint = new Paint()
    paint.setColor(Color.BLACK)

    val path = new Path()

    path.moveTo(0,0)
    path.lineTo(100,100)
    path.close()
    canvas.drawPath(path, paint)

  }

  def drawSubTrianlge(canvas: Canvas) = {

    val paint = new Paint()
    paint.setColor(Color.BLUE)

    val path = new Path()

    path.moveTo(50,0)
    path.lineTo(0,50)
    path.close()
    canvas.drawPath(path, paint)
  }
}
