package me.virustotal.FactionsReloaded.Commands;

import org.apache.commons.lang.math.NumberUtils;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class FBaseCommand implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label,String[] args) {
		
		if(label.equalsIgnoreCase("f"))
		{
			Player player = (Player)sender;
			if(args.length == 0)
			{
				return FHelp.doCommand(player);
			}
			else if(args.length == 1)
			{
				String arg = args[0];
				if(NumberUtils.isNumber(arg))
				{
					return FHelp.doCommandWithArg(player,arg);
				}
				else if(arg.equalsIgnoreCase("help"))
				{
					return FHelp.doCommand(player);
				}
				else if(arg.equalsIgnoreCase("claim"))
				{
					
				}
				else if(arg.equalsIgnoreCase("join"))
				{
					return FJoin.doCommand(player);
				}
				else if(arg.equalsIgnoreCase("invite"))
				{
					return FInvite.doCommand(player);
				}
				else if(arg.equalsIgnoreCase("deinvite"))
				{
					return FDeinvite.doCommand(player);
				}
				else if(arg.equalsIgnoreCase("close"))
				{
					
				}
				else if(arg.equalsIgnoreCase("tag"))
				{
					return FTag.doCommand(player);
				}
				else if(arg.equalsIgnoreCase("warp"))
				{
					return FWarp.doCommand(player);
				}
				else if(arg.equalsIgnoreCase("setwarp"))
				{
					return FSetWarp.doCommand(player);
				}
			}
			else if(args.length == 2)
			{
				String arg1 = args[0];
				String arg2 = args[1];
				if(arg1.equalsIgnoreCase("help") && NumberUtils.isNumber(arg2))
				{
					return FHelp.doCommandWithArg(player,arg2);
				}
				else if(arg1.equalsIgnoreCase("tag"))
				{
					return FTag.doCommandWithArgs(player, arg2);
				}
				else if(arg1.equalsIgnoreCase("join"))
				{
					return FJoin.doCommandWithArgs(player, arg2);
				}
				else if(arg1.equalsIgnoreCase("warp"))
				{
					return FWarp.doCommandWithArgs(player, arg2);
				}
				else if(arg1.equalsIgnoreCase("setwarp"))
				{
					return FSetWarp.doCommandWithArgs(player, arg2);
				}
			}
		}
		
		
		return false;
	}

	
	
}
