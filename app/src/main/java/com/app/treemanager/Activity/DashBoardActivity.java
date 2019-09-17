package com.app.treemanager.Activity;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.app.treemanager.R;

import butterknife.ButterKnife;
import butterknife.Unbinder;

public class DashBoardActivity extends AppCompatActivity {

    /************************************************************************************
     * Class      : DashBoardActivity
     * Created on : 09/03/2019
     * Updated on : 09/03/2019
     **************************************************************************************/
    private Unbinder viewUnBinder;
    private Intent intent;
    private Context context;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dash_board);

        viewUnBinder = ButterKnife.bind(this);
        context = DashBoardActivity.this;
    }
}
