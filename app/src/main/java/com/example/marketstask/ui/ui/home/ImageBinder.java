package com.example.marketstask.ui.ui.home;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.widget.ImageView;

import androidx.databinding.BindingAdapter;


import com.example.marketstask.utils.ImageUtils;

import java.io.InputStream;

public class ImageBinder {

    private ImageBinder() {
    }

    @BindingAdapter({"imageURL"})
    public static void loadImage(ImageView imageView, String imageUrl) {
        final Bitmap bitmap = ImageUtils.getInstance().getBitmapFromMemCache(imageUrl);
        if(bitmap != null){
            imageView.setImageBitmap(bitmap);
        } else{
            new DownloadImageTask(imageView)
                    .execute(imageUrl);
        }
    }

    private static class DownloadImageTask extends AsyncTask<String, Void, Bitmap> {
        ImageView bmImage;
        ImageUtils imageUtils;
        Object lock;

        public DownloadImageTask(ImageView bmImage) {
            this.bmImage = bmImage;
            this.imageUtils = ImageUtils.getInstance();
            if(lock == null){
                lock = new Object();
            }
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        protected Bitmap doInBackground(String... urls) {
            synchronized (lock){
                String urldisplay = urls[0];
                Bitmap avatar = null;
                try {
                    InputStream in = new java.net.URL(urldisplay).openStream();
                    avatar = BitmapFactory.decodeStream(in);
                    imageUtils.addBitmapToMemoryCache(String.valueOf(urldisplay), avatar);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                return avatar;
            }
        }

        protected void onPostExecute(Bitmap result) {
            bmImage.setImageBitmap(result);
        }
    }

}

