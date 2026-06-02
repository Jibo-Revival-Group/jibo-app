package com.jibo.aws.integration.aws.services.robotProperties.model;

import com.jibo.aws.integration.aws.services.common.model.IdRequest;
import com.jibo.aws.integration.util.Commons;

/* JADX INFO: loaded from: classes.dex */
public class GetRobotRequest extends IdRequest {
    public GetRobotRequest(String str) {
        super(str);
    }

    @Override // com.jibo.aws.integration.aws.services.common.model.JiboRequestAbstract
    public String getServiceAbbr() {
        return "robotproperties";
    }

    @Override // com.jibo.aws.integration.aws.services.common.model.JiboRequestAbstract
    public String getServicePrefix() {
        return Commons.TARGET_PREFIX_ROBOT_PROPS;
    }
}
