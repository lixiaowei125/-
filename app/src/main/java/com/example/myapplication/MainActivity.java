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

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button tianjia;
    ListView listView;

    database data_base=new database();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        listView = (ListView) findViewById(R.id.list_view);

        data_base.create(this);

        beiwangluAdapter adapter = new beiwangluAdapter(MainActivity.this, R.layout.table_item, data_base.getList());
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                beiwangluContent beiwanglucontent = data_base.getList().get(position);
                Intent intent = new Intent(MainActivity.this, CreateActivity.class);
                intent.putExtra("date",beiwanglucontent.getDate());
                startActivity(intent);
            }
        });

        tianjia=(Button)findViewById(R.id.tianjia);

        tianjia.setOnClickListener(this);
    }

    @Override
    public void onClick(View v){
        Date timer=new Date();
        String  date=timer.toLocaleString();
        switch(v.getId()){
            case R.id.tianjia:
                Intent intent = new Intent(MainActivity.this, CreateActivity.class);
                intent.putExtra("date",date);
                startActivity(intent);
                finish();
                break;
                default:
                    break;
        }
    }
}
