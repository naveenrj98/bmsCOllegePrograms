package developers.bmsce.mank.com.bms.Program_5and6_database;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.app.AlertDialog;
import android.database.Cursor;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import developers.bmsce.mank.com.bms.R;

public class Program5and6 extends AppCompatActivity {

    DatabseHelper dbHelper;
    EditText et_usn, et_name, et_email, et_cgpa;
    Button btn_insert;
    Button btn_display;
    Button btn_delete;
    Button btn_update;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_program5and6);
        dbHelper = new DatabseHelper(this);

        et_usn = findViewById(R.id.editText_usn);
        et_name = findViewById(R.id.editText_name);
        et_email = findViewById(R.id.editText_email);
        et_cgpa = findViewById(R.id.editText_cg);
        btn_insert = findViewById(R.id.button_add);
        btn_display = findViewById(R.id.button_viewAll);
        btn_update = findViewById(R.id.button_update);
        btn_delete = findViewById(R.id.button_delete);
        Insert();
        Display();
        Update();
        Delete();
    }
    public void Delete() {
        btn_delete.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Integer deletedRows = dbHelper.deleteData(et_usn.getText().toString());
                        if(deletedRows > 0)
                            Toast.makeText(Program5and6.this,""+et_usn.getText().toString()+" Data has been deleted",Toast.LENGTH_LONG).show();
                        else
                            Toast.makeText(Program5and6.this,"Please input usn to delete !!!",Toast.LENGTH_LONG).show();
                    }
                }
        );
    }
    public void Update() {
        btn_update.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        boolean isUpdate = dbHelper.updateData(et_usn.getText().toString(),
                                et_name.getText().toString(),
                                et_email.getText().toString(), et_cgpa.getText().toString());
                        if(isUpdate == true)
                            Toast.makeText(Program5and6.this,""+et_usn.getText().toString()+" Data has been updated",Toast.LENGTH_LONG).show();
                        else
                            Toast.makeText(Program5and6.this,"Please make changes to update",Toast.LENGTH_LONG).show();
                    }
                }
        );
    }
    public  void Insert() {
        btn_insert.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        boolean isInserted = dbHelper.insertData(et_usn.getText().toString(),
                                et_name.getText().toString(), et_email.getText().toString(), et_cgpa.getText().toString());
                        if(isInserted == true)
                            Toast.makeText(Program5and6.this,"Data Inserted with USN ="+et_usn.getText().toString(),Toast.LENGTH_LONG).show();
                        else
                            Toast.makeText(Program5and6.this,"Please enter the details",Toast.LENGTH_LONG).show();
                    }
                }
        );
    }

    public void Display() {
        btn_display.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        //to get all data from database
                        Cursor res = dbHelper.getAllData();
                        if(res.getCount() == 0) {
                            //displaying in the card view
                            showMessage("Student Details","Sorry :( Your table is Empty");
                            return;
                        }

                        StringBuffer buffer = new StringBuffer();
                        while (res.moveToNext()) {
                            buffer.append("USN :"+ res.getString(0)+"\n");
                            buffer.append("NAME :"+ res.getString(1)+"\n");
                            buffer.append("EMAIL :"+ res.getString(2)+"\n");
                            buffer.append("CGPA :"+ res.getString(3)+"\n\n");
                        }


                        showMessage("Student Details",buffer.toString());
                    }
                }
        );
    }

    public void showMessage(String title,String Message){
      final AlertDialog.Builder adapter = new AlertDialog.Builder(this);
        adapter.setCancelable(true);
        adapter.setTitle(title);
        adapter.setMessage(Message);
        adapter.show();
    }

}
