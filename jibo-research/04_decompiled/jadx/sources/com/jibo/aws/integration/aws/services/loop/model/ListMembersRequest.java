package com.jibo.aws.integration.aws.services.loop.model;

import com.google.gson.annotations.Expose;
import com.jibo.aws.integration.aws.services.common.model.JiboRequestAbstract;
import com.jibo.aws.integration.util.Commons;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class ListMembersRequest extends JiboRequestAbstract {

    @Expose
    private List<String> statusList;

    @Expose
    private List<String> typeList;

    public ListMembersRequest(List<String> list, List<String> list2) {
        this.statusList = list;
        this.typeList = list2;
    }

    @Override // com.jibo.aws.integration.aws.services.common.model.JiboRequestAbstract
    public String getServiceAbbr() {
        return "loop";
    }

    @Override // com.jibo.aws.integration.aws.services.common.model.JiboRequestAbstract
    public String getServiceMethodName() {
        return "ListLoopMembers";
    }

    @Override // com.jibo.aws.integration.aws.services.common.model.JiboRequestAbstract
    public String getServicePrefix() {
        return Commons.TARGET_PREFIX_LOOP;
    }

    public List<String> getStatusList() {
        return this.statusList;
    }

    public List<String> getTypeList() {
        return this.typeList;
    }

    public void setStatusList(List<String> list) {
        this.statusList = list;
    }

    public void setTypeList(List<String> list) {
        this.typeList = list;
    }
}
