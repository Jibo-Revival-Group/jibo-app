.class public Lcom/jibo/ui/activity/OnBoardingActivity;
.super Lcom/jibo/ui/activity/BaseActivity;
.source "OnBoardingActivity.java"

# interfaces
.implements Lcom/jibo/ui/activity/BaseActivity$OnDoubleBackButtonListener;


# static fields
.field public static final h:Ljava/lang/String;

.field public static final i:Ljava/lang/String;

.field public static final j:Ljava/lang/String;

.field public static final k:Ljava/lang/String;

.field public static final l:Ljava/lang/String;

.field public static n:Ljava/lang/String;


# instance fields
.field public m:Landroid/os/Bundle;


# direct methods
.method static constructor <clinit>()V
    .locals 2

    .prologue
    .line 50
    const-class v0, Lcom/jibo/ui/activity/OnBoardingActivity;

    invoke-virtual {v0}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/jibo/ui/activity/OnBoardingActivity;->h:Ljava/lang/String;

    .line 54
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    const-class v1, Lcom/jibo/ui/activity/OnBoardingActivity;

    invoke-virtual {v1}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, ".ACTION_RESET_PASSWORD"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/jibo/ui/activity/OnBoardingActivity;->i:Ljava/lang/String;

    .line 55
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    const-class v1, Lcom/jibo/ui/activity/OnBoardingActivity;

    invoke-virtual {v1}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, ".ACTION_LOGIN_OR_SIGNUP"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/jibo/ui/activity/OnBoardingActivity;->j:Ljava/lang/String;

    .line 56
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    const-class v1, Lcom/jibo/ui/activity/OnBoardingActivity;

    invoke-virtual {v1}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, ""

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, ".ACTION_CUSTOMER_SUPPORT"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/jibo/ui/activity/OnBoardingActivity;->k:Ljava/lang/String;

    .line 58
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    const-class v1, Lcom/jibo/ui/activity/OnBoardingActivity;

    invoke-virtual {v1}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, ".ACTION_DEV_SETTINGS"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/jibo/ui/activity/OnBoardingActivity;->l:Ljava/lang/String;

    .line 62
    const/4 v0, 0x0

    sput-object v0, Lcom/jibo/ui/activity/OnBoardingActivity;->n:Ljava/lang/String;

    return-void
.end method

.method public constructor <init>()V
    .locals 1

    .prologue
    .line 49
    invoke-direct {p0}, Lcom/jibo/ui/activity/BaseActivity;-><init>()V

    .line 60
    new-instance v0, Landroid/os/Bundle;

    invoke-direct {v0}, Landroid/os/Bundle;-><init>()V

    iput-object v0, p0, Lcom/jibo/ui/activity/OnBoardingActivity;->m:Landroid/os/Bundle;

    return-void
.end method

.method public static a(Landroid/content/Context;Ljava/lang/String;Z)V
    .locals 2

    .prologue
    .line 401
    new-instance v0, Landroid/content/Intent;

    const-class v1, Lcom/jibo/ui/activity/OnBoardingActivity;

    invoke-direct {v0, p0, v1}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .line 402
    invoke-virtual {v0, p1}, Landroid/content/Intent;->setAction(Ljava/lang/String;)Landroid/content/Intent;

    .line 403
    invoke-virtual {p0, v0}, Landroid/content/Context;->startActivity(Landroid/content/Intent;)V

    .line 405
    if-eqz p2, :cond_0

    instance-of v0, p0, Landroid/app/Activity;

    if-eqz v0, :cond_0

    .line 406
    check-cast p0, Landroid/app/Activity;

    invoke-virtual {p0}, Landroid/app/Activity;->finish()V

    .line 408
    :cond_0
    return-void
.end method

.method private a(Landroid/net/Uri;)V
    .locals 4

    .prologue
    .line 188
    const-string v0, "loopId"

    invoke-virtual {p1, v0}, Landroid/net/Uri;->getQueryParameter(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 189
    invoke-static {p0}, Lcom/jibo/db/EntityData;->a(Landroid/content/Context;)Lcom/jibo/db/EntityData;

    move-result-object v1

    invoke-virtual {v1}, Lcom/jibo/db/EntityData;->i()Lcom/jibo/aws/integration/aws/services/account/model/Account;

    move-result-object v1

    .line 190
    if-nez v1, :cond_0

    .line 191
    invoke-virtual {p0}, Lcom/jibo/ui/activity/OnBoardingActivity;->getApplication()Landroid/app/Application;

    move-result-object v0

    check-cast v0, Lcom/jibo/JiboApplication;

    invoke-virtual {v0}, Lcom/jibo/JiboApplication;->b()V

    .line 192
    invoke-virtual {p0}, Lcom/jibo/ui/activity/OnBoardingActivity;->q()V

    .line 202
    :goto_0
    return-void

    .line 194
    :cond_0
    new-instance v1, Landroid/os/Bundle;

    invoke-direct {v1}, Landroid/os/Bundle;-><init>()V

    .line 195
    const-string v2, "ARG_TAB_SELECTED"

    const/4 v3, 0x0

    invoke-virtual {v1, v2, v3}, Landroid/os/Bundle;->putInt(Ljava/lang/String;I)V

    .line 196
    const-string v2, "ARG_SETTINGS"

    const/4 v3, 0x1

    invoke-virtual {v1, v2, v3}, Landroid/os/Bundle;->putBoolean(Ljava/lang/String;Z)V

    .line 197
    const-string v2, "ARG_LOOP_ID"

    invoke-virtual {v1, v2, v0}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 198
    invoke-virtual {p0}, Lcom/jibo/ui/activity/OnBoardingActivity;->getIntent()Landroid/content/Intent;

    move-result-object v0

    const-string v2, "ARG_EXTRAS"

    invoke-virtual {v0, v2, v1}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Landroid/os/Bundle;)Landroid/content/Intent;

    .line 199
    invoke-direct {p0}, Lcom/jibo/ui/activity/OnBoardingActivity;->u()V

    goto :goto_0
.end method

