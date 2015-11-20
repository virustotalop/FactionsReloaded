package me.virustotal.factionsreloaded.listeners;

import java.util.UUID;

import me.virustotal.factionsreloaded.ConfigHandler;
import me.virustotal.factionsreloaded.FactionsReloaded;
import me.virustotal.factionsreloaded.Messages;
import me.virustotal.factionsreloaded.objects.FPlayer;
import me.virustotal.factionsreloaded.objects.Faction;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class FactionChatListener implements Listener {

	private FactionsReloaded plugin;

	public FactionChatListener(FactionsReloaded plugin)
	{
		this.plugin = plugin;	
	}

	@EventHandler(priority = EventPriority.HIGHEST)
	public void chat(AsyncPlayerChatEvent e)
	{
		if(e.getRecipients().size() > 0)
		{
			FPlayer fPlayer = FPlayer.getFPlayer(e.getPlayer());

			if(!fPlayer.getFaction().equals("none"))
			{
				if(!FPlayer.getFPlayer(e.getPlayer()).getFChatEnabled())
				{
					Faction fac = fPlayer.getFaction();
					String tag = fac.getTag(); //make sure to add brackets
					String formattedMsg = Messages.fTagFormat.replace("%message%", e.getMessage());
					formattedMsg = formattedMsg.replace("%tag%", tag);
					e.setMessage(formattedMsg);
				}
				else
				{
					Faction fac = fPlayer.getFaction();
					e.getRecipients().clear();
					for(UUID uuid : fac.getMembers())
					{
						Player p = Bukkit.getPlayer(uuid);
						if(p != null)
							e.getRecipients().add(p);
					}
					e.setMessage(ConfigHandler.fChatFormat.replace("%message%", e.getMessage()));
				}
			}
		}
	}
}
