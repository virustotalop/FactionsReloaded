package me.virustotal.factionsreloaded;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import me.virustotal.factionsreloaded.listeners.DeathPowerListener;
import me.virustotal.factionsreloaded.listeners.FPlayerCacheListener;
import me.virustotal.factionsreloaded.objects.Board;
import me.virustotal.factionsreloaded.objects.FHome;
import me.virustotal.factionsreloaded.objects.FPlayer;
import me.virustotal.factionsreloaded.objects.FWarp;
import me.virustotal.factionsreloaded.objects.Faction;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class FactionsReloaded extends JavaPlugin {
	
	private static FactionsReloaded plugin;
	
	public ArrayList<Faction> factions = new ArrayList<Faction>();
	public ArrayList<FPlayer> fPlayers = new ArrayList<FPlayer>();
	public ArrayList<Board> boards = new ArrayList<Board>();
	public ArrayList<FHome> fHomes = new ArrayList<FHome>();
	public ArrayList<FWarp> fWarps = new ArrayList<FWarp>();
	
	public ArrayList<String> spyPlayers = new ArrayList<String>();
	public ArrayList<String> bypassedPlayers = new ArrayList<String>();
	public ArrayList<String> factionChat = new ArrayList<String>();
	
	public HashMap<String,FPlayer> fPlayerCache = new HashMap<String,FPlayer>();
	
	public ConfigHandler config = new ConfigHandler();
	
	public void onEnable() {
		plugin = this;
		config.loadConfigs();
		
		PluginManager pm = Bukkit.getPluginManager();
		pm.registerEvents(new DeathPowerListener(this),this);
		pm.registerEvents(new FPlayerCacheListener(this), this);
		this.updateFactionPower();
	}
	
	public void onDisable() {
		//onDisable do cleanup
		factions.clear();
		fPlayers.clear();
		boards.clear();
		fPlayerCache.clear();
		fHomes.clear();
		fWarps.clear();
		bypassedPlayers.clear();
		
	}
	
	public static FactionsReloaded get() {
		return plugin;
	}
	
	public String tConfigString(String val)
	{
		return ChatColor.translateAlternateColorCodes('&', this.getConfig().getString(val));
	}
	
	public List<String> tConfigStringList(String val)
	{
		List<String> list = this.getConfig().getStringList(val);
		for(int i = 0; i < list.size(); i++)
		{
			list.set(i, ChatColor.translateAlternateColorCodes('&', list.get(i)));
		}
		return list;
	}

	public void updateFactionPower()
	{
		Bukkit.getScheduler().scheduleSyncDelayedTask(this, new Runnable()
		{
			@Override
			public void run()
			{

			}
		},config.updatePlayerPowerTicks);
	}

}
