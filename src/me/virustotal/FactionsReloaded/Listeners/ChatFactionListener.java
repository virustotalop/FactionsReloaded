package me.virustotal.FactionsReloaded.Listeners;

import me.virustotal.FactionsReloaded.ConfigHandler;
import me.virustotal.FactionsReloaded.FactionsReloaded;
import me.virustotal.FactionsReloaded.Objects.FPlayer;
import me.virustotal.FactionsReloaded.Objects.Faction;
import me.virustotal.FactionsReloaded.Utils.FPlayerUtil;
import me.virustotal.FactionsReloaded.Utils.FactionUtil;

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
