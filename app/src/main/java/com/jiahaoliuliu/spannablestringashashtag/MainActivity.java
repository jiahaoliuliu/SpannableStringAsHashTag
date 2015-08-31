package com.jiahaoliuliu.spannablestringashashtag;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView mHashTagsTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mHashTagsTextView = (TextView) findViewById(R.id.hash_tags_text_view);

        mHashTagsTextView.setText(getString(R.string.hash_tags_text));
    }
}
