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

public class JiboLoopAsyncClient extends AbstractJiboAsyncClient {
   public JiboLoopAsyncClient(AWSCredentials var1) {
      super(var1);
   }

   public JiboLoopAsyncClient(AWSCredentials var1, ClientConfiguration var2) {
      super(var1, var2);
   }

   public JiboLoopAsyncClient(AWSCredentialsProvider var1) {
      super(var1);
   }

   public JiboLoopAsyncClient(AWSCredentialsProvider var1, ClientConfiguration var2) {
      super(var1, var2);
   }

   public Loop acceptInvitation(String var1) {
      return this.getJiboClient().acceptInvitation(var1);
   }

   public Future<Loop> acceptInvitation(String var1, AsyncHandler<AcceptLoopInvitationRequest, Loop> var2) {
      return this.c().submit(new Callable<Loop>(this, var1, var2) {
         final String a;
         final AsyncHandler b;
         final JiboLoopAsyncClient c;

         {
            this.c = var1;
            this.a = var2x;
            this.b = var3;
         }

         public Loop a() {
            Loop var1x;
            try {
               var1x = this.c.acceptInvitation(this.a);
            } catch (Exception var2x) {
               if (this.b != null) {
                  this.b.onError(var2x);
               }

               throw var2x;
            }

            if (this.b != null) {
               this.b.onSuccess(new AcceptLoopInvitationRequest(this.a), var1x);
            }

            return var1x;
         }
      });
   }

   public Loop createLoop(String var1, String var2) {
      return this.getJiboClient().createLoop(var1, var2);
   }

   public Future<Loop> createLoop(String var1, String var2, AsyncHandler<CreateRequest, Loop> var3) {
      return this.c().submit(new Callable<Loop>(this, var1, var2, var3) {
         final String a;
         final String b;
         final AsyncHandler c;
         final JiboLoopAsyncClient d;

         {
            this.d = var1;
            this.a = var2x;
            this.b = var3x;
            this.c = var4;
         }

         public Loop a() {
            Loop var1x;
            try {
               var1x = this.d.createLoop(this.a, this.b);
            } catch (Exception var2x) {
               if (this.c != null) {
                  this.c.onError(var2x);
               }

               throw var2x;
            }

            if (this.c != null) {
               this.c.onSuccess(new CreateRequest(this.a, this.b), var1x);
            }

            return var1x;
         }
      });
   }

   public Loop declineInvitation(String var1) {
      return this.getJiboClient().declineInvitation(var1);
   }

   public Future<Loop> declineInvitation(String var1, AsyncHandler<DeclineLoopInvitationRequest, Loop> var2) {
      return this.c().submit(new Callable<Loop>(this, var1, var2) {
         final String a;
         final AsyncHandler b;
         final JiboLoopAsyncClient c;

         {
            this.c = var1;
            this.a = var2x;
            this.b = var3;
         }

         public Loop a() {
            Loop var1x;
            try {
               var1x = this.c.declineInvitation(this.a);
            } catch (Exception var2x) {
               if (this.b != null) {
                  this.b.onError(var2x);
               }

               throw var2x;
            }

            if (this.b != null) {
               this.b.onSuccess(new DeclineLoopInvitationRequest(this.a), var1x);
            }

            return var1x;
         }
      });
   }

   public JiboLoopClient getJiboClient() {
      return (JiboLoopClient)super.getJiboClient();
   }

   public RobotAccount getRobot(String var1) {
      return this.getJiboClient().getRobot(var1);
   }

   public Future<RobotAccount> getRobot(String var1, AsyncHandler<GetRobotRequest, RobotAccount> var2) {
      return this.c().submit(new Callable<RobotAccount>(this, var1, var2) {
         final String a;
         final AsyncHandler b;
         final JiboLoopAsyncClient c;

         {
            this.c = var1;
            this.a = var2x;
            this.b = var3;
         }

         public RobotAccount a() {
            RobotAccount var1x;
            try {
               var1x = this.c.getRobot(this.a);
            } catch (Exception var2x) {
               if (this.b != null) {
                  this.b.onError(var2x);
               }

               throw var2x;
            }

            if (this.b != null) {
               this.b.onSuccess(new GetRobotRequest(this.a), var1x);
            }

            return var1x;
         }
      });
   }

