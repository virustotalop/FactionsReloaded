package me.virustotal.factionsreloaded;

import java.io.File;

import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

public class FactionsReloaded extends JavaPlugin {
	
	private static FactionsReloaded plugin;
	
	private File messageFile;
	public YamlConfiguration mYaml;
	
	public void onEnable() {
		plugin = this;
		//Snooper.newVariableInstances(this.getClass());
		Snooper.loadListeners(this);
		Snooper.loadCommands(this);
		Snooper.loadPluginFactions(this);
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
	
	protected static FactionsReloaded get() 
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
