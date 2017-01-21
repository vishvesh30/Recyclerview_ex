package com.example.vishvraj.recyclerview_ex;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<Movie> movieList = new ArrayList<>();
    private RecyclerView recyclerView;
    private MoviesAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = (RecyclerView) findViewById(R.id.recyclerview);
        mAdapter = new MoviesAdapter(movieList);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.addOnItemTouchListener(new TouchListener(getApplicationContext(), recyclerView, new TouchListener.ClickListener() {
            @Override
            public void onClick(View view, int position) {
                Movie movie = movieList.get(position);
                Toast.makeText(getApplicationContext(), movie.getTitle() + " is selected!", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onLongClick(View view, int position) {

            }
        }));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(mAdapter);
        prepareMovieData();
    }

    private void prepareMovieData() {
        Movie movie = new Movie("Mad Max: Fury Road", "Action & Adventure", "2016", "12", "30");
        movieList.add(movie);

        movie = new Movie("Inside Out", "Animation, Kids & Family", "2017", "01", "23");
        movieList.add(movie);

        movie = new Movie("Star Wars: Episode VII - The Force Awakens", "Action", "2018", "05", "14");
        movieList.add(movie);

        movie = new Movie("Shaun the Sheep", "Animation", "2017", "02", "21");
        movieList.add(movie);

        movie = new Movie("The Martian", "Science Fiction & Fantasy", "2017", "02", "26");
        movieList.add(movie);

        movie = new Movie("Mission: Impossible Rogue Nation", "Action", "2018", "06", "14");
        movieList.add(movie);

        movie = new Movie("Up", "Animation", "2018", "08", "15");
        movieList.add(movie);

        movie = new Movie("Star Trek", "Science Fiction", "2017", "04", "18");
        movieList.add(movie);

        movie = new Movie("The LEGO Movie", "Animation", "2014", "04", "29");
        movieList.add(movie);

        movie = new Movie("Iron Man", "Action & Adventure", "2018", "11", "20");
        movieList.add(movie);

        movie = new Movie("Aliens", "Science Fiction", "2018", "09", "15");
        movieList.add(movie);

        movie = new Movie("Chicken Run", "Animation", "2016", "06", "05");
        movieList.add(movie);

        movie = new Movie("Back to the Future", "Science Fiction", "2017", "03", "17");
        movieList.add(movie);

        movie = new Movie("Raiders of the Lost Ark", "Action & Adventure", "2017", "01", "13");
        movieList.add(movie);

        movie = new Movie("Goldfinger", "Action & Adventure", "2016", "01", "19");
        movieList.add(movie);

        movie = new Movie("Guardians of the Galaxy", "Science Fiction & Fantasy", "2018", "09", "13");
        movieList.add(movie);

        mAdapter.notifyDataSetChanged();
    }


}
