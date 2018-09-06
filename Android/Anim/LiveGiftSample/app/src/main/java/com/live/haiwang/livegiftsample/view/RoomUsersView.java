package com.live.haiwang.livegiftsample.view;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.View;

import com.live.haiwang.livegiftsample.R;

/**
 * Created by haiwang on 2017/6/28.
 */

public class RoomUsersView extends CustomBaseViewLinear implements View.OnClickListener{

    protected RecyclerView mRecyclerView;
    private LinearLayoutManager mLinearLayoutManager;

    public RoomUsersView(Context context) {
        super(context);
    }

    public RoomUsersView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public void onClick(View v) {

    }

    @Override
    protected int getLayoutId() {
        return R.layout.room_users;
    }

    @Override
    protected void initView() {
        mRecyclerView = (RecyclerView) findViewById(R.id.listview_users);
        mLinearLayoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL ,false);
        mRecyclerView.setLayoutManager(mLinearLayoutManager);
        mRecyclerView.setOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
                boolean needLoadMore;
                if(newState == RecyclerView.SCROLL_STATE_IDLE && mLinearLayoutManager.findFirstVisibleItemPosition() == recyclerView.getAdapter().getItemCount() - 1){

                }

            }
        });
    }

}
