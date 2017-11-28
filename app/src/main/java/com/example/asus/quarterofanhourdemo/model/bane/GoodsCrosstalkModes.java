package com.example.asus.quarterofanhourdemo.model.bane;

import com.example.asus.quarterofanhourdemo.model.bean.CrosstalkBean;
import com.example.asus.quarterofanhourdemo.model.net.MyApp;
import com.example.asus.quarterofanhourdemo.model.net.NetDataCallBack;
import com.example.asus.quarterofanhourdemo.model.net.OkHttpClick;
import com.example.asus.quarterofanhourdemo.urls.URL;

/**
 * 创建时间  2017/11/27 14:56
 * 创建人    gaozhijie
 * 类描述     段子的mode层
 */
public class GoodsCrosstalkModes {

    public OkHttpClick okHttpClick;

    public GoodsCrosstalkModes() {
        this.okHttpClick = MyApp.getOkHttpClick();
    }


    public void getDataCrosstalk(final Databack databack){
        okHttpClick.getdata(URL.CROSSTALK_URl, new NetDataCallBack() {
            @Override
            public void success(Object o) {
                CrosstalkBean bean= (CrosstalkBean) o;
                databack.setbutteck(bean);
            }

            @Override
            public void faild(int positon, String str) {
                databack.setfile(str.toString());
            }
        },CrosstalkBean.class);

    }

    /**
     * 定义两个接口，一个成功，一个失败
     */
    public interface Databack{
        void setbutteck(CrosstalkBean bean);
        void setfile(String s);
    }
}
