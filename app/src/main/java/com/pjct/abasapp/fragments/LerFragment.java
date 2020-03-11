package com.pjct.abasapp.fragments;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.pjct.abasapp.R;
import com.pjct.abasapp.Usuario;

import io.realm.Realm;
import io.realm.RealmQuery;

/**
 * A simple {@link Fragment} subclass.
 */
public class LerFragment extends Fragment {
    public TextView tvResultadoNome;
    public EditText etPesquisa;
    public Button btBusca;

    public LerFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_ler, container, false);
        tvResultadoNome = view.findViewById(R.id.tvResultadoNome);
        etPesquisa = view.findViewById(R.id.etPesquisa);
        btBusca = view.findViewById(R.id.btBusca);

        return (view);
    }

    @Override
    public void onResume() {
        super.onResume();
        btBusca.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnBusca();
            }
        });
    }
    public void btnBusca(){
        Realm realm = Realm.getDefaultInstance();
        Usuario query=realm.where(Usuario.class).equalTo("nome",etPesquisa.getText().toString()).findFirst();
        tvResultadoNome.setText("Nome: "+query.nome+"\nTelefone: "+query.numero);
    }
}
