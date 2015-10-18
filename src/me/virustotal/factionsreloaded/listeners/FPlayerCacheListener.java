package me.virustotal.factionsreloaded.listeners;

import java.util.UUID;

import me.virustotal.factionsreloaded.ConfigHandler;
import me.virustotal.factionsreloaded.FactionsReloaded;
import me.virustotal.factionsreloaded.objects.FPlayer;
import me.virustotal.factionsreloaded.objects.Faction;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

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
		UUID uuid = player.getUniqueId();
		
		boolean contains = false;
		for(FPlayer fPlayer : FPlayer.getFPlayers())
		{
			if(fPlayer.getUUID().equals(uuid))
			{
				contains = true;
				fPlayer.setLastKnownName(player.getName());
				break;
			}
		}
		
		if(!contains)
		{
			FPlayer.getFPlayers().add(new FPlayer(player.getUniqueId(), ConfigHandler.startingPlayerPower, Faction.getFactionByName("wilderness"), player.getName()));
		}
	}
}
