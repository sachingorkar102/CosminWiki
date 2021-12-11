package com.github.sachin.cosmin.commands;

import java.io.IOException;

import com.github.sachin.cosmin.generator.CPackGen;

import org.bukkit.command.CommandSender;

public class GeneratePackCommand extends SubCommands{

    @Override
    public String getName() {
        return "generate";
    }

    @Override
    public String getPermission() {
        return "cosmin.command.generate";
    }

    @Override
    public String getUsage() {
        return "&3/cosmin &fgenerate &9[pack-name] (should-zip)";
    }

    @Override
    public String getDescription() {
        return "generates a resource pack";
    }

    @Override
    public int getMaxArgs() {
        return 2;
    }

    @Override
    public void perform(CommandSender sender, String[] args) {
        if(args.length < 2) return;
        String packname = args[1];
        boolean shouldZip = false;
        if(args.length>2){
            shouldZip = Boolean.parseBoolean(args[2]);
        }
        try {
            CPackGen.createPack(packname,shouldZip);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
}
