package me.virustotal.factionsreloaded.commands;

import me.virustotal.factionsreloaded.ConfigHandler;
import me.virustotal.factionsreloaded.FactionsReloaded;
import me.virustotal.factionsreloaded.objects.FPlayer;
import me.virustotal.factionsreloaded.utils.FPlayerUtil;

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