.method private a(Ljava/util/List;)V
    .locals 4
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Lcom/jibo/aws/integration/aws/services/loop/model/Loop;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 372
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0, p1}, Ljava/util/ArrayList;-><init>(Ljava/util/Collection;)V

    .line 373
    new-instance v1, Landroid/content/Intent;

    invoke-direct {v1}, Landroid/content/Intent;-><init>()V

    .line 374
    const-string v2, " ARGS_LOOPS_LIST"

    invoke-virtual {v1, v2, v0}, Landroid/content/Intent;->putParcelableArrayListExtra(Ljava/lang/String;Ljava/util/ArrayList;)Landroid/content/Intent;

    .line 375
    const-string v0, " ARGS_HAS_ACCEPTED_LOOPS"

    const/4 v2, 0x0

    invoke-virtual {v1, v0, v2}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Z)Landroid/content/Intent;

    .line 376
    const-string v0, "ARG_EXTRAS"

    invoke-virtual {p0}, Lcom/jibo/ui/activity/OnBoardingActivity;->getIntent()Landroid/content/Intent;

    move-result-object v2

    invoke-virtual {v2}, Landroid/content/Intent;->getExtras()Landroid/os/Bundle;

    move-result-object v2

    const-string v3, "ARG_EXTRAS"

    invoke-virtual {v2, v3}, Landroid/os/Bundle;->getBundle(Ljava/lang/String;)Landroid/os/Bundle;

    move-result-object v2

    invoke-virtual {v1, v0, v2}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Landroid/os/Bundle;)Landroid/content/Intent;

    .line 377
    const-class v0, Lcom/jibo/ui/activity/LoopInviteDetailsActivity;

    invoke-virtual {v1, p0, v0}, Landroid/content/Intent;->setClass(Landroid/content/Context;Ljava/lang/Class;)Landroid/content/Intent;

    .line 378
    invoke-virtual {p0, v1}, Lcom/jibo/ui/activity/OnBoardingActivity;->startActivity(Landroid/content/Intent;)V

    .line 379
    invoke-virtual {p0}, Lcom/jibo/ui/activity/OnBoardingActivity;->finish()V

    .line 380
    return-void
.end method

