 package me.doguinho.addons.utils;
 
 import org.bukkit.Location;
 import org.bukkit.Material;
 import org.bukkit.block.Block;
 import org.bukkit.block.BlockFace;
 import org.bukkit.entity.Player;
 import org.bukkit.event.EventHandler;
 import org.bukkit.event.Listener;
 import org.bukkit.event.block.Action;
 import org.bukkit.event.block.BlockBreakEvent;
 import org.bukkit.event.player.PlayerInteractEvent;
 import org.bukkit.event.player.PlayerMoveEvent;
 import org.bukkit.potion.PotionEffect;
 import org.bukkit.potion.PotionEffectType;
 import org.bukkit.util.Vector;
 
 public class Slime implements Listener {
   @EventHandler
   public void toca(PlayerInteractEvent e) {
     Player p = e.getPlayer();
     Action action = e.getAction();
     if (action == Action.RIGHT_CLICK_BLOCK && p.getItemInHand().getType() == Material.SLIME_BLOCK) {
       Location clique = e.getClickedBlock().getLocation();
       clique.getBlock().setType(Material.SLIME_BLOCK);
       if (clique.getBlock().getType() == Material.SLIME_BLOCK)
         clique.getBlock().setType(Material.AIR); 
     } 
   }
   
   @EventHandler
   public void jump(PlayerMoveEvent e) {
     Player p = e.getPlayer();
     Block slime = e.getTo().getBlock().getRelative(BlockFace.DOWN);
     if (slime.getType() == Material.SLIME_BLOCK) {
       p.setVelocity(p.getLocation().getDirection().multiply(1));
       p.setVelocity(new Vector(p.getVelocity().getX(), 1.0D, p.getVelocity().getZ()));
       p.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 66, 15));
     } 
   }
   
   @EventHandler
   public void quebrar(BlockBreakEvent e) {
     if (e.getBlock().getType() == Material.SLIME_BLOCK)
       e.setCancelled(true); 
   }
 }