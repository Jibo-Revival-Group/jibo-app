.class Lcom/jibo/utils/CustomHolidaysUtils$CustomHolidays;
.super Ljava/lang/Object;
.source "CustomHolidaysUtils.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/jibo/utils/CustomHolidaysUtils;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x8
    name = "CustomHolidays"
.end annotation


# instance fields
.field sHolidays:Ljava/util/List;
    .annotation runtime Lcom/google/gson/annotations/SerializedName;
        a = "holidays"
    .end annotation

    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/jibo/aws/integration/aws/services/person/model/Holiday;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method constructor <init>()V
    .locals 0

    .prologue
    .line 112
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method