   public Loop inviteMember(String var1, String var2, String var3, String var4, Account.Gender var5, Long var6, Boolean var7, Boolean var8) {
      return this.getJiboClient().inviteMember(var1, var2, var3, var4, var5, var6, var7, var8);
   }

   public Future<Loop> inviteMember(
      String var1,
      String var2,
      String var3,
      String var4,
      Account.Gender var5,
      Long var6,
      Boolean var7,
      Boolean var8,
      AsyncHandler<InviteMemberRequest, Loop> var9
   ) {
      return this.c().submit(new Callable<Loop>(this, var1, var2, var3, var4, var5, var6, var7, var8, var9) {
         final String a;
         final String b;
         final String c;
         final String d;
         final Account.Gender e;
         final Long f;
         final Boolean g;
         final Boolean h;
         final AsyncHandler i;
         final JiboLoopAsyncClient j;

         {
            this.j = var1;
            this.a = var2x;
            this.b = var3x;
            this.c = var4x;
            this.d = var5x;
            this.e = var6x;
            this.f = var7x;
            this.g = var8x;
            this.h = var9x;
            this.i = var10;
         }

         public Loop a() {
            Loop var1x;
            try {
               var1x = this.j.inviteMember(this.a, this.b, this.c, this.d, this.e, this.f, this.g, this.h);
            } catch (Exception var2x) {
               if (this.i != null) {
                  this.i.onError(var2x);
               }

               throw var2x;
            }

            if (this.i != null) {
               this.i.onSuccess(new InviteMemberRequest(this.a, this.b, this.c, this.d, this.e, this.f, this.g, this.h), var1x);
            }

            return var1x;
         }
      });
   }

   public List<Loop> listLoops() {
      return this.getJiboClient().listLoops();
   }

   public Future<List<Loop>> listLoops(AsyncHandler<ListRequest, List<Loop>> var1) {
      return this.c().submit(new Callable<List<Loop>>(this, var1) {
         final AsyncHandler a;
         final JiboLoopAsyncClient b;

         {
            this.b = var1;
            this.a = var2;
         }

         public List<Loop> a() {
            List var1x;
            try {
               var1x = this.b.listLoops();
            } catch (Exception var2) {
               if (this.a != null) {
                  this.a.onError(var2);
               }

               throw var2;
            }

            if (this.a != null) {
               this.a.onSuccess(new ListRequest(), var1x);
            }

            return var1x;
         }
      });
   }

   public List<Member> listMembers(List<String> var1, List<String> var2) {
      return this.getJiboClient().listMembers(var1, var2);
   }

   public Future<List<Member>> listMembers(List<String> var1, List<String> var2, AsyncHandler<ListMembersRequest, List<Member>> var3) {
      return this.c().submit(new Callable<List<Member>>(this, var1, var2, var3) {
         final List a;
         final List b;
         final AsyncHandler c;
         final JiboLoopAsyncClient d;

         {
            this.d = var1;
            this.a = var2x;
            this.b = var3x;
            this.c = var4;
         }

         public List<Member> a() {
            List var1x;
            try {
               var1x = this.d.listMembers(this.a, this.b);
            } catch (Exception var2x) {
               if (this.c != null) {
                  this.c.onError(var2x);
               }

               throw var2x;
            }

            if (this.c != null) {
               this.c.onSuccess(new ListMembersRequest(this.a, this.b), var1x);
            }

            return var1x;
         }
      });
   }

   public List<Robot> listOwnerRobots(String var1) {
      return this.getJiboClient().listOwnerRobots(var1);
   }

