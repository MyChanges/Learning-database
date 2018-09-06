package com.live.haiwang.livegiftsample.view;

import android.content.Context;
import android.net.Uri;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseBooleanArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Checkable;
import android.widget.FrameLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.facebook.drawee.view.SimpleDraweeView;
import com.live.haiwang.livegiftsample.R;
import com.live.haiwang.livegiftsample.model.GiftInfo;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by haiwang on 2017/7/9.
 */

public class GiftViewPager extends FrameLayout{

    private ViewPager mExtViewPager;
    private CirclePageIndicator mCirclePageIndicator;
    private LayoutInflater mInflater;
    private List<GiftInfo> mGifts;
    private GiftItemPagerAdapter pagerAdapter;
    private RecyclerView.Adapter mLastAdapter;
    private int mLastPos = -1;

    public GiftViewPager(Context context) {
        super(context);
    }

    public GiftViewPager(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    {
        mInflater = LayoutInflater.from(getContext());
        mInflater.inflate(R.layout.tab_pager_view, this);
        mGifts = new ArrayList<>();
        for(int i = 0; i < 23; i++){
            GiftInfo info = new GiftInfo();
            info.name = "gift" + i;
            mGifts.add(info);
        }
        mExtViewPager = (ExtViewPager) findViewById(R.id.live_pager);
        pagerAdapter = new GiftItemPagerAdapter();
        mExtViewPager.setAdapter(pagerAdapter);
        mCirclePageIndicator = (CirclePageIndicator) findViewById(R.id.live_indicator);
        mCirclePageIndicator.setViewPager(mExtViewPager);
    }

    private class GiftItemPagerAdapter extends PagerAdapter{

        int size;
        GiftAdapter adapter;

        GiftItemPagerAdapter(){
            size = mGifts.size() % 10 == 0 ? mGifts.size() / 10 : mGifts.size() / 10 + 1;
        }

        @Override
        public int getCount() {
            return size;
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == object;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView((View)object);
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            View view = mInflater.inflate(R.layout.layout_local_gift, null);
            RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.gift_list_view);
            recyclerView.setLayoutManager(new GridLayoutManager(getContext(), 5));
            List<GiftInfo> data;
            if(position < size - 1){
                data = mGifts.subList(position * 10, position * 10 + 10);
            }else{
                data = mGifts.subList(position * 10, mGifts.size());
            }
            adapter = new GiftAdapter(data);
            recyclerView.setAdapter(adapter);
            container.addView(view);
            return view;
        }
    }

    private class GiftAdapter extends RecyclerView.Adapter<GiftViewHolder>{
        List<GiftInfo> gifts;

        GiftAdapter(List<GiftInfo> gift){
            this.gifts = gift;
        }

        @Override
        public GiftViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            return new GiftViewHolder(mInflater.inflate(R.layout.grid_item_send_gift_new , parent, false),this, gifts);
        }

        @Override
        public void onBindViewHolder(GiftViewHolder holder, int position) {
            if(holder.itemView instanceof Checkable) {
                ((Checkable)holder.itemView).setChecked(gifts.get(position).isChecked);
            }
            holder.tv.setText(gifts.get(position).name);
            holder.simpleDraweeView.setImageURI(Uri.parse("http://imgstest.ikanshu.cn/images-wwlive/gift/1707/6aa9c572116147388c9e266a27e40dac_144.gif"));
        }

        @Override
        public int getItemCount() {
            return gifts.size();
        }

    }

    class GiftViewHolder extends RecyclerView.ViewHolder{
        TextView tv;
        SimpleDraweeView simpleDraweeView;

        GiftViewHolder(final View itemView, final RecyclerView.Adapter adapter, final List<GiftInfo> infos) {
            super(itemView);
            tv = (TextView) itemView.findViewById(R.id.tv_title);
            simpleDraweeView = (SimpleDraweeView) itemView.findViewById(R.id.img_gift);
            itemView.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View v) {
                    for(GiftInfo info : mGifts)
                        info.isChecked = false;
                    infos.get(getLayoutPosition()).isChecked = true;
                    adapter.notifyItemChanged(getLayoutPosition());
                    if(mLastAdapter != null && mLastPos != -1)
                        mLastAdapter.notifyItemChanged(mLastPos);
                    mLastAdapter = adapter;
                    mLastPos = getLayoutPosition();
//                    Toast.makeText(getContext(), "点击了" + getLayoutPosition(), Toast.LENGTH_SHORT).show();
                }
            });
        }
    }

}
