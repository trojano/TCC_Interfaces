package com.example.amaraltm.elmat;
/*
import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
*/




import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;

import static com.example.amaraltm.elmat.R.id.buttonFacebook;


public class MainActivity extends /*AppCompat*/ Activity  {



        private static final String NAMESPACE = "com.service.ServiceImpl";
        private static final String URL =
                "http://www.elmat.kinghost.net/elmatservices/Services/UserService.svc?wsdl";
        private static final String SOAP_ACTION = "UserService";
        private static final String METHOD_NAME = "getMessage";

        private static final String[] sampleACTV = new String[] {
                "android", "iphone", "blackberry"
        };

        @Override
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.login);
            ArrayAdapter<String> arrAdapter = new ArrayAdapter<String>
                    (this, android.R.layout.simple_dropdown_item_1line, sampleACTV);

            AutoCompleteTextView ACTV = (AutoCompleteTextView)findViewById (buttonFacebook);
            ACTV.setAdapter(arrAdapter);

            SoapObject request = new SoapObject(NAMESPACE, METHOD_NAME);
            SoapSerializationEnvelope envelope =
                    new SoapSerializationEnvelope(SoapEnvelope.VER11);

            envelope.setOutputSoapObject(request);
            HttpTransportSE androidHttpTransport = new HttpTransportSE(URL);

            try {
                androidHttpTransport.call(SOAP_ACTION, envelope);
                SoapObject resultsRequestSOAP = (SoapObject) envelope.bodyIn;
                ACTV.setHint("Received :" + resultsRequestSOAP.toString());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }












   /* @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

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

*/
    /*Button buttonFacebook = (Button) findViewById(R.id.buttonFacebook);

    buttonFacebook.setOnClickListener (new View.OnClickListener() {
            Intent it = new Intent(MainActivity.this, SecondActivity.class);
            startActivity(it);

    }*/




}
