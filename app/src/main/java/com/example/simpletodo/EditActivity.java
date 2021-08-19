package com.example.simpletodo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class EditActivity extends AppCompatActivity {
    TextView etText;
    Button btnSave;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);
        etText = findViewById(R.id.etText);
        btnSave = findViewById(R.id.btnSave);

        getSupportActionBar().setTitle("Edit item");
        etText.setText(getIntent().getStringExtra(MainActivity.KEY_ITEM_TEXT));
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //create intent that contains results
                Intent intent = new Intent();
                //pass the data
                intent.putExtra(MainActivity.KEY_ITEM_TEXT, etText.getText().toString());
                intent.putExtra(MainActivity.KEY_ITEM_POSITION, getIntent().getExtras().getInt(MainActivity.KEY_ITEM_POSITION));
                //set the result
                setResult(RESULT_OK, intent);
                //finish activity
                finish();
            }
        });
    }
}