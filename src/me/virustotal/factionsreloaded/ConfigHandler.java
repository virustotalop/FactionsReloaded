package me.virustotal.factionsreloaded;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.UUID;

import me.virustotal.factionsreloaded.objects.Board;
import me.virustotal.factionsreloaded.objects.FHome;
import me.virustotal.factionsreloaded.objects.FPlayer;
import me.virustotal.factionsreloaded.objects.FWarp;
import me.virustotal.factionsreloaded.objects.Faction;
import me.virustotal.factionsreloaded.objects.FactionEnum;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class ConfigHandler {
	
	//Faction values
	public int maxFactionMembers;
	public int maxFactionPower;
	public int maxFactionLand;
	public int maxFactionWarps;
	public int startingFactionWarps;
	public int maxFactionTagSize;
	
	//Player values
	public int maxPlayerPower;
	public int minimumPlayerPower;
	public int startingPlayerPower;
	public int lossOfPlayerPerDeath;
	public long updatePlayerPowerTicks;
	
	
	//Help Menu
	public List<String> topOfMenu;
	public List<String> helpMenu;
	public int commandsPerPage;
	
	//Block list
	public boolean blockAny;
	public List<String> blockedContainers;
	
	public void loadConfigs()
	{
		FactionsReloaded plugin = FactionsReloaded.get();
		
		/*Faction values
		 * 
		 */
		
		this.maxFactionMembers = plugin.getConfig().getInt("max-faction-members");
		this.maxFactionPower = plugin.getConfig().getInt("max-faction-power");
		this.maxFactionLand = plugin.getConfig().getInt("max-faction-land");
		this.maxFactionWarps = plugin.getConfig().getInt("max-faction-warps");
		this.startingFactionWarps = plugin.getConfig().getInt("starting-faction-warps");
		this.maxFactionTagSize = plugin.getConfig().getInt("max-faction-tag-size");
		
		/*If faction values are set to 0 increase them to Integer,MAX_VALUE
		 * 
		 */
		
		if(this.maxFactionMembers == 0)
			this.maxFactionMembers = Integer.MAX_VALUE;
		if(this.maxFactionPower == 0)
			this.maxFactionPower = Integer.MAX_VALUE;
		if(this.maxFactionLand == 0)
			this.maxFactionLand = Integer.MAX_VALUE;
		
		/*Player power values
		 * 
		 */
		
		this.maxPlayerPower = plugin.getConfig().getInt("max-player-power");
		this.minimumPlayerPower = plugin.getConfig().getInt("minimum-player-power");
		this.startingPlayerPower = plugin.getConfig().getInt("starting-player-power");
		this.lossOfPlayerPerDeath = plugin.getConfig().getInt("loss-of-player-power-per-death");
		this.updatePlayerPowerTicks = plugin.getConfig().getLong("update-player-power-ticks");
		
		/* Help Menu
		 * 
		 */
		
		this.topOfMenu = plugin.tConfigStringList("top-of-menu");
		this.helpMenu = plugin.tConfigStringList("help-menu");
		this.commandsPerPage = plugin.getConfig().getInt("commands-per-page");
		
		/*Blocked containers
		 * 
		 */
		this.blockAny = plugin.getConfig().getBoolean("blockAny");
		this.blockedContainers = plugin.getConfig().getStringList("blocked-containers");
		
		/*Config files
		 * 
		 */
		
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
			plugin.reloadConfig();
		}
		if(!factionsFile.exists())
		{
			plugin.saveResource("factions.yml", true);
		}
		else
		{
			//save
		}
		
		/*Load in factions, fwarps and fhomes          - Do optimizations to storage later
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
			boolean open = factionsConfig.getBoolean(name + ".open");
			ArrayList<String> members = (ArrayList<String>) factionsConfig.getStringList(name + ".members");
			String admin = factionsConfig.getString(name + ".admin");
			ArrayList<String> mods = (ArrayList<String>) factionsConfig.getStringList(name + ".mods");
			Faction fac = new Faction(name,tag,power,land,open,FactionEnum.OTHER, admin,mods, members);
			String[] locSplit = factionsConfig.getString(name + ".fhome.location").split(",");
			int x = Integer.parseInt(locSplit[0]);
			int y = Integer.parseInt(locSplit[1]);
			int z = Integer.parseInt(locSplit[2]);
			String world = locSplit[3];
			Location loc = new Location(Bukkit.getWorld(world),y,z,x);
			plugin.factions.add(fac);
			List<PotionEffect> potionEffects = new ArrayList<PotionEffect>();
			for(String pEff : factionsConfig.getStringList(name + ".fhome.potion-effects"))
			{
				String[] pSplit = pEff.split(",");
				potionEffects.add(new PotionEffect(PotionEffectType.getByName(pSplit[0]),1,Integer.parseInt(pSplit[1])));
			}
			
			
			//Add faction fHome to
			plugin.fHomes.add(new FHome(fac,loc,potionEffects));
			
			
			for(String fWarp : factionsConfig.getStringList(name + ".fwarps"))
			{
				String[] fSplit = fWarp.split(",");
				int fx = Integer.parseInt(fSplit[0]);
				int fy = Integer.parseInt(fSplit[1]);
				int fz = Integer.parseInt(fSplit[2]);
				World fWorld = Bukkit.getWorld(fSplit[3]);
				String warpName = fSplit[4];
				String group = fSplit[5];
				String password = fSplit[6];
				
				Location wLoc = new Location(fWorld,fx,fy,fz);
				
				plugin.fWarps.add(new FWarp(fac,wLoc,warpName,group,password));
			}
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
