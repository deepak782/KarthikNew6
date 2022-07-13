package com.example.karthiknew6;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.imageview.ShapeableImageView;

import java.util.ArrayList;
import java.util.List;

public class CountryAdapter extends RecyclerView.Adapter<CountryAdapter.CountryHolder> {
    Context context;
    List<CountryModel> countryModelList=new ArrayList<>();
    //type3
    OnItemClickFun onItemClickFun;


    //type3

    public CountryAdapter(Context context, List<CountryModel> countryModelList, OnItemClickFun onItemClickFun) {
        this.context = context;
        this.countryModelList = countryModelList;
        this.onItemClickFun = onItemClickFun;
    }

    public CountryAdapter(Context context, List<CountryModel> countryModelList) {
        this.context = context;
        this.countryModelList = countryModelList;
    }

    @NonNull
    @Override
    public  CountryHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View root= LayoutInflater.from(parent.getContext()).inflate(R.layout.custom_horizontal,parent,false);
        Log.d("TAG",""+viewType);

        return new CountryHolder(root);
    }

    @Override
    public void onBindViewHolder(@NonNull CountryHolder holder, int position) {

        holder.shapeableImageView.setImageResource(countryModelList.get(position).getImage());
        holder.textView.setText(countryModelList.get(position).getName());

        //type2
       /* holder.layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context, ""+countryModelList.get(holder.getAdapterPosition()).getName(), Toast.LENGTH_SHORT).show();

            }
        });*/

    }

    @Override
    public int getItemCount() {
        return countryModelList.size();
    }

    public class CountryHolder extends RecyclerView.ViewHolder {
        ShapeableImageView shapeableImageView;
        LinearLayout layout;
        TextView textView;
        public CountryHolder(@NonNull View itemView) {
            super(itemView);
            shapeableImageView=itemView.findViewById(R.id.c_image);
            textView=itemView.findViewById(R.id.c_name);
            layout=itemView.findViewById(R.id.ll);

            //Type1
            /*itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    Toast.makeText(context,""+getAdapterPosition(),Toast.LENGTH_SHORT).show();
                    Toast.makeText(context, ""+countryModelList.get(getAdapterPosition()).getName(), Toast.LENGTH_SHORT).show();

                }
            });*/

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    onItemClickFun.onItemClick(getAdapterPosition());
                }
            });

        }
    }
}
