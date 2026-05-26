.class public Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment;
.super Lcom/jibo/ui/fragment/BaseFragment;
.source "JiboDetailsFragment.java"

# interfaces
.implements Landroid/support/v4/app/LoaderManager$LoaderCallbacks;
.implements Landroid/support/v4/widget/SwipeRefreshLayout$OnRefreshListener;
.implements Lcom/jibo/ui/fragment/dialog/passphrase/LoopPassphraseRestoreDialog$BackupKeyRestoredListener;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment$LoadAttributionsAsyncTask;,
        Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment$WhyTextClickableSpan;
    }
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lcom/jibo/ui/fragment/BaseFragment;",
        "Landroid/support/v4/app/LoaderManager$LoaderCallbacks",
        "<",
        "Landroid/database/Cursor;",
        ">;",
        "Landroid/support/v4/widget/SwipeRefreshLayout$OnRefreshListener;",
        "Lcom/jibo/ui/fragment/dialog/passphrase/LoopPassphraseRestoreDialog$BackupKeyRestoredListener;"
    }
.end annotation


# instance fields
.field a:Z

.field b:Lcom/jibo/ui/fragment/dialog/CircleProgressFragment;

.field btnReconnectToJibo:Landroid/view/View;
    .annotation build Lbutterknife/BindView;
    .end annotation
.end field

.field private c:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/jibo/ui/helpers/Items$Item;",
            ">;"
        }
    .end annotation
.end field

.field private d:Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment$LoadAttributionsAsyncTask;

.field private e:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/jibo/aws/integration/aws/services/gqa/model/Attribution;",
            ">;"
        }
    .end annotation
.end field

.field private l:Lcom/jibo/ui/fragment/jibos/adapter/LoopMembersListAdapter;

.field list:Landroid/support/v7/widget/RecyclerView;
    .annotation build Lbutterknife/BindView;
    .end annotation
.end field

.field loopSuspendedView:Landroid/view/View;
    .annotation build Lbutterknife/BindView;
    .end annotation
.end field

.field private m:Lcom/jibo/aws/integration/aws/services/loop/model/Member;

.field private n:Lcom/jibo/aws/integration/aws/services/notification/JiboNotificationAsyncClient;

.field private o:Lcom/jibo/aws/integration/aws/services/skills/JiboSkillsAsyncClient;

.field private p:Lcom/jibo/aws/integration/aws/services/loop/model/Member;

.field private q:Landroid/view/View$OnClickListener;

.field private r:Landroid/view/View$OnLongClickListener;

.field private s:Lcom/jibo/aws/integration/aws/services/robotProperties/JiboRobotPropertiesAsyncClient;

.field swipeRefreshLayout:Landroid/support/v4/widget/SwipeRefreshLayout;
    .annotation build Lbutterknife/BindView;
    .end annotation
.end field

.field private t:Lcom/jibo/aws/integration/aws/services/robotProperties/model/Robot;

.field tutorialTitle:Landroid/widget/TextView;
    .annotation build Lbutterknife/BindView;
    .end annotation
.end field

.field tutorialTitleContainer:Landroid/view/View;
    .annotation build Lbutterknife/BindView;
    .end annotation
.end field

.field private u:Landroid/content/BroadcastReceiver;

.field private v:Landroid/view/View$OnClickListener;

.field private w:Lcom/jibo/ui/fragment/dialog/passphrase/LoopPassphraseUtils$KeyBackupCheckListener;

.field private x:Lcom/jibo/ui/fragment/dialog/passphrase/LoopPassphraseUtils$KeyBackupCheckListener;

.field private y:Landroid/view/View$OnClickListener;


# direct methods
.method public constructor <init>()V
    .locals 2

    .prologue
    const/4 v1, 0x0

    .line 113
    invoke-direct {p0}, Lcom/jibo/ui/fragment/BaseFragment;-><init>()V

    .line 135
    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment;->a:Z

    .line 139
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment;->c:Ljava/util/List;

    .line 141
    new-instance v0, Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment$LoadAttributionsAsyncTask;

    invoke-direct {v0, p0, v1}, Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment$LoadAttributionsAsyncTask;-><init>(Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment;Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment$1;)V

    iput-object v0, p0, Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment;->d:Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment$LoadAttributionsAsyncTask;

    .line 145
    iput-object v1, p0, Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment;->m:Lcom/jibo/aws/integration/aws/services/loop/model/Member;

    .line 151
    iput-object v1, p0, Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment;->p:Lcom/jibo/aws/integration/aws/services/loop/model/Member;

    .line 152
    new-instance v0, Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment$1;

    invoke-direct {v0, p0}, Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment$1;-><init>(Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment;)V

    iput-object v0, p0, Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment;->q:Landroid/view/View$OnClickListener;

    .line 161
    new-instance v0, Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment$2;

    invoke-direct {v0, p0}, Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment$2;-><init>(Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment;)V

    iput-object v0, p0, Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment;->r:Landroid/view/View$OnLongClickListener;

    .line 181
    new-instance v0, Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment$3;

    invoke-direct {v0, p0}, Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment$3;-><init>(Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment;)V

    iput-object v0, p0, Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment;->u:Landroid/content/BroadcastReceiver;

    .line 977
    new-instance v0, Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment$16;

    invoke-direct {v0, p0}, Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment$16;-><init>(Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment;)V

    iput-object v0, p0, Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment;->v:Landroid/view/View$OnClickListener;

    .line 985
    new-instance v0, Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment$17;

    invoke-direct {v0, p0}, Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment$17;-><init>(Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment;)V

    iput-object v0, p0, Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment;->w:Lcom/jibo/ui/fragment/dialog/passphrase/LoopPassphraseUtils$KeyBackupCheckListener;

    .line 1000
    new-instance v0, Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment$18;

    invoke-direct {v0, p0}, Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment$18;-><init>(Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment;)V

    iput-object v0, p0, Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment;->x:Lcom/jibo/ui/fragment/dialog/passphrase/LoopPassphraseUtils$KeyBackupCheckListener;

    .line 1021
    new-instance v0, Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment$19;

    invoke-direct {v0, p0}, Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment$19;-><init>(Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment;)V

    iput-object v0, p0, Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment;->y:Landroid/view/View$OnClickListener;

    return-void
.end method

.method private A()V
    .locals 3

    .prologue
    .line 1125
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    invoke-static {v0}, Lcom/jibo/utils/SharedPreferencesUtil;->q(Landroid/content/Context;)Z

    move-result v0

    if-nez v0, :cond_0

    iget-object v0, p0, Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment;->o:Lcom/jibo/aws/integration/aws/services/skills/JiboSkillsAsyncClient;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment;->k:Lcom/jibo/aws/integration/aws/services/loop/model/Loop;

    if-eqz v0, :cond_0

    .line 1127
    iget-object v0, p0, Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment;->o:Lcom/jibo/aws/integration/aws/services/skills/JiboSkillsAsyncClient;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment;->k:Lcom/jibo/aws/integration/aws/services/loop/model/Loop;

    if-eqz v0, :cond_0

    iget-boolean v0, p0, Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment;->a:Z

    if-nez v0, :cond_0

    .line 1129
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment;->f()V

    .line 1131
    iget-object v0, p0, Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment;->o:Lcom/jibo/aws/integration/aws/services/skills/JiboSkillsAsyncClient;

    iget-object v1, p0, Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment;->k:Lcom/jibo/aws/integration/aws/services/loop/model/Loop;

    invoke-virtual {v1}, Lcom/jibo/aws/integration/aws/services/loop/model/Loop;->getId()Ljava/lang/String;

    move-result-object v1

    new-instance v2, Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment$20;

    invoke-direct {v2, p0}, Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment$20;-><init>(Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment;)V

    invoke-virtual {v0, v1, v2}, Lcom/jibo/aws/integration/aws/services/skills/JiboSkillsAsyncClient;->getSkillsJson(Ljava/lang/String;Lcom/amazonaws/handlers/AsyncHandler;)Ljava/util/concurrent/Future;

    .line 1161
    :cond_0
    return-void
.end method

.method static synthetic a(Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment;)Lcom/jibo/aws/integration/aws/services/loop/model/Member;
    .locals 1

    .prologue
    .line 113
    iget-object v0, p0, Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment;->p:Lcom/jibo/aws/integration/aws/services/loop/model/Member;

    return-object v0
.end method

.method static synthetic a(Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment;Lcom/jibo/aws/integration/aws/services/robotProperties/model/Robot;)Lcom/jibo/aws/integration/aws/services/robotProperties/model/Robot;
    .locals 0

    .prologue
    .line 113
    iput-object p1, p0, Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment;->t:Lcom/jibo/aws/integration/aws/services/robotProperties/model/Robot;

    return-object p1
.end method

.method static synthetic a(Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment;Ljava/util/List;)Ljava/util/List;
    .locals 0

    .prologue
    .line 113
    iput-object p1, p0, Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment;->e:Ljava/util/List;

    return-object p1
.end method

.method private a(Ljava/util/List;)Ljava/util/List;
    .locals 8
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Lcom/jibo/aws/integration/aws/services/gqa/model/Attribution;",
            ">;)",
            "Ljava/util/List",
            "<",
            "Lcom/jibo/ui/helpers/Items$Item;",
            ">;"
        }
    .end annotation

    .prologue
    .line 1101
    new-instance v3, Ljava/util/ArrayList;

    invoke-direct {v3}, Ljava/util/ArrayList;-><init>()V

    .line 1102
    if-eqz p1, :cond_3

    .line 1103
    const/4 v1, 0x0

    .line 1104
    invoke-interface {p1}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v4

    :goto_0
    invoke-interface {v4}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_3

    invoke-interface {v4}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/jibo/aws/integration/aws/services/gqa/model/Attribution;

    .line 1105
    if-nez v1, :cond_1

    .line 1106
    new-instance v1, Ljava/util/Date;

    invoke-virtual {v0}, Lcom/jibo/aws/integration/aws/services/gqa/model/Attribution;->getTimestamp()J

    move-result-wide v6

    invoke-direct {v1, v6, v7}, Ljava/util/Date;-><init>(J)V

    .line 1107
    new-instance v2, Lcom/jibo/ui/helpers/Items$DateItem;

    invoke-virtual {v0}, Lcom/jibo/aws/integration/aws/services/gqa/model/Attribution;->getTimestamp()J

    move-result-wide v6

    sget-object v5, Lcom/jibo/aws/integration/util/DateTimeUtils;->FULL_DATE_FORMAT:Ljava/lang/String;

    invoke-static {v6, v7, v5}, Lcom/jibo/aws/integration/util/DateTimeUtils;->getBirthdayString(JLjava/lang/String;)Ljava/lang/String;

    move-result-object v5

    invoke-direct {v2, v5}, Lcom/jibo/ui/helpers/Items$DateItem;-><init>(Ljava/lang/String;)V

    invoke-interface {v3, v2}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 1117
    :cond_0
    :goto_1
    new-instance v2, Lcom/jibo/ui/helpers/Items$AttributionItem;

    iget-object v5, p0, Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment;->y:Landroid/view/View$OnClickListener;

    invoke-direct {v2, v0, v5}, Lcom/jibo/ui/helpers/Items$AttributionItem;-><init>(Lcom/jibo/aws/integration/aws/services/gqa/model/Attribution;Landroid/view/View$OnClickListener;)V

    invoke-interface {v3, v2}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    goto :goto_0

    .line 1109
    :cond_1
    new-instance v2, Ljava/util/Date;

    invoke-virtual {v0}, Lcom/jibo/aws/integration/aws/services/gqa/model/Attribution;->getTimestamp()J

    move-result-wide v6

    invoke-direct {v2, v6, v7}, Ljava/util/Date;-><init>(J)V

    .line 1110
    invoke-virtual {v2}, Ljava/util/Date;->getDate()I

    move-result v5

    invoke-virtual {v1}, Ljava/util/Date;->getDate()I

    move-result v6

    if-ne v5, v6, :cond_2

    .line 1111
    invoke-virtual {v2}, Ljava/util/Date;->getMonth()I

    move-result v5

    invoke-virtual {v1}, Ljava/util/Date;->getMonth()I

    move-result v6

    if-ne v5, v6, :cond_2

    .line 1112
    invoke-virtual {v2}, Ljava/util/Date;->getYear()I

    move-result v5

    invoke-virtual {v1}, Ljava/util/Date;->getYear()I

    move-result v6

    if-eq v5, v6, :cond_0

    .line 1114
    :cond_2
    new-instance v1, Lcom/jibo/ui/helpers/Items$DateItem;

    invoke-virtual {v0}, Lcom/jibo/aws/integration/aws/services/gqa/model/Attribution;->getTimestamp()J

    move-result-wide v6

    sget-object v5, Lcom/jibo/aws/integration/util/DateTimeUtils;->FULL_DATE_FORMAT:Ljava/lang/String;

    invoke-static {v6, v7, v5}, Lcom/jibo/aws/integration/util/DateTimeUtils;->getBirthdayString(JLjava/lang/String;)Ljava/lang/String;

    move-result-object v5

    invoke-direct {v1, v5}, Lcom/jibo/ui/helpers/Items$DateItem;-><init>(Ljava/lang/String;)V

    invoke-interface {v3, v1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    move-object v1, v2

    goto :goto_1

    .line 1120
    :cond_3
    return-object v3
.end method

.method private a(Lcom/jibo/aws/integration/aws/services/loop/model/Member;)V
    .locals 4

    .prologue
    .line 783
    new-instance v1, Lcom/jibo/ui/activity/SingleFragmentActivity$Builder;

    const-class v0, Lcom/jibo/ui/fragment/profile/ProfileFragment;

    .line 784
    invoke-virtual {v0}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v0

    invoke-direct {v1, p0, v0}, Lcom/jibo/ui/activity/SingleFragmentActivity$Builder;-><init>(Landroid/support/v4/app/Fragment;Ljava/lang/String;)V

    .line 785
    const-class v0, Lcom/jibo/aws/integration/aws/services/loop/model/Member;

    invoke-virtual {v0}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v1, v0, p1}, Lcom/jibo/ui/activity/SingleFragmentActivity$Builder;->a(Ljava/lang/String;Landroid/os/Parcelable;)Lcom/jibo/ui/activity/SingleFragmentActivity$Builder;

    move-result-object v0

    const-class v2, Lcom/jibo/aws/integration/aws/services/loop/model/Loop;

    .line 786
    invoke-virtual {v2}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v2

    iget-object v3, p0, Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment;->k:Lcom/jibo/aws/integration/aws/services/loop/model/Loop;

    invoke-virtual {v0, v2, v3}, Lcom/jibo/ui/activity/SingleFragmentActivity$Builder;->a(Ljava/lang/String;Landroid/os/Parcelable;)Lcom/jibo/ui/activity/SingleFragmentActivity$Builder;

    move-result-object v2

    const-string v3, "ARG_LOOPS"

    .line 787
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    check-cast v0, Lcom/jibo/ui/activity/TabbedActivity;

    invoke-virtual {v0}, Lcom/jibo/ui/activity/TabbedActivity;->x()Ljava/util/ArrayList;

    move-result-object v0

    invoke-virtual {v2, v3, v0}, Lcom/jibo/ui/activity/SingleFragmentActivity$Builder;->a(Ljava/lang/String;Ljava/io/Serializable;)Lcom/jibo/ui/activity/SingleFragmentActivity$Builder;

    .line 788
    const/16 v0, 0x3ef

    invoke-virtual {v1, v0}, Lcom/jibo/ui/activity/SingleFragmentActivity$Builder;->a(I)V

    .line 789
    return-void
