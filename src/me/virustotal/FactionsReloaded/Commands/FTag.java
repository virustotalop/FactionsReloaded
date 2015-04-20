package me.virustotal.FactionsReloaded.Commands;

import java.util.ArrayList;

import me.virustotal.FactionsReloaded.ConfigHandler;
import me.virustotal.FactionsReloaded.FactionsReloaded;
import me.virustotal.FactionsReloaded.Objects.FPlayer;
import me.virustotal.FactionsReloaded.Objects.Faction;

import me.virustotal.FactionsReloaded.Utils.FPlayerUtil;
import me.virustotal.FactionsReloaded.Utils.FactionUtil;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public class FTag {
	
	public static boolean doCommand(Player player)
	{
		player.sendMessage(ConfigHandler.fTagNoArgs);
		return true;
	}
	
	public static boolean doCommandWithArgs(Player player, String arg)
	{
		FPlayer fPlayer = FPlayerUtil.getFPlayer(player);
		Faction pFac = FactionUtil.getFactionByName(fPlayer.getFaction());
		
		if(pFac.getName().equalsIgnoreCase("none"))
		{
			player.sendMessage(ConfigHandler.cannotDoFtagNoFaction);
			return true;
		}
		
		String group = FactionUtil.getGroup(fPlayer);
		if(!group.equals("admin"))
		{
			player.sendMessage(ConfigHandler.cannotDoFTagNotCorrectGroup);
			return true;
		}
		
		ArrayList<Faction> factions = FactionsReloaded.get().factions;
		for(Faction fac : factions)
		{
			if(fac.getName().equals(ChatColor.stripColor(ChatColor.translateAlternateColorCodes('&', arg))))
			{
				player.sendMessage(ConfigHandler.fTagInUse);
				return true;
			}
		}
		
		String tag = ChatColor.translateAlternateColorCodes('&', arg);
		String name = ChatColor.stripColor(tag);
		
		if(name.length() > ConfigHandler.maxFactionTagSize)
		{
			player.sendMessage(ConfigHandler.fTagTooLong.replace("{length}","" + ConfigHandler.maxFactionTagSize));
			return true;
		}
		
		pFac.setTag(tag);
		pFac.setName(name);
		
		//Make sure all caches/lists are updated
		FactionsReloaded.get().factions.remove(pFac);
		FactionsReloaded.get().factions.add(pFac);
		FactionUtil.saveFactionToFile(pFac);
		return true;
	}

}
