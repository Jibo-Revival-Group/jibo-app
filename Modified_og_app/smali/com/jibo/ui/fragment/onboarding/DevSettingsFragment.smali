.class public Lcom/jibo/ui/fragment/onboarding/DevSettingsFragment;
.super Lcom/jibo/ui/fragment/BaseFragment;
.source "DevSettingsFragment.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/jibo/ui/fragment/onboarding/DevSettingsFragment$ListAttributionsAsyncTask;,
        Lcom/jibo/ui/fragment/onboarding/DevSettingsFragment$MyGestureListener;
    }
.end annotation


# static fields
.field public static final a:Ljava/lang/String;


# instance fields
.field private b:I

.field buttonSetEndpoint:Landroid/widget/Button;
    .annotation build Lbutterknife/BindView;
    .end annotation
.end field

.field private c:Landroid/support/v4/view/GestureDetectorCompat;

.field current_endpoint:Landroid/widget/TextView;
    .annotation build Lbutterknife/BindView;
    .end annotation
.end field

.field private d:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/jibo/aws/integration/aws/services/loop/model/Loop;",
            ">;"
        }
    .end annotation
.end field

.field endpointEdit:Landroid/widget/EditText;
    .annotation build Lbutterknife/BindView;
    .end annotation
.end field

.field endpointSpinner:Landroid/widget/Spinner;
    .annotation build Lbutterknife/BindView;
    .end annotation
.end field

.field gqaLoopsSpinner:Landroid/widget/Spinner;
    .annotation build Lbutterknife/BindView;
    .end annotation
.end field

.field loops1Spinner:Landroid/widget/Spinner;
    .annotation build Lbutterknife/BindView;
    .end annotation
.end field

.field loopsSpinner:Landroid/widget/Spinner;
    .annotation build Lbutterknife/BindView;
    .end annotation
.end field

.field questionEdit:Landroid/widget/EditText;
    .annotation build Lbutterknife/BindView;
    .end annotation
.end field

.field responseText:Landroid/widget/TextView;
    .annotation build Lbutterknife/BindView;
    .end annotation
.end field

.field suspensionLoopSpinner:Landroid/widget/Spinner;
    .annotation build Lbutterknife/BindView;
    .end annotation
.end field

.field switchEncryption:Landroid/widget/Switch;
    .annotation build Lbutterknife/BindView;
    .end annotation
.end field

.field textVersion:Landroid/widget/TextView;
    .annotation build Lbutterknife/BindView;
    .end annotation
.end field

.field ugcKeyText:Landroid/widget/TextView;
    .annotation build Lbutterknife/BindView;
    .end annotation
.end field

.field ugcLoopSpinner:Landroid/widget/Spinner;
    .annotation build Lbutterknife/BindView;
    .end annotation
.end field


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 68
    const-class v0, Lcom/jibo/ui/fragment/onboarding/DevSettingsFragment;

    invoke-virtual {v0}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/jibo/ui/fragment/onboarding/DevSettingsFragment;->a:Ljava/lang/String;

    return-void
.end method

.method public constructor <init>()V
    .locals 1

    .prologue
    .line 108
    invoke-direct {p0}, Lcom/jibo/ui/fragment/BaseFragment;-><init>()V

    .line 102
    const/4 v0, 0x0

    iput v0, p0, Lcom/jibo/ui/fragment/onboarding/DevSettingsFragment;->b:I

    .line 106
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/jibo/ui/fragment/onboarding/DevSettingsFragment;->d:Ljava/util/List;

    .line 110
    return-void
.end method

.method static synthetic a(Lcom/jibo/ui/fragment/onboarding/DevSettingsFragment;)I
    .locals 1

    .prologue
    .line 66
    iget v0, p0, Lcom/jibo/ui/fragment/onboarding/DevSettingsFragment;->b:I

    return v0
.end method

.method static synthetic a(Lcom/jibo/ui/fragment/onboarding/DevSettingsFragment;I)I
    .locals 0

    .prologue
    .line 66
    iput p1, p0, Lcom/jibo/ui/fragment/onboarding/DevSettingsFragment;->b:I

    return p1
.end method

.method static synthetic b(Lcom/jibo/ui/fragment/onboarding/DevSettingsFragment;)Ljava/util/List;
    .locals 1

    .prologue
    .line 66
    iget-object v0, p0, Lcom/jibo/ui/fragment/onboarding/DevSettingsFragment;->d:Ljava/util/List;

    return-object v0
