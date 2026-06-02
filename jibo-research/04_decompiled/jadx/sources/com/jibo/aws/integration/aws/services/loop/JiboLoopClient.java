package com.jibo.aws.integration.aws.services.loop;

import com.amazonaws.ClientConfiguration;
import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSCredentialsProvider;
import com.amazonaws.http.HttpClient;
import com.jibo.aws.integration.aws.services.AbstractJiboClient;
import com.jibo.aws.integration.aws.services.account.model.Account;
import com.jibo.aws.integration.aws.services.common.model.CommandResponse;
import com.jibo.aws.integration.aws.services.common.model.p005a.C0851a;
import com.jibo.aws.integration.aws.services.common.model.p005a.C0855e;
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
import com.jibo.aws.integration.aws.services.loop.model.p011a.C0923b;
import com.jibo.aws.integration.aws.services.loop.model.p011a.C0924c;
import com.jibo.aws.integration.aws.services.loop.model.p011a.C0925d;
import com.jibo.aws.integration.aws.services.loop.model.p011a.C0926e;
import com.jibo.aws.integration.aws.services.loop.model.p011a.C0927f;
import com.jibo.aws.integration.aws.services.loop.model.p011a.C0928g;
import com.jibo.aws.integration.util.C0977a;
import java.io.File;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class JiboLoopClient extends AbstractJiboClient {
    public static final String TAG = C0977a.m10070a(JiboLoopClient.class);

    public JiboLoopClient(AWSCredentials aWSCredentials) {
        super(aWSCredentials);
    }

    public JiboLoopClient(AWSCredentials aWSCredentials, ClientConfiguration clientConfiguration) {
        super(aWSCredentials, clientConfiguration);
    }

    public JiboLoopClient(AWSCredentialsProvider aWSCredentialsProvider) {
        super(aWSCredentialsProvider);
    }

    public JiboLoopClient(AWSCredentialsProvider aWSCredentialsProvider, ClientConfiguration clientConfiguration) {
        super(aWSCredentialsProvider, clientConfiguration);
    }

    public JiboLoopClient(AWSCredentialsProvider aWSCredentialsProvider, ClientConfiguration clientConfiguration, HttpClient httpClient) {
        super(aWSCredentialsProvider, clientConfiguration, httpClient);
    }

    public Loop acceptInvitation(String str) {
        return (Loop) m9913a(new AcceptLoopInvitationRequest(str), (C0855e) null, new C0923b()).getAwsResponse();
    }

    public Loop createLoop(String str, String str2) {
        return (Loop) m9913a(new CreateRequest(str, str2), (C0855e) null, new C0923b()).getAwsResponse();
    }

    public Loop declineInvitation(String str) {
        return (Loop) m9913a(new DeclineLoopInvitationRequest(str), (C0855e) null, new C0923b()).getAwsResponse();
    }

    public RobotAccount getRobot(String str) {
        return (RobotAccount) m9913a(new GetRobotRequest(str), (C0855e) null, new C0926e()).getAwsResponse();
    }

    public Loop inviteMember(String str, String str2, String str3, String str4, Account.Gender gender, Long l, Boolean bool, Boolean bool2) {
        return (Loop) m9913a(new InviteMemberRequest(str, str2, str3, str4, gender, l, bool, bool2), (C0855e) null, new C0923b()).getAwsResponse();
    }

    public List<Loop> listLoops() {
        return (List) m9913a(new ListRequest(), (C0855e) null, new C0924c()).getAwsResponse();
    }

    public List<Member> listMembers(List<String> list, List<String> list2) {
        return (List) m9913a(new ListMembersRequest(list, list2), (C0855e) null, new C0925d()).getAwsResponse();
    }

    public List<Robot> listOwnerRobots(String str) {
        return (List) m9913a(new ListOwnerRobotsRequest(str), (C0855e) null, new C0927f()).getAwsResponse();
    }

    public Loop removeLoop(String str) {
        return (Loop) m9913a(new RemoveRequest(str), (C0855e) null, new C0923b()).getAwsResponse();
    }

    public Loop removeMember(String str, String str2) {
        return (Loop) m9913a(new RemoveMemberRequest(str, str2), (C0855e) null, new C0923b()).getAwsResponse();
    }

    public Loop removeMemberPhoto(String str, String str2) {
        return (Loop) m9913a(new RemoveMemberPhotoRequest(str, str2), (C0855e) null, new C0923b()).getAwsResponse();
    }

    public CommandResponse setLegalGuardian(String str, String str2, String str3) {
        return (CommandResponse) m9913a(new SetLegalGuardianRequest(str, str2, str3), (C0855e) null, new C0851a()).getAwsResponse();
    }

    public CommandResponse suspendLoop(String str) {
        return (CommandResponse) m9913a(new SuspendLoopRequest(str), (C0855e) null, new C0851a()).getAwsResponse();
    }

    public CommandResponse updateLoop(String str, String str2) {
        return (CommandResponse) m9913a(new UpdateRequest(str, str2), (C0855e) null, new C0851a()).getAwsResponse();
    }

    public Loop updateMember(String str, String str2, String str3, String str4, String str5, Account.Gender gender, Long l, Boolean bool) {
        return (Loop) m9913a(new UpdateMemberRequest(str, str2, str3, str4, str5, gender, l, bool), (C0855e) null, new C0923b()).getAwsResponse();
    }

    public Loop updateMemberPhoto(String str, String str2, File file) {
        return (Loop) m9913a(new UpdateMemberPhotoRequest(str, str2, file, null), new C0928g(), new C0923b()).getAwsResponse();
    }

    public CommandResponse updateNickname(String str, String str2, String str3) {
        return (CommandResponse) m9913a(new UpdateNicknameRequest(str, str2, str3), (C0855e) null, new C0851a()).getAwsResponse();
    }

    public CommandResponse updatePhoneticName(String str, String str2, String str3) {
        return (CommandResponse) m9913a(new UpdatePhoneticNameRequest(str, str2, str3), (C0855e) null, new C0851a()).getAwsResponse();
    }
}
