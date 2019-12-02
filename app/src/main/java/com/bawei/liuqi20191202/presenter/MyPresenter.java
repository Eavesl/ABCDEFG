package com.bawei.liuqi20191202.presenter;

import com.bawei.liuqi20191202.base.BasePresenter;
import com.bawei.liuqi20191202.contract.IContract;
import com.bawei.liuqi20191202.model.MyModel;

/**
 * author : Eaves
 * desc   : 功能描述
 * date   : 2019/12/2
 */
public class MyPresenter extends BasePresenter {
    @Override
    protected IContract.IModel initModel() {
        return new MyModel();
    }

    @Override
    public void startGetRequest(String httpUrl) {
        mModel.doGet(httpUrl, new IContract.MVPCallBack() {
            @Override
            public void onSuccess(String json) {
                if (getViewInstance() != null) {
                    getViewInstance().onSuccess(json);
                }
            }

            @Override
            public void onError(String error) {
                if (getViewInstance() != null) {
                    getViewInstance().onError(error);
                }
            }
        });

    }
}
