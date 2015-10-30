package com.example.antoine.calendrier;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Html;
import android.text.InputType;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AbsListView;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

public class MatiereActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_matiere);


        TableLayout tata = (TableLayout) findViewById(R.id.table_matier_cour);
        TableLayout tata2 = (TableLayout) findViewById(R.id.table_matier_fini);

        String toupi[][] = new String[][]{
                {"ITIL","Robert","3 crédits","17.5h","100%","Indice : 3"},
                {"Python","De villoda","4 crédits","30h","100%","Indice : 3.5"},
                {"Méthodologie Dévellopement","Robert","4 crédits","25h","33%","Indice : 4"},
                {"Swift","Robert","4 crédits","35h","15%","Indice : 4.5"},
                {"C#","Robert","4 crédits","35h","15%","Indice : 4.5"},
        };



        for(int i = 0; i < 5; i++) {

            TableRow titi = new TableRow(this);
            titi.setLayoutParams(new
                    AbsListView.LayoutParams(AbsListView.LayoutParams.MATCH_PARENT, AbsListView.LayoutParams.WRAP_CONTENT));

            TableRow titi2 = new TableRow(this);
            titi2.setLayoutParams(new
                    AbsListView.LayoutParams(AbsListView.LayoutParams.MATCH_PARENT, AbsListView.LayoutParams.WRAP_CONTENT));

            TextView tri = new TextView(this);
            TextView tri2 = new TextView(this);
            tri.setText("      " + toupi[i][0]);
            tri.setTextSize(14);



            //tri2.setText("                   " + toupi[i][1] + " / " + toupi[i][2] + " / " + toupi[i][3] + " / " + toupi[i][4] + " / " + toupi[i][5]);
            tri2.setTextSize(10);
            String espace = "";
            for (int yy = 0; yy < 17; yy ++ )
            {
                espace = espace + "&nbsp;";
            }

            tri2.setText(Html.fromHtml(espace
                    + toupi[i][1] + " / " + toupi[i][2] + " / " + toupi[i][3]
                    + " / " + toupi[i][4] + " / " + "<font color=red>" + toupi[i][5]));



            titi.addView(tri);
            titi2.addView(tri2);

            tata.addView(titi);
            tata.addView(titi2);
        }

        for(int i = 0; i < 5; i++) {

            TableRow titi = new TableRow(this);
            titi.setLayoutParams(new
                    AbsListView.LayoutParams(AbsListView.LayoutParams.MATCH_PARENT, AbsListView.LayoutParams.WRAP_CONTENT));

            TableRow titi2 = new TableRow(this);
            titi2.setLayoutParams(new
                    AbsListView.LayoutParams(AbsListView.LayoutParams.MATCH_PARENT, AbsListView.LayoutParams.WRAP_CONTENT));

            TextView tri = new TextView(this);
            TextView tri2 = new TextView(this);
            tri.setText("      " + toupi[i][0]);
            tri.setTextSize(14);

            tri2.setText("                   " + toupi[i][1] + " / " + toupi[i][2] + " / " + toupi[i][3] + " / " + toupi[i][4] + " / " + toupi[i][5]);
            tri2.setTextSize(10);

            titi.addView(tri);
            titi2.addView(tri2);

            tata2.addView(titi);
            tata2.addView(titi2);
        }





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
