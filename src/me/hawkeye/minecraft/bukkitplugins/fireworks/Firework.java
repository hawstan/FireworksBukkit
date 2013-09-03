package me.hawkeye.minecraft.bukkitplugins.fireworks;

public class Firework
{
	private float x;
	private float y;
	private float z;
	
	public Firework(float x, float y, float z)
	{
		this.x = x;
		this.y = y;
		this.z = z;
	}
	
	public float x()
	{
		return x;
	}

	public float y()
	{
		return y;
	}
	
	public float z()
	{
		return z;
	}
}