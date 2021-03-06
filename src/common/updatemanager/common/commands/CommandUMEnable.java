package updatemanager.common.commands;

import updatemanager.common.Settings;
import updatemanager.common.UpdateManager;
import net.minecraft.server.MinecraftServer;
import net.minecraft.src.CommandBase;
import net.minecraft.src.ICommandSender;
import net.minecraft.src.ModLoader;
import net.minecraft.src.ServerConfigurationManager;

/**
 * @author Vazkii, TheWhiteWolves, Kovu
 */
public class CommandUMEnable extends CommandBase {

	@Override
	public String getCommandName() {
		return "um-enable";
	}

	@Override
	public void processCommand(ICommandSender var1, String[] var2) {
		MinecraftServer server = ModLoader.getMinecraftServerInstance();
		ServerConfigurationManager manager = UpdateManager.getServerConfig(server);
		
		if(var1.canCommandSenderUseCommand(0, getCommandName()) || !Settings.getBoolean("opOnly")){
		Settings.setBoolean("loginCheck", true);
		Settings.setInt("checkDelay", 900);
		UpdateManager.sendChatMessageToPlayer(manager.getPlayerForUsername(var1.getCommandSenderName()), "Update Manager has been re-enabled.");
		}
	}

}
