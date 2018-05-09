package com.mvp.ultimate.http;


import com.mvp.ultimate.http.response.GankHttpResponse;
import com.mvp.ultimate.model.bean.GankItemBean;

import java.util.List;


/**
 * @author: Est <codeest.dev@gmail.com>
 * @date: 2017/4/21
 * @description:
 */

public interface HttpHelpers {


    GankHttpResponse<List<GankItemBean>> fetchTechLists();

}
