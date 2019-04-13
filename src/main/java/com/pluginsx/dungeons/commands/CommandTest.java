package com.pluginsx.dungeons.commands;

import com.pluginsx.dungeons.Dungeons;
import com.pluginsx.dungeons.entity.mobs.BeeMob;
import com.pluginsx.dungeons.entity.mobs.GoombaMob;
import com.pluginsx.dungeons.entity.mobs.TestMob;
import com.pluginsx.dungeons.skulls.SkullCreator;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.*;
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
        for(int i = 0; i < 10; i++) {
            instance.entities.add(new GoombaMob(p.getLocation()));
        }
        //Location loc = p.getLocation();

        /*
        for(int i = 0; i < 10; i++)
        {
            Slime test = (Slime) (loc.getWorld().spawn(loc, Slime.class));
            test.setSize(i);
            String  name = Integer.toString(i);
            test.setCustomName(name);
        }
        */


        //instance.entities.add(new TestMob(p.getLocation()));


    }
}
