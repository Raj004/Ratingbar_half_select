package com.example.rating_bar;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.AppCompatRatingBar;
import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {

  private AppCompatRatingBar ratingBar;
  private TextView txtRatingValue;
  private Button btnSubmit;

  @Override
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    addListenerOnRatingBar();
    addListenerOnButton();

  }

  public void addListenerOnRatingBar() {

    ratingBar = (AppCompatRatingBar) findViewById(R.id.ratingBar1);
    txtRatingValue = (TextView) findViewById(R.id.txtRatingValue);

    //if rating value is changed,
    //display the current rating value in the result (textview) automatically
    ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
      public void onRatingChanged(RatingBar ratingBar, float rating,
                                  boolean fromUser) {

        txtRatingValue.setText(String.valueOf(rating));

      }
    });
  }

  public void addListenerOnButton() {

    ratingBar = (AppCompatRatingBar) findViewById(R.id.ratingBar1);
    btnSubmit = (Button) findViewById(R.id.btnSubmit);

    //if click on me, then display the current rating value.
    btnSubmit.setOnClickListener(new View.OnClickListener() {

      @Override
      public void onClick(View v) {

        Toast.makeText(MainActivity.this,
          String.valueOf(ratingBar.getRating()),
          Toast.LENGTH_SHORT).show();

      }

    });

  }
}
