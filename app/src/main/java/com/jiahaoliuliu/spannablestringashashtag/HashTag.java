package com.jiahaoliuliu.spannablestringashashtag;

import android.content.Context;
import android.text.Spanned;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by jiahaoliuliu on 15/8/31.
 */
public class HashTag extends ClickableSpan {

    private Context mContext;

    private TextPaint mTextPain;

    public HashTag(Context context) {
        super();
        this.mContext = context;
    }

    @Override
    public void updateDrawState(TextPaint ds) {
        mTextPain = ds;
        ds.setColor(ds.linkColor);
        ds.setARGB(255, 30, 144, 255);
    }

    @Override
    public void onClick(View widget) {
        TextView tv = (TextView) widget;
        Spanned s = (Spanned) tv.getText();
        int start = s.getSpanStart(this);
        int end = s.getSpanEnd(this);
        String theWord = s.subSequence(start + 1, end).toString();
        Toast.makeText(mContext, String.format("Tags for tags: %s", theWord), Toast.LENGTH_LONG).show();
    }

}
