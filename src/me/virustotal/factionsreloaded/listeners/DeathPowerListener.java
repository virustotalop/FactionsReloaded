package me.virustotal.factionsreloaded.listeners;

import me.virustotal.factionsreloaded.ConfigHandler;
import me.virustotal.factionsreloaded.FactionsReloaded;
import me.virustotal.factionsreloaded.objects.FPlayer;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

public class DeathPowerListener implements Listener {
	
	private FactionsReloaded plugin;
	public DeathPowerListener(FactionsReloaded plugin)
	{
		this.plugin = plugin;
	}
	
	@EventHandler
	public void deathListener(PlayerDeathEvent e)
	{
		Player player = e.getEntity();
		FPlayer fPlayer = FPlayer.getFPlayer(player);
		int currentPower = fPlayer.getPower();
		int minPower = ConfigHandler.minimumPlayerPower;
		int powerPerDeath = ConfigHandler.lossOfPlayerPerDeath;
		
		//set fPlayer power to minimum power if power would be less than minimum power
		if(currentPower - powerPerDeath < minPower)
		{
			fPlayer.setPower(minPower);
		}
		else
		{
			//set fPlayer power to currentPower - powerPerDeath
			fPlayer.setPower(currentPower - powerPerDeath);
		}
	}
}
