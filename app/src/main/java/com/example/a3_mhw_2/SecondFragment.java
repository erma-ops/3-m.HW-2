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


public class SecondFragment extends Fragment {
    public static final String KEY_FOR_BUNDLE_TWO = "key.two";
    private EditText editText2;
    private Button btnClick2;
    private TextView tvSecondFragment;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_second, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        editText2 = view.findViewById(R.id.second_edt);
        tvSecondFragment = view.findViewById(R.id.tv_second_fragment);
        btnClick2 = view.findViewById(R.id.btn_Click2);

        if (getArguments() != null){
        String value = getArguments().getString(FirstFragment.KEY_FOR_BUNDLE_ONE);
        editText2.setText(value);
        }
        btnClick2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle bundle = new Bundle();
                bundle.putString(KEY_FOR_BUNDLE_TWO, editText2.getText().toString());
                ThirdFragment thirdFragment = new ThirdFragment();
                thirdFragment.setArguments(bundle);
                requireActivity().getSupportFragmentManager().beginTransaction().replace(R.id.container,  thirdFragment).addToBackStack(null).commit();


            }
        });
    }
}