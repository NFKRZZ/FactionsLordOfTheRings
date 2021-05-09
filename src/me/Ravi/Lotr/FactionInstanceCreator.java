package me.Ravi.Lotr;

import java.lang.reflect.Type;

import com.google.gson.InstanceCreator;
import com.massivecraft.factions.Faction;
import com.massivecraft.factions.Factions;
import com.massivecraft.factions.data.MemoryFaction;


public class FactionInstanceCreator implements InstanceCreator<Faction>
{
    public MemoryFaction createInstance(Type arg0) 
    {
        return (MemoryFaction)Factions.getInstance().getFactionById("Wilderness");
    }
    
}
