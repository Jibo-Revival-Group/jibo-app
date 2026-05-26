.class final Lcom/segment/analytics/android/integrations/mixpanel/MixpanelIntegration$1;
.super Ljava/lang/Object;
.source "MixpanelIntegration.java"

# interfaces
.implements Lcom/segment/analytics/integrations/Integration$Factory;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/segment/analytics/android/integrations/mixpanel/MixpanelIntegration;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x8
    name = null
.end annotation


# direct methods
.method constructor <init>()V
    .locals 0

    .prologue
    .line 31
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public create(Lcom/segment/analytics/ValueMap;Lcom/segment/analytics/Analytics;)Lcom/segment/analytics/integrations/Integration;
    .locals 16
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/segment/analytics/ValueMap;",
            "Lcom/segment/analytics/Analytics;",
            ")",
            "Lcom/segment/analytics/integrations/Integration",
            "<*>;"
        }
    .end annotation

    .prologue
    .line 34
    const-string v1, "consolidatedPageCalls"

    const/4 v2, 0x1

    move-object/from16 v0, p1

    invoke-virtual {v0, v1, v2}, Lcom/segment/analytics/ValueMap;->getBoolean(Ljava/lang/String;Z)Z

    move-result v5

    .line 35
    const-string v1, "trackAllPages"

    const/4 v2, 0x0

    move-object/from16 v0, p1

    invoke-virtual {v0, v1, v2}, Lcom/segment/analytics/ValueMap;->getBoolean(Ljava/lang/String;Z)Z

    move-result v6

    .line 36
    const-string v1, "trackCategorizedPages"

    const/4 v2, 0x0

    move-object/from16 v0, p1

    invoke-virtual {v0, v1, v2}, Lcom/segment/analytics/ValueMap;->getBoolean(Ljava/lang/String;Z)Z

    move-result v7

    .line 37
    const-string v1, "trackNamedPages"

    const/4 v2, 0x0

    move-object/from16 v0, p1

    invoke-virtual {v0, v1, v2}, Lcom/segment/analytics/ValueMap;->getBoolean(Ljava/lang/String;Z)Z

    move-result v8

    .line 38
    const-string v1, "people"

    const/4 v2, 0x0

    move-object/from16 v0, p1

    invoke-virtual {v0, v1, v2}, Lcom/segment/analytics/ValueMap;->getBoolean(Ljava/lang/String;Z)Z

    move-result v4

    .line 39
    const-string v1, "token"

    move-object/from16 v0, p1

    invoke-virtual {v0, v1}, Lcom/segment/analytics/ValueMap;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v9

    .line 40
    const-string v1, "increments"

    move-object/from16 v0, p1

    invoke-static {v0, v1}, Lcom/segment/analytics/android/integrations/mixpanel/MixpanelIntegration;->access$000(Lcom/segment/analytics/ValueMap;Ljava/lang/String;)Ljava/util/Set;

    move-result-object v11

    .line 41
    const-string v1, "setAllTraitsByDefault"

    const/4 v2, 0x1

    move-object/from16 v0, p1

    invoke-virtual {v0, v1, v2}, Lcom/segment/analytics/ValueMap;->getBoolean(Ljava/lang/String;Z)Z

    move-result v12

    .line 42
    const-string v1, "peopleProperties"

    move-object/from16 v0, p1

    invoke-static {v0, v1}, Lcom/segment/analytics/android/integrations/mixpanel/MixpanelIntegration;->access$000(Lcom/segment/analytics/ValueMap;Ljava/lang/String;)Ljava/util/Set;

    move-result-object v13

    .line 43
    const-string v1, "superProperties"

    move-object/from16 v0, p1

    invoke-static {v0, v1}, Lcom/segment/analytics/android/integrations/mixpanel/MixpanelIntegration;->access$000(Lcom/segment/analytics/ValueMap;Ljava/lang/String;)Ljava/util/Set;

    move-result-object v14

    .line 45
    const-string v1, "Mixpanel"

    move-object/from16 v0, p2

    invoke-virtual {v0, v1}, Lcom/segment/analytics/Analytics;->logger(Ljava/lang/String;)Lcom/segment/analytics/integrations/Logger;

    move-result-object v10

    .line 46
    invoke-virtual/range {p2 .. p2}, Lcom/segment/analytics/Analytics;->getApplication()Landroid/app/Application;

    move-result-object v1

    invoke-static {v1, v9}, Lcom/mixpanel/android/mpmetrics/MixpanelAPI;->a(Landroid/content/Context;Ljava/lang/String;)Lcom/mixpanel/android/mpmetrics/MixpanelAPI;

    move-result-object v2

    .line 47
    const-string v1, "MixpanelAPI.getInstance(context, %s);"

    const/4 v3, 0x1

    new-array v3, v3, [Ljava/lang/Object;

    const/4 v15, 0x0

    aput-object v9, v3, v15

    invoke-virtual {v10, v1, v3}, Lcom/segment/analytics/integrations/Logger;->verbose(Ljava/lang/String;[Ljava/lang/Object;)V

    .line 50
    if-eqz v4, :cond_0

    .line 51
    invoke-virtual {v2}, Lcom/mixpanel/android/mpmetrics/MixpanelAPI;->c()Lcom/mixpanel/android/mpmetrics/MixpanelAPI$People;

    move-result-object v3

    .line 56
    :goto_0
    new-instance v1, Lcom/segment/analytics/android/integrations/mixpanel/MixpanelIntegration;

    invoke-direct/range {v1 .. v14}, Lcom/segment/analytics/android/integrations/mixpanel/MixpanelIntegration;-><init>(Lcom/mixpanel/android/mpmetrics/MixpanelAPI;Lcom/mixpanel/android/mpmetrics/MixpanelAPI$People;ZZZZZLjava/lang/String;Lcom/segment/analytics/integrations/Logger;Ljava/util/Set;ZLjava/util/Set;Ljava/util/Set;)V

    return-object v1

    .line 53
    :cond_0
    const/4 v3, 0x0

    goto :goto_0
.end method

.method public key()Ljava/lang/String;
    .locals 1

    .prologue
    .line 74
    const-string v0, "Mixpanel"

    return-object v0
.end method
