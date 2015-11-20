package me.virustotal.factionsreloaded.commands.subcommands;

import org.bukkit.command.CommandSender;

import me.virustotal.factionsreloaded.commands.SubCommand;

public class HelpCommand extends SubCommand {
	
	@Override
	public void execute(CommandSender sender, String[] args)
	{
		for(SubCommand subCommand : SubCommand.subCommands)
		{
			
		}
	}
	
	@Override
	public String usage()
	{
		return "/f help <page #>";
	}
}