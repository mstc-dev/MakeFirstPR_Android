package com.demo.makefirstpr_android.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.demo.makefirstpr_android.R;

import java.util.ArrayList;

public class ContribAdapter extends RecyclerView.Adapter<ContribAdapter.ViewHolder> {

    private ArrayList<String> mContrib;
    private onItemListener onItemListener;
    private Context mContext;

    public ContribAdapter(Context context, ArrayList<String> mContrib, ContribAdapter.onItemListener onItemListener) {
        this.mContext = context;
        this.mContrib = mContrib;
        this.onItemListener = onItemListener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_item, parent, false);
        return new ViewHolder(view, onItemListener);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.mUsername.setText(mContrib.get(position));
        holder.itemView.setAnimation(AnimationUtils.loadAnimation(mContext, R.anim.fade_in));
    }

    @Override
    public int getItemCount() {
        return mContrib.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView mUsername;
        onItemListener onItemListener;

        public ViewHolder(@NonNull View itemView, onItemListener listener) {
            super(itemView);

            mUsername = itemView.findViewById(R.id.username);
            onItemListener = listener;
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            onItemListener.onItemClickListener(getAdapterPosition());
        }
    }

    public interface onItemListener {
        void onItemClickListener(int pos);
    }
}
