package com.mattmahowald.todolistapp;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RelativeLayout;

import java.util.ArrayList;


public class ListActivity extends Activity {

    private ArrayList<String> mItems;
    private ArrayAdapter<String> mAdapter;
    private ListView mListView;
    private Button mButton;
    private EditText mEditText;
    private RelativeLayout mRelativeLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        mListView = (ListView) findViewById(R.id.list_items);
        mButton = (Button)findViewById(R.id.button);
        mEditText = (EditText)findViewById(R.id.editText);
        mRelativeLayout = (RelativeLayout)findViewById(R.id.relativeLayout);



        mItems = new ArrayList<String>();
        mAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, mItems);
        mListView.setAdapter(mAdapter);

        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String item = mEditText.getText().toString();
                mAdapter.add(item);
                mEditText.setText("");
            }
        });

        deleteItemListener();

    }

    private void deleteItemListener() {
        mListView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                mItems.remove(position);
                mAdapter.notifyDataSetChanged();
                return true;
            }
        });
    }

}
