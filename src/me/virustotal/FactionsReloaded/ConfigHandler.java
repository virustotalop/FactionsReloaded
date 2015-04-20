package me.virustotal.FactionsReloaded;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.UUID;

import me.virustotal.FactionsReloaded.Objects.Board;
import me.virustotal.FactionsReloaded.Objects.FPlayer;
import me.virustotal.FactionsReloaded.Objects.Faction;

import org.bukkit.ChatColor;
import org.bukkit.configuration.file.YamlConfiguration;

public class ConfigHandler {
	
	public static int maxFactionMembers;
	public static int maxFactionPower;
	public static int maxFactionLand;
	
	public static int maxPlayerPower;
	public static int minimumPlayerPower;
	public static int startingPlayerPower;
	
	public static void loadConfigs()
	{
		FactionsReloaded plugin = FactionsReloaded.get();
		
		/*Faction values
		 */
		ConfigHandler.maxFactionMembers = plugin.getConfig().getInt("max-faction-members");
		ConfigHandler.maxFactionPower = plugin.getConfig().getInt("max-faction-power");
		ConfigHandler.maxFactionLand = plugin.getConfig().getInt("max-faction-land");
		
		/*If faction values are set to 0 increase them to Integer,MAX_VALUE
		 */
		if(ConfigHandler.maxFactionMembers == 0)
			ConfigHandler.maxFactionMembers = Integer.MAX_VALUE;
		if(ConfigHandler.maxFactionPower == 0)
			ConfigHandler.maxFactionPower = Integer.MAX_VALUE;
		if(ConfigHandler.maxFactionLand == 0)
			ConfigHandler.maxFactionLand = Integer.MAX_VALUE;
		
		/*Player power values
		 */
		ConfigHandler.maxPlayerPower = plugin.getConfig().getInt("max-player-power");
		ConfigHandler.minimumPlayerPower = plugin.getConfig().getInt("minimum-player-power");
		ConfigHandler.startingPlayerPower = plugin.getConfig().getInt("starting-player-power");
		
		File boardFile = new File(plugin.getDataFolder().getPath(),"board.yml");
		File configFile = new File(plugin.getDataFolder().getPath(),"config.yml");
		File factionsFile = new File(plugin.getDataFolder().getPath(),"factions.yml");
		File playerFile = new File(plugin.getDataFolder().getPath(), "players.yml");
		
		if(!boardFile.exists())
		{
			plugin.saveResource("board.yml", true);
		}
		else
		{
			//save
			
		}
		if(!configFile.exists())
		{
			plugin.saveDefaultConfig();
		}
		else
		{
			//save
		}
		if(!factionsFile.exists())
		{
			plugin.saveResource("factions.yml", true);
		}
		else
		{
			//save
		}
		
		/*Load in factions
		 *Populates the list in the main factions class
		 *Creates a new object for each faction
		 */
		
		YamlConfiguration factionsConfig = YamlConfiguration.loadConfiguration(factionsFile);
		Set<String> fkeys = factionsConfig.getKeys(false);
		
		for(String key : fkeys)
		{
			String name = key;
			String tag = ChatColor.translateAlternateColorCodes('&',factionsConfig.getString(name + ".tag"));
			int power = factionsConfig.getInt(name + ".power");
			int land = factionsConfig.getInt(name + ".land");
			List<String> members = factionsConfig.getStringList(name + ".members");
			Faction fac = new Faction(name,tag,power,land,(ArrayList<String>) members);
			plugin.factions.add(fac);
		}
		
		/*Loads in entirety of the board
		 */
		
		YamlConfiguration boardConfig = YamlConfiguration.loadConfiguration(boardFile);
		for(String string : boardConfig.getStringList("board"))
		{
			String[] split = string.split(",");
			plugin.boards.add(new Board(Integer.parseInt(split[0]),Integer.parseInt(split[1]),split[2],split[3]));
		}
		
		/*Loads in faction players
		 */
		
		YamlConfiguration playerConfig = YamlConfiguration.loadConfiguration(playerFile);
		Set<String> pkeys = playerConfig.getKeys(false);
		for(String string : pkeys)
		{
			plugin.fPlayers.add(new FPlayer(UUID.fromString(string),playerConfig.getInt(string + ".power"),playerConfig.getString(string + ".faction")));
		}
		
	}

}
