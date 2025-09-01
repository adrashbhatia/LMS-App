package com.example.xgenlms;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface ApiService {
    @POST("admin/login")
    Call<LoginResponse> login(@Body LoginRequest loginRequest);
}
