package com.example.firebasetest;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.List;

public class BuyAdapter extends RecyclerView.Adapter<BuyAdapter.ImageViewHolder> {

    private Context mContext;
    private List<Upload_Sell> mUploads;

    public BuyAdapter(Context context,List<Upload_Sell> uploads){
        mContext = context;
        mUploads = uploads;
    }

    @NonNull
    @Override
    public ImageViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(mContext).inflate(R.layout.buy_template,parent,false);
        return new ImageViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ImageViewHolder holder, int position) {
        Upload_Sell uploadCurrent = mUploads.get(position);
        holder.textViewCat.setText(uploadCurrent.getCat());
        holder.textViewProduct.setText(uploadCurrent.getPro());
        holder.textViewPrice.setText(uploadCurrent.getPrice());
        holder.textViewContact.setText(uploadCurrent.getContact());
        Picasso.get().load(uploadCurrent.getImageUrl()).placeholder(R.mipmap.ic_launcher).fit().centerInside().into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return mUploads.size();
    }

    public class ImageViewHolder extends RecyclerView.ViewHolder{
        public TextView textViewCat;
        public TextView textViewProduct;
        public TextView textViewPrice;
        public TextView textViewContact;
        public ImageView imageView;
        public ImageViewHolder(@NonNull View itemView) {
            super(itemView);

            textViewCat = itemView.findViewById(R.id.category);
            textViewProduct = itemView.findViewById(R.id.product);
            textViewPrice = itemView.findViewById(R.id.price);
            textViewContact = itemView.findViewById(R.id.contact_no);
            imageView = itemView.findViewById(R.id.image_view_upload_buy);

        }
    }
}
