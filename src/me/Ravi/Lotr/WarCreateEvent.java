package me.Ravi.Lotr;

import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

public class WarCreateEvent extends Event
{
    private final War war;
    private final LotrFaction declarer;
    private final LotrFaction target;
    public WarCreateEvent(War war, LotrFaction declarer, LotrFaction target)
    {
        this.war = war;
        this.declarer = declarer;
        this.target = target;
    }
    @Override
    public HandlerList getHandlers() 
    {
        return null;
    }
    public LotrFaction getDeclarer()
    {
        return declarer;
    }
    public LotrFaction getTarget()
    {
        return target;
    }
    
}
