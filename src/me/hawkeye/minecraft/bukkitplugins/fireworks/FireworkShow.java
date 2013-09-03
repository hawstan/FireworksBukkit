package me.hawkeye.minecraft.bukkitplugins.fireworks;

import org.bukkit.Bukkit;
import org.bukkit.Location;

public class FireworkShow
{
	private static Location baseLocation;
	
	private static int taskId = 0;
	
	private static int dx = 0;
	
	private static int dz = 0;
	
	public static void setBaseLocation(Location loc)
	{
		baseLocation = loc;
	}
	
	public static void setDX(int newdx)
	{
		dx = newdx;
	}
	
	public static void setDZ(int newdz)
	{
		dz = newdz;
	}
	
	public static void start()
	{
		stop();
		
		taskId = Bukkit.getScheduler().scheduleSyncRepeatingTask(FireworksPlugin.getInstance(), new Runnable(){
			public void run()
			{
				float x = Rnd.get(2*dx) - dx - 1 + (float)Rnd.getDouble();
				float y = 5;
				float z = Rnd.get(2*dz) - dz - 1 + (float)Rnd.getDouble();
				Fireworks.fire(baseLocation, new Firework(x,y,z));
			}
		},2,10);
	}
	
	public static void stop()
	{
		Bukkit.getScheduler().cancelTask(taskId);
	}
}
