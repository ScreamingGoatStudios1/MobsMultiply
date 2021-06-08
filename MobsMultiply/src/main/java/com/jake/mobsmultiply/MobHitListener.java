package com.jake.mobsmultiply;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class MobHitListener implements Listener {
    @EventHandler
    public void onMobDamage(EntityDamageByEntityEvent e) {
        if (MobsMultiply.isStarted) {
            Location location = e.getEntity().getLocation();

            if (e.getDamager() instanceof Player) {
                if (!(e.getEntity().getType().equals(EntityType.ENDER_DRAGON) || e.getEntity().getType().equals(EntityType.ENDER_CRYSTAL) || e.getEntity().getType().equals(EntityType.ARMOR_STAND) || e.getEntity().getType().equals(EntityType.SHULKER_BULLET) || e.getEntity().getType().equals(EntityType.PLAYER))) {
                    LivingEntity entity = (LivingEntity) Bukkit.getWorld("world").spawnEntity(location, e.getEntity().getType());
                    LivingEntity netherEntity = (LivingEntity) Bukkit.getWorld("world_nether").spawnEntity(location, e.getEntity().getType());
                    LivingEntity endEntity = (LivingEntity) Bukkit.getWorld("world_the_end").spawnEntity(location, e.getEntity().getType());
                    entity.addPotionEffect(new PotionEffect(PotionEffectType.GLOWING, 10, 1, false, false));
                    netherEntity.addPotionEffect(new PotionEffect(PotionEffectType.GLOWING, 10, 1, false, false));
                    endEntity.addPotionEffect(new PotionEffect(PotionEffectType.GLOWING, 10, 1, false, false));
                }
            }
        }
    }
}
