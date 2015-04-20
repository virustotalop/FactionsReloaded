package me.virustotal.FactionsReloaded.Listeners;

import me.virustotal.FactionsReloaded.Objects.FPlayer;
import me.virustotal.FactionsReloaded.Utils.FPlayerUtil;
import me.virustotal.FactionsReloaded.Utils.FactionUtil;

import org.bukkit.Chunk;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.block.BlockPlaceEvent;

public class FactionBuildListener {
	
	@EventHandler
	public void build(BlockPlaceEvent e)
	{
		Player player = e.getPlayer();
		FPlayer fPlayer = FPlayerUtil.getFPlayer(player);
		Chunk chunk = e.getBlock().getChunk();
		if(!FactionUtil.canBuild(fPlayer, chunk.getX(), chunk.getZ())) //or if player has bypass
		{
			e.setCancelled(true);
		}
	}

}
