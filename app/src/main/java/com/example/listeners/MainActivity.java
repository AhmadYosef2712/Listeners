package com.example.listeners;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.Switch;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.ColorInt;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity implements  View.OnClickListener,SeekBar.OnSeekBarChangeListener{
    private Switch sw;
    private ImageView emoji;
    private int seekBarProgress;
    private SeekBar seekBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        initViews();
    }

    private void initViews() {
        sw=findViewById(R.id.switch1);
        sw.setOnClickListener(this);
        emoji=findViewById(R.id.emoji);
        emoji.setOnClickListener(this);
        seekBar=findViewById(R.id.seekBar);
        seekBar.setOnSeekBarChangeListener(this);
    }

    @Override
    public void onClick(View v) {
      if(v.getId()==R.id.switch1)
      {
          if(sw.isChecked())

          { Toast.makeText(this,"Switch is On",Toast.LENGTH_SHORT).show();
              emoji.setImageResource(R.drawable.happy);
          }

          else {
              Toast.makeText(this, "Switch is Off", Toast.LENGTH_SHORT).show();
              emoji.setImageResource(R.drawable.sad);
          }

      }
    }


    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
        seekBarProgress = progress;
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {
          emoji.setX(seekBarProgress*2);
    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {
        Toast.makeText(this, "seek bar new value: " + seekBarProgress, Toast.LENGTH_SHORT).show();
    }
}
