.class public Lcom/salesforce/android/service/common/liveagentclient/response/message/SwitchServerMessage;
.super Ljava/lang/Object;
.source "SwitchServerMessage.java"


# instance fields
.field private mNewServerUrl:Ljava/lang/String;
    .annotation runtime Lcom/google/gson/annotations/SerializedName;
        a = "newUrl"
    .end annotation
.end field


# virtual methods
.method public a()Ljava/lang/String;
    .locals 1

    .prologue
    .line 50
    iget-object v0, p0, Lcom/salesforce/android/service/common/liveagentclient/response/message/SwitchServerMessage;->mNewServerUrl:Ljava/lang/String;

    return-object v0
.end method

.method public b()Ljava/lang/String;
    .locals 3

    .prologue
    const/4 v0, 0x0

    .line 54
    iget-object v1, p0, Lcom/salesforce/android/service/common/liveagentclient/response/message/SwitchServerMessage;->mNewServerUrl:Ljava/lang/String;

    if-nez v1, :cond_1

    .line 62
    :cond_0
    :goto_0
    return-object v0

    .line 58
    :cond_1
    const-string v1, "https://(.*)/chat"

    invoke-static {v1}, Ljava/util/regex/Pattern;->compile(Ljava/lang/String;)Ljava/util/regex/Pattern;

    move-result-object v1

    iget-object v2, p0, Lcom/salesforce/android/service/common/liveagentclient/response/message/SwitchServerMessage;->mNewServerUrl:Ljava/lang/String;

    invoke-virtual {v1, v2}, Ljava/util/regex/Pattern;->matcher(Ljava/lang/CharSequence;)Ljava/util/regex/Matcher;

    move-result-object v1

    .line 59
    invoke-virtual {v1}, Ljava/util/regex/Matcher;->find()Z

    move-result v2

    if-eqz v2, :cond_0

    .line 60
    const/4 v0, 0x1

    invoke-virtual {v1, v0}, Ljava/util/regex/Matcher;->group(I)Ljava/lang/String;

    move-result-object v0

    goto :goto_0
.end method
