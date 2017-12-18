package com.example.asus.quarterofanhourdemo.presenter;

import com.example.asus.quarterofanhourdemo.base.BaseDataPresenter;
import com.example.asus.quarterofanhourdemo.base.Basebean;
import com.example.asus.quarterofanhourdemo.model.bane.GoodsPersonalDetailsModes;
import com.example.asus.quarterofanhourdemo.model.bean.PersonalDetailsBean;
import com.example.asus.quarterofanhourdemo.view.iview.PersonalDetailsView;

import java.util.List;
import java.util.Map;

/**
 * 创建时间  2017/12/16 9:03
 * 创建人    gaozhijie
 * 类描述    个人详情persenter层
 */
public class PersonalDetailsPresenter extends BaseDataPresenter<PersonalDetailsView> {

    private GoodsPersonalDetailsModes modes;

    public PersonalDetailsPresenter(PersonalDetailsView iView) {
        super(iView);
        modes = new GoodsPersonalDetailsModes();
    }

    public void getData(Map<String, String> map) {
        modes.getDataPersonalDetails(new GoodsPersonalDetailsModes.DataPersonalDetails() {
            @Override
            public void setbutteck(Basebean<List<PersonalDetailsBean>> bean) {
                iView.onGetPersonalDetailsSucceed(bean);
            }

            @Override
            public void setfile(String s) {
                iView.onGetPersonalDetailsFail(s.toString());
            }
        }, map);

    }
}
