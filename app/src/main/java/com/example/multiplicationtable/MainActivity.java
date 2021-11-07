package com.example.multiplicationtable;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private EditText editText;
    private Button button;
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = findViewById(R.id.button);
        editText = findViewById(R.id.editText);
        listView = findViewById(R.id.listView);
//
    }
    public void onClick(View view) {
        editText.onEditorAction(EditorInfo.IME_ACTION_DONE);
    }
    public void Table(View view) {
        String s = editText.getText().toString();
        int table = Integer.parseInt(s);
        ArrayList<String> MultipleTable = new ArrayList<>();
        for (int i = 1; i <= 10; i++) {
            MultipleTable.add(table + " X " + i + " = " + table * i);
        }
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_list_item_1, MultipleTable) {
            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                /// Get the Item from ListView
                View view = super.getView(position, convertView, parent);

                TextView tv = (TextView) view.findViewById(android.R.id.text1);

                // Set the text size 25 dip for ListView each item
                tv.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 25);
                tv.setTextColor(Color.BLUE);

                // Return the view
                return view;
            }
        };
        listView.setAdapter(arrayAdapter);
    }

}