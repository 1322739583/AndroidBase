package com.xzh.androidbase.mvp.model.api.service;

import com.xzh.androidbase.mvp.model.entry.AddRelease;
import com.xzh.androidbase.mvp.model.entry.AddReleaseResponse;
import com.xzh.androidbase.mvp.model.entry.AddUserResponse;
import com.xzh.androidbase.mvp.model.entry.AssertResponse;
import com.xzh.androidbase.mvp.model.entry.Issue;
import com.xzh.androidbase.mvp.model.entry.Release;
import com.xzh.androidbase.mvp.model.entry.Repo;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface RepoService {

    @GET("/users/{user}/repos")
    Observable<List<Repo>> getRepos(@Path("user") String user);


    @GET("/users/{user}/repos")
    Observable<List<Repo>> getReposByPage(@Path("user") String user, @Query("page") int page, @Query("per_page") int perPage);

    @POST("/repos/{user}/{repo}/issues")
    Observable<AddUserResponse> addIssue(@Path("user") String user, @Path("repo") String repo, @Body Issue issue);

    @POST("/repos/{user}/{repo}/releases")
    Observable<AddReleaseResponse> addRelease(@Path("user") String user, @Path("repo") String repo, @Body AddRelease release);

    @GET("/repos/{user}/{repo}/releases/{id}")
    Observable<Release> getReleaseById(@Path("user") String user, @Path("repo") String repo, @Path("id") int id);

    @POST("/repos/{user}/{repo}/releases/{id}/assets")
    Observable<AssertResponse> uploadAssert(@Path("user") String user, @Path("repo") String repo, @Path("id") int id, @Query("name") String name);

}