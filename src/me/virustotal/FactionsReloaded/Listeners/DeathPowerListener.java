package me.virustotal.FactionsReloaded.Listeners;

import me.virustotal.FactionsReloaded.ConfigHandler;
import me.virustotal.FactionsReloaded.Objects.FPlayer;
import me.virustotal.FactionsReloaded.Utils.FPlayerUtil;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

public class DeathPowerListener implements Listener {
	
	@EventHandler
	public void deathListener(PlayerDeathEvent e)
	{
		Player player = e.getEntity();
		FPlayer fPlayer = FPlayerUtil.getFPlayer(player);
		int currentPower = fPlayer.getPower();
		int minPower = ConfigHandler.minimumPlayerPower;
		int powerPerDeath = ConfigHandler.lossOfPlayerPerDeath;
		
		if(currentPower - powerPerDeath < minPower)
		{
			//set fPlayer power to minimum power
			
		}
		else
		{
			//set fPlayer power to currentPower - powerPerDeath
		}
		//update faction power
	}

}
