package com.example.akshay.jsonparsingvolleyawsrh.activities;

import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.akshay.jsonparsingvolleyawsrh.R;

public class AnimeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anime);
        //hide the default action bar

        getSupportActionBar().hide();


        //recieve data
        String name = getIntent().getExtras().getString("anime_name");
        String description = getIntent().getExtras().getString("anime_description");
        String studio = getIntent().getExtras().getString("anime_studio");
        String category = getIntent().getExtras().getString("anime_category");
        int nbEpisode = getIntent().getExtras().getInt("anime_nb_episode");
        String rating = getIntent().getExtras().getString("anime_rating");
        String image_url = getIntent().getExtras().getString("anime_img");

        //initilise views
        CollapsingToolbarLayout collapsingToolbarLayout = findViewById(R.id.ctlCollapsingToolbar);
        collapsingToolbarLayout.setTitleEnabled(true);

        TextView tvName = findViewById(R.id.aaRowName);
        TextView tvStudio = findViewById(R.id.aaStudio);
        TextView tvCatagory = findViewById(R.id.aaCategorie);
        TextView tvDescription = findViewById(R.id.aaDescription);
        TextView tvRating = findViewById(R.id.aaRating);
        ImageView img = findViewById(R.id.aaThumbnail);


        // setting value to each view

        tvName.setText(name);
        tvCatagory.setText(description);
        tvDescription.setText(description);
        tvRating.setText(rating);
        tvStudio.setText(studio);

        RequestOptions requestOptions = new RequestOptions().centerCrop().placeholder(R.drawable.loading_shape).error(R.drawable.loading_shape);

        //setImageUsingGlide
        Glide.with(this).load(image_url).apply(requestOptions).into(img);



    }
}
