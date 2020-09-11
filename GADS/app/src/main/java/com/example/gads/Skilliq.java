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
import com.example.gads.models.skill_iq;
import com.example.gads.networkapi.NetworkAPI;
import com.example.gads.networkapi.retrofit_api;
import com.example.gads.ui.main.skilladapter;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class Skilliq extends Fragment {

    public Skilliq(){}

    RecyclerView RR_View;
    ArrayList<skill_iq> iq_top;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_skilliq, container,false);

        RR_View = v.findViewById(R.id.skills_list);
        RR_View.setHasFixedSize(true);
        iq_top = new ArrayList<>();

        retrofit_api myConnection = NetworkAPI.GET_Base_url().create(retrofit_api.class);

        Call<List<skill_iq>> request = myConnection.getTop_SkillIQ_learners();
        request.enqueue(new Callback<List<skill_iq>>() {
            @Override
            public void onResponse(Call<List<skill_iq>> call, Response<List<skill_iq>> response) {
                if(!response.isSuccessful()){
                    return;
                }

                iq_top = new ArrayList<>(response.body());
                RR_View.setAdapter(new skilladapter(iq_top,getContext()));
                LinearLayoutManager lyman = new LinearLayoutManager(getContext());

                RR_View.setLayoutManager(lyman);

            }

            @Override
            public void onFailure(Call<List<skill_iq>> call, Throwable t) {
                Toast.makeText(getActivity(), "Failed", Toast.LENGTH_SHORT).show();
            }
        });



        return RR_View;
    }

    private ArrayList<skill_iq> iq_data(){
        iq_top = new ArrayList<>();

        retrofit_api myConnection = NetworkAPI.GET_Base_url().create(retrofit_api.class);

       Call<List<skill_iq>> request = myConnection.getTop_SkillIQ_learners();
       request.enqueue(new Callback<List<skill_iq>>() {
           @Override
           public void onResponse(Call<List<skill_iq>> call, Response<List<skill_iq>> response) {
               if(!response.isSuccessful()){
                   return;
               }

               iq_top = new ArrayList<>(response.body());
           }

           @Override
           public void onFailure(Call<List<skill_iq>> call, Throwable t) {
               Toast.makeText(getActivity(), "Failed", Toast.LENGTH_SHORT).show();
           }
       });
        return iq_top;

    }
}