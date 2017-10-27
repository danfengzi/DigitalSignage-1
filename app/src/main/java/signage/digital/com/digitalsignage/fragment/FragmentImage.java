package signage.digital.com.digitalsignage.fragment;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterViewFlipper;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.squareup.picasso.Picasso;

import java.io.File;
import java.util.ArrayList;

import signage.digital.com.digitalsignage.R;
import signage.digital.com.digitalsignage.WeatherView;
import signage.digital.com.digitalsignage.adapter.ImageAdapter;
import signage.digital.com.digitalsignage.model.City;

public class FragmentImage extends Fragment {
    private String path;

    static FragmentImage getInstance(String path) {
        FragmentImage frag = new FragmentImage();
        Bundle args = new Bundle();
        args.putString("path", path);
        frag.setArguments(args);
        return frag;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        System.out.println("----------- onCreate FragmentImage");
        Bundle args = getArguments();
        if(args!=null) {
            path = args.getString("path");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        System.out.println("----------------onCreateView FragmentImage");

        ImageView imageView = new ImageView(getContext());
        imageView.setScaleType(ImageView.ScaleType.FIT_END);
        imageView.setTag(path);
        Picasso.with(getContext())
                .load(path)
                .into(imageView);

        return imageView;
    }
}