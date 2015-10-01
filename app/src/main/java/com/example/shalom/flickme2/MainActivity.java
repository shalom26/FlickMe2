package com.example.shalom.flickme2;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final Intent intent = new Intent(this, ImageView.class);
        ListView listView = new ListView(this);
        listView = (ListView) findViewById(R.id.listView);
        String[] Tags = {"Love", "Hate", "Happiness", "Jelusy", "Curage", "Fear", "Joy"};
        ArrayAdapter<String> adpter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, Tags);
        listView.setAdapter(adpter);
        listView.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {


                String item = ((TextView)view).getText().toString();
                intent.putExtra("selectedTag",item);
                startActivity(intent);

            }
        });


    }
}