package com.example.maciej.myapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        TextView tv = (TextView)findViewById(R.id.textView1);


//        DatabaseController dc = new DatabaseController(this);

//        tv.setText("");
//
//        for(Product p: dc.getByName(""))
//        {
//            Log.d("Data from database: ", p.getNr()+ " " + p.getName() + " " + p.getCalories() +
//            " " + p.getCarbo() + " " + p.getProtein() + " " + p.getFat());
//        }

//        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);

//
//        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });
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

    public void aboutAuthor(View view)
    {
        Intent intent = new Intent(this, AboutActivity.class);
        startActivity(intent);
    }

    public void showActivityCalculateDailyLimit(View view)
    {
        Intent intent = new Intent(this, CalculateActivity.class);
        startActivity(intent);
    }

    public void addPlan(View view)
    {
        Intent intent = new Intent(this, AddPlanActivity.class);
        startActivity(intent);
    }



}