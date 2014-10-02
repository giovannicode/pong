package com.pong2;

import android.graphics.Color;
import android.graphics.Paint.Style;
import android.graphics.Rect;
import android.graphics.Paint;
import android.graphics.Canvas;
import android.util.Log;

public class PongObject
{
	private Rect shape;
	private static Paint paint;
	public int positionxright;
	public int positionyright;
	
	public Boolean toGoal = false;
	
	PongObject(int x, int y, int xx, int yy)
	{
		shape = new Rect(x, y, xx, yy);
		paint = new Paint();
		paint.setColor(Color.WHITE);
		paint.setStyle(Style.FILL);
	}
	
	public  boolean intersects(PongObject pongobject )
	{  
		if (Math.abs( this.centerY() - pongobject.centerY()) <  this.halfheight() + pongobject.halfheight()  && Math.abs(this.centerX() - pongobject.centerX()) <  this.halfwidth() + pongobject.halfwidth())
		{
			if(this.toGoal == false)
			{
				Log.d("MainMenu", "false");
			   return true;
			}
		}
		else if
		(Math.abs( this.centerY() - pongobject.centerY()) <  this.halfheight() + pongobject.halfheight())
		{
			this.toGoal = true;
			Log.d("MainMenu", "true");
			if(Math.abs(this.centerX() - pongobject.centerX()) <  this.halfwidth() + pongobject.halfwidth())
			{
				Global.bXspeed = -Global.bXspeed;
			}
		}
		
		if(this.toGoal == true)
		{
		if(Math.abs(this.centerX() - pongobject.centerX()) <  this.halfwidth() + pongobject.halfwidth())
		{
			Global.bXspeed = -Global.bXspeed;
		}
		}
		
		return false;
			
	}
	
	public int positionx()
	{
		return shape.left;
	}
	
	public int positionxright()
	{
		return shape.right;
	}
	
	public int positionTop()
	{
		return shape.top;
	}
	
	public int positionBottom()
	{
		return shape.bottom;
	}
	
	public int width()
	{
		return shape.width();
	}
	
	public int height()
	{
		return shape.height();
	}
	
	public int centerX()
	{
		return shape.centerX();
	}
	
	public int centerY()
	{
		return shape.centerY();
	}
	
	public int halfwidth()
	{
		return shape.width() / 2;
	}
	
	public int halfheight()
	{
		return shape.height() / 2;
	}
	
	public Rect rect()
	{
	   return shape;
	}
	
	public void setPosition(int x, int y)
	{
		shape.set(x, y, x + this.width(),  y + this.height());	
	}
	
	public void draw(Canvas canvas)
	{
		canvas.drawRect(this.rect(), paint);
	}
}
