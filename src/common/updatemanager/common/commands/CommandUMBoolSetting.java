package updatemanager.common.commands;

import updatemanager.common.Settings;
import updatemanager.common.UpdateManager;
import net.minecraft.server.MinecraftServer;
import net.minecraft.src.CommandBase;
import net.minecraft.src.ICommandSender;
import net.minecraft.src.ModLoader;
import net.minecraft.src.ServerConfigurationManager;

/**
 * @author Vazkii, TheWhiteWolves
 */
public class CommandUMBoolSetting extends CommandBase {

	String name;
	String configTag;
	String displayMsg;
	
	public CommandUMBoolSetting(String name, String configTag, String displayMsg){
		this.name = name;
		this.configTag = configTag;
		this.displayMsg = displayMsg;
	}
	
	@Override
	public String getCommandName() {
		return "um-" + name;
	}

	@Override
	public void processCommand(ICommandSender var1, String[] var2) {
		MinecraftServer server = ModLoader.getMinecraftServerInstance();
		ServerConfigurationManager manager = UpdateManager.getServerConfig(server);
		
		if(var1.canCommandSenderUseCommand(0, getCommandName()) || !Settings.getBoolean("opOnly")){
		boolean oldSetting = Settings.getBoolean(configTag);
		Settings.setBoolean(configTag, !oldSetting);
		UpdateManager.sendChatMessageToPlayer(manager.getPlayerForUsername(var1.getCommandSenderName()), String.format(displayMsg, !oldSetting));
	}
	}
	
	

}
