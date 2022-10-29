package com.example.a3_mhw_2;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class ThirdFragment extends Fragment {
    public static final String KEY_FOR_BUNDLE_THREE = "Key.three";
    private TextView textView3;
    private Button btnClick3;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
       return inflater.inflate(R.layout.fragment_third, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        textView3 = view.findViewById(R.id.third_tv);
        btnClick3 = view.findViewById(R.id.btn_click3);
        if (getArguments()!= null){
            String value = getArguments().getString(SecondFragment.KEY_FOR_BUNDLE_TWO);
            textView3.setText(value);
        }
        btnClick3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle bundle = new Bundle();
                bundle.putString(KEY_FOR_BUNDLE_THREE, textView3.getText().toString());
                FirstFragment firstFragment = new FirstFragment();
                firstFragment.setArguments(bundle);
                requireActivity().getSupportFragmentManager().beginTransaction().replace(R.id.container,firstFragment).addToBackStack(null).commit();
            }
        });
    }
}