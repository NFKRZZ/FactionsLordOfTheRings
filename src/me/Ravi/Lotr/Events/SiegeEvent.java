package me.Ravi.Lotr.Events;

import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

import me.Ravi.Lotr.LotrFaction;
import me.Ravi.Lotr.Settlement;

public class SiegeEvent extends Event implements Cancellable
{
    public LotrFaction sieger;
    public LotrFaction defender;
    public Settlement settlement;
    boolean isCancelled;
    @Override
    public HandlerList getHandlers()
    {
        
        return null;
    }
    public SiegeEvent(LotrFaction sieger, LotrFaction defender,Settlement settlement)
    {
        this.sieger = sieger;
        this.defender = defender;
        this.settlement = settlement;
    }
    @Override
    public boolean isCancelled()
    {
        
        return isCancelled;
    }
    @Override
    public void setCancelled(boolean arg0)
    {        
        isCancelled = arg0;
    }  
    public void modifyReinforcements(int a)
    {
        
    }
    public void modifyDaysToHoldOut(int b)
    {

    }
       
}
