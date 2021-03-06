package com.example.antoine.calendrier;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TableRow;
import android.widget.TextView;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button boulogin = (Button) findViewById(R.id.boutonlogin);
        boulogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, PlanningActivity.class);
                startActivity(intent);
            }
        });

        /*

        String myHexColor = "#CC2233";

        TextView texty = (TextView) findViewById(R.id.lundi1);
        texty.setBackgroundColor(Color.parseColor(myHexColor));
        TextView texty2 = (TextView) findViewById(R.id.samedi5);
        texty2.setBackgroundColor(Color.parseColor(myHexColor));

        texty.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View V){
                setContentView(R.layout.matier_descrip);

            }
        });
        **/



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
