package com.example.android.dictionaryprovider;

import android.content.ContentResolver;
import android.database.Cursor;
import android.os.Bundle;
import android.provider.UserDictionary;
import android.support.v7.app.ActionBarActivity;
import android.widget.ListView;
import android.support.v4.widget.SimpleCursorAdapter;



public class MainActivity extends ActionBarActivity {

    private static final String [] columns = new String[] {UserDictionary.Words.WORD,UserDictionary.Words.FREQUENCY};

    private static final int [] toview = new int[] {android.R.id.text1,android.R.id.text2};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //List view to populate the words
        ListView dictListView = (ListView)findViewById(R.id.dictionary_list_view);

        //Get the ContentResolver which will send a message to the ContentProvider
        ContentResolver resolver =getContentResolver();
        //Get a Cursor containing all of the rows in the Words table
        Cursor cursor =resolver.query(UserDictionary.Words.CONTENT_URI,null,null,null,null);

        // Initiating the simpleCursorAdapter
        SimpleCursorAdapter adapter = new SimpleCursorAdapter(this,android.R.layout.two_line_list_item,
                cursor,columns,toview,0);

        dictListView.setAdapter(adapter);





    }


//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        // Inflate the menu; this adds items to the action bar if it is present.
//        getMenuInflater().inflate(R.menu.menu_main, menu);
//        return true;
//    }
//
//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        // Handle action bar item clicks here. The action bar will
//        // automatically handle clicks on the Home/Up button, so long
//        // as you specify a parent activity in AndroidManifest.xml.
//        int id = item.getItemId();
//
//        //noinspection SimplifiableIfStatement
//        if (id == R.id.action_settings) {
//            return true;
//        }
//
//        return super.onOptionsItemSelected(item);
//    }
}
