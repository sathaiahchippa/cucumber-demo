package com.emmasuzuki.cucumberespressodemo.test;

//Following imports are necessary for JSON parsing

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;

import cucumber.api.Scenario;
import cucumber.api.java.Before;

import static android.support.test.InstrumentationRegistry.getInstrumentation;


/**
 * Created by sathaiah on 1/23/16.
 */
public class Data {

    private static String scenarioName;

    public static String get(String data_in) {
 //       System.out.println("i am in");

        JSONObject json_object = parseJSONData();

        String data_out = null;
        // handle a structure into the json object
        JSONObject structure = null;
        //String sName = new Instrumentation().getScenarioName();
        String scenario = null;
        Iterator<String> keys = json_object.keys();
        while (keys.hasNext()){
            String key = keys.next();
            if(key.contains(scenarioName)){
                scenario = key;
                break;
            }
        }

        if(scenario != null){
            try {
                structure = (JSONObject) json_object.get(scenario);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        else {
            try {
                structure = (JSONObject) json_object.get("Default");
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }

/*        try {
            structure = (JSONObject) json_object.get(scenarioName);
        } catch (JSONException e) {
            try {
                structure = (JSONObject) json_object.get("Default");
            } catch (JSONException e1) {
                e1.printStackTrace();
            }
        }*/

 //           System.out.println("Structure: "+ structure);

/*        Object obj = null;
        try {
            obj = structure.get(data_in);
        } catch (JSONException e) {
            System.out.println("Test data: " + data_in + ", is not found, for scenario: " + scenarioName);
        }
        System.out.println(obj);*/

        try {
            data_out = (String) structure.get(data_in);
        } catch (JSONException e) {
            System.out.println("Test data: " + data_in + ", is not found, for scenario: " + scenarioName);
        }
//        System.out.println(data_out);
        return data_out;
    }


    //Method that will parse the JSON file and will return a JSONObject
    public static JSONObject parseJSONData() {
        String json_str = null;
        JSONObject json_data = null;
        try {

            //open the inputStream to the file
            InputStream inputStream = getInstrumentation().getContext().getAssets().open("data.json");

            int sizeOfJSONFile = inputStream.available();

            //array that will store all the data
            byte[] bytes = new byte[sizeOfJSONFile];

            //reading data into the array from the file
            inputStream.read(bytes);

            //close the input stream
            inputStream.close();

            json_str = new String(bytes, "UTF-8");
            json_data = new JSONObject(json_str);


        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
        catch (JSONException x) {
            x.printStackTrace();
            return null;
        }
        return json_data;
    }

    @Before
    public static void getScenarioName(Scenario scenario) {
        scenarioName = scenario.getName();
    }


}
