package com.jibo.aws.integration.aws.services.loop;

import com.amazonaws.ClientConfiguration;
import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSCredentialsProvider;
import com.amazonaws.handlers.AsyncHandler;
import com.jibo.aws.integration.aws.services.AbstractJiboAsyncClient;
import com.jibo.aws.integration.aws.services.account.model.Account;
import com.jibo.aws.integration.aws.services.common.model.CommandResponse;
import com.jibo.aws.integration.aws.services.loop.model.AcceptLoopInvitationRequest;
import com.jibo.aws.integration.aws.services.loop.model.CreateRequest;
import com.jibo.aws.integration.aws.services.loop.model.DeclineLoopInvitationRequest;
import com.jibo.aws.integration.aws.services.loop.model.GetRobotRequest;
import com.jibo.aws.integration.aws.services.loop.model.InviteMemberRequest;
import com.jibo.aws.integration.aws.services.loop.model.ListMembersRequest;
import com.jibo.aws.integration.aws.services.loop.model.ListOwnerRobotsRequest;
import com.jibo.aws.integration.aws.services.loop.model.ListRequest;
import com.jibo.aws.integration.aws.services.loop.model.Loop;
import com.jibo.aws.integration.aws.services.loop.model.Member;
import com.jibo.aws.integration.aws.services.loop.model.RemoveMemberPhotoRequest;
import com.jibo.aws.integration.aws.services.loop.model.RemoveMemberRequest;
import com.jibo.aws.integration.aws.services.loop.model.RemoveRequest;
import com.jibo.aws.integration.aws.services.loop.model.Robot;
import com.jibo.aws.integration.aws.services.loop.model.RobotAccount;
import com.jibo.aws.integration.aws.services.loop.model.SetLegalGuardianRequest;
import com.jibo.aws.integration.aws.services.loop.model.SuspendLoopRequest;
import com.jibo.aws.integration.aws.services.loop.model.UpdateMemberPhotoRequest;
import com.jibo.aws.integration.aws.services.loop.model.UpdateMemberRequest;
import com.jibo.aws.integration.aws.services.loop.model.UpdateNicknameRequest;
import com.jibo.aws.integration.aws.services.loop.model.UpdatePhoneticNameRequest;
import com.jibo.aws.integration.aws.services.loop.model.UpdateRequest;
import java.io.File;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;

/* JADX INFO: loaded from: classes.dex */
public class JiboLoopAsyncClient extends AbstractJiboAsyncClient {
    public JiboLoopAsyncClient(AWSCredentials aWSCredentials) {
        super(aWSCredentials);
    }

    public JiboLoopAsyncClient(AWSCredentials aWSCredentials, ClientConfiguration clientConfiguration) {
        super(aWSCredentials, clientConfiguration);
    }

    public JiboLoopAsyncClient(AWSCredentialsProvider aWSCredentialsProvider) {
        super(aWSCredentialsProvider);
    }

    public JiboLoopAsyncClient(AWSCredentialsProvider aWSCredentialsProvider, ClientConfiguration clientConfiguration) {
        super(aWSCredentialsProvider, clientConfiguration);
    }

    public Loop acceptInvitation(String str) {
        return m17211getJiboClient().acceptInvitation(str);
    }

    public Future<Loop> acceptInvitation(final String str, final AsyncHandler<AcceptLoopInvitationRequest, Loop> asyncHandler) {
        return m9909c().submit(new Callable<Loop>() { // from class: com.jibo.aws.integration.aws.services.loop.JiboLoopAsyncClient.11
            @Override // java.util.concurrent.Callable
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public Loop call() throws Exception {
                try {
                    Loop loopAcceptInvitation = JiboLoopAsyncClient.this.acceptInvitation(str);
                    if (asyncHandler != null) {
                        asyncHandler.onSuccess(new AcceptLoopInvitationRequest(str), loopAcceptInvitation);
                    }
                    return loopAcceptInvitation;
                } catch (Exception e) {
                    if (asyncHandler != null) {
                        asyncHandler.onError(e);
                    }
                    throw e;
                }
            }
        });
    }

    public Loop createLoop(String str, String str2) {
        return m17211getJiboClient().createLoop(str, str2);
    }

