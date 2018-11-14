package com.example.bital_117.recyclerviewsearchenable;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    EditText editTextSearch;
    ArrayList<String> names;

    CustomAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        names = new ArrayList<>();

        names.add("Jakarta");
        names.add("Bandung");
        names.add("Surabaya");
        names.add("Yogyakarta");
        names.add("Semarang");
        names.add("Medan");
        names.add("Padang");
        names.add("Aceh");
        names.add("Makasar");
        names.add("Bali");
        names.add("Lombok");
        names.add("Jayapura");


        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        editTextSearch = (EditText) findViewById(R.id.editTextSearch);

        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        adapter = new CustomAdapter(names);

        recyclerView.setAdapter(adapter);


        editTextSearch.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                
                filter(editable.toString());
            }
        });

    }

    private void filter(String text) {

        ArrayList<String> filterNames = new ArrayList<>();

        for (String s : names){
            if (s.toLowerCase().contains(text.toLowerCase())){
                filterNames.add(s);
            }
        }
        adapter.filterList(filterNames);
    }

}