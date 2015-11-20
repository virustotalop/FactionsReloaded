package me.virustotal.factionsreloaded.commands.subcommands;

import me.virustotal.factionsreloaded.commands.SubCommand;

import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class JoinCommand extends SubCommand {
	
	@Override
	public void execute(CommandSender sender, String[] args)
	{
		if(!(sender instanceof Player))
			return;
	}

}
