package developers.bmsce.mank.com.bms.program_2_eventlistener;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import developers.bmsce.mank.com.bms.R;

public class SecondActivity extends AppCompatActivity {

    TextView t1, t2, t3;

    String name, reg, dept;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        t1 = (TextView) findViewById(R.id.textView1);
        t2 = (TextView) findViewById(R.id.textView2);
        t3 = (TextView) findViewById(R.id.textView3);

        //Getting the Intent
        Intent i = getIntent();

        //Getting the Values from First Activity using the Intent received
        name = i.getStringExtra("name_key");
        reg = i.getStringExtra("reg_key");
        dept = i.getStringExtra("dept_key");

        //Setting the Values to Intent
        t1.setText(name);
        t2.setText(reg);
        t3.setText(dept);

    }
}
