package com.example.clcoktimer;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class CountryClockAdapter extends RecyclerView.Adapter<CountryClockAdapter.CountryClockView> {


    ArrayList<Country> countryArrayList;
    Context mContext;

    public  CountryClockAdapter(Context context){
        this.mContext = context;
    }


    public void setCountryArrayList(ArrayList<Country> countryArrayList){
        this.countryArrayList = countryArrayList;
    }

    @NonNull
    @Override
    public CountryClockView onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.view_country_time, parent, false);
        CountryClockView vh = new CountryClockView(view);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull CountryClockView holder, int position) {
        Country country = countryArrayList.get(position);
        holder.tvCountry.setText(country.name);
        holder.tvTime.setText(getCountryTime(country));

        holder.imgDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                countryArrayList.remove(position);
                notifyDataSetChanged();
            }
        });

    }

    @Override
    public int getItemCount() {
        return countryArrayList.size();
    }

    public class CountryClockView extends RecyclerView.ViewHolder {
        TextView tvCountry;
        TextView tvTime;

        TextView tvTimeFormat;

        ImageView imgDelete;
        public CountryClockView(@NonNull View itemView) {
            super(itemView);
            tvCountry = (TextView) itemView.findViewById(R.id.tvCountryName);
            tvTime = (TextView) itemView.findViewById(R.id.tvTime);
            tvTimeFormat = (TextView) itemView.findViewById(R.id.tvFormat);
            imgDelete  = (ImageView) itemView.findViewById(R.id.imgDelete);
        }

       
    }

    private String getCountryTime(Country country){
        Date date = new Date();
        date.setMinutes(date.getMinutes() + country.timeDifference);
        SimpleDateFormat dateFormat = new SimpleDateFormat("hh:mm a");
        String formattedDate = dateFormat.format(date).toString();
        return formattedDate;
    }
}
