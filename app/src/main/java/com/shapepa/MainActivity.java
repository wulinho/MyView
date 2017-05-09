package com.shapepa;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    private CustomViews mCustomView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mCustomView = (CustomViews) findViewById(R.id.cv);
        new Thread(mCustomView).start();
    }
}
