package com.example.asus.quarterofanhourdemo.model.bane;

import com.example.asus.quarterofanhourdemo.base.Basebean;
import com.example.asus.quarterofanhourdemo.model.net.ApiService;
import com.example.asus.quarterofanhourdemo.model.net.MRetrofit;

import java.io.File;
import java.util.Map;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.internal.observers.BlockingBaseObserver;
import io.reactivex.schedulers.Schedulers;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;

/**
 * 创建时间  2017/11/29 9:56
 * 创建人    gaozhijie
 * 类描述    发布段子的mode层
 */
public class GoodsPublishedModes {
    private MRetrofit mRetrofit;
    private MultipartBody.Part body;
    private RequestBody requestFile;
    private File file;


    public GoodsPublishedModes() {
        mRetrofit = MRetrofit.getinstance();
    }


    public void getPublishedData(final DataPublished dataPublished, Map<String,String> map) {

     /* //  MultipartBody.Builder builders = new MultipartBody.Builder();
        String uid = MyApp.getUserInfoSp().getString("userId", "");
        System.out.println("++++++++++++++++++++++++" + uid);
        for (LocalMedia localMedia : list) {
            file = new File(localMedia.getPath());
        }
String content, List<LocalMedia> list
       // requestFile = RequestBody.create(MediaType.parse("application/octet-stream"), file);
        RequestBody photobody = RequestBody.create(MediaType.parse("application/octet-stream"), file);
        MultipartBody.Part photo = MultipartBody.Part.createFormData("jokeFiles",file.getName(), photobody);
*/
        mRetrofit.create(ApiService.class).getPublished(map)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new BlockingBaseObserver<ResponseBody>() {
                    @Override
                    public void onNext(ResponseBody responseBody) {
                        System.out.println("responseBody = " + responseBody);
                    }

                    @Override
                    public void onError(Throwable e) {
                        System.out.println("e = " + e.toString());
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
