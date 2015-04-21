package me.virustotal.FactionsReloaded.Commands;

import org.bukkit.entity.Player;

import me.virustotal.FactionsReloaded.Objects.FPlayer;
import me.virustotal.FactionsReloaded.Utils.FPlayerUtil;

public class FClose {
	
	public static boolean doCommand(Player player)
	{
	
		FPlayer fPlayer = FPlayerUtil.getFPlayer(player);
		if(fPlayer.getFaction().equals("none"))
		{
		
			return true;
		}
		
		//send message no args fclose
		return true;
	}

}