   public Future<List<Robot>> listOwnerRobots(String var1, AsyncHandler<ListOwnerRobotsRequest, List<Robot>> var2) {
      return this.c().submit(new Callable<List<Robot>>(this, var1, var2) {
         final String a;
         final AsyncHandler b;
         final JiboLoopAsyncClient c;

         {
            this.c = var1;
            this.a = var2x;
            this.b = var3;
         }

         public List<Robot> a() {
            List var1x;
            try {
               var1x = this.c.listOwnerRobots(this.a);
            } catch (Exception var2x) {
               if (this.b != null) {
                  this.b.onError(var2x);
               }

               throw var2x;
            }

            if (this.b != null) {
               this.b.onSuccess(new ListOwnerRobotsRequest(this.a), var1x);
            }

            return var1x;
         }
      });
   }

   public Loop removeLoop(String var1) {
      return this.getJiboClient().removeLoop(var1);
   }

   public Future<Loop> removeLoop(String var1, AsyncHandler<RemoveRequest, Loop> var2) {
      return this.c().submit(new Callable<Loop>(this, var1, var2) {
         final String a;
         final AsyncHandler b;
         final JiboLoopAsyncClient c;

         {
            this.c = var1;
            this.a = var2x;
            this.b = var3;
         }

         public Loop a() {
            Loop var1x;
            try {
               var1x = this.c.removeLoop(this.a);
            } catch (Exception var2x) {
               if (this.b != null) {
                  this.b.onError(var2x);
               }

               throw var2x;
            }

            if (this.b != null) {
               this.b.onSuccess(new RemoveRequest(this.a), var1x);
            }

            return var1x;
         }
      });
   }

   public Loop removeMember(String var1, String var2) {
      return this.getJiboClient().removeMember(var1, var2);
   }

   public Future<Loop> removeMember(String var1, String var2, AsyncHandler<RemoveMemberRequest, Loop> var3) {
      return this.c().submit(new Callable<Loop>(this, var1, var2, var3) {
         final String a;
         final String b;
         final AsyncHandler c;
         final JiboLoopAsyncClient d;

         {
            this.d = var1;
            this.a = var2x;
            this.b = var3x;
            this.c = var4;
         }

         public Loop a() {
            Loop var1x;
            try {
               var1x = this.d.removeMember(this.a, this.b);
            } catch (Exception var2x) {
               if (this.c != null) {
                  this.c.onError(var2x);
               }

               throw var2x;
            }

            if (this.c != null) {
               this.c.onSuccess(new RemoveMemberRequest(this.a, this.b), var1x);
            }

            return var1x;
         }
      });
   }

   public Loop removeMemberPhoto(String var1, String var2) {
      return this.getJiboClient().removeMemberPhoto(var1, var2);
   }

   public Future<Loop> removeMemberPhoto(String var1, String var2, AsyncHandler<RemoveMemberPhotoRequest, Loop> var3) {
      return this.c().submit(new Callable<Loop>(this, var1, var2, var3) {
         final String a;
         final String b;
         final AsyncHandler c;
         final JiboLoopAsyncClient d;

         {
            this.d = var1;
            this.a = var2x;
            this.b = var3x;
            this.c = var4;
         }

         public Loop a() {
            Loop var1x;
            try {
               var1x = this.d.removeMemberPhoto(this.a, this.b);
            } catch (Exception var2x) {
               if (this.c != null) {
                  this.c.onError(var2x);
               }

               throw var2x;
            }

            if (this.c != null) {
               this.c.onSuccess(new RemoveMemberPhotoRequest(this.a, this.b), var1x);
            }

            return var1x;
         }
      });
   }

   public CommandResponse setLegalGuardian(String var1, String var2, String var3) {
      return this.getJiboClient().setLegalGuardian(var1, var2, var3);
   }

