package com.example.gadsleaderboard.UI.main;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toolbar;

import com.example.gadsleaderboard.R;
import com.google.android.material.tabs.TabLayout;

public class LeaderBoardActivity extends AppCompatActivity {
private Toolbar toolbar;
private TabLayout tabLayout;
private ViewPager viewPager;
private Button submit_button;
private ViewPagerAdapter viewPagerAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_l_e_a_d_e_r_b_o_a_r_d);
        toolbar = (Toolbar) findViewById(R.id.toolbar);

        setActionBar(toolbar);
        submit_button=findViewById(R.id.submit_btn);
        submit_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(LeaderBoardActivity.this,SubmitActivity.class);
                startActivity(intent);
            }
        });

        tabLayout=findViewById(R.id.tablayout);
        viewPager=findViewById(R.id.viewpager);
        viewPagerAdapter=new ViewPagerAdapter(getSupportFragmentManager(), FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        viewPagerAdapter.AddFragment(new leaderboardFragment(),"Learning Leaders");
        viewPagerAdapter.AddFragment(new skillIQFragment(),"Skill IQ Leaders");
        viewPager.setAdapter(viewPagerAdapter);
        tabLayout.setTabTextColors(Color.parseColor("#FF808080"),Color.WHITE);
        tabLayout.setupWithViewPager(viewPager);


    }
}