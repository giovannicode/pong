package com.pong2;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.content.Intent;
import android.util.Log;

public class Pong2Activity extends Activity 
{
	Button newGame;
	Button highscore;
	Button settings;
	Button exit;
	
	private void log(String text)
	{
		Log.d("MainMenu", text);
	}
	
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState)
    {  
        super.onCreate(savedInstanceState);     
        setContentView(R.layout.mainmenu);
        
        newGame = (Button) findViewById(R.id.playgame);   
        newGame.setOnClickListener(new View.OnClickListener() 
        {	
			@Override
			public void onClick(View v) 
			{
				// TODO Auto-generated method stub
				Intent intent = new Intent(Pong2Activity.this,RenderingActivity.class);
				startActivity(intent);
				
			}
		});
        
        settings = (Button) findViewById(R.id.settings);
        settings.setOnClickListener(new View.OnClickListener()
        {
        	@Override
        	public void onClick(View v)
        	{
        		
        		/*try
        		{
        			Thread.sleep(6000);
        		}
        		catch(Exception e)
        		{
        			
        		}*/
        		Intent intent = new Intent(Pong2Activity.this, Settings.class);
        		startActivity(intent);
        	}
    
        });
        
        log("Created");
        
        
    }
    
    @Override
    protected void onResume()
    {
    	super.onResume();
    	log("Resumed");
    }
    
    @Override
    protected void onPause()
    {
    	super.onPause();
    	log("Paused");
    	
    	if(isFinishing())
    	{
    		log("Finishin");
    	}
    }

}