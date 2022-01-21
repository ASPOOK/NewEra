package com.aspook.jsengine;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.aspook.newera.R;
import com.eclipsesource.v8.V8;

public class V8TestActivity extends AppCompatActivity {
    Button btn1, btn2, btn3, btn4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_v8_test);

        findViews();
        setListeners();
    }

    public void findViews() {
        btn1 = findViewById(R.id.btn_1_v8);
        btn2 = findViewById(R.id.btn_2_v8);
        btn3 = findViewById(R.id.btn_3_v8);
        btn4 = findViewById(R.id.btn_4_v8);
    }

    public void setListeners() {
        btn1.setOnClickListener(v -> {
            v8Test();
        });

        btn2.setOnClickListener(v -> {

        });

        btn3.setOnClickListener(v -> {

        });

        btn4.setOnClickListener(v -> {

        });
    }

    /**
     * V8 Test
     */
    public void v8TestWithClose() {
        V8 v8 = V8.createV8Runtime();
        int result = v8.executeIntegerScript("var a = 1+2;\n a;");
        Log.e("v8", String.valueOf(result));
        v8.close();
    }

    /**
     * V8 Test
     */
    public void v8Test() {
        Log.d("v8", "start=" + System.currentTimeMillis());
        V8 v8 = V8.createV8Runtime();
        Log.d("v8", "createV8Runtime=" + System.currentTimeMillis());
        int result = v8.executeIntegerScript("var a = 1+2;\n a;");
        Log.d("v8", "execute end=" + System.currentTimeMillis());

        v8.close();
        Log.d("v8", "close end=" + System.currentTimeMillis());
        Log.e("v8", String.valueOf(result));
    }


}