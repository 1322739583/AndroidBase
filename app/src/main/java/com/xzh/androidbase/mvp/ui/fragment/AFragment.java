package com.xzh.androidbase.mvp.ui.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.xzh.androidbase.R;
import com.xzh.androidbase.mvp.contract.HomeContract;
import com.xzh.androidbase.mvp.model.HomeModel;
import com.xzh.androidbase.mvp.presenter.HomePresenter;
import com.xzh.androidbase.mvp.ui.activity.MainActivity;
import com.xzh.androidbase.mvp.ui.adapter.HomeAdapter;


import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

/**
 * Mvp模式的起点是View
 */
public class AFragment extends Fragment implements HomeContract.View<HomePresenter,List>  {
    RecyclerView recyclerView=null;
   //  @Inject
    HomePresenter presenter;

    HomeAdapter adapter;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_a, null);
        recyclerView=view.findViewById(R.id.recycler);

        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);

        adapter = new HomeAdapter(new ArrayList<>());
        recyclerView.setAdapter(adapter);

        presenter=new HomePresenter(this);
        //先获取数据，可以在这里获取list的内容
        presenter.onLoadData();

        return view;
    }


    @Override
    public void setPresenter(HomePresenter presenter) {
        this.presenter=presenter;
    }

    @Override
    public void initData(List data) {
        adapter.setNewData(data);
    }

    @Override
    public void updateData(List data) {

    }


}
