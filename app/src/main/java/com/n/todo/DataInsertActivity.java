package com.n.todo;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.n.todo.databinding.ActivityDataInsertBinding;

public class DataInsertActivity extends AppCompatActivity {
    ActivityDataInsertBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityDataInsertBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.putExtra("title",binding.editTextText3.getText().toString());
                intent.putExtra("description",binding.editTextText4.getText().toString());
                setResult(RESULT_OK,intent);
                finish();
            }
        });
    }
}