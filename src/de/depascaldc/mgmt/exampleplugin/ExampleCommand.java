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

import java.io.IOException;

import de.depascaldc.management.commands.ConsoleCommand;
import de.depascaldc.management.main.ServerManager;
import de.depascaldc.management.plugins.Plugin;
import de.depascaldc.management.process.ManagedProcess;

public class ExampleCommand extends ConsoleCommand {

	private Plugin plugin;

	public ExampleCommand(Plugin plugin, String name) {
		super(name);
		this.plugin = plugin;
		setAliases("ex");
		setDescription("This is a nice Command description.");
		setUsage("/" + name + "  -  Example Command Usage...");
	}

	@Override
	public boolean executeCommand(String commandLabel, String[] args) {
		plugin.getLogger().info("Example Command answer.");

		ManagedProcess managedProcess = ServerManager.getManagedProcess();
		boolean managedProcessActive = managedProcess != null
				&& managedProcess.getProcess() != null;
		String mgmtProc = managedProcessActive ? "ManagedProcess has active ServerProcess" : "ManagedProcess has NO active ServerProcess";
		plugin.getLogger().info(mgmtProc);
		
		if(args.length > 0) {
			switch (args[0].toLowerCase()) {
			case "restart":
				if(managedProcessActive) {
					managedProcess.stopProcess();
					while (managedProcess.getProcess() != null) {
						try {
							Thread.sleep(500);
						} catch (InterruptedException e) {
						}
					}
					try {
						managedProcess.initProcess();
						plugin.getLogger().info("Process Restarted...");
					} catch (IOException e) {
						plugin.getLogger().info("Error while restarting serverprocess", e);
					}
				} else {
					try {
						managedProcess.initProcess();
						plugin.getLogger().info("Process Restarted...");
					} catch (IOException e) {
						plugin.getLogger().info("Error while restarting serverprocess", e);
					}
				}
				break;
			default:
				break;
			}
		}

		return false;
	}

}
