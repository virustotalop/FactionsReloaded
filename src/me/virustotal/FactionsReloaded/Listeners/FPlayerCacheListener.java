package me.virustotal.FactionsReloaded.Listeners;

import java.util.ArrayList;

import me.virustotal.FactionsReloaded.ConfigHandler;
import me.virustotal.FactionsReloaded.FactionsReloaded;
import me.virustotal.FactionsReloaded.Objects.FPlayer;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerKickEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class FPlayerCacheListener {
	
	
	@EventHandler
	public void onJoin(PlayerJoinEvent e)
	{
		
		Player player = e.getPlayer();
		String pName = player.getName();
		FactionsReloaded plugin = FactionsReloaded.get();
		ArrayList<FPlayer> fPlayers = plugin.fPlayers;
		
		if(plugin.fPlayerCache.containsKey(pName))
		{
			plugin.fPlayerCache.remove(pName);
		}
		
		for(FPlayer fPlayer : fPlayers)
		{
			if(fPlayer.getUUID().equals(player.getUniqueId()))
			{
				plugin.fPlayerCache.put(pName, fPlayer);
				return;
			}
		}
		
		FPlayer newPlayer = new FPlayer(player.getUniqueId(),ConfigHandler.startingPlayerPower,"none");
		plugin.fPlayerCache.put(pName, newPlayer);
		plugin.fPlayers.add(newPlayer);
		/* Set player in the player config file
		 */
	}
	
	@EventHandler
	public void onLeave(PlayerQuitEvent e)
	{
		Player player = e.getPlayer();
		String pName = player.getName();
		
		FactionsReloaded plugin = FactionsReloaded.get();
		
		if(plugin.fPlayerCache.containsKey(pName))
		{
			plugin.fPlayerCache.remove(pName);
		}
	}
	
	@EventHandler
	public void onKick(PlayerKickEvent e)
	{
		Player player = e.getPlayer();
		String pName = player.getName();
		
		FactionsReloaded plugin = FactionsReloaded.get();
		
		if(plugin.fPlayerCache.containsKey(pName))
		{
			plugin.fPlayerCache.remove(pName);
		}
	}

}
