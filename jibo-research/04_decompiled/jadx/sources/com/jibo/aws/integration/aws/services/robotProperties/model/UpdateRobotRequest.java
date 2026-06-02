package com.jibo.aws.integration.aws.services.robotProperties.model;

import com.google.gson.JsonObject;

/* JADX INFO: loaded from: classes.dex */
public class UpdateRobotRequest extends RobotRequest {
    public UpdateRobotRequest(Robot robot) {
        super(robot);
    }

    public UpdateRobotRequest(String str, String str2, JsonObject jsonObject, long j, long j2) {
        super(str, str2, jsonObject, j, j2);
    }
}
