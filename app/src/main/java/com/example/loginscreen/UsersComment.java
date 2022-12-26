package com.example.loginscreen;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.OnPausedListener;
import com.google.firebase.storage.OnProgressListener;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.StorageReference;

import java.io.File;

public class UsersComment extends AppCompatActivity {
    private static final int GALLERY_REQ_CODE = 1000;
    ImageView imgGallery;
    FirebaseDatabase database = FirebaseDatabase.getInstance();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_users_comment);


        // Kullanıcının fotoğraf ekleme işlemini gerçekleştireceği bir buton oluşturun

         imgGallery = findViewById(R.id.image_view);
        Button selectPhotoButton = findViewById(R.id.downloadPic);




        selectPhotoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Cihazın fotoğraf galerisini açın
                Thread thread = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        // Cihazın fotoğraf galerisini açın
                        Intent intent = new Intent(Intent.ACTION_PICK);
                        intent.setData(MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                        startActivityForResult(intent, GALLERY_REQ_CODE);
                    }
                });
                thread.start();
            }


        });



    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode==RESULT_OK){
            if (requestCode == GALLERY_REQ_CODE ) {
                // Fotoğrafın dosya yolunu alın
                imgGallery.setImageURI(data.getData());



            }
        }
        // Fotoğraf dosyasının yolunu alın


// Firebase Storage'a dosya olarak yükleme işlemi başlatın
        FirebaseStorage storage = FirebaseStorage.getInstance();
        StorageReference storageRef = storage.getReference();
        StorageReference imagesRef = storageRef.child("images");

        Uri file = data.getData();
        System.out.println("Dosya yolu: " + imgGallery.toString());
        StorageReference imageRef = imagesRef.child(file.getLastPathSegment());
        UploadTask uploadTask = imageRef.putFile(file);

// Yükleme işlemini izleyin
        uploadTask.addOnProgressListener(new OnProgressListener<UploadTask.TaskSnapshot>() {
            @Override
            public void onProgress(UploadTask.TaskSnapshot taskSnapshot) {
                double progress = (100.0 * taskSnapshot.getBytesTransferred()) / taskSnapshot.getTotalByteCount();
                System.out.println("Upload is " + progress + "% done");
            }
        }).addOnPausedListener(new OnPausedListener<UploadTask.TaskSnapshot>() {
            @Override
            public void onPaused(UploadTask.TaskSnapshot taskSnapshot) {
                System.out.println("Upload is paused");
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception exception) {
                System.out.println("Upload failed: " + exception.getMessage());
            }
        }).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
            @Override
            public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                System.out.println("Upload completed successfully");
            }
        });


    }
    public void uploadPhoto(String filePath){

    }








}