package com.example.todolist;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.todolist.Adapter.TodoAdapter;
import com.example.todolist.Model.ToDoModel;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RecyclerView taskRecyclerView;
    private TodoAdapter adapter;
    private List<ToDoModel> toDoModelList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.tasksText), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        taskRecyclerView = findViewById(R.id.recyclerView);
        taskRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        adapter = new TodoAdapter(this);
        taskRecyclerView.setAdapter(adapter);


        ToDoModel task = new ToDoModel();
        task.setTask("My task 1");
        task.setStatus(false);
        task.setId(1);
        toDoModelList = new ArrayList<>();
        toDoModelList.add(task);
        toDoModelList.add(task);
        adapter.setToDoModelList(toDoModelList);

    }
}