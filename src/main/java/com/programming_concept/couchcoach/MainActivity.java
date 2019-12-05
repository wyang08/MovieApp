package com.programming_concept.couchcoach;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(TAG, "onCreate: Started.");
        ListView listView = (ListView) findViewById(R.id.ListView);

        Person A = new Person("Survival Box", "08-16-2019", "William Scoular", "drawable://" + R.drawable.survivalbox);
        Person B = new Person("Venom", "10-05-2018", "Ruben Fleischer", "drawable://" + R.drawable.venom);
        Person C = new Person("Aquaman", "12-21-2018", "James Wan", "drawable://" + R.drawable.aquaman);
        Person D = new Person("John Wick II", "02-10-2017", "Chad Stahelski", "drawable://" + R.drawable.johnwickii);
        Person E = new Person("12 Strong", "01-19-2018", "Nicolai Fuglsig", "drawable://" + R.drawable.onetwostrong);
        Person F = new Person("Deadpool II", "05-18-2018", "David Leitch", "drawable://" + R.drawable.dpii);
        Person G = new Person("Joker","10-04-2019","Todd Phillips","drawable://" + R.drawable.joker);
        Person H = new Person("The Avengers", "05-04-2012", "Joss Whedon", "drawable://" + R.drawable.avengers);
        Person I = new Person("Avengers: Age of Ultron","05-01-2015","Joss Whedon","drawable://" + R.drawable.avengersii);
        Person J = new Person("Avengers: Infinity War", "04-27-2018","Anthony Russo","drawable://" + R.drawable.avengersiii);
        Person K = new Person("Kingsman: The Secret Service","02-12-2015","Matthew Vaughn","drawable://" + R.drawable.kingsmani);
        Person L = new Person("Kingsman: The Golden Circle","09-22-2017","Matthew Vaughn","drawable://" + R.drawable.kingsmanii);
        Person M = new Person("King's man: ","Upcoming: 02-14-2020","Matthew Vaughn","drawable://" + R.drawable.kingsmaniii);
        Person N = new Person("Hacksaw Ridge","11-04-2016","Mel Gibson","drawable://" + R.drawable.hacksawridge);

        ArrayList<Person> peoplelist = new ArrayList<>();
        peoplelist.add(A);
        peoplelist.add(B);
        peoplelist.add(C);
        peoplelist.add(D);
        peoplelist.add(E);
        peoplelist.add(F);
        peoplelist.add(G);
        peoplelist.add(H);
        peoplelist.add(I);
        peoplelist.add(J);
        peoplelist.add(K);
        peoplelist.add(L);
        peoplelist.add(M);
        peoplelist.add(N);




        PersonListAdapter adapter = new PersonListAdapter(this, R.layout.adapter_view_layout, peoplelist);
        listView.setAdapter(adapter);
    }
}
