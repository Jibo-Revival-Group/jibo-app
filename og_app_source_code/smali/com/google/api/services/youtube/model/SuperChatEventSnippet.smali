.class public final Lcom/google/api/services/youtube/model/SuperChatEventSnippet;
.super Lcom/google/api/client/json/GenericJson;
.source "SuperChatEventSnippet.java"


# instance fields
.field private amountMicros:Ljava/math/BigInteger;
    .annotation runtime Lcom/google/api/client/json/JsonString;
    .end annotation

    .annotation runtime Lcom/google/api/client/util/Key;
    .end annotation
.end field

.field private channelId:Ljava/lang/String;
    .annotation runtime Lcom/google/api/client/util/Key;
    .end annotation
.end field

.field private commentText:Ljava/lang/String;
    .annotation runtime Lcom/google/api/client/util/Key;
    .end annotation
.end field

.field private createdAt:Lcom/google/api/client/util/DateTime;
    .annotation runtime Lcom/google/api/client/util/Key;
    .end annotation
.end field

.field private currency:Ljava/lang/String;
    .annotation runtime Lcom/google/api/client/util/Key;
    .end annotation
.end field

.field private displayString:Ljava/lang/String;
    .annotation runtime Lcom/google/api/client/util/Key;
    .end annotation
.end field

.field private messageType:Ljava/lang/Long;
    .annotation runtime Lcom/google/api/client/util/Key;
    .end annotation
.end field

.field private supporterDetails:Lcom/google/api/services/youtube/model/ChannelProfileDetails;
    .annotation runtime Lcom/google/api/client/util/Key;
    .end annotation
.end field


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 34
    invoke-direct {p0}, Lcom/google/api/client/json/GenericJson;-><init>()V

    return-void
.end method


# virtual methods
.method public bridge synthetic clone()Lcom/google/api/client/json/GenericJson;
    .locals 1

    .prologue
    .line 33
    invoke-virtual {p0}, Lcom/google/api/services/youtube/model/SuperChatEventSnippet;->clone()Lcom/google/api/services/youtube/model/SuperChatEventSnippet;

    move-result-object v0

    return-object v0
.end method

.method public bridge synthetic clone()Lcom/google/api/client/util/GenericData;
    .locals 1

    .prologue
    .line 33
    invoke-virtual {p0}, Lcom/google/api/services/youtube/model/SuperChatEventSnippet;->clone()Lcom/google/api/services/youtube/model/SuperChatEventSnippet;

    move-result-object v0

    return-object v0
.end method

.method public clone()Lcom/google/api/services/youtube/model/SuperChatEventSnippet;
    .locals 1

    .prologue
    .line 244
    invoke-super {p0}, Lcom/google/api/client/json/GenericJson;->clone()Lcom/google/api/client/json/GenericJson;

    move-result-object v0

    check-cast v0, Lcom/google/api/services/youtube/model/SuperChatEventSnippet;

    return-object v0
.end method

.method public bridge synthetic clone()Ljava/lang/Object;
    .locals 1
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/CloneNotSupportedException;
        }
    .end annotation

    .prologue
    .line 33
    invoke-virtual {p0}, Lcom/google/api/services/youtube/model/SuperChatEventSnippet;->clone()Lcom/google/api/services/youtube/model/SuperChatEventSnippet;

    move-result-object v0

    return-object v0
.end method

.method public getAmountMicros()Ljava/math/BigInteger;
    .locals 1

    .prologue
    .line 100
    iget-object v0, p0, Lcom/google/api/services/youtube/model/SuperChatEventSnippet;->amountMicros:Ljava/math/BigInteger;

    return-object v0
.end method

.method public getChannelId()Ljava/lang/String;
    .locals 1

    .prologue
    .line 117
    iget-object v0, p0, Lcom/google/api/services/youtube/model/SuperChatEventSnippet;->channelId:Ljava/lang/String;

    return-object v0
.end method

.method public getCommentText()Ljava/lang/String;
    .locals 1

    .prologue
    .line 134
    iget-object v0, p0, Lcom/google/api/services/youtube/model/SuperChatEventSnippet;->commentText:Ljava/lang/String;

    return-object v0
.end method

.method public getCreatedAt()Lcom/google/api/client/util/DateTime;
    .locals 1

    .prologue
    .line 152
    iget-object v0, p0, Lcom/google/api/services/youtube/model/SuperChatEventSnippet;->createdAt:Lcom/google/api/client/util/DateTime;

    return-object v0
.end method

.method public getCurrency()Ljava/lang/String;
    .locals 1

    .prologue
    .line 170
    iget-object v0, p0, Lcom/google/api/services/youtube/model/SuperChatEventSnippet;->currency:Ljava/lang/String;

    return-object v0
.end method

.method public getDisplayString()Ljava/lang/String;
    .locals 1

    .prologue
    .line 188
    iget-object v0, p0, Lcom/google/api/services/youtube/model/SuperChatEventSnippet;->displayString:Ljava/lang/String;

    return-object v0
.end method

