package me.virustotal.factionsreloaded.listeners;

import me.virustotal.factionsreloaded.ConfigHandler;
import me.virustotal.factionsreloaded.FactionsReloaded;
import me.virustotal.factionsreloaded.objects.FPlayer;
import me.virustotal.factionsreloaded.objects.Faction;

import org.bukkit.Chunk;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.player.PlayerInteractEvent;

public class FactionInteractionsListener implements Listener {

	private FactionsReloaded plugin;
	public FactionInteractionsListener(FactionsReloaded plugin)
	{
		this.plugin = plugin;
	}
	
	@EventHandler
	public void blockBuild(BlockPlaceEvent e)
	{
		Player player = e.getPlayer();
		FPlayer fPlayer = FPlayer.getFPlayer(player);
		Chunk chunk = e.getBlock().getChunk();
		if(!Faction.canBuild(fPlayer, chunk.getX(), chunk.getZ()))
		{
			e.setCancelled(true);
		}
	}

	@EventHandler
	public void blockBreak(BlockBreakEvent e)
	{
		Player player = e.getPlayer();
		FPlayer fPlayer = FPlayer.getFPlayer(player);
		Chunk chunk = e.getBlock().getChunk();
		if(!Faction.canBuild(fPlayer, chunk.getX(), chunk.getZ()))
		{
			e.setCancelled(true);
		}
	}

	@EventHandler
	public void blockInteract(PlayerInteractEvent e)
	{
		if(ConfigHandler.blockAny)
		{
			if(e.getAction() == Action.RIGHT_CLICK_BLOCK)
			{
				Player player = e.getPlayer();
				FPlayer fPlayer = FPlayer.getFPlayer(player);
				Chunk chunk = e.getClickedBlock().getChunk();
				if(!Faction.canBuild(fPlayer, chunk.getX(), chunk.getZ()))
				{
					if(ConfigHandler.blockedContainers.contains(e.getClickedBlock().getType().name()))
					{
						e.setCancelled(true);
					}
				}
			}
		}
	}
}
