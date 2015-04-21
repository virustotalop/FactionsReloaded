package me.virustotal.FactionsReloaded.Commands;

import me.virustotal.FactionsReloaded.ConfigHandler;
import me.virustotal.FactionsReloaded.Objects.FPlayer;
import me.virustotal.FactionsReloaded.Utils.FPlayerUtil;

import org.bukkit.entity.Player;

public class FInvite {
	
	public static boolean doCommand(Player player)
	{
		FPlayer fPlayer = FPlayerUtil.getFPlayer(player);
		if(fPlayer.getFaction().equals("none"))
		{
			player.sendMessage(ConfigHandler.fInviteNoFaction);
			return true;
		}
		player.sendMessage(ConfigHandler.fInviteNoArgs);
		return true;
	}

}
