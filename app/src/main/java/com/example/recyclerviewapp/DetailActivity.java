package com.example.recyclerviewapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {
    private TextView name,description;
    private Bundle extras;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        extras = getIntent().getExtras();

        name = (TextView) findViewById(R.id.namedetaiId);
        description = (TextView) findViewById(R.id.descriptiondetailId);

        if(extras!=null)
        {
            name.setText(extras.getString("name"));
            description.setText(extras.getString("description"));
        }

    }
}
