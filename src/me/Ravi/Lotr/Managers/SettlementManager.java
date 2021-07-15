package me.Ravi.Lotr.Managers;

import java.util.ArrayList;
import java.util.List;

import me.Ravi.Lotr.Settlement;

public class SettlementManager 
{
    public static List<Settlement> settlementList = new ArrayList<Settlement>();
    public static void collectIncome()
    {
        for(Settlement s: settlementList)
        {
            s.sumIncome();
            s.funds = s.totalIncome;
            s.resetIncome();
        }
    }
    public static void Happiness()
    {
        for(Settlement s: settlementList)
        {
            s.sumHappiness();
        }
    }
}
