package com.example.ripples;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

/**
 * 点击涟漪效果的示例
 */
public class MyActivity extends Activity {
    ListView listView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        initView();
        initData();
        initEvent();
    }


    private void initView() {
        listView = (ListView) findViewById(R.id.listView);

    }

    private void initData() {
        List<String> list = new ArrayList<String>();
        for (int i = 0; i < 8; i++) {
            list.add("line  " + (i + 1));
        }

        ArrayAdapter adapter = new ArrayAdapter(this, R.layout.item, R.id.text, list);
        listView.setAdapter(adapter);

    }

    private void initEvent() {
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MyActivity.this, "你点击了" + position, Toast.LENGTH_SHORT).show();
            }
        });

    }

    public void clickText(View view) {
        Toast.makeText(MyActivity.this, "你点击文字干嘛！！！~~", Toast.LENGTH_SHORT).show();
    }


}
