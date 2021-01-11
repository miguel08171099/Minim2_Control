package com.vogella.android.minim2;


import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
// Gets y Post que funcionen igual que les APIs de java

public interface APIInterface {

    @GET("/users/{username}")
    Call<GithubUser> getUser(@Path("username") String username);

    @GET("/users/{username}/repos")
    Call<List<GithubRepositories>> getRepositories(@Path("username") String username);


}
