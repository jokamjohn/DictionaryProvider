package com.example.android.dictionaryprovider;

import android.content.ContentResolver;
import android.database.Cursor;
import android.provider.UserDictionary;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;


public class MainActivity extends ActionBarActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Text view to populate the words
        TextView dicttext = (TextView)findViewById(R.id.dictionary_text_view);

        //Get the ContentResolver which will send a message to the ContentProvider
        ContentResolver resolver =getContentResolver();
        //Get a Cursor containing all of the rows in the Words table
        Cursor cursor =resolver.query(UserDictionary.Words.CONTENT_URI,null,null,null,null);

        try {

            dicttext.setText("Your user dictionary contains " );
            int wordColumn = cursor.getColumnIndex(UserDictionary.Words.WORD);

            while (cursor.moveToFirst()){
                // Use that index to extract the String value of the word
                // at the current row the cursor is on.
                String word =cursor.getString(wordColumn);
                dicttext.append(("\n" + word));
            }
        }
        finally {
            // Always close your cursor to avoid memory leaks
            cursor.close();
        }




    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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
}
