package com.jibo.aws.integration.aws.services.account.model.a;

import com.amazonaws.Request;
import com.jibo.aws.integration.aws.services.account.model.UpdatePhotoRequest;
import com.jibo.aws.integration.aws.services.binary.model.CreateBinaryRequest;
import com.jibo.aws.integration.aws.services.common.model.JiboRequestAbstract;
import java.util.HashMap;

public class e extends com.jibo.aws.integration.aws.services.binary.model.a.c {
   @Override
   protected void a(Request<JiboRequestAbstract> var1, CreateBinaryRequest var2) {
      UpdatePhotoRequest var3 = (UpdatePhotoRequest)var2;
      if (var3.getMeta() == null) {
         var3.setMeta(new HashMap<>());
      }

      if (!var3.getMeta().containsKey("size")) {
         var3.getMeta().put("size", Long.toString(var3.getBody().length()));
      }
   }
}
