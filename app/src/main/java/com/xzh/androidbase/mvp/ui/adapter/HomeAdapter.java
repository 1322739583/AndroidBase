package com.xzh.androidbase.mvp.ui.adapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.xzh.androidbase.R;
import com.xzh.androidbase.mvp.model.entry.Repo;

import java.util.List;

public class HomeAdapter extends BaseQuickAdapter<Repo, BaseViewHolder> {
    public HomeAdapter(@Nullable List<Repo> data) {
        super(R.layout.fragment_a_item,data);
    }

    @Override
    protected void convert(@NonNull BaseViewHolder helper, Repo item) {
        helper.setText(R.id.tv_repo_title,item.getName());
      //  helper.setText(R.id.tv_repo_intro,item);
    }
}
