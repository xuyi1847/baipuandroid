package com.baipu.project.Fragment;

import android.graphics.Rect;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import com.baipu.project.Adapter.FollowFragmentAdapter;
import com.baipu.project.Adapter.HomeItem;
import com.baipu.project.R;
import com.chad.library.adapter.base.BaseQuickAdapter;

import java.util.ArrayList;

public class NearbyFragment extends Fragment {
    private static final String[] TITLE = {"AnimationAnimationAnimationAnimationAnimationAnimationAnimationAnimationAnimation", "MultipleItem", "Header/Footer", "PullToRefresh",};
    private static final int[] IMG = {R.drawable.timg, R.drawable.timg, R.drawable.bottom_category, R.drawable.timg,};
    private RecyclerView mRecyclerView;
    private ArrayList<HomeItem> mDataList;
    View mview;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.tab_fragment_hot, container, false);

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mview=view;
        initView();
        initData();
        initAdapter();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }



    private void initView() {
        mRecyclerView = (RecyclerView)mview.findViewById(R.id.recyclerView);
        mRecyclerView.setLayoutManager(new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL));
    }

    @SuppressWarnings("unchecked")
    private void initAdapter() {
        BaseQuickAdapter homeAdapter = new FollowFragmentAdapter(R.layout.staggered_item_view, mDataList);
        homeAdapter.openLoadAnimation();
//        View top = getLayoutInflater().inflate(R.layout.top_view, (ViewGroup) mRecyclerView.getParent(), false);
//        homeAdapter.addHeaderView(top);
        homeAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                Log.d("testtest", "onItemClick: "+position);
            }

        });

        mRecyclerView.setAdapter(homeAdapter);
        int spacingInPixels=8;
//        mRecyclerView.addItemDecoration(new SpacesItemDecoration(spacingInPixels));
    }
    public class SpacesItemDecoration extends RecyclerView.ItemDecoration {
        private int space;

        public SpacesItemDecoration(int space) {
            this.space = space;
        }

        @Override
        public void getItemOffsets(Rect outRect, View view,
                                   RecyclerView parent, RecyclerView.State state) {
            outRect.left = space;
            outRect.right = space;
            outRect.bottom = space;

            // Add top margin only for the first item to avoid double space between items
            if (parent.getChildPosition(view) == 0)
                outRect.top = space;
        }
    }
    private void initData() {
        mDataList = new ArrayList<>();
        for (int i = 0; i < TITLE.length; i++) {
            HomeItem item = new HomeItem();
            item.setTitle(TITLE[i]);
            item.setImageResource(IMG[i]);
            mDataList.add(item);
        }
    }
}
