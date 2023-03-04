package com.example.converterxo;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import java.util.Objects;

public class MainActivity extends AppCompatActivity {
    Spinner input, target;

    ArrayAdapter<CharSequence> inputadapter,targetadapter;
    String selectedinput, selectedtarget;
    EditText munumber;
    Button submitButton;
    TextView ans;
    double num;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        input =findViewById(R.id.input);
        target = findViewById(R.id.target);
        munumber = (EditText) findViewById(R.id.number);
        ans = (TextView) findViewById(R.id.answer);

        inputadapter=ArrayAdapter.createFromResource(this, R.array.planets_array, android.R.layout.simple_spinner_item);
        inputadapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        input.setAdapter(inputadapter);

        input.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                target = findViewById(R.id.target);

                selectedinput = input.getSelectedItem().toString();

                int parentID = adapterView.getId();
                if (parentID == R.id.input){
                    switch (selectedinput){
                        case "Select any option": targetadapter = ArrayAdapter.createFromResource(adapterView.getContext(),
                                R.array.input_default,R.layout.item_menu);
                        break;

                        case "Days": targetadapter = ArrayAdapter.createFromResource(adapterView.getContext(),
                                R.array.time,R.layout.item_menu);
                        break;
                        case "Hours": targetadapter = ArrayAdapter.createFromResource(adapterView.getContext(),
                                R.array.time,R.layout.item_menu);
                        break;
                        case "Minutes": targetadapter = ArrayAdapter.createFromResource(adapterView.getContext(),
                                R.array.time,R.layout.item_menu);
                        break;
                        case "Seconds": targetadapter = ArrayAdapter.createFromResource(adapterView.getContext(),
                                R.array.time,R.layout.item_menu);
                        break;
                        case "Terabytes": targetadapter = ArrayAdapter.createFromResource(adapterView.getContext(),
                                R.array.data,R.layout.item_menu);
                        break;
                        case "Megabytes": targetadapter = ArrayAdapter.createFromResource(adapterView.getContext(),
                                R.array.data,R.layout.item_menu);
                            break;
                        case "Gigabytes": targetadapter = ArrayAdapter.createFromResource(adapterView.getContext(),
                                R.array.data,R.layout.item_menu);
                            break;
                        case "Kilobytes": targetadapter = ArrayAdapter.createFromResource(adapterView.getContext(),
                                R.array.data,R.layout.item_menu);
                            break;
                        case "Bytes": targetadapter = ArrayAdapter.createFromResource(adapterView.getContext(),
                                R.array.data,R.layout.item_menu);
                            break;
                        case "Celsius": targetadapter = ArrayAdapter.createFromResource(adapterView.getContext(),
                                R.array.temperature,R.layout.item_menu);
                            break;
                        case "Fahrenheit": targetadapter = ArrayAdapter.createFromResource(adapterView.getContext(),
                                R.array.temperature,R.layout.item_menu);
                            break;


                        default: break;
                    }

                    targetadapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    target.setAdapter(targetadapter);

                    target.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                        @Override
                        public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                            selectedtarget = target.getSelectedItem().toString();
                        }

