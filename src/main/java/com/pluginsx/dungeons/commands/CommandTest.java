package com.pluginsx.dungeons.commands;

import com.pluginsx.dungeons.skulls.SkullCreator;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.Bat;
import org.bukkit.entity.Parrot;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class CommandTest extends Command
{
    public CommandTest() { }

    public  String getName()
    {
        return "test";
    }
    public void execute(CommandSender sender, String[] args)
    {
        Player player = (Player) sender;
        Location loc = player.getLocation().clone();

        Parrot parrot = (Parrot)loc.getWorld().spawn(loc, Parrot.class);
        parrot.addPotionEffect(new PotionEffect(PotionEffectType.INVISIBILITY, Integer.MAX_VALUE, 1));
        parrot.setCustomName("taylorsasser1234");

        ArmorStand stand = (ArmorStand)loc.getWorld().spawn(loc, ArmorStand.class);
        stand.setGravity(false);
        stand.setHelmet(SkullCreator.itemFromBase64("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvOTQ3MzIyZjgzMWUzYzE2OGNmYmQzZTI4ZmU5MjUxNDRiMjYxZTc5ZWIzOWM3NzEzNDlmYWM1NWE4MTI2NDczIn19fQ=="));
        stand.setVisible(false);
        //stand.getEquipment().setItemInMainHand(new ItemStack(Material.FEATHER, 1));
        stand.setCustomName("taylorsasser1235");

    }
}
