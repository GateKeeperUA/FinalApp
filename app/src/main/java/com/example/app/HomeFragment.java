package com.example.app;


import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.widget.Toolbar;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;



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

        Toolbar toolbar = requireActivity().findViewById(R.id.toolbar_v);
        BottomNavigationView bottomNavigation = requireActivity().findViewById(R.id.bottom_navigation_v);

        ConstraintLayout.LayoutParams toolbarLayoutParams = (ConstraintLayout.LayoutParams) toolbar.getLayoutParams();
        toolbarLayoutParams.topToTop = ConstraintLayout.LayoutParams.PARENT_ID;
        toolbar.setLayoutParams(toolbarLayoutParams);

        ConstraintLayout.LayoutParams bottomNavigationLayoutParams = (ConstraintLayout.LayoutParams) bottomNavigation.getLayoutParams();
        bottomNavigationLayoutParams.bottomToBottom = ConstraintLayout.LayoutParams.PARENT_ID;
        bottomNavigation.setLayoutParams(bottomNavigationLayoutParams);

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





