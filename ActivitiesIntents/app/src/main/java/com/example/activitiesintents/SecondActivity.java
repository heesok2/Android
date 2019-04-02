package com.example.activitiesintents;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {
    public static final String EXTRA_REPLY = "com.example.activitiesIntents.extra.reply";
    private static final String LOG_TAG = SecondActivity.class.getSimpleName();
    private TextView mTextViewSend;
    private EditText mEditTextReply;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d(LOG_TAG, "SecondActivity:onCreate");

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        mTextViewSend = findViewById(R.id.textView_send);
        mEditTextReply = findViewById(R.id.editText_reply);

        Intent intent = getIntent();
        String strMsg = intent.getStringExtra(MainActivity.EXTRA_SEND);

        mTextViewSend.setText(strMsg);
    }

    public void onClickedReply(View view) {
        Log.d(LOG_TAG, "SecondActivity:onClickedReply");

        String strMsg = mEditTextReply.getText().toString();
        Intent intent = new Intent();
        intent.putExtra(EXTRA_REPLY, strMsg);
        setResult(RESULT_OK, intent);
        finish();
    }
}
