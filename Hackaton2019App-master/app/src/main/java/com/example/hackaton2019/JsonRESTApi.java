package com.example.hackaton2019;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import testing.Post;

public interface JsonRESTApi {
    @GET("posts")
    Call<List<Post>> getUsers();

}