.end method


# virtual methods
.method protected a(Landroid/support/v7/app/ActionBar;)V
    .locals 1

    .prologue
    .line 236
    invoke-super {p0, p1}, Lcom/jibo/ui/fragment/BaseFragment;->a(Landroid/support/v7/app/ActionBar;)V

    .line 237
    const/4 v0, 0x1

    invoke-virtual {p1, v0}, Landroid/support/v7/app/ActionBar;->setDisplayHomeAsUpEnabled(Z)V

    .line 238
    return-void
.end method

.method public logout(Landroid/view/View;)V
    .locals 2
    .annotation build Lbutterknife/OnClick;
    .end annotation

    .prologue
    .line 247
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/onboarding/DevSettingsFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    instance-of v0, v0, Lcom/jibo/ui/activity/OnBoardingActivity;

    if-eqz v0, :cond_0

    .line 248
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/onboarding/DevSettingsFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    invoke-virtual {v0}, Landroid/support/v4/app/FragmentActivity;->getApplication()Landroid/app/Application;

    move-result-object v0

    check-cast v0, Lcom/jibo/JiboApplication;

    invoke-virtual {v0}, Lcom/jibo/JiboApplication;->b()V

    .line 249
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/onboarding/DevSettingsFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    check-cast v0, Lcom/jibo/ui/activity/OnBoardingActivity;

    invoke-virtual {v0}, Lcom/jibo/ui/activity/OnBoardingActivity;->q()V

    .line 254
    :goto_0
    return-void

    .line 251
    :cond_0
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/onboarding/DevSettingsFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    sget v1, Lcom/jibo/ui/activity/TabbedActivity;->c:I

    invoke-virtual {v0, v1}, Landroid/support/v4/app/FragmentActivity;->setResult(I)V

    .line 252
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/onboarding/DevSettingsFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    invoke-virtual {v0}, Landroid/support/v4/app/FragmentActivity;->finish()V

    goto :goto_0
.end method

.method protected o()Ljava/lang/String;
    .locals 1

    .prologue
    .line 242
    const-string v0, "Debug Screen"

    return-object v0
.end method

