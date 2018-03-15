package com.example.kiit.birthday;

import android.Manifest;
import android.content.CursorLoader;
import android.content.Loader;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.os.Build;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    private static final int READ_CONTACTS_PERMISSION_GRANTED = 0;
    private static final int CONTACTS_ID = 90 ;
    private SimpleCursorAdapter simpleCursorAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            getpermissions();
        }
        ListView mListView = (ListView)findViewById(R.id.list_item);
        mListView.setAdapter(simpleCursorAdapter);
        setCusorAdapter();
    }

    private void setCusorAdapter() {
        String[] UIbindfrom = {ContactsContract.Contacts.DISPLAY_NAME , ContactsContract.Contacts.PHOTO_URI};
        int[] UIbindto = {R.id.text,R.id.image};

        simpleCursorAdapter = new SimpleCursorAdapter(this,R.layout.item,null,UIbindfrom,UIbindto,0);

    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    private void getpermissions() {
        if (checkSelfPermission(Manifest.permission.READ_CONTACTS) != PackageManager.PERMISSION_GRANTED)
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                requestPermissions(new String[]{Manifest.permission.READ_CONTACTS},READ_CONTACTS_PERMISSION_GRANTED);
                return;
            }
            else
                loadContacts();

    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch (requestCode)
        {
            case READ_CONTACTS_PERMISSION_GRANTED:
            {
                if(grantResults[0] == PackageManager.PERMISSION_GRANTED)
                    loadContacts();
                else
                    Toast.makeText(getApplicationContext(),"Not Granted",Toast.LENGTH_LONG).show();
            }
        }
    }

    private void loadContacts() {
        getSupportLoaderManager().initLoader(CONTACTS_ID,new Bundle(), (android.support.v4.app.LoaderManager.LoaderCallbacks<Object>) contactsAdapter);
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
    private LoaderManager.LoaderCallbacks<Cursor> contactsAdapter = new LoaderManager.LoaderCallbacks<Cursor>()
    {

        @Override
        public Loader<Cursor> onCreateLoader(int i, Bundle bundle) {
            String[] projectionfields = new String[]{ContactsContract.Contacts._ID,
                    ContactsContract.Contacts.DISPLAY_NAME,
                    ContactsContract.Contacts.PHOTO_URI};
            CursorLoader mCursorLoader = new CursorLoader(MainActivity.this,ContactsContract.Contacts.CONTENT_URI,projectionfields,null,null,null);

            return mCursorLoader;
        }

        @Override
        public void onLoadFinished(Loader<Cursor> loader, Cursor cursor) {
             simpleCursorAdapter.swapCursor(cursor);
        }

        @Override
        public void onLoaderReset(Loader<Cursor> loader) {
             simpleCursorAdapter.swapCursor(null);
        }
    };

}
