package com.pluginsx.dungeons.commands;

import com.pluginsx.dungeons.Dungeons;
import com.pluginsx.dungeons.entity.mobs.BeeMob;
import com.pluginsx.dungeons.entity.mobs.TestMob;
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
    public void execute(CommandSender sender, String[] args, Dungeons instance)
    {
        Player p = (Player) sender;
        //instance.entities.add(new BeeMob(p.getLocation()));

        instance.entities.add(new TestMob(p.getLocation()));


    }
}
