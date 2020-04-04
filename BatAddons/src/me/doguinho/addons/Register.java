package me.doguinho.addons;

import org.bukkit.Bukkit;
import org.bukkit.command.CommandExecutor;
import org.bukkit.event.Listener;
import me.doguinho.addons.utils.LManager;
import me.doguinho.addons.utils.Lançador;
import me.doguinho.addons.utils.Slime;

 public class Register {

	public Register(Main pl) {
		RegisterEvents(pl);
		RegisterCommands(pl);
	}
	
	void C(CommandExecutor classe, String comando, Main pl){
		pl.getCommand(comando).setExecutor(classe);
	}


	void E(Listener classe, Main pl){
		Bukkit.getPluginManager().registerEvents(classe, pl);
	}
	
	void RegisterEvents(Main pl){
		E(new LManager(), pl);
		E(new Slime(), pl);
	}
	
	void RegisterCommands(Main pl){
		C(new Lançador(), "lancador", pl);
	}
	
}