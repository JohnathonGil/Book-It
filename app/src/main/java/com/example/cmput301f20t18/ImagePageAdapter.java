package com.example.cmput301f20t18;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.PagerAdapter;

import java.util.ArrayList;

//This needs to be where ever a cover book is at
/*                mPager = findViewById(R.id.slider_viewer);
                imageAdapter = new ImagePageAdapter (getSupportFragmentManager(),1);
                mPager.setAdapter(imageAdapter);    */


public class ImagePageAdapter extends PagerAdapter {

    private Context mContext;
    private ArrayList<Bitmap> photos;

    public ImagePageAdapter(Context mContext, ArrayList<Bitmap> photos) {
        this.mContext = mContext;
        this.photos = photos;
    }

    @Override
    public int getCount() {
        return photos.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        ImageView imageView = new ImageView(mContext);
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);

        Bitmap bm = photoAdapter.scaleBitmap(photos.get(position),
                imageView.getLayoutParams().width,
                imageView.getLayoutParams().height);

        imageView.setImageBitmap(bm);
        container.addView(imageView,0);

        return imageView;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((ImageView) object);
    }

}
