package me.Ravi.Lotr;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;

public class Utils 
{
    public static void Log(String message)
    {
        Bukkit.getConsoleSender().sendMessage(message);
    }
    public static boolean Serialize(Object object,String Directory)
    {
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
            GsonBuilder builder = new GsonBuilder().serializeNulls();
            builder.registerTypeAdapter(Location.class, new LocationTypeAdapter()).setPrettyPrinting();
            Gson gson = builder.create();
            FileWriter Writer = new FileWriter(file);
            Writer.write(gson.toJson(object));
            Writer.close();
       }
       catch(Exception e)
       {
           Utils.Log(ChatColor.RED+e.toString());
            return false;
       }
       return true;
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
                return null;
		    }
            GsonBuilder builder = new GsonBuilder().serializeNulls();
            Gson gson = builder.create();
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            Type type = new TypeToken<List<Object>>(){}.getType();
            rObject = gson.fromJson(bufferedReader, type);
        }
        catch(Exception e)
        {

        }
        return rObject;
    } 
}
