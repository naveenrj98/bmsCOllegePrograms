package developers.bmsce.mank.com.bms.program_2_eventlistener;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import developers.bmsce.mank.com.bms.MainActivity;
import developers.bmsce.mank.com.bms.R;

public class Program2 extends AppCompatActivity {

    //Defining the Views
    EditText e1, e2;
    Button bt;
    Spinner s;

    //Data for populating in Spinner
    String[] dept_array = {"CSE", "ECE", "IT", "Mech", "Civil"};

    String name, reg, dept;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Referring the Views
        e1 = (EditText) findViewById(R.id.editText);
        e2 = (EditText) findViewById(R.id.editText2);

        bt = (Button) findViewById(R.id.button);

        s = (Spinner) findViewById(R.id.spinner);

        //Creating Adapter for Spinner for adapting the data from array to Spinner
        ArrayAdapter adapter = new ArrayAdapter(Program2.this, android.R.layout.simple_spinner_item, dept_array);
        s.setAdapter(adapter);

        //Creating Listener for Button
        bt.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick (View v){

                //Getting the Values from Views(Edittext & Spinner)
                name = e1.getText().toString();
                reg = e2.getText().toString();
                dept = s.getSelectedItem().toString();

                //Intent For Navigating to Second Activity
                Intent i = new Intent(Program2.this, SecondActivity.class);

                //For Passing the Values to Second Activity
                i.putExtra("name_key", name);
                i.putExtra("reg_key", reg);
                i.putExtra("dept_key", dept);

                startActivity(i);

            }
        });
    }
}