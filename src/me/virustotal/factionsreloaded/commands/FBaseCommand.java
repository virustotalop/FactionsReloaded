package me.virustotal.factionsreloaded.commands;

import java.util.ArrayList;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class FBaseCommand implements CommandExecutor {

	private ArrayList<String> commands;
	private ArrayList<String> cmdArgs;
	
	public FBaseCommand(ArrayList<String> commands,ArrayList<String> cmdArgs,String permission,String groupRequired)
	{
		this.commands = commands;
		this.cmdArgs = cmdArgs;
	}
	
	public void run()
	{
		
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label,String[] args) {
		
		for(String string : commands)
		{
			if(label.equalsIgnoreCase(string))
			{
				
			}
		}
		
		return false;
	}

	
	
}
