package com.vogella.android.minim2;

import com.vogella.android.minim2.models.Museums;

import retrofit2.Call;
import retrofit2.http.GET;

// Gets y Post que funcionen igual que les APIs de java
public interface APIInterface {
    @GET("/api/dataset/museus/format/json/")
    Call<Museums> getMuseums();
}
