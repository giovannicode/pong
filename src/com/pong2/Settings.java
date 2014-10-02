package com.pong2;

import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import android.widget.Button;

public class Settings extends Activity
{
	int difiCount = 0;
	int paddCount = 1;
	int speeCount = 0;
	
	TextView difficulty;
	TextView paddleSize;
	TextView gameSpeed;
	
	Button minusDifficulty;
	Button plusDifficulty;
	Button minusPaddleSize;
	Button plusPaddleSize;
	Button minusGameSpeed;
	Button plusGameSpeed;
	
	TextView difficultySetting;
	TextView paddleSizeSetting;
	TextView gameSpeedSetting;
	
	@Override
	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);	
		setContentView(R.layout.settings);
		
		difficulty = (TextView) findViewById(R.id.difficulty);
		paddleSize = (TextView) findViewById(R.id.paddleSize);
		gameSpeed= (TextView) findViewById(R.id.gameSpeed);
		
		minusDifficulty = (Button) findViewById(R.id.minusDifficulty);
		minusPaddleSize = (Button)  findViewById(R.id.minusPaddleSize);
		minusGameSpeed= (Button)  findViewById(R.id.minusGameSpeed);
		
		difficultySetting = (TextView) findViewById(R.id.difficultySetting);
		paddleSizeSetting = (TextView)findViewById(R.id.paddleSizeSetting);
		gameSpeedSetting = (TextView) findViewById(R.id.gameSpeedSetting);
		
		
		plusDifficulty= (Button) findViewById(R.id.plusDifficulty);
		plusPaddleSize = (Button) findViewById(R.id.plusPaddleSize);
		plusGameSpeed = (Button) findViewById(R.id.plusGameSpeed);
		
		minusDifficulty.setOnClickListener(new View.OnClickListener() 
		{
			
			@Override
			public void onClick(View v) 
			{
				// TODO Auto-generated method stub
				difiCount--;
				if(difiCount < 0)
				{
					difiCount = 0;
				}
				
				if(difiCount==1)
				{
					difficultySetting.setText("Hard");
					Global.scSpeed = 10;
				}
							
				if(difiCount == 0)
				{
				   difficultySetting.setText("Normal");
				   Global.scSpeed = 5;
				}
				
			}
		});
		
		plusDifficulty.setOnClickListener(new View.OnClickListener() 
		{
			
			@Override
			public void onClick(View v)
			{
				// TODO Auto-generated method stub
				difiCount++;
				if(difiCount > 2)
				{
					difiCount = 2;
				}
				
				if(difiCount==1)
				{
					difficultySetting.setText("Hard");
					Global.scSpeed = 10;
				}
				
				if(difiCount == 2)
				{
				   difficultySetting.setText("Hardest");
				   Global.scSpeed = 20;
				}
				
			}
		});
		
		minusPaddleSize.setOnClickListener(new View.OnClickListener() 
		{
			
			@Override
			public void onClick(View v) 
			{
				// TODO Auto-generated method stub
				paddCount--;
				if(paddCount < 0)
				{
					paddCount = 0;
				}
				
				if(paddCount==1)
				{
					paddleSizeSetting.setText("Medium");
				   Paddle.width = 100;
				}
							
				if(paddCount == 0)
				{
				   paddleSizeSetting.setText("Small");
				   Paddle.width = 50;
				}
				
			}
		});
		
		plusPaddleSize.setOnClickListener(new View.OnClickListener() 
		{
			
			@Override
			public void onClick(View v) 
			{
				// TODO Auto-generated method stub
				paddCount++;
				if(paddCount > 2)
				{
					paddCount = 2;
				}
				
				if(paddCount==1)
				{
					paddleSizeSetting.setText("Medium");
				   Paddle.width = 100;
				}
							
				if(paddCount == 2)
				{
				   paddleSizeSetting.setText("Large");
				   Paddle.width = 150;
				}
				
			}
		});
		
		minusGameSpeed.setOnClickListener(new View.OnClickListener() 
		{
			
			@Override
			public void onClick(View v) 
			{
				// TODO Auto-generated method stub
				speeCount--;
				if(speeCount < 0)
				{
					speeCount = 0;
				}
				
				if(speeCount == 1)
				{
					gameSpeedSetting.setText("Fast");
					Global.sbYspeed = 10;
					
				}
				
				if(speeCount == 0)
				{
					gameSpeedSetting.setText("Normal");
					Global.sbYspeed = 5;

				}
				
				
				
			}
		});
		
		plusGameSpeed.setOnClickListener(new View.OnClickListener()
		{
			@Override
			public void onClick(View v)
			{
				 //TODO auto-generated method stub
				speeCount++;
				if(speeCount > 2)
				{
					speeCount = 2;
				}
				
				if(speeCount == 1)
				{
					gameSpeedSetting.setText("Fast");
					Global.sbYspeed = 10;

				}
				
				if(speeCount == 2)
				{
					gameSpeedSetting.setText("Fastest");
					Global.sbYspeed = 20;		
				}
				
			}
			
		});
		
	}

}
