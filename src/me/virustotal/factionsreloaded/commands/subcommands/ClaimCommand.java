package me.virustotal.factionsreloaded.commands.subcommands;

import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.virustotal.factionsreloaded.Messages;
import me.virustotal.factionsreloaded.commands.SubCommand;
import me.virustotal.factionsreloaded.customevents.FactionLandClaimEvent;
import me.virustotal.factionsreloaded.objects.FPlayer;
import me.virustotal.factionsreloaded.objects.Faction;

public class ClaimCommand extends SubCommand {
	
	@Override
	public void execute(CommandSender sender, String[] args)
	{
		//todo add radius claiming
		if(!(sender instanceof Player))
			return;
		
		Player player = (Player)sender;
		UUID uuid = player.getUniqueId();
		FPlayer fPlayer = FPlayer.getFPlayer(player);
		Faction faction = fPlayer.getFaction();
		if(faction == null)
			player.sendMessage(Messages.fClaimNoFaction);
		
		boolean correctGroup = faction.getAdmin().equals(uuid) || faction.getMods().contains(uuid);
		
		if(correctGroup)
		{
			Bukkit.getPluginManager().callEvent(new FactionLandClaimEvent(faction, player.getLocation().getChunk()));
		}
		else if(!correctGroup)
			player.sendMessage(Messages.fClaimNotCorrectGroup);
		else
			player.sendMessage(Messages.fCommandUsageFormat.replace("%usage%", this.usage()));
			
	}
	
	@Override
	public String usage()
	{
		return "/f claim <radius>";
	}
}