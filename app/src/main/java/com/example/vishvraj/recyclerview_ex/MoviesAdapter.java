package com.example.vishvraj.recyclerview_ex;

import android.graphics.Color;
import android.graphics.PorterDuff;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;

import org.joda.time.DateTime;
import org.joda.time.Days;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;


/**
 * Created by vishvraj on 20-01-2017.
 */

public class MoviesAdapter extends RecyclerView.Adapter<MoviesAdapter.MyViewHolder> {

    private List<Movie> moviesList;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView title, year, month, date, genre, totaldays;
        public ProgressBar progressBar;

        public MyViewHolder(View view) {
            super(view);
            title = (TextView) view.findViewById(R.id.title);
            genre = (TextView) view.findViewById(R.id.genre);
            year = (TextView) view.findViewById(R.id.year);
            totaldays = (TextView) view.findViewById(R.id.total_days);
            progressBar = (ProgressBar) view.findViewById(R.id.progressBar2);
        }
    }


    public MoviesAdapter(List<Movie> moviesList) {
        this.moviesList = moviesList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.movie_list_row, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Movie movie = moviesList.get(position);

        //for current date
        Calendar calendar = Calendar.getInstance();
        int curr_year = calendar.get(Calendar.YEAR);
        int curr_month = calendar.get(Calendar.MONTH);
        int curr_date = calendar.get(Calendar.DATE);
        curr_month += 1;

        //for total days available
        int total_days = 0;

        //date from sqlite database
        int db_year = Integer.parseInt(movie.getYear());
        int db_month = Integer.parseInt(movie.getMonth());
        int db_date = Integer.parseInt(movie.getDate());

        //for jola's time api dont forget to add gradle dependancy
        String date_from_db = String.valueOf(db_date) + "/" + String.valueOf(db_month) + "/" + String.valueOf(db_year) + " 09:29:58";
        String date_from_curr = String.valueOf(curr_date) + "/" + String.valueOf(curr_month) + "/" + String.valueOf(curr_year) + " 09:29:58";

        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

        Date d1 = null;
        Date d2 = null;

        try {
            d1 = format.parse(date_from_db);
            d2 = format.parse(date_from_curr);
            DateTime dt1 = new DateTime(d1);
            DateTime dt2 = new DateTime(d2);
            total_days = Days.daysBetween(dt2, dt1).getDays();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        //displaying data
        String title = "Title:-\t" + movie.getTitle();
        String genre = "Genre:-\t" + movie.getGenre();
        String Date = "Date:-\t" + date_from_db;
        String days = "Total Days:-\t" + String.valueOf(total_days);
        holder.title.setText(title);
        holder.genre.setText(genre);
        holder.year.setText(Date);
        holder.totaldays.setText(days);

        //for progressbar color
        if (total_days < 15) {
            holder.progressBar.getProgressDrawable().setColorFilter(Color.parseColor("#f44336"), PorterDuff.Mode.MULTIPLY);
        } else if (total_days < 30) {
            holder.progressBar.getProgressDrawable().setColorFilter(Color.parseColor("#ffea00"), PorterDuff.Mode.MULTIPLY);
        } else {
            holder.progressBar.getProgressDrawable().setColorFilter(Color.parseColor("#64dd17"), PorterDuff.Mode.MULTIPLY);
        }
        holder.progressBar.setProgress(total_days);
    }

    @Override
    public int getItemCount() {
        return moviesList.size();
    }
}