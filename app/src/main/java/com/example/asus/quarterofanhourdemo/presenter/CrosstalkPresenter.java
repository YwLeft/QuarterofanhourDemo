package com.example.asus.quarterofanhourdemo.presenter;

import com.example.asus.quarterofanhourdemo.base.BaseDataPresenter;
import com.example.asus.quarterofanhourdemo.base.Basebean;
import com.example.asus.quarterofanhourdemo.model.bane.GoodsCrosstalkModes;
import com.example.asus.quarterofanhourdemo.model.bean.CrosstalkBean;
import com.example.asus.quarterofanhourdemo.view.iview.CrosstalkView;

import java.util.List;

/**
 * 类描述    段子的Presenter层
 */
public class CrosstalkPresenter extends BaseDataPresenter<CrosstalkView> {

    public GoodsCrosstalkModes modes;

    public CrosstalkPresenter(CrosstalkView iView) {
        super(iView);
        modes = new GoodsCrosstalkModes();
    }

    public void getData(String page) {
        modes.getDataCrosstalk(new GoodsCrosstalkModes.Databack() {


            @Override
            public void setbutteck(Basebean<List<CrosstalkBean>> bean) {

                iView.onGetDataSucceed(bean);

            }

            @Override
            public void setfile(String s) {
                iView.onGetDataFail(s);
            }
        }, page);
    }
}
