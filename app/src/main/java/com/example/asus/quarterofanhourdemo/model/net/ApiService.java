package com.example.asus.quarterofanhourdemo.model.net;

import com.example.asus.quarterofanhourdemo.base.Basebean;
import com.example.asus.quarterofanhourdemo.model.bean.CrosstalkBean;
import com.example.asus.quarterofanhourdemo.model.bean.LoginBean;
import com.example.asus.quarterofanhourdemo.model.bean.RecommendHotBean;

import java.util.List;
import java.util.Map;

import io.reactivex.Observable;
import okhttp3.ResponseBody;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
import retrofit2.http.QueryMap;

/**
 * 创建时间  2017/12/2 14:41
 * 创建人    gaozhijie
 * 类描述    接口
 */
public interface ApiService {

    //获取段子
    @FormUrlEncoded
    @POST("quarter/getJokes")
    Observable<Basebean<List<CrosstalkBean>>> getJokes(@Field("page") String  page);

    //登陆
    @POST("user/login")
    @FormUrlEncoded
    Observable<Basebean<LoginBean>> getLogin(@Field("mobile") String mobile,
                                             @Field("password") String  password);


    //热门视频
    @POST("quarter/getVideos")
    Observable<Basebean<List<RecommendHotBean>>> getRecommendHot(@QueryMap Map<String,String> map);

    /*//发布段子
    @Multipart
    @POST("quarter/publishJoke")
    Observable<ResponseBody> getPublished(
            @Field("uid") String mobile,
            @Field("content") String content,
            @Part MultipartBody.Part file);*/

    //发布段子
    @POST("quarter/publishJoke")
    Observable<ResponseBody> getPublished(
            @QueryMap Map<String,String> map);




}
