package com.example.sashealthcare;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;

public class DoctorDetailsActivity extends AppCompatActivity {
      private String[][] doctor_details1 =
              {
                      {"Doctor Name : Sahil", "Hospital Address : Dwarka", "Exp : 3yrs", "Mobile No:8076514258", "600"},
                      {"Doctor Name : Ankit", "Hospital Address : Gurgaon", "Exp : 15yrs", "Mobile No:8076514258", "900"},
                      {"Doctor Name : Shivani", "Hospital Address : Janakpuri", "Exp : 8yrs", "Mobile No:8076514258", "300"},
                      {"Doctor Name : Naina", "Hospital Address : Kriti Nagar", "Exp : 6yrs", "Mobile No:8076514258", "500"},
                      {"Doctor Name : Prince", "Hospital Address : Uttam Nagar", "Exp : 7yrs", "Mobile No:8076514258", "200"},
              };
      private String[][] doctor_details2 =
            {
                    {"Doctor Name : Seema", "Hospital Address : Dwarka", "Exp : 4yrs", "Mobile No:8076514258", "300"},
                    {"Doctor Name : Ankita", "Hospital Address : Gurgaon", "Exp : 6yrs", "Mobile No:8076514258", "400"},
                    {"Doctor Name : Shiv", "Hospital Address : Janakpuri", "Exp : 7yrs", "Mobile No:8076514258", "600"},
                    {"Doctor Name : Monish", "Hospital Address : Kriti Nagar", "Exp : 4yrs", "Mobile No:8076514258", "500"},
                    {"Doctor Name : Shivam", "Hospital Address : Uttam Nagar", "Exp : 5yrs", "Mobile No:8076514258", "700"},
            };
      private String[][] doctor_details3 =
            {
                    {"Doctor Name : Amol", "Hospital Address : Dwarka", "Exp : 3yrs", "Mobile No:8076514258", "600"},
                    {"Doctor Name : Prasad", "Hospital Address : Gurgaon", "Exp : 14yrs", "Mobile No:8076514258", "1100"},
                    {"Doctor Name : Nilesh", "Hospital Address : Janakpuri", "Exp : 6yrs", "Mobile No:8076514258", "300"},
                    {"Doctor Name : Deepak", "Hospital Address : Kriti Nagar", "Exp : 7yrs", "Mobile No:8076514258", "600"},
                    {"Doctor Name : Ankul", "Hospital Address : Uttam Nagar", "Exp : 9yrs", "Mobile No:8076514258", "700"},
            };

    private String[][] doctor_details4 =
            {
                    {"Doctor Name : Shrikant", "Hospital Address : Dwarka", "Exp : 4yrs", "Mobile No:8076514258", "600"},
                    {"Doctor Name : Monish", "Hospital Address : Gurgaon", "Exp : 12yrs", "Mobile No:8076514258", "900"},
                    {"Doctor Name : Pankaj", "Hospital Address : Janakpuri", "Exp : 3yrs", "Mobile No:8076514258", "300"},
                    {"Doctor Name : Kriti", "Hospital Address : Kriti Nagar", "Exp : 8yrs", "Mobile No:8076514258", "500"},
                    {"Doctor Name : Minakshi", "Hospital Address : Uttam Nagar", "Exp : 5yrs", "Mobile No:8076514258", "800"},
            };
    private String[][] doctor_details5 =
            {
                    {"Doctor Name : Seela", "Hospital Address : Dwarka", "Exp : 3yrs", "Mobile No:8076514258", "1600"},
                    {"Doctor Name : Alka", "Hospital Address : Gurgaon", "Exp : 9yrs", "Mobile No:8076514258", "1900"},
                    {"Doctor Name : Anil", "Hospital Address : Janakpuri", "Exp : 2yrs", "Mobile No:8076514258", "1200"},
                    {"Doctor Name : Raj", "Hospital Address : Kriti Nagar", "Exp : 4yrs", "Mobile No:8076514258", "1500"},
                    {"Doctor Name : Mukul", "Hospital Address : Uttam Nagar", "Exp : 9yrs", "Mobile No:8076514258", "1800"},
            };
    TextView tv;
    Button btn;
    String[][] doctor_details = {};
    HashMap<String,String> item;
    ArrayList list;
    SimpleAdapter sa;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_details);

        tv = findViewById(R.id.textViewHATitle);
        btn = findViewById(R.id.buttonHABack);

        Intent it = getIntent();
        String title = it.getStringExtra( "title");
        tv.setText(title);

        if(title.compareTo("Family Physicians")==0)
            doctor_details = doctor_details1;
        else
        if(title.compareTo("Dietician")==0)
            doctor_details = doctor_details2;
        else
        if(title.compareTo("Dentist")==0)
            doctor_details = doctor_details3;
        else
        if(title.compareTo("Surgeon")==0)
            doctor_details = doctor_details4;
        else
            doctor_details = doctor_details5;

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(DoctorDetailsActivity.this,FindDoctorActivity.class));
            }
        });

        list = new ArrayList();
        for(int i=0; i<doctor_details.length;i++){
            item = new HashMap<String,String>();
            item.put("Line1", doctor_details[i][0]);
            item.put("Line2", doctor_details[i][1]);
            item.put("Line3", doctor_details[i][2]);
            item.put("Line4", doctor_details[i][3]);
            item.put("line5", "Cons Fees:"+doctor_details[i][4]+"/-");
            list.add( item );
        }
        sa = new SimpleAdapter(this, list,
                R.layout.multi_lines,
                new String[]{"line1","line2","line3","line4","line5"},
                new int[]{R.id.line_a,R.id.line_b,R.id.line_c,R.id.line_d,R.id.line_e}
        );
        ListView lst = findViewById(R.id.listViewHA);
        lst.setAdapter(sa);

       lst.setOnItemClickListener(new AdapterView.OnItemClickListener() {
           @Override
           public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
               Intent it = new Intent(  DoctorDetailsActivity.this,BookAppointmentActivity.class);
               it.putExtra("text1",title);
               it.putExtra("text2",doctor_details[i][0]);
               it.putExtra("text3",doctor_details[i][1]);
               it.putExtra("text4",doctor_details[i][3]);
               it.putExtra("text5",doctor_details[i][4]);
               startActivity(it);

           }
       });
    }
}