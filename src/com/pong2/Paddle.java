package com.pong2;

import android.graphics.Canvas;


public class Paddle  extends PongObject
{
	public  static  int width = 100;
	private static  int height= 25;
	private Boolean ai;
	
	Paddle(int x, int y)
	{
		super(x, y, x+ width, y+ height);
	}
	
	public void ai(Boolean bool)
	{
		this.ai = bool;
	}
	
	public void attachmotion(Ball  ball, Canvas canvas)
	{
		if(this.ai == true)
		{
			if(Global.bYspeed  < 0 )
			{
                 this.defend(ball);
		    }
		   else
		   if (Global.bYspeed > 0)
		   {
			   this.tomiddle(canvas);
		   }
		}
	}
	
	private void defend(Ball ball)
	{
	    if(this.centerX() > ball.centerX() )
	    {
            this.movedown();
	    }
	    else
	    if(this.centerX() < ball.centerX())
	    {
		    this.moveup();
	    }
	}
	
	private void movedown()
	{
		Global.cpx -= Global.cSpeed;
		
	}
	
	private void moveup()
	{
		Global.cpx += Global.cSpeed;
	}
	
	private void tomiddle(Canvas canvas)
	{
		if(this.centerX() < canvas.getWidth()/2 )
		{
			this.moveup();
		}
		else if(this.centerX() > canvas.getWidth()/2)
		{
			this.movedown();
		}
			
	}

}
