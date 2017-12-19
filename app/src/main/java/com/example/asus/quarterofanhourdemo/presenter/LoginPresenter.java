package com.example.asus.quarterofanhourdemo.presenter;

import com.example.asus.quarterofanhourdemo.base.BaseDataPresenter;
import com.example.asus.quarterofanhourdemo.base.Basebean;
import com.example.asus.quarterofanhourdemo.model.bane.GoodsLoginModes;
import com.example.asus.quarterofanhourdemo.model.bean.LoginBean;
import com.example.asus.quarterofanhourdemo.view.iview.LoginView;

/**
 * 类描述    登陆的Presenter层
 */
public class LoginPresenter extends BaseDataPresenter<LoginView> {

    public GoodsLoginModes modes;

    public LoginPresenter(LoginView iView) {
        super(iView);
        modes = new GoodsLoginModes();
    }

    public void getData(String mobile,String password) {
        modes.getLoginData(new GoodsLoginModes.DataLigin() {
            @Override
            public void setbutteck(Basebean<LoginBean> bean) {
                iView.onGetLoginSucceed(bean);
            }

            @Override
            public void setfile(String s) {
                iView.onGetLoginFail(s);
            }
        },mobile,password);
    }
}
