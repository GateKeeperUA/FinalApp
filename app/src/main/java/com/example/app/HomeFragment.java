package com.example.app;


import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.Fragment;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;


public class HomeFragment extends Fragment implements View.OnClickListener {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        // Encontra os botões de cada andar
        Button firstfloorButton = view.findViewById(R.id.floor1);
        Button secondfloorButton = view.findViewById(R.id.floor2);
        Button thirdfloorButton = view.findViewById(R.id.floor3);
        Button officesButton = view.findViewById(R.id.offices);


        // Define os listeners de clique para cada botão
        firstfloorButton.setOnClickListener(this);
        secondfloorButton.setOnClickListener(this);
        thirdfloorButton.setOnClickListener(this);
        officesButton.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View v) {
        String id = v.getResources().getResourceEntryName(v.getId());

        if (id.equals("floor1")) {
            Intent intent = new Intent(getActivity(), floor1.class);
            startActivity(intent);
        }
        else if (id.equals("floor2")) {
            Intent intent = new Intent(getActivity(), floor2.class);
            startActivity(intent);
        }
        else if (id.equals("floor3")) {
            Intent intent = new Intent(getActivity(), floor3.class);
            startActivity(intent);
        }
        else if (id.equals("offices")) {
            Intent intent = new Intent(getActivity(), offices.class);
            startActivity(intent);
        }
    }
}





