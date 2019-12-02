package com.bawei.liuqi20191202.contract;

/**
 * author : Eaves
 * desc   : 功能描述
 * date   : 2019/12/2
 */
public interface IContract {

    interface MVPCallBack{
        void onSuccess(String json);
        void onError(String error);
    }

    interface IModel{
        void doGet(String httpUrl,MVPCallBack mvpCallBack);
    }

    interface IPresenter{
        void startGetRequest(String httpUrl);
    }

    interface IView{
        void onSuccess(String json);
        void onError(String error);
    }
}
