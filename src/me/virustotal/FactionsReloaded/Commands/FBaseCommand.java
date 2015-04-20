package me.virustotal.FactionsReloaded.Commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class FBaseCommand implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label,String[] args) {
		
		if(label.equalsIgnoreCase("f"))
		{
			if(args.length == 0)
			{
				
			}
		}
		
		
		return false;
	}

	
	
}
