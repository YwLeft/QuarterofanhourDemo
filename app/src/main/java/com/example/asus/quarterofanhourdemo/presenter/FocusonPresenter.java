package com.example.asus.quarterofanhourdemo.presenter;

import com.example.asus.quarterofanhourdemo.base.BaseDataPresenter;
import com.example.asus.quarterofanhourdemo.base.Basebean;
import com.example.asus.quarterofanhourdemo.model.bane.GoodsFocusonModes;
import com.example.asus.quarterofanhourdemo.view.iview.FocusonView;

import java.util.Map;

/**
 * 类描述    关注的Presenter层
 */
public class FocusonPresenter extends BaseDataPresenter<FocusonView> {

    private GoodsFocusonModes modes;

    public FocusonPresenter(FocusonView iView) {
        super(iView);
        modes = new GoodsFocusonModes();
    }

    public void getData(Map<String, String> map) {
        modes.getFocusoModes(new GoodsFocusonModes.DataFocuso() {
            @Override
            public void setbutteck(Basebean bean) {
                iView.onGetFocusonSucceed(bean);
            }

            @Override
            public void setfile(String s) {
                iView.onGetFocusonFail(s.toString());
            }
        }, map);

    }
}