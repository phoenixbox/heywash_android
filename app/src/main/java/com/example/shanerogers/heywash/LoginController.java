package com.example.shanerogers.heywash;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;


public class LoginController extends ActionBarActivity implements View.OnClickListener {
    // UI Elements
    TextView loginTextView ;
    Button loginButton ;
    ListView loginListView ;
    ArrayAdapter loginArrayAdapter;
    ArrayList valuePropList = new ArrayList();
    EditText emailInput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_controller);

        // Programatically set the TextView
        //        UILabel *header = [UITextLabel new];
        //        [header setText:@"Im the header!"];
        //        [self addSubview:header];
        loginTextView = (TextView) findViewById(R.id.login_textview);
        loginTextView.setText("Reset!");

        loginButton = (Button) findViewById(R.id.login_button);
        loginButton.setOnClickListener(this);
        loginButton.setText("Sign In");

        loginListView = (ListView) findViewById(R.id.login_listView);
        loginArrayAdapter = new ArrayAdapter(this,
                android.R.layout.simple_list_item_1,
                valuePropList);

        loginListView.setAdapter(loginArrayAdapter);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_login_controller, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View v) {
        emailInput = (EditText) findViewById(R.id.login_emailInput);
        valuePropList.add(emailInput.getText().toString());
        loginArrayAdapter.notifyDataSetChanged();
    }
}
