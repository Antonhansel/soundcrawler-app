package com.example.apollo.soundcrawler;

import javax.security.auth.callback.Callback;

import retrofit.http.Field;
import retrofit.http.FormUrlEncoded;
import retrofit.http.POST;

/**
 * Created by Apollo on 19/04/15.
 */
public interface RestActivity {
    @FormUrlEncoded
    @POST("/crawlsoundcloud")
    // void crawlUrl(@Body String url, Callback cb);
    void crawlUrl(@Field("url") String url, Callback cb);

}
