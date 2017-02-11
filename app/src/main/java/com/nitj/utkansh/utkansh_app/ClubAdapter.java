package com.nitj.utkansh.utkansh_app;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Build;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.nitj.utkansh.utkansh_app.ImgLoader.BitmapLoader;

import java.util.ArrayList;

/**
 * Created by Rishab on 12/3/2016.
 */

public class ClubAdapter extends RecyclerView.Adapter<ClubAdapter.ClubViewHolder> {
    static Activity activity;
    ArrayList<Clubs_set> clubs = new ArrayList<Clubs_set>();
    Context ctx;
            public ClubAdapter(ArrayList<Clubs_set> clubs, Context ctx, Activity activity)
            {
                this.clubs = clubs;
                this.ctx = ctx;
                this.activity=activity;
            }
    @Override
    public ClubViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_view,parent,false);
        ClubViewHolder clubViewHolder = new ClubViewHolder(view,ctx,clubs);
        return clubViewHolder;
    }

    @Override
    public void onBindViewHolder(ClubViewHolder holder, int position) {

        Clubs_set clubs_set = clubs.get(position);
        /*Bitmap bmp=BitmapLoader.decodeSampledBitmapFromResource(ctx.getResources(),clubs_set.getImage_id(),100,100);
        holder.club_img.setImageBitmap(bmp);*/
        holder.club_img.setImageResource(clubs_set.getImage_id());
        holder.club_name.setText(clubs_set.getClubs());
    }

    @Override
    public int getItemCount() {
        return clubs.size();
    }

    public static class ClubViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener
    {
        ImageView club_img;
        TextView club_name;
        ArrayList<Clubs_set> clubs = new ArrayList<Clubs_set>();
        Context ctx;
        View view;
        public ClubViewHolder (View view, Context ctx, ArrayList<Clubs_set> clubs)
        {
            super(view);
            this.ctx = ctx;
            this.clubs = clubs;
            this.view=view;
            view.setOnClickListener(this);
            view.setOnClickListener(this);
            club_img = (ImageView) view.findViewById(R.id.club_image);
            club_name = (TextView) view.findViewById(R.id.club_text);
        }


        @Override
        public void onClick(View v) {

            int position = getAdapterPosition();
            Clubs_set c = this.clubs.get(position);
            String society = c.getClubs();
            Intent intent = new Intent(ctx, EventList.class);
            if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.LOLLIPOP) {
                ActivityOptionsCompat options = ActivityOptionsCompat.
                        makeSceneTransitionAnimation(activity, view.findViewById(R.id.club_image), "club_tx");
                intent.putExtra("society", society);
                this.ctx.startActivity(intent,options.toBundle());
            }
            else{
            intent.putExtra("society", society);
            this.ctx.startActivity(intent);}
        }
    }
}
