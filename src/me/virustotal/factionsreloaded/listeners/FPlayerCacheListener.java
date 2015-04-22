package me.virustotal.factionsreloaded.listeners;

import java.util.ArrayList;

import me.virustotal.factionsreloaded.FactionsReloaded;
import me.virustotal.factionsreloaded.objects.FPlayer;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerKickEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class FPlayerCacheListener implements Listener {
	
	private FactionsReloaded plugin;
	public FPlayerCacheListener(FactionsReloaded plugin)
	{
		this.plugin = plugin;
	}
	
	@EventHandler
	public void onJoin(PlayerJoinEvent e)
	{	
		Player player = e.getPlayer();
		String pName = player.getName();
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
		
		FPlayer newPlayer = new FPlayer(player.getUniqueId(),plugin.config.startingPlayerPower,"none");
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
