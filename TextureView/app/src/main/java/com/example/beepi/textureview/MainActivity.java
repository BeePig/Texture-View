package com.example.beepi.textureview;

import android.Manifest;
import android.content.pm.PackageManager;
import android.hardware.Camera;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.TextureView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements
        ActivityCompat.OnRequestPermissionsResultCallback{
    private TextureView myTexture;
    private Camera mCamera;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        requestPermissions(new String[]{Manifest.permission.CAMERA},1);
        myTexture = new TextureView(this);
        myTexture.setSurfaceTextureListener(new com.example.beepi.textureview.SurfaceTexture(mCamera,myTexture));
        setContentView(myTexture);

    }
    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults){
        switch (requestCode){
            case 1:
                if(grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED){
                    Toast.makeText(this,"start",Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(this,"not allowed",Toast.LENGTH_SHORT).show();
                }
                break;
        }
    }
}
