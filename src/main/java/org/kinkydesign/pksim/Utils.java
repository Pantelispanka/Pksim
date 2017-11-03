package org.kinkydesign.pksim;

import javax.ejb.Stateless;
import javax.json.JsonObject;
import java.io.*;

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

    public String runRScript(String rTrainModelPath, String jsonFileName ){
        //String pythonScriptPath = "C:\\Users\\Angelos\\Desktop\\wildfly-10.1.0.Final\\pythonHello.py";
        String[] cmd = new String[2];
        cmd[0] = "R"; // check version of installed python: python -V
        cmd[1] = rTrainModelPath;

        // create runtime to execute external command
        Runtime rt = Runtime.getRuntime();
        Process pr = null;
        try {
            pr = rt.exec(cmd);
        } catch (IOException e) {
            e.printStackTrace();
        }

        StringBuilder stringBuilder = new StringBuilder();
        // retrieve output from python script
        BufferedReader bfr = new BufferedReader(new InputStreamReader(pr.getInputStream()));
        String line = "";
        try {
            while ((line = bfr.readLine()) != null) {
                // display each output line form python script
                stringBuilder.append(line);
                //System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return stringBuilder.toString();
    }
}
