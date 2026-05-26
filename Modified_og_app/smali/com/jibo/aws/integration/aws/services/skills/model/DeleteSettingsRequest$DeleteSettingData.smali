.class public Lcom/jibo/aws/integration/aws/services/skills/model/DeleteSettingsRequest$DeleteSettingData;
.super Ljava/lang/Object;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/jibo/aws/integration/aws/services/skills/model/DeleteSettingsRequest;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "DeleteSettingData"
.end annotation

.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/jibo/aws/integration/aws/services/skills/model/DeleteSettingsRequest$DeleteSettingData$DeleteSettingValue;
    }
.end annotation


# instance fields
.field public key:Ljava/lang/String;

.field public value:Lcom/jibo/aws/integration/aws/services/skills/model/DeleteSettingsRequest$DeleteSettingData$DeleteSettingValue;


# direct methods
.method public constructor <init>(Ljava/lang/String;Lcom/jibo/aws/integration/aws/services/skills/model/DeleteSettingsRequest$DeleteSettingData$DeleteSettingValue;)V
    .locals 0

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    iput-object p1, p0, Lcom/jibo/aws/integration/aws/services/skills/model/DeleteSettingsRequest$DeleteSettingData;->key:Ljava/lang/String;

    iput-object p2, p0, Lcom/jibo/aws/integration/aws/services/skills/model/DeleteSettingsRequest$DeleteSettingData;->value:Lcom/jibo/aws/integration/aws/services/skills/model/DeleteSettingsRequest$DeleteSettingData$DeleteSettingValue;

    return-void
.end method

.method public constructor <init>(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    .locals 1

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    iput-object p1, p0, Lcom/jibo/aws/integration/aws/services/skills/model/DeleteSettingsRequest$DeleteSettingData;->key:Ljava/lang/String;

    new-instance v0, Lcom/jibo/aws/integration/aws/services/skills/model/DeleteSettingsRequest$DeleteSettingData$DeleteSettingValue;

    invoke-direct {v0, p2, p3}, Lcom/jibo/aws/integration/aws/services/skills/model/DeleteSettingsRequest$DeleteSettingData$DeleteSettingValue;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    iput-object v0, p0, Lcom/jibo/aws/integration/aws/services/skills/model/DeleteSettingsRequest$DeleteSettingData;->value:Lcom/jibo/aws/integration/aws/services/skills/model/DeleteSettingsRequest$DeleteSettingData$DeleteSettingValue;

    return-void
.end method
