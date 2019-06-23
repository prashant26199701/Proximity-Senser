package prashant.spinner;

import android.app.Activity;
import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.Toast;

public class Main2Activity extends Activity implements SensorEventListener
{
SensorManager sm;
    ImageView iv;
     @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        iv=(ImageView)findViewById(R.id.imageView);
        String ss= Context.SENSOR_SERVICE;
        sm =(SensorManager) getSystemService(ss);
        int type= Sensor.TYPE_PROXIMITY;
        Sensor s=sm.getDefaultSensor(type);
        sm.registerListener(this,s,SensorManager.SENSOR_DELAY_NORMAL);
        Toast.makeText(Main2Activity.this,"put  your finger in front of your Proximity sensor",Toast.LENGTH_LONG).show();
    }
    @Override
    public void onSensorChanged(SensorEvent event)
    {
        float f =event.values[0];

        if(f==0)
        {
            iv.setImageResource(R.drawable.prs2);
            
        }
        else
        {
           iv.setImageResource(R.drawable.prs);
        }


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
