package com.pluginsx.dungeons.commands;

import org.bukkit.command.CommandSender;

public abstract class Command
{
    public Command() { }
    public abstract String getName();
    public abstract void execute(CommandSender sender, String[] args);
}
