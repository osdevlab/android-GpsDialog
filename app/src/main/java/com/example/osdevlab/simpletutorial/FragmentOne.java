package com.example.osdevlab.simpletutorial;

import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

/**
 * Created by osdevlab on 12/29/14.
 */
public class FragmentOne extends Fragment {

    Context context;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        // Inflate the layout with fragment_one.xml
        View view = inflater.inflate(R.layout.fragment_one, container, false);

        //create Button 'button' and link with button id from fragment_one.xml
        Button button = (Button) view.findViewById(R.id.button);

        //returns the Activity the Fragment is currently associated with
        //In Fragment, this step requires to pass context to other class.
        context = getActivity();

        /*define OnClickListener for button here*/
        button.setOnClickListener(new View.OnClickListener() {
            //create object and pass context to it.
            GpsHelperClass gpsHelperClass = new GpsHelperClass(context);

            public void onClick(View v) {
                //get boolean result and display small pop up
                if (gpsHelperClass.isGpsReadyToUse()) {
                    Toast.makeText(context, "GPS is already enable",
                            Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(context, "GPS is not enable",
                            Toast.LENGTH_SHORT).show();
                }
            }
        });
        return view;
    }
}
