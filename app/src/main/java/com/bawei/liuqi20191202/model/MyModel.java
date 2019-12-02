package com.bawei.liuqi20191202.model;

import com.bawei.liuqi20191202.contract.IContract;
import com.bawei.liuqi20191202.net.VolleyUtils;

/**
 * author : Eaves
 * desc   : 功能描述
 * date   : 2019/12/2
 */
public class MyModel implements IContract.IModel {
    @Override
    public void doGet(String httpUrl, final IContract.MVPCallBack mvpCallBack) {
        VolleyUtils.getInstance().doGet(httpUrl, new VolleyUtils.VolleyCallBack() {
            @Override
            public void onSuccess(String json) {
                mvpCallBack.onSuccess(json);
            }

            @Override
            public void onError(String error) {
                mvpCallBack.onError(error);
            }
        });
    }
}
