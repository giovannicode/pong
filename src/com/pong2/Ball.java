package com.pong2;

import android.graphics.Canvas;


public class Ball extends PongObject
{
	private static final int width = 25;
	private static final int height = 25;
	
	Ball(int x, int y)
	{
		super(x, y, x + width,  y + height);
	}
	
	public boolean scoregoal(Canvas canvas)
	{
		if (this.centerY() > canvas.getHeight() || this.centerY() < 0)
		{
			if(this.centerY() > canvas.getHeight())
			{
		            Global.cScore++;
			}
			if(this.centerY() < 0)
			{
				Global.mScore++;
			}
			return true;
		}
		else 
			return false;
	}
	
	public boolean hitwall(Canvas canvas)
	{
		if(this.positionxright() > canvas.getWidth()  || this.positionx() < 0)
			return true;
		else 
			return false;
	}
}

