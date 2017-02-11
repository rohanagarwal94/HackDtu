package com.example.rohanagarwal94.hackdtu;

import android.Manifest;
import android.annotation.TargetApi;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Toast;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import butterknife.ButterKnife;
import butterknife.OnClick;

@TargetApi(Build.VERSION_CODES.JELLY_BEAN)
public class CancerDetectionActivity extends AppCompatActivity {
    private static final int CAMERA_CAPTURE_REQUEST_CODE = 100;
    private static final int GALLERY_REQUEST_CODE = 1234;
    private static final int REQUEST_EXTERNAL_STORAGE = 1;
    private int points = 0;
    private Uri fileUri;
    private ProgressDialog progress;
    Bitmap image = null;
    private int _xDelta;
    private int _yDelta;
    private ViewGroup mRrootLayout;
    private Uri finalUri;

    private static String[] APP_PERMISSIONS = {
            Manifest.permission.READ_EXTERNAL_STORAGE,
            Manifest.permission.WRITE_EXTERNAL_STORAGE
    };

    ImageView imgContainer;

//    @Bind(R.id.imageContLayout)
    RelativeLayout imageContLayout;

    @OnClick(R.id.gotoGallery)
    void openGalleryImages() {
        GetImagesGallery();
    }

    @OnClick(R.id.gotoCamera)
    void openCameraImages() {
        CaptureImageCamera();
    }

    private void shareDrawImage() throws IOException {
        imageContLayout.setDrawingCacheEnabled(true);
        Bitmap bitmap = imageContLayout.getDrawingCache();
        File file, f = null;
        int filename = 1;
        if (android.os.Environment.getExternalStorageState().equals(android.os.Environment.MEDIA_MOUNTED)) {
            filename = filename + 1;
            file = new File(android.os.Environment.getExternalStorageDirectory(), "Brand Ambassador");
            if (!file.exists()) {
                file.mkdirs();
            }
            f = new File(file.getAbsolutePath() + file.separator + "mukul" + filename + ".png");
        }
        FileOutputStream ostream = new FileOutputStream(f);
        bitmap.compress(Bitmap.CompressFormat.PNG, 10, ostream);
        ostream.close();
        finalUri = Uri.fromFile(f);
    }

    private void CaptureImageCamera() {
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(intent, CAMERA_CAPTURE_REQUEST_CODE);
    }

    private void GetImagesGallery() {
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(Intent.createChooser(intent, "Select File"), GALLERY_REQUEST_CODE);
    }

    private void getCameraImageUri() {
        new Thread() {
            @Override
            public void run() {
                try {
                    File file = new File(Environment.getExternalStorageDirectory(), "hashtag.jpg");
                    OutputStream os = new BufferedOutputStream(new FileOutputStream(file));
                    image.compress(Bitmap.CompressFormat.JPEG, 100, os);
                    os.close();
                    fileUri = Uri.fromFile(file);
                } catch (Exception e) {
                    Log.i("File Error", e.toString());
                }
            }
        }.start();
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == CAMERA_CAPTURE_REQUEST_CODE) {
            if (resultCode == RESULT_OK) {
                image = (Bitmap) data.getExtras().get("data");
                imgContainer.setImageBitmap(image);
                getCameraImageUri();
            } else if (resultCode == RESULT_CANCELED) {
                // user cancelled Image capture
                Toast.makeText(getApplicationContext(),
                        "User cancelled image capture", Toast.LENGTH_SHORT)
                        .show();
            } else {
                // failed to capture image
                Toast.makeText(getApplicationContext(),
                        "Sorry! Failed to capture image", Toast.LENGTH_SHORT)
                        .show();
            }

        }
        if (requestCode == GALLERY_REQUEST_CODE) {
            if (resultCode == RESULT_OK) {
                fileUri = data.getData();
                try {
                    image = MediaStore.Images.Media.getBitmap(getContentResolver(), fileUri);
                    image = Bitmap.createScaledBitmap(image, 500, 500, false);
                    imgContainer.setImageBitmap(image);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } else if (resultCode == RESULT_CANCELED) {
                // user cancelled Image capture
                Toast.makeText(getApplicationContext(),
                        "User cancelled image selection", Toast.LENGTH_SHORT)
                        .show();
            } else {
                // failed to capture image
                Toast.makeText(getApplicationContext(),
                        "Sorry! Failed to open Gallery", Toast.LENGTH_SHORT)
                        .show();
            }
        }
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cancer_detection_activity);
        ButterKnife.bind(this);
        verifyStoragePermissions(this);
        mRrootLayout = (ViewGroup) findViewById(R.id.imageContLayout);
        imgContainer=(ImageView)findViewById(R.id.imgContainer);

    }


    public static void verifyStoragePermissions(Activity activity) {
        int permission = ActivityCompat.checkSelfPermission(activity, Manifest.permission.WRITE_EXTERNAL_STORAGE);

        if (permission != PackageManager.PERMISSION_GRANTED) {
            // We don't have permission so prompt the user
            ActivityCompat.requestPermissions(
                    activity,
                    APP_PERMISSIONS,
                    REQUEST_EXTERNAL_STORAGE
            );
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    private void uploadFile() {
        //if there is a file to upload
        if (fileUri != null) {
            //displaying a progress dialog while upload is going on
            final ProgressDialog progressDialog = new ProgressDialog(this);
            progressDialog.setTitle("Uploading");
            progressDialog.show();

            StorageReference riversRef = storageReference.child("images/pic.jpg");
            riversRef.putFile(filePath)
                    .addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                        @Override
                        public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                            //if the upload is successfull
                            //hiding the progress dialog
                            progressDialog.dismiss();

                            //and displaying a success toast
                            Toast.makeText(getApplicationContext(), "File Uploaded ", Toast.LENGTH_LONG).show();
                        }
                    })
                    .addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception exception) {
                            //if the upload is not successfull
                            //hiding the progress dialog
                            progressDialog.dismiss();

                            //and displaying error message
                            Toast.makeText(getApplicationContext(), exception.getMessage(), Toast.LENGTH_LONG).show();
                        }
                    })
                    .addOnProgressListener(new OnProgressListener<UploadTask.TaskSnapshot>() {
                        @Override
                        public void onProgress(UploadTask.TaskSnapshot taskSnapshot) {
                            //calculating progress percentage
                            double progress = (100.0 * taskSnapshot.getBytesTransferred()) / taskSnapshot.getTotalByteCount();

                            //displaying percentage in progress dialog
                            progressDialog.setMessage("Uploaded " + ((int) progress) + "%...");
                        }
                    });
        }
        //if there is not any file
        else {
            //you can display an error toast
        }
    }

}