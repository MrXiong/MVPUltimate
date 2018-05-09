package com.mvp.ultimate;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.mvp.ultimate.base.BaseActivity;
import com.mvp.ultimate.contract.GirlContract;
import com.mvp.ultimate.model.bean.GankItemBean;
import com.mvp.ultimate.presenter.GirlPresenter;
import com.zhy.adapter.recyclerview.CommonAdapter;
import com.zhy.adapter.recyclerview.base.ViewHolder;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

public class GirlsActivity extends BaseActivity<GirlPresenter> implements GirlContract.View {

    @BindView(R.id.rv_list)
    RecyclerView mRvList;

    private List<GankItemBean> mList = new ArrayList<>();
    private CommonAdapter mCommonAdapter;

    @Override
    protected int getLayout() {
        return R.layout.activity_girls;
    }

    @Override
    protected void initInject() {
        getActivityComponent().inject(this);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initView();
        mPresenter.getGirlData();
    }

    private void initView() {
        mRvList.setLayoutManager(new LinearLayoutManager(this));
        mCommonAdapter = new CommonAdapter<GankItemBean>(mContext, R.layout.listitem_girls, mList) {
            @Override
            protected void convert(ViewHolder holder, GankItemBean bean, int position) {
                holder.setText(R.id.tv_test, bean.getDesc());
            }
        };
        mRvList.setAdapter(mCommonAdapter);
    }

    @Override
    public void showContent(List<GankItemBean> list) {
        mList.clear();
        mList.addAll(list);
        mCommonAdapter.notifyDataSetChanged();
    }
}
