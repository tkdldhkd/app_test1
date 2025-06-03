package com.example.app_test;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

public class Achievement extends AppCompatActivity {
    private RecyclerView achievementsRecyclerView;
    private AchievementsAdapter adapter;
    private List<Achievements_list> allAchievementsList;
    private List<Achievements_list> filteredAchievementsList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_achievement);

        achievementsRecyclerView = findViewById(R.id.achievementsRecyclerView);
        achievementsRecyclerView.setLayoutManager(new LinearLayoutManager(this));


        Intent intent = getIntent();
        String whereName = intent.getStringExtra("WhereName"); //지역 이름 받기

        //업적 생성 하는 곳
        allAchievementsList = new ArrayList<>();
        allAchievementsList.add(new Achievements_list(System.currentTimeMillis(), "첫 업적", "업적을 획득했습니다!", "서울"));
        allAchievementsList.add(new Achievements_list(0, "숨겨진 업적", "아직 잠금 해제되지 않음", "부산"));
        allAchievementsList.add(new Achievements_list(System.currentTimeMillis(), "레벨 업!", "레벨이 올랐습니다!", "서울"));
        allAchievementsList.add(new Achievements_list(System.currentTimeMillis(), "관광 완료!", "제주도 여행을 마쳤습니다!", "제주"));
        allAchievementsList.add(new Achievements_list(System.currentTimeMillis(), "대구 입성!", "대구에 왔습니다!", "대구"));
        allAchievementsList.add(new Achievements_list(System.currentTimeMillis(), "대구 입성2!", "대구에 왔습니다!", "대구"));

        filteredAchievementsList = new ArrayList<>();
        for (Achievements_list achievement : allAchievementsList) {
            if (whereName != null && whereName.equals(achievement.getID())) {
                filteredAchievementsList.add(achievement);
            }
        }


        adapter = new AchievementsAdapter(filteredAchievementsList);
        achievementsRecyclerView.setAdapter(adapter);
    }
}