.class public Lcom/segment/analytics/android/integrations/mixpanel/MixpanelIntegration;
.super Lcom/segment/analytics/integrations/Integration;
.source "MixpanelIntegration.java"


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lcom/segment/analytics/integrations/Integration",
        "<",
        "Lcom/mixpanel/android/mpmetrics/MixpanelAPI;",
        ">;"
    }
.end annotation


# static fields
.field public static final FACTORY:Lcom/segment/analytics/integrations/Integration$Factory;

.field private static final MAPPER:Ljava/util/Map;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field

.field private static final MIXPANEL_KEY:Ljava/lang/String; = "Mixpanel"

.field private static final VIEWED_EVENT_FORMAT:Ljava/lang/String; = "Viewed %s Screen"


# instance fields
.field private final consolidatedPageCalls:Z

.field final increments:Ljava/util/Set;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Set",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field

.field final isPeopleEnabled:Z

.field private final logger:Lcom/segment/analytics/integrations/Logger;

.field private final mixpanel:Lcom/mixpanel/android/mpmetrics/MixpanelAPI;

.field final mixpanelPeople:Lcom/mixpanel/android/mpmetrics/MixpanelAPI$People;

.field private final peopleProperties:Ljava/util/Set;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Set",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field

.field final setAllTraitsByDefault:Z

.field private final superProperties:Ljava/util/Set;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Set",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field

.field final token:Ljava/lang/String;

.field final trackAllPages:Z

.field final trackCategorizedPages:Z

.field final trackNamedPages:Z


