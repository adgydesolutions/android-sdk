package com.adgyde.example;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.adgyde.android.PAgent;
import com.adgyde.myapplication.R;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    public Button revenue, unique_Event, simple_event, counting_event, Computing_event, user_info;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        revenue = (Button) findViewById(R.id.revenue);
        revenue.setOnClickListener(this);

        unique_Event = (Button) findViewById(R.id.unique_Event);
        unique_Event.setOnClickListener(this);

        simple_event = (Button) findViewById(R.id.simple_event);
        simple_event.setOnClickListener(this);

        counting_event = (Button) findViewById(R.id.counting_event);
        counting_event.setOnClickListener(this);

        Computing_event = (Button) findViewById(R.id.Computing_event);
        Computing_event.setOnClickListener(this);

        user_info = (Button) findViewById(R.id.demography);
        user_info.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.revenue:
                revenue();
                break;
            case R.id.unique_Event:
                uniqueEvent();
                break;
            case R.id.simple_event:
                simpleEvent();
                break;
            case R.id.counting_event:
                Intent in2 = new Intent(this, CountingEvent.class);
                startActivity(in2);
                break;
            case R.id.Computing_event:
                Intent in3 = new Intent(this, ComputingEvent.class);
                startActivity(in3);
                break;
            case R.id.demography:
                Intent in4 = new Intent(this, UserProfile.class);
                startActivity(in4);
                break;
        }


    }


    /* 
	 * Simple Event
	 * =============
     * The below code is the example to pass a simple event to the AdGyde SDK.
	 * This event requires only 1 Parameter which is the Event ID.
	 * 
	 * NOTE : Creating the Simple Event on Console with Event ID is Compulsory
	 *
	 */
    public void simpleEvent() {
        PAgent.onEvent("SimpleEventID");
        Toast.makeText(this, "Simple event clicked", Toast.LENGTH_SHORT).show();
        PAgent.flush();
    }


    /* 
	 * Unique Event
	 * =============
     * The below code is the example to pass a Unique event to the AdGyde SDK.
	 * This event is useful to track event which needs to be tracked once / Uniquely in a Day.
	 * Multiple values Can be passed in the Event using multiple Parameters, but Uniqueness will be as per Event ID only
	 * 
	 * NOTE : Creating the Unique Event on Console with Event ID, Parameter is Compulsory
	 *
	 */
    public void uniqueEvent(){
        Map<String,String> param=new HashMap<String, String>();

        // The paramter being passed in unique event are in combination of ParamterName and Value same as shown below
		// param.put( paramName, valueName );
        param.put("uniqueParamterName","valueName");

		// Event is triggered with EventId and Parameters prepared above, the same are passed in this function
        // The third Boolean parameter (true) specifies that the Event is a unique Event
		// 
		// NOTE : In case false is passed in third parameter then this event will work as counting event
        PAgent.onEvent("uniqueEventId",param,true);

        Toast.makeText(this, "Unique event clicked", Toast.LENGTH_SHORT).show();
        PAgent.flush();
    }

	
	
	/* 
	 * Revenue Event
	 * =============
     * The below code is the example to pass a Revenue event to the AdGyde SDK.
	 * This event is useful to track revenue generated by the user in-app.
	 * Unit of the currency need not be passed, by default revenue is calculated in INR (Indian Rupees)
	 * 
	 * NOTE : There is no Need to create the Revenue Event on Console
	 *
	 */
    public void revenue() {
		// Revenue Event only requires the Revenue Value to be passed
        PAgent.onRevenue(5); 
        Toast.makeText(this, "Revenue clicked", Toast.LENGTH_SHORT).show();
        PAgent.flush();

    }
}
