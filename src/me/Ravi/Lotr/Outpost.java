package me.Ravi.Lotr;

import java.util.Collections;

import org.bukkit.Location;

public class Outpost extends Settlement
{
     int reinforcements;
     int daysToHoldOut;
     public Outpost(int reinforcements,Location loc, String name)
     {   
          this.reinforcements = reinforcements;
          super.location = loc;
          super.settlerList = Collections.<Citizen>emptyList();
          super.funds = 10;
          super.name = name;
          daysToHoldOut = 8;
     }
     public void reinforce(int amount)
     {
          reinforcements+=amount;
     }
     public void decrementDays()
     {
          daysToHoldOut--;
     }
}
