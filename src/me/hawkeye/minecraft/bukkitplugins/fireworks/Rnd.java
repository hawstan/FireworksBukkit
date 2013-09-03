package me.hawkeye.minecraft.bukkitplugins.fireworks;

import java.util.Random;

public class Rnd
{
	private static final Random random = new Random(System.currentTimeMillis());

	public static int nextInt()
	{
		return random.nextInt();
	}
	
	public static boolean getBool()
	{
		return random.nextBoolean();
	}

	public static int get(int max)
	{
		return random.nextInt(max);
	}

	public static double getDouble()
	{
		return random.nextDouble();
	}
}
