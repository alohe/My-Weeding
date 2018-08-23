package com.example.user.myapplication;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.WallpaperManager;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.ShareCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class View_Image_Detaile extends AppCompatActivity {
TextView textView;
Product product =null;
ImageView imageView;
Button share ;

    @Override
    public void onBackPressed() {
        super.onBackPressed();

    }
AlertDialog alertDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view_image_detaile);
       Toolbar toolbar = (Toolbar) findViewById(R.id.imageviewtoolbar);
        textView=(TextView)findViewById(R.id.textView);
        imageView=(ImageView)findViewById(R.id.imageview);

        setSupportActionBar(toolbar);

        RequestOptions requestOptions = new RequestOptions().centerCrop().placeholder(R.drawable.love).error(R.drawable.weeding);

        String image_url = getIntent().getExtras().getString("UserImage") ;
        // set image using Glide
        Glide.with(this).load(image_url).apply(requestOptions).into(imageView);
        //String image_url = getIntent().getExtras().getString("anime_img") ;
        textView.setText(getIntent().getStringExtra("UserImage"));

       // imageView.setImageResource(Integer.parseInt(getIntent().getStringExtra("UserImage")));
//  getActionBar().setDisplayHomeAsUpEnabled(true);
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.share);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               // Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                   //     .setAction("Action", null).show();
                //slide a social media and post there pictures inthe socaial media
                 share();
            }
        });


    }
    public  void  share()
    {
        Bitmap bitmap = viewbitmap(imageView,imageView.getWidth(),imageView.getHeight());
        Intent sendfile= new Intent(Intent.ACTION_SEND);
        sendfile.setType("image/jpeg");
        ByteArrayOutputStream arrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG,100,arrayOutputStream);
        File shre_file = new File(Environment.getExternalStorageDirectory()+File.separator+"ImageDemo.jpg");
        try {
            shre_file.createNewFile();
            FileOutputStream fileOutputStream = new FileOutputStream(shre_file);
            fileOutputStream.write(arrayOutputStream.toByteArray());
        } catch (IOException e) {
            e.printStackTrace();
        }
        sendfile.putExtra(Intent.EXTRA_STREAM,Uri.parse("file:///Internal storage/ImageDemo.jpg"));
        startActivity(Intent.createChooser(sendfile,"Share Image"));

    }
public  static Bitmap viewbitmap(View view,int width,int height){
Bitmap bitmap =Bitmap.createBitmap(width,height,Bitmap.Config.ARGB_8888);
    Canvas canvas = new Canvas(bitmap);
    view.draw(canvas);

        return bitmap ;
}
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.imageview_menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
       switch (item.getItemId())
       {

          case  R.id.wallpapermenu:
           {

               WallpaperManager wallpaperManager = WallpaperManager.getInstance(getApplicationContext());
               try
               {
wallpaperManager.setBitmap(viewbitmap(imageView,imageView.getWidth(),imageView.getHeight()));


Toast.makeText(getBaseContext(),"SuccessFully changed",Toast.LENGTH_LONG).show();
               }
               catch (Exception ex)
               {
                   ex.printStackTrace();
               }

           }
           case R.id.download:
           {
                alertDialog = new AlertDialog.Builder(this).create();
                alertDialog.setTitle("Download");
                alertDialog.setMessage("Are You want to save the app in your local drive?");
                alertDialog.setButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
   startsave();
                    }
                });
                alertDialog.setButton2("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        alertDialog.dismiss();
                    }
                });
                alertDialog.show();
           }
       }
       return true;
    }
    public  void startsave()
    {
        FileOutputStream fileOutputStream = null;
        File file = filedisk();
        if(!file.exists() && !file.mkdirs())
        {
            Toast.makeText(getBaseContext(),"Can't Create A Directory",Toast.LENGTH_LONG).show();
            return;
        }

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyymmsshhmmss");
        String date = simpleDateFormat.format( new Date());
        String name = "Img" + date + ". jpg";
        String file_name = file.getAbsolutePath()+"/"+name;
        File new_file = new File(file_name);
        try {
            fileOutputStream = new FileOutputStream(file_name);
            Bitmap bitmap = viewbitmap(imageView,imageView.getWidth(),imageView.getHeight());
            bitmap.compress(Bitmap.CompressFormat.JPEG,100,fileOutputStream);
            Toast.makeText(getBaseContext(),"Image Saved Successfully",Toast.LENGTH_LONG).show();
            fileOutputStream.flush();
            fileOutputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
refreshGallery(new_file);

    }

    private void refreshGallery(File file) {
        Intent intent = new Intent(Intent.ACTION_MEDIA_SCANNER_SCAN_FILE);
        intent.setData(Uri.fromFile(file));
        sendBroadcast(intent);
    }

    public File filedisk()
    {
        File file = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DCIM);
        return new File("Image");
    }
}
