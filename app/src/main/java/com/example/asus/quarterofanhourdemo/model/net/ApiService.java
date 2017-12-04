package com.example.asus.quarterofanhourdemo.model.net;

import com.example.asus.quarterofanhourdemo.base.Basebean;
import com.example.asus.quarterofanhourdemo.model.bean.CrosstalkBean;

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

    @FormUrlEncoded
    @POST("quarter/getJokes")
    Observable<Basebean<List<CrosstalkBean>>> getJokes(@Field("page") String  page);

//    //注册
//    @POST("quarter/register")
//    @FormUrlEncoded
//    Observable<HotBean>
//    getRegest(@Field("regType") String regType,
//              @Field("mobile") String  mobile,
//              @Field("password") String password
//    );
}
