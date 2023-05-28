package com.example.exercise2;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public class DemoTestActivity extends Activity implements View.OnClickListener{
        Button btnread, bntwrite;
        EditText editdata;
        protected void onCreate(Bundle savedInstanceState){
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);

            btnread=(Button) findViewById(R.id.btnRead);
            bntwrite=(Button) findViewById(R.id.btnWrite);
            editdata=(EditText) findViewById(R.id.editTextData);

            btnread.setOnClickListener(this);
            bntwrite.setOnClickListener(this);
        }
        public void onClick(View v){
            if(v.getId()==R.id.btnRead)
            {
                readData();
            }
            else if(v.getId()==R.id.btnWrite)
            {
                writeData();
            }
        }
        public void readData()
        {
            try {
                FileInputStream in=openFileInput("myfile.txt");
                BufferedReader reader =new BufferedReader(new InputStreamReader(in));
                String data="";
                StringBuilder builder=new StringBuilder();
                while ((data=reader.readLine())!=null)
                {
                    builder.append(data);
                    builder.append("\n");
                }
                in.close();
                editdata.setText(builder.toString());
            }catch (FileNotFoundException e) {
                e.printStackTrace();
            }catch (IOException e){
                e.printStackTrace();
            }
        }
        public void writeData()
        {
            try {
                FileOutputStream out=openFileOutput("myfile.txt",0);
                OutputStreamWriter writer=new OutputStreamWriter(out);
                writer.write(editdata.getText().toString());
                writer.close();
            }catch (FileNotFoundException e){
                e.printStackTrace();
            }catch (IOException e){
                e.printStackTrace();
            }
        }
    }
}