package com.ai.slp.balance.api.resquery.param;

import java.io.Serializable;
import java.util.List;

/**
 * 套餐余量查询结果,套餐信息
 *
 * Date: 2015年10月21日 <br>
 * Copyright (c) 2015 asiainfo.com <br>
 * 
 * @author lilg
 */
public class ResPkgInfo implements Serializable {

    /**
     * 产品元素ID
     */
    private long prodElementId;

    /**
     * 套餐内资源列表
     */
    private List<PkgResource> pkgResourceList;

    public long getProdElementId() {
        return prodElementId;
    }

    public void setProdElementId(long prodElementId) {
        this.prodElementId = prodElementId;
    }

    public List<PkgResource> getPkgResourceList() {
        return pkgResourceList;
    }

    public void setPkgResourceList(List<PkgResource> pkgResourceList) {
        this.pkgResourceList = pkgResourceList;
    }

}
