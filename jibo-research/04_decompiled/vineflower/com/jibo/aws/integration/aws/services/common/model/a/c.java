package com.jibo.aws.integration.aws.services.common.model.a;

import android.text.TextUtils;
import com.jibo.aws.integration.aws.services.common.model.IdRequestAbstract;
import com.jibo.aws.integration.aws.services.common.model.JiboRequestAbstract;

public class c extends e {
   @Override
   protected String b(JiboRequestAbstract var1) {
      String var2;
      if (!TextUtils.isEmpty(((IdRequestAbstract)var1).getId())) {
         var2 = super.b(var1);
      } else {
         var2 = "{}";
      }

      return var2;
   }
}
