package com.elisvobs.roots.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import com.elisvobs.roots.R;
import com.elisvobs.roots.model.OnBoardItem;

import java.util.ArrayList;

public class OnBoardAdapter extends PagerAdapter {
    private Context mContext;
    ArrayList<OnBoardItem> onBoardItems = new ArrayList<>();

    public OnBoardAdapter(Context context, ArrayList<OnBoardItem> onBoardItems) {
        mContext = context;
        this.onBoardItems = onBoardItems;
    }

    @Override
    public int getCount() {
        return onBoardItems.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        View itemView = LayoutInflater.from(mContext).inflate(R.layout.onboard_item, container, false);
        OnBoardItem item = onBoardItems.get(position);

        ImageView pic = itemView.findViewById(R.id.iv_onboard);
        TextView title, content;
        title = itemView.findViewById(R.id.tv_header);
        content = itemView.findViewById(R.id.tv_desc);

        title.setText(item.getTitle());
        pic.setImageResource(item.getImageID());
        content.setText(item.getDescription());

        container.addView(itemView);
        return itemView;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((LinearLayout) object);
    }

}