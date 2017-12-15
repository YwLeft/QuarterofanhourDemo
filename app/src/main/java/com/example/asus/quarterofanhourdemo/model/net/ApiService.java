package com.example.asus.quarterofanhourdemo.model.net;

import com.example.asus.quarterofanhourdemo.base.Basebean;
import com.example.asus.quarterofanhourdemo.model.bean.CrosstalkBean;
import com.example.asus.quarterofanhourdemo.model.bean.LoginBean;
import com.example.asus.quarterofanhourdemo.model.bean.RecommendHotBean;
import com.example.asus.quarterofanhourdemo.model.bean.VideoHotBean;

import java.util.List;
import java.util.Map;

import io.reactivex.Observable;
import okhttp3.MultipartBody;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
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


    //推荐热门视频
    @POST("quarter/getVideos")
    Observable<Basebean<List<RecommendHotBean>>> getRecommendHot(@QueryMap Map<String,String> map);


    //视频热门视频
    @POST("quarter/getHotVideos")
    Observable<Basebean<List<VideoHotBean>>> getVideoHotBean(@QueryMap Map<String,String> map);

    //发布段子
    @Multipart
    @POST("quarter/publishJoke")
    Observable<Basebean> getPublished(
            @Part MultipartBody.Part uid,
            @Part MultipartBody.Part content,
            @Part List<MultipartBody.Part> list

    );


}
