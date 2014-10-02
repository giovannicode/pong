package com.pong2;

public  class Global
{
	static int bpx = 147;
	static int bpy = 227;
	static int bXspeed = 2;
	static int bYspeed = 5;
	
	static int cpx = 110;
	static int cpy = 25;
	static int cSpeed = 5;
	
	static int mpx = 110;
	static int mpy = 430;
	
	static int cScore = 0;
	static int mScore = 0;
	
	//From Settings
	static int scSpeed = 5;
	static int sbXspeed = 2;
	static int sbYspeed = 5;
	
	public static void getSettings()
	{
		cSpeed = scSpeed; 
		bXspeed = sbXspeed;
		bYspeed = sbYspeed;	
	}
	
	public static void Reset()
	{
		  bpx = 147;
		  bpy = 227;
		  bXspeed = 3;	
		  bYspeed = 5;
		  
		  cpx = 110;
		  cpy = 25;
		  cSpeed = 5;			
	      mpx = 110;
		  mpy = 430;
		  
		  
	}
	
	
}
