package com.n.todo;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.n.todo.databinding.ActivityDataInsertBinding;

public class MainActivity extends AppCompatActivity {

    private NoteViewModel noteViewModel;
    ActivityDataInsertBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityDataInsertBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        noteViewModel = new NoteViewProvider(this,(ViewModelProvider.Factory)androidviewModelProviderFactory.getInstance(this.getApplication()))
                .get(NoteViewModel.class);
        binding.floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, DataInsertActivity.class);
                startActivityForResult(intent,1);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == 1)
        {
            String title = data.getStringExtra("title");
            String description = data.getStringExtra("description");
            Note note =new Note(title,description);

        }
    }
}