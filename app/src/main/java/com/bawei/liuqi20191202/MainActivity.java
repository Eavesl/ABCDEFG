package com.bawei.liuqi20191202;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.bawei.liuqi20191202.base.BaseActivity;
import com.bawei.liuqi20191202.base.BasePresenter;
import com.bawei.liuqi20191202.presenter.MyPresenter;

public class MainActivity extends BaseActivity {


    private TextView mTextView;

    @Override
    protected void initView() {

        mTextView = findViewById(R.id.tv);

    }

    @Override
    protected void initData() {


        mPresenter.startGetRequest("http://172.17.8.100/small/commodity/v1/bannerShow");

    }

    @Override
    protected BasePresenter initPresenter() {
        return new MyPresenter();
    }

    @Override
    protected int provideLayoutID() {
        return R.layout.activity_main;
    }

    @Override
    public void onSuccess(String json) {

        mTextView.setText(json);
    }

    @Override
    public void onError(String error) {

    }
}
