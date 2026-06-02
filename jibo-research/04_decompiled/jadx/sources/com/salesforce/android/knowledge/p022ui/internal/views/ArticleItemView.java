package com.salesforce.android.knowledge.p022ui.internal.views;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.salesforce.android.knowledge.core.model.ArticleSummary;
import com.salesforce.android.knowledge.p022ui.R;
import com.salesforce.android.knowledge.p022ui.internal.util.AnimatedOnClickListener;

/* JADX INFO: loaded from: classes.dex */
public class ArticleItemView extends RelativeLayout {
    public ArticleItemView(Context context) {
        super(context);
    }

    public ArticleItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    /* JADX INFO: renamed from: a */
    public void m13711a(final ArticleSummary articleSummary, Drawable drawable) {
        final TextView textView = (TextView) ViewUtil.m13714a(this, R.id.knowledge_article_item_title);
        final TextView textView2 = (TextView) ViewUtil.m13714a(this, R.id.knowledge_article_item_summary);
        ImageView imageView = (ImageView) ViewUtil.m13714a(this, R.id.knowledge_article_item_thumbnail);
        if (textView != null) {
            textView.setText(articleSummary.mo13219i());
            textView.addOnLayoutChangeListener(new View.OnLayoutChangeListener() { // from class: com.salesforce.android.knowledge.ui.internal.views.ArticleItemView.1
                @Override // android.view.View.OnLayoutChangeListener
                public void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
                    if (textView2 != null) {
                        textView2.setMaxLines(Math.max(1, 3 - textView.getLineCount()));
                        textView2.setText(articleSummary.mo13220j());
                    }
                    textView.removeOnLayoutChangeListener(this);
                }
            });
        }
        if (textView2 != null) {
            textView2.setText(articleSummary.mo13220j());
        }
        if (imageView != null) {
            imageView.setVisibility(drawable == null ? 8 : 0);
            imageView.setImageDrawable(drawable);
        }
    }

    @Override // android.view.View
    public void setOnClickListener(View.OnClickListener onClickListener) {
        super.setOnClickListener(AnimatedOnClickListener.m13687a(getContext(), onClickListener));
    }
}
