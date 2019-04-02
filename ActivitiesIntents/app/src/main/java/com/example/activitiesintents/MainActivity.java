package com.example.activitiesintents;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    public static final String EXTRA_SEND = "com.example.activitiesIntents.extra.send";
    public static final int REQUEST_CODE = 1;
    // Message
    private static final String LOG_TAG = MainActivity.class.getSimpleName();
    // Control
    private TextView mTextViewReply;
    private EditText mEditTextSend;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d(LOG_TAG, "MainActivity:onCreate");

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTextViewReply = findViewById(R.id.textView_reply);
        mEditTextSend = findViewById(R.id.editText_send);
    }

    public void onClickedSend(View view) {
        Log.d(LOG_TAG, "MainActivity:onClickedSend");

        String strMsg = mEditTextSend.getText().toString();
        Intent intent = new Intent(this, SecondActivity.class);
        intent.putExtra(EXTRA_SEND, strMsg);
        startActivityForResult(intent, REQUEST_CODE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        Log.d(LOG_TAG, "MainActivity:onActivityResult");

        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_CODE) {
            String strMsg = data.getStringExtra(SecondActivity.EXTRA_REPLY);
            mTextViewReply.setText(strMsg);
        }
    }
}
