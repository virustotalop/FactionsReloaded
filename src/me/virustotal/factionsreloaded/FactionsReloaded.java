package me.virustotal.factionsreloaded;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;

import me.virustotal.factionsreloaded.objects.Board;
import me.virustotal.factionsreloaded.objects.FHome;
import me.virustotal.factionsreloaded.objects.FPlayer;
import me.virustotal.factionsreloaded.objects.FWarp;
import me.virustotal.factionsreloaded.objects.Faction;

import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.ChatColor;
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
	public Messages messages;
	
	private File messageFile;
	public YamlConfiguration mYaml;
	
	public void onEnable() {
		plugin = this;
		
		//Snooper.newVariableInstances(this.getClass());
		Snooper.loadListeners(this);
		Snooper.loadCommands(this);
		this.messageFile = new File(this.getDataFolder().getPath(),"messages.yml");
		this.saveResource(this.messageFile.getName(), false);
		this.mYaml = YamlConfiguration.loadConfiguration(messageFile);
		
		Messages.loadMessages(this);
		ConfigHandler.loadConfigs(this);
		
		//config.loadConfigs();
		//messages = new Messages(this);
		//this.updateFactionPower();
	}
	
	public void onDisable() {
		//onDisable do cleanup
		//Snooper.cleanupVariables(this.getClass());
		
	}
	
	public static FactionsReloaded get() 
	{
		return plugin;
	}
	
	public String tMessageString(String val)
	{
		return ChatColor.translateAlternateColorCodes('&', mYaml.getString(val));
	}
	
	/*public String tConfigString(String val)
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
		},this.config.updatePlayerPowerTicks);
	}*/

}
