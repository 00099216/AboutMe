package com.andres00099216.perfil;


import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v4.graphics.drawable.RoundedBitmapDrawable;
import android.support.v4.graphics.drawable.RoundedBitmapDrawableFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {
    ImageButton boton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        boton = findViewById(R.id.boton_share);

        //funcionalidad del boton
        boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent sendIntent = new Intent();
                sendIntent.setAction(Intent.ACTION_SEND);
                sendIntent.setType("text/plain");

                sendIntent.putExtra(Intent.EXTRA_TEXT,"Nombre: "+((TextView)findViewById(R.id.text_nombre)).getText().toString() +"\n"
                                                        +"Correo: "+ ((TextView)findViewById(R.id.text_email)).getText().toString() +"\n"+
                                                        "GitHub: "+((TextView)findViewById(R.id.text_git)).getText().toString()+"\n"
                                                        +"Twitter: " +((TextView)findViewById(R.id.text_twitter)).getText().toString()+"\n" +
                                                        "Telefono: "+((TextView)findViewById(R.id.text_telefono)).getText().toString());



                if (sendIntent.resolveActivity(getPackageManager()) != null){
                    startActivity(sendIntent);
                }
            }
        });

        //lo que hace circular la imagen
        ImageView ImageView = findViewById(R.id.foto_perfil);

        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.me);

        RoundedBitmapDrawable RoundedBitmapDrawable= RoundedBitmapDrawableFactory.create(getResources(), bitmap);
        RoundedBitmapDrawable.setCircular(true);
        ImageView.setImageDrawable(RoundedBitmapDrawable);
    }
}
