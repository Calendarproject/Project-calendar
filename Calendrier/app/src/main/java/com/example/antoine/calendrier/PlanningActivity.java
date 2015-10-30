package com.example.antoine.calendrier;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.graphics.Color;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

public class PlanningActivity extends AppCompatActivity {

    int jourSemaine = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_planning);
        TextView titi = (TextView) findViewById(R.id.lundi1);
        String myHexColor = "#CC2233";
        //titi.setBackgroundColor(Color.parseColor(myHexColor));

        titi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View V) {
                AlertDialog alertDialog = new AlertDialog.Builder(PlanningActivity.this).create();
                alertDialog.setTitle("Python - De Villoda - Chartrons G1");
                Date d = new Date();
                SimpleDateFormat sdf = new SimpleDateFormat("dd-MM");
                String dayOfTheWeek = sdf.format(d);
                alertDialog.setMessage("8h45 - 12h15");
                alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                            }
                        });
                alertDialog.show();

            }
        });
        calendrieSemaine();

        Spinner spi = (Spinner) findViewById(R.id.semaine_planning);
        spi.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Spinner spi2 = (Spinner) findViewById(R.id.semaine_planning);

                TextView textLundi2 = (TextView) findViewById(R.id.lundi);

                if (spi2.getSelectedItem().toString().equals("Semaine 2")) {

                    calendrieSemaine2();

                }

                if (spi2.getSelectedItem().toString().equals("Semaine 1")) {

                    calendrieSemaine();

                }


            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        matier_Semaine();

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


        if (item.toString().equals("Matières"))
        {
            Intent intent = new Intent(PlanningActivity.this, MatiereActivity.class);
            startActivity(intent);
        }

        else if (item.toString().equals("Projets"))
        {
            Intent intent = new Intent(PlanningActivity.this, ProjetActivity.class);
            startActivity(intent);
        }

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private void calendrieSemaine ()
    {
        Date d = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("EEEE");
        SimpleDateFormat sdf5 = new SimpleDateFormat("MMMM");
        String dayOfTheWeek = sdf.format(d);
        String tonpere = sdf5.format(d);


        Calendar cal = Calendar.getInstance();
        SimpleDateFormat sdf3 = new SimpleDateFormat("dd");

        int ecart = 0;


        int joutL = 0;
        int joutM = 0;
        int joutMe = 0;
        int joutJ = 0;
        int joutV = 0;
        int joutS = 0;
        int joutD = 0;

        TextView textLundi = (TextView) findViewById(R.id.lundi);
        TextView textMardi = (TextView) findViewById(R.id.mardi);
        TextView textMercredi = (TextView) findViewById(R.id.mercredi);
        TextView textJeudi = (TextView) findViewById(R.id.jeudi);
        TextView textVendredi = (TextView) findViewById(R.id.vendredi);
        TextView textSamedi = (TextView) findViewById(R.id.samedi);
        TextView textDimanche = (TextView) findViewById(R.id.dimanche);

        String myHexColor = "#CC2233";

        switch (dayOfTheWeek){
            case "lundi" :
            case "Monday":
                textLundi.setTextColor(Color.parseColor(myHexColor));
                ecart = 0;
                break;
            case "dimanche" :
                textDimanche.setTextColor(Color.parseColor(myHexColor));
                ecart = 6;
                jourSemaine = 6;
                break;

        }
        cal.add(Calendar.DATE, -ecart);
        joutL = Integer.valueOf(sdf3.format(cal.getTime()));
        cal.add(Calendar.DATE,1);
        joutM = Integer.valueOf(sdf3.format(cal.getTime()));
        cal.add(Calendar.DATE,1);
        joutMe = Integer.valueOf(sdf3.format(cal.getTime()));
        cal.add(Calendar.DATE,1);
        joutJ = Integer.valueOf(sdf3.format(cal.getTime()));
        cal.add(Calendar.DATE,1);
        joutV = Integer.valueOf(sdf3.format(cal.getTime()));
        cal.add(Calendar.DATE,1);
        joutS = Integer.valueOf(sdf3.format(cal.getTime()));
        cal.add(Calendar.DATE,1);
        joutD = Integer.valueOf(sdf3.format(cal.getTime()));

        textLundi.setText("L " + (joutL));

        textMardi.setText("M " + (joutM));
        textMercredi.setText("M " + (joutMe));
        textJeudi.setText("J " + joutJ);
        textVendredi.setText("V " + joutV);
        textSamedi.setText("S " + joutS);
        textDimanche.setText("D " + joutD);

        TextView textyto = (TextView) findViewById(R.id.date_semaine);
        textyto.setText(tonpere);


    }

    private void calendrieSemaine2 ()
    {

        Calendar cal = Calendar.getInstance();
        SimpleDateFormat sdf3 = new SimpleDateFormat("dd");
        SimpleDateFormat sdf5 = new SimpleDateFormat("MMMM");


        int joutL = 0;
        int joutM = 0;
        int joutMe = 0;
        int joutJ = 0;
        int joutV = 0;
        int joutS = 0;
        int joutD = 0;

        TextView textLundi = (TextView) findViewById(R.id.lundi);
        TextView textMardi = (TextView) findViewById(R.id.mardi);
        TextView textMercredi = (TextView) findViewById(R.id.mercredi);
        TextView textJeudi = (TextView) findViewById(R.id.jeudi);
        TextView textVendredi = (TextView) findViewById(R.id.vendredi);
        TextView textSamedi = (TextView) findViewById(R.id.samedi);
        TextView textDimanche = (TextView) findViewById(R.id.dimanche);

        int bolo = -(jourSemaine) + 7;

        cal.add(Calendar.DATE, bolo);
        joutL = Integer.valueOf(sdf3.format(cal.getTime()));

        cal.add(Calendar.DATE,1);
        joutM = Integer.valueOf(sdf3.format(cal.getTime()));
        String mois2 = sdf5.format(cal.getTime());
        cal.add(Calendar.DATE,1);
        joutMe = Integer.valueOf(sdf3.format(cal.getTime()));
        cal.add(Calendar.DATE,1);
        joutJ = Integer.valueOf(sdf3.format(cal.getTime()));
        cal.add(Calendar.DATE,1);
        joutV = Integer.valueOf(sdf3.format(cal.getTime()));
        cal.add(Calendar.DATE,1);
        joutS = Integer.valueOf(sdf3.format(cal.getTime()));
        cal.add(Calendar.DATE,1);
        joutD = Integer.valueOf(sdf3.format(cal.getTime()));

        textLundi.setText("L " + (joutL));

        textMardi.setText("M " + (joutM));
        textMercredi.setText("M " + (joutMe));
        textJeudi.setText("J " + joutJ);
        textVendredi.setText("V " + joutV);
        textSamedi.setText("S " + joutS);
        textDimanche.setText("D " + joutD);

        TextView textyto = (TextView) findViewById(R.id.date_semaine);
        textyto.setText(mois2);


    }

    public void matier_Semaine(){

        String[] etatSemaine = new String[]{"26/10", "27/10","28/10","29/10","30/10","31/10","01/11"};
        int[] nombreTache = new int[]{0,0,0,0,0,0,0};


        String[][] repertoire = new String[][]{
                {"26/10","Python","De Villoda", "Chartron G1", "8:45", "10h30"},
                {"26/10","Python","De villoda", "Chartron G1", "10:45", "12h30"},
                {"27/10","Python","De villoda", "Chartron G1", "13:30", "15:15"},
                {"27/10","Python","De Villoda", "Chartron G1", "15:30", "17:15"},
                {"28/10","C#","Larquet", "Chartron G1", "8:45", "9h45"},
                {"30/10","Labo","Govou", "Chartron G1", "8:45", "9h45"},
                {"30/10","Start-up","Dufry", "Chartron G1", "13:30", "9h45"},
                {"30/10","Projet","Govou", "Chartron G1", "18:00", "9h45"}};

        List<String> liste = new ArrayList<String>();

        for (int i = 0; i < repertoire.length;i++)
        {
            if ( i == 0) {

                liste.add(repertoire[i][1]);
            }
            else
            {
                int a =0;
                for (int ji = 0; ji < liste.size();ji++)
                {

                    if (liste.get(ji).equals(repertoire[i][1]))
                    {
                        a++;
                    }

                }
                if ( a == 0)
                {
                    liste.add(repertoire[i][1]);
                }
            }
        }

        String[] couleur = new String[]{"#0066FF","#006633","#CC0000","#FF6600","#FF3399","#009966"};


        int[] tacheL = new int[] {R.id.lundi1, R.id.lundi2, R.id.lundi3};
        int[] tacheM = new int[] {R.id.mardi1, R.id.mardi2, R.id.mardi3};
        int[] tacheMe = new int[] {R.id.mercredi1, R.id.mercredi2, R.id.mercredi3};
        int[] tacheJ = new int[] {R.id.jeudi1, R.id.jeudi2, R.id.jeudi3};
        int[] tacheV = new int[] {R.id.vendredi1, R.id.vendredi2, R.id.vendredi3};
        int[] tacheS = new int[] {R.id.samedi1, R.id.samedi2, R.id.samedi3};
        int[] tacheD = new int[] {R.id.dimanche1, R.id.dimanche2, R.id.dimanche3};
        String myHexColor = "#CC2233";

        for (int i = 0; i < repertoire.length;i++)
        {
            for ( int ja = 0; ja < liste.size();ja++)
            {
                if (liste.get(ja).equals(repertoire[i][1]))
                {
                    myHexColor = couleur[ja];
                    break;

                }
            }
            for (int j = 0; j < etatSemaine.length; j++)
            {

                if (etatSemaine[j] == repertoire[i][0]) {
                    switch (j) {
                        case 0 :
                            int jj = nombreTache[0];
                            TextView try25 = (TextView) findViewById(tacheL[jj]);
                            try25.setBackgroundColor(Color.parseColor(myHexColor));
                            try25.setText(repertoire[i][4] + " " + repertoire[i][1]);
                            nombreTache[0] ++;
                            break;

                        case 1 :
                            int nbrM = nombreTache[1];
                            TextView txmar = (TextView) findViewById(tacheM[nbrM]);
                            txmar.setBackgroundColor(Color.parseColor(myHexColor));
                            txmar.setText(repertoire[i][4]+ " " + repertoire[i][1]);
                            nombreTache[1] ++;
                            break;

                        case 2 :
                            int nbrMe = nombreTache[2];
                            TextView txmer = (TextView) findViewById(tacheMe[nbrMe]);
                            txmer.setBackgroundColor(Color.parseColor(myHexColor));
                            txmer.setText(repertoire[i][4]+ " " + repertoire[i][1]);
                            nombreTache[2] ++;

                            break;
                        case 3 :
                            int nbrJ = nombreTache[3];
                            TextView txjeu = (TextView) findViewById(tacheJ[nbrJ]);
                            txjeu.setBackgroundColor(Color.parseColor(myHexColor));
                            txjeu.setText(repertoire[i][4]+ " " + repertoire[i][1]);
                            nombreTache[3] ++;
                            break;
                        case 4 :
                            int nbrV = nombreTache[4];
                            TextView txven = (TextView) findViewById(tacheV[nbrV]);
                            txven.setBackgroundColor(Color.parseColor(myHexColor));
                            txven.setText(repertoire[i][4]+ " " + repertoire[i][1]);
                            nombreTache[4] ++;
                            break;
                        case 5 :
                            int nbrS = nombreTache[5];
                            TextView txsam = (TextView) findViewById(tacheS[nbrS]);
                            txsam.setBackgroundColor(Color.parseColor(myHexColor));
                            txsam.setText(repertoire[i][4]+ " " + repertoire[i][1]);
                            nombreTache[5] ++;
                            break;
                        case 6 :
                            int nbrD = nombreTache[6];
                            TextView txdim = (TextView) findViewById(tacheD[nbrD]);
                            txdim.setBackgroundColor(Color.parseColor(myHexColor));
                            txdim.setText(repertoire[i][4]+ " " + repertoire[i][1]);
                            nombreTache[6] ++;
                            break;
                    }

                }

            }
        }

    }


}
