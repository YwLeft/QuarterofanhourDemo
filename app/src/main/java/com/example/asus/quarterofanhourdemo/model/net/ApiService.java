package com.example.asus.quarterofanhourdemo.model.net;

import com.example.asus.quarterofanhourdemo.base.Basebean;
import com.example.asus.quarterofanhourdemo.model.bean.CrosstalkBean;
import com.example.asus.quarterofanhourdemo.model.bean.LoginBean;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

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

    //发布段子
    @POST("quarter/publishJoke")
    @FormUrlEncoded
    Observable<Basebean> getPublished(@Field("uid") String uid,
                                             @Field("content") String  content);
}
