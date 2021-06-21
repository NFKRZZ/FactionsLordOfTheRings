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
import com.google.gson.JsonDeserializer;
import com.google.gson.reflect.TypeToken;
import com.massivecraft.factions.FPlayer;
import com.massivecraft.factions.Faction;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;

public class Utils 
{
    public static void Log(String message)
    {
        Bukkit.getConsoleSender().sendMessage("[FactionsUUIDLOTR] "+message);
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
    // public static <T> ArrayList<T> Deserialize(String Directory,Class<T> clazz )
    // {
       
    //     try
    //     {
    //         File file = new File(Main.pluginDirectory.getAbsolutePath(),Directory);
    //         if(file.exists()&&file.isFile())
	// 	    {
	// 		    Utils.Log(ChatColor.GREEN+"File Exists");
	// 	    }
	// 	    else if(!file.exists())
	// 	    {
	// 			file.createNewFile();
	// 			Utils.Log(ChatColor.RED+"File at "+file.getAbsolutePath()+" Didn't Exist, Created New File");
    //             return null;
	// 	    }
    //         GsonBuilder builder = new GsonBuilder().serializeNulls();
    //         Gson gson = builder.create();
    //         BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
    //         //Type type = new TypeToken<ArrayList<T>>(){}.getType();
    //         Type type = TypeToken.getParameterized(ArrayList.class, clazz).getType();
    //         Utils.Log(type+" this is type");
            
    //         return gson.fromJson(bufferedReader, type);
    //     }
    //     catch(Exception e)
    //     {
    //         return null;
    //     }
    // } 
    public static List<LotrSect> DeserializeSect()
    {
         try
         {
            File file = new File(Main.pluginDirectory.getAbsolutePath(),"sect.json");
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
            builder.registerTypeAdapter(Location.class, new LocationTypeAdapter()).setPrettyPrinting();
            Gson gson = builder.create();
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            Type type = new TypeToken<List<LotrSect>>(){}.getType();
            Utils.Log(ChatColor.GREEN+"LOADING UP SECTS AHAHAHAHA");
            return gson.fromJson(bufferedReader, type);
            

        }
        catch(Exception e)
        {
            Utils.Log(ChatColor.DARK_RED+"HELLO WWE DON");
            Utils.Log(e.toString());
            return null;
        }
    }
    public static List<LotrFaction> DeserializeFaction()
    {
        try
        {
           File file = new File(Main.pluginDirectory.getAbsolutePath(),"faction.json");
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
           builder.registerTypeAdapter(Location.class, new LocationTypeAdapter()).setPrettyPrinting();
           builder.registerTypeAdapter(Faction.class, new FactionInstanceCreator()).create();
           Gson gson = builder.create();
           BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
           Type type = new TypeToken<List<LotrFaction>>(){}.getType();
           return gson.fromJson(bufferedReader, type);

       }
       catch(Exception e)
       {
            Utils.Log(ChatColor.DARK_RED+"BIG BAD ERROR DESERIALIZING FACTION");
            Utils.Log(e.toString());
           return null;
       }
    }
    public static List<LotrFPlayer> DeserializePlayer()
    {
        try
        {
           File file = new File(Main.pluginDirectory.getAbsolutePath(),"player.json");
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
           builder.registerTypeAdapter(Location.class, new LocationTypeAdapter()).setPrettyPrinting();
           builder.registerTypeAdapter(FPlayer.class, new FPlayerInstanceCreator()).create();
           Gson gson = builder.create();
           BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
           Type type = new TypeToken<List<LotrFPlayer>>(){}.getType();
           return gson.fromJson(bufferedReader, type);
        }
        catch(Exception e)
        {
             Utils.Log(ChatColor.DARK_RED+"BIG ERROR DESERIALIZING PLAYER");
             Utils.Log(e.toString());
             return null;
        }
    }
    public static List<War> DeserializeWar()
    {
        try
        {
           File file = new File(Main.pluginDirectory.getAbsolutePath(),"war.json");
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
           builder.registerTypeAdapter(Location.class, new LocationTypeAdapter()).setPrettyPrinting();
           Gson gson = builder.create();
           BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
           Type type = new TypeToken<List<War>>(){}.getType();
           return gson.fromJson(bufferedReader, type);
        }
        catch(Exception e)
        {
             Utils.Log(ChatColor.DARK_RED+"BIG ERROR DESERIALIZING WARS");
             Utils.Log(e.toString());
             return null;
        }
    }
}
