package me.virustotal.factionsreloaded.listeners;

import me.virustotal.factionsreloaded.ConfigHandler;
import me.virustotal.factionsreloaded.FactionCache;
import me.virustotal.factionsreloaded.FactionsReloaded;
import me.virustotal.factionsreloaded.Messages;
import me.virustotal.factionsreloaded.objects.FPlayer;
import me.virustotal.factionsreloaded.objects.Faction;

import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class FactionChatListener implements Listener {

	private FactionsReloaded plugin;
	
	public FactionChatListener(FactionsReloaded plugin)
	{
		this.plugin = plugin;	
	}
	
	@EventHandler
	public void chat(AsyncPlayerChatEvent e)
	{
		FPlayer fPlayer = FPlayer.getFPlayer(e.getPlayer());
		
		if(!fPlayer.getFaction().equals("none"))
		{
			if(!FactionCache.fChatPlayers.contains(e.getPlayer().getUniqueId()))
			{
				Faction fac = Faction.getFactionByName(fPlayer.getFaction());
				String tag = fac.getTag(); //make sure to add brackets
				String formattedMsg = Messages.fTagFormat.replace("{message}", e.getMessage());
				formattedMsg = formattedMsg.replace("{tag}", tag);
				e.setMessage(formattedMsg);
			}
			else
			{
				Faction fac = Faction.getFactionByName(fPlayer.getFaction());
				e.getRecipients().clear();
				for(String string : fac.getMembers())
				{
					if(Bukkit.getPlayer(string) != null)
					e.getRecipients().add(Bukkit.getPlayer(string));
				}
				e.setMessage(ConfigHandler.fChatFormat.replace("{message}", e.getMessage()));
			}
		}
	}
}
