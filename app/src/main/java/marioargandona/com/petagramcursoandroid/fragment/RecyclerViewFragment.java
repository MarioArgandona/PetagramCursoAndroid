package marioargandona.com.petagramcursoandroid.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import marioargandona.com.petagramcursoandroid.R;
import marioargandona.com.petagramcursoandroid.adapter.MascotaAdapter;
import marioargandona.com.petagramcursoandroid.entidades.Mascota;


public class RecyclerViewFragment extends Fragment {

    public ArrayList<Mascota> mascotas;
    public RecyclerView listaMascotas;
    public MascotaAdapter adapter;
    public Integer likesRecibidos = 0;
    public TextView tvLikes;
    public TextView tvNombreMascota;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //return super.onCreateView(inflater, container, savedInstanceState);
        View v = inflater.inflate(R.layout.fragment_recycler_view , container , false);

        listaMascotas = (RecyclerView)v.findViewById(R.id.rvMascota);
        tvNombreMascota = (TextView) listaMascotas.findViewById(R.id.tvNombreMascota);
        tvLikes = (TextView)listaMascotas.findViewById(R.id.tvLikesMascota);

        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        llm.setOrientation(LinearLayoutManager.VERTICAL);

        listaMascotas.setLayoutManager(llm);

        iniciaListaMascotas();
        iniciaAdapterMascotas();

        return v;
    }


    private void iniciaListaMascotas()
    {
        mascotas = new ArrayList<Mascota>();
        mascotas.add(new Mascota("Spark"    , 0     , R.drawable.mascota1));
        mascotas.add(new Mascota("Coffee"   , 0     , R.drawable.mascota2));
        mascotas.add(new Mascota("Kaiser"   , 0     , R.drawable.mascota3));
        mascotas.add(new Mascota("Shamuu"   , 0     , R.drawable.mascota4));
        mascotas.add(new Mascota("Bingo"    , 0     , R.drawable.mascota5));
    }



    private void iniciaAdapterMascotas()
    {
        adapter = new MascotaAdapter(mascotas,getActivity());
        listaMascotas.setAdapter(adapter);
    }
}
