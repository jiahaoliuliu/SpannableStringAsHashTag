package com.jiahaoliuliu.spannablestringashashtag;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.method.LinkMovementMethod;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    private TextView mHashTagsTextView;

    private Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mContext = this;

        mHashTagsTextView = (TextView) findViewById(R.id.hash_tags_text_view);

        String loremIpsumText = getString(R.string.hash_tags_text_complete);

        // Add hash tag to the words
        if (!loremIpsumText.startsWith("#")) {
            loremIpsumText = "#" + loremIpsumText;
        }
        loremIpsumText = loremIpsumText.replace(" ", " #");

        SpannableString loremIpsum = new SpannableString(loremIpsumText);
        String[] words = loremIpsum.toString().split(" ");

        int position = 0;
        for (final String word : words) {
            loremIpsum.setSpan(
                    new HashTag(this) {
                        @Override
                        public void onClick(View widget) {
                            String originalWord = word.replaceFirst("#", "");
                            Toast.makeText(mContext, originalWord, Toast.LENGTH_SHORT).show();
                            Log.v(TAG, "Word " + originalWord + " clicked");
                        }
                    },
                    position,
                    position + word.length(),
                    Spanned.SPAN_EXCLUSIVE_EXCLUSIVE
            );

            // Update position
            position += word.length();
            position++;
        }

        mHashTagsTextView.setText(loremIpsum);
        mHashTagsTextView.setMovementMethod(LinkMovementMethod.getInstance());
        mHashTagsTextView.setHighlightColor(Color.TRANSPARENT);
    }
}
