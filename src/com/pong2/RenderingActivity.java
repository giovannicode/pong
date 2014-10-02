package com.pong2;

import android.app.Activity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.view .SurfaceHolder;
import android.view.SurfaceView;
import android.content.Context;
import android.graphics.Canvas;
import android.util.Log;
import android.view.View.OnTouchListener;
import android.view.View;
import android.view.MotionEvent;
import android.graphics.Paint;
import android.graphics.Color;



public class RenderingActivity extends Activity implements OnTouchListener
{
	Gameview gameview;
	Ball ball;
	Paddle mypaddle;
	Paddle cpaddle;
	Paint paint;
	FPSCounter counter = new FPSCounter();
	Boolean gaming = true;
	Boolean down = false;
	
	
	private void log(String text)
	{
		Log.d("MainMenu", text);
	}
	
	@Override
	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
		                                   WindowManager.LayoutParams.FLAG_FULLSCREEN);
		Global.getSettings();
		gameview = new Gameview(this);
		gameview.setOnTouchListener(this);
		setContentView(gameview);
		log("RENCreated");
		
	}
	
	@Override
	protected void onResume()
	{
		super.onResume();
		gameview.onResume();
		log("RENResumed");
	}
	
	@Override
	protected void onPause()
	{
		super.onPause();
		gameview.onPause();
		log("RENPause");
		
		if(isFinishing())
		{
			log("RENFinishing");
		}
		
	}
	
	public boolean onTouch(View v, MotionEvent event)
	{
		if(gaming)
		{
		   Global.mpx = (int) event.getX() - Paddle.width/2;
		}
		else 
	    if(gaming == false)
		{
			switch (event.getAction())
			{
			case MotionEvent.ACTION_DOWN:
			{
				down = true;
				break;
			}
			case MotionEvent.ACTION_UP:
			{
				if(down)
				{
				   down = false;
				   gaming = true;
				}
				break;
			}
			}		    
		}
		return true;
	}
	
	class Gameview extends SurfaceView implements Runnable//, OnTouchListener
	{
		Thread  animationthread = null;
		SurfaceHolder holder;
		volatile boolean running = false;
		int red = 350;
		
		public Gameview(Context context)
		{
			super(context);
			holder = getHolder();
			loadContent();
		}
		

		
		private void loadContent()
		{
			cpaddle= new Paddle(110, 25);
			ball = new Ball(Global.bpx, Global.bpy);
			mypaddle = new Paddle(110, 430);
			
			cpaddle.ai(true);
			
			paint = new Paint();
			paint.setColor(Color.WHITE);
			paint.setTextSize(20);
			
			ball.toGoal = false;
		}
		
		public void onResume()
		{
			running = true;
			animationthread = new Thread(this);
			animationthread.start();
		}
		
		public void run()
		{
			while(running) 
			{
				if(!holder.getSurface().isValid())
					continue;
				if(gaming)
				{
				   Canvas canvas = holder.lockCanvas();
				   Update(canvas);
				   Draw(canvas);
				   counter.logFrame();
				   if(!gaming)
				   {
					   canvas.drawText("Tap screen to serve", 120f, 220f, paint);
					   ball.toGoal = false;
				   }
				   holder.unlockCanvasAndPost(canvas);
				}
				
			}
		}
		
		public void onPause()
		{
			Global.Reset();
			Global.cScore = 0;
			Global.mScore = 0;
			running = false;
			while(true)
			{
				try
				{
					animationthread.join();
					break;
				}
				catch(InterruptedException e)
				{
					//retry ?
				}
			}
		}
		
		private void Update(Canvas canvas)
		{
            ballUpdate(canvas);
            cpaddleUpdate(canvas);
            mypaddleUpdate(canvas);

		}
		
		private void Draw(Canvas canvas)
		{
			canvas.drawRGB(0, 0, 0);
			canvas.drawText("SCORE    " +  "Computer:  " + Global.cScore +  "    You: " +Global. mScore, 10f, 20f, paint);
			cpaddle.draw(canvas);
			ball.draw(canvas);
			mypaddle.draw(canvas);
			//canvas.drawText("Tap screen to serve", 120f, 220f, paint);
		}
		
		private void ballUpdate(Canvas canvas)
		{
			if(ball.scoregoal(canvas))
			{
				Global.Reset();
				gaming = false;
				ball.toGoal = false;
			}
			
			if(ball.intersects(mypaddle))
			{
				Global.bYspeed = -Global.bYspeed;
				Global.bYspeed--;
			}
			
			if(ball.intersects(cpaddle))
			{
				Global.bYspeed = -Global.bYspeed;
				Global.bYspeed++;
			}
			
			if(ball.hitwall(canvas))
			{
				
				Global.bXspeed = - Global.bXspeed;
				
				if(Global.bXspeed < 0)
				{
					Global.bXspeed--;
				}
				else
				if(Global.bXspeed > 0)
				{
					Global.bXspeed++;
				}
			}
			
			Global.bpx += Global.bXspeed;
			Global.bpy += Global.bYspeed;
			
			ball.setPosition(Global.bpx, Global.bpy);
		}
		
		private void cpaddleUpdate(Canvas canvas)
		{
			cpaddle.attachmotion(ball, canvas);
			cpaddle.setPosition(Global.cpx, Global.cpy);		
		}
		
		private void mypaddleUpdate(Canvas canvas)
		{
			mypaddle.setPosition(Global.mpx,Global.mpy);
		}
		
	}
	
}