    public Future<Loop> createLoop(final String str, final String str2, final AsyncHandler<CreateRequest, Loop> asyncHandler) {
        return m9909c().submit(new Callable<Loop>() { // from class: com.jibo.aws.integration.aws.services.loop.JiboLoopAsyncClient.17
            @Override // java.util.concurrent.Callable
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public Loop call() throws Exception {
                try {
                    Loop loopCreateLoop = JiboLoopAsyncClient.this.createLoop(str, str2);
                    if (asyncHandler != null) {
                        asyncHandler.onSuccess(new CreateRequest(str, str2), loopCreateLoop);
                    }
                    return loopCreateLoop;
                } catch (Exception e) {
                    if (asyncHandler != null) {
                        asyncHandler.onError(e);
                    }
                    throw e;
                }
            }
        });
    }

    public Loop declineInvitation(String str) {
        return m17211getJiboClient().declineInvitation(str);
    }

    public Future<Loop> declineInvitation(final String str, final AsyncHandler<DeclineLoopInvitationRequest, Loop> asyncHandler) {
        return m9909c().submit(new Callable<Loop>() { // from class: com.jibo.aws.integration.aws.services.loop.JiboLoopAsyncClient.12
            @Override // java.util.concurrent.Callable
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public Loop call() throws Exception {
                try {
                    Loop loopDeclineInvitation = JiboLoopAsyncClient.this.declineInvitation(str);
                    if (asyncHandler != null) {
                        asyncHandler.onSuccess(new DeclineLoopInvitationRequest(str), loopDeclineInvitation);
                    }
                    return loopDeclineInvitation;
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
    public JiboLoopClient m17209getJiboClient() {
        return (JiboLoopClient) super.m17211getJiboClient();
    }

    public RobotAccount getRobot(String str) {
        return m17211getJiboClient().getRobot(str);
    }

    public Future<RobotAccount> getRobot(final String str, final AsyncHandler<GetRobotRequest, RobotAccount> asyncHandler) {
        return m9909c().submit(new Callable<RobotAccount>() { // from class: com.jibo.aws.integration.aws.services.loop.JiboLoopAsyncClient.9
            @Override // java.util.concurrent.Callable
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public RobotAccount call() throws Exception {
                try {
                    RobotAccount robot = JiboLoopAsyncClient.this.getRobot(str);
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

    public Loop inviteMember(String str, String str2, String str3, String str4, Account.Gender gender, Long l, Boolean bool, Boolean bool2) {
        return m17211getJiboClient().inviteMember(str, str2, str3, str4, gender, l, bool, bool2);
    }

    public Future<Loop> inviteMember(final String str, final String str2, final String str3, final String str4, final Account.Gender gender, final Long l, final Boolean bool, final Boolean bool2, final AsyncHandler<InviteMemberRequest, Loop> asyncHandler) {
        return m9909c().submit(new Callable<Loop>() { // from class: com.jibo.aws.integration.aws.services.loop.JiboLoopAsyncClient.1
            @Override // java.util.concurrent.Callable
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public Loop call() throws Exception {
                try {
                    Loop loopInviteMember = JiboLoopAsyncClient.this.inviteMember(str, str2, str3, str4, gender, l, bool, bool2);
                    if (asyncHandler != null) {
                        asyncHandler.onSuccess(new InviteMemberRequest(str, str2, str3, str4, gender, l, bool, bool2), loopInviteMember);
                    }
                    return loopInviteMember;
                } catch (Exception e) {
                    if (asyncHandler != null) {
                        asyncHandler.onError(e);
                    }
                    throw e;
                }
            }
        });
    }

    public List<Loop> listLoops() {
        return m17211getJiboClient().listLoops();
    }

    public Future<List<Loop>> listLoops(final AsyncHandler<ListRequest, List<Loop>> asyncHandler) {
        return m9909c().submit(new Callable<List<Loop>>() { // from class: com.jibo.aws.integration.aws.services.loop.JiboLoopAsyncClient.18
            @Override // java.util.concurrent.Callable
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public List<Loop> call() throws Exception {
                try {
                    List<Loop> listListLoops = JiboLoopAsyncClient.this.listLoops();
                    if (asyncHandler != null) {
                        asyncHandler.onSuccess(new ListRequest(), listListLoops);
                    }
                    return listListLoops;
                } catch (Exception e) {
                    if (asyncHandler != null) {
                        asyncHandler.onError(e);
                    }
                    throw e;
                }
            }
        });
    }

    public List<Member> listMembers(List<String> list, List<String> list2) {
        return m17211getJiboClient().listMembers(list, list2);
    }

    public Future<List<Member>> listMembers(final List<String> list, final List<String> list2, final AsyncHandler<ListMembersRequest, List<Member>> asyncHandler) {
        return m9909c().submit(new Callable<List<Member>>() { // from class: com.jibo.aws.integration.aws.services.loop.JiboLoopAsyncClient.13
            @Override // java.util.concurrent.Callable
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public List<Member> call() throws Exception {
                try {
                    List<Member> listListMembers = JiboLoopAsyncClient.this.listMembers(list, list2);
                    if (asyncHandler != null) {
                        asyncHandler.onSuccess(new ListMembersRequest(list, list2), listListMembers);
                    }
                    return listListMembers;
                } catch (Exception e) {
                    if (asyncHandler != null) {
                        asyncHandler.onError(e);
                    }
                    throw e;
                }
            }
        });
    }

    public List<Robot> listOwnerRobots(String str) {
        return m17211getJiboClient().listOwnerRobots(str);
    }

    public Future<List<Robot>> listOwnerRobots(final String str, final AsyncHandler<ListOwnerRobotsRequest, List<Robot>> asyncHandler) {
        return m9909c().submit(new Callable<List<Robot>>() { // from class: com.jibo.aws.integration.aws.services.loop.JiboLoopAsyncClient.16
            @Override // java.util.concurrent.Callable
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public List<Robot> call() throws Exception {
                try {
                    List<Robot> listListOwnerRobots = JiboLoopAsyncClient.this.listOwnerRobots(str);
                    if (asyncHandler != null) {
                        asyncHandler.onSuccess(new ListOwnerRobotsRequest(str), listListOwnerRobots);
                    }
                    return listListOwnerRobots;
                } catch (Exception e) {
                    if (asyncHandler != null) {
                        asyncHandler.onError(e);
                    }
                    throw e;
                }
            }
        });
    }

    public Loop removeLoop(String str) {
        return m17211getJiboClient().removeLoop(str);
    }

    public Future<Loop> removeLoop(final String str, final AsyncHandler<RemoveRequest, Loop> asyncHandler) {
        return m9909c().submit(new Callable<Loop>() { // from class: com.jibo.aws.integration.aws.services.loop.JiboLoopAsyncClient.2
            @Override // java.util.concurrent.Callable
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public Loop call() throws Exception {
                try {
                    Loop loopRemoveLoop = JiboLoopAsyncClient.this.removeLoop(str);
                    if (asyncHandler != null) {
                        asyncHandler.onSuccess(new RemoveRequest(str), loopRemoveLoop);
                    }
                    return loopRemoveLoop;
                } catch (Exception e) {
                    if (asyncHandler != null) {
                        asyncHandler.onError(e);
                    }
                    throw e;
                }
            }
        });
    }

    public Loop removeMember(String str, String str2) {
        return m17211getJiboClient().removeMember(str, str2);
    }

    public Future<Loop> removeMember(final String str, final String str2, final AsyncHandler<RemoveMemberRequest, Loop> asyncHandler) {
        return m9909c().submit(new Callable<Loop>() { // from class: com.jibo.aws.integration.aws.services.loop.JiboLoopAsyncClient.14
            @Override // java.util.concurrent.Callable
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public Loop call() throws Exception {
                try {
                    Loop loopRemoveMember = JiboLoopAsyncClient.this.removeMember(str, str2);
                    if (asyncHandler != null) {
                        asyncHandler.onSuccess(new RemoveMemberRequest(str, str2), loopRemoveMember);
                    }
                    return loopRemoveMember;
                } catch (Exception e) {
                    if (asyncHandler != null) {
                        asyncHandler.onError(e);
                    }
                    throw e;
                }
            }
        });
    }

    public Loop removeMemberPhoto(String str, String str2) {
        return m17211getJiboClient().removeMemberPhoto(str, str2);
    }

    public Future<Loop> removeMemberPhoto(final String str, final String str2, final AsyncHandler<RemoveMemberPhotoRequest, Loop> asyncHandler) {
        return m9909c().submit(new Callable<Loop>() { // from class: com.jibo.aws.integration.aws.services.loop.JiboLoopAsyncClient.8
            @Override // java.util.concurrent.Callable
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public Loop call() throws Exception {
                try {
                    Loop loopRemoveMemberPhoto = JiboLoopAsyncClient.this.removeMemberPhoto(str, str2);
                    if (asyncHandler != null) {
                        asyncHandler.onSuccess(new RemoveMemberPhotoRequest(str, str2), loopRemoveMemberPhoto);
                    }
                    return loopRemoveMemberPhoto;
                } catch (Exception e) {
                    if (asyncHandler != null) {
                        asyncHandler.onError(e);
                    }
                    throw e;
                }
            }
        });
    }

    public CommandResponse setLegalGuardian(String str, String str2, String str3) {
        return m17211getJiboClient().setLegalGuardian(str, str2, str3);
    }

    public Future<CommandResponse> setLegalGuardian(final String str, final String str2, final String str3, final AsyncHandler<SetLegalGuardianRequest, CommandResponse> asyncHandler) {
        return m9909c().submit(new Callable<CommandResponse>() { // from class: com.jibo.aws.integration.aws.services.loop.JiboLoopAsyncClient.3
            @Override // java.util.concurrent.Callable
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public CommandResponse call() throws Exception {
                try {
                    CommandResponse legalGuardian = JiboLoopAsyncClient.this.setLegalGuardian(str, str2, str3);
                    if (asyncHandler != null) {
                        asyncHandler.onSuccess(new SetLegalGuardianRequest(str, str2, str3), legalGuardian);
                    }
                    return legalGuardian;
                } catch (Exception e) {
                    if (asyncHandler != null) {
                        asyncHandler.onError(e);
                    }
                    throw e;
                }
            }
        });
    }

    public CommandResponse suspendLoop(String str) {
        return m17211getJiboClient().suspendLoop(str);
    }

    public Future<CommandResponse> suspendLoop(final String str, final AsyncHandler<SuspendLoopRequest, CommandResponse> asyncHandler) {
        return m9909c().submit(new Callable<CommandResponse>() { // from class: com.jibo.aws.integration.aws.services.loop.JiboLoopAsyncClient.10
            @Override // java.util.concurrent.Callable
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public CommandResponse call() throws Exception {
                try {
                    CommandResponse commandResponseSuspendLoop = JiboLoopAsyncClient.this.suspendLoop(str);
                    if (asyncHandler != null) {
                        asyncHandler.onSuccess(new SuspendLoopRequest(str), commandResponseSuspendLoop);
                    }
                    return commandResponseSuspendLoop;
                } catch (Exception e) {
                    if (asyncHandler != null) {
                        asyncHandler.onError(e);
                    }
                    throw e;
                }
            }
        });
    }

    public CommandResponse updateLoop(String str, String str2) {
        return m17211getJiboClient().updateLoop(str, str2);
    }

    public Future<CommandResponse> updateLoop(final String str, final String str2, final AsyncHandler<UpdateRequest, CommandResponse> asyncHandler) {
        return m9909c().submit(new Callable<CommandResponse>() { // from class: com.jibo.aws.integration.aws.services.loop.JiboLoopAsyncClient.15
            @Override // java.util.concurrent.Callable
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public CommandResponse call() throws Exception {
                try {
                    CommandResponse commandResponseUpdateLoop = JiboLoopAsyncClient.this.updateLoop(str, str2);
                    if (asyncHandler != null) {
                        asyncHandler.onSuccess(new UpdateRequest(str, str2), commandResponseUpdateLoop);
                    }
                    return commandResponseUpdateLoop;
                } catch (Exception e) {
                    if (asyncHandler != null) {
                        asyncHandler.onError(e);
                    }
                    throw e;
                }
            }
        });
    }

    public Loop updateMember(String str, String str2, String str3, String str4, String str5, Account.Gender gender, Long l, Boolean bool) {
        return m17211getJiboClient().updateMember(str, str2, str3, str4, str5, gender, l, bool);
    }

    public Future<Loop> updateMember(final String str, final String str2, final String str3, final String str4, final String str5, final Account.Gender gender, final Long l, final Boolean bool, final AsyncHandler<UpdateMemberRequest, Loop> asyncHandler) {
        return m9909c().submit(new Callable<Loop>() { // from class: com.jibo.aws.integration.aws.services.loop.JiboLoopAsyncClient.6
            @Override // java.util.concurrent.Callable
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public Loop call() throws Exception {
                try {
                    Loop loopUpdateMember = JiboLoopAsyncClient.this.updateMember(str, str2, str3, str4, str5, gender, l, bool);
                    if (asyncHandler != null) {
                        asyncHandler.onSuccess(new UpdateMemberRequest(str, str2, str3, str4, str5, gender, l, bool), loopUpdateMember);
                    }
                    return loopUpdateMember;
                } catch (Exception e) {
                    if (asyncHandler != null) {
                        asyncHandler.onError(e);
                    }
                    throw e;
                }
            }
        });
    }

    public Loop updateMemberPhoto(String str, String str2, File file) {
        return m17211getJiboClient().updateMemberPhoto(str, str2, file);
    }

    public Future<Loop> updateMemberPhoto(final String str, final String str2, final File file, final AsyncHandler<UpdateMemberPhotoRequest, Loop> asyncHandler) {
        return m9909c().submit(new Callable<Loop>() { // from class: com.jibo.aws.integration.aws.services.loop.JiboLoopAsyncClient.7
            @Override // java.util.concurrent.Callable
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public Loop call() throws Exception {
                try {
                    Loop loopUpdateMemberPhoto = JiboLoopAsyncClient.this.updateMemberPhoto(str, str2, file);
                    if (asyncHandler != null) {
                        asyncHandler.onSuccess(new UpdateMemberPhotoRequest(str, str2, file, null), loopUpdateMemberPhoto);
                    }
                    return loopUpdateMemberPhoto;
                } catch (Exception e) {
                    if (asyncHandler != null) {
                        asyncHandler.onError(e);
                    }
                    throw e;
                }
            }
        });
    }

    public CommandResponse updateNickname(String str, String str2, String str3) {
        return m17211getJiboClient().updateNickname(str, str2, str3);
    }

    public Future<CommandResponse> updateNickname(final String str, final String str2, final String str3, final AsyncHandler<UpdateNicknameRequest, CommandResponse> asyncHandler) {
        return m9909c().submit(new Callable<CommandResponse>() { // from class: com.jibo.aws.integration.aws.services.loop.JiboLoopAsyncClient.4
            @Override // java.util.concurrent.Callable
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public CommandResponse call() throws Exception {
                try {
                    CommandResponse commandResponseUpdateNickname = JiboLoopAsyncClient.this.updateNickname(str, str2, str3);
                    if (asyncHandler != null) {
                        asyncHandler.onSuccess(new UpdateNicknameRequest(str, str2, str3), commandResponseUpdateNickname);
                    }
                    return commandResponseUpdateNickname;
                } catch (Exception e) {
                    if (asyncHandler != null) {
                        asyncHandler.onError(e);
                    }
                    throw e;
                }
            }
        });
    }

    public CommandResponse updatePhoneticName(String str, String str2, String str3) {
        return m17211getJiboClient().updatePhoneticName(str, str2, str3);
    }

    public Future<CommandResponse> updatePhoneticName(final String str, final String str2, final String str3, final AsyncHandler<UpdatePhoneticNameRequest, CommandResponse> asyncHandler) {
        return m9909c().submit(new Callable<CommandResponse>() { // from class: com.jibo.aws.integration.aws.services.loop.JiboLoopAsyncClient.5
            @Override // java.util.concurrent.Callable
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public CommandResponse call() throws Exception {
                try {
                    CommandResponse commandResponseUpdatePhoneticName = JiboLoopAsyncClient.this.updatePhoneticName(str, str2, str3);
                    if (asyncHandler != null) {
                        asyncHandler.onSuccess(new UpdatePhoneticNameRequest(str, str2, str3), commandResponseUpdatePhoneticName);
                    }
                    return commandResponseUpdatePhoneticName;
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
