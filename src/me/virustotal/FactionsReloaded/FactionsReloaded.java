package me.virustotal.FactionsReloaded;

import java.util.ArrayList;
import java.util.HashMap;

import me.virustotal.FactionsReloaded.Objects.Board;
import me.virustotal.FactionsReloaded.Objects.FPlayer;
import me.virustotal.FactionsReloaded.Objects.Faction;

import org.bukkit.plugin.java.JavaPlugin;

public class FactionsReloaded extends JavaPlugin {
	
	private static FactionsReloaded plugin;
	
	public ArrayList<Faction> factions = new ArrayList<Faction>();
	public ArrayList<FPlayer> fPlayers = new ArrayList<FPlayer>();
	public ArrayList<Board> boards = new ArrayList<Board>();
	
	public HashMap<String,FPlayer> fPlayerCache = new HashMap<String,FPlayer>();
	
	public void onEnable() {
		plugin = this;
		ConfigHandler.loadConfigs();
	}
	
	public void onDisable() {
		
	}
	
	public static FactionsReloaded get() {
		return plugin;
	}

}
