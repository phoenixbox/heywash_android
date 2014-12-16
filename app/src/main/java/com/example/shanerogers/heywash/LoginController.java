package com.example.shanerogers.heywash;

import android.app.Activity;
import android.content.Intent;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.ShareActionProvider;
import android.widget.TextView;

import java.util.ArrayList;


public class LoginController extends Activity implements View.OnClickListener, AdapterView.OnItemClickListener {
    // UI Vars
    TextView loginTextView ;
    Button loginButton ;
    ListView loginListView ;
    ArrayAdapter loginArrayAdapter;
    ArrayList valuePropList = new ArrayList();
    EditText emailInput;
//   m prefix for namespacing the controller? m for main
    ShareActionProvider mShareActionProvider;

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
        loginListView.setOnItemClickListener(this);
        loginArrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, valuePropList);

        loginListView.setAdapter(loginArrayAdapter);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        // Inflate the menu.
        // Adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_login_controller, menu);

        // Access the Share Item defined in menu XML
        MenuItem shareItem = menu.findItem(R.id.menu_item_share);

        // Access the object responsible for
        // putting together the sharing submenu
        if (shareItem != null) {
            mShareActionProvider = (ShareActionProvider) shareItem.getActionProvider();
        }

        // Create an Intent to share your content
        setShareIntent();

        return true;
    }

    private void setShareIntent() {

        // create an Intent with the contents of the TextView
        Intent shareIntent = new Intent(Intent.ACTION_SEND);
        shareIntent.setType("text/plain");
        shareIntent.putExtra(Intent.EXTRA_SUBJECT,"Android Development");
        shareIntent.putExtra(Intent.EXTRA_TEXT, "Extra Text");

        // Make sure the provider knows
        // it should work with that Intent
        mShareActionProvider.setShareIntent(shareIntent);
    }

    @Override
    public void onClick(View v) {
        emailInput = (EditText) findViewById(R.id.login_emailInput);
        valuePropList.add(emailInput.getText().toString());
        loginArrayAdapter.notifyDataSetChanged();

        setShareIntent();
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Log.d("List Item Tapped: ", position + ": " + valuePropList.get(position));
    }
}
