package com.example.exercise4;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText edit;
    Button btn;
    TextView txt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edit= (EditText) findViewById(R.id.editTextTextPersonName);
        btn= (Button) findViewById(R.id.button);
        txt= (TextView) findViewById(R.id.textViewhienthi);

        btn.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String t;
                t=edit.getText()+"";
                txt.setText(t);

            }
        }));

    }
}
