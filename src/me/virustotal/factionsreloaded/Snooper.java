package me.virustotal.factionsreloaded;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.List;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;
import java.util.logging.Level;

import org.bukkit.Bukkit;
import org.bukkit.command.CommandExecutor;
import org.bukkit.event.Listener;
import org.bukkit.plugin.PluginManager;

public class Snooper {
	
	protected static void loadListeners(FactionsReloaded plugin)
	{
		PluginManager pm = Bukkit.getPluginManager();
		try
		{
			File jarFile = new File(plugin.getClass().getProtectionDomain().getCodeSource().getLocation().toURI());
			JarFile jar = new JarFile(jarFile);
			Enumeration<JarEntry> entries = jar.entries();
			int count = 0;
			
			while(entries.hasMoreElements() )
			{
				JarEntry entry = entries.nextElement();
				String name = entry.getName().replace('/', '.');
				name = name.substring(0, name.lastIndexOf("."));
				if(name.contains("me.virustotal"))
				{
					Class<?> theClass = Class.forName(name);
					if(theClass.getInterfaces().length > 0)
					{
						if(Arrays.asList(theClass.getInterfaces()).contains(Listener.class))
						{
							pm.registerEvents((Listener) theClass.getDeclaredConstructor(plugin.getClass()).newInstance(plugin), plugin);
							count ++;
						}
					}
				}
			}
			plugin.getLogger().log(Level.INFO, count + " listeners loaded!");
			jar.close();
		}
		catch(IOException | URISyntaxException | InstantiationException | IllegalAccessException | ClassNotFoundException | IllegalArgumentException | InvocationTargetException | NoSuchMethodException | SecurityException ex)
		{
			ex.printStackTrace();
		}
	}
	
	protected static void loadCommands(FactionsReloaded plugin)
	{
		try
		{
			File jarFile = new File(plugin.getClass().getProtectionDomain().getCodeSource().getLocation().toURI());
			JarFile jar = new JarFile(jarFile);
			Enumeration<JarEntry> entries = jar.entries();
			int count = 0;

			while(entries.hasMoreElements())
			{
				JarEntry entry = entries.nextElement();
				String name = entry.getName().replace('/', '.');
				name = name.substring(0, name.lastIndexOf("."));
				if(name.contains("me.virustotal"))
				{
					Class<?> theClass = Class.forName(name);
					if(theClass.getInterfaces().length > 0)
					{
						if(Arrays.asList(theClass.getInterfaces()).contains(CommandExecutor.class))
						{
							Method method = theClass.getMethod("getCmd");
							Object instance = theClass.newInstance();
							String command = (String) method.invoke(instance);
							plugin.getCommand(command).setExecutor((CommandExecutor) instance);
							count ++;
						}
					}
				}
			}
			plugin.getLogger().log(Level.INFO, count + " commands loaded!");
			jar.close();
		}
		catch(IOException | URISyntaxException | InstantiationException | IllegalAccessException | ClassNotFoundException | IllegalArgumentException | SecurityException | InvocationTargetException | NoSuchMethodException ex)
		{
			ex.printStackTrace();
		}
	}
	
	protected static void loadCommands()
	{
		
	}
	
	protected static void cleanupVariables(Class<?> theClass)
	{
		for(Field field : theClass.getFields())
		{
			try 
			{
				if(field.getType().newInstance() instanceof List)
				{
					field.set(field.get(new ArrayList<>()), null);
				}
			} 
			catch (IllegalArgumentException | IllegalAccessException | InstantiationException e) 
			{
				e.printStackTrace();
			}
		}
	}
	
	protected static void newVariableInstances(Class<?> theClass)
	{
		for(Field field : theClass.getFields())
		{
			try 
			{
				if(field.getType().newInstance() instanceof List)
					field.set(field.get(new ArrayList<>()), field.getType().newInstance());
			} 
			catch (InstantiationException | IllegalAccessException| IllegalArgumentException e) 
			{
				e.printStackTrace();
			}
		}
	}
}
