package prashant.spinner;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.net.wifi.WifiManager;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class Main4Activity extends Activity {
TextView tv;
    @Override
    protect super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
        tv=(TextView)findViewById(R.id.textView7);
        Uri uri= ContactsContract.Contacts.CONTENT_URI;
        ContentResolver cr=getContentResolver();
        Cursor c=cr.query(uri,null,null,null);
        String names="CONTACTNAME:\n_ _ _ _ _\n";
        while (c.moveToNext());
        {
            int ni=c.getColumnIndex(ContactsContract.PhoneLookup.DISPLAY_NAME);
            String name=c.getString(ni);
            names+=name+"\n";

        }
        tv.setText(names);
        Toast.makeText(this,names,Toast.LENGTH_LONG).show();

    }
}
