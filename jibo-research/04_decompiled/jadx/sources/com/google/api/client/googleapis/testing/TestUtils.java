package com.google.api.client.googleapis.testing;

import com.google.common.base.Splitter;
import com.google.common.collect.Lists;
import java.io.IOException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class TestUtils {
    private static final String UTF_8 = "UTF-8";

    public static Map<String, String> parseQuery(String str) throws IOException {
        HashMap map = new HashMap();
        Iterator<String> it = Splitter.m9025a('&').m9031a(str).iterator();
        while (it.hasNext()) {
            ArrayList arrayListM9048a = Lists.m9048a(Splitter.m9025a('=').m9031a(it.next()));
            if (arrayListM9048a.size() != 2) {
                throw new IOException("Invalid Query String");
            }
            map.put(URLDecoder.decode((String) arrayListM9048a.get(0), "UTF-8"), URLDecoder.decode((String) arrayListM9048a.get(1), "UTF-8"));
        }
        return map;
    }

    private TestUtils() {
    }
}
