package com.pluginsx.dungeons.commands;

import com.pluginsx.dungeons.Dungeons;
import org.bukkit.command.CommandSender;

public class CommandInfo extends Command
{
    public CommandInfo() { }

    public  String getName()
    {
        return "info";
    }
    public void execute(CommandSender sender, String[] args, Dungeons instance)
    {
        sender.sendMessage("Taylorsasser 1234");
    }
}
