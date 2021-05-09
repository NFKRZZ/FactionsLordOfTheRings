package me.Ravi.Lotr;

import java.lang.reflect.Type;

import com.google.gson.InstanceCreator;
import com.massivecraft.factions.FPlayer;
import com.massivecraft.factions.FPlayers;
import com.massivecraft.factions.data.MemoryFPlayer;

public class FPlayerInstanceCreator implements InstanceCreator<FPlayer>
{
    public FPlayer createInstance(Type arg0) 
    {
        return FPlayers.getInstance().getById("e7300189-961b-4162-9596-165aa844cf78");
    }
}
