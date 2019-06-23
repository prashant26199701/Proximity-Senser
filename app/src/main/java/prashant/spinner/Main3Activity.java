package prashant.spinner;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class Main3Activity extends AppCompatActivity {
    Button b;
    //ImageView i1,i2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
       b=(Button)findViewById(R.id.button4);
       // i1=(ImageView)findViewById(R.id.imageView3);
       // i1.setImageResource(R.drawable.ps);
       // i2=(ImageView)findViewById(R.id.imageView4);
//        i2.setImageResource(R.drawable.ps2);

       b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Main3Activity.this,"launching",Toast.LENGTH_SHORT).show();

                Intent i=new Intent(Main3Activity.this,Main2Activity.class);
7
                startActivity(i);

            }
        });
    }

}
