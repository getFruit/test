package utils;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.List;

import javax.lang.model.util.Types;

import bean.Category;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;

public class JsonUtil {
	private static Gson gson=new Gson();
	
	
	public static Gson getGson() {
		
		return gson==null? gson=new Gson():gson;
	}


	public static List<Category> json2Objects(String json){
		return gson.fromJson(json, new TypeToken<List<Category>>() { }.getType());
		
	}
	
	public static <T> List<T> json2Objects(String json ,T clazz){
		return (List<T>)gson.fromJson(json, new TypeToken<List<T>>() { }.getType());
		
	}
	
	public static String objectToJson(Object o){
		return gson.toJson(o);
		
	}

	
	public static Object readJson(String pathandfilename) {
		/*try {
			return gson.fromJson(new FileReader(pathandfilename), Category.class);
		} catch (JsonSyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonIOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
        
		
		File file = new File(pathandfilename);
        System.out.println(file.getAbsolutePath());
        BufferedReader reader = null;
        StringBuffer data = new StringBuffer();
        try {
            reader = new BufferedReader(new FileReader(file));
            String temp = null;
            while((temp = reader.readLine()) != null){
                data.append(temp);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (reader != null){
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return data.toString();
    }
	
	
    public static void WriteToJsonFile(String fileName,String json){
        BufferedWriter writer = null;
        File file = new File(fileName);
        if(!file.exists()){
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        try {
            writer = new BufferedWriter(new FileWriter(file));
            writer.write(json);
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                if(writer != null){
                    writer.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}