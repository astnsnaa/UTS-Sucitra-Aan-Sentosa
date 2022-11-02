package com.aan.uts_20753033_sucitraaansentosa;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class MotorActivity extends AppCompatActivity {

    TextView tvName, tvDescription;
    ImageView imgPhoto;
    Motor motorModel;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_motor);

        tvName = findViewById(R.id.tv_name_detail);
        tvDescription = findViewById(R.id.tv_description_detail);
        imgPhoto = findViewById(R.id.iv_photo);
        intent = getIntent();

        if(intent != null) {
            motorModel = (Motor) intent.getParcelableExtra("data");
            String name = motorModel.getName();
            String description = motorModel.getDescription();

            tvName.setText(name);
            tvDescription.setText(description);
            imgPhoto.setImageResource(motorModel.getPhoto());
        }
    }
}