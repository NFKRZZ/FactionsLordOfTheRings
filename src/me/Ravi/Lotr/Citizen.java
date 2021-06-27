package me.Ravi.Lotr;

import java.util.Random;

public class Citizen 
{
    public int income;
    //public String name;
    double age;
    int happiness;
    boolean male;
    public Citizen()
    {
        Random random = new Random();
        male = random.nextBoolean();
        age = random.nextInt(50);
    }
    public void incrementAge()
    {
        age++;
    }
    public double getAge()
    {
        return age;
    }
    public int getHappiness()
    {
        return happiness;
    }
}
