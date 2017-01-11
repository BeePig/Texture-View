package com.example.beepi.textureview;

import android.hardware.Camera;
import android.view.Gravity;
import android.view.TextureView;
import android.widget.FrameLayout;

import java.io.IOException;

/**
 * Created by beepi on 11/01/2017.
 */

public class SurfaceTexture implements TextureView.SurfaceTextureListener {
    private Camera mCamera;
    private TextureView mTexture;
    public SurfaceTexture (Camera camera,TextureView textureView){
        this.mCamera = camera;
        this.mTexture = textureView;
    }
    @Override
    public void onSurfaceTextureAvailable(android.graphics.SurfaceTexture surface, int width, int height) {

        mCamera = Camera.open();
        Camera.Size previewSize = mCamera.getParameters().getPreviewSize();
        mTexture.setLayoutParams(new FrameLayout.LayoutParams(previewSize.width, previewSize.height, Gravity.CENTER));
        try {
            mCamera.setPreviewTexture(surface);
        } catch (IOException t) {
        }
        mCamera.startPreview();
        mTexture.setAlpha(1.0f);
        mTexture.setRotation(45.0f);
    }

    @Override
    public void onSurfaceTextureSizeChanged(android.graphics.SurfaceTexture surface, int width, int height) {

    }

    @Override
    public boolean onSurfaceTextureDestroyed(android.graphics.SurfaceTexture surface) {
        mCamera.stopPreview();
        mCamera.release();
        return true;
    }

    @Override
    public void onSurfaceTextureUpdated(android.graphics.SurfaceTexture surface) {

    }
}
