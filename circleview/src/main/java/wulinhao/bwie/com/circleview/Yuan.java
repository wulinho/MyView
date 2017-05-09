package wulinhao.bwie.com.circleview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Region;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

import static android.content.ContentValues.TAG;
import static android.graphics.Path.Op.DIFFERENCE;

/**
 * Created by 武林浩
 * on 2017/5/8 -8:57 .
 * Description:
 */

public class Yuan extends View{

    private Region region;
    private Region region1;

    public Yuan(Context context) {
        super(context);
        addPaint();
    }

    public Yuan(Context context, Region region) {
        super(context);
        addPaint();
    }

    public Yuan(Context context, AttributeSet attrs, Region region) {
        super(context, attrs);
        addPaint();
    }



    private Paint paint;//画笔

    private int width;     //宽
    private int height;   //高


    private void addPaint(){
        paint = new Paint();
        paint.setColor(Color.BLACK);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(10);
        paint.setAntiAlias(true);

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        width=getWidth();   //屏幕的全部的宽
        height=getHeight(); //屏幕全部的高
        Path cirPath=new Path();
        cirPath.addCircle(width/2,height/2,200,Path.Direction.CCW);
        //圆              除2也就是在屏幕的中间
        //canvas.drawCircle(width/2,height/2,500,paint);
                                         //圆的半径
        canvas.drawPath(cirPath,paint);

        //路径
       paint.setColor(Color.YELLOW);

       Path p1=new Path();
        p1.moveTo(width /2, height /2-200);
        p1.lineTo(width /2+200, height /2);
        p1.lineTo(width /2, height /2+200);
        p1.lineTo(width /2-200, height /2);
        p1.close();
        canvas.drawPath(p1,paint);


        //在画个路径
        paint.setColor(Color.GREEN);
        Path p2 = new Path();
        p2.moveTo((width /2+(width /2+200))/2,((height /2-200)+ height /2)/2);
        p2.lineTo(((width /2+200)+ width /2)/2,((height /2+200)+ height /2)/2);
        p2.lineTo((width /2+(width /2-200))/2,((height /2+200)+ height /2)/2);
        p2.lineTo(((width /2-200)+ width /2)/2,(height /2+(height /2-200))/2);
        p2.close();
        canvas.drawPath(p2,paint);

        cirPath.op(p1,DIFFERENCE);
        p1.op(p2,DIFFERENCE);
        //屏幕的大小
        region = new Region(0,0,getWidth(),getHeight());
        region.setPath(cirPath,region);

        region1 = new Region(0,0,getWidth(),getHeight());
        region1.setPath(p1, region1);


    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        int XX = (int) event.getX();
        int YY = (int) event.getY();
        switch (event.getAction()){
            case  MotionEvent.ACTION_DOWN:
                break;
            case  MotionEvent.ACTION_MOVE:
                break;
            case  MotionEvent.ACTION_UP:

                if(region.contains(XX,YY)){
                    Log.d(TAG, "onTouchEvent: -----------"+region.contains(XX,YY)+"------"+XX+"---------"+YY);
                 listener.onClick(this);
                }
                if(region1.contains(XX,YY)){
                 listener1.onClick(this);
                    Log.d(TAG, "onTouchEvent: ++++++++++++++++++"+region1.contains(XX,YY));
                }
                break;
        }

        return super.onTouchEvent(event);

    }
    @Override
    public void setOnClickListener(@Nullable OnClickListener l) {
        super.setOnClickListener(l);
        listener = l;
    }

    public void setOnClick(OnClickListener m) {
        this.listener1 = m;
    }
    OnClickListener listener;



    OnClickListener listener1;
}
