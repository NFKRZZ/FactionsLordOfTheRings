package me.Ravi.Lotr;

import java.util.ArrayList;
import java.util.List;

public class SettlementManager 
{
    static List<Settlement> settlementList = new ArrayList<Settlement>();
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