   public Future<CommandResponse> setLegalGuardian(String var1, String var2, String var3, AsyncHandler<SetLegalGuardianRequest, CommandResponse> var4) {
      return this.c().submit(new Callable<CommandResponse>(this, var1, var2, var3, var4) {
         final String a;
         final String b;
         final String c;
         final AsyncHandler d;
         final JiboLoopAsyncClient e;

         {
            this.e = var1;
            this.a = var2x;
            this.b = var3x;
            this.c = var4x;
            this.d = var5;
         }

         public CommandResponse a() {
            CommandResponse var1x;
            try {
               var1x = this.e.setLegalGuardian(this.a, this.b, this.c);
            } catch (Exception var2x) {
               if (this.d != null) {
                  this.d.onError(var2x);
               }

               throw var2x;
            }

            if (this.d != null) {
               this.d.onSuccess(new SetLegalGuardianRequest(this.a, this.b, this.c), var1x);
            }

            return var1x;
         }
      });
   }

   public CommandResponse suspendLoop(String var1) {
      return this.getJiboClient().suspendLoop(var1);
   }

   public Future<CommandResponse> suspendLoop(String var1, AsyncHandler<SuspendLoopRequest, CommandResponse> var2) {
      return this.c().submit(new Callable<CommandResponse>(this, var1, var2) {
         final String a;
         final AsyncHandler b;
         final JiboLoopAsyncClient c;

         {
            this.c = var1;
            this.a = var2x;
            this.b = var3;
         }

         public CommandResponse a() {
            CommandResponse var1x;
            try {
               var1x = this.c.suspendLoop(this.a);
            } catch (Exception var2x) {
               if (this.b != null) {
                  this.b.onError(var2x);
               }

               throw var2x;
            }

            if (this.b != null) {
               this.b.onSuccess(new SuspendLoopRequest(this.a), var1x);
            }

            return var1x;
         }
      });
   }

   public CommandResponse updateLoop(String var1, String var2) {
      return this.getJiboClient().updateLoop(var1, var2);
   }

   public Future<CommandResponse> updateLoop(String var1, String var2, AsyncHandler<UpdateRequest, CommandResponse> var3) {
      return this.c().submit(new Callable<CommandResponse>(this, var1, var2, var3) {
         final String a;
         final String b;
         final AsyncHandler c;
         final JiboLoopAsyncClient d;

         {
            this.d = var1;
            this.a = var2x;
            this.b = var3x;
            this.c = var4;
         }

         public CommandResponse a() {
            CommandResponse var1x;
            try {
               var1x = this.d.updateLoop(this.a, this.b);
            } catch (Exception var2x) {
               if (this.c != null) {
                  this.c.onError(var2x);
               }

               throw var2x;
            }

            if (this.c != null) {
               this.c.onSuccess(new UpdateRequest(this.a, this.b), var1x);
            }

            return var1x;
         }
      });
   }

   public Loop updateMember(String var1, String var2, String var3, String var4, String var5, Account.Gender var6, Long var7, Boolean var8) {
      return this.getJiboClient().updateMember(var1, var2, var3, var4, var5, var6, var7, var8);
   }

   public Future<Loop> updateMember(
      String var1,
      String var2,
      String var3,
      String var4,
      String var5,
      Account.Gender var6,
      Long var7,
      Boolean var8,
      AsyncHandler<UpdateMemberRequest, Loop> var9
   ) {
      return this.c().submit(new Callable<Loop>(this, var1, var2, var3, var4, var5, var6, var7, var8, var9) {
         final String a;
         final String b;
         final String c;
         final String d;
         final String e;
         final Account.Gender f;
         final Long g;
         final Boolean h;
         final AsyncHandler i;
         final JiboLoopAsyncClient j;

         {
            this.j = var1;
            this.a = var2x;
            this.b = var3x;
            this.c = var4x;
            this.d = var5x;
            this.e = var6x;
            this.f = var7x;
            this.g = var8x;
            this.h = var9x;
            this.i = var10;
         }

         public Loop a() {
            Loop var1x;
            try {
               var1x = this.j.updateMember(this.a, this.b, this.c, this.d, this.e, this.f, this.g, this.h);
            } catch (Exception var2x) {
               if (this.i != null) {
                  this.i.onError(var2x);
               }

               throw var2x;
            }

            if (this.i != null) {
               this.i.onSuccess(new UpdateMemberRequest(this.a, this.b, this.c, this.d, this.e, this.f, this.g, this.h), var1x);
            }

            return var1x;
         }
      });
   }

