package com.jiahaoliuliu.spannablestringashashtag;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.text.Spanned;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by jiahaoliuliu on 15/8/31.
 */
public class HashTag extends ClickableSpan {

    private static final String TAG = "HashTag";
    private Context mContext;

    public HashTag(Context context) {
        super();
        mContext = context;
    }

    @Override
    public void updateDrawState(TextPaint ds) {
//        ds.setColor(ds.linkColor);
        ds.setColor(mContext.getResources().getColor(R.color.primary));
    }

    @Override
    public void onClick(View widget) {
        throw new IllegalStateException("You must override onclick method");
    }
}
