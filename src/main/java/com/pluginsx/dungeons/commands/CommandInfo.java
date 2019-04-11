package com.pluginsx.dungeons.commands;

import org.bukkit.command.CommandSender;

public class CommandInfo extends Command
{
    public CommandInfo() { }

    public  String getName()
    {
        return "info";
    }
    public void execute(CommandSender sender, String[] args)
    {
        sender.sendMessage("Taylorsasser 1234");
    }
}
