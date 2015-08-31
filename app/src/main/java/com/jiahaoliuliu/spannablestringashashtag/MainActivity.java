package com.jiahaoliuliu.spannablestringashashtag;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.SpannableString;
import android.util.Log;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    private TextView mHashTagsTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mHashTagsTextView = (TextView) findViewById(R.id.hash_tags_text_view);

        SpannableString loremIpsum = new SpannableString(getString(R.string.hash_tags_text_complete));
        String[] words = loremIpsum.toString().split(" ");

        for (int i = 0; i < words.length; i++) {
            Log.v(TAG, i + " : " + words[i]);
        }

        int position = 0;
        for (String word : words) {
            loremIpsum.setSpan(
                    new HashTag(this),
                    position,
                    position + word.length(),
                    0
            );

            // Update position
            position += word.length();
            position++;
        }

        mHashTagsTextView.setText(loremIpsum);
    }
}
