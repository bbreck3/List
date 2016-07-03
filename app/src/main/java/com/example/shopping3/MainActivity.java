package com.example.shopping3;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    EditText itmName, itmPrice, itmAmount;
    Button btnAdd, btnReset;
    ArrayList<String> items;
    ListView listView;
    ArrayAdapter<String> arrayAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //EditText Stuff
        items = new ArrayList<String>();
        itmName = (EditText)findViewById(R.id.et_item_name);
        itmAmount = (EditText)findViewById(R.id.et_item_amount);
        itmPrice = (EditText)findViewById(R.id.et_item_quantity);

        //List Stuff
        listView = (ListView)findViewById(R.id.listView);
        arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,android.R.id.text1,items);
        listView.setAdapter(arrayAdapter);

        //Get list item info stuff
        // ListView Item Click Listener
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {

                // ListView Clicked item index
                int itemPosition     = position;

                // ListView Clicked item value
                String  itemValue    = (String) listView.getItemAtPosition(position);

                // Show Alert
                Toast.makeText(getApplicationContext(),
                        "Position :"+itemPosition+"  ListItem : " +itemValue , Toast.LENGTH_LONG)
                        .show();

            }

        });


        /**
         *      BUTTONS
         *
         */
        //Button --> ADD
        btnAdd = (Button)findViewById(R.id.btnAdd);
        btnAdd.setOnClickListener(new View.OnClickListener(){

            public void onClick(View v){
                //if(!Character.isDigit(itmPrice.getText().toString().charAt(0)) || !Character.isDigit(itmAmount.getText().toString().charAt(0)) || !Character.isLetter(itmName.getText().toString().charAt(0))){
                  if(itmAmount.getText().toString() =="" || itmName.getText().toString() =="" || itmPrice.getText().toString() ==""){
                      Toast.makeText(getApplicationContext(), "No information to add", Toast.LENGTH_SHORT).show();
                } else {
                      String temp = "";
                      String name = itmName.getText().toString();
                      String price = itmAmount.getText().toString();
                      String quantity = itmPrice.getText().toString();

                      temp += name + ", " + price + ", " + quantity;
                      if (temp == "") {
                          Toast.makeText(getApplicationContext(), "No information to add", Toast.LENGTH_SHORT).show();
                      } else {
                          items.add(temp);
                      }
                  }
            }
        });

        //Button --> RESET
        btnReset = (Button)findViewById(R.id.btnReset);
        btnReset.setOnClickListener(new View.OnClickListener(){

            public void onClick(View v){
                items.clear();
                arrayAdapter.clear();
                Toast.makeText(getApplicationContext(), "List cleared", Toast.LENGTH_SHORT).show();
            }
        });



        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
