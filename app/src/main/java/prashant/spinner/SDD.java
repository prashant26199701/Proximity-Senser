package prashant.spinner;

import android.app.Activity;
import android.content.DialogInterface;
import android.os.Environment;
import android.support.annotation.RequiresPermission;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.SearchView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class SDD extends Activity
{
Button b1,b2;
    EditText e1,e2;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sdd);
        e1=(EditText)findViewById(R.id.editText);
                e2=(EditText)findViewById(R.id.editText2);
        b1=(Button)findViewById(R.id.button2);
                b2=(Button)findViewById(R.id.button3);
        b1.setOnClickListener(new WriteSDcard());
        b2.setOnClickListener(new ReadSDcard());
    }
   class WriteSDcard implements View.OnClickListener
   {
       @Override
       public void onClick(View v)
       {
           File rootPath = Environment.getExternalStorageDirectory();
           File f = new File(rootPath, "Contact data.txt");
           if (f.exists() == false)
           {
               try
               {
                   f.createNewFile();
                   Toast.makeText(SDD.this, "File created", Toast.LENGTH_LONG).show();
               }
               catch (Exception e)
               {
               }
               try
               {
                   String dts = e1.getText().toString() + ":" + e2.getText().toString();
                   FileOutputStream fos = new FileOutputStream(f, true);
                   fos.write(dts.getBytes());
                   Toast.makeText(SDD.this, "Data Saved", Toast.LENGTH_LONG).show();
               }
               catch (Exception e)
               {
                   e.printStackTrace();
               }
           }
       }
   }
    class ReadSDcard implements View.OnClickListener
    {
        @Override
        public void onClick(View V)
        {
            File rootPath= Environment.getExternalStorageDirectory();
            File f= new File(rootPath,"ContactData.txt");
            if(f.exists())
            {
                try
                {
                    FileInputStream fis = new FileInputStream(f);
                    String fd = "";
                    while (true) {
                        int a = fis.read();
                        if (a == 1) {
                            break;
                        }
                        fd = fd + (char) a;
                    }
                    Toast.makeText(SDD.this,fd, Toast.LENGTH_LONG).show();
                }
                catch (Exception e)
                {
                    e.printStackTrace();
                }
            }
            else
            {
                Toast.makeText(SDD.this,"No Data", Toast.LENGTH_LONG).show();
            }
        }
    }

}