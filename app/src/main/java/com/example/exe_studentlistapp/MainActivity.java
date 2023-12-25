package com.example.exe_studentlistapp;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private EditText editTextName, editTextStudentId, editTextNationalCode;
    private Button btnSave;
    private ListView listViewStudents;
    private ArrayList<String> studentList;
    private ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextName = findViewById(R.id.editTextName);
        editTextStudentId = findViewById(R.id.editTextStudentId);
        editTextNationalCode = findViewById(R.id.editTextNationalCode);
        btnSave = findViewById(R.id.btnSave);
        listViewStudents = findViewById(R.id.listViewStudents);

        studentList = new ArrayList<>();
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, studentList);
        listViewStudents.setAdapter(adapter);

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveStudentInfo();
            }
        });
    }

    private void saveStudentInfo() {
        String name = editTextName.getText().toString();
        String studentId = editTextStudentId.getText().toString();
        String nationalCode = editTextNationalCode.getText().toString();

        // افزودن اطلاعات دانشجو به لیست
        String studentInfo = "نام: " + name + "\nشماره دانشجویی: " + studentId + "\nکد ملی: " + nationalCode;
        studentList.add(studentInfo);

        // به‌روزرسانی ListView
        adapter.notifyDataSetChanged();

        // پاک کردن متن ورودی‌ها
        editTextName.getText().clear();
        editTextStudentId.getText().clear();
        editTextNationalCode.getText().clear();
    }
}