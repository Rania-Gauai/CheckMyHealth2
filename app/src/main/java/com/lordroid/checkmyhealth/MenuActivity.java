package com.lordroid.checkmyhealth;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

public class MenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        ImageButton imageButton_img =  (ImageButton) findViewById(R.id.image_button_img);
        imageButton_img.setOnClickListener (new ImageButton.OnClickListener() {
            public void onClick (View v){
                Intent intent = new Intent (MenuActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }

}
