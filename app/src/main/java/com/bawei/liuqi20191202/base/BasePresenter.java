package com.bawei.liuqi20191202.base;

/**
 * author : Eaves
 * desc   : 功能描述
 * date   : 2019/12/2
 */

import com.bawei.liuqi20191202.contract.IContract;

import java.lang.ref.WeakReference;

public abstract class BasePresenter<V extends IContract.IView> implements IContract.IPresenter {

    protected WeakReference<V> mWeak;
    public IContract.IModel mModel;
    public BasePresenter() {
        mModel = initModel();
    }

    protected abstract IContract.IModel initModel();

    protected void onAttach(V v){
        mWeak = new WeakReference<>(v);
    }

    protected V getViewInstance(){
        return mWeak.get();
    }

    protected void onDetach(){
        if (mWeak != null) {
            mWeak.clear();
            mWeak = null;
        }
        if (mModel != null) {
            mModel = null;
        }
    }
}
