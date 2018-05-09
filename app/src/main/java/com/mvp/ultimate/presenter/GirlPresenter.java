package com.mvp.ultimate.presenter;

import android.support.v7.widget.LinearLayoutManager;

import com.mvp.ultimate.R;
import com.mvp.ultimate.base.BaseView;
import com.mvp.ultimate.base.RxPresenter;
import com.mvp.ultimate.contract.GirlContract;
import com.mvp.ultimate.model.bean.GankItemBean;
import com.zhy.adapter.recyclerview.CommonAdapter;
import com.zhy.adapter.recyclerview.base.ViewHolder;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

/**
 * Created by ZX on 2018/5/8.
 */

public class GirlPresenter extends RxPresenter<GirlContract.View> implements GirlContract.Presenter {

    @Inject
    public GirlPresenter() {
    }

    @Override
    public void getGirlData() {
        List<GankItemBean> list = new ArrayList<>();
        for (int i = 0; i < 50; i++) {
            GankItemBean bean = new GankItemBean();
            bean.setDesc("测量描述数据" + i);
            list.add(bean);
        }


        mView.showContent(list);

    }

    @Override
    public void getMoreGirlData() {
    }
}
