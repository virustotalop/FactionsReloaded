package me.virustotal.factionsreloaded.commands.subcommands;

import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.virustotal.factionsreloaded.commands.SubCommand;

public class ModCommand extends SubCommand {
	
	@Override
	public void execute(CommandSender sender, String[] args)
	{
		if(!(sender instanceof Player))
			return;
	}

}
