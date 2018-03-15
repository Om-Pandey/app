package hk.ust.cse.comp107x.timegreetfriend;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Calendar;
import java.util.Date;

public class MainActivity extends AppCompatActivity implements View.OnClickListener  {

    Button greetButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // get a reference to the greetButton on the UI
        greetButton = (Button) findViewById(R.id.greetButton);
        // Set the onClickListener for the greetButton to be this class.
        // This requires that the class implement the View.OnClickListener callback
        // the onClick() method
        greetButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        // get a reference to the TextView on the UI
        TextView textMessage = (TextView) findViewById(R.id.textMessage);

        //get a reference to the EditText so that we can read in the value typed
        // by the user
        EditText editFriendName = (EditText) findViewById(R.id.editFriendName);

        // get the name of the friend typed in by the user in the EditText field
        String friendName = editFriendName.getText().toString();

        Date date = new Date();
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        int hour = cal.get(Calendar.HOUR_OF_DAY);
        if(hour >= 6 && hour < 12)
        textMessage.setText(getString(R.string.goodmorning) + friendName + "!");
        if(hour >= 12 && hour < 17)
            textMessage.setText(getString(R.string.goodafternoon) + friendName + "!");
        if(hour >= 17 && hour < 21)
            textMessage.setText(getString(R.string.goodevening) + friendName + "!");
        if(  21 <= hour||(hour >=0 && hour < 6 ))
            textMessage.setText(getString(R.string.goodnight) + friendName + "!");


        // TODO 1
        // Add the code to display the appropriate greeting message. Your output message should be exactly the same as the one you see on the video with exactly the same number of spaces in the same positions.
        // The code from the previous exercise is commented and kept below for your reference
        //switch (v.getId()) {

        //case R.id.greetButton:

        // set the string being displayed by the TextView to the greeting
        // message for the friend
        //textMessage.setText(getString(R.string.greetstring) + friendName + "!");

        //break;

        //default:

        //break;
        //}
    }
}
