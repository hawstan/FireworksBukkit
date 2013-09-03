package me.hawkeye.minecraft.bukkitplugins.fireworks;

import java.util.logging.Logger;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class FireworksPlugin extends JavaPlugin
{
	public FireworksPlugin()
	{
		instance = this;
	}
	
	public void onEnable() 
	{
		log.info("Fireworks plugin enabled.");
	}

	public void onDisable() 
	{
		log.info("Fireworks plugin disabled.");
		FireworkShow.stop();
	}
	
	public final Logger log = Logger.getLogger("Minecraft");
	
	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args)
	{
		if(cmd.getName().equalsIgnoreCase("firework") && sender.hasPermission("fireworks.firework"))
		{
			if(sender instanceof Player)
			{
				int count = 1;
				if(args.length > 0)
					count = Integer.parseInt(args[0]);
				while(count-- > 0)
					Fireworks.spawnRandomFirework(((Player) sender).getLocation(),3,5);
			}
			else
			{
				sender.sendMessage("/firework can only be used as a player");
				return false;
			}
		}
		else if(cmd.getName().equalsIgnoreCase("fs") && sender.hasPermission("fireworks.show"))
		{
			if(args.length > 0)
			{
				if(args[0].equals("loc"))
				{
					if(sender instanceof Player)
					{
						FireworkShow.setBaseLocation(((Player)sender).getLocation());
						sender.sendMessage("Location set");
					}
					else
					{
						sender.sendMessage("Firework show location can only be set as a player");
						return false;
					}
				}
				else if(args[0].equals("dx") && args.length > 1)
				{
					FireworkShow.setDX(Integer.parseInt(args[1]));
					sender.sendMessage("DX set");
				}
				else if(args[0].equals("dz") && args.length > 1)
				{
					FireworkShow.setDZ(Integer.parseInt(args[1]));
					sender.sendMessage("DZ set");
				}
				else if(args[0].equals("start"))
				{
					FireworkShow.start();
					sender.sendMessage("Show started");
				}
				else if(args[0].equals("stop"))
				{
					FireworkShow.stop();
					sender.sendMessage("Show stopped");
				}
			}
			else
				sender.sendMessage(new String[]{
					"/fs loc",
					"/fs dx",
					"/fs dy",
					"/fs start",
					"/fs stop",
				});
			return true;
		}
		return false;
	}

	private static FireworksPlugin instance;
	
	public static FireworksPlugin getInstance() {
		return instance;
	}
}
