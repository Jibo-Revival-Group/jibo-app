package okhttp3.internal.http2;

public enum ErrorCode {
   CANCEL(8),
   FLOW_CONTROL_ERROR(3),
   INTERNAL_ERROR(2),
   NO_ERROR(0),
   PROTOCOL_ERROR(1),
   REFUSED_STREAM(7);

   private static final ErrorCode[] $VALUES = new ErrorCode[]{
      ErrorCode.NO_ERROR, ErrorCode.PROTOCOL_ERROR, ErrorCode.INTERNAL_ERROR, ErrorCode.FLOW_CONTROL_ERROR, ErrorCode.REFUSED_STREAM, ErrorCode.CANCEL
   };
   public final int httpCode;

   ErrorCode(int var3) {
      this.httpCode = var3;
   }

   public static ErrorCode fromHttp2(int var0) {
      ErrorCode[] var4 = values();
      int var2 = var4.length;
      int var1 = 0;

      ErrorCode var3;
      while (true) {
         if (var1 >= var2) {
            var3 = null;
            break;
         }

         var3 = var4[var1];
         if (var3.httpCode == var0) {
            break;
         }

         var1++;
      }

      return var3;
   }
}
