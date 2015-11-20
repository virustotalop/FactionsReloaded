package me.virustotal.factionsreloaded.commands;

import java.util.ArrayList;

import org.bukkit.command.CommandSender;
public class SubCommand {
	
	private String cmd = "";
	protected static ArrayList<SubCommand> subCommands = new ArrayList<SubCommand>();
	public SubCommand()
	{
		
	}
	
	public void execute(CommandSender sender, String[] args)
	{
		
	}
	
	public String getCmd()
	{
		return this.cmd;
	}
	
	public void setCmd(String cmd)
	{
		this.cmd = cmd;
	}
	
	public String usage()
	{
		return "";
	}
	
	public static SubCommand getSubCommandByName(String subCommand)
	{
		for(SubCommand subCmd : subCommands)
		{
			if(subCommand.equals(subCmd.getCmd()))
				return subCmd;
		}
		return null;
	}
}
