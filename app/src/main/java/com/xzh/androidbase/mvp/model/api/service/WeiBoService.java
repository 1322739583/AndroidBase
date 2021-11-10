package com.xzh.androidbase.mvp.model.api.service;

import com.xzh.androidbase.mvp.model.entry.Repo;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface WeiBoService {

    @GET("/users/{user}/repos")
    Observable<List<Repo>> getRepos(@Path("user") String user);


}
