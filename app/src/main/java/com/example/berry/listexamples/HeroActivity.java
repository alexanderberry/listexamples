package com.example.berry.listexamples;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class HeroActivity extends AppCompatActivity {

    private String name;
    private String description;
    private TextView nameText;
    private TextView descriptionText;
    private ImageView image;
    private Button back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hero);
        name = getIntent().getStringExtra("heroName");
        description = getIntent().getStringExtra("heroDescription");
        nameText = (TextView) findViewById(R.id.hero_text);
        descriptionText = (TextView) findViewById(R.id.description_text);
        back = (Button) findViewById(R.id.button_back);
        image = (ImageView) findViewById(R.id.imageView);
        nameText.setText(name);
        descriptionText.setText(description);
        image.setImageDrawable(getDrawable(getIntent().getIntExtra("image",R.drawable.bart)));
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(HeroActivity.this,MainActivity.class);
                startActivity(i);
            }
        });
    }
}
