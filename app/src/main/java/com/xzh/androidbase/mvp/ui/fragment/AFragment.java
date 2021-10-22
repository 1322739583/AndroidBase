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
import com.xzh.androidbase.mvp.presenter.HomePresenter;
import com.xzh.androidbase.mvp.ui.activity.MainActivity;
import com.xzh.androidbase.mvp.ui.adapter.HomeAdapter;


import java.util.ArrayList;
import java.util.List;

/**
 * Mvp模式的起点是View
 */
public class AFragment extends Fragment implements HomeContract.View<HomePresenter> {
    RecyclerView recyclerView=null;
    private HomePresenter presenter=null;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_a, null);
        recyclerView=view.findViewById(R.id.recycler);
        List<String> list=new ArrayList<>();
        for (int i = 0; i <50 ; i++) {
            list.add("item"+i);
        }
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);

        HomeAdapter adapter=new HomeAdapter(new ArrayList<>());
        recyclerView.setAdapter(adapter);
        adapter.setNewData(list);

        return view;
    }


    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }

    @Override
    public void showError(Throwable e) {
     }


    @Override
    public void setPresenter(HomePresenter presenter) {
        this.presenter=presenter;
    }

public void test(int a,int b){

      //  int b;
    System.out.println("");
    System.out.println("");

    System.out.println();//1.213s 0.894s 1.7s 1.74s 2.56s 2.67 2.
}
}
