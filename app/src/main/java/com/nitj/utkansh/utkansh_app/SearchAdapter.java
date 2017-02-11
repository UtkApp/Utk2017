package com.nitj.utkansh.utkansh_app;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import java.util.ArrayList;

public class SearchAdapter extends RecyclerView.Adapter<SearchAdapter.ViewHolder> {

    private Context context;
    private ArrayList<String> data;
    public SearchAdapter(Context context, ArrayList<String> data)
    {
        this.context=context;
        this.data=data;
    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.search_card, parent,false);
        ViewHolder mh = new ViewHolder(v);
        return mh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.textView.setText(data.get(position).toLowerCase());
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView textView;
        CardView cardView;
        public ViewHolder(View itemView) {
            super(itemView);
            cardView= (CardView) itemView.findViewById(R.id.cv_datacard);
            textView = (TextView) itemView.findViewById(R.id.text_data);
            cardView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            System.out.println("onClick!");
            String name=data.get(getAdapterPosition());
            String[] clubs=context.getResources().getStringArray(R.array.clubs);
            for (String str:clubs){
                if(name.equals(str)){
                    Intent intent = new Intent(context, EventList.class);
                    intent.putExtra("society", name);
                    System.out.println("society! "+name );

                    context.startActivity(intent);
                    return;
                }
            }
            System.out.println("event "+name);
            Intent intent = new Intent(context, Event.class);
            intent.putExtra("name", name);
            context.startActivity(intent);
        }
    }
}
