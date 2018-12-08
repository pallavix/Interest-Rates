package e.pallavidash.dictionary;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.Dictionary;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

import stanford.androidlib.SimpleActivity;
import stanford.androidlib.SimpleList;

public class MainActivity extends SimpleActivity {


    private Map<String,String> DICTIONARY;
    private void readFileData(){
        Scanner scan  = new Scanner (getResources().openRawResource(R.raw.grewords));
        while (scan.hasNextLine())
        {
            String line = scan.nextLine();
            String[] parts = line.split("\t");
            DICTIONARY.put(parts[0],parts[1]);
        }


    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DICTIONARY = new HashMap<>();
        readFileData();

        Spinner list = $(R.id.word_list);
        SimpleList.with(this)

                .setItems(list,DICTIONARY.keySet());
        list.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()

        {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                String word = parent.getItemAtPosition(position).toString();
                String defn = DICTIONARY.get(word);
                toast(defn);

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
            
            public void onNothingSelected(AdapterView<?> parent, View view, int position, long id) {

            }




    });
}}





