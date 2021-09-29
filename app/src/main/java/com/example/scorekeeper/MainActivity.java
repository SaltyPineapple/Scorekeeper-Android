package com.example.scorekeeper;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private int team1Score;
    private int team2Score;
    private TextView team1ScoreText;
    private TextView team2ScoreText;

    static final String STATE_SCORE_1 = "Team 1 Score";
    static final String STATE_SCORE_2 = "Team 2 Score";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        team1ScoreText = findViewById(R.id.tv_score1);
        team2ScoreText = findViewById(R.id.tv_score2);

        if(savedInstanceState != null){
            team1ScoreText.setText(String.valueOf(team1Score));
            team2ScoreText.setText(String.valueOf(team2Score));
        }


    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        if(item.getItemId() == R.id.night_mode){
            int nightMode = AppCompatDelegate.getDefaultNightMode();
            if(nightMode == AppCompatDelegate.MODE_NIGHT_YES){
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
            }
            else {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
            }
            recreate();
        }
        return true;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        int nightMode = AppCompatDelegate.getDefaultNightMode();
        if(nightMode == AppCompatDelegate.MODE_NIGHT_YES){
            menu.findItem(R.id.night_mode).setTitle(R.string.day);
        }
        else{
            menu.findItem(R.id.night_mode).setTitle(R.string.night);
        }
        return true;
    }

    public void increaseScore(View view) {
        int viewID = view.getId();
        switch(viewID){
            case R.id.bt_increaseTeam1:
                team1Score++;
                team1ScoreText.setText(String.valueOf(team1Score));
                break;
            case R.id.bt_increaseTeam2:
                team2Score++;
                team2ScoreText.setText(String.valueOf(team2Score));
                break;
            default:
                break;
        }
    }

    public void decreaseScore(View view) {
        int viewID = view.getId();
        switch(viewID){
            case R.id.bt_decreaseTeam1:
                team1Score--;
                team1ScoreText.setText(String.valueOf(team1Score));
                break;
            case R.id.bt_decreaseTeam2:
                team2Score--;
                team2ScoreText.setText(String.valueOf(team2Score));
                break;
            default:
                break;
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState){
        outState.putInt(STATE_SCORE_1, team1Score);
        outState.putInt(STATE_SCORE_2, team2Score);
        super.onSaveInstanceState(outState);
    }
}