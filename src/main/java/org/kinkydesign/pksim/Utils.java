package org.kinkydesign.pksim;

import javax.ejb.Stateless;
import javax.json.JsonObject;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

@Stateless
public class Utils {

    static String path ="C:\\Users\\Angelos\\Desktop\\PKSimFiles\\";

    public static void createFileWithJsonObject(JsonObject jsonObject, String filename) throws IOException {
        BufferedWriter out = null;
        try
        {
            FileWriter fstream = new FileWriter(path+ filename, false); //true tells to append data.
            out = new BufferedWriter(fstream);
            out.write(jsonObject.toString());
            out.flush();
        }
        catch (IOException e)
        {
            System.err.println("Error: " + e.getMessage());
        }
        finally
        {
            if(out != null) {
                out.close();
            }
        }
    }
}
