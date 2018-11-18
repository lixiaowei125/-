package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;
import android.widget.EditText;

import java.util.Date;


public class CreateActivity extends AppCompatActivity implements View.OnClickListener {
    Button fanhui;
    Button delete;

    EditText textView;

    database data_base=new database();

    String date;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        data_base.init(this);

        textView=(EditText)findViewById(R.id.textView);

        fanhui=(Button)findViewById(R.id.fanhui);
        delete=(Button)findViewById(R.id.delete);

        fanhui.setOnClickListener(this);
        delete.setOnClickListener(this);

        Intent intent=getIntent();
        date=intent.getStringExtra("date");

        if(data_base.query(date).size()>0) textView.setText(data_base.query(date).get(0).getContent());
        else textView.setText("");
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(CreateActivity.this,MainActivity.class);
        switch (v.getId()){
            case R.id.fanhui:
                data_base.save(textView.getText().toString(),date);
                startActivity(intent);
                finish();
                break;
            case R.id.delete:
                data_base.delete(date);
                startActivity(intent);
                finish();
                break;
                default:
                    break;
        }
    }
}
