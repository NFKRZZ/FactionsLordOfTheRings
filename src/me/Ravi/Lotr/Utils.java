package me.Ravi.Lotr;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;

public class Utils 
{
    public static void Log(String message)
    {
        Bukkit.getConsoleSender().sendMessage(message);
    }
    public static boolean Serialize(Object object,String Directory)
    {
        boolean works = false;
        try
        {
            File outFile = new File(Main.pluginDirectory.getAbsolutePath(),Directory);
            if(outFile.exists()&&outFile.isFile())
            {

            }
            else if(!outFile.exists())
            {
                    outFile.createNewFile();
            }
            FileOutputStream file = new FileOutputStream(outFile); 
            ObjectOutputStream out = new ObjectOutputStream(file);
            out.writeObject(object);
            out.close();
            file.close();
            works = true;
        }
        catch(Exception e)
        {
            works = false;
        }
        return works;
    }   
    public static Object Deserialize(String Directory)
    {
        Object rObject = null;
        try
        {
            File file = new File(Main.pluginDirectory.getAbsolutePath(),Directory);
            if(file.exists()&&file.isFile())
		    {
			    Utils.Log(ChatColor.GREEN+"File Exists");
		    }
		    else if(!file.exists())
		    {
				file.createNewFile();
				Utils.Log(ChatColor.RED+"File at "+file.getAbsolutePath()+" Didn't Exist, Created New File");
		    }
            FileInputStream filez = new FileInputStream(file); 
		    ObjectInputStream out = new ObjectInputStream(filez);
            rObject = out.readObject();
            out.close();
            filez.close();
        }
        catch(Exception e)
        {

        }
        return rObject;
    } 
}
