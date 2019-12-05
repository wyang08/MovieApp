package com.programming_concept.couchcoach;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;


import com.nostra13.universalimageloader.cache.memory.impl.WeakMemoryCache;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.assist.ImageScaleType;
import com.nostra13.universalimageloader.core.display.FadeInBitmapDisplayer;

import java.util.ArrayList;

public class PersonListAdapter extends ArrayAdapter<Person>
{
    private static final String TAG = "PersonListAdapter";
    private Context mContext;
    private int mResource;
    private int lastPosition = -1;

    public PersonListAdapter(Context context, int resource, ArrayList<Person> objects)
    {
        super(context, resource, objects);
        mContext = context;
        mResource = resource;
    }

    private static class ImageHolder
    {
        TextView title;
        TextView publish_day;
        TextView director;
        ImageView img;
    }

    public View getView(int position, View convertView, ViewGroup parent)
    {
        setupImageLoader();

        String title = getItem(position).getTitle();
        String publish_day = getItem(position).getPublish_day();
        String director = getItem(position).getDirector();
        String imaURL = getItem(position).getImaURL();
//        Person person = new Person(title, publish_day, director);

        final View result;
        ImageHolder holder;

        if (convertView == null)
        {
            LayoutInflater inflater = LayoutInflater.from(mContext);
            convertView = inflater.inflate(mResource, parent, false);
            holder = new ImageHolder();
            holder.title = (TextView) convertView.findViewById(R.id.textView01);
            holder.publish_day = (TextView) convertView.findViewById(R.id.textView02);
            holder.director = (TextView) convertView.findViewById(R.id.textView03);
            holder.img = (ImageView) convertView.findViewById(R.id.image);
            result = convertView;
            convertView.setTag(holder);
        }
        else
        {
            holder = (ImageHolder) convertView.getTag();
            result = convertView;
        }

        Animation animation = AnimationUtils.loadAnimation(mContext, (position > lastPosition) ?
                R.anim.load_down_anim : R.anim.load_up_anim);
        result.startAnimation(animation);
        lastPosition = position;

        ImageLoader imageLoader = ImageLoader.getInstance();

        int defaultImage = mContext.getResources().getIdentifier("@drawable/image_failed", null, mContext.getPackageName());

        DisplayImageOptions options = new DisplayImageOptions.Builder().cacheInMemory(true)
                .cacheOnDisc(true).resetViewBeforeLoading(true)
                .showImageForEmptyUri(defaultImage)
                .showImageOnFail(defaultImage)
                .showImageOnLoading(defaultImage).build();

        imageLoader.displayImage(imaURL, holder.img, options);

        holder.title.setText(title);
        holder.director.setText(director);
        holder.publish_day.setText(publish_day);

//        textView_title.setText(title);
//        textView_publish_day.setText(publish_day);
//        textView_director.setText(director);

        return convertView;

    }

    private void setupImageLoader()
    {
        // UNIVERSAL IMAGE LOADER SETUP
        DisplayImageOptions defaultOptions = new DisplayImageOptions.Builder()
                .cacheOnDisc(true).cacheInMemory(true)
                .imageScaleType(ImageScaleType.EXACTLY)
                .displayer(new FadeInBitmapDisplayer(300)).build();

        ImageLoaderConfiguration config = new ImageLoaderConfiguration.Builder(
                mContext)
                .defaultDisplayImageOptions(defaultOptions)
                .memoryCache(new WeakMemoryCache())
                .discCacheSize(100 * 1024 * 1024).build();

        ImageLoader.getInstance().init(config);
        // END - UNIVERSAL IMAGE LOADER SETUP
    }
}