.method private b(Landroid/net/Uri;)V
    .locals 6

    .prologue
    const/4 v5, 0x0

    .line 205
    const-string v0, "email"

    invoke-virtual {p1, v0}, Landroid/net/Uri;->getQueryParameter(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    .line 206
    const-string v0, "code"

    invoke-virtual {p1, v0}, Landroid/net/Uri;->getQueryParameter(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    .line 208
    invoke-static {p0}, Lcom/jibo/db/EntityData;->a(Landroid/content/Context;)Lcom/jibo/db/EntityData;

    move-result-object v0

    invoke-virtual {v0}, Lcom/jibo/db/EntityData;->i()Lcom/jibo/aws/integration/aws/services/account/model/Account;

    move-result-object v0

    .line 210
    if-nez v0, :cond_1

    .line 211
    invoke-virtual {p0}, Lcom/jibo/ui/activity/OnBoardingActivity;->getApplication()Landroid/app/Application;

    move-result-object v0

    check-cast v0, Lcom/jibo/JiboApplication;

    invoke-virtual {v0}, Lcom/jibo/JiboApplication;->b()V

    .line 213
    invoke-static {v2}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 214
    invoke-virtual {p0}, Lcom/jibo/ui/activity/OnBoardingActivity;->q()V

    .line 239
    :goto_0
    return-void

    .line 217
    :cond_0
    invoke-virtual {p0, v1, v2}, Lcom/jibo/ui/activity/OnBoardingActivity;->a(Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_0

    .line 219
    :cond_1
    invoke-static {v1}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v2

    if-nez v2, :cond_2

    invoke-virtual {v0}, Lcom/jibo/aws/integration/aws/services/account/model/Account;->getEmail()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_2

    .line 221
    new-instance v0, Landroid/os/Bundle;

    invoke-direct {v0}, Landroid/os/Bundle;-><init>()V

    .line 222
    const-string v1, "ARG_TAB_SELECTED"

    invoke-virtual {v0, v1, v5}, Landroid/os/Bundle;->putInt(Ljava/lang/String;I)V

    .line 223
    invoke-virtual {p0}, Lcom/jibo/ui/activity/OnBoardingActivity;->getIntent()Landroid/content/Intent;

    move-result-object v1

    const-string v2, "ARG_EXTRAS"

    invoke-virtual {v1, v2, v0}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Landroid/os/Bundle;)Landroid/content/Intent;

    .line 224
    invoke-direct {p0}, Lcom/jibo/ui/activity/OnBoardingActivity;->u()V

    goto :goto_0

    .line 225
    :cond_2
    invoke-static {v1}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v2

    if-nez v2, :cond_3

    invoke-virtual {v0}, Lcom/jibo/aws/integration/aws/services/account/model/Account;->getEmail()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v1, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_3

    .line 227
    new-instance v0, Landroid/os/Bundle;

    invoke-direct {v0}, Landroid/os/Bundle;-><init>()V

    .line 228
    const-string v2, "ARG_TAB_SELECTED"

    invoke-virtual {v0, v2, v5}, Landroid/os/Bundle;->putInt(Ljava/lang/String;I)V

    .line 229
    const-string v2, "ARG_TITLE"

    const v3, 0x7f10021a

    invoke-virtual {p0, v3}, Lcom/jibo/ui/activity/OnBoardingActivity;->getString(I)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v0, v2, v3}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 230
    const-string v2, "ARG_MESSAGE"

    const v3, 0x7f100219

    .line 231
    invoke-virtual {p0, v3}, Lcom/jibo/ui/activity/OnBoardingActivity;->getString(I)Ljava/lang/String;

    move-result-object v3

    const/4 v4, 0x1

    new-array v4, v4, [Ljava/lang/Object;

    aput-object v1, v4, v5

    invoke-static {v3, v4}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v1

    .line 230
    invoke-virtual {v0, v2, v1}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 232
    invoke-virtual {p0}, Lcom/jibo/ui/activity/OnBoardingActivity;->getIntent()Landroid/content/Intent;

    move-result-object v1

    const-string v2, "ARG_EXTRAS"

    invoke-virtual {v1, v2, v0}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Landroid/os/Bundle;)Landroid/content/Intent;

    .line 233
    iget-object v1, p0, Lcom/jibo/ui/activity/OnBoardingActivity;->m:Landroid/os/Bundle;

    invoke-virtual {v1, v0}, Landroid/os/Bundle;->putAll(Landroid/os/Bundle;)V

    .line 234
    invoke-direct {p0}, Lcom/jibo/ui/activity/OnBoardingActivity;->u()V

    goto :goto_0

    .line 237
    :cond_3
    invoke-direct {p0}, Lcom/jibo/ui/activity/OnBoardingActivity;->u()V

    goto :goto_0
.end method

.method private u()V
    .locals 2

    .prologue
    .line 242
    invoke-virtual {p0}, Lcom/jibo/ui/activity/OnBoardingActivity;->m()V

    .line 244
    const-class v0, Lcom/jibo/ui/fragment/SplashFragment;

    iget-object v1, p0, Lcom/jibo/ui/activity/OnBoardingActivity;->m:Landroid/os/Bundle;

    invoke-virtual {p0, v0, v1}, Lcom/jibo/ui/activity/OnBoardingActivity;->a(Ljava/lang/Class;Landroid/os/Bundle;)V

    .line 245
    return-void
.end method


# virtual methods
.method public a(Ljava/lang/String;)V
    .locals 2

    .prologue
    .line 262
    iget-object v0, p0, Lcom/jibo/ui/activity/OnBoardingActivity;->m:Landroid/os/Bundle;

    const-string v1, "email"

    invoke-virtual {v0, v1, p1}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 264
    const-class v0, Lcom/jibo/ui/fragment/onboarding/LoginFragment;

    iget-object v1, p0, Lcom/jibo/ui/activity/OnBoardingActivity;->m:Landroid/os/Bundle;

    invoke-virtual {p0, v0, v1}, Lcom/jibo/ui/activity/OnBoardingActivity;->a(Ljava/lang/Class;Landroid/os/Bundle;)V

    .line 265
    return-void
.end method

.method public a(Ljava/lang/String;Ljava/lang/String;)V
    .locals 4

    .prologue
    .line 271
    iget-object v0, p0, Lcom/jibo/ui/activity/OnBoardingActivity;->m:Landroid/os/Bundle;

    const-string v1, "email"

    invoke-virtual {v0, v1, p1}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 272
    iget-object v0, p0, Lcom/jibo/ui/activity/OnBoardingActivity;->m:Landroid/os/Bundle;

    const-string v1, "code"

    invoke-virtual {v0, v1, p2}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 274
    invoke-virtual {p0}, Lcom/jibo/ui/activity/OnBoardingActivity;->getSupportFragmentManager()Landroid/support/v4/app/FragmentManager;

    move-result-object v0

    invoke-virtual {v0}, Landroid/support/v4/app/FragmentManager;->a()Landroid/support/v4/app/FragmentTransaction;

    move-result-object v0

    const v1, 0x7f09013f

    const-class v2, Lcom/jibo/ui/fragment/onboarding/SignupFragment;

    .line 275
    invoke-virtual {v2}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v2

    iget-object v3, p0, Lcom/jibo/ui/activity/OnBoardingActivity;->m:Landroid/os/Bundle;

    invoke-static {p0, v2, v3}, Landroid/support/v4/app/Fragment;->instantiate(Landroid/content/Context;Ljava/lang/String;Landroid/os/Bundle;)Landroid/support/v4/app/Fragment;

    move-result-object v2

    sget-object v3, Lcom/jibo/ui/fragment/onboarding/SignupFragment;->a:Ljava/lang/String;

    invoke-virtual {v0, v1, v2, v3}, Landroid/support/v4/app/FragmentTransaction;->b(ILandroid/support/v4/app/Fragment;Ljava/lang/String;)Landroid/support/v4/app/FragmentTransaction;

    move-result-object v0

    sget-object v1, Lcom/jibo/ui/fragment/onboarding/SignupFragment;->a:Ljava/lang/String;

    .line 276
    invoke-virtual {v0, v1}, Landroid/support/v4/app/FragmentTransaction;->a(Ljava/lang/String;)Landroid/support/v4/app/FragmentTransaction;

    move-result-object v0

    invoke-virtual {v0}, Landroid/support/v4/app/FragmentTransaction;->d()I

    .line 277
    return-void
.end method

.method public a(Ljava/util/List;Lcom/jibo/ui/fragment/BaseFragment;)V
    .locals 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Lcom/jibo/aws/integration/aws/services/loop/model/Loop;",
            ">;",
            "Lcom/jibo/ui/fragment/BaseFragment;",
            ")V"
        }
    .end annotation

    .prologue
    .line 343
    invoke-static {p0}, Lcom/jibo/db/EntityData;->a(Landroid/content/Context;)Lcom/jibo/db/EntityData;

    move-result-object v0

    invoke-virtual {v0}, Lcom/jibo/db/EntityData;->i()Lcom/jibo/aws/integration/aws/services/account/model/Account;

    move-result-object v0

    .line 344
    if-nez v0, :cond_0

    .line 346
    invoke-virtual {p0}, Lcom/jibo/ui/activity/OnBoardingActivity;->q()V

    .line 369
    :goto_0
    return-void

    .line 347
    :cond_0
    invoke-virtual {v0}, Lcom/jibo/aws/integration/aws/services/account/model/Account;->isActive()Ljava/lang/Boolean;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v1

    if-nez v1, :cond_1

    .line 349
    invoke-virtual {v0}, Lcom/jibo/aws/integration/aws/services/account/model/Account;->getEmail()Ljava/lang/String;

    move-result-object v0

    const/4 v1, 0x0

    invoke-virtual {p0, v0, v1}, Lcom/jibo/ui/activity/OnBoardingActivity;->b(Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_0

    .line 350
    :cond_1
    if-eqz p2, :cond_2

    instance-of v1, p2, Lcom/jibo/ui/fragment/onboarding/SignupCompleteFragment;

    if-eqz v1, :cond_2

    .line 352
    invoke-virtual {p0}, Lcom/jibo/ui/activity/OnBoardingActivity;->r()V

    goto :goto_0

    .line 353
    :cond_2
    invoke-virtual {v0}, Lcom/jibo/aws/integration/aws/services/account/model/Account;->isIncomplete()Z

    move-result v1

    if-eqz v1, :cond_3

    .line 355
    invoke-virtual {p0}, Lcom/jibo/ui/activity/OnBoardingActivity;->r()V

    goto :goto_0

    .line 356
    :cond_3
    invoke-virtual {v0}, Lcom/jibo/aws/integration/aws/services/account/model/Account;->getEmail()Ljava/lang/String;

    move-result-object v0

    invoke-static {p1, v0}, Lcom/jibo/aws/integration/helpers/LoopHelper;->hasInvitationsOnly(Ljava/util/List;Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_4

    .line 357
    invoke-direct {p0, p1}, Lcom/jibo/ui/activity/OnBoardingActivity;->a(Ljava/util/List;)V

    goto :goto_0

    .line 360
    :cond_4
    invoke-virtual {p0}, Lcom/jibo/ui/activity/OnBoardingActivity;->getApplicationContext()Landroid/content/Context;

    move-result-object v0

    invoke-static {v0}, Lcom/jibo/utils/SharedPreferencesUtil;->g(Landroid/content/Context;)Z

    move-result v0

    if-eqz v0, :cond_5

    .line 361
    invoke-virtual {p0}, Lcom/jibo/ui/activity/OnBoardingActivity;->getApplicationContext()Landroid/content/Context;

    move-result-object v0

    invoke-static {v0}, Lcom/jibo/service/SyncHelper;->a(Landroid/content/Context;)V

    .line 365
    :cond_5
    invoke-virtual {p0}, Lcom/jibo/ui/activity/OnBoardingActivity;->getApplicationContext()Landroid/content/Context;

    move-result-object v0

    invoke-static {v0}, Lcom/jibo/service/SyncHelper;->c(Landroid/content/Context;)V

    .line 367
    invoke-virtual {p0}, Lcom/jibo/ui/activity/OnBoardingActivity;->getIntent()Landroid/content/Intent;

    move-result-object v0

    invoke-virtual {v0}, Landroid/content/Intent;->getExtras()Landroid/os/Bundle;

    move-result-object v0

    const-string v1, "ARG_EXTRAS"

    invoke-virtual {v0, v1}, Landroid/os/Bundle;->getBundle(Ljava/lang/String;)Landroid/os/Bundle;

    move-result-object v0

    invoke-static {p0, v0}, Lcom/jibo/ui/activity/TabbedActivity;->a(Landroid/app/Activity;Landroid/os/Bundle;)V

    goto :goto_0
.end method

.method protected a(Landroid/content/Intent;)Z
    .locals 4

    .prologue
    const/4 v3, 0x0

    .line 140
    invoke-static {p0}, Lcom/jibo/utils/SharedPreferencesUtil;->c(Landroid/content/Context;)Z

    move-result v0

    if-nez v0, :cond_0

    .line 141
    invoke-virtual {p1}, Landroid/content/Intent;->getData()Landroid/net/Uri;

    move-result-object v0

    if-eqz v0, :cond_2

    invoke-virtual {p1}, Landroid/content/Intent;->getData()Landroid/net/Uri;

    move-result-object v0

    invoke-virtual {v0}, Landroid/net/Uri;->toString()Ljava/lang/String;

    move-result-object v0

    if-eqz v0, :cond_2

    .line 142
    const/4 v0, 0x1

    invoke-static {p0, v0}, Lcom/jibo/JiboAnalytics;->a(Landroid/content/Context;Z)V

    .line 146
    :goto_0
    invoke-static {p0}, Lcom/jibo/utils/SharedPreferencesUtil;->d(Landroid/content/Context;)V

    .line 149
    :cond_0
    sget-object v0, Lcom/jibo/ui/activity/OnBoardingActivity;->i:Ljava/lang/String;

    invoke-virtual {p1}, Landroid/content/Intent;->getAction()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_3

    .line 150
    invoke-static {p0}, Lcom/jibo/db/EntityData;->a(Landroid/content/Context;)Lcom/jibo/db/EntityData;

    move-result-object v0

    invoke-virtual {v0}, Lcom/jibo/db/EntityData;->i()Lcom/jibo/aws/integration/aws/services/account/model/Account;

    move-result-object v0

    invoke-virtual {v0}, Lcom/jibo/aws/integration/aws/services/account/model/Account;->getEmail()Ljava/lang/String;

    move-result-object v0

    const-string v1, ""

    invoke-virtual {p0, v0, v1}, Lcom/jibo/ui/activity/OnBoardingActivity;->c(Ljava/lang/String;Ljava/lang/String;)V

    .line 184
    :cond_1
    :goto_1
    return v3

    .line 144
    :cond_2
    invoke-static {p0, v3}, Lcom/jibo/JiboAnalytics;->a(Landroid/content/Context;Z)V

    goto :goto_0

    .line 151
    :cond_3
    sget-object v0, Lcom/jibo/ui/activity/OnBoardingActivity;->j:Ljava/lang/String;

    invoke-virtual {p1}, Landroid/content/Intent;->getAction()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_4

    .line 152
    invoke-virtual {p0}, Lcom/jibo/ui/activity/OnBoardingActivity;->q()V

    goto :goto_1

    .line 153
    :cond_4
    sget-object v0, Lcom/jibo/ui/activity/OnBoardingActivity;->k:Ljava/lang/String;

    invoke-virtual {p1}, Landroid/content/Intent;->getAction()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_1

    .line 154
    sget-object v0, Lcom/jibo/ui/activity/OnBoardingActivity;->l:Ljava/lang/String;

    invoke-virtual {p1}, Landroid/content/Intent;->getAction()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_5

    .line 155
    invoke-virtual {p0}, Lcom/jibo/ui/activity/OnBoardingActivity;->t()V

    goto :goto_1

    .line 156
    :cond_5
    invoke-virtual {p1}, Landroid/content/Intent;->getData()Landroid/net/Uri;

    move-result-object v0

    if-eqz v0, :cond_6

    invoke-virtual {p1}, Landroid/content/Intent;->getData()Landroid/net/Uri;

    move-result-object v0

    invoke-virtual {v0}, Landroid/net/Uri;->toString()Ljava/lang/String;

    move-result-object v0

    const v1, 0x7f1001e5

    invoke-virtual {p0, v1}, Lcom/jibo/ui/activity/OnBoardingActivity;->getString(I)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/String;->contains(Ljava/lang/CharSequence;)Z

    move-result v0

    if-eqz v0, :cond_6

    .line 159
    invoke-virtual {p0}, Lcom/jibo/ui/activity/OnBoardingActivity;->getApplication()Landroid/app/Application;

    move-result-object v0

    check-cast v0, Lcom/jibo/JiboApplication;

    invoke-virtual {v0}, Lcom/jibo/JiboApplication;->b()V

    .line 161
    invoke-virtual {p1}, Landroid/content/Intent;->getData()Landroid/net/Uri;

    move-result-object v0

    const-string v1, "email"

    invoke-virtual {v0, v1}, Landroid/net/Uri;->getQueryParameter(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p1}, Landroid/content/Intent;->getData()Landroid/net/Uri;

    move-result-object v1

    const-string v2, "code"

    .line 162
    invoke-virtual {v1, v2}, Landroid/net/Uri;->getQueryParameter(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    .line 161
    invoke-virtual {p0, v0, v1}, Lcom/jibo/ui/activity/OnBoardingActivity;->b(Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_1

    .line 163
    :cond_6
    invoke-virtual {p1}, Landroid/content/Intent;->getData()Landroid/net/Uri;

    move-result-object v0

    if-eqz v0, :cond_7

    invoke-virtual {p1}, Landroid/content/Intent;->getData()Landroid/net/Uri;

    move-result-object v0

    invoke-virtual {v0}, Landroid/net/Uri;->toString()Ljava/lang/String;

    move-result-object v0

    const v1, 0x7f1001e8

    invoke-virtual {p0, v1}, Lcom/jibo/ui/activity/OnBoardingActivity;->getString(I)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/String;->contains(Ljava/lang/CharSequence;)Z

    move-result v0

    if-eqz v0, :cond_7

    .line 166
    invoke-virtual {p0}, Lcom/jibo/ui/activity/OnBoardingActivity;->getApplication()Landroid/app/Application;

    move-result-object v0

    check-cast v0, Lcom/jibo/JiboApplication;

    invoke-virtual {v0}, Lcom/jibo/JiboApplication;->b()V

    .line 168
    invoke-virtual {p1}, Landroid/content/Intent;->getData()Landroid/net/Uri;

    move-result-object v0

    const-string v1, "email"

    invoke-virtual {v0, v1}, Landroid/net/Uri;->getQueryParameter(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p1}, Landroid/content/Intent;->getData()Landroid/net/Uri;

    move-result-object v1

    const-string v2, "code"

    .line 169
    invoke-virtual {v1, v2}, Landroid/net/Uri;->getQueryParameter(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    .line 168
    invoke-virtual {p0, v0, v1}, Lcom/jibo/ui/activity/OnBoardingActivity;->c(Ljava/lang/String;Ljava/lang/String;)V

    goto/16 :goto_1

    .line 171
    :cond_7
    invoke-virtual {p1}, Landroid/content/Intent;->getData()Landroid/net/Uri;

    move-result-object v0

    if-eqz v0, :cond_8

    invoke-virtual {p1}, Landroid/content/Intent;->getData()Landroid/net/Uri;

    move-result-object v0

    invoke-virtual {v0}, Landroid/net/Uri;->toString()Ljava/lang/String;

    move-result-object v0

    const v1, 0x7f1001e6

    invoke-virtual {p0, v1}, Lcom/jibo/ui/activity/OnBoardingActivity;->getString(I)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/String;->contains(Ljava/lang/CharSequence;)Z

    move-result v0

    if-eqz v0, :cond_8

    .line 172
    invoke-virtual {p1}, Landroid/content/Intent;->getData()Landroid/net/Uri;

    move-result-object v0

    invoke-direct {p0, v0}, Lcom/jibo/ui/activity/OnBoardingActivity;->b(Landroid/net/Uri;)V

    goto/16 :goto_1

    .line 173
    :cond_8
    invoke-virtual {p1}, Landroid/content/Intent;->getData()Landroid/net/Uri;

    move-result-object v0

    if-eqz v0, :cond_9

    invoke-virtual {p1}, Landroid/content/Intent;->getData()Landroid/net/Uri;

    move-result-object v0

    invoke-virtual {v0}, Landroid/net/Uri;->toString()Ljava/lang/String;

    move-result-object v0

    const v1, 0x7f1001e7

    invoke-virtual {p0, v1}, Lcom/jibo/ui/activity/OnBoardingActivity;->getString(I)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/String;->contains(Ljava/lang/CharSequence;)Z

    move-result v0

    if-eqz v0, :cond_9

    .line 174
    invoke-virtual {p1}, Landroid/content/Intent;->getData()Landroid/net/Uri;

    move-result-object v0

    invoke-direct {p0, v0}, Lcom/jibo/ui/activity/OnBoardingActivity;->b(Landroid/net/Uri;)V

    goto/16 :goto_1

    .line 175
    :cond_9
    invoke-virtual {p1}, Landroid/content/Intent;->getData()Landroid/net/Uri;

    move-result-object v0

    if-eqz v0, :cond_a

    invoke-virtual {p1}, Landroid/content/Intent;->getData()Landroid/net/Uri;

    move-result-object v0

    invoke-virtual {v0}, Landroid/net/Uri;->toString()Ljava/lang/String;

    move-result-object v0

    const v1, 0x7f1001e9

    invoke-virtual {p0, v1}, Lcom/jibo/ui/activity/OnBoardingActivity;->getString(I)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/String;->contains(Ljava/lang/CharSequence;)Z

    move-result v0

    if-eqz v0, :cond_a

    .line 176
    invoke-virtual {p1}, Landroid/content/Intent;->getData()Landroid/net/Uri;

    move-result-object v0

    invoke-direct {p0, v0}, Lcom/jibo/ui/activity/OnBoardingActivity;->a(Landroid/net/Uri;)V

    goto/16 :goto_1

    .line 177
    :cond_a
    invoke-virtual {p1}, Landroid/content/Intent;->getData()Landroid/net/Uri;

    move-result-object v0

    if-eqz v0, :cond_b

    invoke-virtual {p1}, Landroid/content/Intent;->getData()Landroid/net/Uri;

    move-result-object v0

    invoke-virtual {v0}, Landroid/net/Uri;->toString()Ljava/lang/String;

    move-result-object v0

    const v1, 0x7f100141

    invoke-virtual {p0, v1}, Lcom/jibo/ui/activity/OnBoardingActivity;->getString(I)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/String;->contains(Ljava/lang/CharSequence;)Z

    move-result v0

    if-eqz v0, :cond_b

    .line 178
    invoke-virtual {p1}, Landroid/content/Intent;->getData()Landroid/net/Uri;

    move-result-object v0

    invoke-virtual {v0}, Landroid/net/Uri;->toString()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/jibo/ui/activity/OnBoardingActivity;->n:Ljava/lang/String;

    .line 179
    const/4 v0, -0x1

    invoke-virtual {p0, v0, p1}, Lcom/jibo/ui/activity/OnBoardingActivity;->setResult(ILandroid/content/Intent;)V

    .line 180
    invoke-virtual {p0}, Lcom/jibo/ui/activity/OnBoardingActivity;->finish()V

    goto/16 :goto_1

    .line 182
    :cond_b
    invoke-direct {p0}, Lcom/jibo/ui/activity/OnBoardingActivity;->u()V

    goto/16 :goto_1
.end method

.method public b(Ljava/lang/String;)V
    .locals 4

    .prologue
    .line 303
    iget-object v0, p0, Lcom/jibo/ui/activity/OnBoardingActivity;->m:Landroid/os/Bundle;

    const-string v1, "email"

    invoke-virtual {v0, v1, p1}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 304
    invoke-virtual {p0}, Lcom/jibo/ui/activity/OnBoardingActivity;->getSupportFragmentManager()Landroid/support/v4/app/FragmentManager;

    move-result-object v0

    invoke-virtual {v0}, Landroid/support/v4/app/FragmentManager;->a()Landroid/support/v4/app/FragmentTransaction;

    move-result-object v0

    const v1, 0x7f09013f

    const-class v2, Lcom/jibo/ui/fragment/onboarding/ResetPasswordFragment;

    .line 305
    invoke-virtual {v2}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v2

    iget-object v3, p0, Lcom/jibo/ui/activity/OnBoardingActivity;->m:Landroid/os/Bundle;

    invoke-static {p0, v2, v3}, Landroid/support/v4/app/Fragment;->instantiate(Landroid/content/Context;Ljava/lang/String;Landroid/os/Bundle;)Landroid/support/v4/app/Fragment;

    move-result-object v2

    sget-object v3, Lcom/jibo/ui/fragment/onboarding/ResetPasswordFragment;->a:Ljava/lang/String;

    invoke-virtual {v0, v1, v2, v3}, Landroid/support/v4/app/FragmentTransaction;->b(ILandroid/support/v4/app/Fragment;Ljava/lang/String;)Landroid/support/v4/app/FragmentTransaction;

    move-result-object v0

    sget-object v1, Lcom/jibo/ui/fragment/onboarding/ResetPasswordFragment;->a:Ljava/lang/String;

    .line 306
    invoke-virtual {v0, v1}, Landroid/support/v4/app/FragmentTransaction;->a(Ljava/lang/String;)Landroid/support/v4/app/FragmentTransaction;

    move-result-object v0

    invoke-virtual {v0}, Landroid/support/v4/app/FragmentTransaction;->d()I

    .line 307
    return-void
.end method

.method public b(Ljava/lang/String;Ljava/lang/String;)V
    .locals 4

    .prologue
    .line 281
    invoke-static {p1}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 282
    invoke-direct {p0}, Lcom/jibo/ui/activity/OnBoardingActivity;->u()V

    .line 300
    :goto_0
    return-void

    .line 286
    :cond_0
    iget-object v0, p0, Lcom/jibo/ui/activity/OnBoardingActivity;->m:Landroid/os/Bundle;

    const-string v1, "email"

    invoke-virtual {v0, v1, p1}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 287
    iget-object v0, p0, Lcom/jibo/ui/activity/OnBoardingActivity;->m:Landroid/os/Bundle;

    const-string v1, "code"

    invoke-virtual {v0, v1, p2}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 290
    invoke-virtual {p0}, Lcom/jibo/ui/activity/OnBoardingActivity;->getSupportFragmentManager()Landroid/support/v4/app/FragmentManager;

    move-result-object v0

    invoke-virtual {v0}, Landroid/support/v4/app/FragmentManager;->d()Z

    .line 292
    iget-object v0, p0, Lcom/jibo/ui/activity/OnBoardingActivity;->e:Landroid/support/v7/widget/Toolbar;

    new-instance v1, Lcom/jibo/ui/activity/OnBoardingActivity$1;

    invoke-direct {v1, p0}, Lcom/jibo/ui/activity/OnBoardingActivity$1;-><init>(Lcom/jibo/ui/activity/OnBoardingActivity;)V

    const-wide/16 v2, 0x1f4

    invoke-virtual {v0, v1, v2, v3}, Landroid/support/v7/widget/Toolbar;->postDelayed(Ljava/lang/Runnable;J)Z

    goto :goto_0
.end method

.method public c(Ljava/lang/String;)V
    .locals 4

    .prologue
    .line 330
    iget-object v0, p0, Lcom/jibo/ui/activity/OnBoardingActivity;->m:Landroid/os/Bundle;

    const-string v1, "code"

    invoke-virtual {v0, v1, p1}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 332
    invoke-virtual {p0}, Lcom/jibo/ui/activity/OnBoardingActivity;->getSupportFragmentManager()Landroid/support/v4/app/FragmentManager;

    move-result-object v0

    invoke-virtual {v0}, Landroid/support/v4/app/FragmentManager;->a()Landroid/support/v4/app/FragmentTransaction;

    move-result-object v0

    const v1, 0x7f09013f

    const-class v2, Lcom/jibo/ui/fragment/onboarding/ResetPasswordNewPasswordFragment;

    .line 334
    invoke-virtual {v2}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v2

    iget-object v3, p0, Lcom/jibo/ui/activity/OnBoardingActivity;->m:Landroid/os/Bundle;

    .line 332
    invoke-static {p0, v2, v3}, Landroid/support/v4/app/Fragment;->instantiate(Landroid/content/Context;Ljava/lang/String;Landroid/os/Bundle;)Landroid/support/v4/app/Fragment;

    move-result-object v2

    sget-object v3, Lcom/jibo/ui/fragment/onboarding/ResetPasswordNewPasswordFragment;->a:Ljava/lang/String;

    invoke-virtual {v0, v1, v2, v3}, Landroid/support/v4/app/FragmentTransaction;->b(ILandroid/support/v4/app/Fragment;Ljava/lang/String;)Landroid/support/v4/app/FragmentTransaction;

    move-result-object v0

    sget-object v1, Lcom/jibo/ui/fragment/onboarding/ResetPasswordNewPasswordFragment;->a:Ljava/lang/String;

    .line 335
    invoke-virtual {v0, v1}, Landroid/support/v4/app/FragmentTransaction;->a(Ljava/lang/String;)Landroid/support/v4/app/FragmentTransaction;

    move-result-object v0

    invoke-virtual {v0}, Landroid/support/v4/app/FragmentTransaction;->d()I

    .line 336
    return-void
.end method

.method public c(Ljava/lang/String;Ljava/lang/String;)V
    .locals 4

    .prologue
    .line 311
    invoke-static {p1}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 312
    invoke-direct {p0}, Lcom/jibo/ui/activity/OnBoardingActivity;->u()V

    .line 327
    :goto_0
    return-void

    .line 319
    :cond_0
    iget-object v0, p0, Lcom/jibo/ui/activity/OnBoardingActivity;->m:Landroid/os/Bundle;

    const-string v1, "email"

    invoke-virtual {v0, v1, p1}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 320
    iget-object v0, p0, Lcom/jibo/ui/activity/OnBoardingActivity;->m:Landroid/os/Bundle;

    const-string v1, "code"

    invoke-virtual {v0, v1, p2}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 322
    invoke-virtual {p0}, Lcom/jibo/ui/activity/OnBoardingActivity;->getSupportFragmentManager()Landroid/support/v4/app/FragmentManager;

    move-result-object v0

    invoke-virtual {v0}, Landroid/support/v4/app/FragmentManager;->a()Landroid/support/v4/app/FragmentTransaction;

    move-result-object v0

    .line 323
    const v1, 0x7f09013f

    const-class v2, Lcom/jibo/ui/fragment/onboarding/ResetPasswordSentFragment;

    .line 324
    invoke-virtual {v2}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v2

    iget-object v3, p0, Lcom/jibo/ui/activity/OnBoardingActivity;->m:Landroid/os/Bundle;

    .line 323
    invoke-static {p0, v2, v3}, Landroid/support/v4/app/Fragment;->instantiate(Landroid/content/Context;Ljava/lang/String;Landroid/os/Bundle;)Landroid/support/v4/app/Fragment;

    move-result-object v2

    sget-object v3, Lcom/jibo/ui/fragment/onboarding/ResetPasswordSentFragment;->a:Ljava/lang/String;

    invoke-virtual {v0, v1, v2, v3}, Landroid/support/v4/app/FragmentTransaction;->b(ILandroid/support/v4/app/Fragment;Ljava/lang/String;)Landroid/support/v4/app/FragmentTransaction;

    move-result-object v0

    sget-object v1, Lcom/jibo/ui/fragment/onboarding/ResetPasswordSentFragment;->a:Ljava/lang/String;

    .line 324
    invoke-virtual {v0, v1}, Landroid/support/v4/app/FragmentTransaction;->a(Ljava/lang/String;)Landroid/support/v4/app/FragmentTransaction;

    move-result-object v0

    .line 325
    invoke-virtual {v0}, Landroid/support/v4/app/FragmentTransaction;->d()I

    goto :goto_0
.end method

.method public e()V
    .locals 0

    .prologue
    .line 135
    return-void
.end method

.method public onBackPressed()V
    .locals 2

    .prologue
    .line 108
    invoke-virtual {p0}, Lcom/jibo/ui/activity/OnBoardingActivity;->l()V

    .line 112
    invoke-virtual {p0}, Lcom/jibo/ui/activity/OnBoardingActivity;->getSupportFragmentManager()Landroid/support/v4/app/FragmentManager;

    move-result-object v0

    invoke-virtual {v0}, Landroid/support/v4/app/FragmentManager;->e()I

    move-result v0

    const/4 v1, 0x1

    if-ne v0, v1, :cond_3

    .line 114
    invoke-virtual {p0}, Lcom/jibo/ui/activity/OnBoardingActivity;->getSupportFragmentManager()Landroid/support/v4/app/FragmentManager;

    move-result-object v0

    sget-object v1, Lcom/jibo/ui/fragment/onboarding/SignupCompleteFragment;->a:Ljava/lang/String;

    invoke-virtual {v0, v1}, Landroid/support/v4/app/FragmentManager;->a(Ljava/lang/String;)Landroid/support/v4/app/Fragment;

    move-result-object v0

    if-nez v0, :cond_0

    .line 115
    invoke-virtual {p0}, Lcom/jibo/ui/activity/OnBoardingActivity;->getSupportFragmentManager()Landroid/support/v4/app/FragmentManager;

    move-result-object v0

    sget-object v1, Lcom/jibo/ui/fragment/onboarding/LoginFragment;->a:Ljava/lang/String;

    invoke-virtual {v0, v1}, Landroid/support/v4/app/FragmentManager;->a(Ljava/lang/String;)Landroid/support/v4/app/Fragment;

    move-result-object v0

    if-nez v0, :cond_0

    .line 116
    invoke-virtual {p0}, Lcom/jibo/ui/activity/OnBoardingActivity;->getSupportFragmentManager()Landroid/support/v4/app/FragmentManager;

    move-result-object v0

    sget-object v1, Lcom/jibo/ui/fragment/onboarding/AboutYouFragment;->n:Ljava/lang/String;

    invoke-virtual {v0, v1}, Landroid/support/v4/app/FragmentManager;->a(Ljava/lang/String;)Landroid/support/v4/app/Fragment;

    move-result-object v0

    if-eqz v0, :cond_1

    .line 117
    :cond_0
    invoke-virtual {p0}, Lcom/jibo/ui/activity/OnBoardingActivity;->q()V

    .line 131
    :goto_0
    return-void

    .line 121
    :cond_1
    invoke-virtual {p0}, Lcom/jibo/ui/activity/OnBoardingActivity;->getSupportFragmentManager()Landroid/support/v4/app/FragmentManager;

    move-result-object v0

    sget-object v1, Lcom/jibo/ui/fragment/onboarding/ResetPasswordSentFragment;->a:Ljava/lang/String;

    invoke-virtual {v0, v1}, Landroid/support/v4/app/FragmentManager;->a(Ljava/lang/String;)Landroid/support/v4/app/Fragment;

    move-result-object v0

    if-nez v0, :cond_2

    .line 122
    invoke-virtual {p0}, Lcom/jibo/ui/activity/OnBoardingActivity;->getSupportFragmentManager()Landroid/support/v4/app/FragmentManager;

    move-result-object v0

    sget-object v1, Lcom/jibo/ui/fragment/onboarding/ResetPasswordNewPasswordFragment;->a:Ljava/lang/String;

    invoke-virtual {v0, v1}, Landroid/support/v4/app/FragmentManager;->a(Ljava/lang/String;)Landroid/support/v4/app/Fragment;

    move-result-object v0

    if-eqz v0, :cond_3

    .line 123
    :cond_2
    invoke-virtual {p0}, Lcom/jibo/ui/activity/OnBoardingActivity;->m()V

    .line 124
    const/4 v0, 0x0

    invoke-virtual {p0, v0}, Lcom/jibo/ui/activity/OnBoardingActivity;->a(Ljava/lang/String;)V

    goto :goto_0

    .line 130
    :cond_3
    invoke-super {p0}, Lcom/jibo/ui/activity/BaseActivity;->onBackPressed()V

    goto :goto_0
.end method

.method protected onCreate(Landroid/os/Bundle;)V
    .locals 5

    .prologue
    const/4 v4, 0x2

    const/4 v3, 0x0

    const-string v0, "com.jibo.ui.activity.OnBoardingActivity"

    invoke-static {v0}, Lcom/google/firebase/perf/metrics/AppStartTrace;->setLauncherActivityOnCreateTime(Ljava/lang/String;)V

    .line 66
    invoke-virtual {p0}, Lcom/jibo/ui/activity/OnBoardingActivity;->getIntent()Landroid/content/Intent;

    move-result-object v0

    sget-object v1, Lcom/jibo/ui/activity/BaseActivity;->b:Ljava/lang/String;

    const v2, 0x7f0b0021

    invoke-virtual {v0, v1, v2}, Landroid/content/Intent;->putExtra(Ljava/lang/String;I)Landroid/content/Intent;

    .line 67
    invoke-super {p0, p1}, Lcom/jibo/ui/activity/BaseActivity;->onCreate(Landroid/os/Bundle;)V

    .line 68
    const/4 v0, 0x1

    new-array v0, v0, [Lio/fabric/sdk/android/Kit;

    new-instance v1, Lcom/crashlytics/android/Crashlytics;

    invoke-direct {v1}, Lcom/crashlytics/android/Crashlytics;-><init>()V

    aput-object v1, v0, v3

    invoke-static {p0, v0}, Lio/fabric/sdk/android/Fabric;->a(Landroid/content/Context;[Lio/fabric/sdk/android/Kit;)Lio/fabric/sdk/android/Fabric;

    .line 72
    const-string v0, "jibo"

    const-string v1, "netposa"

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_1

    .line 84
    :goto_0
    if-nez p1, :cond_0

    .line 85
    invoke-virtual {p0}, Lcom/jibo/ui/activity/OnBoardingActivity;->getIntent()Landroid/content/Intent;

    move-result-object v0

    invoke-virtual {p0, v0}, Lcom/jibo/ui/activity/OnBoardingActivity;->a(Landroid/content/Intent;)Z

    .line 87
    :cond_0
    return-void

    .line 75
    :cond_1
    const v0, 0x7f100037

    .line 76
    invoke-virtual {p0, v0}, Lcom/jibo/ui/activity/OnBoardingActivity;->getString(I)Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p0, v0, v3}, Lcom/jibo/ui/activity/OnBoardingActivity;->getSharedPreferences(Ljava/lang/String;I)Landroid/content/SharedPreferences;

    move-result-object v0

    .line 77
    sget-object v1, Lcom/jibo/aws/integration/util/Commons;->ALLOWED_ENDPOINTS:[Ljava/lang/String;

    aget-object v1, v1, v4

    invoke-static {v1}, Lcom/jibo/aws/integration/util/Commons;->setRootEndpoint(Ljava/lang/String;)V

    .line 78
    invoke-interface {v0}, Landroid/content/SharedPreferences;->edit()Landroid/content/SharedPreferences$Editor;

    move-result-object v0

    const-string v1, "PREF_END_POINT"

    sget-object v2, Lcom/jibo/aws/integration/util/Commons;->ALLOWED_ENDPOINTS:[Ljava/lang/String;

    aget-object v2, v2, v4

    invoke-interface {v0, v1, v2}, Landroid/content/SharedPreferences$Editor;->putString(Ljava/lang/String;Ljava/lang/String;)Landroid/content/SharedPreferences$Editor;

    move-result-object v0

    .line 79
    invoke-interface {v0}, Landroid/content/SharedPreferences$Editor;->apply()V

    goto :goto_0
.end method

.method protected onNewIntent(Landroid/content/Intent;)V
    .locals 1

    .prologue
    .line 91
    invoke-virtual {p0, p1}, Lcom/jibo/ui/activity/OnBoardingActivity;->setIntent(Landroid/content/Intent;)V

    .line 94
    invoke-virtual {p0, p1}, Lcom/jibo/ui/activity/OnBoardingActivity;->a(Landroid/content/Intent;)Z

    move-result v0

    if-nez v0, :cond_0

    invoke-super {p0, p1}, Lcom/jibo/ui/activity/BaseActivity;->onNewIntent(Landroid/content/Intent;)V

    .line 95
    :cond_0
    return-void
.end method

.method protected onResume()V
    .locals 1

    const-string v0, "com.jibo.ui.activity.OnBoardingActivity"

    invoke-static {v0}, Lcom/google/firebase/perf/metrics/AppStartTrace;->setLauncherActivityOnResumeTime(Ljava/lang/String;)V

    invoke-super {p0}, Lcom/jibo/ui/activity/BaseActivity;->onResume()V

    return-void
.end method

.method protected onResumeFragments()V
    .locals 0

    .prologue
    .line 99
    invoke-super {p0}, Lcom/jibo/ui/activity/BaseActivity;->onResumeFragments()V

    .line 102
    return-void
.end method

.method protected onStart()V
    .locals 1

    const-string v0, "com.jibo.ui.activity.OnBoardingActivity"

    invoke-static {v0}, Lcom/google/firebase/perf/metrics/AppStartTrace;->setLauncherActivityOnStartTime(Ljava/lang/String;)V

    invoke-super {p0}, Lcom/jibo/ui/activity/BaseActivity;->onStart()V

    return-void
.end method

.method public q()V
    .locals 2

    .prologue
    .line 253
    invoke-virtual {p0}, Lcom/jibo/ui/activity/OnBoardingActivity;->m()V

    .line 255
    const-class v0, Lcom/jibo/ui/fragment/onboarding/WelcomeFragment;

    iget-object v1, p0, Lcom/jibo/ui/activity/OnBoardingActivity;->m:Landroid/os/Bundle;

    invoke-virtual {p0, v0, v1}, Lcom/jibo/ui/activity/OnBoardingActivity;->a(Ljava/lang/Class;Landroid/os/Bundle;)V

    .line 256
    return-void
.end method

.method public r()V
    .locals 2

    .prologue
    .line 383
    invoke-virtual {p0}, Lcom/jibo/ui/activity/OnBoardingActivity;->m()V

    .line 385
    const-class v0, Lcom/jibo/ui/fragment/phone/PhoneFillFragment;

    iget-object v1, p0, Lcom/jibo/ui/activity/OnBoardingActivity;->m:Landroid/os/Bundle;

    invoke-virtual {p0, v0, v1}, Lcom/jibo/ui/activity/OnBoardingActivity;->a(Ljava/lang/Class;Landroid/os/Bundle;)V

    .line 386
    return-void
.end method

.method public s()V
    .locals 2

    .prologue
    .line 389
    invoke-virtual {p0}, Lcom/jibo/ui/activity/OnBoardingActivity;->m()V

    .line 391
    const-class v0, Lcom/jibo/ui/fragment/onboarding/AboutYouFragment;

    iget-object v1, p0, Lcom/jibo/ui/activity/OnBoardingActivity;->m:Landroid/os/Bundle;

    invoke-virtual {p0, v0, v1}, Lcom/jibo/ui/activity/OnBoardingActivity;->a(Ljava/lang/Class;Landroid/os/Bundle;)V

    .line 392
    return-void
.end method

.method public t()V
    .locals 4

    .prologue
    .line 395
    invoke-virtual {p0}, Lcom/jibo/ui/activity/OnBoardingActivity;->getSupportFragmentManager()Landroid/support/v4/app/FragmentManager;

    move-result-object v0

    invoke-virtual {v0}, Landroid/support/v4/app/FragmentManager;->a()Landroid/support/v4/app/FragmentTransaction;

    move-result-object v0

    const v1, 0x7f09013f

    const-class v2, Lcom/jibo/ui/fragment/onboarding/DevSettingsFragment;

    .line 396
    invoke-virtual {v2}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v2

    iget-object v3, p0, Lcom/jibo/ui/activity/OnBoardingActivity;->m:Landroid/os/Bundle;

    .line 395
    invoke-static {p0, v2, v3}, Landroid/support/v4/app/Fragment;->instantiate(Landroid/content/Context;Ljava/lang/String;Landroid/os/Bundle;)Landroid/support/v4/app/Fragment;

    move-result-object v2

    sget-object v3, Lcom/jibo/ui/fragment/onboarding/DevSettingsFragment;->a:Ljava/lang/String;

    invoke-virtual {v0, v1, v2, v3}, Landroid/support/v4/app/FragmentTransaction;->b(ILandroid/support/v4/app/Fragment;Ljava/lang/String;)Landroid/support/v4/app/FragmentTransaction;

    move-result-object v0

    sget-object v1, Lcom/jibo/ui/fragment/onboarding/DevSettingsFragment;->a:Ljava/lang/String;

    .line 397
    invoke-virtual {v0, v1}, Landroid/support/v4/app/FragmentTransaction;->a(Ljava/lang/String;)Landroid/support/v4/app/FragmentTransaction;

    move-result-object v0

    invoke-virtual {v0}, Landroid/support/v4/app/FragmentTransaction;->d()I

    .line 398
    return-void
.end method
