package com.bawei.liuqi20191202.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.bawei.liuqi20191202.contract.IContract;

/**
 * author : Eaves
 * desc   : 功能描述
 * date   : 2019/12/2
 */
public abstract class BaseActivity<P extends BasePresenter> extends AppCompatActivity implements IContract.IView {

    protected P mPresenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (provideLayoutID() != 0){
            setContentView(provideLayoutID());
            initView();
            mPresenter = initPresenter();
            if (mPresenter != null) {
                mPresenter.onAttach(this);
            }
            initData();
        }
    }

    protected abstract void initView();

    protected abstract void initData();

    protected abstract P initPresenter();

    protected abstract int provideLayoutID();

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mPresenter != null) {
            mPresenter.onDetach();
            mPresenter = null;
        }
    }
}
