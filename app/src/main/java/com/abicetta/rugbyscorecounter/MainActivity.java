package com.abicetta.rugbyscorecounter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

/**
 * This activity keeps track of the rugby score for 2 teams.
 */
public class MainActivity extends AppCompatActivity {
    int scoreOfTeamA = 0;
    int scoreOfTeamB = 0;
    int unDoA = 0;
    int unDoB = 0;
    boolean aOrB_team = true;

    // for recovery
    static final String SCORE_TEAM_A = "scoreOfTeamA";
    static final String SCORE_TEAM_B = "scoreOfTeamB";
    static final String UNDO_A = "unDoA";
    static final String UNDO_B = "unDoB";
    static final String A_B = "aOrB_team";

    /**
     * This method receives the parameter savedInstanceState, which is a Bundle object
     * containing the activity's previously saved state.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // recovering the instance state
        if (savedInstanceState != null) {
            this.scoreOfTeamA = savedInstanceState.getInt(SCORE_TEAM_A);
            this.scoreOfTeamB = savedInstanceState.getInt(SCORE_TEAM_B);
            this.unDoA = savedInstanceState.getInt(UNDO_A);
            this.unDoB = savedInstanceState.getInt(UNDO_B);
            this.aOrB_team = savedInstanceState.getBoolean(A_B);
        } else {
            scoreOfTeamA = 0;
            scoreOfTeamB = 0;
        }
        setContentView(R.layout.activity_main);
        displayForTeamA(scoreOfTeamA);
        displayForTeamB(scoreOfTeamB);
    }

    /**
     * invoked when the activity may be temporarily destroyed, save the instance state here
     * and call superclass to save data
     */
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt(SCORE_TEAM_A, scoreOfTeamA);
        outState.putInt(SCORE_TEAM_B, scoreOfTeamB);
        outState.putInt(UNDO_A, unDoA);
        outState.putInt(UNDO_B, unDoB);
        outState.putBoolean(A_B, aOrB_team);
    }

    /**
     * Increase the score for Team A (HOME) by 5 points.
     */
    public void add5toTeamA(View v) {
        aOrB_team = true;
        unDoA = scoreOfTeamA;
        scoreOfTeamA = scoreOfTeamA + 5;
        displayForTeamA(scoreOfTeamA);
    }

    /**
     * Increase the score for Team B (VISITORS) by 5 points.
     */
    public void add5toTeamB(View v) {
        aOrB_team = false;
        unDoB = scoreOfTeamB;
        scoreOfTeamB = scoreOfTeamB + 5;
        displayForTeamB(scoreOfTeamB);
    }

    /**
     * Increase the score for Team A (HOME) by 1 point.
     */
    public void add3toTeamA(View v) {
        aOrB_team = true;
        unDoA = scoreOfTeamA;
        scoreOfTeamA = scoreOfTeamA + 3;
        displayForTeamA(scoreOfTeamA);
    }

    /**
     * Increase the score for Team B (VISITORS) by 1 point.
     */
    public void add3toTeamB(View v) {
        aOrB_team = false;
        unDoB = scoreOfTeamB;
        scoreOfTeamB = scoreOfTeamB + 3;
        displayForTeamB(scoreOfTeamB);
    }

    /**
     * Increase the score for Team A (HOME) by 2 points.
     */
    public void add2toTeamA(View v) {
        aOrB_team = true;
        unDoA = scoreOfTeamA;
        scoreOfTeamA = scoreOfTeamA + 2;
        displayForTeamA(scoreOfTeamA);
    }

    /**
     * Increase the score for Team B (VISITORS) by 2 points.
     */
    public void add2toTeamB(View v) {
        aOrB_team = false;
        unDoB = scoreOfTeamB;
        scoreOfTeamB = scoreOfTeamB + 2;
        displayForTeamB(scoreOfTeamB);
    }

    /**
     * Undo button, that cancel the last operation.
     */
    public void unDo(View v) {

        if (aOrB_team) {
            scoreOfTeamA = unDoA;
        }
        if (!aOrB_team) {
            scoreOfTeamB = unDoB;
        }
        displayForTeamA(scoreOfTeamA);
        displayForTeamB(scoreOfTeamB);
    }

    /**
     * Resets the score for both teams back to 0.
     */
    public void resetAll(View v) {
        unDoA = 0;
        unDoB = 0;
        scoreOfTeamA = 0;
        scoreOfTeamB = 0;
        displayForTeamB(scoreOfTeamB);
        displayForTeamA(scoreOfTeamA);
        aOrB_team = true;
    }

    /**
     * Displays the given score for Team A.
     */
    public void displayForTeamA(int score) {
        TextView scoreView = (TextView) findViewById(R.id.team_a_score);
        scoreView.setText(String.valueOf(score));


    }

    /**
     * Displays the given score for Team B.
     */
    public void displayForTeamB(int score) {
        TextView scoreView = (TextView) findViewById(R.id.team_b_score);
        scoreView.setText(String.valueOf(score));
    }
}
