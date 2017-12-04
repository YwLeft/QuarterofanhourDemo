package com.example.asus.quarterofanhourdemo.model.net;

import android.util.Log;

import java.io.IOException;

import okhttp3.FormBody;
import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.Request;

/**
 * 创建时间  2017/11/27 15:47
 * 创建人    gaozhijie
 * 类描述      ok的拦截器
 */
public class LogInterceptor implements Interceptor {

    public static String TAG = "LogInterceptor";

    @Override
    public okhttp3.Response intercept(Chain chain) throws IOException {
        Request request = chain.request();

        HttpUrl url = null;
        try {
            url = request.url()
                    .newBuilder()
                    .addQueryParameter("source", "android")
                    .addQueryParameter("token", MyApp.getUserInfoSp().getString("usertoken",""))
                    .addQueryParameter("appVersion",String.valueOf(VersionUtils.getVersoncode()))
                    .build();
        } catch (Exception e) {
            e.printStackTrace();
        }

        request = request.newBuilder().url(url).build();
        long startTime = System.currentTimeMillis();
        okhttp3.Response response = chain.proceed(request);
        long endTime = System.currentTimeMillis();
        long duration = endTime - startTime;
        okhttp3.MediaType mediaType = response.body().contentType();
        String content = response.body().string();
        Log.d(TAG, "\n");
        Log.d(TAG, "----------Start----------------");
        Log.d(TAG, "| " + request.toString());
        String method = request.method();
        if ("POST".equals(method)) {
            StringBuilder sb = new StringBuilder();
            if (request.body() instanceof FormBody) {
                FormBody body = (FormBody) request.body();
                for (int i = 0; i < body.size(); i++) {
                    sb.append(body.encodedName(i) + "=" + body.encodedValue(i) + ",");
                }
                sb.delete(sb.length() - 1, sb.length());
                Log.d(TAG, "| RequestParams:{" + sb.toString() + "}");
            }
        }
        Log.d(TAG, "| Response:" + content);
        Log.d(TAG, "----------End:" + duration + "毫秒----------");
        return response.newBuilder()
                .body(okhttp3.ResponseBody.create(mediaType, content))
                .build();
    }
}
