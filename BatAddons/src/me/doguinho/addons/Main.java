package me.doguinho.addons;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.event.HandlerList;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin{
	
	public static Main plugin;
	
	@Override
	public void onEnable() {
		plugin = this;
		saveConfig();
		new Register(this);
		Bukkit.getConsoleSender().sendMessage(ChatColor.GREEN+"[ADDONS] Addons Ativados!");

	}
	
	@Override
	public void onDisable() {
		HandlerList.unregisterAll();
		Bukkit.getConsoleSender().sendMessage(ChatColor.RED+"[ADDONS] Addons Desativados!");
	}
	
	public static Main getInstance(){
		return Main.getPlugin(Main.class);
	}
	
	

}
