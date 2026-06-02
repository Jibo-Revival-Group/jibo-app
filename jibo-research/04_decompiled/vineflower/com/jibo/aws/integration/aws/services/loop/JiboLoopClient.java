package com.jibo.aws.integration.aws.services.loop;

import com.amazonaws.ClientConfiguration;
import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSCredentialsProvider;
import com.amazonaws.http.HttpClient;
import com.jibo.aws.integration.aws.services.AbstractJiboClient;
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
import com.jibo.aws.integration.aws.services.loop.model.a.b;
import com.jibo.aws.integration.aws.services.loop.model.a.c;
import com.jibo.aws.integration.aws.services.loop.model.a.d;
import com.jibo.aws.integration.aws.services.loop.model.a.e;
import com.jibo.aws.integration.aws.services.loop.model.a.f;
import com.jibo.aws.integration.aws.services.loop.model.a.g;
import com.jibo.aws.integration.util.a;
import java.io.File;
import java.util.List;

public class JiboLoopClient extends AbstractJiboClient {
   public static final String TAG = com.jibo.aws.integration.util.a.a(JiboLoopClient.class);

   public JiboLoopClient(AWSCredentials var1) {
      super(var1);
   }

   public JiboLoopClient(AWSCredentials var1, ClientConfiguration var2) {
      super(var1, var2);
   }

   public JiboLoopClient(AWSCredentialsProvider var1) {
      super(var1);
   }

   public JiboLoopClient(AWSCredentialsProvider var1, ClientConfiguration var2) {
      super(var1, var2);
   }

   public JiboLoopClient(AWSCredentialsProvider var1, ClientConfiguration var2, HttpClient var3) {
      super(var1, var2, var3);
   }

   public Loop acceptInvitation(String var1) {
      return this.a(new AcceptLoopInvitationRequest(var1), null, new b()).getAwsResponse();
   }

   public Loop createLoop(String var1, String var2) {
      return this.a(new CreateRequest(var1, var2), null, new b()).getAwsResponse();
   }

   public Loop declineInvitation(String var1) {
      return this.a(new DeclineLoopInvitationRequest(var1), null, new b()).getAwsResponse();
   }

   public RobotAccount getRobot(String var1) {
      return this.a(new GetRobotRequest(var1), null, new e()).getAwsResponse();
   }

   public Loop inviteMember(String var1, String var2, String var3, String var4, Account.Gender var5, Long var6, Boolean var7, Boolean var8) {
      return this.a(new InviteMemberRequest(var1, var2, var3, var4, var5, var6, var7, var8), null, new b()).getAwsResponse();
   }

   public List<Loop> listLoops() {
      return this.a(new ListRequest(), null, new c()).getAwsResponse();
   }

   public List<Member> listMembers(List<String> var1, List<String> var2) {
      return this.a(new ListMembersRequest(var1, var2), null, new d()).getAwsResponse();
   }

   public List<Robot> listOwnerRobots(String var1) {
      return this.a(new ListOwnerRobotsRequest(var1), null, new f()).getAwsResponse();
   }

   public Loop removeLoop(String var1) {
      return this.a(new RemoveRequest(var1), null, new b()).getAwsResponse();
   }

   public Loop removeMember(String var1, String var2) {
      return this.a(new RemoveMemberRequest(var1, var2), null, new b()).getAwsResponse();
   }

   public Loop removeMemberPhoto(String var1, String var2) {
      return this.a(new RemoveMemberPhotoRequest(var1, var2), null, new b()).getAwsResponse();
   }

   public CommandResponse setLegalGuardian(String var1, String var2, String var3) {
      return this.a(new SetLegalGuardianRequest(var1, var2, var3), null, new com.jibo.aws.integration.aws.services.common.model.a.a()).getAwsResponse();
   }

   public CommandResponse suspendLoop(String var1) {
      return this.a(new SuspendLoopRequest(var1), null, new com.jibo.aws.integration.aws.services.common.model.a.a()).getAwsResponse();
   }

   public CommandResponse updateLoop(String var1, String var2) {
      return this.a(new UpdateRequest(var1, var2), null, new com.jibo.aws.integration.aws.services.common.model.a.a()).getAwsResponse();
   }

   public Loop updateMember(String var1, String var2, String var3, String var4, String var5, Account.Gender var6, Long var7, Boolean var8) {
      return this.a(new UpdateMemberRequest(var1, var2, var3, var4, var5, var6, var7, var8), null, new b()).getAwsResponse();
   }

   public Loop updateMemberPhoto(String var1, String var2, File var3) {
      return this.a(new UpdateMemberPhotoRequest(var1, var2, var3, null), new g(), new b()).getAwsResponse();
   }

   public CommandResponse updateNickname(String var1, String var2, String var3) {
      return this.a(new UpdateNicknameRequest(var1, var2, var3), null, new com.jibo.aws.integration.aws.services.common.model.a.a()).getAwsResponse();
   }

   public CommandResponse updatePhoneticName(String var1, String var2, String var3) {
      return this.a(new UpdatePhoneticNameRequest(var1, var2, var3), null, new com.jibo.aws.integration.aws.services.common.model.a.a()).getAwsResponse();
   }
}
