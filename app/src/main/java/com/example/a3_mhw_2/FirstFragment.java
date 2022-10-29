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


public class FirstFragment extends Fragment {
    public static final   String KEY_FOR_BUNDLE_ONE = "Key.one";
    private Button btnClick1;
    private EditText editText1;
    private TextView tvfirstFrag;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
                return inflater.inflate(R.layout.fragment_first, container, false);
    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        tvfirstFrag = view.findViewById(R.id.tv_first_fragment);
        if (getArguments() != null){
            tvfirstFrag.setText(getArguments().getString(ThirdFragment.KEY_FOR_BUNDLE_THREE));
        }

        btnClick1 = view.findViewById(R.id.btn_1);
        editText1 = view.findViewById(R.id.first_edt);
        btnClick1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            Bundle bundle = new Bundle();
            bundle.putString(KEY_FOR_BUNDLE_ONE, editText1.getText().toString());
            SecondFragment secondFragment = new SecondFragment();
            secondFragment.setArguments(bundle);
            requireActivity().getSupportFragmentManager().beginTransaction().replace(R.id.container, secondFragment).addToBackStack(null).commit();

            }
        });
    }
}