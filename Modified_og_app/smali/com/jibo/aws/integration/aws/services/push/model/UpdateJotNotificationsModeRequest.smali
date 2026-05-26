.class public Lcom/jibo/aws/integration/aws/services/push/model/UpdateJotNotificationsModeRequest;
.super Lcom/jibo/aws/integration/aws/services/push/model/JiboPushRequest;


# instance fields
.field protected jotPushMode:Lcom/jibo/aws/integration/aws/services/push/model/JotPushNotificationsMode;
    .annotation runtime Lcom/google/gson/annotations/Expose;
    .end annotation
.end field


# direct methods
.method public constructor <init>(Lcom/jibo/aws/integration/aws/services/push/model/JotPushNotificationsMode;)V
    .locals 0

    invoke-direct {p0}, Lcom/jibo/aws/integration/aws/services/push/model/JiboPushRequest;-><init>()V

    iput-object p1, p0, Lcom/jibo/aws/integration/aws/services/push/model/UpdateJotNotificationsModeRequest;->jotPushMode:Lcom/jibo/aws/integration/aws/services/push/model/JotPushNotificationsMode;

    return-void
.end method


# virtual methods
.method public equals(Ljava/lang/Object;)Z
    .locals 4

    const/4 v1, 0x1

    const/4 v2, 0x0

    if-ne p0, p1, :cond_1

    move v2, v1

    :cond_0
    :goto_0
    return v2

    :cond_1
    if-eqz p1, :cond_0

    invoke-super {p0, p1}, Ljava/lang/Object;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_0

    instance-of v0, p1, Lcom/jibo/aws/integration/aws/services/push/model/UpdateJotNotificationsModeRequest;

    if-eqz v0, :cond_0

    check-cast p1, Lcom/jibo/aws/integration/aws/services/push/model/UpdateJotNotificationsModeRequest;

    invoke-virtual {p1}, Lcom/jibo/aws/integration/aws/services/push/model/UpdateJotNotificationsModeRequest;->getJotPushMode()Lcom/jibo/aws/integration/aws/services/push/model/JotPushNotificationsMode;

    move-result-object v0

    if-nez v0, :cond_3

    move v0, v1

    :goto_1
    invoke-virtual {p0}, Lcom/jibo/aws/integration/aws/services/push/model/UpdateJotNotificationsModeRequest;->getJotPushMode()Lcom/jibo/aws/integration/aws/services/push/model/JotPushNotificationsMode;

    move-result-object v3

    if-nez v3, :cond_4

    move v3, v1

    :goto_2
    xor-int/2addr v0, v3

    if-nez v0, :cond_0

    invoke-virtual {p1}, Lcom/jibo/aws/integration/aws/services/push/model/UpdateJotNotificationsModeRequest;->getJotPushMode()Lcom/jibo/aws/integration/aws/services/push/model/JotPushNotificationsMode;

    move-result-object v0

    if-eqz v0, :cond_2

    invoke-virtual {p1}, Lcom/jibo/aws/integration/aws/services/push/model/UpdateJotNotificationsModeRequest;->getJotPushMode()Lcom/jibo/aws/integration/aws/services/push/model/JotPushNotificationsMode;

    move-result-object v0

    invoke-virtual {p0}, Lcom/jibo/aws/integration/aws/services/push/model/UpdateJotNotificationsModeRequest;->getJotPushMode()Lcom/jibo/aws/integration/aws/services/push/model/JotPushNotificationsMode;

    move-result-object v3

    invoke-virtual {v0, v3}, Lcom/jibo/aws/integration/aws/services/push/model/JotPushNotificationsMode;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_0

    :cond_2
    move v2, v1

    goto :goto_0

    :cond_3
    move v0, v2

    goto :goto_1

    :cond_4
    move v3, v2

    goto :goto_2
.end method

.method public getJotPushMode()Lcom/jibo/aws/integration/aws/services/push/model/JotPushNotificationsMode;
    .locals 1

    iget-object v0, p0, Lcom/jibo/aws/integration/aws/services/push/model/UpdateJotNotificationsModeRequest;->jotPushMode:Lcom/jibo/aws/integration/aws/services/push/model/JotPushNotificationsMode;

    return-object v0
.end method

.method public hashCode()I
    .locals 2

    invoke-super {p0}, Ljava/lang/Object;->hashCode()I

    move-result v0

    mul-int/lit8 v1, v0, 0x1f

    invoke-virtual {p0}, Lcom/jibo/aws/integration/aws/services/push/model/UpdateJotNotificationsModeRequest;->getJotPushMode()Lcom/jibo/aws/integration/aws/services/push/model/JotPushNotificationsMode;

    move-result-object v0

    if-nez v0, :cond_0

    const/4 v0, 0x0

    :goto_0
    add-int/2addr v0, v1

    return v0

    :cond_0
    invoke-virtual {p0}, Lcom/jibo/aws/integration/aws/services/push/model/UpdateJotNotificationsModeRequest;->getJotPushMode()Lcom/jibo/aws/integration/aws/services/push/model/JotPushNotificationsMode;

    move-result-object v0

    invoke-virtual {v0}, Lcom/jibo/aws/integration/aws/services/push/model/JotPushNotificationsMode;->hashCode()I

    move-result v0

    goto :goto_0
.end method

.method public setJotPushMode(Lcom/jibo/aws/integration/aws/services/push/model/JotPushNotificationsMode;)V
    .locals 1

    iget-object v0, p0, Lcom/jibo/aws/integration/aws/services/push/model/UpdateJotNotificationsModeRequest;->jotPushMode:Lcom/jibo/aws/integration/aws/services/push/model/JotPushNotificationsMode;

    iput-object v0, p0, Lcom/jibo/aws/integration/aws/services/push/model/UpdateJotNotificationsModeRequest;->jotPushMode:Lcom/jibo/aws/integration/aws/services/push/model/JotPushNotificationsMode;

    return-void
.end method

.method public toString()Ljava/lang/String;
    .locals 2

    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    const-string v1, "UpdateJotNotificationsModeRequest {, jotPushMode=\'"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget-object v1, p0, Lcom/jibo/aws/integration/aws/services/push/model/UpdateJotNotificationsModeRequest;->jotPushMode:Lcom/jibo/aws/integration/aws/services/push/model/JotPushNotificationsMode;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v0

    const/16 v1, 0x27

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    move-result-object v0

    const/16 v1, 0x7d

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method