                        @Override
                        public void onNothingSelected(AdapterView<?> adapterView) {

                        }
                    });
                }

            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        submitButton = findViewById(R.id.button);
        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (munumber.getText().toString().length() == 0){
                    munumber.setText("0");
                }

                num = Double.parseDouble(munumber.getText().toString());

                if (Objects.equals(selectedinput, selectedtarget)) {
                    ans.setText("Output: "+ num);
                }
                else if (selectedinput.equals("Celsius")&& selectedtarget.equals("Fahrenheit")){
                    num = (double) ((num*1.8)+32);
                    ans.setText("Output: "+String.valueOf(num));
                }
                else if (selectedinput.equals("Fahrenheit")&& selectedtarget.equals("Celsius")){
                    num = (double) ((num-32)*0.5);
                    ans.setText("Output: "+String.valueOf(num));
                }
                if (selectedinput.equals("Terabytes")){
                    if (selectedtarget.equals("Gigabytes")){
                        num = num*1024;
                        ans.setText("Output: "+String.valueOf(num));
                    }
                    else if (selectedtarget.equals("Megabytes")){
                        num = (double) (num*(Math.pow(1024,2)));
                        ans.setText("Output: "+String.valueOf(num));
                    }
                    else if (selectedtarget.equals("Kilobytes")){
                        num = (double) (num*(Math.pow(1024,3)));
                        ans.setText("Output: "+String.valueOf(num));
                    }
                    else if (selectedtarget.equals("Bytes")){
                        num = (double) (num*(Math.pow(1024,4)));
                        ans.setText("Output: "+ num);
                    }
                }
                if (selectedinput.equals("Gigabytes")){
                    if (selectedtarget.equals("Terabytes")){
                        num = num/1024;
                        ans.setText("Output: "+String.valueOf(num));
                    }
                    else if (selectedtarget.equals("Megabytes")){
                        num = num*(1024*1);
                        ans.setText("Output: "+String.valueOf(num));
                    }
                    else if (selectedtarget.equals("Kilobytes")){
                        num = (double) (num*(Math.pow(1024,2)));
                        ans.setText("Output: "+String.valueOf(num));
                    }
                    else if (selectedtarget.equals("Bytes")){
                        num = (double) (num*(Math.pow(1024,3)));
                        ans.setText("Output: "+String.valueOf(num));
                    }
                }
                if (selectedinput.equals("Megabytes")){
                    if (selectedtarget.equals("Terabytes")){
                        num = (double) (num/(Math.pow(1024,2)));
                        ans.setText("Output: "+String.valueOf(num));
                    }
                    else if (selectedtarget.equals("Gigabytes")){
                        num = num/(1024*1);
                        ans.setText("Output: "+String.valueOf(num));
                    }
                    else if (selectedtarget.equals("Kilobytes")){
                        num = num*(1024);
                        ans.setText("Output: "+String.valueOf(num));
                    }
                    else if (selectedtarget.equals("Bytes")){
                        num = (double) (num*(Math.pow(1024,2)));
                        ans.setText("Output: "+String.valueOf(num));
                    }
                }
                if (selectedinput.equals("Kilobytes")){
                    if (selectedtarget.equals("Terabytes")){
                        num = (double) (num/(Math.pow(1024,3)));
                        ans.setText("Output: "+String.valueOf(num));
                    }
                    else if (selectedtarget.equals("Gigabytes")){
                        num = (double) (num/(Math.pow(1024,2)));
                        ans.setText("Output: "+String.valueOf(num));
                    }
                    else if (selectedtarget.equals("Megabytes")){
                        num = num/(1024);
                        ans.setText("Output: "+String.valueOf(num));
                    }
                    else if (selectedtarget.equals("Bytes")){
                        num = num*(1024);
                        ans.setText("Output: "+String.valueOf(num));
                    }
                }
                if (selectedinput.equals("Bytes")){
                    if (selectedtarget.equals("Terabytes")){
                        num = (double) (num/(Math.pow(1024,4)));
                        ans.setText("Output: "+String.valueOf(num));
                    }
                    else if (selectedtarget.equals("Gigabytes")){
                        num = (double) (num/(Math.pow(1024,3)));
                        ans.setText("Output: "+String.valueOf(num));
                    }
                    else if (selectedtarget.equals("Megabytes")){
                        num = (double) (num/(Math.pow(1024,2)));
                        ans.setText("Output: "+String.valueOf(num));
                    }
                    else if (selectedtarget.equals("Kilobytes")){
                        num = num/(1024);
                        ans.setText("Output: "+String.valueOf(num));
                    }
                }

                if (selectedinput.equals("Days")){
                    if (selectedtarget.equals("Hours")){
                        num = (double) (num*24);
                        ans.setText("Output: "+String.valueOf(num));
                    }
                    else if (selectedtarget.equals("Minutes")){
                        num = (double) (num*24*60);
                        ans.setText("Output: "+String.valueOf(num));
                    }
                    else if (selectedtarget.equals("Seconds")){
                        num = (double) (num*24*3600);
                        ans.setText("Output: "+String.valueOf(num));
                    }
                }

                if (selectedinput.equals("Hours")){
                    if (selectedtarget.equals("Days")){
                        num = (double) (num/24);
                        ans.setText("Output: "+String.valueOf(num));
                    }
                    else if (selectedtarget.equals("Minutes")){
                        num = (double) (num*60);
                        ans.setText("Output: "+String.valueOf(num));
                    }
                    else if (selectedtarget.equals("Seconds")){
                        num = (double) (num*3600);
                        ans.setText("Output: "+String.valueOf(num));
                    }
                }

                if (selectedinput.equals("Minutes")){
                    if (selectedtarget.equals("Days")){
                        num = (double) (num/1440);
                        ans.setText("Output: "+String.valueOf(num));
                    }
                    else if (selectedtarget.equals("Hours")){
                        num = (double) (num/60);
                        ans.setText("Output: "+String.valueOf(num));
                    }
                    else if (selectedtarget.equals("Seconds")){
                        num = (double) (num*60);
                        ans.setText("Output: "+String.valueOf(num));
                    }
                }

                if (selectedinput.equals("Seconds")){
                    if (selectedtarget.equals("Days")){
                        num = (double) (num/86400);
                        ans.setText("Output: "+String.valueOf(num));
                    }
                    else if (selectedtarget.equals("Hours")){
                        num = (double) (num/3600);
                        ans.setText("Output: "+String.valueOf(num));
                    }
                    else if (selectedtarget.equals("Minutes")){
                        num = (double) (num/60);
                        ans.setText("Output: "+String.valueOf(num));
                    }
                }
            }
        });
    }

}