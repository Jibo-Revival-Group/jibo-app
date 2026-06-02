package com.jibo.aws.integration.aws.services.robotProperties;

import com.amazonaws.ClientConfiguration;
import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSCredentialsProvider;
import com.amazonaws.handlers.AsyncHandler;
import com.jibo.aws.integration.aws.services.AbstractJiboAsyncClient;
import com.jibo.aws.integration.aws.services.common.model.CommandResponse;
import com.jibo.aws.integration.aws.services.robotProperties.model.CreateRobotRequest;
import com.jibo.aws.integration.aws.services.robotProperties.model.GetFriendlyIdsRequest;
import com.jibo.aws.integration.aws.services.robotProperties.model.GetRobotRequest;
import com.jibo.aws.integration.aws.services.robotProperties.model.IdPair;
import com.jibo.aws.integration.aws.services.robotProperties.model.RemoveRobotRequest;
import com.jibo.aws.integration.aws.services.robotProperties.model.Robot;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;

/* JADX INFO: loaded from: classes.dex */
public class JiboRobotPropertiesAsyncClient extends AbstractJiboAsyncClient {
    public JiboRobotPropertiesAsyncClient(AWSCredentials aWSCredentials) {
        super(aWSCredentials);
    }

    public JiboRobotPropertiesAsyncClient(AWSCredentials aWSCredentials, ClientConfiguration clientConfiguration) {
        super(aWSCredentials, clientConfiguration);
    }

    public JiboRobotPropertiesAsyncClient(AWSCredentialsProvider aWSCredentialsProvider) {
        super(aWSCredentialsProvider);
    }

    public JiboRobotPropertiesAsyncClient(AWSCredentialsProvider aWSCredentialsProvider, ClientConfiguration clientConfiguration) {
        super(aWSCredentialsProvider, clientConfiguration);
    }

    public CommandResponse createRobot(Robot robot) {
        return m17207getJiboClient().createRobot(robot);
    }

    public Future<CommandResponse> createRobot(final Robot robot, final AsyncHandler<CreateRobotRequest, CommandResponse> asyncHandler) {
        return m9909c().submit(new Callable<CommandResponse>() { // from class: com.jibo.aws.integration.aws.services.robotProperties.JiboRobotPropertiesAsyncClient.2
            @Override // java.util.concurrent.Callable
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public CommandResponse call() throws Exception {
                try {
                    CommandResponse commandResponseCreateRobot = JiboRobotPropertiesAsyncClient.this.createRobot(robot);
                    if (asyncHandler != null) {
                        asyncHandler.onSuccess(new CreateRobotRequest(robot), commandResponseCreateRobot);
                    }
                    return commandResponseCreateRobot;
                } catch (Exception e) {
                    if (asyncHandler != null) {
                        asyncHandler.onError(e);
                    }
                    throw e;
                }
            }
        });
    }

    public List<IdPair> getFriendlyIds(int i) {
        return m17207getJiboClient().getFriendlyIds(i);
    }

    public Future<List<IdPair>> getFriendlyIds(final int i, final AsyncHandler<GetFriendlyIdsRequest, List<IdPair>> asyncHandler) {
        return m9909c().submit(new Callable<List<IdPair>>() { // from class: com.jibo.aws.integration.aws.services.robotProperties.JiboRobotPropertiesAsyncClient.1
            @Override // java.util.concurrent.Callable
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public List<IdPair> call() throws Exception {
                try {
                    List<IdPair> friendlyIds = JiboRobotPropertiesAsyncClient.this.getFriendlyIds(i);
                    if (asyncHandler != null) {
                        asyncHandler.onSuccess(new GetFriendlyIdsRequest(i), friendlyIds);
                    }
                    return friendlyIds;
                } catch (Exception e) {
                    if (asyncHandler != null) {
                        asyncHandler.onError(e);
                    }
                    throw e;
                }
            }
        });
    }

    @Override // com.jibo.aws.integration.aws.services.AbstractJiboAsyncClient
    /* JADX INFO: renamed from: getJiboClient, reason: merged with bridge method [inline-methods] */
    public JiboRobotPropertiesClient m17215getJiboClient() {
        return (JiboRobotPropertiesClient) super.m17207getJiboClient();
    }

    public Robot getRobot(String str) {
        return m17207getJiboClient().getRobot(str);
    }

    public Future<Robot> getRobot(final String str, final AsyncHandler<GetRobotRequest, Robot> asyncHandler) {
        return m9909c().submit(new Callable<Robot>() { // from class: com.jibo.aws.integration.aws.services.robotProperties.JiboRobotPropertiesAsyncClient.4
            @Override // java.util.concurrent.Callable
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public Robot call() throws Exception {
                try {
                    Robot robot = JiboRobotPropertiesAsyncClient.this.getRobot(str);
                    if (asyncHandler != null) {
                        asyncHandler.onSuccess(new GetRobotRequest(str), robot);
                    }
                    return robot;
                } catch (Exception e) {
                    if (asyncHandler != null) {
                        asyncHandler.onError(e);
                    }
                    throw e;
                }
            }
        });
    }

    public CommandResponse removeRobot(String str) {
        return m17207getJiboClient().removeRobot(str);
    }

    public Future<CommandResponse> removeRobot(final String str, final AsyncHandler<RemoveRobotRequest, CommandResponse> asyncHandler) {
        return m9909c().submit(new Callable<CommandResponse>() { // from class: com.jibo.aws.integration.aws.services.robotProperties.JiboRobotPropertiesAsyncClient.5
            @Override // java.util.concurrent.Callable
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public CommandResponse call() throws Exception {
                try {
                    CommandResponse commandResponseRemoveRobot = JiboRobotPropertiesAsyncClient.this.removeRobot(str);
                    if (asyncHandler != null) {
                        asyncHandler.onSuccess(new RemoveRobotRequest(str), commandResponseRemoveRobot);
                    }
                    return commandResponseRemoveRobot;
                } catch (Exception e) {
                    if (asyncHandler != null) {
                        asyncHandler.onError(e);
                    }
                    throw e;
                }
            }
        });
    }

    public CommandResponse updateRobot(Robot robot) {
        return m17207getJiboClient().updateRobot(robot);
    }

    public Future<CommandResponse> updateRobot(final Robot robot, final AsyncHandler<CreateRobotRequest, CommandResponse> asyncHandler) {
        return m9909c().submit(new Callable<CommandResponse>() { // from class: com.jibo.aws.integration.aws.services.robotProperties.JiboRobotPropertiesAsyncClient.3
            @Override // java.util.concurrent.Callable
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public CommandResponse call() throws Exception {
                try {
                    CommandResponse commandResponseUpdateRobot = JiboRobotPropertiesAsyncClient.this.updateRobot(robot);
                    if (asyncHandler != null) {
                        asyncHandler.onSuccess(new CreateRobotRequest(robot), commandResponseUpdateRobot);
                    }
                    return commandResponseUpdateRobot;
                } catch (Exception e) {
                    if (asyncHandler != null) {
                        asyncHandler.onError(e);
                    }
                    throw e;
                }
            }
        });
    }
}
