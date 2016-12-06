package com.smashedcontrollers.sportsontv;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Luke Smy on 06/12/2016.
 */

public class GalleryFragment extends Fragment {
    //global variables
    private RecyclerView rcView;

    public static GalleryFragment newInstance(){
        return new GalleryFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View newView = inflater.inflate(R.layout.fragment_gallery, container, false);
        rcView =(RecyclerView)newView.findViewById(R.id.fragment_gallery_recycler_view);
        rcView.setLayoutManager(new GridLayoutManager(getActivity(), 3));

        return newView;
    }





}
