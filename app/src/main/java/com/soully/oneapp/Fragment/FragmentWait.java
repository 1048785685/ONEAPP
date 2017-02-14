package com.soully.oneapp.Fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.soully.oneapp.R;

/**
 * Created by Soully on 2017/2/14.
 */

public class FragmentWait extends Fragment{
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
       View view = inflater.inflate(R.layout.fragment_wait,container,false);
        ImageView image = (ImageView) view.findViewById(R.id.wait);
        Glide.with(this).load(R.mipmap.zaijia).asGif().into(image);
        return view;
    }
}
