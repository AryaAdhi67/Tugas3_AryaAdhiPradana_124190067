package com.example.semifinaluclmodul_recyclerview;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private int orien = 0; // ==> penanda oreintasi recyclerview => 0 = vertical , 1 = horizontal, 2 = grid

    private Button vertical;
    private Button horizontal;
    private Button grid;

    private RecyclerView rvTeam;
    private ArrayList<Model> listTeam = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        vertical = findViewById(R.id.btn_Vertical);
        horizontal = findViewById(R.id.btn_Horizontal);
        grid = findViewById(R.id.btn_Grid);

        rvTeam = findViewById(R.id.rv_team_list);
        rvTeam.setHasFixedSize(true);
        listTeam.addAll(Data.getListData());

        showRecyclerList();

        vertical.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setOrien(0);
                showRecyclerList();
            }
        });
        horizontal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setOrien(1);
                showRecyclerList();
            }
        });
        grid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setOrien(2);
                showRecyclerList();
            }
        });
    }

    private void showRecyclerList() {
        // jika vertical
        if (getOrien()==0) rvTeam.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        // jika horizontal
        else if (getOrien()==1) rvTeam.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
       // jika grid
        else if (getOrien()==2) rvTeam.setLayoutManager(new GridLayoutManager(this,2));
        // default
        else  rvTeam.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));

        Adapter adapter = new Adapter(this);
        adapter.setModels(listTeam);
        adapter.setOrientasi(getOrien());
        rvTeam.setAdapter(adapter);

        adapter.setOnItemClickListener(new Adapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                Intent intent = new Intent(MainActivity.this, DataPemain.class);
                intent.putExtra("posisi", position);
                startActivity(intent);
            }
        });
    }

    public int getOrien() {
        return orien;
    }

    public void setOrien(int orien) {
        this.orien = orien;
    }
}