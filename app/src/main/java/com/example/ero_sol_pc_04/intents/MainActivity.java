package com.example.ero_sol_pc_04.intents;

        import android.app.Activity;
        import android.content.Intent;
        import android.graphics.Bitmap;
        import android.media.Image;
        import android.provider.MediaStore;
        import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;
        import android.view.View;
        import android.widget.Button;
        import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    private static final int IMAGE_REQUEST = 1888;

    ImageView camera,image;

    Button gallery;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        camera = (ImageView) findViewById(R.id.camera);
        image = (ImageView) findViewById(R.id.image);
        gallery = (Button) findViewById(R.id.gallry);
        gallery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,Gallery.class);
                startActivity(intent);
            }
        });
        camera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                if(intent.resolveActivity(getPackageManager()) != null)
                {

                    startActivityForResult(intent,IMAGE_REQUEST);
                }
            }
        });


    }

    protected void onActivityResult(int requestCode,int resultCode,Intent data)
    {
        if(requestCode == IMAGE_REQUEST && resultCode == Activity.RESULT_OK)
        {
            Bitmap Photo = (Bitmap) data.getExtras().get("data");

            image.setImageBitmap(Photo);

        }
    }
}
