package com.example.gilharap.mybluetooth3;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;


public class PairedAdapter extends RecyclerView.Adapter<PairedAdapter.CustomViewHolder>{



    public interface SelectListener{
        void onSelect(int position);
    }


    private List<String> mDevices;
    private SelectListener mListener;

    public PairedAdapter(List<String> mDevices, SelectListener selectListener) {
        this.mDevices = mDevices;
        this.mListener = selectListener;
    }

    @Override
    public CustomViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.paired_adapter_row, null);
        CustomViewHolder viewHolder = new CustomViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(CustomViewHolder holder, int position) {
        final String device = mDevices.get(position);
        holder.mName.setText(device);
        holder.mConnect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mListener.onSelect(position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mDevices.size();
    }

    public class CustomViewHolder extends RecyclerView.ViewHolder {
//        protected TextView name;
        @BindView(R.id.name) TextView mName;
        @BindView(R.id.select) View mConnect;

        public CustomViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }
}
