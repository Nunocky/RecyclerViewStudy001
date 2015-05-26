package org.nunocky.recyclerviewstudy001;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * RecyclerViewのアイテムビューとデータの管理。
 * このへんは従来の ListViewとAdapterの関係と一緒。
 */
public class SampleRecyclerAdapter extends RecyclerView.Adapter {

    private static final String TAG = "SampleRecyclerAdapter";
    // 適当なデータを用意
    private static List<String> strings = new ArrayList<>();

    static {
        for (int i = 0; i < 30; i++) {
            strings.add("Item " + i);
        }
    }

    private LayoutInflater mLayoutInflater;

    public SampleRecyclerAdapter(Context context) {
        mLayoutInflater = LayoutInflater.from(context);
    }

    @Override
    public int getItemCount() {
        return strings.size();
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = mLayoutInflater.inflate(R.layout.listitem_layout, viewGroup, false);
        return new CustomViewHolder(v);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        final CustomViewHolder viewHolder = (CustomViewHolder) holder;

        // アイテムビューとデータを関連付ける
        viewHolder.textView.setText(strings.get(position));

        // コールバックもこの辺で定義するのが良い？
        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "item clicked, row=" + viewHolder.getPosition());
            }
        });

        viewHolder.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "item button clicked, row=" + viewHolder.getPosition());
            }
        });
    }

    /**
     * ビューホルダー
     */
    private static class CustomViewHolder extends RecyclerView.ViewHolder {
        public TextView textView;
        public Button button;

        public CustomViewHolder(View itemView) {
            super(itemView);
            textView = (TextView) itemView.findViewById(R.id.textview0);
            button = (Button) itemView.findViewById(R.id.button);
        }
    }

}