.method public onBtnGenerateKeyClick(Landroid/view/View;)V
    .locals 4
    .annotation build Lbutterknife/OnClick;
    .end annotation

    .prologue
    .line 334
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/onboarding/DevSettingsFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    .line 335
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/onboarding/DevSettingsFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v1

    invoke-static {v1}, Lcom/jibo/db/EntityData;->a(Landroid/content/Context;)Lcom/jibo/db/EntityData;

    move-result-object v1

    invoke-virtual {v1}, Lcom/jibo/db/EntityData;->i()Lcom/jibo/aws/integration/aws/services/account/model/Account;

    move-result-object v1

    invoke-virtual {v1}, Lcom/jibo/aws/integration/aws/services/account/model/Account;->getId()Ljava/lang/String;

    move-result-object v1

    .line 334
    invoke-static {v0, v1}, Lcom/jibo/aws/integration/util/KeyManager;->getInstance(Landroid/content/Context;Ljava/lang/String;)Lcom/jibo/aws/integration/util/KeyManager;

    move-result-object v1

    .line 337
    :try_start_0
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/onboarding/DevSettingsFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v2

    iget-object v0, p0, Lcom/jibo/ui/fragment/onboarding/DevSettingsFragment;->d:Ljava/util/List;

    iget-object v3, p0, Lcom/jibo/ui/fragment/onboarding/DevSettingsFragment;->loops1Spinner:Landroid/widget/Spinner;

    .line 338
    invoke-virtual {v3}, Landroid/widget/Spinner;->getSelectedItemPosition()I

    move-result v3

    invoke-interface {v0, v3}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/jibo/aws/integration/aws/services/loop/model/Loop;

    invoke-virtual {v0}, Lcom/jibo/aws/integration/aws/services/loop/model/Loop;->getId()Ljava/lang/String;

    move-result-object v0

    const/4 v3, 0x1

    .line 337
    invoke-virtual {v1, v2, v0, v3}, Lcom/jibo/aws/integration/util/KeyManager;->generateSymmetricKey(Landroid/content/Context;Ljava/lang/String;Z)V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 343
    :goto_0
    return-void

    .line 339
    :catch_0
    move-exception v0

    .line 340
    sget-object v1, Lcom/jibo/ui/fragment/onboarding/DevSettingsFragment;->a:Ljava/lang/String;

    const-string v2, "Could not generate key"

    invoke-static {v1, v2, v0}, Lcom/jibo/utils/LogUtils;->b(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V

    .line 341
    invoke-static {v0}, Lcom/crashlytics/android/Crashlytics;->a(Ljava/lang/Throwable;)V

    goto :goto_0
.end method

.method public onBtnListAttributions(Landroid/view/View;)V
    .locals 2
    .annotation build Lbutterknife/OnClick;
    .end annotation

    .prologue
    .line 276
    new-instance v0, Lcom/jibo/ui/fragment/onboarding/DevSettingsFragment$ListAttributionsAsyncTask;

    const/4 v1, 0x0

    invoke-direct {v0, p0, v1}, Lcom/jibo/ui/fragment/onboarding/DevSettingsFragment$ListAttributionsAsyncTask;-><init>(Lcom/jibo/ui/fragment/onboarding/DevSettingsFragment;Lcom/jibo/ui/fragment/onboarding/DevSettingsFragment$1;)V

    .line 277
    const/4 v1, 0x0

    new-array v1, v1, [Ljava/lang/Void;

    invoke-virtual {v0, v1}, Lcom/jibo/ui/fragment/onboarding/DevSettingsFragment$ListAttributionsAsyncTask;->execute([Ljava/lang/Object;)Landroid/os/AsyncTask;

    .line 278
    return-void
.end method

.method public onBtnRequestKeyClick(Landroid/view/View;)V
    .locals 4
    .annotation build Lbutterknife/OnClick;
    .end annotation

    .prologue
    .line 259
    new-instance v1, Landroid/content/Intent;

    invoke-virtual {p0}, Lcom/jibo/ui/fragment/onboarding/DevSettingsFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    const-class v2, Lcom/jibo/service/KeyRequestingSharingService;

    invoke-direct {v1, v0, v2}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .line 260
    const-string v0, "ACTION_REQUEST_KEY"

    invoke-virtual {v1, v0}, Landroid/content/Intent;->setAction(Ljava/lang/String;)Landroid/content/Intent;

    .line 261
    const-string v2, "loopId"

    iget-object v0, p0, Lcom/jibo/ui/fragment/onboarding/DevSettingsFragment;->d:Ljava/util/List;

    iget-object v3, p0, Lcom/jibo/ui/fragment/onboarding/DevSettingsFragment;->loopsSpinner:Landroid/widget/Spinner;

    invoke-virtual {v3}, Landroid/widget/Spinner;->getSelectedItemPosition()I

    move-result v3

    invoke-interface {v0, v3}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/jibo/aws/integration/aws/services/loop/model/Loop;

    invoke-virtual {v0}, Lcom/jibo/aws/integration/aws/services/loop/model/Loop;->getId()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v1, v2, v0}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 262
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/onboarding/DevSettingsFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    invoke-static {v0, v1}, Lcom/jibo/utils/ServiceUtils;->a(Landroid/content/Context;Landroid/content/Intent;)V

    .line 263
    return-void
.end method

.method public onBtnSendQuestion(Landroid/view/View;)V
    .locals 4
    .annotation build Lbutterknife/OnClick;
    .end annotation

    .prologue
    .line 282
    iget-object v0, p0, Lcom/jibo/ui/fragment/onboarding/DevSettingsFragment;->questionEdit:Landroid/widget/EditText;

    invoke-virtual {v0}, Landroid/widget/EditText;->getText()Landroid/text/Editable;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v1

    .line 283
    iget-object v0, p0, Lcom/jibo/ui/fragment/onboarding/DevSettingsFragment;->d:Ljava/util/List;

    iget-object v2, p0, Lcom/jibo/ui/fragment/onboarding/DevSettingsFragment;->gqaLoopsSpinner:Landroid/widget/Spinner;

    invoke-virtual {v2}, Landroid/widget/Spinner;->getSelectedItemPosition()I

    move-result v2

    invoke-interface {v0, v2}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/jibo/aws/integration/aws/services/loop/model/Loop;

    .line 285
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/onboarding/DevSettingsFragment;->getContext()Landroid/content/Context;

    move-result-object v2

    invoke-static {v2}, Lcom/jibo/db/EntityData;->a(Landroid/content/Context;)Lcom/jibo/db/EntityData;

    move-result-object v2

    invoke-virtual {v2}, Lcom/jibo/db/EntityData;->b()Lcom/jibo/aws/integration/aws/services/loop/JiboLoopAsyncClient;

    move-result-object v2

    .line 287
    invoke-virtual {v0}, Lcom/jibo/aws/integration/aws/services/loop/model/Loop;->getId()Ljava/lang/String;

    move-result-object v0

    new-instance v3, Lcom/jibo/ui/fragment/onboarding/DevSettingsFragment$5;

    invoke-direct {v3, p0, v1}, Lcom/jibo/ui/fragment/onboarding/DevSettingsFragment$5;-><init>(Lcom/jibo/ui/fragment/onboarding/DevSettingsFragment;Ljava/lang/String;)V

    invoke-virtual {v2, v0, v3}, Lcom/jibo/aws/integration/aws/services/loop/JiboLoopAsyncClient;->getRobot(Ljava/lang/String;Lcom/amazonaws/handlers/AsyncHandler;)Ljava/util/concurrent/Future;

    .line 329
    return-void
.end method

.method public onBtnSuspendLoopClick(Landroid/view/View;)V
    .locals 2
    .annotation build Lbutterknife/OnClick;
    .end annotation

    .prologue
    .line 366
    iget-object v0, p0, Lcom/jibo/ui/fragment/onboarding/DevSettingsFragment;->d:Ljava/util/List;

    iget-object v1, p0, Lcom/jibo/ui/fragment/onboarding/DevSettingsFragment;->suspensionLoopSpinner:Landroid/widget/Spinner;

    invoke-virtual {v1}, Landroid/widget/Spinner;->getSelectedItemPosition()I

    move-result v1

    invoke-interface {v0, v1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/jibo/aws/integration/aws/services/loop/model/Loop;

    invoke-virtual {v0}, Lcom/jibo/aws/integration/aws/services/loop/model/Loop;->getId()Ljava/lang/String;

    move-result-object v0

    new-instance v1, Lcom/jibo/ui/fragment/onboarding/DevSettingsFragment$6;

    invoke-direct {v1, p0}, Lcom/jibo/ui/fragment/onboarding/DevSettingsFragment$6;-><init>(Lcom/jibo/ui/fragment/onboarding/DevSettingsFragment;)V

    invoke-static {v0, v1}, Lcom/jibo/aws/integration/helpers/LoopHelper;->suspendLoop(Ljava/lang/String;Lcom/jibo/aws/integration/util/Commons$AsyncCallback;)V

    .line 385
    return-void
.end method

.method public onCreateView(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;
    .locals 2

    .prologue
    .line 114
    const v0, 0x7f0b0068

    const/4 v1, 0x0

    invoke-virtual {p1, v0, p2, v1}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    move-result-object v0

    return-object v0
.end method

.method public onViewCreated(Landroid/view/View;Landroid/os/Bundle;)V
    .locals 10

    .prologue
    const/4 v7, 0x0

    const v9, 0x7f0b00cc

    const/4 v6, 0x0

    .line 119
    invoke-super {p0, p1, p2}, Lcom/jibo/ui/fragment/BaseFragment;->onViewCreated(Landroid/view/View;Landroid/os/Bundle;)V

    .line 121
    new-instance v0, Landroid/support/v4/view/GestureDetectorCompat;

    invoke-virtual {p0}, Lcom/jibo/ui/fragment/onboarding/DevSettingsFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v1

    new-instance v2, Lcom/jibo/ui/fragment/onboarding/DevSettingsFragment$MyGestureListener;

    invoke-direct {v2, p0}, Lcom/jibo/ui/fragment/onboarding/DevSettingsFragment$MyGestureListener;-><init>(Lcom/jibo/ui/fragment/onboarding/DevSettingsFragment;)V

    invoke-direct {v0, v1, v2}, Landroid/support/v4/view/GestureDetectorCompat;-><init>(Landroid/content/Context;Landroid/view/GestureDetector$OnGestureListener;)V

    iput-object v0, p0, Lcom/jibo/ui/fragment/onboarding/DevSettingsFragment;->c:Landroid/support/v4/view/GestureDetectorCompat;

    .line 123
    iget-object v0, p0, Lcom/jibo/ui/fragment/onboarding/DevSettingsFragment;->endpointSpinner:Landroid/widget/Spinner;

    new-instance v1, Landroid/widget/ArrayAdapter;

    invoke-virtual {p0}, Lcom/jibo/ui/fragment/onboarding/DevSettingsFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v2

    sget-object v3, Lcom/jibo/aws/integration/util/Commons;->ALLOWED_ENDPOINTS:[Ljava/lang/String;

    invoke-direct {v1, v2, v9, v3}, Landroid/widget/ArrayAdapter;-><init>(Landroid/content/Context;I[Ljava/lang/Object;)V

    invoke-virtual {v0, v1}, Landroid/widget/Spinner;->setAdapter(Landroid/widget/SpinnerAdapter;)V

    .line 125
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/onboarding/DevSettingsFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    const v1, 0x7f100037

    .line 126
    invoke-virtual {p0, v1}, Lcom/jibo/ui/fragment/onboarding/DevSettingsFragment;->getString(I)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1, v6}, Landroid/support/v4/app/FragmentActivity;->getSharedPreferences(Ljava/lang/String;I)Landroid/content/SharedPreferences;

    move-result-object v1

    .line 127
    const-string v0, "PREF_END_POINT"

    sget-object v2, Lcom/jibo/aws/integration/util/Commons;->ROOT_ENDPOINT:Ljava/lang/String;

    invoke-interface {v1, v0, v2}, Landroid/content/SharedPreferences;->getString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    move v0, v6

    .line 129
    :goto_0
    sget-object v3, Lcom/jibo/aws/integration/util/Commons;->ALLOWED_ENDPOINTS:[Ljava/lang/String;

    array-length v3, v3

    if-ge v0, v3, :cond_0

    .line 130
    sget-object v3, Lcom/jibo/aws/integration/util/Commons;->ALLOWED_ENDPOINTS:[Ljava/lang/String;

    aget-object v3, v3, v0

    invoke-virtual {v3, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_2

    .line 131
    iput v0, p0, Lcom/jibo/ui/fragment/onboarding/DevSettingsFragment;->b:I

    .line 135
    :cond_0
    iget-object v0, p0, Lcom/jibo/ui/fragment/onboarding/DevSettingsFragment;->endpointSpinner:Landroid/widget/Spinner;

    iget v2, p0, Lcom/jibo/ui/fragment/onboarding/DevSettingsFragment;->b:I

    invoke-virtual {v0, v2, v6}, Landroid/widget/Spinner;->setSelection(IZ)V

    .line 136
    iget-object v0, p0, Lcom/jibo/ui/fragment/onboarding/DevSettingsFragment;->endpointSpinner:Landroid/widget/Spinner;

    new-instance v2, Lcom/jibo/ui/fragment/onboarding/DevSettingsFragment$1;

    invoke-direct {v2, p0, v1}, Lcom/jibo/ui/fragment/onboarding/DevSettingsFragment$1;-><init>(Lcom/jibo/ui/fragment/onboarding/DevSettingsFragment;Landroid/content/SharedPreferences;)V

    invoke-virtual {v0, v2}, Landroid/widget/Spinner;->setOnItemSelectedListener(Landroid/widget/AdapterView$OnItemSelectedListener;)V

    .line 155
    iget-object v0, p0, Lcom/jibo/ui/fragment/onboarding/DevSettingsFragment;->current_endpoint:Landroid/widget/TextView;

    const-string v2, "PREF_END_POINT"

    sget-object v3, Lcom/jibo/aws/integration/util/Commons;->ROOT_ENDPOINT:Ljava/lang/String;

    invoke-interface {v1, v2, v3}, Landroid/content/SharedPreferences;->getString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v2}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 168
    iget-object v0, p0, Lcom/jibo/ui/fragment/onboarding/DevSettingsFragment;->textVersion:Landroid/widget/TextView;

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v3, "Version: "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {p0}, Lcom/jibo/ui/fragment/onboarding/DevSettingsFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v3

    invoke-static {v3}, Lcom/jibo/utils/Util;->a(Landroid/content/Context;)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v2}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 170
    const-string v0, "PREF_ENCRYPTION_ENABLED"

    const/4 v2, 0x1

    invoke-interface {v1, v0, v2}, Landroid/content/SharedPreferences;->getBoolean(Ljava/lang/String;Z)Z

    move-result v0

    .line 171
    iget-object v2, p0, Lcom/jibo/ui/fragment/onboarding/DevSettingsFragment;->switchEncryption:Landroid/widget/Switch;

    invoke-virtual {v2, v0}, Landroid/widget/Switch;->setChecked(Z)V

    .line 172
    iget-object v0, p0, Lcom/jibo/ui/fragment/onboarding/DevSettingsFragment;->switchEncryption:Landroid/widget/Switch;

    new-instance v2, Lcom/jibo/ui/fragment/onboarding/DevSettingsFragment$3;

    invoke-direct {v2, p0, v1}, Lcom/jibo/ui/fragment/onboarding/DevSettingsFragment$3;-><init>(Lcom/jibo/ui/fragment/onboarding/DevSettingsFragment;Landroid/content/SharedPreferences;)V

    invoke-virtual {v0, v2}, Landroid/widget/Switch;->setOnCheckedChangeListener(Landroid/widget/CompoundButton$OnCheckedChangeListener;)V

    .line 180
    new-instance v8, Ljava/util/ArrayList;

    invoke-direct {v8}, Ljava/util/ArrayList;-><init>()V

    .line 183
    :try_start_0
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/onboarding/DevSettingsFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    invoke-virtual {v0}, Landroid/support/v4/app/FragmentActivity;->getContentResolver()Landroid/content/ContentResolver;

    move-result-object v0

    const/16 v1, 0x8

    invoke-static {v1}, Lcom/jibo/db/DatabaseContract$EntityEntry;->a(I)Landroid/net/Uri;

    move-result-object v1

    sget-object v2, Lcom/jibo/db/DatabaseContract$EntityEntry;->a:[Ljava/lang/String;

    const/4 v3, 0x0

    const/4 v4, 0x0

    const-string v5, "_id"

    invoke-virtual/range {v0 .. v5}, Landroid/content/ContentResolver;->query(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_1
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    move-result-object v1

    .line 186
    if-eqz v1, :cond_3

    :try_start_1
    invoke-interface {v1}, Landroid/database/Cursor;->isClosed()Z

    move-result v0

    if-nez v0, :cond_3

    invoke-interface {v1}, Landroid/database/Cursor;->moveToFirst()Z

    move-result v0

    if-eqz v0, :cond_3

    .line 187
    :goto_1
    invoke-interface {v1}, Landroid/database/Cursor;->isAfterLast()Z

    move-result v0

    if-nez v0, :cond_3

    .line 188
    iget-object v0, p0, Lcom/jibo/ui/fragment/onboarding/DevSettingsFragment;->d:Ljava/util/List;

    invoke-static {v1}, Lcom/jibo/db/EntityData;->a(Landroid/database/Cursor;)Lcom/jibo/aws/integration/aws/services/loop/model/Loop;

    move-result-object v2

    invoke-interface {v0, v2}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 189
    iget-object v0, p0, Lcom/jibo/ui/fragment/onboarding/DevSettingsFragment;->d:Ljava/util/List;

    iget-object v2, p0, Lcom/jibo/ui/fragment/onboarding/DevSettingsFragment;->d:Ljava/util/List;

    invoke-interface {v2}, Ljava/util/List;->size()I

    move-result v2

    add-int/lit8 v2, v2, -0x1

    invoke-interface {v0, v2}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/jibo/aws/integration/aws/services/loop/model/Loop;

    invoke-virtual {v0}, Lcom/jibo/aws/integration/aws/services/loop/model/Loop;->getName()Ljava/lang/String;

    move-result-object v0

    invoke-interface {v8, v0}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 190
    invoke-interface {v1}, Landroid/database/Cursor;->moveToNext()Z
    :try_end_1
    .catch Ljava/lang/Exception; {:try_start_1 .. :try_end_1} :catch_0
    .catchall {:try_start_1 .. :try_end_1} :catchall_1

    goto :goto_1

    .line 193
    :catch_0
    move-exception v0

    .line 194
    :goto_2
    :try_start_2
    invoke-static {v0}, Lcom/crashlytics/android/Crashlytics;->a(Ljava/lang/Throwable;)V
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_1

    .line 196
    if-eqz v1, :cond_1

    invoke-interface {v1}, Landroid/database/Cursor;->close()V

    .line 198
    :cond_1
    :goto_3
    iget-object v0, p0, Lcom/jibo/ui/fragment/onboarding/DevSettingsFragment;->loopsSpinner:Landroid/widget/Spinner;

    new-instance v1, Landroid/widget/ArrayAdapter;

    invoke-virtual {p0}, Lcom/jibo/ui/fragment/onboarding/DevSettingsFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v2

    invoke-direct {v1, v2, v9, v8}, Landroid/widget/ArrayAdapter;-><init>(Landroid/content/Context;ILjava/util/List;)V

    invoke-virtual {v0, v1}, Landroid/widget/Spinner;->setAdapter(Landroid/widget/SpinnerAdapter;)V

    .line 199
    iget-object v0, p0, Lcom/jibo/ui/fragment/onboarding/DevSettingsFragment;->loopsSpinner:Landroid/widget/Spinner;

    invoke-virtual {v0, v6, v6}, Landroid/widget/Spinner;->setSelection(IZ)V

    .line 200
    iget-object v0, p0, Lcom/jibo/ui/fragment/onboarding/DevSettingsFragment;->loops1Spinner:Landroid/widget/Spinner;

    new-instance v1, Landroid/widget/ArrayAdapter;

    invoke-virtual {p0}, Lcom/jibo/ui/fragment/onboarding/DevSettingsFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v2

    invoke-direct {v1, v2, v9, v8}, Landroid/widget/ArrayAdapter;-><init>(Landroid/content/Context;ILjava/util/List;)V

    invoke-virtual {v0, v1}, Landroid/widget/Spinner;->setAdapter(Landroid/widget/SpinnerAdapter;)V

    .line 201
    iget-object v0, p0, Lcom/jibo/ui/fragment/onboarding/DevSettingsFragment;->loops1Spinner:Landroid/widget/Spinner;

    invoke-virtual {v0, v6, v6}, Landroid/widget/Spinner;->setSelection(IZ)V

    .line 202
    iget-object v0, p0, Lcom/jibo/ui/fragment/onboarding/DevSettingsFragment;->gqaLoopsSpinner:Landroid/widget/Spinner;

    new-instance v1, Landroid/widget/ArrayAdapter;

    invoke-virtual {p0}, Lcom/jibo/ui/fragment/onboarding/DevSettingsFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v2

    invoke-direct {v1, v2, v9, v8}, Landroid/widget/ArrayAdapter;-><init>(Landroid/content/Context;ILjava/util/List;)V

    invoke-virtual {v0, v1}, Landroid/widget/Spinner;->setAdapter(Landroid/widget/SpinnerAdapter;)V

    .line 203
    iget-object v0, p0, Lcom/jibo/ui/fragment/onboarding/DevSettingsFragment;->gqaLoopsSpinner:Landroid/widget/Spinner;

    invoke-virtual {v0, v6, v6}, Landroid/widget/Spinner;->setSelection(IZ)V

    .line 204
    iget-object v0, p0, Lcom/jibo/ui/fragment/onboarding/DevSettingsFragment;->ugcLoopSpinner:Landroid/widget/Spinner;

    new-instance v1, Landroid/widget/ArrayAdapter;

    invoke-virtual {p0}, Lcom/jibo/ui/fragment/onboarding/DevSettingsFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v2

    invoke-direct {v1, v2, v9, v8}, Landroid/widget/ArrayAdapter;-><init>(Landroid/content/Context;ILjava/util/List;)V

    invoke-virtual {v0, v1}, Landroid/widget/Spinner;->setAdapter(Landroid/widget/SpinnerAdapter;)V

    .line 205
    iget-object v0, p0, Lcom/jibo/ui/fragment/onboarding/DevSettingsFragment;->ugcLoopSpinner:Landroid/widget/Spinner;

    new-instance v1, Lcom/jibo/ui/fragment/onboarding/DevSettingsFragment$4;

    invoke-direct {v1, p0}, Lcom/jibo/ui/fragment/onboarding/DevSettingsFragment$4;-><init>(Lcom/jibo/ui/fragment/onboarding/DevSettingsFragment;)V

    invoke-virtual {v0, v1}, Landroid/widget/Spinner;->setOnItemSelectedListener(Landroid/widget/AdapterView$OnItemSelectedListener;)V

    .line 229
    iget-object v0, p0, Lcom/jibo/ui/fragment/onboarding/DevSettingsFragment;->ugcLoopSpinner:Landroid/widget/Spinner;

    invoke-virtual {v0, v6, v6}, Landroid/widget/Spinner;->setSelection(IZ)V

    .line 230
    iget-object v0, p0, Lcom/jibo/ui/fragment/onboarding/DevSettingsFragment;->suspensionLoopSpinner:Landroid/widget/Spinner;

    new-instance v1, Landroid/widget/ArrayAdapter;

    invoke-virtual {p0}, Lcom/jibo/ui/fragment/onboarding/DevSettingsFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v2

    invoke-direct {v1, v2, v9, v8}, Landroid/widget/ArrayAdapter;-><init>(Landroid/content/Context;ILjava/util/List;)V

    invoke-virtual {v0, v1}, Landroid/widget/Spinner;->setAdapter(Landroid/widget/SpinnerAdapter;)V

    .line 231
    iget-object v0, p0, Lcom/jibo/ui/fragment/onboarding/DevSettingsFragment;->suspensionLoopSpinner:Landroid/widget/Spinner;

    invoke-virtual {v0, v6, v6}, Landroid/widget/Spinner;->setSelection(IZ)V

    .line 232
    return-void

    .line 129
    :cond_2
    add-int/lit8 v0, v0, 0x1

    goto/16 :goto_0

    .line 196
    :cond_3
    if-eqz v1, :cond_1

    invoke-interface {v1}, Landroid/database/Cursor;->close()V

    goto :goto_3

    :catchall_0
    move-exception v0

    move-object v1, v7

    :goto_4
    if-eqz v1, :cond_4

    invoke-interface {v1}, Landroid/database/Cursor;->close()V

    :cond_4
    throw v0

    :catchall_1
    move-exception v0

    goto :goto_4

    .line 193
    :catch_1
    move-exception v0

    move-object v1, v7

    goto/16 :goto_2
.end method

.method public setEndpoint(Landroid/view/View;)V
    .locals 4
    .annotation build Lbutterknife/OnClick;
    .end annotation

    .prologue
    .line 347
    iget-object v0, p0, Lcom/jibo/ui/fragment/onboarding/DevSettingsFragment;->endpointEdit:Landroid/widget/EditText;

    invoke-virtual {v0}, Landroid/widget/EditText;->getText()Landroid/text/Editable;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v0

    .line 349
    invoke-static {v0}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v1

    if-eqz v1, :cond_0

    .line 350
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/onboarding/DevSettingsFragment;->getContext()Landroid/content/Context;

    move-result-object v0

    const-string v1, "Endpoint must not be empty"

    const/4 v2, 0x1

    invoke-static {v0, v1, v2}, Landroid/widget/Toast;->makeText(Landroid/content/Context;Ljava/lang/CharSequence;I)Landroid/widget/Toast;

    move-result-object v0

    invoke-virtual {v0}, Landroid/widget/Toast;->show()V

    .line 362
    :goto_0
    return-void

    .line 353
    :cond_0
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/onboarding/DevSettingsFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v1

    const v2, 0x7f100037

    .line 354
    invoke-virtual {p0, v2}, Lcom/jibo/ui/fragment/onboarding/DevSettingsFragment;->getString(I)Ljava/lang/String;

    move-result-object v2

    const/4 v3, 0x0

    invoke-virtual {v1, v2, v3}, Landroid/support/v4/app/FragmentActivity;->getSharedPreferences(Ljava/lang/String;I)Landroid/content/SharedPreferences;

    move-result-object v1

    .line 356
    invoke-static {v0}, Lcom/jibo/aws/integration/util/Commons;->setRootEndpoint(Ljava/lang/String;)V

    .line 358
    invoke-interface {v1}, Landroid/content/SharedPreferences;->edit()Landroid/content/SharedPreferences$Editor;

    move-result-object v1

    const-string v2, "PREF_END_POINT"

    invoke-interface {v1, v2, v0}, Landroid/content/SharedPreferences$Editor;->putString(Ljava/lang/String;Ljava/lang/String;)Landroid/content/SharedPreferences$Editor;

    move-result-object v0

    invoke-interface {v0}, Landroid/content/SharedPreferences$Editor;->apply()V

    .line 360
    const/4 v0, 0x0

    invoke-virtual {p0, v0}, Lcom/jibo/ui/fragment/onboarding/DevSettingsFragment;->logout(Landroid/view/View;)V

    goto :goto_0
.end method

.method public showDevSettings(Landroid/view/View;)Z
    .locals 1
    .annotation build Lbutterknife/OnLongClick;
    .end annotation

    .prologue
    .line 271
    const/4 v0, 0x1

    return v0
.end method
