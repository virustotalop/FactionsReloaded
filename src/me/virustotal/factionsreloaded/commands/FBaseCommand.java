package me.virustotal.factionsreloaded.commands;

import java.util.Arrays;
import java.util.List;

import me.virustotal.factionsreloaded.ConfigHandler;
import me.virustotal.factionsreloaded.Messages;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class FBaseCommand implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) 
	{
		if(args == null || args.length == 0)
		{
			SubCommand.getSubCommandByName("help").execute(sender, null);
			return true;
		}
		
		if(args.length >= 1)
		{
			if(SubCommand.getSubCommandByName(args[0]) == null)
			{
				sender.sendMessage(ConfigHandler.prefix + Messages.fCommandDoesNotExist);
				return true;
			}
			else
			{
				List<String> listArgs = Arrays.asList(args);
				String[] newArgs = null;
				if(listArgs.size() > 1)
				{	
					listArgs.remove(0);
					newArgs = listArgs.toArray(new String[listArgs.size()]);
				}
				SubCommand.getSubCommandByName(args[0]).execute(sender, newArgs);
				return true;
			}
		}
		return false;
	}
}