package com.example.shopping2;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ExpandableListView;
import android.widget.Toast;
import android.widget.ExpandableListView;
import android.widget.ExpandableListView.OnChildClickListener;
import android.widget.ExpandableListView.OnGroupClickListener;
import android.widget.ExpandableListView.OnGroupCollapseListener;
import android.widget.ExpandableListView.OnGroupExpandListener;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    /**
     *
     *  List Components
     */
    ExpandableListAdapter listAdapter;
    ExpandableListView expListView;
    List<String> listDataHeader;








    /**
     *  Hashmap for easy loopup of the items in the list
     *
     */
    HashMap<String, List<String>> listDataChild;

    /**
     *
     *  Button, TextView, and EditText Components
     *
     */
    EditText itemName, itemPrice, itemQuantity;
    Button add;

    /**
     *
     *  String, int, and other variables
     *
     */

    String itmName, itmPrice, itmAmount;
    int numItmPrice, numItmAmount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        /*

            Top item component instantiation: TextView, EditText and Buttons
         */

        itemName = (EditText)findViewById(R.id.et_item_name);
        itemPrice = (EditText)findViewById(R.id.et_item_amount);
        itemQuantity = (EditText)findViewById(R.id.et_item_quantity);

        //Button add instantiation and on click listener
        add = (Button)findViewById(R.id.btnAdd);
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                itmName = itemName.getText().toString();

                itmPrice = itemPrice.getText().toString();
                numItmPrice = Integer.parseInt(itmPrice);

                itmAmount = itemQuantity.getText().toString();
                numItmAmount = Integer.parseInt(itmAmount);

                itmName = itemName.getText().toString();
                /**
                 *      Test to see if all information was be taken in and correctly by the
                 *      button click listener on click
                 *
                 *      Test successfull!!
                 *
                 *      Uncomment as needed for testing and debbuging purposes
                 */
                Toast.makeText(MainActivity.this, "Name: " + itmName + " \nPrice: " + itmPrice + "\n Amount: " + itmAmount + "\n Nums: " + Integer.toString(numItmPrice) + " : " + Integer.toString(numItmAmount), Toast.LENGTH_SHORT).show();




            }
        });


        // get the listview
        expListView = (ExpandableListView) findViewById(R.id.expandableListView);





        // preparing list data
        prepareListData();

        listAdapter = new ExpandableListAdapter(this, listDataHeader, listDataChild);

        // setting list adapter
        expListView.setAdapter(listAdapter);



        // Listview Group click listener
        expListView.setOnGroupClickListener(new OnGroupClickListener() {

            @Override
            public boolean onGroupClick(ExpandableListView parent, View v,
                                        int groupPosition, long id) {
                // Toast.makeText(getApplicationContext(),
                // "Group Clicked " + listDataHeader.get(groupPosition),
                // Toast.LENGTH_SHORT).show();
                return false;
            }
        });

        // Listview Group expanded listener
        expListView.setOnGroupExpandListener(new OnGroupExpandListener() {

            @Override
            public void onGroupExpand(int groupPosition) {
                Toast.makeText(getApplicationContext(),
                        listDataHeader.get(groupPosition) + " Expanded",
                        Toast.LENGTH_SHORT).show();
            }
        });

        // Listview Group collasped listener
        expListView.setOnGroupCollapseListener(new OnGroupCollapseListener() {

            @Override
            public void onGroupCollapse(int groupPosition) {
                Toast.makeText(getApplicationContext(),
                        listDataHeader.get(groupPosition) + " Collapsed",
                        Toast.LENGTH_SHORT).show();

            }
        });

        // Listview on child click listener
        expListView.setOnChildClickListener(new OnChildClickListener() {

            @Override
            public boolean onChildClick(ExpandableListView parent, View v,
                                        int groupPosition, int childPosition, long id) {
                // TODO Auto-generated method stub
                Toast.makeText(
                        getApplicationContext(),
                        listDataHeader.get(groupPosition)
                                + " : "
                                + listDataChild.get(
                                listDataHeader.get(groupPosition)).get(
                                childPosition), Toast.LENGTH_SHORT)
                        .show();
                return false;
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






    /*
    * Preparing the list data
    */
    private void prepareListData() {
        listDataHeader = new ArrayList<String>();
        listDataChild = new HashMap<String, List<String>>();

        // Adding child data
        listDataHeader.add(" Shopping List");
        //listDataHeader.add("List Pending");
        //listDataHeader.add("List Pending");

        // Adding child data
        List<String> shopList = new ArrayList<String>();
        //shopList.add(itmName + ", " + itmPrice + ", " + itmAmount);

        shopList.add("The Godfather");

        shopList.add("The Godfather: Part II");
        shopList.add("Pulp Fiction");
        shopList.add("The Good, the Bad and the Ugly");
        shopList.add("The Dark Knight");
        shopList.add("12 Angry Men");


        /***
         *
         *      WIll work on in the future
         *
         *      To implement:
         *
         *      1) Multiple List
         *      2) Name of list from User
         *      3) Additional Features....
         */

        /**
         *      List 2 and 3 already in place...uncomment when ready to use
         *
         */

        /**
         *          List 2
         *

        List<String> nowShowing = new ArrayList<String>();
        nowShowing.add("The Conjuring");
        nowShowing.add("Despicable Me 2");
        nowShowing.add("Turbo");
        nowShowing.add("Grown Ups 2");
        nowShowing.add("Red 2");
        nowShowing.add("The Wolverine");

         */

        /**
         *          List 3
         *


        List<String> comingSoon = new ArrayList<String>();
        comingSoon.add("2 Guns");
        comingSoon.add("The Smurfs 2");
        comingSoon.add("The Spectacular Now");
        comingSoon.add("The Canyons");
        comingSoon.add("Europa Report");

         */
        /**
         *  Add each list to the array...
         *
         */

        //list 1
        listDataChild.put(listDataHeader.get(0), shopList); // Header, Child data

        //list 2
       // listDataChild.put(listDataHeader.get(1), nowShowing);

        //list 3
       // listDataChild.put(listDataHeader.get(2), comingSoon);
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
