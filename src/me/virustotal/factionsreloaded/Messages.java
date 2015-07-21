package me.virustotal.factionsreloaded;

public class Messages {
	
	public static String prefix;
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
	public static String fChatFormat;
	
	public Messages(FactionsReloaded plugin)
	{
		prefix = plugin.tConfigString("prefix");
		cannotClaimNoFaction = prefix + plugin.tConfigString("cannot-claim-no-faction");
		cannotDoFtagNoFaction = prefix + plugin.tConfigString("cannot-do-ftag-no-faction");
		cannotDoFTagNotCorrectGroup = prefix + plugin.tConfigString("cannot-do-ftag-not-correct-group");
		landClaimed = prefix + plugin.tConfigString("land-claimed");
		fTagNoArgs = prefix + plugin.tConfigString("ftag-no-args");
		fTagInUse = prefix + plugin.tConfigString("ftag-in-use");
		fTagTooLong = prefix + plugin.tConfigString("ftag-too-long");
		fTagFormat = plugin.tConfigString("ftag-format");
		fJoinNoArgs = prefix + plugin.tConfigString("fjoin-no-args");
		fJoinSuccess = prefix + plugin.tConfigString("fjoin-success");
		fJoinNotSuccesfulClosed = prefix + plugin.tConfigString("fjoin-not-successful-closed");
		cannotClaimNoFaction = prefix + plugin.tConfigString("fjoin-faction-does-not-exist");
		fWarpNoArgs = prefix + plugin.tConfigString("fwarp-no-args");
		fWarpNoFaction = prefix + plugin.tConfigString("fwarp-no-faction");
		fSetwarpNoArgs = prefix + plugin.tConfigString("fsetwarp-no-args");
		fSetWarpNoFaction = prefix + plugin.tConfigString("fsetwarp-no-faction");
		fCreateNoArgs = prefix + plugin.tConfigString("fcreate-no-args");
		fCreateInvalidName = prefix + plugin.tConfigString("fcreate-invalid-args");
		fCreateAlreadyInFaction = prefix + plugin.tConfigString("fcreate-already-in-faction");
		fBypassOff = prefix + plugin.tConfigString("fbypass-off");
		fBypassOn = prefix + plugin.tConfigString("fbypass-on");
		fBypassNoPermission = prefix + plugin.tConfigString("fbypass-no-permission");
		fAdminNoArgs = prefix + plugin.tConfigString("fadmin-no-args");
		fAdminNoFaction = prefix + plugin.tConfigString("fadmin-no-faction");
		fWildernessEnter = prefix + plugin.tConfigString("fwilderness-enter");
		fFactionEnter = prefix + plugin.tConfigString("ffaction-enter");
		fWhoNoArgs = prefix + plugin.tConfigString("fwho-no-args");
		fInviteNoArgs = prefix + plugin.tConfigString("finvite-no-args");
		fInviteNoFaction = prefix + plugin.tConfigString("finvite-no-faction");
		fDisbandYourFaction = prefix + plugin.tConfigString("fdisband-your-faction");
		fDisbandOtherFaction = prefix + plugin.tConfigString("fdisband-other-faction");
		fDisbandNoFaction = prefix + plugin.tConfigString("fdisband-no-faction");
		fSpyOn = prefix + plugin.tConfigString("fspy-on");
		fSpyOff = prefix + plugin.tConfigString("fspy-off");
		fSpyNoPermission = prefix + plugin.tConfigString("fspy-no-permission");
		fChatOn = prefix + plugin.tConfigString("fchat-on");
		fChatOff = prefix + plugin.tConfigString("fchat-off");
		fChatNoFaction = prefix + plugin.tConfigString("fchat-no-faction");
		fChatFormat = plugin.tConfigString("fchat-format");
	}

}
