package com.example.gads;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.gads.models.learner;
import com.example.gads.networkapi.NetworkAPI;
import com.example.gads.networkapi.retrofit_api;
import com.example.gads.ui.main.learneradapter;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class Learners extends Fragment {

    public Learners(){}

    RecyclerView RR_View;
    ArrayList<learner> top_learner;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_learners, container,false);

        RR_View = v.findViewById(R.id.learner_list);
        RR_View.setHasFixedSize(true);

        retrofit_api myConnection = NetworkAPI.GET_Base_url().create(retrofit_api.class);

        Call<List<learner>> request = myConnection.getTop_learners();
        request.enqueue(new Callback<List<learner>>() {
            @Override
            public void onResponse(Call<List<learner>> call, Response<List<learner>> response) {
                if(!response.isSuccessful()){
                    return;
                }

                top_learner = new ArrayList<>(response.body());
                RR_View.setAdapter(new learneradapter(top_learner,getContext()));
                LinearLayoutManager lyman = new LinearLayoutManager(getContext());

                RR_View.setLayoutManager(lyman);

            }

            @Override
            public void onFailure(Call<List<learner>> call, Throwable t) {
                Toast.makeText(getActivity(), "Failed", Toast.LENGTH_SHORT).show();
            }
        });




        return v;
    }

    private ArrayList<learner> learner_data(){
        top_learner = new ArrayList<>();
        /*top_learner.add(new learner("Mthulisi","234","Mzansi"));
        top_learner.add(new learner("Mthulisi","234","Mzansi2"));
        top_learner.add(new learner("Mthulisi","234","Mzansi3"));
        top_learner.add(new learner("Mthulisi","234","Mzansi4"));
        top_learner.add(new learner("Mthulisi","234","Mzansi5"));*/
        retrofit_api myConnection = NetworkAPI.GET_Base_url().create(retrofit_api.class);

        Call<List<learner>> request = myConnection.getTop_learners();
        request.enqueue(new Callback<List<learner>>() {
            @Override
            public void onResponse(Call<List<learner>> call, Response<List<learner>> response) {
                if(!response.isSuccessful()){
                    return;
                }

                top_learner = new ArrayList<>(response.body());
            }

            @Override
            public void onFailure(Call<List<learner>> call, Throwable t) {
                Toast.makeText(getActivity(), "Failed", Toast.LENGTH_SHORT).show();
            }
        });




        return top_learner;

    }
}