   public Loop updateMemberPhoto(String var1, String var2, File var3) {
      return this.getJiboClient().updateMemberPhoto(var1, var2, var3);
   }

   public Future<Loop> updateMemberPhoto(String var1, String var2, File var3, AsyncHandler<UpdateMemberPhotoRequest, Loop> var4) {
      return this.c().submit(new Callable<Loop>(this, var1, var2, var3, var4) {
         final String a;
         final String b;
         final File c;
         final AsyncHandler d;
         final JiboLoopAsyncClient e;

         {
            this.e = var1;
            this.a = var2x;
            this.b = var3x;
            this.c = var4x;
            this.d = var5;
         }

         public Loop a() {
            Loop var1x;
            try {
               var1x = this.e.updateMemberPhoto(this.a, this.b, this.c);
            } catch (Exception var2x) {
               if (this.d != null) {
                  this.d.onError(var2x);
               }

               throw var2x;
            }

            if (this.d != null) {
               this.d.onSuccess(new UpdateMemberPhotoRequest(this.a, this.b, this.c, null), var1x);
            }

            return var1x;
         }
      });
   }

   public CommandResponse updateNickname(String var1, String var2, String var3) {
      return this.getJiboClient().updateNickname(var1, var2, var3);
   }

   public Future<CommandResponse> updateNickname(String var1, String var2, String var3, AsyncHandler<UpdateNicknameRequest, CommandResponse> var4) {
      return this.c().submit(new Callable<CommandResponse>(this, var1, var2, var3, var4) {
         final String a;
         final String b;
         final String c;
         final AsyncHandler d;
         final JiboLoopAsyncClient e;

         {
            this.e = var1;
            this.a = var2x;
            this.b = var3x;
            this.c = var4x;
            this.d = var5;
         }

         public CommandResponse a() {
            CommandResponse var1x;
            try {
               var1x = this.e.updateNickname(this.a, this.b, this.c);
            } catch (Exception var2x) {
               if (this.d != null) {
                  this.d.onError(var2x);
               }

               throw var2x;
            }

            if (this.d != null) {
               this.d.onSuccess(new UpdateNicknameRequest(this.a, this.b, this.c), var1x);
            }

            return var1x;
         }
      });
   }

   public CommandResponse updatePhoneticName(String var1, String var2, String var3) {
      return this.getJiboClient().updatePhoneticName(var1, var2, var3);
   }

   public Future<CommandResponse> updatePhoneticName(String var1, String var2, String var3, AsyncHandler<UpdatePhoneticNameRequest, CommandResponse> var4) {
      return this.c().submit(new Callable<CommandResponse>(this, var1, var2, var3, var4) {
         final String a;
         final String b;
         final String c;
         final AsyncHandler d;
         final JiboLoopAsyncClient e;

         {
            this.e = var1;
            this.a = var2x;
            this.b = var3x;
            this.c = var4x;
            this.d = var5;
         }

         public CommandResponse a() {
            CommandResponse var1x;
            try {
               var1x = this.e.updatePhoneticName(this.a, this.b, this.c);
            } catch (Exception var2x) {
               if (this.d != null) {
                  this.d.onError(var2x);
               }

               throw var2x;
            }

            if (this.d != null) {
               this.d.onSuccess(new UpdatePhoneticNameRequest(this.a, this.b, this.c), var1x);
            }

            return var1x;
         }
      });
   }
}
