package me.virustotal.FactionsReloaded.Listeners;

import me.virustotal.FactionsReloaded.Objects.FPlayer;
import me.virustotal.FactionsReloaded.Objects.Faction;
import me.virustotal.FactionsReloaded.Utils.FPlayerUtil;
import me.virustotal.FactionsReloaded.Utils.FactionUtil;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class ChatTagListener implements Listener {
	
	@EventHandler
	public void chat(AsyncPlayerChatEvent e)
	{
		FPlayer fPlayer = FPlayerUtil.getFPlayer(e.getPlayer());
		Faction fac = FactionUtil.getFactionByName(fPlayer.getFaction());
		String tag = fac.getTag();
		e.setMessage(tag + " " + e.getFormat() + " " + e.getMessage());
	}

}
