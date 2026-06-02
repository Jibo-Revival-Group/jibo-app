package com.jibo.aws.integration.aws.services.loop.model.a;

import com.amazonaws.Request;
import com.jibo.aws.integration.aws.services.binary.model.CreateBinaryRequest;
import com.jibo.aws.integration.aws.services.common.model.JiboRequestAbstract;
import com.jibo.aws.integration.aws.services.loop.model.UpdateMemberPhotoRequest;
import java.util.HashMap;

public class g extends com.jibo.aws.integration.aws.services.binary.model.a.c {
   @Override
   protected void a(Request<JiboRequestAbstract> var1, CreateBinaryRequest var2) {
      UpdateMemberPhotoRequest var3 = (UpdateMemberPhotoRequest)var2;
      var1.addHeader("x-loop-id", ((UpdateMemberPhotoRequest)var2).getLoopId());
      var1.addHeader("x-id", ((UpdateMemberPhotoRequest)var2).getId());
      if (var3.getMeta() == null) {
         var3.setMeta(new HashMap<>());
      }

      if (!var3.getMeta().containsKey("size")) {
         var3.getMeta().put("size", Long.toString(var3.getBody().length()));
      }
   }
}
