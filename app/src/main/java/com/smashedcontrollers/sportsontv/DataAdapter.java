package com.smashedcontrollers.sportsontv;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import java.util.ArrayList;
public class DataAdapter extends RecyclerView.Adapter<DataAdapter.ViewHolder> {
    //create list
    private ArrayList<String> footballTeam;
    //constructor has ArrayList as argument, which we pass and set data
    public DataAdapter(ArrayList<String> footballTeam) {
        this.footballTeam = footballTeam;
    }
    //we inflate the row layout as a View and return as ViewHolder object
    @Override
    public DataAdapter.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View newView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.card_row, viewGroup, false);
        return new ViewHolder(newView);
    }
    //we set the TextView text from ArrayList object
    @Override
    public void onBindViewHolder(DataAdapter.ViewHolder viewHolder, int i) {
        viewHolder.footballtv.setText(footballTeam.get(i));
    }
    //returns the size of the data
    @Override
    public int getItemCount() {
        return footballTeam.size();
    }
    //viewholder class to initailize layout text view
    public class ViewHolder extends RecyclerView.ViewHolder{
        private TextView footballtv;
        public ViewHolder(View view) {
            super(view);
            footballtv = (TextView)view.findViewById(R.id.footballtv);
        }
    }
}