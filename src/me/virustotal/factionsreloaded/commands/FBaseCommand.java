package me.virustotal.factionsreloaded.commands;

import java.util.ArrayList;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class FBaseCommand implements CommandExecutor {
	
	public FBaseCommand()
	{
		
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) 
	{
		
		if(args == null)
		{
			SubCommand.getSubCommandByName("help").execute(sender, null);
		}
		
		if(args.length == 1)
		{
			for(SubCommand subCommand : SubCommand.subCommands)
			{
				
			}
		}
		
		
		return false;
	}

}