.end method

.method static synthetic a(Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment;Lcom/jibo/aws/integration/aws/services/loop/model/Member;)V
    .locals 0

    .prologue
    .line 113
    invoke-direct {p0, p1}, Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment;->a(Lcom/jibo/aws/integration/aws/services/loop/model/Member;)V

    return-void
.end method

.method static synthetic a(Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment;Ljava/lang/Throwable;Ljava/lang/String;Z)V
    .locals 0

    .prologue
    .line 113
    invoke-virtual {p0, p1, p2, p3}, Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment;->a(Ljava/lang/Throwable;Ljava/lang/String;Z)V

    return-void
.end method

.method private a(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    .locals 4

    .prologue
    .line 909
    new-instance v0, Lcom/jibo/ui/fragment/dialog/CircleProgressFragment;

    invoke-direct {v0}, Lcom/jibo/ui/fragment/dialog/CircleProgressFragment;-><init>()V

    iput-object v0, p0, Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment;->b:Lcom/jibo/ui/fragment/dialog/CircleProgressFragment;

    .line 911
    iget-object v0, p0, Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment;->b:Lcom/jibo/ui/fragment/dialog/CircleProgressFragment;

    const v1, 0x7f10026f

    const/4 v2, 0x1

    new-array v2, v2, [Ljava/lang/Object;

    const/4 v3, 0x0

    aput-object p3, v2, v3

    invoke-virtual {p0, v1, v2}, Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment;->getString(I[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/jibo/ui/fragment/dialog/CircleProgressFragment;->c(Ljava/lang/String;)V

    .line 912
    iget-object v0, p0, Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment;->b:Lcom/jibo/ui/fragment/dialog/CircleProgressFragment;

    invoke-virtual {p0}, Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v1

    invoke-virtual {v1}, Landroid/support/v4/app/FragmentActivity;->getSupportFragmentManager()Landroid/support/v4/app/FragmentManager;

    move-result-object v1

    const-class v2, Lcom/jibo/ui/fragment/dialog/CircleProgressFragment;

    invoke-virtual {v2}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Lcom/jibo/ui/fragment/dialog/CircleProgressFragment;->show(Landroid/support/v4/app/FragmentManager;Ljava/lang/String;)V

    .line 913
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    invoke-static {v0}, Lcom/jibo/db/EntityData;->a(Landroid/content/Context;)Lcom/jibo/db/EntityData;

    move-result-object v0

    invoke-virtual {v0}, Lcom/jibo/db/EntityData;->b()Lcom/jibo/aws/integration/aws/services/loop/JiboLoopAsyncClient;

    move-result-object v0

    new-instance v1, Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment$15;

    invoke-direct {v1, p0}, Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment$15;-><init>(Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment;)V

    invoke-virtual {v0, p1, p2, v1}, Lcom/jibo/aws/integration/aws/services/loop/JiboLoopAsyncClient;->removeMember(Ljava/lang/String;Ljava/lang/String;Lcom/amazonaws/handlers/AsyncHandler;)Ljava/util/concurrent/Future;

    .line 942
    return-void
.end method

.method private a(Ljava/util/Collection;)V
    .locals 3
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/Collection",
            "<",
            "Lcom/jibo/ui/helpers/Items$Item;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 300
    new-instance v0, Lcom/jibo/ui/helpers/Items$SubheaderItem;

    const v1, 0x7f10015d

    invoke-direct {v0, v1}, Lcom/jibo/ui/helpers/Items$SubheaderItem;-><init>(I)V

    invoke-interface {p1, v0}, Ljava/util/Collection;->add(Ljava/lang/Object;)Z

    .line 302
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    invoke-static {v0}, Lcom/jibo/db/EntityData;->a(Landroid/content/Context;)Lcom/jibo/db/EntityData;

    move-result-object v0

    invoke-virtual {v0}, Lcom/jibo/db/EntityData;->i()Lcom/jibo/aws/integration/aws/services/account/model/Account;

    move-result-object v0

    .line 305
    iget-object v1, p0, Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment;->k:Lcom/jibo/aws/integration/aws/services/loop/model/Loop;

    invoke-virtual {v0}, Lcom/jibo/aws/integration/aws/services/account/model/Account;->getId()Ljava/lang/String;

    move-result-object v0

    invoke-static {v1, v0}, Lcom/jibo/aws/integration/helpers/LoopHelper;->isOwner(Lcom/jibo/aws/integration/aws/services/loop/model/Loop;Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 306
    new-instance v0, Lcom/jibo/ui/helpers/Items$JiboSettingsItem;

    new-instance v1, Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment$6;

    invoke-direct {v1, p0}, Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment$6;-><init>(Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment;)V

    iget-object v2, p0, Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment;->t:Lcom/jibo/aws/integration/aws/services/robotProperties/model/Robot;

    invoke-direct {v0, v1, v2}, Lcom/jibo/ui/helpers/Items$JiboSettingsItem;-><init>(Landroid/view/View$OnClickListener;Lcom/jibo/aws/integration/aws/services/robotProperties/model/Robot;)V

    invoke-interface {p1, v0}, Ljava/util/Collection;->add(Ljava/lang/Object;)Z

    .line 325
    :goto_0
    return-void

    .line 317
    :cond_0
    new-instance v0, Lcom/jibo/ui/helpers/Items$WifiSettingsItem;

    new-instance v1, Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment$7;

    invoke-direct {v1, p0}, Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment$7;-><init>(Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment;)V

    invoke-direct {v0, v1}, Lcom/jibo/ui/helpers/Items$WifiSettingsItem;-><init>(Landroid/view/View$OnClickListener;)V

    invoke-interface {p1, v0}, Ljava/util/Collection;->add(Ljava/lang/Object;)Z

    goto :goto_0
.end method

.method static synthetic b(Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment;)Lcom/jibo/aws/integration/aws/services/loop/model/Loop;
    .locals 1

    .prologue
    .line 113
    iget-object v0, p0, Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment;->k:Lcom/jibo/aws/integration/aws/services/loop/model/Loop;

    return-object v0
.end method

.method static synthetic b(Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment;Lcom/jibo/aws/integration/aws/services/loop/model/Member;)Lcom/jibo/aws/integration/aws/services/loop/model/Member;
    .locals 0

    .prologue
    .line 113
    iput-object p1, p0, Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment;->p:Lcom/jibo/aws/integration/aws/services/loop/model/Member;

    return-object p1
.end method

.method static synthetic b(Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment;Ljava/util/List;)Ljava/util/List;
    .locals 1

    .prologue
    .line 113
    invoke-direct {p0, p1}, Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment;->a(Ljava/util/List;)Ljava/util/List;

    move-result-object v0

    return-object v0
.end method

.method private b()V
    .locals 2

    .prologue
    .line 295
    iget-object v0, p0, Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment;->tutorialTitleContainer:Landroid/view/View;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroid/view/View;->setVisibility(I)V

    .line 296
    iget-object v1, p0, Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment;->tutorialTitle:Landroid/widget/TextView;

    iget-object v0, p0, Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment;->k:Lcom/jibo/aws/integration/aws/services/loop/model/Loop;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment;->k:Lcom/jibo/aws/integration/aws/services/loop/model/Loop;

    invoke-virtual {v0}, Lcom/jibo/aws/integration/aws/services/loop/model/Loop;->getName()Ljava/lang/String;

    move-result-object v0

    :goto_0
    invoke-virtual {v1, v0}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 297
    return-void

    .line 296
    :cond_0
    const-string v0, ""

    goto :goto_0
.end method

.method static synthetic b(Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment;Ljava/lang/Throwable;Ljava/lang/String;Z)V
    .locals 0

    .prologue
    .line 113
    invoke-virtual {p0, p1, p2, p3}, Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment;->a(Ljava/lang/Throwable;Ljava/lang/String;Z)V

    return-void
.end method

.method private b(Z)V
    .locals 3

    .prologue
    const/16 v1, 0x8

    const/4 v0, 0x0

    .line 753
    iget-object v2, p0, Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment;->loopSuspendedView:Landroid/view/View;

    invoke-virtual {v2, v0}, Landroid/view/View;->setVisibility(I)V

    .line 754
    iget-object v2, p0, Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment;->btnReconnectToJibo:Landroid/view/View;

    if-eqz p1, :cond_1

    :goto_0
    invoke-virtual {v2, v0}, Landroid/view/View;->setVisibility(I)V

    .line 755
    iget-object v0, p0, Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment;->list:Landroid/support/v7/widget/RecyclerView;

    invoke-virtual {v0, v1}, Landroid/support/v7/widget/RecyclerView;->setVisibility(I)V

    .line 757
    if-eqz p1, :cond_0

    invoke-direct {p0}, Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment;->u()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 758
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment;->f()V

    .line 759
    iget-object v0, p0, Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment;->k:Lcom/jibo/aws/integration/aws/services/loop/model/Loop;

    invoke-virtual {v0}, Lcom/jibo/aws/integration/aws/services/loop/model/Loop;->getId()Ljava/lang/String;

    move-result-object v0

    iget-object v1, p0, Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment;->w:Lcom/jibo/ui/fragment/dialog/passphrase/LoopPassphraseUtils$KeyBackupCheckListener;

    invoke-static {v0, p0, v1}, Lcom/jibo/ui/fragment/dialog/passphrase/LoopPassphraseUtils;->a(Ljava/lang/String;Lcom/jibo/ui/fragment/BaseFragment;Lcom/jibo/ui/fragment/dialog/passphrase/LoopPassphraseUtils$KeyBackupCheckListener;)V

    .line 761
    :cond_0
    return-void

    :cond_1
    move v0, v1

    .line 754
    goto :goto_0
.end method

.method static synthetic c(Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment;)Lcom/jibo/aws/integration/aws/services/loop/model/Loop;
    .locals 1

    .prologue
    .line 113
    iget-object v0, p0, Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment;->k:Lcom/jibo/aws/integration/aws/services/loop/model/Loop;

    return-object v0
.end method

.method static synthetic c(Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment;Ljava/lang/Throwable;Ljava/lang/String;Z)V
    .locals 0

    .prologue
    .line 113
    invoke-virtual {p0, p1, p2, p3}, Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment;->a(Ljava/lang/Throwable;Ljava/lang/String;Z)V

    return-void
.end method

.method static synthetic d(Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment;)Lcom/jibo/aws/integration/aws/services/loop/model/Loop;
    .locals 1

    .prologue
    .line 113
    iget-object v0, p0, Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment;->k:Lcom/jibo/aws/integration/aws/services/loop/model/Loop;

    return-object v0
.end method

.method static synthetic d(Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment;Ljava/lang/Throwable;Ljava/lang/String;Z)V
    .locals 0

    .prologue
    .line 113
    invoke-virtual {p0, p1, p2, p3}, Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment;->a(Ljava/lang/Throwable;Ljava/lang/String;Z)V

    return-void
.end method

.method static synthetic e(Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment;)Lcom/jibo/aws/integration/aws/services/loop/model/Loop;
    .locals 1

    .prologue
    .line 113
    iget-object v0, p0, Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment;->k:Lcom/jibo/aws/integration/aws/services/loop/model/Loop;

    return-object v0
.end method

.method static synthetic e(Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment;Ljava/lang/Throwable;Ljava/lang/String;Z)V
    .locals 0

    .prologue
    .line 113
    invoke-virtual {p0, p1, p2, p3}, Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment;->a(Ljava/lang/Throwable;Ljava/lang/String;Z)V

    return-void
.end method

.method static synthetic f(Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment;)Lcom/jibo/aws/integration/aws/services/loop/model/Loop;
    .locals 1

    .prologue
    .line 113
    iget-object v0, p0, Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment;->k:Lcom/jibo/aws/integration/aws/services/loop/model/Loop;

    return-object v0
.end method

.method static synthetic g(Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment;)Lcom/jibo/aws/integration/aws/services/loop/model/Loop;
    .locals 1

    .prologue
    .line 113
    iget-object v0, p0, Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment;->k:Lcom/jibo/aws/integration/aws/services/loop/model/Loop;

    return-object v0
.end method

.method static synthetic h(Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment;)Lcom/jibo/aws/integration/aws/services/loop/model/Loop;
    .locals 1

    .prologue
    .line 113
    iget-object v0, p0, Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment;->k:Lcom/jibo/aws/integration/aws/services/loop/model/Loop;

    return-object v0
.end method

.method static synthetic i(Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment;)Ljava/util/List;
    .locals 1

    .prologue
    .line 113
    iget-object v0, p0, Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment;->c:Ljava/util/List;

    return-object v0
.end method

.method static synthetic j(Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment;)Lcom/jibo/ui/fragment/jibos/adapter/LoopMembersListAdapter;
    .locals 1

    .prologue
    .line 113
    iget-object v0, p0, Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment;->l:Lcom/jibo/ui/fragment/jibos/adapter/LoopMembersListAdapter;

    return-object v0
.end method

.method static synthetic k(Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment;)Lcom/jibo/aws/integration/aws/services/loop/model/Loop;
    .locals 1

    .prologue
    .line 113
    iget-object v0, p0, Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment;->k:Lcom/jibo/aws/integration/aws/services/loop/model/Loop;

    return-object v0
.end method

.method static synthetic l(Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment;)V
    .locals 0

    .prologue
    .line 113
    invoke-direct {p0}, Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment;->t()V

    return-void
.end method

.method static synthetic m(Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment;)Lcom/jibo/aws/integration/aws/services/loop/model/Loop;
    .locals 1

    .prologue
    .line 113
    iget-object v0, p0, Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment;->k:Lcom/jibo/aws/integration/aws/services/loop/model/Loop;

    return-object v0
.end method

.method static synthetic n(Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment;)V
    .locals 0

    .prologue
    .line 113
    invoke-direct {p0}, Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment;->x()V

    return-void
.end method

.method static synthetic o(Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment;)Lcom/jibo/aws/integration/aws/services/loop/model/Loop;
    .locals 1

    .prologue
    .line 113
    iget-object v0, p0, Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment;->k:Lcom/jibo/aws/integration/aws/services/loop/model/Loop;

    return-object v0
.end method

.method static synthetic p(Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment;)Lcom/jibo/aws/integration/aws/services/loop/model/Loop;
    .locals 1

    .prologue
    .line 113
    iget-object v0, p0, Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment;->k:Lcom/jibo/aws/integration/aws/services/loop/model/Loop;

    return-object v0
.end method

.method static synthetic q(Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment;)Lcom/jibo/aws/integration/aws/services/loop/model/Loop;
    .locals 1

    .prologue
    .line 113
    iget-object v0, p0, Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment;->k:Lcom/jibo/aws/integration/aws/services/loop/model/Loop;

    return-object v0
.end method

.method private q()V
    .locals 3

    .prologue
    .line 396
    invoke-static {}, Lcom/jibo/ui/helpers/skills/SkillsJsonParser;->getInstance()Lcom/jibo/ui/helpers/skills/SkillsJsonParser;

    move-result-object v0

    invoke-virtual {v0}, Lcom/jibo/ui/helpers/skills/SkillsJsonParser;->clearSkills()V

    .line 398
    new-instance v1, Lcom/jibo/ui/activity/SingleFragmentActivity$Builder;

    invoke-virtual {p0}, Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    const-class v2, Lcom/jibo/ui/fragment/account/AccountSettingsFragment;

    .line 399
    invoke-virtual {v2}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v2

    invoke-direct {v1, v0, v2}, Lcom/jibo/ui/activity/SingleFragmentActivity$Builder;-><init>(Landroid/content/Context;Ljava/lang/String;)V

    .line 400
    const-string v2, "ARG_LOOPS"

    invoke-virtual {p0}, Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    check-cast v0, Lcom/jibo/ui/activity/TabbedActivity;

    invoke-virtual {v0}, Lcom/jibo/ui/activity/TabbedActivity;->x()Ljava/util/ArrayList;

    move-result-object v0

    invoke-virtual {v1, v2, v0}, Lcom/jibo/ui/activity/SingleFragmentActivity$Builder;->a(Ljava/lang/String;Ljava/io/Serializable;)Lcom/jibo/ui/activity/SingleFragmentActivity$Builder;

    .line 401
    const/16 v0, 0x3e9

    invoke-virtual {v1, v0}, Lcom/jibo/ui/activity/SingleFragmentActivity$Builder;->a(I)V

    .line 402
    return-void
.end method

.method static synthetic r(Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment;)Ljava/util/List;
    .locals 1

    .prologue
    .line 113
    iget-object v0, p0, Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment;->e:Ljava/util/List;

    return-object v0
.end method

.method private declared-synchronized r()Z
    .locals 9

    .prologue
    const/4 v0, 0x0

    .line 598
    monitor-enter p0

    .line 599
    :try_start_0
    iget-object v2, p0, Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment;->k:Lcom/jibo/aws/integration/aws/services/loop/model/Loop;

    .line 600
    if-eqz v2, :cond_0

    invoke-virtual {p0}, Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v1

    invoke-static {v1}, Lcom/jibo/db/EntityData;->a(Landroid/content/Context;)Lcom/jibo/db/EntityData;

    move-result-object v1

    invoke-virtual {v1}, Lcom/jibo/db/EntityData;->i()Lcom/jibo/aws/integration/aws/services/account/model/Account;

    move-result-object v1

    invoke-virtual {v1}, Lcom/jibo/aws/integration/aws/services/account/model/Account;->getId()Ljava/lang/String;

    move-result-object v1

    invoke-static {v2, v1}, Lcom/jibo/aws/integration/helpers/LoopHelper;->isOwner(Lcom/jibo/aws/integration/aws/services/loop/model/Loop;Ljava/lang/String;)Z

    move-result v1

    if-eqz v1, :cond_0

    .line 601
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v1

    invoke-static {v1}, Lcom/jibo/utils/SharedPreferencesUtil;->h(Landroid/content/Context;)[Ljava/lang/String;

    move-result-object v3

    .line 603
    array-length v4, v3

    move v1, v0

    :goto_0
    if-ge v1, v4, :cond_0

    aget-object v5, v3, v1

    .line 604
    invoke-static {v2, v5}, Lcom/jibo/aws/integration/helpers/LoopHelper;->getMemberByIdOrEmail(Lcom/jibo/aws/integration/aws/services/loop/model/Loop;Ljava/lang/String;)Lcom/jibo/aws/integration/aws/services/loop/model/Member;

    move-result-object v6

    .line 607
    if-eqz v6, :cond_1

    invoke-virtual {v6}, Lcom/jibo/aws/integration/aws/services/loop/model/Member;->getStatus()Lcom/jibo/aws/integration/aws/services/loop/model/Member$InvitationStatus;

    move-result-object v7

    sget-object v8, Lcom/jibo/aws/integration/aws/services/loop/model/Member$InvitationStatus;->accepted:Lcom/jibo/aws/integration/aws/services/loop/model/Member$InvitationStatus;

    if-ne v7, v8, :cond_1

    .line 608
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment;->getFragmentManager()Landroid/support/v4/app/FragmentManager;

    move-result-object v7

    invoke-static {v7}, Lcom/jibo/ui/fragment/dialog/DialogUtils;->a(Landroid/support/v4/app/FragmentManager;)Z

    move-result v7

    if-nez v7, :cond_1

    .line 610
    const/4 v0, 0x1

    .line 613
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v1

    invoke-static {v1, v5}, Lcom/jibo/utils/SharedPreferencesUtil;->b(Landroid/content/Context;Ljava/lang/String;)V

    .line 616
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment;->c()Landroid/os/Handler;

    move-result-object v1

    new-instance v2, Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment$10;

    invoke-direct {v2, p0, v6}, Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment$10;-><init>(Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment;Lcom/jibo/aws/integration/aws/services/loop/model/Member;)V

    const-wide/16 v4, 0x1f4

    invoke-virtual {v1, v2, v4, v5}, Landroid/os/Handler;->postDelayed(Ljava/lang/Runnable;J)Z
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 631
    :cond_0
    monitor-exit p0

    return v0

    .line 603
    :cond_1
    add-int/lit8 v1, v1, 0x1

    goto :goto_0

    .line 598
    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method private s()V
    .locals 3

    .prologue
    .line 636
    :try_start_0
    iget-object v0, p0, Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment;->k:Lcom/jibo/aws/integration/aws/services/loop/model/Loop;

    if-eqz v0, :cond_1

    iget-object v0, p0, Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment;->n:Lcom/jibo/aws/integration/aws/services/notification/JiboNotificationAsyncClient;

    if-eqz v0, :cond_1

    .line 637
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment;->f()V

    .line 639
    iget-object v0, p0, Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment;->n:Lcom/jibo/aws/integration/aws/services/notification/JiboNotificationAsyncClient;

    iget-object v1, p0, Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment;->k:Lcom/jibo/aws/integration/aws/services/loop/model/Loop;

    invoke-virtual {v1}, Lcom/jibo/aws/integration/aws/services/loop/model/Loop;->getRobot()Ljava/lang/String;

    move-result-object v1

    new-instance v2, Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment$11;

    invoke-direct {v2, p0}, Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment$11;-><init>(Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment;)V

    invoke-virtual {v0, v1, v2}, Lcom/jibo/aws/integration/aws/services/notification/JiboNotificationAsyncClient;->getStatus(Ljava/lang/String;Lcom/amazonaws/handlers/AsyncHandler;)Ljava/util/concurrent/Future;

    .line 739
    :cond_0
    :goto_0
    return-void

    .line 713
    :cond_1
    iget-object v0, p0, Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment;->k:Lcom/jibo/aws/integration/aws/services/loop/model/Loop;

    if-eqz v0, :cond_0

    .line 714
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    invoke-static {v0}, Lcom/jibo/db/EntityData;->a(Landroid/content/Context;)Lcom/jibo/db/EntityData;

    move-result-object v0

    invoke-virtual {v0}, Lcom/jibo/db/EntityData;->g()Lcom/jibo/aws/integration/aws/services/robotProperties/JiboRobotPropertiesAsyncClient;

    move-result-object v0

    iget-object v1, p0, Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment;->k:Lcom/jibo/aws/integration/aws/services/loop/model/Loop;

    .line 715
    invoke-virtual {v1}, Lcom/jibo/aws/integration/aws/services/loop/model/Loop;->getRobotFriendlyId()Ljava/lang/String;

    move-result-object v1

    new-instance v2, Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment$12;

    invoke-direct {v2, p0}, Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment$12;-><init>(Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment;)V

    invoke-virtual {v0, v1, v2}, Lcom/jibo/aws/integration/aws/services/robotProperties/JiboRobotPropertiesAsyncClient;->getRobot(Ljava/lang/String;Lcom/amazonaws/handlers/AsyncHandler;)Ljava/util/concurrent/Future;
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    goto :goto_0

    .line 736
    :catch_0
    move-exception v0

    .line 737
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment;->g()V

    goto :goto_0
.end method

.method private t()V
    .locals 3

    .prologue
    .line 742
    iget-object v0, p0, Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment;->c:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v1

    :cond_0
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_1

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/jibo/ui/helpers/Items$Item;

    .line 743
    instance-of v2, v0, Lcom/jibo/ui/helpers/Items$JiboSettingsItem;

    if-eqz v2, :cond_0

    .line 744
    check-cast v0, Lcom/jibo/ui/helpers/Items$JiboSettingsItem;

    iget-object v1, p0, Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment;->t:Lcom/jibo/aws/integration/aws/services/robotProperties/model/Robot;

    invoke-virtual {v0, v1}, Lcom/jibo/ui/helpers/Items$JiboSettingsItem;->a(Lcom/jibo/aws/integration/aws/services/robotProperties/model/Robot;)V

    .line 749
    :cond_1
    iget-object v0, p0, Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment;->l:Lcom/jibo/ui/fragment/jibos/adapter/LoopMembersListAdapter;

    invoke-virtual {v0}, Lcom/jibo/ui/fragment/jibos/adapter/LoopMembersListAdapter;->notifyDataSetChanged()V

    .line 750
    return-void
.end method

.method private u()Z
    .locals 3

    .prologue
    .line 764
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment;->getContext()Landroid/content/Context;

    move-result-object v0

    .line 765
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v1

    invoke-static {v1}, Lcom/jibo/db/EntityData;->a(Landroid/content/Context;)Lcom/jibo/db/EntityData;

    move-result-object v1

    invoke-virtual {v1}, Lcom/jibo/db/EntityData;->i()Lcom/jibo/aws/integration/aws/services/account/model/Account;

    move-result-object v1

    invoke-virtual {v1}, Lcom/jibo/aws/integration/aws/services/account/model/Account;->getId()Ljava/lang/String;

    move-result-object v1

    .line 764
    invoke-static {v0, v1}, Lcom/jibo/aws/integration/util/KeyManager;->getInstance(Landroid/content/Context;Ljava/lang/String;)Lcom/jibo/aws/integration/util/KeyManager;

    move-result-object v0

    .line 769
    :try_start_0
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment;->getContext()Landroid/content/Context;

    move-result-object v1

    iget-object v2, p0, Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment;->k:Lcom/jibo/aws/integration/aws/services/loop/model/Loop;

    invoke-virtual {v2}, Lcom/jibo/aws/integration/aws/services/loop/model/Loop;->getId()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Lcom/jibo/aws/integration/util/KeyManager;->obtainKeyHolder(Landroid/content/Context;Ljava/lang/String;)Lcom/jibo/aws/integration/util/KeyManager$SymmetricKeyHolder;
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v0

    .line 774
    :goto_0
    if-eqz v0, :cond_0

    const/4 v0, 0x1

    :goto_1
    return v0

    .line 770
    :catch_0
    move-exception v0

    .line 771
    const/4 v0, 0x0

    goto :goto_0

    .line 774
    :cond_0
    const/4 v0, 0x0

    goto :goto_1
.end method

.method private v()V
    .locals 2

    .prologue
    .line 778
    iget-object v0, p0, Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment;->loopSuspendedView:Landroid/view/View;

    const/16 v1, 0x8

    invoke-virtual {v0, v1}, Landroid/view/View;->setVisibility(I)V

    .line 779
    iget-object v0, p0, Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment;->list:Landroid/support/v7/widget/RecyclerView;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroid/support/v7/widget/RecyclerView;->setVisibility(I)V

    .line 780
    return-void
.end method

.method private w()V
    .locals 11

    .prologue
    .line 792
    iget-object v0, p0, Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment;->k:Lcom/jibo/aws/integration/aws/services/loop/model/Loop;

    if-nez v0, :cond_1

    .line 900
    :cond_0
    :goto_0
    return-void

    .line 795
    :cond_1
    :try_start_0
    iget-object v0, p0, Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment;->k:Lcom/jibo/aws/integration/aws/services/loop/model/Loop;

    invoke-static {v0}, Lcom/jibo/aws/integration/helpers/LoopHelper;->getOwner(Lcom/jibo/aws/integration/aws/services/loop/model/Loop;)Lcom/jibo/aws/integration/aws/services/loop/model/Member;

    move-result-object v1

    .line 796
    iget-object v0, p0, Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment;->k:Lcom/jibo/aws/integration/aws/services/loop/model/Loop;

    .line 797
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v2

    invoke-static {v2}, Lcom/jibo/db/EntityData;->a(Landroid/content/Context;)Lcom/jibo/db/EntityData;

    move-result-object v2

    invoke-virtual {v2}, Lcom/jibo/db/EntityData;->i()Lcom/jibo/aws/integration/aws/services/account/model/Account;

    move-result-object v2

    .line 796
    invoke-static {v0, v2}, Lcom/jibo/aws/integration/helpers/LoopHelper;->getMemberForAccount(Lcom/jibo/aws/integration/aws/services/loop/model/Loop;Lcom/jibo/aws/integration/aws/services/account/model/Account;)Lcom/jibo/aws/integration/aws/services/loop/model/Member;

    move-result-object v2

    .line 798
    iget-object v0, p0, Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment;->k:Lcom/jibo/aws/integration/aws/services/loop/model/Loop;

    invoke-virtual {v2}, Lcom/jibo/aws/integration/aws/services/loop/model/Member;->getAccountId()Ljava/lang/String;

    move-result-object v3

    invoke-static {v0, v3}, Lcom/jibo/aws/integration/helpers/LoopHelper;->isOwner(Lcom/jibo/aws/integration/aws/services/loop/model/Loop;Ljava/lang/String;)Z

    move-result v3

    .line 800
    iget-object v0, p0, Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment;->k:Lcom/jibo/aws/integration/aws/services/loop/model/Loop;

    invoke-static {v0, v2}, Lcom/jibo/aws/integration/helpers/LoopHelper;->sortMembers(Lcom/jibo/aws/integration/aws/services/loop/model/Loop;Lcom/jibo/aws/integration/aws/services/loop/model/Member;)Ljava/util/List;

    move-result-object v0

    .line 802
    iget-object v4, p0, Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment;->k:Lcom/jibo/aws/integration/aws/services/loop/model/Loop;

    invoke-static {v4}, Lcom/jibo/aws/integration/helpers/LoopHelper;->getUnenrolledMembersCount(Lcom/jibo/aws/integration/aws/services/loop/model/Loop;)I

    move-result v4

    .line 803
    iget-object v5, p0, Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment;->k:Lcom/jibo/aws/integration/aws/services/loop/model/Loop;

    invoke-static {v5}, Lcom/jibo/aws/integration/helpers/LoopHelper;->getFirstUnenrolledMember(Lcom/jibo/aws/integration/aws/services/loop/model/Loop;)Lcom/jibo/aws/integration/aws/services/loop/model/Member;

    move-result-object v5

    .line 805
    new-instance v6, Ljava/util/ArrayList;

    invoke-direct {v6}, Ljava/util/ArrayList;-><init>()V

    .line 808
    invoke-interface {v0}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v7

    :goto_1
    invoke-interface {v7}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_2

    invoke-interface {v7}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/jibo/aws/integration/aws/services/loop/model/Member;

    .line 809
    new-instance v8, Lcom/jibo/ui/helpers/Items$MemberItem;

    iget-object v9, p0, Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment;->q:Landroid/view/View$OnClickListener;

    iget-object v10, p0, Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment;->k:Lcom/jibo/aws/integration/aws/services/loop/model/Loop;

    invoke-direct {v8, v9, v10, v0}, Lcom/jibo/ui/helpers/Items$MemberItem;-><init>(Landroid/view/View$OnClickListener;Lcom/jibo/aws/integration/aws/services/loop/model/Loop;Lcom/jibo/aws/integration/aws/services/loop/model/Member;)V

    invoke-interface {v6, v8}, Ljava/util/List;->add(Ljava/lang/Object;)Z
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    goto :goto_1

    .line 897
    :catch_0
    move-exception v0

    .line 898
    sget-object v1, Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment;->f:Ljava/lang/String;

    const-string v2, "Exception: "

    invoke-static {v1, v2, v0}, Lcom/jibo/utils/LogUtils;->a(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V

    goto :goto_0

    .line 812
    :cond_2
    :try_start_1
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment;->d()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 815
    new-instance v7, Ljava/util/ArrayList;

    invoke-direct {v7}, Ljava/util/ArrayList;-><init>()V

    .line 819
    iget-object v0, p0, Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment;->k:Lcom/jibo/aws/integration/aws/services/loop/model/Loop;

    invoke-static {v0}, Lcom/jibo/aws/integration/helpers/LoopHelper;->getActiveMembersCount(Lcom/jibo/aws/integration/aws/services/loop/model/Loop;)I

    move-result v0

    .line 821
    if-eqz v3, :cond_8

    .line 824
    if-lez v4, :cond_3

    .line 825
    if-nez v5, :cond_6

    invoke-virtual {v1}, Lcom/jibo/aws/integration/aws/services/loop/model/Member;->getAccount()Lcom/jibo/aws/integration/aws/services/loop/model/MemberAccount;

    move-result-object v1

    invoke-virtual {v1}, Lcom/jibo/aws/integration/aws/services/loop/model/MemberAccount;->getFirstName()Ljava/lang/String;

    .line 830
    :cond_3
    :goto_2
    const-string v1, ""

    .line 832
    const/16 v1, 0x10

    if-lt v0, v1, :cond_7

    .line 834
    const v0, 0x7f1001af

    invoke-virtual {p0, v0}, Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment;->getString(I)Ljava/lang/String;

    move-result-object v0

    .line 855
    :goto_3
    new-instance v1, Landroid/text/SpannableStringBuilder;

    invoke-direct {v1, v0}, Landroid/text/SpannableStringBuilder;-><init>(Ljava/lang/CharSequence;)V

    .line 856
    new-instance v2, Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment$WhyTextClickableSpan;

    .line 857
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v3

    invoke-virtual {v3}, Landroid/support/v4/app/FragmentActivity;->getApplicationContext()Landroid/content/Context;

    move-result-object v3

    new-instance v4, Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment$14;

    invoke-direct {v4, p0}, Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment$14;-><init>(Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment;)V

    invoke-direct {v2, v3, v4}, Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment$WhyTextClickableSpan;-><init>(Landroid/content/Context;Landroid/view/View$OnClickListener;)V

    .line 863
    invoke-virtual {v0}, Ljava/lang/String;->length()I

    move-result v3

    add-int/lit8 v3, v3, -0x4

    invoke-virtual {v0}, Ljava/lang/String;->length()I

    move-result v0

    const/16 v4, 0x12

    invoke-virtual {v1, v2, v3, v0, v4}, Landroid/text/SpannableStringBuilder;->setSpan(Ljava/lang/Object;III)V

    .line 875
    :cond_4
    :goto_4
    iget-boolean v0, p0, Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment;->a:Z

    if-eqz v0, :cond_5

    .line 876
    invoke-direct {p0}, Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment;->b()V

    .line 879
    :cond_5
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment;->d()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 881
    invoke-interface {v7}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v1

    :goto_5
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_9

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/CharSequence;

    .line 882
    new-instance v2, Lcom/jibo/ui/helpers/Items$FooterItem;

    invoke-direct {v2, v0}, Lcom/jibo/ui/helpers/Items$FooterItem;-><init>(Ljava/lang/CharSequence;)V

    invoke-interface {v6, v2}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    goto :goto_5

    .line 826
    :cond_6
    invoke-virtual {v5}, Lcom/jibo/aws/integration/aws/services/loop/model/Member;->getAccount()Lcom/jibo/aws/integration/aws/services/loop/model/MemberAccount;

    move-result-object v1

    invoke-virtual {v1}, Lcom/jibo/aws/integration/aws/services/loop/model/MemberAccount;->getFirstName()Ljava/lang/String;

    goto :goto_2

    .line 839
    :cond_7
    new-instance v1, Lcom/jibo/ui/helpers/Items$SimpleItem;

    sget-object v2, Lcom/jibo/ui/helpers/Items$ItemType;->invite:Lcom/jibo/ui/helpers/Items$ItemType;

    new-instance v3, Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment$13;

    invoke-direct {v3, p0}, Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment$13;-><init>(Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment;)V

    invoke-direct {v1, v2, v3}, Lcom/jibo/ui/helpers/Items$SimpleItem;-><init>(Lcom/jibo/ui/helpers/Items$ItemType;Landroid/view/View$OnClickListener;)V

    invoke-interface {v6, v1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 850
    const v1, 0x7f1001ae

    invoke-virtual {p0, v1}, Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment;->getString(I)Ljava/lang/String;

    move-result-object v1

    const/4 v2, 0x1

    new-array v2, v2, [Ljava/lang/Object;

    const/4 v3, 0x0

    rsub-int/lit8 v0, v0, 0x10

    .line 851
    invoke-static {v0}, Ljava/lang/String;->valueOf(I)Ljava/lang/String;

    move-result-object v0

    aput-object v0, v2, v3

    .line 850
    invoke-static {v1, v2}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v0

    goto :goto_3

    .line 869
    :cond_8
    invoke-virtual {v2}, Lcom/jibo/aws/integration/aws/services/loop/model/Member;->isEnrolled()Z

    move-result v0

    if-nez v0, :cond_4

    goto :goto_4

    .line 885
    :cond_9
    iget-object v0, p0, Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment;->c:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->clear()V

    .line 888
    iget-object v0, p0, Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment;->c:Ljava/util/List;

    invoke-direct {p0, v0}, Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment;->a(Ljava/util/Collection;)V

    .line 889
    iget-object v0, p0, Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment;->c:Ljava/util/List;

    new-instance v1, Lcom/jibo/ui/helpers/Items$SubheaderItem;

    const v2, 0x7f100158

    invoke-direct {v1, v2}, Lcom/jibo/ui/helpers/Items$SubheaderItem;-><init>(I)V

    invoke-interface {v0, v1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 891
    iget-object v0, p0, Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment;->c:Ljava/util/List;

    invoke-interface {v0, v6}, Ljava/util/List;->addAll(Ljava/util/Collection;)Z

    .line 892
    iget-object v0, p0, Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment;->l:Lcom/jibo/ui/fragment/jibos/adapter/LoopMembersListAdapter;

    invoke-virtual {v0}, Lcom/jibo/ui/fragment/jibos/adapter/LoopMembersListAdapter;->notifyDataSetChanged()V

    .line 894
    invoke-direct {p0}, Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment;->s()V

    .line 896
    invoke-direct {p0}, Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment;->z()V
    :try_end_1
    .catch Ljava/lang/Exception; {:try_start_1 .. :try_end_1} :catch_0

    goto/16 :goto_0
.end method

.method private x()V
    .locals 3

    .prologue
    .line 903
    const/16 v0, 0x6e

    const v1, 0x7f10010d

    .line 904
    invoke-virtual {p0, v1}, Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment;->getString(I)Ljava/lang/String;

    move-result-object v1

    const v2, 0x7f10010c

    .line 905
    invoke-virtual {p0, v2}, Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment;->getString(I)Ljava/lang/String;

    move-result-object v2

    .line 903
    invoke-static {p0, v0, v1, v2}, Lcom/jibo/ui/fragment/dialog/DialogUtils;->d(Landroid/support/v4/app/Fragment;ILjava/lang/String;Ljava/lang/String;)V

    .line 906
    return-void
.end method

.method private y()J
    .locals 2

    .prologue
    .line 1034
    const-wide/16 v0, 0x0

    .line 1035
    return-wide v0
.end method

.method private z()V
    .locals 6

    .prologue
    const/4 v2, 0x1

    .line 1042
    iget-object v0, p0, Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment;->d:Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment$LoadAttributionsAsyncTask;

    if-eqz v0, :cond_0

    .line 1043
    iget-object v0, p0, Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment;->d:Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment$LoadAttributionsAsyncTask;

    invoke-virtual {v0, v2}, Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment$LoadAttributionsAsyncTask;->cancel(Z)Z

    .line 1045
    :cond_0
    new-instance v0, Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment$LoadAttributionsAsyncTask;

    const/4 v1, 0x0

    invoke-direct {v0, p0, v1}, Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment$LoadAttributionsAsyncTask;-><init>(Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment;Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment$1;)V

    iput-object v0, p0, Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment;->d:Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment$LoadAttributionsAsyncTask;

    .line 1046
    iget-object v0, p0, Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment;->d:Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment$LoadAttributionsAsyncTask;

    new-array v1, v2, [Ljava/lang/Long;

    const/4 v2, 0x0

    invoke-direct {p0}, Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment;->y()J

    move-result-wide v4

    invoke-static {v4, v5}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v3

    aput-object v3, v1, v2

    invoke-virtual {v0, v1}, Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment$LoadAttributionsAsyncTask;->execute([Ljava/lang/Object;)Landroid/os/AsyncTask;

    .line 1047
    return-void
.end method


# virtual methods
.method public a(ILandroid/os/Bundle;)Landroid/support/v4/content/Loader;
    .locals 12
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(I",
            "Landroid/os/Bundle;",
            ")",
            "Landroid/support/v4/content/Loader",
            "<",
            "Landroid/database/Cursor;",
            ">;"
        }
    .end annotation

    .prologue
    const/4 v4, 0x0

    .line 426
    sparse-switch p1, :sswitch_data_0

    move-object v0, v4

    .line 453
    :goto_0
    return-object v0

    .line 428
    :sswitch_0
    new-instance v0, Landroid/support/v4/content/CursorLoader;

    invoke-virtual {p0}, Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v1

    const/16 v2, 0x8

    invoke-static {v2}, Lcom/jibo/db/DatabaseContract$EntityEntry;->a(I)Landroid/net/Uri;

    move-result-object v2

    sget-object v3, Lcom/jibo/db/DatabaseContract$EntityEntry;->a:[Ljava/lang/String;

    const-string v6, "_id"

    move-object v5, v4

    invoke-direct/range {v0 .. v6}, Landroid/support/v4/content/CursorLoader;-><init>(Landroid/content/Context;Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_0

    .line 434
    :sswitch_1
    new-instance v0, Ljava/lang/StringBuilder;

    const-string v1, "_id"

    invoke-direct {v0, v1}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    const-string v1, " IN ("

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    .line 435
    iget-object v2, p0, Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment;->k:Lcom/jibo/aws/integration/aws/services/loop/model/Loop;

    const/4 v0, 0x1

    new-array v3, v0, [Ljava/lang/String;

    const/4 v5, 0x0

    iget-object v0, p0, Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment;->k:Lcom/jibo/aws/integration/aws/services/loop/model/Loop;

    .line 438
    invoke-virtual {v0}, Lcom/jibo/aws/integration/aws/services/loop/model/Loop;->getRobot()Ljava/lang/String;

    move-result-object v0

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment;->k:Lcom/jibo/aws/integration/aws/services/loop/model/Loop;

    invoke-virtual {v0}, Lcom/jibo/aws/integration/aws/services/loop/model/Loop;->getRobot()Ljava/lang/String;

    move-result-object v0

    :goto_1
    aput-object v0, v3, v5

    .line 435
    invoke-static {v2, v4, v3}, Lcom/jibo/aws/integration/helpers/LoopHelper;->getAccountIds(Lcom/jibo/aws/integration/aws/services/loop/model/Loop;Lcom/jibo/aws/integration/aws/services/loop/model/Member$InvitationStatus;[Ljava/lang/String;)Ljava/util/List;

    move-result-object v0

    .line 439
    invoke-interface {v0}, Ljava/util/List;->size()I

    move-result v2

    if-lez v2, :cond_1

    .line 440
    const-string v2, "\'"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, "\',\'"

    invoke-static {v3, v0}, Landroid/text/TextUtils;->join(Ljava/lang/CharSequence;Ljava/lang/Iterable;)Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v2, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v2, "\')"

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 446
    :goto_2
    new-instance v5, Landroid/support/v4/content/CursorLoader;

    invoke-virtual {p0}, Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v6

    const/4 v0, 0x2

    invoke-static {v0}, Lcom/jibo/db/DatabaseContract$EntityEntry;->a(I)Landroid/net/Uri;

    move-result-object v7

    sget-object v8, Lcom/jibo/db/DatabaseContract$EntityEntry;->a:[Ljava/lang/String;

    .line 449
    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v9

    const-string v11, "_id"

    move-object v10, v4

    invoke-direct/range {v5 .. v11}, Landroid/support/v4/content/CursorLoader;-><init>(Landroid/content/Context;Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)V

    move-object v0, v5

    goto :goto_0

    .line 438
    :cond_0
    const-string v0, ""

    goto :goto_1

    .line 443
    :cond_1
    const-string v0, "\'\')"

    invoke-virtual {v1, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    goto :goto_2

    .line 426
    nop

    :sswitch_data_0
    .sparse-switch
        0x7f0901c0 -> :sswitch_1
        0x7f0901c5 -> :sswitch_0
    .end sparse-switch
.end method

.method public a(IILjava/lang/Object;)V
    .locals 6

    .prologue
    const/4 v5, 0x1

    const/4 v4, 0x0

    .line 537
    invoke-super {p0, p1, p2, p3}, Lcom/jibo/ui/fragment/BaseFragment;->a(IILjava/lang/Object;)V

    .line 538
    const/16 v0, 0x78

    if-ne p1, v0, :cond_1

    const/4 v0, -0x1

    if-ne p2, v0, :cond_1

    if-eqz p3, :cond_1

    .line 541
    new-instance v0, Lcom/jibo/ui/activity/SingleFragmentActivity$Builder;

    const-class v1, Lcom/jibo/ui/fragment/invite/NameBirthdayGenderFragment;

    .line 542
    invoke-virtual {v1}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, p0, v1}, Lcom/jibo/ui/activity/SingleFragmentActivity$Builder;-><init>(Landroid/support/v4/app/Fragment;Ljava/lang/String;)V

    .line 543
    const-string v1, "ARG_IS_CHILD"

    invoke-virtual {v0, v1, v5}, Lcom/jibo/ui/activity/SingleFragmentActivity$Builder;->a(Ljava/lang/String;Z)Lcom/jibo/ui/activity/SingleFragmentActivity$Builder;

    .line 544
    const-class v1, Lcom/jibo/aws/integration/aws/services/loop/model/Loop;

    invoke-virtual {v1}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v1

    iget-object v2, p0, Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment;->k:Lcom/jibo/aws/integration/aws/services/loop/model/Loop;

    invoke-virtual {v0, v1, v2}, Lcom/jibo/ui/activity/SingleFragmentActivity$Builder;->a(Ljava/lang/String;Landroid/os/Parcelable;)Lcom/jibo/ui/activity/SingleFragmentActivity$Builder;

    .line 545
    const-class v1, Lcom/jibo/aws/integration/aws/services/loop/model/Member;

    invoke-virtual {v1}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v1

    check-cast p3, Landroid/os/Parcelable;

    invoke-virtual {v0, v1, p3}, Lcom/jibo/ui/activity/SingleFragmentActivity$Builder;->a(Ljava/lang/String;Landroid/os/Parcelable;)Lcom/jibo/ui/activity/SingleFragmentActivity$Builder;

    .line 546
    const/16 v1, 0x3ed

    invoke-virtual {v0, v1}, Lcom/jibo/ui/activity/SingleFragmentActivity$Builder;->a(I)V

    .line 573
    :cond_0
    :goto_0
    return-void

    .line 548
    :cond_1
    const/16 v0, 0x74

    if-ne p1, v0, :cond_2

    .line 550
    iget-object v0, p0, Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment;->k:Lcom/jibo/aws/integration/aws/services/loop/model/Loop;

    invoke-virtual {v0}, Lcom/jibo/aws/integration/aws/services/loop/model/Loop;->getId()Ljava/lang/String;

    move-result-object v0

    iget-object v1, p0, Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment;->p:Lcom/jibo/aws/integration/aws/services/loop/model/Member;

    invoke-virtual {v1}, Lcom/jibo/aws/integration/aws/services/loop/model/Member;->getId()Ljava/lang/String;

    move-result-object v1

    iget-object v2, p0, Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment;->p:Lcom/jibo/aws/integration/aws/services/loop/model/Member;

    invoke-virtual {v2}, Lcom/jibo/aws/integration/aws/services/loop/model/Member;->getAccount()Lcom/jibo/aws/integration/aws/services/loop/model/MemberAccount;

    move-result-object v2

    invoke-virtual {v2}, Lcom/jibo/aws/integration/aws/services/loop/model/MemberAccount;->getFirstName()Ljava/lang/String;

    move-result-object v2

    invoke-direct {p0, v0, v1, v2}, Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment;->a(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_0

    .line 552
    :cond_2
    const/16 v0, 0x7c

    if-ne p1, v0, :cond_0

    .line 555
    invoke-static {}, Lcom/jibo/ui/helpers/skills/SkillsJsonParser;->getInstance()Lcom/jibo/ui/helpers/skills/SkillsJsonParser;

    move-result-object v0

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Lcom/jibo/ui/helpers/skills/SkillsJsonParser;->getViews([I)Ljava/util/List;

    move-result-object v0

    invoke-interface {v0, v4}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/jibo/ui/helpers/skills/DataItems$DataItem;

    .line 557
    instance-of v1, v0, Lcom/jibo/ui/helpers/skills/DataItems$GroupDataItem;

    if-eqz v1, :cond_3

    move-object v1, v0

    check-cast v1, Lcom/jibo/ui/helpers/skills/DataItems$GroupDataItem;

    .line 558
    invoke-virtual {v1}, Lcom/jibo/ui/helpers/skills/DataItems$GroupDataItem;->getChildViews()Ljava/util/List;

    move-result-object v1

    if-eqz v1, :cond_0

    move-object v1, v0

    check-cast v1, Lcom/jibo/ui/helpers/skills/DataItems$GroupDataItem;

    .line 559
    invoke-virtual {v1}, Lcom/jibo/ui/helpers/skills/DataItems$GroupDataItem;->getChildViews()Ljava/util/List;

    move-result-object v1

    invoke-interface {v1}, Ljava/util/List;->isEmpty()Z

    move-result v1

    if-nez v1, :cond_0

    .line 561
    :cond_3
    invoke-static {}, Lcom/jibo/ui/helpers/skills/SkillsJsonParser;->getInstance()Lcom/jibo/ui/helpers/skills/SkillsJsonParser;

    move-result-object v1

    invoke-virtual {v1, v4}, Lcom/jibo/ui/helpers/skills/SkillsJsonParser;->selectSkill(I)V

    .line 563
    new-instance v1, Lcom/jibo/ui/activity/SingleFragmentActivity$Builder;

    .line 564
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment;->getContext()Landroid/content/Context;

    move-result-object v2

    const-class v3, Lcom/jibo/ui/fragment/account/skills/SkillSettingsFragment;

    invoke-virtual {v3}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v3

    invoke-direct {v1, v2, v3}, Lcom/jibo/ui/activity/SingleFragmentActivity$Builder;-><init>(Landroid/content/Context;Ljava/lang/String;)V

    const-string v2, "PARAM_PATH"

    new-array v3, v5, [I

    aput v4, v3, v4

    .line 565
    invoke-virtual {v1, v2, v3}, Lcom/jibo/ui/activity/SingleFragmentActivity$Builder;->a(Ljava/lang/String;Ljava/io/Serializable;)Lcom/jibo/ui/activity/SingleFragmentActivity$Builder;

    move-result-object v1

    const-string v2, "PARAM_TITLE"

    .line 566
    invoke-virtual {v0}, Lcom/jibo/ui/helpers/skills/DataItems$DataItem;->getTitle()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v1, v2, v0}, Lcom/jibo/ui/activity/SingleFragmentActivity$Builder;->a(Ljava/lang/String;Ljava/io/Serializable;)Lcom/jibo/ui/activity/SingleFragmentActivity$Builder;

    move-result-object v0

    .line 567
    const/16 v1, 0x3e9

    invoke-virtual {v0, v1}, Lcom/jibo/ui/activity/SingleFragmentActivity$Builder;->a(I)V

    goto :goto_0
.end method

.method public a(Landroid/support/v4/content/Loader;)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/support/v4/content/Loader",
            "<",
            "Landroid/database/Cursor;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 528
    return-void
.end method

.method public a(Landroid/support/v4/content/Loader;Landroid/database/Cursor;)V
    .locals 4
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/support/v4/content/Loader",
            "<",
            "Landroid/database/Cursor;",
            ">;",
            "Landroid/database/Cursor;",
            ")V"
        }
    .end annotation

    .prologue
    const/4 v3, 0x0

    const v2, 0x7f0901c0

    .line 465
    invoke-virtual {p1}, Landroid/support/v4/content/Loader;->n()I

    move-result v0

    const v1, 0x7f0901c5

    if-ne v0, v1, :cond_1

    invoke-virtual {p0}, Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment;->d()Z

    move-result v0

    if-eqz v0, :cond_1

    .line 467
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    invoke-static {v0}, Lcom/jibo/utils/SharedPreferencesUtil;->f(Landroid/content/Context;)Lcom/jibo/aws/integration/aws/services/loop/model/Loop;

    move-result-object v0

    iput-object v0, p0, Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment;->k:Lcom/jibo/aws/integration/aws/services/loop/model/Loop;

    .line 468
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment;->d()Z

    move-result v0

    if-eqz v0, :cond_0

    invoke-virtual {p0}, Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    check-cast v0, Lcom/jibo/ui/activity/BaseActivity;

    invoke-virtual {v0}, Lcom/jibo/ui/activity/BaseActivity;->getSupportActionBar()Landroid/support/v7/app/ActionBar;

    move-result-object v0

    if-eqz v0, :cond_0

    .line 469
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    check-cast v0, Lcom/jibo/ui/activity/BaseActivity;

    invoke-virtual {v0}, Lcom/jibo/ui/activity/BaseActivity;->getSupportActionBar()Landroid/support/v7/app/ActionBar;

    move-result-object v0

    invoke-virtual {p0}, Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment;->o()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/support/v7/app/ActionBar;->setTitle(Ljava/lang/CharSequence;)V

    .line 474
    :cond_0
    iget-object v0, p0, Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment;->k:Lcom/jibo/aws/integration/aws/services/loop/model/Loop;

    if-eqz v0, :cond_1

    .line 475
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment;->getLoaderManager()Landroid/support/v4/app/LoaderManager;

    move-result-object v0

    invoke-virtual {v0, v2}, Landroid/support/v4/app/LoaderManager;->b(I)Landroid/support/v4/content/Loader;

    move-result-object v0

    if-eqz v0, :cond_2

    .line 476
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment;->getLoaderManager()Landroid/support/v4/app/LoaderManager;

    move-result-object v0

    invoke-virtual {v0, v2, v3, p0}, Landroid/support/v4/app/LoaderManager;->b(ILandroid/os/Bundle;Landroid/support/v4/app/LoaderManager$LoaderCallbacks;)Landroid/support/v4/content/Loader;

    .line 481
    :goto_0
    iget-object v0, p0, Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment;->k:Lcom/jibo/aws/integration/aws/services/loop/model/Loop;

    invoke-virtual {v0}, Lcom/jibo/aws/integration/aws/services/loop/model/Loop;->isSuspended()Ljava/lang/Boolean;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v0

    if-eqz v0, :cond_3

    .line 482
    iget-object v0, p0, Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment;->k:Lcom/jibo/aws/integration/aws/services/loop/model/Loop;

    invoke-virtual {p0}, Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment;->getContext()Landroid/content/Context;

    move-result-object v1

    invoke-static {v1}, Lcom/jibo/db/EntityData;->a(Landroid/content/Context;)Lcom/jibo/db/EntityData;

    move-result-object v1

    invoke-virtual {v1}, Lcom/jibo/db/EntityData;->i()Lcom/jibo/aws/integration/aws/services/account/model/Account;

    move-result-object v1

    invoke-virtual {v1}, Lcom/jibo/aws/integration/aws/services/account/model/Account;->getId()Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Lcom/jibo/aws/integration/helpers/LoopHelper;->isOwner(Lcom/jibo/aws/integration/aws/services/loop/model/Loop;Ljava/lang/String;)Z

    move-result v0

    invoke-direct {p0, v0}, Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment;->b(Z)V

    .line 524
    :cond_1
    :goto_1
    return-void

    .line 478
    :cond_2
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment;->getLoaderManager()Landroid/support/v4/app/LoaderManager;

    move-result-object v0

    invoke-virtual {v0, v2, v3, p0}, Landroid/support/v4/app/LoaderManager;->a(ILandroid/os/Bundle;Landroid/support/v4/app/LoaderManager$LoaderCallbacks;)Landroid/support/v4/content/Loader;

    goto :goto_0

    .line 484
    :cond_3
    invoke-direct {p0}, Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment;->v()V

    .line 486
    iget-object v0, p0, Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment;->l:Lcom/jibo/ui/fragment/jibos/adapter/LoopMembersListAdapter;

    iget-object v1, p0, Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment;->k:Lcom/jibo/aws/integration/aws/services/loop/model/Loop;

    invoke-virtual {v0, v1}, Lcom/jibo/ui/fragment/jibos/adapter/LoopMembersListAdapter;->a(Lcom/jibo/aws/integration/aws/services/loop/model/Loop;)V

    .line 488
    invoke-direct {p0}, Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment;->w()V

    .line 490
    invoke-direct {p0}, Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment;->A()V

    .line 504
    invoke-direct {p0}, Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment;->r()Z

    move-result v0

    if-nez v0, :cond_1

    .line 505
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment;->getFragmentManager()Landroid/support/v4/app/FragmentManager;

    move-result-object v0

    const-class v1, Lcom/jibo/ui/fragment/dialog/HolidaysPopupFragment;

    invoke-virtual {v1}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/support/v4/app/FragmentManager;->a(Ljava/lang/String;)Landroid/support/v4/app/Fragment;

    move-result-object v0

    if-nez v0, :cond_1

    .line 508
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    .line 509
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v1

    invoke-static {v1}, Lcom/jibo/utils/SharedPreferencesUtil;->o(Landroid/content/Context;)[Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Ljava/util/Collections;->addAll(Ljava/util/Collection;[Ljava/lang/Object;)Z

    .line 510
    iget-object v1, p0, Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment;->k:Lcom/jibo/aws/integration/aws/services/loop/model/Loop;

    invoke-virtual {v1}, Lcom/jibo/aws/integration/aws/services/loop/model/Loop;->getId()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/util/ArrayList;->indexOf(Ljava/lang/Object;)I

    move-result v0

    const/4 v1, -0x1

    if-le v0, v1, :cond_1

    .line 511
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment;->c()Landroid/os/Handler;

    move-result-object v0

    new-instance v1, Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment$9;

    invoke-direct {v1, p0}, Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment$9;-><init>(Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment;)V

    const-wide/16 v2, 0x1f4

    invoke-virtual {v0, v1, v2, v3}, Landroid/os/Handler;->postDelayed(Ljava/lang/Runnable;J)Z

    goto :goto_1
.end method

.method public bridge synthetic a(Landroid/support/v4/content/Loader;Ljava/lang/Object;)V
    .locals 0

    .prologue
    .line 113
    check-cast p2, Landroid/database/Cursor;

    invoke-virtual {p0, p1, p2}, Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment;->a(Landroid/support/v4/content/Loader;Landroid/database/Cursor;)V

    return-void
.end method

.method public a(Lcom/jibo/aws/integration/aws/services/loop/model/Loop;)V
    .locals 2

    .prologue
    .line 1018
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    iget-object v1, p0, Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment;->k:Lcom/jibo/aws/integration/aws/services/loop/model/Loop;

    invoke-static {v0, v1}, Lcom/jibo/ui/activity/WifiActivity;->a(Landroid/app/Activity;Lcom/jibo/aws/integration/aws/services/loop/model/Loop;)V

    .line 1019
    return-void
.end method

.method public b(Landroid/os/Bundle;)V
    .locals 1

    .prologue
    .line 290
    invoke-super {p0, p1}, Lcom/jibo/ui/fragment/BaseFragment;->b(Landroid/os/Bundle;)V

    .line 291
    const-string v0, "ARGS_IS_IN_TUTORIAL_MODE"

    invoke-virtual {p1, v0}, Landroid/os/Bundle;->getBoolean(Ljava/lang/String;)Z

    move-result v0

    iput-boolean v0, p0, Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment;->a:Z

    .line 292
    return-void
.end method

.method public n_()V
    .locals 4

    .prologue
    .line 407
    iget-object v0, p0, Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment;->k:Lcom/jibo/aws/integration/aws/services/loop/model/Loop;

    if-nez v0, :cond_0

    .line 408
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    invoke-static {v0}, Lcom/jibo/service/SyncHelper;->b(Landroid/content/Context;)V

    .line 414
    :goto_0
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment;->getView()Landroid/view/View;

    move-result-object v0

    new-instance v1, Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment$8;

    invoke-direct {v1, p0}, Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment$8;-><init>(Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment;)V

    const-wide/16 v2, 0x5dc

    invoke-virtual {v0, v1, v2, v3}, Landroid/view/View;->postDelayed(Ljava/lang/Runnable;J)Z

    .line 422
    return-void

    .line 410
    :cond_0
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    iget-object v1, p0, Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment;->k:Lcom/jibo/aws/integration/aws/services/loop/model/Loop;

    invoke-virtual {v1}, Lcom/jibo/aws/integration/aws/services/loop/model/Loop;->getId()Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Lcom/jibo/service/SyncHelper;->a(Landroid/content/Context;Ljava/lang/String;)V

    goto :goto_0
.end method

.method public o()Ljava/lang/String;
    .locals 1

    .prologue
    .line 532
    iget-object v0, p0, Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment;->k:Lcom/jibo/aws/integration/aws/services/loop/model/Loop;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment;->k:Lcom/jibo/aws/integration/aws/services/loop/model/Loop;

    invoke-virtual {v0}, Lcom/jibo/aws/integration/aws/services/loop/model/Loop;->getName()Ljava/lang/String;

    move-result-object v0

    :goto_0
    return-object v0

    :cond_0
    const-string v0, ""

    goto :goto_0
.end method

.method public onActivityResult(IILandroid/content/Intent;)V
    .locals 3

    .prologue
    const/16 v1, 0x3ed

    .line 357
    invoke-super {p0, p1, p2, p3}, Lcom/jibo/ui/fragment/BaseFragment;->onActivityResult(IILandroid/content/Intent;)V

    .line 358
    const/4 v0, -0x1

    if-ne p2, v0, :cond_1

    .line 359
    const/16 v0, 0x3ef

    if-eq p1, v0, :cond_0

    if-ne p1, v1, :cond_2

    .line 361
    :cond_0
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment;->n_()V

    .line 365
    if-ne p1, v1, :cond_1

    if-eqz p3, :cond_1

    invoke-virtual {p3}, Landroid/content/Intent;->getExtras()Landroid/os/Bundle;

    move-result-object v0

    if-eqz v0, :cond_1

    .line 366
    invoke-virtual {p3}, Landroid/content/Intent;->getExtras()Landroid/os/Bundle;

    move-result-object v0

    const-class v1, Lcom/jibo/aws/integration/aws/services/loop/model/Member;

    invoke-virtual {v1}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/os/Bundle;->containsKey(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_1

    .line 367
    invoke-virtual {p3}, Landroid/content/Intent;->getExtras()Landroid/os/Bundle;

    move-result-object v0

    const-class v1, Lcom/jibo/aws/integration/aws/services/loop/model/Member;

    invoke-virtual {v1}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/os/Bundle;->getParcelable(Ljava/lang/String;)Landroid/os/Parcelable;

    move-result-object v0

    check-cast v0, Lcom/jibo/aws/integration/aws/services/loop/model/Member;

    iput-object v0, p0, Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment;->m:Lcom/jibo/aws/integration/aws/services/loop/model/Member;

    .line 374
    :cond_1
    :goto_0
    return-void

    .line 369
    :cond_2
    const/16 v0, 0x3f7

    if-ne p1, v0, :cond_1

    .line 370
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    invoke-virtual {v0}, Landroid/support/v4/app/FragmentActivity;->getContentResolver()Landroid/content/ContentResolver;

    move-result-object v0

    const/16 v1, 0x8

    invoke-static {v1}, Lcom/jibo/db/DatabaseContract$EntityEntry;->a(I)Landroid/net/Uri;

    move-result-object v1

    const/4 v2, 0x0

    invoke-virtual {v0, v1, v2}, Landroid/content/ContentResolver;->notifyChange(Landroid/net/Uri;Landroid/database/ContentObserver;)V

    goto :goto_0
.end method

.method public onCreate(Landroid/os/Bundle;)V
    .locals 2

    .prologue
    .line 193
    invoke-super {p0, p1}, Lcom/jibo/ui/fragment/BaseFragment;->onCreate(Landroid/os/Bundle;)V

    .line 195
    const/4 v0, 0x1

    invoke-virtual {p0, v0}, Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment;->setHasOptionsMenu(Z)V

    .line 197
    if-eqz p1, :cond_1

    .line 198
    const-string v0, "ARGS_IS_IN_TUTORIAL_MODE"

    invoke-virtual {p1, v0}, Landroid/os/Bundle;->getBoolean(Ljava/lang/String;)Z

    move-result v0

    iput-boolean v0, p0, Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment;->a:Z

    .line 204
    :cond_0
    :goto_0
    return-void

    .line 200
    :cond_1
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment;->getArguments()Landroid/os/Bundle;

    move-result-object v0

    if-eqz v0, :cond_0

    .line 201
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment;->getArguments()Landroid/os/Bundle;

    move-result-object v0

    const-string v1, "ARGS_IS_IN_TUTORIAL_MODE"

    invoke-virtual {v0, v1}, Landroid/os/Bundle;->getBoolean(Ljava/lang/String;)Z

    move-result v0

    iput-boolean v0, p0, Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment;->a:Z

    goto :goto_0
.end method

.method public onCreateOptionsMenu(Landroid/view/Menu;Landroid/view/MenuInflater;)V
    .locals 1

    .prologue
    .line 378
    invoke-super {p0, p1, p2}, Lcom/jibo/ui/fragment/BaseFragment;->onCreateOptionsMenu(Landroid/view/Menu;Landroid/view/MenuInflater;)V

    .line 379
    const v0, 0x7f0c000f

    invoke-virtual {p2, v0, p1}, Landroid/view/MenuInflater;->inflate(ILandroid/view/Menu;)V

    .line 381
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    invoke-static {v0, p1}, Lcom/jibo/utils/ImageUtils;->a(Landroid/content/Context;Landroid/view/Menu;)V

    .line 382
    return-void
.end method

.method public onCreateView(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;
    .locals 2

    .prologue
    .line 210
    const v0, 0x7f0b0077

    const/4 v1, 0x0

    invoke-virtual {p1, v0, p2, v1}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    move-result-object v0

    return-object v0
.end method

.method public onCustomerCareClick(Landroid/view/View;)V
    .locals 3
    .annotation build Lbutterknife/OnClick;
    .end annotation

    .prologue
    .line 587
    const v0, 0x7f1002e7

    invoke-virtual {p0, v0}, Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment;->getString(I)Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v0

    .line 588
    new-instance v1, Landroid/content/Intent;

    const-string v2, "android.intent.action.VIEW"

    invoke-direct {v1, v2, v0}, Landroid/content/Intent;-><init>(Ljava/lang/String;Landroid/net/Uri;)V

    .line 589
    invoke-virtual {p0, v1}, Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment;->startActivity(Landroid/content/Intent;)V

    .line 590
    return-void
.end method

.method public onOptionsItemSelected(Landroid/view/MenuItem;)Z
    .locals 2

    .prologue
    .line 386
    invoke-interface {p1}, Landroid/view/MenuItem;->getItemId()I

    move-result v0

    .line 387
    const v1, 0x7f090032

    if-ne v0, v1, :cond_0

    .line 388
    invoke-direct {p0}, Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment;->q()V

    .line 389
    const/4 v0, 0x1

    .line 391
    :goto_0
    return v0

    :cond_0
    invoke-super {p0, p1}, Lcom/jibo/ui/fragment/BaseFragment;->onOptionsItemSelected(Landroid/view/MenuItem;)Z

    move-result v0

    goto :goto_0
.end method

.method public onPause()V
    .locals 2

    .prologue
    .line 351
    invoke-super {p0}, Lcom/jibo/ui/fragment/BaseFragment;->onPause()V

    .line 352
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    invoke-static {v0}, Landroid/support/v4/content/LocalBroadcastManager;->a(Landroid/content/Context;)Landroid/support/v4/content/LocalBroadcastManager;

    move-result-object v0

    iget-object v1, p0, Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment;->u:Landroid/content/BroadcastReceiver;

    invoke-virtual {v0, v1}, Landroid/support/v4/content/LocalBroadcastManager;->a(Landroid/content/BroadcastReceiver;)V

    .line 353
    return-void
.end method

.method public onResume()V
    .locals 7

    .prologue
    const/4 v6, 0x1

    const/4 v5, 0x0

    .line 329
    invoke-super {p0}, Lcom/jibo/ui/fragment/BaseFragment;->onResume()V

    .line 331
    new-instance v0, Landroid/content/IntentFilter;

    invoke-direct {v0}, Landroid/content/IntentFilter;-><init>()V

    .line 332
    const-string v1, "LOOP_HOLIDAYS_ALARM_ACTION"

    invoke-virtual {v0, v1}, Landroid/content/IntentFilter;->addAction(Ljava/lang/String;)V

    .line 333
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v1

    invoke-static {v1}, Landroid/support/v4/content/LocalBroadcastManager;->a(Landroid/content/Context;)Landroid/support/v4/content/LocalBroadcastManager;

    move-result-object v1

    iget-object v2, p0, Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment;->u:Landroid/content/BroadcastReceiver;

    invoke-virtual {v1, v2, v0}, Landroid/support/v4/content/LocalBroadcastManager;->a(Landroid/content/BroadcastReceiver;Landroid/content/IntentFilter;)V

    .line 337
    iget-object v0, p0, Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment;->m:Lcom/jibo/aws/integration/aws/services/loop/model/Member;

    if-eqz v0, :cond_0

    .line 338
    const/16 v0, 0x67

    const v1, 0x7f100108

    new-array v2, v6, [Ljava/lang/Object;

    iget-object v3, p0, Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment;->m:Lcom/jibo/aws/integration/aws/services/loop/model/Member;

    .line 339
    invoke-virtual {v3}, Lcom/jibo/aws/integration/aws/services/loop/model/Member;->getAccount()Lcom/jibo/aws/integration/aws/services/loop/model/MemberAccount;

    move-result-object v3

    invoke-virtual {v3}, Lcom/jibo/aws/integration/aws/services/loop/model/MemberAccount;->getFirstName()Ljava/lang/String;

    move-result-object v3

    aput-object v3, v2, v5

    invoke-virtual {p0, v1, v2}, Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment;->getString(I[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v1

    const v2, 0x7f1000fe

    const/4 v3, 0x2

    new-array v3, v3, [Ljava/lang/Object;

    iget-object v4, p0, Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment;->m:Lcom/jibo/aws/integration/aws/services/loop/model/Member;

    .line 340
    invoke-virtual {v4}, Lcom/jibo/aws/integration/aws/services/loop/model/Member;->getAccount()Lcom/jibo/aws/integration/aws/services/loop/model/MemberAccount;

    move-result-object v4

    invoke-virtual {v4}, Lcom/jibo/aws/integration/aws/services/loop/model/MemberAccount;->getFirstName()Ljava/lang/String;

    move-result-object v4

    aput-object v4, v3, v5

    iget-object v4, p0, Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment;->m:Lcom/jibo/aws/integration/aws/services/loop/model/Member;

    .line 341
    invoke-virtual {v4}, Lcom/jibo/aws/integration/aws/services/loop/model/Member;->getAccount()Lcom/jibo/aws/integration/aws/services/loop/model/MemberAccount;

    move-result-object v4

    invoke-virtual {v4}, Lcom/jibo/aws/integration/aws/services/loop/model/MemberAccount;->getFirstName()Ljava/lang/String;

    move-result-object v4

    aput-object v4, v3, v6

    .line 340
    invoke-virtual {p0, v2, v3}, Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment;->getString(I[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    const v3, 0x7f100233

    .line 341
    invoke-virtual {p0, v3}, Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment;->getString(I)Ljava/lang/String;

    move-result-object v3

    .line 338
    invoke-static {p0, v0, v1, v2, v3}, Lcom/jibo/ui/fragment/dialog/DialogUtils;->b(Landroid/support/v4/app/Fragment;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    .line 342
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment;->m:Lcom/jibo/aws/integration/aws/services/loop/model/Member;

    .line 347
    :goto_0
    return-void

    .line 345
    :cond_0
    invoke-direct {p0}, Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment;->r()Z

    goto :goto_0
.end method

.method public onViewCreated(Landroid/view/View;Landroid/os/Bundle;)V
    .locals 7

    .prologue
    const/4 v5, 0x1

    .line 215
    invoke-super {p0, p1, p2}, Lcom/jibo/ui/fragment/BaseFragment;->onViewCreated(Landroid/view/View;Landroid/os/Bundle;)V

    .line 217
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    invoke-static {v0}, Lcom/jibo/utils/SharedPreferencesUtil;->f(Landroid/content/Context;)Lcom/jibo/aws/integration/aws/services/loop/model/Loop;

    move-result-object v0

    iput-object v0, p0, Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment;->k:Lcom/jibo/aws/integration/aws/services/loop/model/Loop;

    .line 218
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    invoke-static {v0}, Lcom/jibo/db/EntityData;->a(Landroid/content/Context;)Lcom/jibo/db/EntityData;

    move-result-object v0

    invoke-virtual {v0}, Lcom/jibo/db/EntityData;->i()Lcom/jibo/aws/integration/aws/services/account/model/Account;

    move-result-object v0

    .line 219
    if-eqz v0, :cond_0

    .line 221
    new-instance v1, Lcom/jibo/aws/integration/aws/services/notification/JiboNotificationAsyncClient;

    new-instance v2, Lcom/amazonaws/auth/BasicAWSCredentials;

    .line 222
    invoke-virtual {v0}, Lcom/jibo/aws/integration/aws/services/account/model/Account;->getAccessKeyId()Ljava/lang/String;

    move-result-object v3

    .line 223
    invoke-virtual {v0}, Lcom/jibo/aws/integration/aws/services/account/model/Account;->getSecretAccessKey()Ljava/lang/String;

    move-result-object v4

    invoke-direct {v2, v3, v4}, Lcom/amazonaws/auth/BasicAWSCredentials;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    invoke-direct {v1, v2}, Lcom/jibo/aws/integration/aws/services/notification/JiboNotificationAsyncClient;-><init>(Lcom/amazonaws/auth/AWSCredentials;)V

    iput-object v1, p0, Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment;->n:Lcom/jibo/aws/integration/aws/services/notification/JiboNotificationAsyncClient;

    .line 221
    invoke-virtual {p0, v1}, Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment;->a(Lcom/jibo/aws/integration/aws/services/AbstractJiboAsyncClient;)V

    .line 225
    new-instance v1, Lcom/jibo/aws/integration/aws/services/skills/JiboSkillsAsyncClient;

    new-instance v2, Lcom/amazonaws/auth/BasicAWSCredentials;

    .line 226
    invoke-virtual {v0}, Lcom/jibo/aws/integration/aws/services/account/model/Account;->getAccessKeyId()Ljava/lang/String;

    move-result-object v3

    .line 227
    invoke-virtual {v0}, Lcom/jibo/aws/integration/aws/services/account/model/Account;->getSecretAccessKey()Ljava/lang/String;

    move-result-object v4

    invoke-direct {v2, v3, v4}, Lcom/amazonaws/auth/BasicAWSCredentials;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    invoke-direct {v1, v2}, Lcom/jibo/aws/integration/aws/services/skills/JiboSkillsAsyncClient;-><init>(Lcom/amazonaws/auth/AWSCredentials;)V

    iput-object v1, p0, Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment;->o:Lcom/jibo/aws/integration/aws/services/skills/JiboSkillsAsyncClient;

    .line 225
    invoke-virtual {p0, v1}, Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment;->a(Lcom/jibo/aws/integration/aws/services/AbstractJiboAsyncClient;)V

    .line 234
    :cond_0
    new-instance v1, Lcom/jibo/ui/fragment/jibos/adapter/LoopMembersListAdapter;

    iget-object v2, p0, Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment;->c:Ljava/util/List;

    iget-object v3, p0, Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment;->k:Lcom/jibo/aws/integration/aws/services/loop/model/Loop;

    invoke-direct {v1, v2, v3, v0}, Lcom/jibo/ui/fragment/jibos/adapter/LoopMembersListAdapter;-><init>(Ljava/util/List;Lcom/jibo/aws/integration/aws/services/loop/model/Loop;Lcom/jibo/aws/integration/aws/services/account/model/Account;)V

    iput-object v1, p0, Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment;->l:Lcom/jibo/ui/fragment/jibos/adapter/LoopMembersListAdapter;

    .line 235
    iget-object v1, p0, Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment;->l:Lcom/jibo/ui/fragment/jibos/adapter/LoopMembersListAdapter;

    iget-object v2, p0, Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment;->r:Landroid/view/View$OnLongClickListener;

    invoke-virtual {v1, v2}, Lcom/jibo/ui/fragment/jibos/adapter/LoopMembersListAdapter;->a(Landroid/view/View$OnLongClickListener;)V

    .line 236
    iget-object v1, p0, Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment;->list:Landroid/support/v7/widget/RecyclerView;

    invoke-virtual {v1, v5}, Landroid/support/v7/widget/RecyclerView;->setHasFixedSize(Z)V

    .line 237
    iget-object v1, p0, Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment;->list:Landroid/support/v7/widget/RecyclerView;

    new-instance v2, Landroid/support/v7/widget/DefaultItemAnimator;

    invoke-direct {v2}, Landroid/support/v7/widget/DefaultItemAnimator;-><init>()V

    invoke-virtual {v1, v2}, Landroid/support/v7/widget/RecyclerView;->setItemAnimator(Landroid/support/v7/widget/RecyclerView$ItemAnimator;)V

    .line 238
    iget-object v1, p0, Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment;->list:Landroid/support/v7/widget/RecyclerView;

    new-instance v2, Landroid/support/v7/widget/LinearLayoutManager;

    invoke-virtual {p0}, Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v3

    const/4 v4, 0x0

    invoke-direct {v2, v3, v5, v4}, Landroid/support/v7/widget/LinearLayoutManager;-><init>(Landroid/content/Context;IZ)V

    invoke-virtual {v1, v2}, Landroid/support/v7/widget/RecyclerView;->setLayoutManager(Landroid/support/v7/widget/RecyclerView$LayoutManager;)V

    .line 239
    iget-object v1, p0, Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment;->list:Landroid/support/v7/widget/RecyclerView;

    new-instance v2, Lcom/jibo/ui/fragment/jibos/adapter/LoopMembersListAdapter$SpacesItemDecoration;

    invoke-virtual {p0}, Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v3

    const/4 v4, -0x1

    const v5, 0x7f07004f

    const v6, 0x7f0700b6

    invoke-direct {v2, v3, v4, v5, v6}, Lcom/jibo/ui/fragment/jibos/adapter/LoopMembersListAdapter$SpacesItemDecoration;-><init>(Landroid/content/Context;III)V

    invoke-virtual {v1, v2}, Landroid/support/v7/widget/RecyclerView;->addItemDecoration(Landroid/support/v7/widget/RecyclerView$ItemDecoration;)V

    .line 242
    iget-object v1, p0, Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment;->list:Landroid/support/v7/widget/RecyclerView;

    iget-object v2, p0, Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment;->l:Lcom/jibo/ui/fragment/jibos/adapter/LoopMembersListAdapter;

    invoke-virtual {v1, v2}, Landroid/support/v7/widget/RecyclerView;->setAdapter(Landroid/support/v7/widget/RecyclerView$Adapter;)V

    .line 244
    iget-object v1, p0, Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment;->swipeRefreshLayout:Landroid/support/v4/widget/SwipeRefreshLayout;

    invoke-virtual {v1, p0}, Landroid/support/v4/widget/SwipeRefreshLayout;->setOnRefreshListener(Landroid/support/v4/widget/SwipeRefreshLayout$OnRefreshListener;)V

    .line 245
    iget-object v1, p0, Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment;->swipeRefreshLayout:Landroid/support/v4/widget/SwipeRefreshLayout;

    const/4 v2, 0x4

    new-array v2, v2, [I

    fill-array-data v2, :array_0

    invoke-virtual {v1, v2}, Landroid/support/v4/widget/SwipeRefreshLayout;->setColorSchemeResources([I)V

    .line 248
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment;->getLoaderManager()Landroid/support/v4/app/LoaderManager;

    move-result-object v1

    const v2, 0x7f0901c5

    const/4 v3, 0x0

    invoke-virtual {v1, v2, v3, p0}, Landroid/support/v4/app/LoaderManager;->a(ILandroid/os/Bundle;Landroid/support/v4/app/LoaderManager$LoaderCallbacks;)Landroid/support/v4/content/Loader;

    .line 251
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment;->getArguments()Landroid/os/Bundle;

    move-result-object v1

    if-eqz v1, :cond_1

    invoke-virtual {p0}, Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment;->getArguments()Landroid/os/Bundle;

    move-result-object v1

    const-string v2, "ARG_EXTRAS"

    invoke-virtual {v1, v2}, Landroid/os/Bundle;->getBundle(Ljava/lang/String;)Landroid/os/Bundle;

    move-result-object v1

    if-eqz v1, :cond_1

    .line 252
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment;->getArguments()Landroid/os/Bundle;

    move-result-object v1

    const-string v2, "ARG_EXTRAS"

    invoke-virtual {v1, v2}, Landroid/os/Bundle;->getBundle(Ljava/lang/String;)Landroid/os/Bundle;

    move-result-object v1

    .line 253
    const-string v2, "ARG_MESSAGE"

    invoke-virtual {v1, v2}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    if-eqz v2, :cond_1

    .line 254
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment;->c()Landroid/os/Handler;

    move-result-object v2

    new-instance v3, Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment$4;

    invoke-direct {v3, p0, v1}, Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment$4;-><init>(Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment;Landroid/os/Bundle;)V

    const-wide/16 v4, 0xc8

    invoke-virtual {v2, v3, v4, v5}, Landroid/os/Handler;->postDelayed(Ljava/lang/Runnable;J)Z

    .line 267
    :cond_1
    if-eqz v0, :cond_2

    iget-object v1, p0, Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment;->k:Lcom/jibo/aws/integration/aws/services/loop/model/Loop;

    invoke-virtual {v0}, Lcom/jibo/aws/integration/aws/services/account/model/Account;->getId()Ljava/lang/String;

    move-result-object v2

    invoke-static {v1, v2}, Lcom/jibo/aws/integration/helpers/LoopHelper;->isOwner(Lcom/jibo/aws/integration/aws/services/loop/model/Loop;Ljava/lang/String;)Z

    move-result v1

    if-eqz v1, :cond_2

    .line 268
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v1

    invoke-static {v1}, Lcom/jibo/db/EntityData;->a(Landroid/content/Context;)Lcom/jibo/db/EntityData;

    move-result-object v1

    invoke-virtual {v1}, Lcom/jibo/db/EntityData;->g()Lcom/jibo/aws/integration/aws/services/robotProperties/JiboRobotPropertiesAsyncClient;

    move-result-object v1

    iput-object v1, p0, Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment;->s:Lcom/jibo/aws/integration/aws/services/robotProperties/JiboRobotPropertiesAsyncClient;

    .line 271
    :cond_2
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment;->getArguments()Landroid/os/Bundle;

    move-result-object v1

    const-string v2, "ARG_EXTRAS"

    invoke-virtual {v1, v2}, Landroid/os/Bundle;->containsKey(Ljava/lang/String;)Z

    move-result v1

    if-eqz v1, :cond_3

    .line 272
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment;->getArguments()Landroid/os/Bundle;

    move-result-object v1

    const-string v2, "ARG_EXTRAS"

    invoke-virtual {v1, v2}, Landroid/os/Bundle;->getBundle(Ljava/lang/String;)Landroid/os/Bundle;

    move-result-object v1

    .line 273
    if-eqz v1, :cond_3

    const-string v2, "ARG_SETTINGS"

    invoke-virtual {v1, v2}, Landroid/os/Bundle;->containsKey(Ljava/lang/String;)Z

    move-result v1

    if-eqz v1, :cond_3

    .line 274
    iget-object v1, p0, Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment;->k:Lcom/jibo/aws/integration/aws/services/loop/model/Loop;

    invoke-virtual {v0}, Lcom/jibo/aws/integration/aws/services/account/model/Account;->getId()Ljava/lang/String;

    move-result-object v0

    invoke-static {v1, v0}, Lcom/jibo/aws/integration/helpers/LoopHelper;->isOwner(Lcom/jibo/aws/integration/aws/services/loop/model/Loop;Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_3

    .line 275
    new-instance v0, Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment$5;

    invoke-direct {v0, p0}, Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment$5;-><init>(Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment;)V

    const-wide/16 v2, 0x2ee

    invoke-virtual {p1, v0, v2, v3}, Landroid/view/View;->postDelayed(Ljava/lang/Runnable;J)Z

    .line 286
    :cond_3
    return-void

    .line 245
    :array_0
    .array-data 4
        0x7f06007b
        0x7f060018
        0x7f060018
        0x7f060018
    .end array-data
.end method

.method public reconnectToJiboClick()V
    .locals 2
    .annotation build Lbutterknife/OnClick;
    .end annotation

    .prologue
    .line 577
    invoke-direct {p0}, Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment;->u()Z

    move-result v0

    if-nez v0, :cond_0

    .line 578
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment;->f()V

    .line 579
    iget-object v0, p0, Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment;->k:Lcom/jibo/aws/integration/aws/services/loop/model/Loop;

    invoke-virtual {v0}, Lcom/jibo/aws/integration/aws/services/loop/model/Loop;->getId()Ljava/lang/String;

    move-result-object v0

    iget-object v1, p0, Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment;->x:Lcom/jibo/ui/fragment/dialog/passphrase/LoopPassphraseUtils$KeyBackupCheckListener;

    invoke-static {v0, p0, v1}, Lcom/jibo/ui/fragment/dialog/passphrase/LoopPassphraseUtils;->a(Ljava/lang/String;Lcom/jibo/ui/fragment/BaseFragment;Lcom/jibo/ui/fragment/dialog/passphrase/LoopPassphraseUtils$KeyBackupCheckListener;)V

    .line 583
    :goto_0
    return-void

    .line 581
    :cond_0
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    iget-object v1, p0, Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment;->k:Lcom/jibo/aws/integration/aws/services/loop/model/Loop;

    invoke-static {v0, v1}, Lcom/jibo/ui/activity/WifiActivity;->a(Landroid/app/Activity;Lcom/jibo/aws/integration/aws/services/loop/model/Loop;)V

    goto :goto_0
.end method
