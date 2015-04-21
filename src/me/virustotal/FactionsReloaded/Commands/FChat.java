package me.virustotal.FactionsReloaded.Commands;

import me.virustotal.FactionsReloaded.ConfigHandler;
import me.virustotal.FactionsReloaded.FactionsReloaded;
import me.virustotal.FactionsReloaded.Objects.FPlayer;
import me.virustotal.FactionsReloaded.Utils.FPlayerUtil;

import org.bukkit.entity.Player;

public class FChat {
	
	public static boolean doCommand(Player player)
	{
		FactionsReloaded plugin = FactionsReloaded.get();
		FPlayer fPlayer = FPlayerUtil.getFPlayer(player);
		
		if(fPlayer.getFaction().equals("none"))
		{
			player.sendMessage(ConfigHandler.fChatNoFaction);
			return true;
		}
		
		if(plugin.factionChat.contains(player.getName()))
		{
			player.sendMessage(ConfigHandler.fChatOff);
			plugin.factionChat.remove(player.getName());
			return true;
		}
		else
		{
			player.sendMessage(ConfigHandler.fChatOn);
			plugin.factionChat.add(player.getName());
			return true;
		}
	}

}
