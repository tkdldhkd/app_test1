package com.example.app_test;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        TextView textView = findViewById(R.id.textView);

        Intent intent = getIntent(); //Trip로 부터 연결된 통로로 값 꺼내기
        String WhereName = intent.getStringExtra("WhereName");

        if (WhereName != null) {
            textView.setText(WhereName);
        }
    }


    public void onclick(View view) {

        if(view.getId() == R.id.btn_trip){
            Intent intent = new Intent(MainActivity.this, TripActivity.class);
            startActivity(intent);
        }

        if(view.getId() == R.id.btn_achievement){
            TextView textView = findViewById(R.id.textView);
            String whereName = textView.getText().toString();

            //업적칸 으로 데이터 전달
            Intent intent_achievement = new Intent(MainActivity.this, Achievement.class);
            intent_achievement.putExtra("WhereName", whereName);
            startActivity(intent_achievement);

        }
    }
}