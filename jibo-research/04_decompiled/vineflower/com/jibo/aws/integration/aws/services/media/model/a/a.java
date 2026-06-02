package com.jibo.aws.integration.aws.services.media.model.a;

import android.text.TextUtils;
import com.amazonaws.Request;
import com.jibo.aws.integration.aws.services.binary.model.CreateBinaryRequest;
import com.jibo.aws.integration.aws.services.common.model.JiboRequestAbstract;
import com.jibo.aws.integration.aws.services.media.model.CreateRequest;

public class a extends com.jibo.aws.integration.aws.services.binary.model.a.c {
   @Override
   protected void a(Request<JiboRequestAbstract> var1, CreateBinaryRequest var2) {
      if (!TextUtils.isEmpty(var2.getPath())) {
         var1.addHeader("x-path", var2.getPath());
      }

      var1.addHeader("x-loop-id", ((CreateRequest)var2).getLoopId());
      var1.addHeader("x-type", ((CreateRequest)var2).getType());
      boolean var3;
      if (((CreateRequest)var2).isEncrypted() != null) {
         var3 = ((CreateRequest)var2).isEncrypted();
      } else {
         var3 = false;
      }

      var1.addHeader("x-encrypted", var3 + "");
      if (!TextUtils.isEmpty(((CreateRequest)var2).getReference())) {
         var1.addHeader("x-reference", ((CreateRequest)var2).getReference());
      }
   }
}
