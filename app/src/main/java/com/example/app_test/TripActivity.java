package com.example.app_test;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class TripActivity extends AppCompatActivity {




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.where);
        ViewGroup rootLayout = findViewById(R.id.trip);
        applyClickToAllButtons(rootLayout);
    }
    private void applyClickToAllButtons(ViewGroup root) {
        for (int i = 0; i < root.getChildCount(); i++) {
            View child = root.getChildAt(i);
            if (child instanceof Button) { //모든 오브젝트 찾고 그게 버튼이면 뒤로가기 넣기 <- 굉장히 유용함 기억 필요
                child.setOnClickListener(v -> {

                    String WhereName = ((Button) v).getText().toString(); // 버튼 텍스트 추출

                    Intent intent = new Intent(TripActivity.this, MainActivity.class);//메인 까지의 통로 연결

                    intent.putExtra("WhereName", WhereName); //통로로 정보 보내기

                    startActivity(intent);


                    finish();
                }); //일부 버튼이 레이아웃 밖으로 나가고 함수가 제대로 작동이 안됨
            } else if (child instanceof ViewGroup) { //공식 같은 브레이크 이거 없으면 발동이 안됨. 공부 필요
                applyClickToAllButtons((ViewGroup) child);
            }
        }
    }


    public void onclick(View view) {

    }
}