package com.mvp.ultimate.http;


import com.mvp.ultimate.http.api.GankApis;
import com.mvp.ultimate.http.response.GankHttpResponse;
import com.mvp.ultimate.model.bean.GankItemBean;

import java.util.List;

import javax.inject.Inject;


/**
 * Created by codeest on 2016/8/3.
 */
public class RetrofitHelpers implements HttpHelpers {


    @Inject
    public RetrofitHelpers() {
    }
    @Override
    public GankHttpResponse<List<GankItemBean>> fetchTechLists() {
        return null;
    }
}
