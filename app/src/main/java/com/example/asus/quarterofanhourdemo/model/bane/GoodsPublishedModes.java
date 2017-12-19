package com.example.asus.quarterofanhourdemo.model.bane;

import com.example.asus.quarterofanhourdemo.base.Basebean;
import com.example.asus.quarterofanhourdemo.model.net.ApiService;
import com.example.asus.quarterofanhourdemo.model.net.MRetrofit;
import com.example.asus.quarterofanhourdemo.model.net.MyApp;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.internal.observers.BlockingBaseObserver;
import io.reactivex.schedulers.Schedulers;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;

/**
 * 类描述    发布段子的mode层
 */
public class GoodsPublishedModes {
    private MRetrofit mRetrofit;


    String content;
    List<File> list;

    private final List<MultipartBody.Part> partList;

    public GoodsPublishedModes(String content, List<File> list) {
        this.content = content;
        this.list = list;

        mRetrofit = MRetrofit.getinstance();
        partList = new ArrayList<>();
        for (File f : list) {
            RequestBody requestBody = RequestBody.create(MediaType.parse("image/*"), f);
            MultipartBody.Part ff = MultipartBody.Part.createFormData("jokeFiles", f.getName(), requestBody);
            partList.add(ff);
        }

    }


    public void getPublishedData(final DataPublished dataPublished) {
        String uid = MyApp.getUserInfoSp().getString("userId", "");
        MultipartBody.Part id = MultipartBody.Part.createFormData("uid", uid);
        MultipartBody.Part con = MultipartBody.Part.createFormData("content", content);


        mRetrofit.create(ApiService.class).getPublished(id, con, partList)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new BlockingBaseObserver<Basebean>() {
                    @Override
                    public void onNext(Basebean responseBody) {
                        dataPublished.setbutteck(responseBody);
                        //System.out.println("responseBody = " + responseBody);
                    }

                    @Override
                    public void onError(Throwable e) {
                        dataPublished.setfile(e.toString());
                        //System.out.println("e = " + e.toString());
                    }
                });
    }

    /**
     * 定义两个接口，一个成功，一个失败
     */
    public interface DataPublished {
        void setbutteck(Basebean bean);

        void setfile(String s);
    }
}
