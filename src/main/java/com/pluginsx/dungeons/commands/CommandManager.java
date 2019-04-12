package com.pluginsx.dungeons.commands;

import com.pluginsx.dungeons.Dungeons;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import java.util.LinkedList;

public class CommandManager implements CommandExecutor
{
    private final Dungeons plugin_instance;

    private LinkedList<Command> commands = new LinkedList<>();

    public CommandManager(Dungeons instance)
    {
        this.plugin_instance = instance;
        commands.add(new CommandInfo());
        commands.add(new CommandTest());
    }

    @Override
    public boolean onCommand(CommandSender sender, org.bukkit.command.Command cmd, String label, String[] args)
    {
        if(!(args.length > 0))
        {
            return false;
        }

        for(int i = 0; i < commands.size(); i++)
        {
            if(commands.get(i).getName().equals(args[0]))
            {
                commands.get(i).execute(sender, args, this.plugin_instance);
                return true;
            }
        }

        return false;
    }

}
