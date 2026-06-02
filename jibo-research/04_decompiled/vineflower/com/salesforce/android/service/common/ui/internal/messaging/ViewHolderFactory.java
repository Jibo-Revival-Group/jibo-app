package com.salesforce.android.service.common.ui.internal.messaging;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

public interface ViewHolderFactory {
   int a(Object var1);

   RecyclerView.ViewHolder a(ViewGroup var1, int var2, LayoutInflater var3);

   void a(RecyclerView.ViewHolder var1, int var2, Object var3);
}
