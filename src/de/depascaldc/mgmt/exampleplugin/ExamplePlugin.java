/**
 *   Copyright © 2020 | depascaldc | Discord: [depascaldc]#4093
 *   __  __                                                   _   
 *  |  \/  | __ _ _ __   __ _  __ _  ___ _ __ ___   ___ _ __ | |_ 
 *  | |\/| |/ _` | '_ \ / _` |/ _` |/ _ \ '_ ` _ \ / _ \ '_ \| __|
 *  | |  | | (_| | | | | (_| | (_| |  __/ | | | | |  __/ | | | |_ 
 *  |_|  |_|\__,_|_| |_|\__,_|\__, |\___|_| |_| |_|\___|_| |_|\__|
 *                           |___/                               
 * 
 *   Copyright © 2020 | depascaldc | Discord: [depascaldc]#4093
 *   
 *   This program is free software: you can redistribute it and/or modify
 *   it under the terms of the GNU General Public License as published by
 *   the Free Software Foundation, either version 3 of the License, or
 *   (at your option) any later version.
 *
 *   This program is distributed in the hope that it will be useful,
 *   but WITHOUT ANY WARRANTY; without even the implied warranty of
 *   MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *   GNU General Public License for more details.
 *
 *   You should have received a copy of the GNU General Public License
 *   along with this program.  If not, see <http://www.gnu.org/licenses/>.
 *   
 *   Copyright © 2020 | depascaldc | Discord: [depascaldc]#4093
 *   
 */
package de.depascaldc.mgmt.exampleplugin;

import de.depascaldc.management.config.Config;
import de.depascaldc.management.logger.ConsoleColors;
import de.depascaldc.management.main.ServerManager;
import de.depascaldc.management.plugins.JavaPlugin;

public class ExamplePlugin extends JavaPlugin {
	
	private static ExamplePlugin instance;
	
	public static ExamplePlugin getInstance() {
		return instance;
	}
	
	private Config pluginConfig;
	
	@Override
	public void onLoad() {
		instance = this;
	}
	
	@Override
	public void onEnable() {
		saveDefaultConfig(); 
		reloadConfig();
		pluginConfig = getConfig();
		ServerManager.getCommandMap().register(new ExampleCommand(this, "example"));
		getLogger().info(ConsoleColors.CYAN_UNDERLINED + "Plugin nice geladen diggi XD");
	}
	
	@Override
	public void onDisable() {
		getLogger().info(ConsoleColors.RED_UNDERLINED + "Plugin nice entladen diggi XD");
	}
	
	public Config getPluginConfig() {
		return pluginConfig;
	}

}
