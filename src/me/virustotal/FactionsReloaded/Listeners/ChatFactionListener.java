package me.virustotal.factionsreloaded.listeners;

import me.virustotal.factionsreloaded.ConfigHandler;
import me.virustotal.factionsreloaded.FactionsReloaded;
import me.virustotal.factionsreloaded.objects.FPlayer;
import me.virustotal.factionsreloaded.objects.Faction;
import me.virustotal.factionsreloaded.utils.FPlayerUtil;
import me.virustotal.factionsreloaded.utils.FactionUtil;

import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class ChatFactionListener implements Listener {

	@EventHandler
	public void chat(AsyncPlayerChatEvent e)
	{
		FPlayer fPlayer = FPlayerUtil.getFPlayer(e.getPlayer());
		if(!fPlayer.getFaction().equals("none"))
		{
			if(!FactionsReloaded.get().factionChat.contains(e.getPlayer().getName()))
			{
				Faction fac = FactionUtil.getFactionByName(fPlayer.getFaction());
				String tag = fac.getTag(); //make sure to add brackets
				String formattedMsg = ConfigHandler.fTagFormat.replace("{message}", e.getMessage());
				formattedMsg = formattedMsg.replace("{tag}", tag);
				e.setMessage(formattedMsg);
			}
			else
			{
				Faction fac = FactionUtil.getFactionByName(fPlayer.getFaction());
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
