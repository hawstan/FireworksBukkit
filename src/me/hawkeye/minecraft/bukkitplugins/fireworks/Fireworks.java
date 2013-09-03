package me.hawkeye.minecraft.bukkitplugins.fireworks;

import org.bukkit.Color;
import org.bukkit.FireworkEffect;
import org.bukkit.Location;
import org.bukkit.craftbukkit.v1_6_R2.entity.CraftFirework;
import org.bukkit.entity.EntityType;
import org.bukkit.inventory.meta.FireworkMeta;

public class Fireworks
{	
	public static void spawnRandomFirework(Location loc,int power,int effectCount)
	{
		CraftFirework firework = (CraftFirework) loc.getWorld().spawnEntity(loc, EntityType.FIREWORK);
		FireworkMeta data = firework.getFireworkMeta();
		data.setPower(power);
		while(effectCount-- > 0)
			data.addEffect(createRandomFireworkEffect());
		firework.setFireworkMeta(data);
	}
	
	public static FireworkEffect createRandomFireworkEffect()
	{		
		FireworkEffect.Builder builder = FireworkEffect.builder();
		builder = builder.flicker(Rnd.getBool());
		builder = builder.trail(Rnd.getBool());
		builder = builder.withColor(Color.fromRGB(Rnd.get(256), Rnd.get(256), Rnd.get(256)));
		if(Rnd.getBool())
			builder = builder.withFade(Color.fromRGB(Rnd.get(256), Rnd.get(256), Rnd.get(256)));
		FireworkEffect.Type[] effectTypes = FireworkEffect.Type.values();
		builder = builder.with(effectTypes[Rnd.get(effectTypes.length)]);
		return builder.build();
	}

	public static synchronized void fire(Location baseLoc, final Firework firework)
	{
		final Location newLoc = baseLoc.clone();
		newLoc.add(firework.x(), firework.y(), firework.z());
		spawnRandomFirework(newLoc, Rnd.get(2)+1, Rnd.get(4)+1);
	}
}
