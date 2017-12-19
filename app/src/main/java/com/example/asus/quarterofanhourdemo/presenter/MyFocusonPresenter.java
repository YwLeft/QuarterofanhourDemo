package com.example.asus.quarterofanhourdemo.presenter;

import com.example.asus.quarterofanhourdemo.base.BaseDataPresenter;
import com.example.asus.quarterofanhourdemo.base.Basebean;
import com.example.asus.quarterofanhourdemo.model.bane.GoodsMyFocusonModes;
import com.example.asus.quarterofanhourdemo.model.bean.MyFocusonBean;
import com.example.asus.quarterofanhourdemo.view.iview.MyFocusonView;

import java.util.List;

/**
 * 类描述    我的关注的Presenter层
 */
public class MyFocusonPresenter extends BaseDataPresenter<MyFocusonView> {

    public GoodsMyFocusonModes modes;

    public MyFocusonPresenter(MyFocusonView iView) {
        super(iView);
        modes = new GoodsMyFocusonModes();
    }

    public void getData(String uid) {
        modes.getFocuson(new GoodsMyFocusonModes.DataFocuson() {
            @Override
            public void setbutteck(Basebean<List<MyFocusonBean>> bean) {
                iView.onGetMyFocusonSucceed(bean);
            }

            @Override
            public void setfile(String s) {
                iView.onGetMyFocusonFail(s.toString());
            }
        }, uid);
    }
}
