package me.virustotal.FactionsReloaded.Listeners;

import me.virustotal.FactionsReloaded.ConfigHandler;
import me.virustotal.FactionsReloaded.Objects.FPlayer;
import me.virustotal.FactionsReloaded.Utils.FPlayerUtil;
import me.virustotal.FactionsReloaded.Utils.FactionUtil;

import org.bukkit.Chunk;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.player.PlayerInteractEvent;

public class FactionInteractionsListener {

	@EventHandler
	public void blockBuild(BlockPlaceEvent e)
	{
		Player player = e.getPlayer();
		FPlayer fPlayer = FPlayerUtil.getFPlayer(player);
		Chunk chunk = e.getBlock().getChunk();
		if(!FactionUtil.canBuild(fPlayer, chunk.getX(), chunk.getZ()))
		{
			e.setCancelled(true);
		}
	}

	@EventHandler
	public void blockBreak(BlockBreakEvent e)
	{
		Player player = e.getPlayer();
		FPlayer fPlayer = FPlayerUtil.getFPlayer(player);
		Chunk chunk = e.getBlock().getChunk();
		if(!FactionUtil.canBuild(fPlayer, chunk.getX(), chunk.getZ()))
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
				FPlayer fPlayer = FPlayerUtil.getFPlayer(player);
				Chunk chunk = e.getClickedBlock().getChunk();
				if(!FactionUtil.canBuild(fPlayer, chunk.getX(), chunk.getZ()))
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