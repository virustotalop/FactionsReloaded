package me.virustotal.factionsreloaded.commands.subcommands;

import org.bukkit.command.CommandSender;

import me.virustotal.factionsreloaded.Messages;
import me.virustotal.factionsreloaded.commands.SubCommand;

public class HelpCommand extends SubCommand {

	@Override
	public void execute(CommandSender sender, String[] args)
	{
		if(args == null)
		{
			int count = 1;
			for(SubCommand subCommand : SubCommand.subCommands)
			{
				if(!(subCommand.getCmd().equals("help")))
				{
					sender.sendMessage(Messages.fHelpMenuFormat.replace("%index%", "" + (count)).replace("%usage%", subCommand.usage()));
					count += 1;
				}
				if(count == 6)
					break;
			}
		}
	}

	@Override
	public String usage()
	{
		return "/f help <page #>";
	}
}