# direct methods
.method static constructor <clinit>()V
    .locals 3

    .prologue
    .line 30
    new-instance v0, Lcom/segment/analytics/android/integrations/mixpanel/MixpanelIntegration$1;

    invoke-direct {v0}, Lcom/segment/analytics/android/integrations/mixpanel/MixpanelIntegration$1;-><init>()V

    sput-object v0, Lcom/segment/analytics/android/integrations/mixpanel/MixpanelIntegration;->FACTORY:Lcom/segment/analytics/integrations/Integration$Factory;

    .line 82
    new-instance v0, Ljava/util/LinkedHashMap;

    invoke-direct {v0}, Ljava/util/LinkedHashMap;-><init>()V

    .line 83
    const-string v1, "email"

    const-string v2, "$email"

    invoke-interface {v0, v1, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 84
    const-string v1, "phone"

    const-string v2, "$phone"

    invoke-interface {v0, v1, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 85
    const-string v1, "firstName"

    const-string v2, "$first_name"

    invoke-interface {v0, v1, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 86
    const-string v1, "lastName"

    const-string v2, "$last_name"

    invoke-interface {v0, v1, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 87
    const-string v1, "name"

    const-string v2, "$name"

    invoke-interface {v0, v1, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 88
    const-string v1, "username"

    const-string v2, "$username"

    invoke-interface {v0, v1, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 89
    const-string v1, "createdAt"

    const-string v2, "$created"

    invoke-interface {v0, v1, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 90
    invoke-static {v0}, Ljava/util/Collections;->unmodifiableMap(Ljava/util/Map;)Ljava/util/Map;

    move-result-object v0

    sput-object v0, Lcom/segment/analytics/android/integrations/mixpanel/MixpanelIntegration;->MAPPER:Ljava/util/Map;

    .line 91
    return-void
.end method

.method public constructor <init>(Lcom/mixpanel/android/mpmetrics/MixpanelAPI;Lcom/mixpanel/android/mpmetrics/MixpanelAPI$People;ZZZZZLjava/lang/String;Lcom/segment/analytics/integrations/Logger;Ljava/util/Set;ZLjava/util/Set;Ljava/util/Set;)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/mixpanel/android/mpmetrics/MixpanelAPI;",
            "Lcom/mixpanel/android/mpmetrics/MixpanelAPI$People;",
            "ZZZZZ",
            "Ljava/lang/String;",
            "Lcom/segment/analytics/integrations/Logger;",
            "Ljava/util/Set",
            "<",
            "Ljava/lang/String;",
            ">;Z",
            "Ljava/util/Set",
            "<",
            "Ljava/lang/String;",
            ">;",
            "Ljava/util/Set",
            "<",
            "Ljava/lang/String;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 137
    invoke-direct {p0}, Lcom/segment/analytics/integrations/Integration;-><init>()V

    .line 138
    iput-object p1, p0, Lcom/segment/analytics/android/integrations/mixpanel/MixpanelIntegration;->mixpanel:Lcom/mixpanel/android/mpmetrics/MixpanelAPI;

    .line 139
    iput-object p2, p0, Lcom/segment/analytics/android/integrations/mixpanel/MixpanelIntegration;->mixpanelPeople:Lcom/mixpanel/android/mpmetrics/MixpanelAPI$People;

    .line 140
    iput-boolean p3, p0, Lcom/segment/analytics/android/integrations/mixpanel/MixpanelIntegration;->isPeopleEnabled:Z

    .line 141
    iput-boolean p4, p0, Lcom/segment/analytics/android/integrations/mixpanel/MixpanelIntegration;->consolidatedPageCalls:Z

    .line 142
    iput-boolean p5, p0, Lcom/segment/analytics/android/integrations/mixpanel/MixpanelIntegration;->trackAllPages:Z

    .line 143
    iput-boolean p6, p0, Lcom/segment/analytics/android/integrations/mixpanel/MixpanelIntegration;->trackCategorizedPages:Z

    .line 144
    iput-boolean p7, p0, Lcom/segment/analytics/android/integrations/mixpanel/MixpanelIntegration;->trackNamedPages:Z

    .line 145
    iput-object p8, p0, Lcom/segment/analytics/android/integrations/mixpanel/MixpanelIntegration;->token:Ljava/lang/String;

    .line 146
    iput-object p9, p0, Lcom/segment/analytics/android/integrations/mixpanel/MixpanelIntegration;->logger:Lcom/segment/analytics/integrations/Logger;

    .line 147
    iput-object p10, p0, Lcom/segment/analytics/android/integrations/mixpanel/MixpanelIntegration;->increments:Ljava/util/Set;

    .line 148
    iput-boolean p11, p0, Lcom/segment/analytics/android/integrations/mixpanel/MixpanelIntegration;->setAllTraitsByDefault:Z

    .line 149
    iput-object p12, p0, Lcom/segment/analytics/android/integrations/mixpanel/MixpanelIntegration;->peopleProperties:Ljava/util/Set;

    .line 150
    iput-object p13, p0, Lcom/segment/analytics/android/integrations/mixpanel/MixpanelIntegration;->superProperties:Ljava/util/Set;

    .line 151
    return-void
.end method

.method static synthetic access$000(Lcom/segment/analytics/ValueMap;Ljava/lang/String;)Ljava/util/Set;
    .locals 1

    .prologue
    .line 28
    invoke-static {p0, p1}, Lcom/segment/analytics/android/integrations/mixpanel/MixpanelIntegration;->getStringSet(Lcom/segment/analytics/ValueMap;Ljava/lang/String;)Ljava/util/Set;

    move-result-object v0

    return-object v0
.end method

.method static filter(Ljava/util/Map;Ljava/lang/Iterable;)Ljava/util/Map;
    .locals 4
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "<T:",
            "Ljava/lang/Object;",
            ">(",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "TT;>;",
            "Ljava/lang/Iterable",
            "<",
            "Ljava/lang/String;",
            ">;)",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "TT;>;"
        }
    .end annotation

    .prologue
    .line 190
    new-instance v1, Ljava/util/LinkedHashMap;

    invoke-direct {v1}, Ljava/util/LinkedHashMap;-><init>()V

    .line 191
    invoke-interface {p1}, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;

    move-result-object v2

    :cond_0
    :goto_0
    invoke-interface {v2}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_1

    invoke-interface {v2}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    .line 192
    invoke-interface {p0, v0}, Ljava/util/Map;->containsKey(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_0

    .line 193
    invoke-interface {p0, v0}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v3

    invoke-interface {v1, v0, v3}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    goto :goto_0

    .line 196
    :cond_1
    return-object v1
.end method

.method private static getStringSet(Lcom/segment/analytics/ValueMap;Ljava/lang/String;)Ljava/util/Set;
    .locals 4
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/segment/analytics/ValueMap;",
            "Ljava/lang/String;",
            ")",
            "Ljava/util/Set",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation

    .prologue
    .line 110
    :try_start_0
    invoke-virtual {p0, p1}, Lcom/segment/analytics/ValueMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/util/List;

    .line 111
    if-eqz v0, :cond_0

    invoke-interface {v0}, Ljava/util/List;->size()I

    move-result v1

    if-nez v1, :cond_1

    .line 112
    :cond_0
    invoke-static {}, Ljava/util/Collections;->emptySet()Ljava/util/Set;

    move-result-object v0

    .line 120
    :goto_0
    return-object v0

    .line 114
    :cond_1
    new-instance v2, Ljava/util/HashSet;

    invoke-interface {v0}, Ljava/util/List;->size()I

    move-result v1

    invoke-direct {v2, v1}, Ljava/util/HashSet;-><init>(I)V

    .line 115
    const/4 v1, 0x0

    move v3, v1

    :goto_1
    invoke-interface {v0}, Ljava/util/List;->size()I

    move-result v1

    if-ge v3, v1, :cond_2

    .line 116
    invoke-interface {v0, v3}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/lang/String;

    invoke-interface {v2, v1}, Ljava/util/Set;->add(Ljava/lang/Object;)Z
    :try_end_0
    .catch Ljava/lang/ClassCastException; {:try_start_0 .. :try_end_0} :catch_0

    .line 115
    add-int/lit8 v1, v3, 0x1

    move v3, v1

    goto :goto_1

    :cond_2
    move-object v0, v2

    .line 118
    goto :goto_0

    .line 119
    :catch_0
    move-exception v0

    .line 120
    invoke-static {}, Ljava/util/Collections;->emptySet()Ljava/util/Set;

    move-result-object v0

    goto :goto_0
.end method

.method private registerSuperProperties(Ljava/util/Map;)V
    .locals 5
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/Object;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 169
    invoke-static {p1}, Lcom/segment/analytics/internal/Utils;->isNullOrEmpty(Ljava/util/Map;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 175
    :goto_0
    return-void

    .line 172
    :cond_0
    new-instance v0, Lcom/segment/analytics/ValueMap;

    sget-object v1, Lcom/segment/analytics/android/integrations/mixpanel/MixpanelIntegration;->MAPPER:Ljava/util/Map;

    invoke-static {p1, v1}, Lcom/segment/analytics/internal/Utils;->transform(Ljava/util/Map;Ljava/util/Map;)Ljava/util/Map;

    move-result-object v1

    invoke-direct {v0, v1}, Lcom/segment/analytics/ValueMap;-><init>(Ljava/util/Map;)V

    invoke-virtual {v0}, Lcom/segment/analytics/ValueMap;->toJsonObject()Lorg/json/JSONObject;

    move-result-object v0

    .line 173
    iget-object v1, p0, Lcom/segment/analytics/android/integrations/mixpanel/MixpanelIntegration;->mixpanel:Lcom/mixpanel/android/mpmetrics/MixpanelAPI;

    invoke-virtual {v1, v0}, Lcom/mixpanel/android/mpmetrics/MixpanelAPI;->a(Lorg/json/JSONObject;)V

    .line 174
    iget-object v1, p0, Lcom/segment/analytics/android/integrations/mixpanel/MixpanelIntegration;->logger:Lcom/segment/analytics/integrations/Logger;

    const-string v2, "mixpanel.registerSuperProperties(%s)"

    const/4 v3, 0x1

    new-array v3, v3, [Ljava/lang/Object;

    const/4 v4, 0x0

    aput-object v0, v3, v4

    invoke-virtual {v1, v2, v3}, Lcom/segment/analytics/integrations/Logger;->verbose(Ljava/lang/String;[Ljava/lang/Object;)V

    goto :goto_0
.end method

.method private setPeopleProperties(Ljava/util/Map;)V
    .locals 5
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/Object;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 178
    invoke-static {p1}, Lcom/segment/analytics/internal/Utils;->isNullOrEmpty(Ljava/util/Map;)Z

    move-result v0

    if-eqz v0, :cond_1

    .line 187
    :cond_0
    :goto_0
    return-void

    .line 181
    :cond_1
    iget-boolean v0, p0, Lcom/segment/analytics/android/integrations/mixpanel/MixpanelIntegration;->isPeopleEnabled:Z

    if-eqz v0, :cond_0

    .line 184
    new-instance v0, Lcom/segment/analytics/ValueMap;

    sget-object v1, Lcom/segment/analytics/android/integrations/mixpanel/MixpanelIntegration;->MAPPER:Ljava/util/Map;

    invoke-static {p1, v1}, Lcom/segment/analytics/internal/Utils;->transform(Ljava/util/Map;Ljava/util/Map;)Ljava/util/Map;

    move-result-object v1

    invoke-direct {v0, v1}, Lcom/segment/analytics/ValueMap;-><init>(Ljava/util/Map;)V

    invoke-virtual {v0}, Lcom/segment/analytics/ValueMap;->toJsonObject()Lorg/json/JSONObject;

    move-result-object v0

    .line 185
    iget-object v1, p0, Lcom/segment/analytics/android/integrations/mixpanel/MixpanelIntegration;->mixpanelPeople:Lcom/mixpanel/android/mpmetrics/MixpanelAPI$People;

    invoke-interface {v1, v0}, Lcom/mixpanel/android/mpmetrics/MixpanelAPI$People;->a(Lorg/json/JSONObject;)V

    .line 186
    iget-object v1, p0, Lcom/segment/analytics/android/integrations/mixpanel/MixpanelIntegration;->logger:Lcom/segment/analytics/integrations/Logger;

    const-string v2, "mixpanel.getPeople().set(%s)"

    const/4 v3, 0x1

    new-array v3, v3, [Ljava/lang/Object;

    const/4 v4, 0x0

    aput-object v0, v3, v4

    invoke-virtual {v1, v2, v3}, Lcom/segment/analytics/integrations/Logger;->verbose(Ljava/lang/String;[Ljava/lang/Object;)V

    goto :goto_0
.end method


# virtual methods
.method public alias(Lcom/segment/analytics/integrations/AliasPayload;)V
    .locals 6

    .prologue
    .line 244
    invoke-super {p0, p1}, Lcom/segment/analytics/integrations/Integration;->alias(Lcom/segment/analytics/integrations/AliasPayload;)V

    .line 245
    invoke-virtual {p1}, Lcom/segment/analytics/integrations/AliasPayload;->previousId()Ljava/lang/String;

    move-result-object v0

    .line 246
    invoke-virtual {p1}, Lcom/segment/analytics/integrations/AliasPayload;->anonymousId()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_0

    .line 248
    iget-object v0, p0, Lcom/segment/analytics/android/integrations/mixpanel/MixpanelIntegration;->mixpanel:Lcom/mixpanel/android/mpmetrics/MixpanelAPI;

    invoke-virtual {v0}, Lcom/mixpanel/android/mpmetrics/MixpanelAPI;->b()Ljava/lang/String;

    move-result-object v0

    .line 250
    :cond_0
    invoke-virtual {p1}, Lcom/segment/analytics/integrations/AliasPayload;->userId()Ljava/lang/String;

    move-result-object v1

    .line 251
    if-eqz v1, :cond_1

    .line 252
    iget-object v2, p0, Lcom/segment/analytics/android/integrations/mixpanel/MixpanelIntegration;->mixpanel:Lcom/mixpanel/android/mpmetrics/MixpanelAPI;

    invoke-virtual {v2, v1, v0}, Lcom/mixpanel/android/mpmetrics/MixpanelAPI;->a(Ljava/lang/String;Ljava/lang/String;)V

    .line 253
    iget-object v2, p0, Lcom/segment/analytics/android/integrations/mixpanel/MixpanelIntegration;->logger:Lcom/segment/analytics/integrations/Logger;

    const-string v3, "mixpanel.alias(%s, %s)"

    const/4 v4, 0x2

    new-array v4, v4, [Ljava/lang/Object;

    const/4 v5, 0x0

    aput-object v1, v4, v5

    const/4 v1, 0x1

    aput-object v0, v4, v1

    invoke-virtual {v2, v3, v4}, Lcom/segment/analytics/integrations/Logger;->verbose(Ljava/lang/String;[Ljava/lang/Object;)V

    .line 255
    :cond_1
    return-void
.end method

.method event(Ljava/lang/String;Lcom/segment/analytics/Properties;)V
    .locals 9

    .prologue
    const/4 v8, 0x2

    const/4 v7, 0x1

    const/4 v6, 0x0

    .line 291
    invoke-virtual {p2}, Lcom/segment/analytics/Properties;->toJsonObject()Lorg/json/JSONObject;

    move-result-object v0

    .line 292
    iget-object v1, p0, Lcom/segment/analytics/android/integrations/mixpanel/MixpanelIntegration;->mixpanel:Lcom/mixpanel/android/mpmetrics/MixpanelAPI;

    invoke-virtual {v1, p1, v0}, Lcom/mixpanel/android/mpmetrics/MixpanelAPI;->a(Ljava/lang/String;Lorg/json/JSONObject;)V

    .line 293
    iget-object v1, p0, Lcom/segment/analytics/android/integrations/mixpanel/MixpanelIntegration;->logger:Lcom/segment/analytics/integrations/Logger;

    const-string v2, "mixpanel.track(%s, %s)"

    new-array v3, v8, [Ljava/lang/Object;

    aput-object p1, v3, v6

    aput-object v0, v3, v7

    invoke-virtual {v1, v2, v3}, Lcom/segment/analytics/integrations/Logger;->verbose(Ljava/lang/String;[Ljava/lang/Object;)V

    .line 294
    iget-boolean v1, p0, Lcom/segment/analytics/android/integrations/mixpanel/MixpanelIntegration;->isPeopleEnabled:Z

    if-nez v1, :cond_1

    .line 303
    :cond_0
    :goto_0
    return-void

    .line 297
    :cond_1
    invoke-virtual {p2}, Lcom/segment/analytics/Properties;->revenue()D

    move-result-wide v2

    .line 298
    const-wide/16 v4, 0x0

    cmpl-double v1, v2, v4

    if-eqz v1, :cond_0

    .line 301
    iget-object v1, p0, Lcom/segment/analytics/android/integrations/mixpanel/MixpanelIntegration;->mixpanelPeople:Lcom/mixpanel/android/mpmetrics/MixpanelAPI$People;

    invoke-interface {v1, v2, v3, v0}, Lcom/mixpanel/android/mpmetrics/MixpanelAPI$People;->a(DLorg/json/JSONObject;)V

    .line 302
    iget-object v1, p0, Lcom/segment/analytics/android/integrations/mixpanel/MixpanelIntegration;->logger:Lcom/segment/analytics/integrations/Logger;

    const-string v4, "mixpanelPeople.trackCharge(%s, %s)"

    new-array v5, v8, [Ljava/lang/Object;

    invoke-static {v2, v3}, Ljava/lang/Double;->valueOf(D)Ljava/lang/Double;

    move-result-object v2

    aput-object v2, v5, v6

    aput-object v0, v5, v7

    invoke-virtual {v1, v4, v5}, Lcom/segment/analytics/integrations/Logger;->verbose(Ljava/lang/String;[Ljava/lang/Object;)V

    goto :goto_0
.end method

.method public flush()V
    .locals 3

    .prologue
    .line 230
    invoke-super {p0}, Lcom/segment/analytics/integrations/Integration;->flush()V

    .line 231
    iget-object v0, p0, Lcom/segment/analytics/android/integrations/mixpanel/MixpanelIntegration;->mixpanel:Lcom/mixpanel/android/mpmetrics/MixpanelAPI;

    invoke-virtual {v0}, Lcom/mixpanel/android/mpmetrics/MixpanelAPI;->a()V

    .line 232
    iget-object v0, p0, Lcom/segment/analytics/android/integrations/mixpanel/MixpanelIntegration;->logger:Lcom/segment/analytics/integrations/Logger;

    const-string v1, "mixpanel.flush()"

    const/4 v2, 0x0

    new-array v2, v2, [Ljava/lang/Object;

    invoke-virtual {v0, v1, v2}, Lcom/segment/analytics/integrations/Logger;->verbose(Ljava/lang/String;[Ljava/lang/Object;)V

    .line 233
    return-void
.end method

.method public getUnderlyingInstance()Lcom/mixpanel/android/mpmetrics/MixpanelAPI;
    .locals 1

    .prologue
    .line 165
    iget-object v0, p0, Lcom/segment/analytics/android/integrations/mixpanel/MixpanelIntegration;->mixpanel:Lcom/mixpanel/android/mpmetrics/MixpanelAPI;

    return-object v0
.end method

.method public bridge synthetic getUnderlyingInstance()Ljava/lang/Object;
    .locals 1

    .prologue
    .line 28
    invoke-virtual {p0}, Lcom/segment/analytics/android/integrations/mixpanel/MixpanelIntegration;->getUnderlyingInstance()Lcom/mixpanel/android/mpmetrics/MixpanelAPI;

    move-result-object v0

    return-object v0
.end method

.method public identify(Lcom/segment/analytics/integrations/IdentifyPayload;)V
    .locals 6

    .prologue
    const/4 v5, 0x1

    const/4 v4, 0x0

    .line 201
    invoke-super {p0, p1}, Lcom/segment/analytics/integrations/Integration;->identify(Lcom/segment/analytics/integrations/IdentifyPayload;)V

    .line 203
    invoke-virtual {p1}, Lcom/segment/analytics/integrations/IdentifyPayload;->userId()Ljava/lang/String;

    move-result-object v0

    .line 204
    if-eqz v0, :cond_0

    .line 205
    iget-object v1, p0, Lcom/segment/analytics/android/integrations/mixpanel/MixpanelIntegration;->mixpanel:Lcom/mixpanel/android/mpmetrics/MixpanelAPI;

    invoke-virtual {v1, v0}, Lcom/mixpanel/android/mpmetrics/MixpanelAPI;->a(Ljava/lang/String;)V

    .line 206
    iget-object v1, p0, Lcom/segment/analytics/android/integrations/mixpanel/MixpanelIntegration;->logger:Lcom/segment/analytics/integrations/Logger;

    const-string v2, "mixpanel.identify(%s)"

    new-array v3, v5, [Ljava/lang/Object;

    aput-object v0, v3, v4

    invoke-virtual {v1, v2, v3}, Lcom/segment/analytics/integrations/Logger;->verbose(Ljava/lang/String;[Ljava/lang/Object;)V

    .line 208
    iget-boolean v1, p0, Lcom/segment/analytics/android/integrations/mixpanel/MixpanelIntegration;->isPeopleEnabled:Z

    if-eqz v1, :cond_0

    .line 209
    iget-object v1, p0, Lcom/segment/analytics/android/integrations/mixpanel/MixpanelIntegration;->mixpanelPeople:Lcom/mixpanel/android/mpmetrics/MixpanelAPI$People;

    invoke-interface {v1, v0}, Lcom/mixpanel/android/mpmetrics/MixpanelAPI$People;->a(Ljava/lang/String;)V

    .line 210
    iget-object v1, p0, Lcom/segment/analytics/android/integrations/mixpanel/MixpanelIntegration;->logger:Lcom/segment/analytics/integrations/Logger;

    const-string v2, "mixpanel.getPeople().identify(%s)"

    new-array v3, v5, [Ljava/lang/Object;

    aput-object v0, v3, v4

    invoke-virtual {v1, v2, v3}, Lcom/segment/analytics/integrations/Logger;->verbose(Ljava/lang/String;[Ljava/lang/Object;)V

    .line 214
    :cond_0
    invoke-virtual {p1}, Lcom/segment/analytics/integrations/IdentifyPayload;->traits()Lcom/segment/analytics/Traits;

    move-result-object v0

    .line 216
    iget-boolean v1, p0, Lcom/segment/analytics/android/integrations/mixpanel/MixpanelIntegration;->setAllTraitsByDefault:Z

    if-eqz v1, :cond_1

    .line 217
    invoke-direct {p0, v0}, Lcom/segment/analytics/android/integrations/mixpanel/MixpanelIntegration;->registerSuperProperties(Ljava/util/Map;)V

    .line 218
    invoke-direct {p0, v0}, Lcom/segment/analytics/android/integrations/mixpanel/MixpanelIntegration;->setPeopleProperties(Ljava/util/Map;)V

    .line 226
    :goto_0
    return-void

    .line 222
    :cond_1
    iget-object v1, p0, Lcom/segment/analytics/android/integrations/mixpanel/MixpanelIntegration;->superProperties:Ljava/util/Set;

    invoke-static {v0, v1}, Lcom/segment/analytics/android/integrations/mixpanel/MixpanelIntegration;->filter(Ljava/util/Map;Ljava/lang/Iterable;)Ljava/util/Map;

    move-result-object v1

    .line 223
    invoke-direct {p0, v1}, Lcom/segment/analytics/android/integrations/mixpanel/MixpanelIntegration;->registerSuperProperties(Ljava/util/Map;)V

    .line 224
    iget-object v1, p0, Lcom/segment/analytics/android/integrations/mixpanel/MixpanelIntegration;->peopleProperties:Ljava/util/Set;

    invoke-static {v0, v1}, Lcom/segment/analytics/android/integrations/mixpanel/MixpanelIntegration;->filter(Ljava/util/Map;Ljava/lang/Iterable;)Ljava/util/Map;

    move-result-object v0

    .line 225
    invoke-direct {p0, v0}, Lcom/segment/analytics/android/integrations/mixpanel/MixpanelIntegration;->setPeopleProperties(Ljava/util/Map;)V

    goto :goto_0
.end method

.method public onActivityCreated(Landroid/app/Activity;Landroid/os/Bundle;)V
    .locals 1

    .prologue
    .line 155
    invoke-super {p0, p1, p2}, Lcom/segment/analytics/integrations/Integration;->onActivityCreated(Landroid/app/Activity;Landroid/os/Bundle;)V

    .line 160
    iget-object v0, p0, Lcom/segment/analytics/android/integrations/mixpanel/MixpanelIntegration;->token:Ljava/lang/String;

    invoke-static {p1, v0}, Lcom/mixpanel/android/mpmetrics/MixpanelAPI;->a(Landroid/content/Context;Ljava/lang/String;)Lcom/mixpanel/android/mpmetrics/MixpanelAPI;

    .line 161
    return-void
.end method

.method public reset()V
    .locals 3

    .prologue
    .line 237
    invoke-super {p0}, Lcom/segment/analytics/integrations/Integration;->reset()V

    .line 238
    iget-object v0, p0, Lcom/segment/analytics/android/integrations/mixpanel/MixpanelIntegration;->mixpanel:Lcom/mixpanel/android/mpmetrics/MixpanelAPI;

    invoke-virtual {v0}, Lcom/mixpanel/android/mpmetrics/MixpanelAPI;->d()V

    .line 239
    iget-object v0, p0, Lcom/segment/analytics/android/integrations/mixpanel/MixpanelIntegration;->logger:Lcom/segment/analytics/integrations/Logger;

    const-string v1, "mixpanel.reset()"

    const/4 v2, 0x0

    new-array v2, v2, [Ljava/lang/Object;

    invoke-virtual {v0, v1, v2}, Lcom/segment/analytics/integrations/Logger;->verbose(Ljava/lang/String;[Ljava/lang/Object;)V

    .line 240
    return-void
.end method

.method public screen(Lcom/segment/analytics/integrations/ScreenPayload;)V
    .locals 4

    .prologue
    const/4 v1, 0x1

    const/4 v3, 0x0

    .line 259
    iget-boolean v0, p0, Lcom/segment/analytics/android/integrations/mixpanel/MixpanelIntegration;->consolidatedPageCalls:Z

    if-eqz v0, :cond_1

    .line 260
    new-instance v0, Lcom/segment/analytics/Properties;

    invoke-direct {v0}, Lcom/segment/analytics/Properties;-><init>()V

    .line 261
    invoke-virtual {p1}, Lcom/segment/analytics/integrations/ScreenPayload;->properties()Lcom/segment/analytics/Properties;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/segment/analytics/Properties;->putAll(Ljava/util/Map;)V

    .line 262
    const-string v1, "name"

    invoke-virtual {p1}, Lcom/segment/analytics/integrations/ScreenPayload;->name()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Lcom/segment/analytics/Properties;->put(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/Object;

    .line 263
    const-string v1, "Loaded a Screen"

    invoke-virtual {p0, v1, v0}, Lcom/segment/analytics/android/integrations/mixpanel/MixpanelIntegration;->event(Ljava/lang/String;Lcom/segment/analytics/Properties;)V

    .line 276
    :cond_0
    :goto_0
    return-void

    .line 267
    :cond_1
    iget-boolean v0, p0, Lcom/segment/analytics/android/integrations/mixpanel/MixpanelIntegration;->trackAllPages:Z

    if-eqz v0, :cond_2

    .line 268
    const-string v0, "Viewed %s Screen"

    new-array v1, v1, [Ljava/lang/Object;

    invoke-virtual {p1}, Lcom/segment/analytics/integrations/ScreenPayload;->event()Ljava/lang/String;

    move-result-object v2

    aput-object v2, v1, v3

    invoke-static {v0, v1}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p1}, Lcom/segment/analytics/integrations/ScreenPayload;->properties()Lcom/segment/analytics/Properties;

    move-result-object v1

    invoke-virtual {p0, v0, v1}, Lcom/segment/analytics/android/integrations/mixpanel/MixpanelIntegration;->event(Ljava/lang/String;Lcom/segment/analytics/Properties;)V

    goto :goto_0

    .line 270
    :cond_2
    iget-boolean v0, p0, Lcom/segment/analytics/android/integrations/mixpanel/MixpanelIntegration;->trackCategorizedPages:Z

    if-eqz v0, :cond_3

    invoke-virtual {p1}, Lcom/segment/analytics/integrations/ScreenPayload;->category()Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Lcom/segment/analytics/internal/Utils;->isNullOrEmpty(Ljava/lang/CharSequence;)Z

    move-result v0

    if-nez v0, :cond_3

    .line 272
    const-string v0, "Viewed %s Screen"

    new-array v1, v1, [Ljava/lang/Object;

    invoke-virtual {p1}, Lcom/segment/analytics/integrations/ScreenPayload;->category()Ljava/lang/String;

    move-result-object v2

    aput-object v2, v1, v3

    invoke-static {v0, v1}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p1}, Lcom/segment/analytics/integrations/ScreenPayload;->properties()Lcom/segment/analytics/Properties;

    move-result-object v1

    invoke-virtual {p0, v0, v1}, Lcom/segment/analytics/android/integrations/mixpanel/MixpanelIntegration;->event(Ljava/lang/String;Lcom/segment/analytics/Properties;)V

    goto :goto_0

    .line 273
    :cond_3
    iget-boolean v0, p0, Lcom/segment/analytics/android/integrations/mixpanel/MixpanelIntegration;->trackNamedPages:Z

    if-eqz v0, :cond_0

    invoke-virtual {p1}, Lcom/segment/analytics/integrations/ScreenPayload;->name()Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Lcom/segment/analytics/internal/Utils;->isNullOrEmpty(Ljava/lang/CharSequence;)Z

    move-result v0

    if-nez v0, :cond_0

    .line 274
    const-string v0, "Viewed %s Screen"

    new-array v1, v1, [Ljava/lang/Object;

    invoke-virtual {p1}, Lcom/segment/analytics/integrations/ScreenPayload;->name()Ljava/lang/String;

    move-result-object v2

    aput-object v2, v1, v3

    invoke-static {v0, v1}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p1}, Lcom/segment/analytics/integrations/ScreenPayload;->properties()Lcom/segment/analytics/Properties;

    move-result-object v1

    invoke-virtual {p0, v0, v1}, Lcom/segment/analytics/android/integrations/mixpanel/MixpanelIntegration;->event(Ljava/lang/String;Lcom/segment/analytics/Properties;)V

    goto :goto_0
.end method

.method public track(Lcom/segment/analytics/integrations/TrackPayload;)V
    .locals 4

    .prologue
    .line 280
    invoke-virtual {p1}, Lcom/segment/analytics/integrations/TrackPayload;->event()Ljava/lang/String;

    move-result-object v0

    .line 282
    invoke-virtual {p1}, Lcom/segment/analytics/integrations/TrackPayload;->properties()Lcom/segment/analytics/Properties;

    move-result-object v1

    invoke-virtual {p0, v0, v1}, Lcom/segment/analytics/android/integrations/mixpanel/MixpanelIntegration;->event(Ljava/lang/String;Lcom/segment/analytics/Properties;)V

    .line 284
    iget-object v1, p0, Lcom/segment/analytics/android/integrations/mixpanel/MixpanelIntegration;->increments:Ljava/util/Set;

    invoke-interface {v1, v0}, Ljava/util/Set;->contains(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_0

    iget-boolean v1, p0, Lcom/segment/analytics/android/integrations/mixpanel/MixpanelIntegration;->isPeopleEnabled:Z

    if-eqz v1, :cond_0

    .line 285
    iget-object v1, p0, Lcom/segment/analytics/android/integrations/mixpanel/MixpanelIntegration;->mixpanelPeople:Lcom/mixpanel/android/mpmetrics/MixpanelAPI$People;

    const-wide/high16 v2, 0x3ff0000000000000L    # 1.0

    invoke-interface {v1, v0, v2, v3}, Lcom/mixpanel/android/mpmetrics/MixpanelAPI$People;->a(Ljava/lang/String;D)V

    .line 286
    iget-object v1, p0, Lcom/segment/analytics/android/integrations/mixpanel/MixpanelIntegration;->mixpanelPeople:Lcom/mixpanel/android/mpmetrics/MixpanelAPI$People;

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v3, "Last "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    new-instance v2, Ljava/util/Date;

    invoke-direct {v2}, Ljava/util/Date;-><init>()V

    invoke-interface {v1, v0, v2}, Lcom/mixpanel/android/mpmetrics/MixpanelAPI$People;->a(Ljava/lang/String;Ljava/lang/Object;)V

    .line 288
    :cond_0
    return-void
.end method
