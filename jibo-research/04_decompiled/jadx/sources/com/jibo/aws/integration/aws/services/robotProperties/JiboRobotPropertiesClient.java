package com.jibo.aws.integration.aws.services.robotProperties;

import com.amazonaws.ClientConfiguration;
import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSCredentialsProvider;
import com.amazonaws.http.HttpClient;
import com.jibo.aws.integration.aws.services.AbstractJiboClient;
import com.jibo.aws.integration.aws.services.common.model.CommandResponse;
import com.jibo.aws.integration.aws.services.common.model.p005a.C0851a;
import com.jibo.aws.integration.aws.services.common.model.p005a.C0853c;
import com.jibo.aws.integration.aws.services.common.model.p005a.C0855e;
import com.jibo.aws.integration.aws.services.robotProperties.model.CreateRobotRequest;
import com.jibo.aws.integration.aws.services.robotProperties.model.GetFriendlyIdsRequest;
import com.jibo.aws.integration.aws.services.robotProperties.model.GetRobotRequest;
import com.jibo.aws.integration.aws.services.robotProperties.model.IdPair;
import com.jibo.aws.integration.aws.services.robotProperties.model.RemoveRobotRequest;
import com.jibo.aws.integration.aws.services.robotProperties.model.Robot;
import com.jibo.aws.integration.aws.services.robotProperties.model.UpdateRobotRequest;
import com.jibo.aws.integration.aws.services.robotProperties.model.p017a.C0969a;
import com.jibo.aws.integration.aws.services.robotProperties.model.p017a.C0970b;
import com.jibo.aws.integration.util.C0977a;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class JiboRobotPropertiesClient extends AbstractJiboClient {
    public static final String TAG = C0977a.m10070a(JiboRobotPropertiesClient.class);

    public JiboRobotPropertiesClient(AWSCredentials aWSCredentials) {
        super(aWSCredentials);
    }

    public JiboRobotPropertiesClient(AWSCredentials aWSCredentials, ClientConfiguration clientConfiguration) {
        super(aWSCredentials, clientConfiguration);
    }

    public JiboRobotPropertiesClient(AWSCredentialsProvider aWSCredentialsProvider) {
        super(aWSCredentialsProvider);
    }

    public JiboRobotPropertiesClient(AWSCredentialsProvider aWSCredentialsProvider, ClientConfiguration clientConfiguration) {
        super(aWSCredentialsProvider, clientConfiguration);
    }

    public JiboRobotPropertiesClient(AWSCredentialsProvider aWSCredentialsProvider, ClientConfiguration clientConfiguration, HttpClient httpClient) {
        super(aWSCredentialsProvider, clientConfiguration, httpClient);
    }

    public CommandResponse createRobot(Robot robot) {
        return (CommandResponse) m9913a(new CreateRobotRequest(robot), (C0855e) null, new C0851a()).getAwsResponse();
    }

    public List<IdPair> getFriendlyIds(int i) {
        return (List) m9913a(new GetFriendlyIdsRequest(i), (C0855e) null, new C0969a()).getAwsResponse();
    }

    public Robot getRobot(String str) {
        return (Robot) m9913a(new GetRobotRequest(str), new C0853c(), new C0970b()).getAwsResponse();
    }

    public CommandResponse removeRobot(String str) {
        return (CommandResponse) m9913a(new RemoveRobotRequest(str), new C0853c(), new C0851a()).getAwsResponse();
    }

    public CommandResponse updateRobot(Robot robot) {
        return (CommandResponse) m9913a(new UpdateRobotRequest(robot), (C0855e) null, new C0851a()).getAwsResponse();
    }
}
