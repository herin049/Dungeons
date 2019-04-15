package com.pluginsx.dungeons.commands;

import com.pluginsx.dungeons.Dungeons;
import com.pluginsx.dungeons.entity.mobs.TestMob;
import net.minecraft.server.v1_13_R2.Entity;
import org.bukkit.Location;
import org.bukkit.command.CommandSender;
import org.bukkit.craftbukkit.v1_13_R2.CraftWorld;

import org.bukkit.entity.Player;

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

        instance.entities.add(new TestMob(p.getLocation()));
        //instance.entities.add(new GoombaMob(p.getLocation()));
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
