package com.pjct.abasapp.fragments;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.pjct.abasapp.R;
import com.pjct.abasapp.Usuario;

import io.realm.Realm;

/**
 * A simple {@link Fragment} subclass.
 */
public class SalvarFragment extends Fragment {
    public EditText etNome;
    public EditText etNumero;
    public Button btSalvar;

    public SalvarFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_salvar, container, false);

        etNome = view.findViewById(R.id.etNome);
        etNumero = view.findViewById(R.id.etNumero);
        btSalvar = view.findViewById(R.id.btSalvar);
        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        btSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnSalvar();
            }
        });
    }

    public void btnSalvar(){
        Realm realm = Realm.getDefaultInstance();
        realm.beginTransaction();
        Usuario usuario = realm.createObject(Usuario.class);
        usuario.setNome(etNome.getText().toString());
        usuario.setNumero(etNumero.getText().toString());
        realm.commitTransaction();
        realm.close();
    }
}
