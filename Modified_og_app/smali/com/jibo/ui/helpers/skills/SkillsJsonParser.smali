.class public Lcom/jibo/ui/helpers/skills/SkillsJsonParser;
.super Ljava/lang/Object;
.source "SkillsJsonParser.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/jibo/ui/helpers/skills/SkillsJsonParser$TextLinksMatcher;,
        Lcom/jibo/ui/helpers/skills/SkillsJsonParser$ImageUrlMatcher;,
        Lcom/jibo/ui/helpers/skills/SkillsJsonParser$BooleanDataValueDeserializer;,
        Lcom/jibo/ui/helpers/skills/SkillsJsonParser$DataDeserializer;
    }
.end annotation


# static fields
.field public static final TYPE_CHOICE:Ljava/lang/String; = "choice"

.field public static final TYPE_CONNECTABLE:Ljava/lang/String; = "connectable"

.field public static final TYPE_FOOTER:Ljava/lang/String; = "footer"

.field public static final TYPE_LOCATION:Ljava/lang/String; = "location"

.field public static final TYPE_LOCATION_TEXTFIELD:Ljava/lang/String; = "locationTextField"

.field public static final TYPE_OAUTH:Ljava/lang/String; = "oauth"

.field public static final TYPE_SKILL:Ljava/lang/String; = "skill"

.field public static final TYPE_SUBHEADER:Ljava/lang/String; = "subheader"

.field public static final TYPE_SWITCH:Ljava/lang/String; = "switch"

.field public static final TYPE_TIME:Ljava/lang/String; = "time"

.field public static final TYPE_TOGGLE:Ljava/lang/String; = "toggle"

.field private static gson:Lcom/google/gson/Gson;

.field private static mDataValueClassesMap:Ljava/util/HashMap;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/HashMap",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/Class;",
            ">;"
        }
    .end annotation
.end field

.field private static mSimpleTypeClassesMap:Ljava/util/HashMap;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/HashMap",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/Class;",
            ">;"
        }
    .end annotation
.end field

.field private static sComplexTypesClassesMap:Ljava/util/HashMap;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/HashMap",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/Class;",
            ">;"
        }
    .end annotation
.end field

.field private static sInstance:Lcom/jibo/ui/helpers/skills/SkillsJsonParser;


# instance fields
.field private mCurrentSkillIndx:I

.field private mDataItems:Lcom/jibo/ui/helpers/skills/DataItems;


