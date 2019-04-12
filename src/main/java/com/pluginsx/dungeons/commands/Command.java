package com.pluginsx.dungeons.commands;

import com.pluginsx.dungeons.Dungeons;
import org.bukkit.command.CommandSender;

public abstract class Command
{
    public Command() { }
    public abstract String getName();
    public abstract void execute(CommandSender sender, String[] args, Dungeons instance);
}
