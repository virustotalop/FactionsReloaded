package me.virustotal.factionsreloaded.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class FBaseCommand implements CommandExecutor {
	
	private String cmd = "f";
	
	public FBaseCommand()
	{
		
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) 
	{
	
		
		
		return false;
	}
	
	public String getCmd()
	{
		return this.cmd;
	}

}
