package me.Ravi.Lotr.Events;

import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

import me.Ravi.Lotr.LotrFaction;

public class LotrFactionCreateEvent extends Event 
{
    private static final HandlerList handlers = new HandlerList();
    private final LotrFaction faction;
    public LotrFactionCreateEvent(LotrFaction fac)
    {
        faction = fac;
    }
    public void cancelEvent()
    {
        
    }
    @Override
    public HandlerList getHandlers() 
    {
       
        return null;
    }
    
}
