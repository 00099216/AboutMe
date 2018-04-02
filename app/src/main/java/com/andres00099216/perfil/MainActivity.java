package com.andres00099216.perfil;


import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v4.graphics.drawable.RoundedBitmapDrawable;
import android.support.v4.graphics.drawable.RoundedBitmapDrawableFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        ImageView ImageView = (ImageView) findViewById(R.id.foto_perfil);

        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.me);

        RoundedBitmapDrawable RoundedBitmapDrawable= RoundedBitmapDrawableFactory.create(getResources(), bitmap);
        RoundedBitmapDrawable.setCircular(true);
        ImageView.setImageDrawable(RoundedBitmapDrawable);
    }
}
