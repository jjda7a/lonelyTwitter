package ca.ualberta.cs.lonelytwitter;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Date;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
/**
*Main Activity of the Lonely Twitter App. Does this, this this..
*
* @author justin
 *@see Tweet
* @version2.3
*
 */
public class LonelyTwitterActivity extends Activity {
    /**
     * array is for ...
     * @see #loadFromFile() l
     *
     */


    private int calculateTweetSize() {
        //
        return -1;
    }

    private String removeStopWords(String text) {
        //
        return "";
    }

    /**
     * This starts the next activity which is...
     * @param intent This is the intent to be run immediately after hitting "start" button
     *@deprecated
     */
    private void startSecondActivity(Intent intent){
        //
    }

    /**
     *
     * @param s is some parameter
     * @returnThe value that is used for some job
     * @throws ...
     * @deprecated
     */
    public String someMethod(String s){
        return "";
    }


    private static final String FILENAME = "file.sav";
    private EditText bodyText;
    private ListView oldTweetsList;

    private ArrayList<Tweet> tweets = new ArrayList<Tweet>();
    private ArrayAdapter<Tweet> adapter;

    /** Called when the activity is first created.
     * @param savedInstanceState
     *
     * */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        bodyText = (EditText) findViewById(R.id.body);
        Button saveButton = (Button) findViewById(R.id.save);
        Button clearButton = (Button) findViewById(R.id.clear);
        oldTweetsList = (ListView) findViewById(R.id.oldTweetsList);

        saveButton.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                setResult(RESULT_OK);
                String text = bodyText.getText().toString();
                Tweet latestTweet = new NormalTweet(text);
                ImportantTweet latestImportantTweet = new ImportantTweet(text);
                // latestTweet.setMessage(latestTweet.getMessage() + "!");
                tweets.add(latestTweet);
                adapter.notifyDataSetChanged();
                saveInFile();
                //saveInFile(text, new Date(System.currentTimeMillis()));
                //finish();

            }
        });
        clearButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
            //clear tweets on disk & remove tweets on screen
                tweets.clear();
                adapter.notifyDataSetChanged();
                saveInFile();

            }
        });
    }

    /**
     * Calls on loadfile function and updates the main activity list
     */
    @Override
    protected void onStart() {
        // TODO Auto-generated method stub
        super.onStart();
        //String[] tweets = loadFromFile();
        loadFromFile();
        adapter = new ArrayAdapter<Tweet>(this,
                R.layout.list_item, tweets);
        oldTweetsList.setAdapter(adapter);
    }

    /**
     * loads from file
     *
     * @throws RuntimeException
     *
     * @see Gson
     */
    private void loadFromFile() {
        try {
            FileInputStream fis = openFileInput(FILENAME);
            BufferedReader in = new BufferedReader(new InputStreamReader(fis));
            Gson gson = new Gson();

            // Took from https://google-gson.googlecode.com/svn/trunk/gson/docs/javadocs/com/google/gson/Gson.html 01-19 2016
            Type listType = new TypeToken<ArrayList<NormalTweet>>() {}.getType();
            tweets = gson.fromJson(in, listType);

        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            tweets = new ArrayList<Tweet>();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            throw new RuntimeException();
        }
    }

    /**
     * Saves tweets to file
     * @throws RuntimeException
     * @see Gson
     *
     */
    private void saveInFile() {
        try {
            FileOutputStream fos = openFileOutput(FILENAME,
                    0);
            BufferedWriter out = new BufferedWriter(new OutputStreamWriter(fos));
            Gson gson = new Gson();
            gson.toJson(tweets, out);
            out.flush();
            fos.close();
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            throw new RuntimeException();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            throw new RuntimeException();
        }
    }

}