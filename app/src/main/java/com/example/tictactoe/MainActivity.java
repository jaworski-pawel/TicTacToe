package com.example.tictactoe;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.gridlayout.widget.GridLayout;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private Player activePlayer = Player.CIRCLE;
    private boolean activeGame = true;

    public void dropIn(View view) {
        ImageView counter = (ImageView) view;
        TextView textView = findViewById(R.id.textView);
        counter.setTranslationY(-1500);
        if (activePlayer == Player.CIRCLE && counter.getTag() == null && activeGame) {
            counter.setImageResource(R.drawable.circle);
            counter.setTag(Player.CIRCLE);
            activePlayer = Player.SHARP;
            textView.setText("Now sharp!");
            checkIfWin(textView);
        } else if (counter.getTag() == null && activeGame) {
            counter.setImageResource(R.drawable.sharp);
            counter.setTag(Player.SHARP);
            activePlayer = Player.CIRCLE;
            textView.setText("Now circle!");
            checkIfWin(textView);
        }
        counter.animate().translationYBy(1500).rotation(3600).setDuration(200);
    }

    public void playAgain(View view) {
        GridLayout gridLayout = findViewById(R.id.gridLayout);
        for (int i = 0; i < gridLayout.getChildCount(); i++) {
            ImageView imageView = (ImageView)gridLayout.getChildAt(i);
            imageView.setTag(null);
            imageView.setImageResource(0);
        }
        TextView textView = findViewById(R.id.textView);
        textView.setText("The circle begins!");
        activeGame = true;
        activePlayer = Player.CIRCLE;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    private void checkIfWin(TextView textView) {
        GridLayout gridLayout = findViewById(R.id.gridLayout);
        List<ImageView> imageViewList = new ArrayList<>();
        for (int i = 0; i < gridLayout.getChildCount(); i++) {
            imageViewList.add((ImageView) gridLayout.getChildAt(i));
        }
        if ((imageViewList.get(0).getTag() == imageViewList.get(1).getTag()) && (imageViewList.get(1).getTag() == imageViewList.get(2).getTag()) && (imageViewList.get(0).getTag() != null)) {
            textView.setText(String.format("%s WIN!", imageViewList.get(0).getTag().toString()));
            activeGame = false;
        }
        if ((imageViewList.get(3).getTag() == imageViewList.get(4).getTag()) && (imageViewList.get(4).getTag() == imageViewList.get(5).getTag()) && (imageViewList.get(3).getTag() != null)) {
            textView.setText(String.format("%s WIN!", imageViewList.get(3).getTag().toString()));
            activeGame = false;
        }
        if ((imageViewList.get(6).getTag() == imageViewList.get(7).getTag()) && (imageViewList.get(7).getTag() == imageViewList.get(8).getTag()) && (imageViewList.get(6).getTag() != null)) {
            textView.setText(String.format("%s WIN!", imageViewList.get(6).getTag().toString()));
            activeGame = false;
        }
        if ((imageViewList.get(0).getTag() == imageViewList.get(3).getTag()) && (imageViewList.get(3).getTag() == imageViewList.get(6).getTag()) && (imageViewList.get(0).getTag() != null)) {
            textView.setText(String.format("%s WIN!", imageViewList.get(0).getTag().toString()));
            activeGame = false;
        }
        if ((imageViewList.get(1).getTag() == imageViewList.get(4).getTag()) && (imageViewList.get(4).getTag() == imageViewList.get(7).getTag()) && (imageViewList.get(1).getTag() != null)) {
            textView.setText(String.format("%s WIN!", imageViewList.get(1).getTag().toString()));
            activeGame = false;
        }
        if ((imageViewList.get(2).getTag() == imageViewList.get(5).getTag()) && (imageViewList.get(5).getTag() == imageViewList.get(8).getTag()) && (imageViewList.get(2).getTag() != null)) {
            textView.setText(String.format("%s WIN!", imageViewList.get(2).getTag().toString()));
            activeGame = false;
        }
        if ((imageViewList.get(0).getTag() == imageViewList.get(4).getTag()) && (imageViewList.get(4).getTag() == imageViewList.get(8).getTag()) && (imageViewList.get(0).getTag() != null)) {
            textView.setText(String.format("%s WIN!", imageViewList.get(0).getTag().toString()));
            activeGame = false;
        }
        if ((imageViewList.get(2).getTag() == imageViewList.get(4).getTag()) && (imageViewList.get(4).getTag() == imageViewList.get(6).getTag()) && (imageViewList.get(2).getTag() != null)) {
            textView.setText(String.format("%s WIN!", imageViewList.get(2).getTag().toString()));
            activeGame = false;
        }
    }
}