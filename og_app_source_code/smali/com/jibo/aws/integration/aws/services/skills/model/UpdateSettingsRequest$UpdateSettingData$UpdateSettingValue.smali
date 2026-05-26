.class public Lcom/jibo/aws/integration/aws/services/skills/model/UpdateSettingsRequest$UpdateSettingData$UpdateSettingValue;
.super Ljava/lang/Object;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/jibo/aws/integration/aws/services/skills/model/UpdateSettingsRequest$UpdateSettingData;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "UpdateSettingValue"
.end annotation


# instance fields
.field public dataService:Ljava/lang/String;

.field public skillId:Ljava/lang/String;

.field public value:Lcom/google/gson/JsonElement;


# direct methods
.method public constructor <init>(Ljava/lang/String;Ljava/lang/String;Lcom/google/gson/JsonElement;)V
    .locals 0

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    iput-object p1, p0, Lcom/jibo/aws/integration/aws/services/skills/model/UpdateSettingsRequest$UpdateSettingData$UpdateSettingValue;->skillId:Ljava/lang/String;

    iput-object p2, p0, Lcom/jibo/aws/integration/aws/services/skills/model/UpdateSettingsRequest$UpdateSettingData$UpdateSettingValue;->dataService:Ljava/lang/String;

    iput-object p3, p0, Lcom/jibo/aws/integration/aws/services/skills/model/UpdateSettingsRequest$UpdateSettingData$UpdateSettingValue;->value:Lcom/google/gson/JsonElement;

    return-void
.end method
