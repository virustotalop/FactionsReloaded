package me.virustotal.FactionsReloaded;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.UUID;

import me.virustotal.FactionsReloaded.Objects.Board;
import me.virustotal.FactionsReloaded.Objects.FHome;
import me.virustotal.FactionsReloaded.Objects.FPlayer;
import me.virustotal.FactionsReloaded.Objects.FWarp;
import me.virustotal.FactionsReloaded.Objects.Faction;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class ConfigHandler {
	
	//Faction values
	public static int maxFactionMembers;
	public static int maxFactionPower;
	public static int maxFactionLand;
	public static int maxFactionWarps;
	public static int startingFactionWarps;
	public static int maxFactionTagSize;
	
	//Player values
	public static int maxPlayerPower;
	public static int minimumPlayerPower;
	public static int startingPlayerPower;
	public static int lossOfPlayerPerDeath;
	public static long updatePlayerPowerTicks;
	
	//Messages
	public static String prefix;
	public static String cannotClaimNoFaction;
	public static String cannotDoFtagNoFaction;
	public static String cannotDoFTagNotCorrectGroup;
	public static String landClaimed;
	public static String fTagNoArgs;
	public static String fTagInUse;
	public static String fTagTooLong;
	public static String fJoinNoArgs;
	public static String fJoinSuccess;
	public static String fJoinNotSuccesfulClosed;
	public static String fJoinFactionDoesNotExist;
	public static String fWarpNoArgs;
	public static String fWarpNoFaction;
	public static String fSetwarpNoArgs;
	
	//Help Menu
	public static List<String> topOfMenu;
	public static List<String> helpMenu;
	public static int commandsPerPage;
	
	public static void loadConfigs()
	{
		FactionsReloaded plugin = FactionsReloaded.get();
		
		/*Faction values
		 * 
		 */
		
		ConfigHandler.maxFactionMembers = plugin.getConfig().getInt("max-faction-members");
		ConfigHandler.maxFactionPower = plugin.getConfig().getInt("max-faction-power");
		ConfigHandler.maxFactionLand = plugin.getConfig().getInt("max-faction-land");
		ConfigHandler.maxFactionWarps = plugin.getConfig().getInt("max-faction-warps");
		ConfigHandler.startingFactionWarps = plugin.getConfig().getInt("starting-faction-warps");
		ConfigHandler.maxFactionTagSize = plugin.getConfig().getInt("max-faction-tag-size");
		
		/*If faction values are set to 0 increase them to Integer,MAX_VALUE
		 * 
		 */
		
		if(ConfigHandler.maxFactionMembers == 0)
			ConfigHandler.maxFactionMembers = Integer.MAX_VALUE;
		if(ConfigHandler.maxFactionPower == 0)
			ConfigHandler.maxFactionPower = Integer.MAX_VALUE;
		if(ConfigHandler.maxFactionLand == 0)
			ConfigHandler.maxFactionLand = Integer.MAX_VALUE;
		
		/*Player power values
		 * 
		 */
		
		ConfigHandler.maxPlayerPower = plugin.getConfig().getInt("max-player-power");
		ConfigHandler.minimumPlayerPower = plugin.getConfig().getInt("minimum-player-power");
		ConfigHandler.startingPlayerPower = plugin.getConfig().getInt("starting-player-power");
		ConfigHandler.lossOfPlayerPerDeath = plugin.getConfig().getInt("loss-of-player-power-per-death");
		ConfigHandler.updatePlayerPowerTicks = plugin.getConfig().getLong("update-player-power-ticks");
		
		/*Messages
		 * 
		 */
	
		ConfigHandler.prefix = plugin.tConfigString("prefix");
		ConfigHandler.cannotClaimNoFaction = ConfigHandler.prefix + plugin.tConfigString("cannot-claim-no-faction");
		ConfigHandler.cannotDoFtagNoFaction = ConfigHandler.prefix + plugin.tConfigString("cannot-do-ftag-no-faction");
		ConfigHandler.cannotDoFTagNotCorrectGroup = ConfigHandler.prefix + plugin.tConfigString("cannot-do-ftag-not-correct-group");
		ConfigHandler.landClaimed = ConfigHandler.prefix + plugin.tConfigString("land-claimed");
		ConfigHandler.fTagNoArgs = ConfigHandler.prefix + plugin.tConfigString("ftag-no-args");
		ConfigHandler.fTagInUse = ConfigHandler.prefix + plugin.tConfigString("ftag-in-use");
		ConfigHandler.fTagTooLong = ConfigHandler.prefix + plugin.tConfigString("ftag-too-long");
		ConfigHandler.fJoinNoArgs = ConfigHandler.prefix + plugin.tConfigString("fjoin-no-args");
		ConfigHandler.fJoinSuccess = ConfigHandler.prefix + plugin.tConfigString("fjoin-success");
		ConfigHandler.fJoinNotSuccesfulClosed = ConfigHandler.prefix + plugin.tConfigString("fjoin-not-successful-closed");
		ConfigHandler.cannotClaimNoFaction = ConfigHandler.prefix + plugin.tConfigString("fjoin-faction-does-not-exist");
		ConfigHandler.fWarpNoArgs = ConfigHandler.prefix + plugin.tConfigString("fwarp-no-args");
		ConfigHandler.fWarpNoFaction = ConfigHandler.prefix + plugin.tConfigString("fwarp-no-faction");
		ConfigHandler.fSetwarpNoArgs = ConfigHandler.prefix + plugin.tConfigString("fsetwarp-no-args");
		
		
		/* Help Menu
		 * 
		 */
		
		ConfigHandler.topOfMenu = plugin.tConfigStringList("top-of-menu");
		ConfigHandler.helpMenu = plugin.tConfigStringList("help-menu");
		ConfigHandler.commandsPerPage = plugin.getConfig().getInt("commands-per-page");
		
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
			Faction fac = new Faction(name,tag,power,land,open,admin,mods, members);
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
