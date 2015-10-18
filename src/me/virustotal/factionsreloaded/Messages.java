package me.virustotal.factionsreloaded;

import java.lang.reflect.Field;
import java.util.ArrayList;

public class Messages {
	
	public static String cannotClaimNoFaction;
	public static String cannotDoFtagNoFaction;
	public static String cannotDoFTagNotCorrectGroup;
	public static String landClaimed;
	public static String fTagNoArgs;
	public static String fTagInUse;
	public static String fTagTooLong;
	public static String fTagFormat;
	public static String fJoinNoArgs;
	public static String fJoinSuccess;
	public static String fJoinNotSuccesfulClosed;
	public static String fJoinFactionDoesNotExist;
	public static String fWarpNoArgs;
	public static String fWarpNoFaction;
	public static String fSetwarpNoArgs;
	public static String fSetWarpNoFaction;
	public static String fCreateNoArgs;
	public static String fCreateInvalidName;
	public static String fCreateAlreadyInFaction;
	public static String fBypassOn;
	public static String fBypassOff;
	public static String fBypassNoPermission;
	public static String fAdminNoArgs;
	public static String fAdminNoFaction;
	public static String fWildernessEnter;
	public static String fFactionEnter;
	public static String fWhoNoArgs;
	public static String fInviteNoArgs;
	public static String fInviteNoFaction;
	public static String fDisbandYourFaction;
	public static String fDisbandOtherFaction;
	public static String fDisbandNoFaction;
	public static String fSpyOn;
	public static String fSpyOff;
	public static String fSpyNoPermission;
	public static String fChatOn;
	public static String fChatOff;
	public static String fChatNoFaction;	
	
	protected static void loadMessages(FactionsReloaded plugin)
	{
		for(Field field : Messages.class.getFields())
		{
			String fName = field.getName();
			ArrayList<Character> chars = new ArrayList<Character>();
			char[] ar = fName.toCharArray();
			for(int i = 0; i < ar.length; i++)
			{
				if(Character.isUpperCase(ar[i]))
				{
					if(!chars.contains(ar[i]))
						chars.add(ar[i]);
				}
			}
			int count = 0;
			for(Character theChar : chars)
			{
				if(count == 0)
					fName = fName.replace(("" + theChar), ("-" + Character.toLowerCase(theChar) + "-"));
				else
					fName = fName.replace(("" + theChar), (Character.toLowerCase(theChar) + "-"));
				count += 1;
			}
			try 
			{
				field.set(field, ConfigHandler.prefix + plugin.tMessageString(fName));
			} 
			catch (IllegalArgumentException | IllegalAccessException e) 
			{
				e.printStackTrace();
			}
		}
	}
}