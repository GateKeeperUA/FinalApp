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
        Button primeiroAndarButton = view.findViewById(R.id.andar1);
        Button segundoAndarButton = view.findViewById(R.id.andar2);
        Button terceiroAndarButton = view.findViewById(R.id.andar3);


        // Define os listeners de clique para cada botão
        primeiroAndarButton.setOnClickListener(this);
        segundoAndarButton.setOnClickListener(this);
        terceiroAndarButton.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View v) {
        String id = v.getResources().getResourceEntryName(v.getId());

        if (id.equals("andar1")) {
            Intent intent = new Intent(getActivity(), floor1.class);
            startActivity(intent);
        }
        else if (id.equals("andar2")) {
            Intent intent = new Intent(getActivity(), floor2.class);
            startActivity(intent);
        }
        else if (id.equals("andar3")) {
            Intent intent = new Intent(getActivity(), floor3.class);
            startActivity(intent);
        }
    }
}





