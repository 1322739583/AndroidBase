package com.xzh.androidbase.mvp.ui.adapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.xzh.androidbase.R;

import java.util.List;

public class HomeAdapter extends BaseQuickAdapter<String, BaseViewHolder> {
    public HomeAdapter(@Nullable List<String> data) {
        super(R.layout.home_item,data);
    }

    @Override
    protected void convert(@NonNull BaseViewHolder helper, String item) {
        helper.setText(R.id.tv_home,item);
    }
}
