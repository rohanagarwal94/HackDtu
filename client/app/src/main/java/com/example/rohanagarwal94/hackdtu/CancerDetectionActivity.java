package com.example.rohanagarwal94.hackdtu;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.example.rohanagarwal94.hackdtu.model.Action;

/**
 * Created by rohanagarwal94 on 11/2/17.
 */
public class CancerDetectionActivity extends AppCompatActivity {

    Button takePic,uploadPic;
    ImageView imageView;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cancer_detection_activity);
        takePic = (Button)findViewById(R.id.btn_take_pic);
        uploadPic = (Button)findViewById(R.id.btn_upload);
        imageView = (ImageView)findViewById(R.id.img_upload);
        takePic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent camIntent = new Intent();
            }
        });
    }
}
