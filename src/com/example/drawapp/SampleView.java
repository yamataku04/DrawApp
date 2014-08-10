package com.example.drawapp;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;

public class SampleView extends View {
	
	private Paint paint=new Paint();
	private int color =Color.RED;
	private int bx=100;
	private int by=100;
	private int dx=2;
	private int dy=2;
	private static int margin=20;
	private Bitmap item;
	
	/**
	 * @param args
	 */
	//import:Ctrl+Shift+O
	//�R�[�h�A�V�X�g�FCtrl+space
public SampleView(Context context){
	super(context);
	setBackgroundColor(Color.WHITE);
	Resources res=context.getResources();
	item=BitmapFactory.decodeResource(res, R.drawable.ic_launcher);
	
}
@Override
public void onDraw(Canvas canvas){
	paint.setColor(color);
	canvas.drawCircle(bx,by,20,paint);
	//�E�[�ɗ����甽�]
	if(bx<0+margin){
		dx=2;
	}//�E�[
	if(bx>getWidth()-margin){
		dx=-2;
	}//��[
	if(by<0+margin){
		dy=2;
	}//���[
	if(by>getHeight()-margin){
		dy=-2;
	}
	bx=bx+dx;
	by=by+dy;
}
@Override
public boolean onTouchEvent(MotionEvent event){
	int action=event.getAction();
	if((action&MotionEvent.ACTION_MASK)==//bit���Z
			MotionEvent.ACTION_DOWN){//�{�^�����������Ƃ��ɕ\�������(�ǂ��ł�)
	int ex=(int)event.getX();
	int ey=(int)event.getY();
	
	
	if((bx-ex)*(bx-ex)+(by-ey)*(by-ey)<=20*20){//�_�̍��W�w��
		Toast.makeText(getContext(), "Touch����܂���", 
				Toast.LENGTH_SHORT).show();//�F�ς��B��������ԂɁB�Ԃ��������
		if(color==Color.BLUE){
			color=Color.RED;
		}else{
			color=Color.BLUE;
		}
		
		invalidate();//�ĕ`��
		
	}
		
	}
return true;	
}

}