# direct methods
.method static constructor <clinit>()V
    .locals 3

    .prologue
    .line 45
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    sput-object v0, Lcom/jibo/ui/helpers/skills/SkillsJsonParser;->sComplexTypesClassesMap:Ljava/util/HashMap;

    .line 47
    sget-object v0, Lcom/jibo/ui/helpers/skills/SkillsJsonParser;->sComplexTypesClassesMap:Ljava/util/HashMap;

    const-string v1, "switch"

    const-class v2, Lcom/jibo/ui/helpers/skills/DataItems$SwitchDataItem;

    invoke-virtual {v0, v1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 48
    sget-object v0, Lcom/jibo/ui/helpers/skills/SkillsJsonParser;->sComplexTypesClassesMap:Ljava/util/HashMap;

    const-string v1, "locationTextField"

    const-class v2, Lcom/jibo/ui/helpers/skills/DataItems$LocationDataItem;

    invoke-virtual {v0, v1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 49
    sget-object v0, Lcom/jibo/ui/helpers/skills/SkillsJsonParser;->sComplexTypesClassesMap:Ljava/util/HashMap;

    const-string v1, "connectable"

    const-class v2, Lcom/jibo/ui/helpers/skills/DataItems$ConnectableDataItem;

    invoke-virtual {v0, v1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 51
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    sput-object v0, Lcom/jibo/ui/helpers/skills/SkillsJsonParser;->mSimpleTypeClassesMap:Ljava/util/HashMap;

    .line 53
    sget-object v0, Lcom/jibo/ui/helpers/skills/SkillsJsonParser;->mSimpleTypeClassesMap:Ljava/util/HashMap;

    const-string v1, "skill"

    const-class v2, Lcom/jibo/ui/helpers/skills/DataItems$SkillDataItem;

    invoke-virtual {v0, v1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 54
    sget-object v0, Lcom/jibo/ui/helpers/skills/SkillsJsonParser;->mSimpleTypeClassesMap:Ljava/util/HashMap;

    const-string v1, "subheader"

    const-class v2, Lcom/jibo/ui/helpers/skills/DataItems$SubheaderDataItem;

    invoke-virtual {v0, v1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 55
    sget-object v0, Lcom/jibo/ui/helpers/skills/SkillsJsonParser;->mSimpleTypeClassesMap:Ljava/util/HashMap;

    const-string v1, "footer"

    const-class v2, Lcom/jibo/ui/helpers/skills/DataItems$FooterDataItem;

    invoke-virtual {v0, v1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 56
    sget-object v0, Lcom/jibo/ui/helpers/skills/SkillsJsonParser;->mSimpleTypeClassesMap:Ljava/util/HashMap;

    const-string v1, "location"

    const-class v2, Lcom/jibo/ui/helpers/skills/DataItems$LocationDataItem;

    invoke-virtual {v0, v1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 57
    sget-object v0, Lcom/jibo/ui/helpers/skills/SkillsJsonParser;->mSimpleTypeClassesMap:Ljava/util/HashMap;

    const-string v1, "choice"

    const-class v2, Lcom/jibo/ui/helpers/skills/DataItems$ChoiceDataItem;

    invoke-virtual {v0, v1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 58
    sget-object v0, Lcom/jibo/ui/helpers/skills/SkillsJsonParser;->mSimpleTypeClassesMap:Ljava/util/HashMap;

    const-string v1, "oauth"

    const-class v2, Lcom/jibo/ui/helpers/skills/DataItems$OauthDataItem;

    invoke-virtual {v0, v1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 59
    sget-object v0, Lcom/jibo/ui/helpers/skills/SkillsJsonParser;->mSimpleTypeClassesMap:Ljava/util/HashMap;

    const-string v1, "toggle"

    const-class v2, Lcom/jibo/ui/helpers/skills/DataItems$ToggleDataItem;

    invoke-virtual {v0, v1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 60
    sget-object v0, Lcom/jibo/ui/helpers/skills/SkillsJsonParser;->mSimpleTypeClassesMap:Ljava/util/HashMap;

    const-string v1, "time"

    const-class v2, Lcom/jibo/ui/helpers/skills/DataItems$TimeDataItem;

    invoke-virtual {v0, v1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 63
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    sput-object v0, Lcom/jibo/ui/helpers/skills/SkillsJsonParser;->mDataValueClassesMap:Ljava/util/HashMap;

    .line 66
    sget-object v0, Lcom/jibo/ui/helpers/skills/SkillsJsonParser;->mDataValueClassesMap:Ljava/util/HashMap;

    const-string v1, "switch"

    const-class v2, Lcom/jibo/ui/helpers/skills/DataItems$BooleanDataValue;

    invoke-virtual {v0, v1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 67
    sget-object v0, Lcom/jibo/ui/helpers/skills/SkillsJsonParser;->mDataValueClassesMap:Ljava/util/HashMap;

    const-string v1, "locationTextField"

    const-class v2, Lcom/jibo/ui/helpers/skills/DataItems$LocationDataValue;

    invoke-virtual {v0, v1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 68
    sget-object v0, Lcom/jibo/ui/helpers/skills/SkillsJsonParser;->mDataValueClassesMap:Ljava/util/HashMap;

    const-string v1, "location"

    const-class v2, Lcom/jibo/ui/helpers/skills/DataItems$LocationDataValue;

    invoke-virtual {v0, v1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 69
    sget-object v0, Lcom/jibo/ui/helpers/skills/SkillsJsonParser;->mDataValueClassesMap:Ljava/util/HashMap;

    const-string v1, "choice"

    const-class v2, Lcom/jibo/ui/helpers/skills/DataItems$IntegerDataValue;

    invoke-virtual {v0, v1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 70
    sget-object v0, Lcom/jibo/ui/helpers/skills/SkillsJsonParser;->mDataValueClassesMap:Ljava/util/HashMap;

    const-string v1, "connectable"

    const-class v2, Lcom/jibo/ui/helpers/skills/DataItems$ConnectableDataValue;

    invoke-virtual {v0, v1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 71
    sget-object v0, Lcom/jibo/ui/helpers/skills/SkillsJsonParser;->mDataValueClassesMap:Ljava/util/HashMap;

    const-string v1, "oauth"

    const-class v2, Lcom/jibo/ui/helpers/skills/DataItems$OauthDataValue;

    invoke-virtual {v0, v1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 72
    sget-object v0, Lcom/jibo/ui/helpers/skills/SkillsJsonParser;->mDataValueClassesMap:Ljava/util/HashMap;

    const-string v1, "toggle"

    const-class v2, Lcom/jibo/ui/helpers/skills/DataItems$BooleanDataValue;

    invoke-virtual {v0, v1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 73
    sget-object v0, Lcom/jibo/ui/helpers/skills/SkillsJsonParser;->mDataValueClassesMap:Ljava/util/HashMap;

    const-string v1, "time"

    const-class v2, Lcom/jibo/ui/helpers/skills/DataItems$TimeDataValue;

    invoke-virtual {v0, v1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 77
    new-instance v0, Lcom/google/gson/GsonBuilder;

    invoke-direct {v0}, Lcom/google/gson/GsonBuilder;-><init>()V

    const-class v1, Lcom/jibo/ui/helpers/skills/DataItems$DataItem;

    new-instance v2, Lcom/jibo/ui/helpers/skills/SkillsJsonParser$DataDeserializer;

    invoke-direct {v2}, Lcom/jibo/ui/helpers/skills/SkillsJsonParser$DataDeserializer;-><init>()V

    .line 78
    invoke-virtual {v0, v1, v2}, Lcom/google/gson/GsonBuilder;->a(Ljava/lang/reflect/Type;Ljava/lang/Object;)Lcom/google/gson/GsonBuilder;

    move-result-object v0

    const-class v1, Lcom/jibo/ui/helpers/skills/DataItems$BooleanDataValue;

    new-instance v2, Lcom/jibo/ui/helpers/skills/SkillsJsonParser$BooleanDataValueDeserializer;

    invoke-direct {v2}, Lcom/jibo/ui/helpers/skills/SkillsJsonParser$BooleanDataValueDeserializer;-><init>()V

    .line 79
    invoke-virtual {v0, v1, v2}, Lcom/google/gson/GsonBuilder;->a(Ljava/lang/reflect/Type;Ljava/lang/Object;)Lcom/google/gson/GsonBuilder;

    move-result-object v0

    .line 80
    invoke-virtual {v0}, Lcom/google/gson/GsonBuilder;->a()Lcom/google/gson/Gson;

    move-result-object v0

    sput-object v0, Lcom/jibo/ui/helpers/skills/SkillsJsonParser;->gson:Lcom/google/gson/Gson;

    .line 77
    return-void
.end method

.method public constructor <init>()V
    .locals 1

    .prologue
    .line 101
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 82
    const/4 v0, 0x0

    iput v0, p0, Lcom/jibo/ui/helpers/skills/SkillsJsonParser;->mCurrentSkillIndx:I

    .line 101
    return-void
.end method

.method static synthetic access$000()Ljava/util/HashMap;
    .locals 1

    .prologue
    .line 31
    sget-object v0, Lcom/jibo/ui/helpers/skills/SkillsJsonParser;->mSimpleTypeClassesMap:Ljava/util/HashMap;

    return-object v0
.end method

.method static synthetic access$100()Ljava/util/HashMap;
    .locals 1

    .prologue
    .line 31
    sget-object v0, Lcom/jibo/ui/helpers/skills/SkillsJsonParser;->sComplexTypesClassesMap:Ljava/util/HashMap;

    return-object v0
.end method

.method static synthetic access$200()Lcom/google/gson/Gson;
    .locals 1

    .prologue
    .line 31
    sget-object v0, Lcom/jibo/ui/helpers/skills/SkillsJsonParser;->gson:Lcom/google/gson/Gson;

    return-object v0
.end method

.method public static declared-synchronized getInstance()Lcom/jibo/ui/helpers/skills/SkillsJsonParser;
    .locals 3

    .prologue
    .line 89
    const-class v1, Lcom/jibo/ui/helpers/skills/SkillsJsonParser;

    monitor-enter v1

    :try_start_0
    sget-object v0, Lcom/jibo/ui/helpers/skills/SkillsJsonParser;->sInstance:Lcom/jibo/ui/helpers/skills/SkillsJsonParser;

    .line 90
    if-nez v0, :cond_1

    .line 91
    const-class v2, Lcom/jibo/ui/helpers/skills/SkillsJsonParser;

    monitor-enter v2
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_1

    .line 92
    :try_start_1
    sget-object v0, Lcom/jibo/ui/helpers/skills/SkillsJsonParser;->sInstance:Lcom/jibo/ui/helpers/skills/SkillsJsonParser;

    .line 93
    if-nez v0, :cond_0

    .line 94
    new-instance v0, Lcom/jibo/ui/helpers/skills/SkillsJsonParser;

    invoke-direct {v0}, Lcom/jibo/ui/helpers/skills/SkillsJsonParser;-><init>()V

    sput-object v0, Lcom/jibo/ui/helpers/skills/SkillsJsonParser;->sInstance:Lcom/jibo/ui/helpers/skills/SkillsJsonParser;

    .line 96
    :cond_0
    monitor-exit v2
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .line 98
    :cond_1
    monitor-exit v1

    return-object v0

    .line 96
    :catchall_0
    move-exception v0

    :try_start_2
    monitor-exit v2
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    :try_start_3
    throw v0
    :try_end_3
    .catchall {:try_start_3 .. :try_end_3} :catchall_1

    .line 89
    :catchall_1
    move-exception v0

    monitor-exit v1

    throw v0
.end method

.method private isConfigured(Lcom/google/gson/JsonElement;)Z
    .locals 1

    .prologue
    .line 269
    invoke-virtual {p1}, Lcom/google/gson/JsonElement;->i()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 270
    invoke-virtual {p1}, Lcom/google/gson/JsonElement;->l()Lcom/google/gson/JsonObject;

    move-result-object v0

    invoke-virtual {v0}, Lcom/google/gson/JsonObject;->a()Ljava/util/Set;

    move-result-object v0

    invoke-direct {p0, v0}, Lcom/jibo/ui/helpers/skills/SkillsJsonParser;->isConfigured(Ljava/util/Set;)Z

    move-result v0

    .line 274
    :goto_0
    return v0

    .line 271
    :cond_0
    invoke-virtual {p1}, Lcom/google/gson/JsonElement;->j()Z

    move-result v0

    if-eqz v0, :cond_1

    move-object v0, p1

    check-cast v0, Lcom/google/gson/JsonPrimitive;

    invoke-virtual {v0}, Lcom/google/gson/JsonPrimitive;->a()Z

    move-result v0

    if-eqz v0, :cond_1

    .line 272
    invoke-virtual {p1}, Lcom/google/gson/JsonElement;->g()Z

    move-result v0

    goto :goto_0

    .line 274
    :cond_1
    const/4 v0, 0x1

    goto :goto_0
.end method

.method private isConfigured(Ljava/util/Set;)Z
    .locals 5
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/Set",
            "<",
            "Ljava/util/Map$Entry",
            "<",
            "Ljava/lang/String;",
            "Lcom/google/gson/JsonElement;",
            ">;>;)Z"
        }
    .end annotation

    .prologue
    .line 259
    const/4 v0, 0x0

    .line 260
    invoke-interface {p1}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v3

    move v2, v0

    :goto_0
    invoke-interface {v3}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_0

    invoke-interface {v3}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/util/Map$Entry;

    .line 261
    invoke-interface {v0}, Ljava/util/Map$Entry;->getKey()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/lang/String;

    const-string v4, "offerProactively"

    invoke-virtual {v1, v4}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-nez v1, :cond_1

    .line 262
    invoke-interface {v0}, Ljava/util/Map$Entry;->getValue()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/google/gson/JsonElement;

    invoke-direct {p0, v0}, Lcom/jibo/ui/helpers/skills/SkillsJsonParser;->isConfigured(Lcom/google/gson/JsonElement;)Z

    move-result v0

    or-int/2addr v0, v2

    :goto_1
    move v2, v0

    .line 264
    goto :goto_0

    .line 265
    :cond_0
    return v2

    :cond_1
    move v0, v2

    goto :goto_1
.end method

.method public static declared-synchronized isCreated()Z
    .locals 2

    .prologue
    .line 85
    const-class v1, Lcom/jibo/ui/helpers/skills/SkillsJsonParser;

    monitor-enter v1

    :try_start_0
    sget-object v0, Lcom/jibo/ui/helpers/skills/SkillsJsonParser;->sInstance:Lcom/jibo/ui/helpers/skills/SkillsJsonParser;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    if-eqz v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    monitor-exit v1

    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0

    :catchall_0
    move-exception v0

    monitor-exit v1

    throw v0
.end method

.method private setItemDataValue(Lcom/jibo/ui/helpers/skills/DataItems$DataItem;Ljava/lang/Class;)V
    .locals 4

    .prologue
    .line 104
    if-eqz p2, :cond_0

    .line 105
    invoke-virtual {p1}, Lcom/jibo/ui/helpers/skills/DataItems$DataItem;->getValueDefinition()Lcom/jibo/ui/helpers/skills/DataItems$ValueDefinition;

    move-result-object v1

    sget-object v2, Lcom/jibo/ui/helpers/skills/SkillsJsonParser;->gson:Lcom/google/gson/Gson;

    invoke-virtual {p0}, Lcom/jibo/ui/helpers/skills/SkillsJsonParser;->getSkills()Ljava/util/List;

    move-result-object v0

    iget v3, p0, Lcom/jibo/ui/helpers/skills/SkillsJsonParser;->mCurrentSkillIndx:I

    invoke-interface {v0, v3}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/jibo/ui/helpers/skills/DataItems$SkillDataItem;

    invoke-virtual {v0}, Lcom/jibo/ui/helpers/skills/DataItems$SkillDataItem;->getData()Lcom/google/gson/JsonObject;

    move-result-object v0

    .line 106
    invoke-virtual {p1}, Lcom/jibo/ui/helpers/skills/DataItems$DataItem;->getValueDefinition()Lcom/jibo/ui/helpers/skills/DataItems$ValueDefinition;

    move-result-object v3

    invoke-virtual {v3}, Lcom/jibo/ui/helpers/skills/DataItems$ValueDefinition;->getKey()Ljava/lang/String;

    move-result-object v3

    .line 105
    invoke-virtual {v0, v3}, Lcom/google/gson/JsonObject;->e(Ljava/lang/String;)Lcom/google/gson/JsonObject;

    move-result-object v0

    invoke-virtual {v2, v0, p2}, Lcom/google/gson/Gson;->a(Lcom/google/gson/JsonElement;Ljava/lang/Class;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/jibo/ui/helpers/skills/DataItems$DataValue;

    invoke-virtual {v1, v0}, Lcom/jibo/ui/helpers/skills/DataItems$ValueDefinition;->setDataValue(Lcom/jibo/ui/helpers/skills/DataItems$DataValue;)V

    .line 108
    :cond_0
    return-void
.end method


# virtual methods
.method public clearSkills()V
    .locals 1

    .prologue
    .line 140
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/jibo/ui/helpers/skills/SkillsJsonParser;->mDataItems:Lcom/jibo/ui/helpers/skills/DataItems;

    .line 141
    new-instance v0, Lcom/jibo/ui/helpers/skills/DataItems;

    invoke-direct {v0}, Lcom/jibo/ui/helpers/skills/DataItems;-><init>()V

    iput-object v0, p0, Lcom/jibo/ui/helpers/skills/SkillsJsonParser;->mDataItems:Lcom/jibo/ui/helpers/skills/DataItems;

    .line 142
    return-void
.end method

.method public getCurrentSkill()Lcom/jibo/ui/helpers/skills/DataItems$SkillDataItem;
    .locals 2

    .prologue
    .line 245
    invoke-virtual {p0}, Lcom/jibo/ui/helpers/skills/SkillsJsonParser;->getSkills()Ljava/util/List;

    move-result-object v0

    iget v1, p0, Lcom/jibo/ui/helpers/skills/SkillsJsonParser;->mCurrentSkillIndx:I

    invoke-interface {v0, v1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/jibo/ui/helpers/skills/DataItems$SkillDataItem;

    return-object v0
.end method

.method public getSkills()Ljava/util/List;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List",
            "<",
            "Lcom/jibo/ui/helpers/skills/DataItems$SkillDataItem;",
            ">;"
        }
    .end annotation

    .prologue
    .line 145
    iget-object v0, p0, Lcom/jibo/ui/helpers/skills/SkillsJsonParser;->mDataItems:Lcom/jibo/ui/helpers/skills/DataItems;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/jibo/ui/helpers/skills/SkillsJsonParser;->mDataItems:Lcom/jibo/ui/helpers/skills/DataItems;

    invoke-virtual {v0}, Lcom/jibo/ui/helpers/skills/DataItems;->getSkills()Ljava/util/List;

    move-result-object v0

    :goto_0
    return-object v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public getView([I)Lcom/jibo/ui/helpers/skills/DataItems$DataItem;
    .locals 4

    .prologue
    const/4 v3, 0x0

    .line 199
    const/4 v2, 0x0

    .line 201
    iget-object v0, p0, Lcom/jibo/ui/helpers/skills/SkillsJsonParser;->mDataItems:Lcom/jibo/ui/helpers/skills/DataItems;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/jibo/ui/helpers/skills/SkillsJsonParser;->mDataItems:Lcom/jibo/ui/helpers/skills/DataItems;

    invoke-virtual {v0}, Lcom/jibo/ui/helpers/skills/DataItems;->getSkills()Ljava/util/List;

    move-result-object v0

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/jibo/ui/helpers/skills/SkillsJsonParser;->mDataItems:Lcom/jibo/ui/helpers/skills/DataItems;

    invoke-virtual {v0}, Lcom/jibo/ui/helpers/skills/DataItems;->getSkills()Ljava/util/List;

    move-result-object v0

    invoke-interface {v0}, Ljava/util/List;->isEmpty()Z

    move-result v0

    if-eqz v0, :cond_1

    .line 229
    :cond_0
    :goto_0
    return-object v2

    .line 203
    :cond_1
    if-eqz p1, :cond_2

    array-length v0, p1

    if-nez v0, :cond_3

    .line 204
    :cond_2
    new-instance v1, Ljava/util/ArrayList;

    invoke-direct {v1}, Ljava/util/ArrayList;-><init>()V

    .line 205
    iget-object v0, p0, Lcom/jibo/ui/helpers/skills/SkillsJsonParser;->mDataItems:Lcom/jibo/ui/helpers/skills/DataItems;

    invoke-virtual {v0}, Lcom/jibo/ui/helpers/skills/DataItems;->getSkills()Ljava/util/List;

    move-result-object v0

    invoke-interface {v0}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v3

    :goto_1
    invoke-interface {v3}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_0

    invoke-interface {v3}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/jibo/ui/helpers/skills/DataItems$SkillDataItem;

    .line 206
    invoke-virtual {v0}, Lcom/jibo/ui/helpers/skills/DataItems$SkillDataItem;->getView()Lcom/jibo/ui/helpers/skills/DataItems$SkillViewDataItem;

    move-result-object v0

    invoke-interface {v1, v0}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    goto :goto_1

    .line 211
    :cond_3
    iget-object v0, p0, Lcom/jibo/ui/helpers/skills/SkillsJsonParser;->mDataItems:Lcom/jibo/ui/helpers/skills/DataItems;

    invoke-virtual {v0}, Lcom/jibo/ui/helpers/skills/DataItems;->getSkills()Ljava/util/List;

    move-result-object v0

    invoke-interface {v0}, Ljava/util/List;->size()I

    move-result v0

    aget v1, p1, v3

    if-le v0, v1, :cond_0

    .line 213
    iget-object v0, p0, Lcom/jibo/ui/helpers/skills/SkillsJsonParser;->mDataItems:Lcom/jibo/ui/helpers/skills/DataItems;

    invoke-virtual {v0}, Lcom/jibo/ui/helpers/skills/DataItems;->getSkills()Ljava/util/List;

    move-result-object v0

    aget v1, p1, v3

    invoke-interface {v0, v1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/jibo/ui/helpers/skills/DataItems$SkillDataItem;

    invoke-virtual {v0}, Lcom/jibo/ui/helpers/skills/DataItems$SkillDataItem;->getView()Lcom/jibo/ui/helpers/skills/DataItems$SkillViewDataItem;

    move-result-object v1

    move-object v0, v1

    .line 214
    check-cast v0, Lcom/jibo/ui/helpers/skills/DataItems$SkillViewDataItem;

    invoke-virtual {v0}, Lcom/jibo/ui/helpers/skills/DataItems$SkillViewDataItem;->getChildViews()Ljava/util/List;

    move-result-object v0

    if-eqz v0, :cond_4

    .line 215
    const/4 v0, 0x1

    move v2, v0

    :goto_2
    array-length v0, p1

    if-ge v2, v0, :cond_5

    .line 216
    instance-of v0, v1, Lcom/jibo/ui/helpers/skills/DataItems$GroupDataItem;

    if-eqz v0, :cond_5

    move-object v0, v1

    check-cast v0, Lcom/jibo/ui/helpers/skills/DataItems$GroupDataItem;

    .line 217
    invoke-virtual {v0}, Lcom/jibo/ui/helpers/skills/DataItems$GroupDataItem;->getChildViews()Ljava/util/List;

    move-result-object v0

    if-eqz v0, :cond_5

    move-object v0, v1

    check-cast v0, Lcom/jibo/ui/helpers/skills/DataItems$GroupDataItem;

    .line 218
    invoke-virtual {v0}, Lcom/jibo/ui/helpers/skills/DataItems$GroupDataItem;->getChildViews()Ljava/util/List;

    move-result-object v0

    invoke-interface {v0}, Ljava/util/List;->size()I

    move-result v0

    aget v3, p1, v2

    if-le v0, v3, :cond_5

    .line 219
    check-cast v1, Lcom/jibo/ui/helpers/skills/DataItems$GroupDataItem;

    invoke-virtual {v1}, Lcom/jibo/ui/helpers/skills/DataItems$GroupDataItem;->getChildViews()Ljava/util/List;

    move-result-object v0

    aget v1, p1, v2

    invoke-interface {v0, v1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/jibo/ui/helpers/skills/DataItems$DataItem;

    .line 215
    add-int/lit8 v1, v2, 0x1

    move v2, v1

    move-object v1, v0

    goto :goto_2

    :cond_4
    move-object v1, v2

    :cond_5
    move-object v2, v1

    .line 229
    goto/16 :goto_0
.end method

.method public getViews([I)Ljava/util/List;
    .locals 5
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "([I)",
            "Ljava/util/List",
            "<",
            "Lcom/jibo/ui/helpers/skills/DataItems$DataItem;",
            ">;"
        }
    .end annotation

    .prologue
    const/4 v3, 0x0

    const/4 v2, 0x0

    .line 149
    .line 150
    iget-object v0, p0, Lcom/jibo/ui/helpers/skills/SkillsJsonParser;->mDataItems:Lcom/jibo/ui/helpers/skills/DataItems;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/jibo/ui/helpers/skills/SkillsJsonParser;->mDataItems:Lcom/jibo/ui/helpers/skills/DataItems;

    invoke-virtual {v0}, Lcom/jibo/ui/helpers/skills/DataItems;->getSkills()Ljava/util/List;

    move-result-object v0

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/jibo/ui/helpers/skills/SkillsJsonParser;->mDataItems:Lcom/jibo/ui/helpers/skills/DataItems;

    invoke-virtual {v0}, Lcom/jibo/ui/helpers/skills/DataItems;->getSkills()Ljava/util/List;

    move-result-object v0

    invoke-interface {v0}, Ljava/util/List;->isEmpty()Z

    move-result v0

    if-eqz v0, :cond_1

    .line 191
    :cond_0
    return-object v3

    .line 152
    :cond_1
    if-eqz p1, :cond_2

    array-length v0, p1

    if-nez v0, :cond_3

    .line 153
    :cond_2
    new-instance v3, Ljava/util/ArrayList;

    invoke-direct {v3}, Ljava/util/ArrayList;-><init>()V

    .line 154
    iget-object v0, p0, Lcom/jibo/ui/helpers/skills/SkillsJsonParser;->mDataItems:Lcom/jibo/ui/helpers/skills/DataItems;

    invoke-virtual {v0}, Lcom/jibo/ui/helpers/skills/DataItems;->getSkills()Ljava/util/List;

    move-result-object v0

    invoke-interface {v0}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v1

    :goto_0
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_0

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/jibo/ui/helpers/skills/DataItems$SkillDataItem;

    .line 155
    invoke-virtual {v0}, Lcom/jibo/ui/helpers/skills/DataItems$SkillDataItem;->getView()Lcom/jibo/ui/helpers/skills/DataItems$SkillViewDataItem;

    move-result-object v0

    invoke-interface {v3, v0}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    goto :goto_0

    .line 160
    :cond_3
    iget-object v0, p0, Lcom/jibo/ui/helpers/skills/SkillsJsonParser;->mDataItems:Lcom/jibo/ui/helpers/skills/DataItems;

    invoke-virtual {v0}, Lcom/jibo/ui/helpers/skills/DataItems;->getSkills()Ljava/util/List;

    move-result-object v0

    invoke-interface {v0}, Ljava/util/List;->size()I

    move-result v0

    aget v1, p1, v2

    if-le v0, v1, :cond_0

    .line 162
    iget-object v0, p0, Lcom/jibo/ui/helpers/skills/SkillsJsonParser;->mDataItems:Lcom/jibo/ui/helpers/skills/DataItems;

    invoke-virtual {v0}, Lcom/jibo/ui/helpers/skills/DataItems;->getSkills()Ljava/util/List;

    move-result-object v0

    aget v1, p1, v2

    invoke-interface {v0, v1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/jibo/ui/helpers/skills/DataItems$SkillDataItem;

    .line 163
    iget-object v0, p0, Lcom/jibo/ui/helpers/skills/SkillsJsonParser;->mDataItems:Lcom/jibo/ui/helpers/skills/DataItems;

    invoke-virtual {v0}, Lcom/jibo/ui/helpers/skills/DataItems;->getSkills()Ljava/util/List;

    move-result-object v0

    aget v1, p1, v2

    invoke-interface {v0, v1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/jibo/ui/helpers/skills/DataItems$SkillDataItem;

    invoke-virtual {v0}, Lcom/jibo/ui/helpers/skills/DataItems$SkillDataItem;->getView()Lcom/jibo/ui/helpers/skills/DataItems$SkillViewDataItem;

    move-result-object v1

    move-object v0, v1

    .line 164
    check-cast v0, Lcom/jibo/ui/helpers/skills/DataItems$SkillViewDataItem;

    invoke-virtual {v0}, Lcom/jibo/ui/helpers/skills/DataItems$SkillViewDataItem;->getChildViews()Ljava/util/List;

    move-result-object v0

    if-eqz v0, :cond_5

    .line 165
    const/4 v0, 0x1

    move v2, v0

    :goto_1
    array-length v0, p1

    if-ge v2, v0, :cond_4

    .line 166
    instance-of v0, v1, Lcom/jibo/ui/helpers/skills/DataItems$GroupDataItem;

    if-eqz v0, :cond_4

    move-object v0, v1

    check-cast v0, Lcom/jibo/ui/helpers/skills/DataItems$GroupDataItem;

    .line 167
    invoke-virtual {v0}, Lcom/jibo/ui/helpers/skills/DataItems$GroupDataItem;->getChildViews()Ljava/util/List;

    move-result-object v0

    if-eqz v0, :cond_4

    move-object v0, v1

    check-cast v0, Lcom/jibo/ui/helpers/skills/DataItems$GroupDataItem;

    .line 168
    invoke-virtual {v0}, Lcom/jibo/ui/helpers/skills/DataItems$GroupDataItem;->getChildViews()Ljava/util/List;

    move-result-object v0

    invoke-interface {v0}, Ljava/util/List;->size()I

    move-result v0

    aget v4, p1, v2

    if-le v0, v4, :cond_4

    .line 169
    check-cast v1, Lcom/jibo/ui/helpers/skills/DataItems$GroupDataItem;

    invoke-virtual {v1}, Lcom/jibo/ui/helpers/skills/DataItems$GroupDataItem;->getChildViews()Ljava/util/List;

    move-result-object v0

    aget v1, p1, v2

    invoke-interface {v0, v1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/jibo/ui/helpers/skills/DataItems$DataItem;

    .line 165
    add-int/lit8 v1, v2, 0x1

    move v2, v1

    move-object v1, v0

    goto :goto_1

    .line 174
    :cond_4
    instance-of v0, v1, Lcom/jibo/ui/helpers/skills/DataItems$GroupDataItem;

    if-eqz v0, :cond_6

    check-cast v1, Lcom/jibo/ui/helpers/skills/DataItems$GroupDataItem;

    .line 175
    invoke-virtual {v1}, Lcom/jibo/ui/helpers/skills/DataItems$GroupDataItem;->getChildViews()Ljava/util/List;

    move-result-object v0

    :goto_2
    move-object v3, v0

    .line 180
    :cond_5
    if-eqz v3, :cond_0

    invoke-interface {v3}, Ljava/util/List;->isEmpty()Z

    move-result v0

    if-nez v0, :cond_0

    .line 181
    new-instance v0, Lcom/jibo/ui/helpers/skills/SkillsJsonParser$3;

    invoke-direct {v0, p0}, Lcom/jibo/ui/helpers/skills/SkillsJsonParser$3;-><init>(Lcom/jibo/ui/helpers/skills/SkillsJsonParser;)V

    invoke-static {v3, v0}, Ljava/util/Collections;->sort(Ljava/util/List;Ljava/util/Comparator;)V

    .line 187
    invoke-interface {v3}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v2

    :goto_3
    invoke-interface {v2}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_0

    invoke-interface {v2}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/jibo/ui/helpers/skills/DataItems$DataItem;

    .line 188
    sget-object v1, Lcom/jibo/ui/helpers/skills/SkillsJsonParser;->mDataValueClassesMap:Ljava/util/HashMap;

    invoke-virtual {v0}, Lcom/jibo/ui/helpers/skills/DataItems$DataItem;->getType()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v1, v4}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/lang/Class;

    invoke-direct {p0, v0, v1}, Lcom/jibo/ui/helpers/skills/SkillsJsonParser;->setItemDataValue(Lcom/jibo/ui/helpers/skills/DataItems$DataItem;Ljava/lang/Class;)V

    goto :goto_3

    :cond_6
    move-object v0, v3

    .line 175
    goto :goto_2
.end method

.method public isConfigured()Z
    .locals 5

    .prologue
    const/4 v2, 0x1

    const/4 v1, 0x0

    .line 250
    :try_start_0
    invoke-virtual {p0}, Lcom/jibo/ui/helpers/skills/SkillsJsonParser;->getSkills()Ljava/util/List;

    move-result-object v0

    const/4 v3, 0x0

    invoke-interface {v0, v3}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/jibo/ui/helpers/skills/DataItems$SkillDataItem;

    invoke-virtual {v0}, Lcom/jibo/ui/helpers/skills/DataItems$SkillDataItem;->getData()Lcom/google/gson/JsonObject;

    move-result-object v0

    .line 251
    invoke-virtual {v0}, Lcom/google/gson/JsonObject;->a()Ljava/util/Set;

    move-result-object v3

    .line 252
    invoke-virtual {v0}, Lcom/google/gson/JsonObject;->p()I

    move-result v0

    const/4 v4, 0x7

    if-gt v0, v4, :cond_0

    invoke-direct {p0, v3}, Lcom/jibo/ui/helpers/skills/SkillsJsonParser;->isConfigured(Ljava/util/Set;)Z
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    move-result v0

    if-eqz v0, :cond_1

    :cond_0
    move v0, v2

    .line 254
    :goto_0
    return v0

    :cond_1
    move v0, v1

    .line 252
    goto :goto_0

    .line 253
    :catch_0
    move-exception v0

    move v0, v2

    .line 254
    goto :goto_0
.end method

.method public parseSkills(Ljava/lang/String;)Lcom/jibo/ui/helpers/skills/SkillsJsonParser;
    .locals 3

    .prologue
    .line 118
    :try_start_0
    new-instance v0, Lcom/jibo/ui/helpers/skills/DataItems;

    invoke-direct {v0}, Lcom/jibo/ui/helpers/skills/DataItems;-><init>()V

    iput-object v0, p0, Lcom/jibo/ui/helpers/skills/SkillsJsonParser;->mDataItems:Lcom/jibo/ui/helpers/skills/DataItems;

    .line 119
    new-instance v0, Lcom/google/gson/JsonParser;

    invoke-direct {v0}, Lcom/google/gson/JsonParser;-><init>()V

    invoke-virtual {v0, p1}, Lcom/google/gson/JsonParser;->a(Ljava/lang/String;)Lcom/google/gson/JsonElement;

    move-result-object v0

    .line 120
    invoke-virtual {v0}, Lcom/google/gson/JsonElement;->h()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 121
    sget-object v0, Lcom/jibo/ui/helpers/skills/SkillsJsonParser;->gson:Lcom/google/gson/Gson;

    new-instance v1, Lcom/jibo/ui/helpers/skills/SkillsJsonParser$1;

    invoke-direct {v1, p0}, Lcom/jibo/ui/helpers/skills/SkillsJsonParser$1;-><init>(Lcom/jibo/ui/helpers/skills/SkillsJsonParser;)V

    .line 122
    invoke-virtual {v1}, Lcom/jibo/ui/helpers/skills/SkillsJsonParser$1;->getType()Ljava/lang/reflect/Type;

    move-result-object v1

    .line 121
    invoke-virtual {v0, p1, v1}, Lcom/google/gson/Gson;->a(Ljava/lang/String;Ljava/lang/reflect/Type;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/util/List;

    .line 123
    new-instance v1, Lcom/jibo/ui/helpers/skills/SkillsJsonParser$2;

    invoke-direct {v1, p0}, Lcom/jibo/ui/helpers/skills/SkillsJsonParser$2;-><init>(Lcom/jibo/ui/helpers/skills/SkillsJsonParser;)V

    invoke-static {v0, v1}, Ljava/util/Collections;->sort(Ljava/util/List;Ljava/util/Comparator;)V

    .line 129
    iget-object v1, p0, Lcom/jibo/ui/helpers/skills/SkillsJsonParser;->mDataItems:Lcom/jibo/ui/helpers/skills/DataItems;

    invoke-virtual {v1, v0}, Lcom/jibo/ui/helpers/skills/DataItems;->addSkills(Ljava/util/List;)V

    .line 136
    :goto_0
    return-object p0

    .line 131
    :cond_0
    iget-object v1, p0, Lcom/jibo/ui/helpers/skills/SkillsJsonParser;->mDataItems:Lcom/jibo/ui/helpers/skills/DataItems;

    sget-object v0, Lcom/jibo/ui/helpers/skills/SkillsJsonParser;->gson:Lcom/google/gson/Gson;

    const-class v2, Lcom/jibo/ui/helpers/skills/DataItems$SkillDataItem;

    invoke-virtual {v0, p1, v2}, Lcom/google/gson/Gson;->a(Ljava/lang/String;Ljava/lang/Class;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/jibo/ui/helpers/skills/DataItems$SkillDataItem;

    invoke-virtual {v1, v0}, Lcom/jibo/ui/helpers/skills/DataItems;->addSkill(Lcom/jibo/ui/helpers/skills/DataItems$SkillDataItem;)V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    goto :goto_0

    .line 133
    :catch_0
    move-exception v0

    .line 134
    invoke-static {v0}, Lcom/crashlytics/android/Crashlytics;->a(Ljava/lang/Throwable;)V

    goto :goto_0
.end method

.method public selectSkill(I)V
    .locals 0

    .prologue
    .line 233
    iput p1, p0, Lcom/jibo/ui/helpers/skills/SkillsJsonParser;->mCurrentSkillIndx:I

    .line 234
    return-void
.end method

.method public setItemDataValue(Lcom/jibo/ui/helpers/skills/DataItems$DataItem;)V
    .locals 2

    .prologue
    .line 195
    sget-object v0, Lcom/jibo/ui/helpers/skills/SkillsJsonParser;->mDataValueClassesMap:Ljava/util/HashMap;

    invoke-virtual {p1}, Lcom/jibo/ui/helpers/skills/DataItems$DataItem;->getType()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/Class;

    invoke-direct {p0, p1, v0}, Lcom/jibo/ui/helpers/skills/SkillsJsonParser;->setItemDataValue(Lcom/jibo/ui/helpers/skills/DataItems$DataItem;Ljava/lang/Class;)V

    .line 196
    return-void
.end method

.method public updateData(Ljava/lang/String;Lcom/google/gson/JsonElement;)V
    .locals 2

    .prologue
    .line 241
    invoke-virtual {p0}, Lcom/jibo/ui/helpers/skills/SkillsJsonParser;->getSkills()Ljava/util/List;

    move-result-object v0

    iget v1, p0, Lcom/jibo/ui/helpers/skills/SkillsJsonParser;->mCurrentSkillIndx:I

    invoke-interface {v0, v1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/jibo/ui/helpers/skills/DataItems$SkillDataItem;

    invoke-virtual {v0}, Lcom/jibo/ui/helpers/skills/DataItems$SkillDataItem;->getData()Lcom/google/gson/JsonObject;

    move-result-object v0

    invoke-virtual {v0, p1, p2}, Lcom/google/gson/JsonObject;->a(Ljava/lang/String;Lcom/google/gson/JsonElement;)V

    .line 242
    return-void
.end method

.method public updateData(Ljava/lang/String;Lcom/jibo/ui/helpers/skills/DataItems$DataValue;)V
    .locals 2

    .prologue
    .line 237
    invoke-virtual {p0}, Lcom/jibo/ui/helpers/skills/SkillsJsonParser;->getSkills()Ljava/util/List;

    move-result-object v0

    iget v1, p0, Lcom/jibo/ui/helpers/skills/SkillsJsonParser;->mCurrentSkillIndx:I

    invoke-interface {v0, v1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/jibo/ui/helpers/skills/DataItems$SkillDataItem;

    invoke-virtual {v0}, Lcom/jibo/ui/helpers/skills/DataItems$SkillDataItem;->getData()Lcom/google/gson/JsonObject;

    move-result-object v0

    sget-object v1, Lcom/jibo/ui/helpers/skills/SkillsJsonParser;->gson:Lcom/google/gson/Gson;

    invoke-virtual {v1, p2}, Lcom/google/gson/Gson;->a(Ljava/lang/Object;)Lcom/google/gson/JsonElement;

    move-result-object v1

    invoke-virtual {v0, p1, v1}, Lcom/google/gson/JsonObject;->a(Ljava/lang/String;Lcom/google/gson/JsonElement;)V

    .line 238
    return-void
.end method
