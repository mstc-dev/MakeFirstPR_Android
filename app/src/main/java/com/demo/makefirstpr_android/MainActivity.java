package com.demo.makefirstpr_android;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import com.demo.makefirstpr_android.adapter.ContribAdapter;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements ContribAdapter.onItemListener {

    private ArrayList<String> mContrib;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initRecyclerView();
    }

    private void initRecyclerView() {

        RecyclerView mRecycler = findViewById(R.id.recycler);
        Contributors contrib = new Contributors();
        mContrib = contrib.getContributorList();

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        mRecycler.setLayoutManager(layoutManager);
        ContribAdapter mAdapter = new ContribAdapter(this, mContrib, this);
        mRecycler.setAdapter(mAdapter);
    }

    @Override
    public void onItemClickListener(int pos) {
        String url = "https://github.com/" + mContrib.get(pos);
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse(url));
        startActivity(intent);
    }
}