.method public getMessageType()Ljava/lang/Long;
    .locals 1

    .prologue
    .line 207
    iget-object v0, p0, Lcom/google/api/services/youtube/model/SuperChatEventSnippet;->messageType:Ljava/lang/Long;

    return-object v0
.end method

.method public getSupporterDetails()Lcom/google/api/services/youtube/model/ChannelProfileDetails;
    .locals 1

    .prologue
    .line 225
    iget-object v0, p0, Lcom/google/api/services/youtube/model/SuperChatEventSnippet;->supporterDetails:Lcom/google/api/services/youtube/model/ChannelProfileDetails;

    return-object v0
.end method

.method public bridge synthetic set(Ljava/lang/String;Ljava/lang/Object;)Lcom/google/api/client/json/GenericJson;
    .locals 1

    .prologue
    .line 33
    invoke-virtual {p0, p1, p2}, Lcom/google/api/services/youtube/model/SuperChatEventSnippet;->set(Ljava/lang/String;Ljava/lang/Object;)Lcom/google/api/services/youtube/model/SuperChatEventSnippet;

    move-result-object v0

    return-object v0
.end method

.method public bridge synthetic set(Ljava/lang/String;Ljava/lang/Object;)Lcom/google/api/client/util/GenericData;
    .locals 1

    .prologue
    .line 33
    invoke-virtual {p0, p1, p2}, Lcom/google/api/services/youtube/model/SuperChatEventSnippet;->set(Ljava/lang/String;Ljava/lang/Object;)Lcom/google/api/services/youtube/model/SuperChatEventSnippet;

    move-result-object v0

    return-object v0
.end method

.method public set(Ljava/lang/String;Ljava/lang/Object;)Lcom/google/api/services/youtube/model/SuperChatEventSnippet;
    .locals 1

    .prologue
    .line 239
    invoke-super {p0, p1, p2}, Lcom/google/api/client/json/GenericJson;->set(Ljava/lang/String;Ljava/lang/Object;)Lcom/google/api/client/json/GenericJson;

    move-result-object v0

    check-cast v0, Lcom/google/api/services/youtube/model/SuperChatEventSnippet;

    return-object v0
.end method

.method public setAmountMicros(Ljava/math/BigInteger;)Lcom/google/api/services/youtube/model/SuperChatEventSnippet;
    .locals 0

    .prologue
    .line 108
    iput-object p1, p0, Lcom/google/api/services/youtube/model/SuperChatEventSnippet;->amountMicros:Ljava/math/BigInteger;

    .line 109
    return-object p0
.end method

.method public setChannelId(Ljava/lang/String;)Lcom/google/api/services/youtube/model/SuperChatEventSnippet;
    .locals 0

    .prologue
    .line 125
    iput-object p1, p0, Lcom/google/api/services/youtube/model/SuperChatEventSnippet;->channelId:Ljava/lang/String;

    .line 126
    return-object p0
.end method

.method public setCommentText(Ljava/lang/String;)Lcom/google/api/services/youtube/model/SuperChatEventSnippet;
    .locals 0

    .prologue
    .line 142
    iput-object p1, p0, Lcom/google/api/services/youtube/model/SuperChatEventSnippet;->commentText:Ljava/lang/String;

    .line 143
    return-object p0
.end method

.method public setCreatedAt(Lcom/google/api/client/util/DateTime;)Lcom/google/api/services/youtube/model/SuperChatEventSnippet;
    .locals 0

    .prologue
    .line 161
    iput-object p1, p0, Lcom/google/api/services/youtube/model/SuperChatEventSnippet;->createdAt:Lcom/google/api/client/util/DateTime;

    .line 162
    return-object p0
.end method

.method public setCurrency(Ljava/lang/String;)Lcom/google/api/services/youtube/model/SuperChatEventSnippet;
    .locals 0

    .prologue
    .line 178
    iput-object p1, p0, Lcom/google/api/services/youtube/model/SuperChatEventSnippet;->currency:Ljava/lang/String;

    .line 179
    return-object p0
.end method

.method public setDisplayString(Ljava/lang/String;)Lcom/google/api/services/youtube/model/SuperChatEventSnippet;
    .locals 0

    .prologue
    .line 197
    iput-object p1, p0, Lcom/google/api/services/youtube/model/SuperChatEventSnippet;->displayString:Ljava/lang/String;

    .line 198
    return-object p0
.end method

.method public setMessageType(Ljava/lang/Long;)Lcom/google/api/services/youtube/model/SuperChatEventSnippet;
    .locals 0

    .prologue
    .line 216
    iput-object p1, p0, Lcom/google/api/services/youtube/model/SuperChatEventSnippet;->messageType:Ljava/lang/Long;

    .line 217
    return-object p0
.end method

.method public setSupporterDetails(Lcom/google/api/services/youtube/model/ChannelProfileDetails;)Lcom/google/api/services/youtube/model/SuperChatEventSnippet;
    .locals 0

    .prologue
    .line 233
    iput-object p1, p0, Lcom/google/api/services/youtube/model/SuperChatEventSnippet;->supporterDetails:Lcom/google/api/services/youtube/model/ChannelProfileDetails;

    .line 234
    return-object p0
.end method
