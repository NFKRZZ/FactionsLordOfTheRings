package me.Ravi.Lotr;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Location;

public class Settlement 
{
    List<Citizen> settlerList = new ArrayList<Citizen>();
    String name;
    public int totalIncome;
    Location location;
    boolean underSiege;
    public double funds;
    SettlementState state;
    double percentGrowth;
    public void sumIncome()
    {
        totalIncome = 0;
        for(Citizen c: settlerList)
        {
            totalIncome+=c.income;
        }
    }
    public void resetIncome()
    {
        totalIncome=0;
    }
    public int sumHappiness()
    {
        int happiness = 0;
        for(Citizen c: settlerList)
        {
            happiness+=c.happiness;
        }
        return (happiness/settlerList.size());
    } 
    @Override
    public String toString()
    {
        return name;
    }   

}
enum SettlementState
{
    VERY_CONTENT,
    CONTENT,
    INCONTENT,
    REVOLTING
}
