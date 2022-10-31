package com.aan.uts_20753033_sucitraaansentosa;

import android.content.res.TypedArray;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;

public class HomeFragment extends Fragment {
    private RecyclerView rvMotor;
    private ArrayList<Motor> list = new ArrayList<>();

    public static HomeFragment newInstance(String param1, String param2) {
        HomeFragment fragment = new HomeFragment();
        Bundle args = new Bundle();

        return fragment;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        rvMotor = view.findViewById(R.id.rv_motor);
        rvMotor.setHasFixedSize(true);

        list.addAll(getListMotor());
        showRecyclerList();

    }

    public ArrayList<Motor> getListMotor() {
        String[] dataName = getResources().getStringArray(R.array.data_name);
        String[] dataDescription = getResources().getStringArray(R.array.data_description);
        TypedArray dataPhoto = getResources().obtainTypedArray(R.array.data_photo);
        ArrayList<Motor> listMotor = new ArrayList<>();
        for (int i = 0; i < dataName.length; i++) {
            Motor Motor = new Motor();
            Motor.setName(dataName[i]);
            Motor.setDescription(dataDescription[i]);
            Motor.setPhoto(dataPhoto.getResourceId(i, -1));
            listMotor.add(Motor);
        }
        return listMotor;
    }

    private void showRecyclerList() {
        rvMotor.setLayoutManager(new LinearLayoutManager(getContext()));
        ListMotorAdapter listMotorAdapter = new ListMotorAdapter(list);
        rvMotor.setAdapter(listMotorAdapter);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_home, container, false);
    }

}