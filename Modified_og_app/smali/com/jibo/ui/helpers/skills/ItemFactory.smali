.class public Lcom/jibo/ui/helpers/skills/ItemFactory;
.super Ljava/lang/Object;
.source "ItemFactory.java"


# static fields
.field private static gson:Lcom/google/gson/Gson;


# instance fields
.field private mCurrentViewsPath:[I

.field private mDataDeleter:Lcom/jibo/ui/fragment/account/skills/SkillSettingsFragment$DataPublisher;

.field private mDataPublisher:Lcom/jibo/ui/fragment/account/skills/SkillSettingsFragment$DataPublisher;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 42
    new-instance v0, Lcom/google/gson/Gson;

    invoke-direct {v0}, Lcom/google/gson/Gson;-><init>()V

    sput-object v0, Lcom/jibo/ui/helpers/skills/ItemFactory;->gson:Lcom/google/gson/Gson;

    return-void
.end method

.method public constructor <init>([ILcom/jibo/ui/fragment/account/skills/SkillSettingsFragment$DataPublisher;)V
    .locals 1

    .prologue
    .line 47
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 49
    iput-object p1, p0, Lcom/jibo/ui/helpers/skills/ItemFactory;->mCurrentViewsPath:[I

    .line 50
    iput-object p2, p0, Lcom/jibo/ui/helpers/skills/ItemFactory;->mDataPublisher:Lcom/jibo/ui/fragment/account/skills/SkillSettingsFragment$DataPublisher;

    .line 51
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/jibo/ui/helpers/skills/ItemFactory;->mDataDeleter:Lcom/jibo/ui/fragment/account/skills/SkillSettingsFragment$DataPublisher;

    .line 52
    return-void
.end method

.method public constructor <init>([ILcom/jibo/ui/fragment/account/skills/SkillSettingsFragment$DataPublisher;Lcom/jibo/ui/fragment/account/skills/SkillSettingsFragment$DataPublisher;)V
    .locals 0

    .prologue
    .line 54
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 56
    iput-object p1, p0, Lcom/jibo/ui/helpers/skills/ItemFactory;->mCurrentViewsPath:[I

    .line 57
    iput-object p2, p0, Lcom/jibo/ui/helpers/skills/ItemFactory;->mDataPublisher:Lcom/jibo/ui/fragment/account/skills/SkillSettingsFragment$DataPublisher;

    .line 58
    iput-object p3, p0, Lcom/jibo/ui/helpers/skills/ItemFactory;->mDataDeleter:Lcom/jibo/ui/fragment/account/skills/SkillSettingsFragment$DataPublisher;

    .line 59
    return-void
.end method

.method static synthetic access$000(Lcom/jibo/ui/helpers/skills/ItemFactory;Lcom/jibo/ui/helpers/skills/DataItems$DataItem;Z)V
    .locals 0

    .prologue
    .line 40
    invoke-direct {p0, p1, p2}, Lcom/jibo/ui/helpers/skills/ItemFactory;->putBooleanDataValue(Lcom/jibo/ui/helpers/skills/DataItems$DataItem;Z)V

    return-void
.end method

.method static synthetic access$100(Lcom/jibo/ui/helpers/skills/ItemFactory;Landroid/content/Context;Lcom/jibo/ui/helpers/skills/DataItems$DataItem;I)V
    .locals 0

    .prologue
    .line 40
    invoke-direct {p0, p1, p2, p3}, Lcom/jibo/ui/helpers/skills/ItemFactory;->openChildrenScreen(Landroid/content/Context;Lcom/jibo/ui/helpers/skills/DataItems$DataItem;I)V

    return-void
.end method

.method static synthetic access$200(Lcom/jibo/ui/helpers/skills/ItemFactory;Lcom/jibo/ui/helpers/skills/DataItems$DataItem;)V
    .locals 0

    .prologue
    .line 40
    invoke-direct {p0, p1}, Lcom/jibo/ui/helpers/skills/ItemFactory;->putBooleanDataValue(Lcom/jibo/ui/helpers/skills/DataItems$DataItem;)V

    return-void
.end method

.method static synthetic access$300(Lcom/jibo/ui/helpers/skills/ItemFactory;)Lcom/jibo/ui/fragment/account/skills/SkillSettingsFragment$DataPublisher;
    .locals 1

    .prologue
    .line 40
    iget-object v0, p0, Lcom/jibo/ui/helpers/skills/ItemFactory;->mDataPublisher:Lcom/jibo/ui/fragment/account/skills/SkillSettingsFragment$DataPublisher;

    return-object v0
.end method

.method static synthetic access$400(Lcom/jibo/ui/helpers/skills/ItemFactory;)Lcom/jibo/ui/fragment/account/skills/SkillSettingsFragment$DataPublisher;
    .locals 1

    .prologue
    .line 40
    iget-object v0, p0, Lcom/jibo/ui/helpers/skills/ItemFactory;->mDataDeleter:Lcom/jibo/ui/fragment/account/skills/SkillSettingsFragment$DataPublisher;

    return-object v0
.end method

.method static synthetic access$500()Lcom/google/gson/Gson;
    .locals 1

    .prologue
    .line 40
    sget-object v0, Lcom/jibo/ui/helpers/skills/ItemFactory;->gson:Lcom/google/gson/Gson;

    return-object v0
.end method

.method private getOnCheckChangeListener(Lcom/jibo/ui/helpers/skills/DataItems$DataItem;I)Landroid/widget/CompoundButton$OnCheckedChangeListener;
    .locals 3

    .prologue
    .line 139
    invoke-virtual {p1}, Lcom/jibo/ui/helpers/skills/DataItems$DataItem;->getType()Ljava/lang/String;

    move-result-object v1

    const/4 v0, -0x1

    invoke-virtual {v1}, Ljava/lang/String;->hashCode()I

    move-result v2

    packed-switch v2, :pswitch_data_0

    :cond_0
    :goto_0
    packed-switch v0, :pswitch_data_1

    .line 166
    const/4 v0, 0x0

    :goto_1
    return-object v0

    .line 139
    :pswitch_0
    const-string v2, "switch"

    invoke-virtual {v1, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_0

    const/4 v0, 0x0

    goto :goto_0

    .line 141
    :pswitch_1
    new-instance v0, Lcom/jibo/ui/helpers/skills/ItemFactory$1;

    invoke-direct {v0, p0, p1}, Lcom/jibo/ui/helpers/skills/ItemFactory$1;-><init>(Lcom/jibo/ui/helpers/skills/ItemFactory;Lcom/jibo/ui/helpers/skills/DataItems$DataItem;)V

    goto :goto_1

    .line 139
    nop

    :pswitch_data_0
    .packed-switch -0x350448cc
        :pswitch_0
    .end packed-switch

    :pswitch_data_1
    .packed-switch 0x0
        :pswitch_1
    .end packed-switch
.end method

.method private getOnClickLister(Lcom/jibo/ui/helpers/skills/DataItems$DataItem;I)Landroid/view/View$OnClickListener;
    .locals 3

    .prologue
    .line 178
    invoke-virtual {p1}, Lcom/jibo/ui/helpers/skills/DataItems$DataItem;->getType()Ljava/lang/String;

    move-result-object v1

    const/4 v0, -0x1

    invoke-virtual {v1}, Ljava/lang/String;->hashCode()I

    move-result v2

    sparse-switch v2, :sswitch_data_0

    :cond_0
    :goto_0
    packed-switch v0, :pswitch_data_0

    .line 290
    new-instance v0, Lcom/jibo/ui/helpers/skills/ItemFactory$10;

    invoke-direct {v0, p0}, Lcom/jibo/ui/helpers/skills/ItemFactory$10;-><init>(Lcom/jibo/ui/helpers/skills/ItemFactory;)V

    :goto_1
    return-object v0

    .line 178
    :sswitch_0
    const-string v2, "skill"

    invoke-virtual {v1, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_0

    const/4 v0, 0x0

    goto :goto_0

    :sswitch_1
    const-string v2, "switch"

    invoke-virtual {v1, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_0

    const/4 v0, 0x1

    goto :goto_0

    :sswitch_2
    const-string v2, "toggle"

    invoke-virtual {v1, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_0

    const/4 v0, 0x2

    goto :goto_0

    :sswitch_3
    const-string v2, "choice"

    invoke-virtual {v1, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_0

    const/4 v0, 0x3

    goto :goto_0

    :sswitch_4
    const-string v2, "locationTextField"

    invoke-virtual {v1, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_0

    const/4 v0, 0x4

    goto :goto_0

    :sswitch_5
    const-string v2, "connectable"

    invoke-virtual {v1, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_0

    const/4 v0, 0x5

    goto :goto_0

    :sswitch_6
    const-string v2, "oauth"

    invoke-virtual {v1, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_0

    const/4 v0, 0x6

    goto :goto_0

    :sswitch_7
    const-string v2, "time"

    invoke-virtual {v1, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_0

    const/4 v0, 0x7

    goto :goto_0

    .line 180
    :pswitch_0
    new-instance v0, Lcom/jibo/ui/helpers/skills/ItemFactory$2;

    invoke-direct {v0, p0, p2, p1}, Lcom/jibo/ui/helpers/skills/ItemFactory$2;-><init>(Lcom/jibo/ui/helpers/skills/ItemFactory;ILcom/jibo/ui/helpers/skills/DataItems$DataItem;)V

    goto :goto_1

    .line 189
    :pswitch_1
    new-instance v0, Lcom/jibo/ui/helpers/skills/ItemFactory$3;

    invoke-direct {v0, p0, p1, p2}, Lcom/jibo/ui/helpers/skills/ItemFactory$3;-><init>(Lcom/jibo/ui/helpers/skills/ItemFactory;Lcom/jibo/ui/helpers/skills/DataItems$DataItem;I)V

    goto :goto_1

    .line 204
    :pswitch_2
    new-instance v0, Lcom/jibo/ui/helpers/skills/ItemFactory$4;

    invoke-direct {v0, p0, p1}, Lcom/jibo/ui/helpers/skills/ItemFactory$4;-><init>(Lcom/jibo/ui/helpers/skills/ItemFactory;Lcom/jibo/ui/helpers/skills/DataItems$DataItem;)V

    goto :goto_1

    .line 211
    :pswitch_3
    new-instance v0, Lcom/jibo/ui/helpers/skills/ItemFactory$5;

    invoke-direct {v0, p0, p1}, Lcom/jibo/ui/helpers/skills/ItemFactory$5;-><init>(Lcom/jibo/ui/helpers/skills/ItemFactory;Lcom/jibo/ui/helpers/skills/DataItems$DataItem;)V

    goto :goto_1

    .line 225
    :pswitch_4
    new-instance v0, Lcom/jibo/ui/helpers/skills/ItemFactory$6;

    invoke-direct {v0, p0, p1}, Lcom/jibo/ui/helpers/skills/ItemFactory$6;-><init>(Lcom/jibo/ui/helpers/skills/ItemFactory;Lcom/jibo/ui/helpers/skills/DataItems$DataItem;)V

    goto :goto_1

    .line 232
    :pswitch_5
    new-instance v0, Lcom/jibo/ui/helpers/skills/ItemFactory$7;

    invoke-direct {v0, p0, p1, p2}, Lcom/jibo/ui/helpers/skills/ItemFactory$7;-><init>(Lcom/jibo/ui/helpers/skills/ItemFactory;Lcom/jibo/ui/helpers/skills/DataItems$DataItem;I)V

    goto :goto_1

    .line 257
    :pswitch_6
    new-instance v0, Lcom/jibo/ui/helpers/skills/ItemFactory$8;

    invoke-direct {v0, p0, p1}, Lcom/jibo/ui/helpers/skills/ItemFactory$8;-><init>(Lcom/jibo/ui/helpers/skills/ItemFactory;Lcom/jibo/ui/helpers/skills/DataItems$DataItem;)V

    goto :goto_1

    .line 276
    :pswitch_7
    new-instance v0, Lcom/jibo/ui/helpers/skills/ItemFactory$9;

    invoke-direct {v0, p0, p1}, Lcom/jibo/ui/helpers/skills/ItemFactory$9;-><init>(Lcom/jibo/ui/helpers/skills/ItemFactory;Lcom/jibo/ui/helpers/skills/DataItems$DataItem;)V

    goto :goto_1

    .line 178
    nop

    :sswitch_data_0
    .sparse-switch
        -0x5122a25f -> :sswitch_3
        -0x350448cc -> :sswitch_1
        -0x33c144ac -> :sswitch_2
        0x3652cd -> :sswitch_7
        0x64a0e97 -> :sswitch_6
        0x686ca51 -> :sswitch_0
        0x24f4fb98 -> :sswitch_4
        0x66c78944 -> :sswitch_5
    .end sparse-switch

    :pswitch_data_0
    .packed-switch 0x0
        :pswitch_0
        :pswitch_1
        :pswitch_2
        :pswitch_3
        :pswitch_4
        :pswitch_5
        :pswitch_6
        :pswitch_7
    .end packed-switch
.end method

.method private openChildrenScreen(Landroid/content/Context;Lcom/jibo/ui/helpers/skills/DataItems$DataItem;I)V
    .locals 5

    .prologue
    const/4 v1, 0x1

    const/4 v2, 0x0

    .line 310
    instance-of v0, p2, Lcom/jibo/ui/helpers/skills/DataItems$GroupDataItem;

    if-eqz v0, :cond_0

    instance-of v0, p2, Lcom/jibo/ui/helpers/skills/DataItems$GroupDataItem;

    if-eqz v0, :cond_1

    move-object v0, p2

    check-cast v0, Lcom/jibo/ui/helpers/skills/DataItems$GroupDataItem;

    .line 312
    invoke-virtual {v0}, Lcom/jibo/ui/helpers/skills/DataItems$GroupDataItem;->getChildViews()Ljava/util/List;

    move-result-object v0

    if-eqz v0, :cond_0

    move-object v0, p2

    check-cast v0, Lcom/jibo/ui/helpers/skills/DataItems$GroupDataItem;

    .line 313
    invoke-virtual {v0}, Lcom/jibo/ui/helpers/skills/DataItems$GroupDataItem;->getChildViews()Ljava/util/List;

    move-result-object v0

    invoke-interface {v0}, Ljava/util/List;->isEmpty()Z

    move-result v0

    if-eqz v0, :cond_1

    .line 344
    :cond_0
    :goto_0
    return-void

    .line 318
    :cond_1
    iget-object v0, p0, Lcom/jibo/ui/helpers/skills/ItemFactory;->mCurrentViewsPath:[I

    if-eqz v0, :cond_2

    iget-object v0, p0, Lcom/jibo/ui/helpers/skills/ItemFactory;->mCurrentViewsPath:[I

    array-length v0, v0

    add-int/lit8 v0, v0, 0x1

    :goto_1
    new-array v3, v0, [I

    .line 319
    iget-object v0, p0, Lcom/jibo/ui/helpers/skills/ItemFactory;->mCurrentViewsPath:[I

    if-eqz v0, :cond_3

    move v0, v2

    .line 320
    :goto_2
    iget-object v4, p0, Lcom/jibo/ui/helpers/skills/ItemFactory;->mCurrentViewsPath:[I

    array-length v4, v4

    if-ge v0, v4, :cond_3

    .line 321
    iget-object v4, p0, Lcom/jibo/ui/helpers/skills/ItemFactory;->mCurrentViewsPath:[I

    aget v4, v4, v0

    aput v4, v3, v0

    .line 320
    add-int/lit8 v0, v0, 0x1

    goto :goto_2

    :cond_2
    move v0, v1

    .line 318
    goto :goto_1

    .line 324
    :cond_3
    array-length v0, v3

    add-int/lit8 v0, v0, -0x1

    aput p3, v3, v0

    move-object v0, p2

    .line 328
    check-cast v0, Lcom/jibo/ui/helpers/skills/DataItems$GroupDataItem;

    invoke-virtual {v0}, Lcom/jibo/ui/helpers/skills/DataItems$GroupDataItem;->getChildViews()Ljava/util/List;

    move-result-object v0

    invoke-interface {v0}, Ljava/util/List;->size()I

    move-result v0

    if-ne v0, v1, :cond_4

    move-object v0, p2

    check-cast v0, Lcom/jibo/ui/helpers/skills/DataItems$GroupDataItem;

    .line 329
    invoke-virtual {v0}, Lcom/jibo/ui/helpers/skills/DataItems$GroupDataItem;->getChildViews()Ljava/util/List;

    move-result-object v0

    invoke-interface {v0, v2}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    instance-of v0, v0, Lcom/jibo/ui/helpers/skills/DataItems$LocationDataItem;

    if-eqz v0, :cond_4

    .line 332
    new-instance v0, Landroid/os/Bundle;

    invoke-direct {v0}, Landroid/os/Bundle;-><init>()V

    .line 333
    const-class v1, Lcom/jibo/ui/helpers/skills/DataItems$LocationDataItem;

    invoke-virtual {v1}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v1

    sget-object v3, Lcom/jibo/ui/helpers/skills/ItemFactory;->gson:Lcom/google/gson/Gson;

    check-cast p2, Lcom/jibo/ui/helpers/skills/DataItems$GroupDataItem;

    .line 334
    invoke-virtual {p2}, Lcom/jibo/ui/helpers/skills/DataItems$GroupDataItem;->getChildViews()Ljava/util/List;

    move-result-object v4

    invoke-interface {v4, v2}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v2

    invoke-virtual {v3, v2}, Lcom/google/gson/Gson;->b(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    .line 333
    invoke-virtual {v0, v1, v2}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 335
    check-cast p1, Lcom/jibo/ui/activity/BaseActivity;

    const-class v1, Lcom/jibo/ui/fragment/account/skills/LocationFragment;

    invoke-virtual {p1, v1, v0}, Lcom/jibo/ui/activity/BaseActivity;->c(Ljava/lang/Class;Landroid/os/Bundle;)V

    goto :goto_0

    .line 339
    :cond_4
    check-cast p1, Lcom/jibo/ui/activity/BaseActivity;

    .line 340
    new-instance v0, Landroid/os/Bundle;

    invoke-direct {v0}, Landroid/os/Bundle;-><init>()V

    .line 341
    const-string v1, "PARAM_PATH"

    invoke-virtual {v0, v1, v3}, Landroid/os/Bundle;->putIntArray(Ljava/lang/String;[I)V

    .line 342
    const-string v1, "PARAM_TITLE"

    invoke-virtual {p2}, Lcom/jibo/ui/helpers/skills/DataItems$DataItem;->getTitle()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 343
    const-class v1, Lcom/jibo/ui/fragment/account/skills/SkillSettingsFragment;

    invoke-virtual {p1, v1, v0}, Lcom/jibo/ui/activity/BaseActivity;->c(Ljava/lang/Class;Landroid/os/Bundle;)V

    goto/16 :goto_0
.end method

.method private putBooleanDataValue(Lcom/jibo/ui/helpers/skills/DataItems$DataItem;)V
    .locals 3

    .prologue
    const/4 v1, 0x1

    .line 116
    iget-object v0, p0, Lcom/jibo/ui/helpers/skills/ItemFactory;->mDataPublisher:Lcom/jibo/ui/fragment/account/skills/SkillSettingsFragment$DataPublisher;

    if-eqz v0, :cond_0

    .line 117
    new-instance v2, Lcom/jibo/ui/helpers/skills/DataItems$BooleanDataValue;

    invoke-direct {v2}, Lcom/jibo/ui/helpers/skills/DataItems$BooleanDataValue;-><init>()V

    .line 118
    invoke-virtual {p1}, Lcom/jibo/ui/helpers/skills/DataItems$DataItem;->getDataValue()Lcom/jibo/ui/helpers/skills/DataItems$DataValue;

    move-result-object v0

    if-eqz v0, :cond_2

    .line 119
    invoke-virtual {p1}, Lcom/jibo/ui/helpers/skills/DataItems$DataItem;->getDataValue()Lcom/jibo/ui/helpers/skills/DataItems$DataValue;

    move-result-object v0

    check-cast v0, Lcom/jibo/ui/helpers/skills/DataItems$BooleanDataValue;

    invoke-virtual {v0}, Lcom/jibo/ui/helpers/skills/DataItems$BooleanDataValue;->getValue()Z

    move-result v0

    if-nez v0, :cond_1

    move v0, v1

    .line 118
    :goto_0
    invoke-virtual {v2, v0}, Lcom/jibo/ui/helpers/skills/DataItems$BooleanDataValue;->setValue(Z)V

    .line 121
    iget-object v0, p0, Lcom/jibo/ui/helpers/skills/ItemFactory;->mDataPublisher:Lcom/jibo/ui/fragment/account/skills/SkillSettingsFragment$DataPublisher;

    const/4 v1, 0x0

    invoke-interface {v0, p1, v2, v1}, Lcom/jibo/ui/fragment/account/skills/SkillSettingsFragment$DataPublisher;->a(Lcom/jibo/ui/helpers/skills/DataItems$DataItem;Lcom/jibo/ui/helpers/skills/DataItems$DataValue;Lcom/jibo/aws/integration/util/Commons$AsyncCallback;)V

    .line 123
    :cond_0
    return-void

    .line 119
    :cond_1
    const/4 v0, 0x0

    goto :goto_0

    :cond_2
    move v0, v1

    goto :goto_0
.end method

.method private putBooleanDataValue(Lcom/jibo/ui/helpers/skills/DataItems$DataItem;Z)V
    .locals 3

    .prologue
    .line 131
    iget-object v0, p0, Lcom/jibo/ui/helpers/skills/ItemFactory;->mDataPublisher:Lcom/jibo/ui/fragment/account/skills/SkillSettingsFragment$DataPublisher;

    if-eqz v0, :cond_0

    .line 132
    new-instance v0, Lcom/jibo/ui/helpers/skills/DataItems$BooleanDataValue;

    invoke-direct {v0}, Lcom/jibo/ui/helpers/skills/DataItems$BooleanDataValue;-><init>()V

    .line 133
    invoke-virtual {v0, p2}, Lcom/jibo/ui/helpers/skills/DataItems$BooleanDataValue;->setValue(Z)V

    .line 134
    iget-object v1, p0, Lcom/jibo/ui/helpers/skills/ItemFactory;->mDataPublisher:Lcom/jibo/ui/fragment/account/skills/SkillSettingsFragment$DataPublisher;

    const/4 v2, 0x0

    invoke-interface {v1, p1, v0, v2}, Lcom/jibo/ui/fragment/account/skills/SkillSettingsFragment$DataPublisher;->a(Lcom/jibo/ui/helpers/skills/DataItems$DataItem;Lcom/jibo/ui/helpers/skills/DataItems$DataValue;Lcom/jibo/aws/integration/util/Commons$AsyncCallback;)V

    .line 136
    :cond_0
    return-void
.end method


# virtual methods
.method public getItems(Ljava/util/List;)Ljava/util/List;
    .locals 7
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Lcom/jibo/ui/helpers/skills/DataItems$DataItem;",
            ">;)",
            "Ljava/util/List",
            "<",
            "Lcom/jibo/ui/helpers/Items$Item;",
            ">;"
        }
    .end annotation

    .prologue
    .line 68
    new-instance v1, Ljava/util/ArrayList;

    invoke-direct {v1}, Ljava/util/ArrayList;-><init>()V

    .line 69
    if-eqz p1, :cond_0

    invoke-interface {p1}, Ljava/util/List;->isEmpty()Z

    move-result v0

    if-eqz v0, :cond_1

    :cond_0
    move-object v0, v1

    .line 107
    :goto_0
    return-object v0

    .line 72
    :cond_1
    invoke-interface {p1}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v3

    :goto_1
    invoke-interface {v3}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_3

    invoke-interface {v3}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/jibo/ui/helpers/skills/DataItems$DataItem;

    .line 73
    invoke-interface {p1, v0}, Ljava/util/List;->indexOf(Ljava/lang/Object;)I

    move-result v2

    invoke-direct {p0, v0, v2}, Lcom/jibo/ui/helpers/skills/ItemFactory;->getOnClickLister(Lcom/jibo/ui/helpers/skills/DataItems$DataItem;I)Landroid/view/View$OnClickListener;

    move-result-object v4

    .line 74
    invoke-virtual {v0}, Lcom/jibo/ui/helpers/skills/DataItems$DataItem;->getType()Ljava/lang/String;

    move-result-object v5

    const/4 v2, -0x1

    invoke-virtual {v5}, Ljava/lang/String;->hashCode()I

    move-result v6

    sparse-switch v6, :sswitch_data_0

    :cond_2
    :goto_2
    packed-switch v2, :pswitch_data_0

    goto :goto_1

    .line 76
    :pswitch_0
    new-instance v2, Lcom/jibo/ui/helpers/skills/Items$SkillItem;

    check-cast v0, Lcom/jibo/ui/helpers/skills/DataItems$SkillViewDataItem;

    invoke-direct {v2, v4, v0}, Lcom/jibo/ui/helpers/skills/Items$SkillItem;-><init>(Landroid/view/View$OnClickListener;Lcom/jibo/ui/helpers/skills/DataItems$SkillViewDataItem;)V

    invoke-interface {v1, v2}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    goto :goto_1

    .line 74
    :sswitch_0
    const-string v6, "skill"

    invoke-virtual {v5, v6}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v5

    if-eqz v5, :cond_2

    const/4 v2, 0x0

    goto :goto_2

    :sswitch_1
    const-string v6, "switch"

    invoke-virtual {v5, v6}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v5

    if-eqz v5, :cond_2

    const/4 v2, 0x1

    goto :goto_2

    :sswitch_2
    const-string v6, "subheader"

    invoke-virtual {v5, v6}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v5

    if-eqz v5, :cond_2

    const/4 v2, 0x2

    goto :goto_2

    :sswitch_3
    const-string v6, "footer"

    invoke-virtual {v5, v6}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v5

    if-eqz v5, :cond_2

    const/4 v2, 0x3

    goto :goto_2

    :sswitch_4
    const-string v6, "choice"

    invoke-virtual {v5, v6}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v5

    if-eqz v5, :cond_2

    const/4 v2, 0x4

    goto :goto_2

    :sswitch_5
    const-string v6, "toggle"

    invoke-virtual {v5, v6}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v5

    if-eqz v5, :cond_2

    const/4 v2, 0x5

    goto :goto_2

    :sswitch_6
    const-string v6, "locationTextField"

    invoke-virtual {v5, v6}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v5

    if-eqz v5, :cond_2

    const/4 v2, 0x6

    goto :goto_2

    :sswitch_7
    const-string v6, "connectable"

    invoke-virtual {v5, v6}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v5

    if-eqz v5, :cond_2

    const/4 v2, 0x7

    goto :goto_2

    :sswitch_8
    const-string v6, "oauth"

    invoke-virtual {v5, v6}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v5

    if-eqz v5, :cond_2

    const/16 v2, 0x8

    goto :goto_2

    :sswitch_9
    const-string v6, "time"

    invoke-virtual {v5, v6}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v5

    if-eqz v5, :cond_2

    const/16 v2, 0x9

    goto :goto_2

    .line 79
    :pswitch_1
    new-instance v2, Lcom/jibo/ui/helpers/skills/Items$SwitchItem;

    invoke-interface {p1, v0}, Ljava/util/List;->indexOf(Ljava/lang/Object;)I

    move-result v5

    invoke-direct {p0, v0, v5}, Lcom/jibo/ui/helpers/skills/ItemFactory;->getOnCheckChangeListener(Lcom/jibo/ui/helpers/skills/DataItems$DataItem;I)Landroid/widget/CompoundButton$OnCheckedChangeListener;

    move-result-object v5

    check-cast v0, Lcom/jibo/ui/helpers/skills/DataItems$SwitchDataItem;

    invoke-direct {v2, v4, v5, v0}, Lcom/jibo/ui/helpers/skills/Items$SwitchItem;-><init>(Landroid/view/View$OnClickListener;Landroid/widget/CompoundButton$OnCheckedChangeListener;Lcom/jibo/ui/helpers/skills/DataItems$SwitchDataItem;)V

    invoke-interface {v1, v2}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    goto/16 :goto_1

    .line 82
    :pswitch_2
    new-instance v2, Lcom/jibo/ui/helpers/Items$SubheaderItem;

    invoke-virtual {v0}, Lcom/jibo/ui/helpers/skills/DataItems$DataItem;->getTitle()Ljava/lang/String;

    move-result-object v0

    invoke-direct {v2, v0}, Lcom/jibo/ui/helpers/Items$SubheaderItem;-><init>(Ljava/lang/String;)V

    invoke-interface {v1, v2}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    goto/16 :goto_1

    .line 85
    :pswitch_3
    new-instance v2, Lcom/jibo/ui/helpers/skills/Items$SkillFooterItem;

    check-cast v0, Lcom/jibo/ui/helpers/skills/DataItems$FooterDataItem;

    invoke-direct {v2, v0}, Lcom/jibo/ui/helpers/skills/Items$SkillFooterItem;-><init>(Lcom/jibo/ui/helpers/skills/DataItems$FooterDataItem;)V

    invoke-interface {v1, v2}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    goto/16 :goto_1

    .line 88
    :pswitch_4
    new-instance v2, Lcom/jibo/ui/helpers/skills/Items$ChoiceItem;

    check-cast v0, Lcom/jibo/ui/helpers/skills/DataItems$ChoiceDataItem;

    invoke-direct {v2, v4, v0}, Lcom/jibo/ui/helpers/skills/Items$ChoiceItem;-><init>(Landroid/view/View$OnClickListener;Lcom/jibo/ui/helpers/skills/DataItems$ChoiceDataItem;)V

    invoke-interface {v1, v2}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    goto/16 :goto_1

    .line 91
    :pswitch_5
    new-instance v2, Lcom/jibo/ui/helpers/skills/Items$ToggleItem;

    check-cast v0, Lcom/jibo/ui/helpers/skills/DataItems$ToggleDataItem;

    invoke-direct {v2, v4, v0}, Lcom/jibo/ui/helpers/skills/Items$ToggleItem;-><init>(Landroid/view/View$OnClickListener;Lcom/jibo/ui/helpers/skills/DataItems$ToggleDataItem;)V

    invoke-interface {v1, v2}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    goto/16 :goto_1

    .line 94
    :pswitch_6
    new-instance v2, Lcom/jibo/ui/helpers/skills/Items$LocationItem;

    check-cast v0, Lcom/jibo/ui/helpers/skills/DataItems$LocationDataItem;

    invoke-direct {v2, v4, v0}, Lcom/jibo/ui/helpers/skills/Items$LocationItem;-><init>(Landroid/view/View$OnClickListener;Lcom/jibo/ui/helpers/skills/DataItems$LocationDataItem;)V

    invoke-interface {v1, v2}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    goto/16 :goto_1

    .line 97
    :pswitch_7
    new-instance v2, Lcom/jibo/ui/helpers/skills/Items$ConnectableItem;

    check-cast v0, Lcom/jibo/ui/helpers/skills/DataItems$ConnectableDataItem;

    invoke-direct {v2, v4, v0}, Lcom/jibo/ui/helpers/skills/Items$ConnectableItem;-><init>(Landroid/view/View$OnClickListener;Lcom/jibo/ui/helpers/skills/DataItems$ConnectableDataItem;)V

    invoke-interface {v1, v2}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    goto/16 :goto_1

    .line 100
    :pswitch_8
    new-instance v2, Lcom/jibo/ui/helpers/skills/Items$OauthItem;

    check-cast v0, Lcom/jibo/ui/helpers/skills/DataItems$OauthDataItem;

    invoke-direct {v2, v4, v0}, Lcom/jibo/ui/helpers/skills/Items$OauthItem;-><init>(Landroid/view/View$OnClickListener;Lcom/jibo/ui/helpers/skills/DataItems$OauthDataItem;)V

    invoke-interface {v1, v2}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    goto/16 :goto_1

    .line 103
    :pswitch_9
    new-instance v2, Lcom/jibo/ui/helpers/skills/Items$TimeItem;

    check-cast v0, Lcom/jibo/ui/helpers/skills/DataItems$TimeDataItem;

    invoke-direct {v2, v4, v0}, Lcom/jibo/ui/helpers/skills/Items$TimeItem;-><init>(Landroid/view/View$OnClickListener;Lcom/jibo/ui/helpers/skills/DataItems$TimeDataItem;)V

    invoke-interface {v1, v2}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    goto/16 :goto_1

    :cond_3
    move-object v0, v1

    .line 107
    goto/16 :goto_0

    .line 74
    nop

    :sswitch_data_0
    .sparse-switch
        -0x5122a25f -> :sswitch_4
        -0x4ba14a65 -> :sswitch_3
        -0x350448cc -> :sswitch_1
        -0x33c144ac -> :sswitch_5
        0x3652cd -> :sswitch_9
        0x64a0e97 -> :sswitch_8
        0x686ca51 -> :sswitch_0
        0xbfef0cd -> :sswitch_2
        0x24f4fb98 -> :sswitch_6
        0x66c78944 -> :sswitch_7
    .end sparse-switch

    :pswitch_data_0
    .packed-switch 0x0
        :pswitch_0
        :pswitch_1
        :pswitch_2
        :pswitch_3
        :pswitch_4
        :pswitch_5
        :pswitch_6
        :pswitch_7
        :pswitch_8
        :pswitch_9
    .end packed-switch
.end method
