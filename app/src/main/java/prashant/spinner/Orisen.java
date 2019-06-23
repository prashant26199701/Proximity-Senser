package prashant.spinner;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import static android.R.attr.x;
import static android.R.attr.y;
import static android.R.attr.zAdjustment;

public class Orisen extends Activity implements SensorEventListener
{
    SensorManager sm;
    TextView t1;
    TextView t2;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
      //  iv=(ImageView)findViewById(R.id.imageView);
        String ss= Context.SENSOR_SERVICE;
        sm =(SensorManager) getSystemService(ss);

        int type= Sensor.TYPE_ORIENTATION;
        Sensor s=sm.getDefaultSensor(type);
        sm.registerListener(this,s,SensorManager.SENSOR_DELAY_NORMAL);
    }
    @Override
    public void onSensorChanged(SensorEvent event)
    {
        int X =(int)event.values[0];
        int Y =(int)event.values[0];
        int Z =(int)event.values[0];


       CharSequence status="SENSOR STATUS :"+
               "\nVALUE OF x= "+X+
               "\nVALUE OF Y= "+Y+
               "\nVALUE OF Z= "+Z;
        t1.setText(status);
        t2.setBackgroundColor(Color.rgb(X,Y,Z));


    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }

    @Override
    protected void onStop() {
        super.onStop();
        sm.unregisterListener(this);
    }
}
