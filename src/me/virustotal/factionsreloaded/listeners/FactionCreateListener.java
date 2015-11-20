package me.virustotal.factionsreloaded.listeners;

import me.virustotal.factionsreloaded.Messages;
import me.virustotal.factionsreloaded.customevents.FactionCreateEvent;
import me.virustotal.factionsreloaded.objects.FPlayer;
import me.virustotal.factionsreloaded.objects.Faction;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

public class FactionCreateListener implements Listener {
	
	@EventHandler
	public void factionCreate(FactionCreateEvent e)
	{
		if(Faction.getFactionByName(e.getFaction()) != null)
		{
			e.getPlayer().sendMessage(Messages.fCreateTagInUse);
		}
		else if(FPlayer.getFPlayer(e.getPlayer()).getFaction() != null)
		{
			e.getPlayer().sendMessage(Messages.fCreateAlreadyInFaction);
		}
		//Create faction
	}

}
