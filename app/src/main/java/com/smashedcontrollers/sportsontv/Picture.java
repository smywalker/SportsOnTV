package com.smashedcontrollers.sportsontv;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

public class Picture  extends AppCompatActivity {

    private static final int CAMERA_REQUEST = 1888;
    ImageView newImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_picture);
        newImageView = (ImageView) this.findViewById(R.id.image_from_camera);

    }
    //Intent to take start camera
    public void takeImageFromCamera(View view) {
        Intent cameraIntent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(cameraIntent, CAMERA_REQUEST);
    }
    //Save image and show it in an imageview
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == CAMERA_REQUEST && resultCode == RESULT_OK) {
            Bitmap capturedImage = (Bitmap) data.getExtras().get("data");
            newImageView.setImageBitmap(capturedImage);
        }
    }
}
