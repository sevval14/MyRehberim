package com.example.loginscreen;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Home#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Home extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private ArrayList<News> newsArrayList;
    private String[] newHedaing;
    private int[] imageResourceID;
    private RecyclerView recycleview;
    private String[] headId;

    public Home() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Home.
     */
    // TODO: Rename and change types and number of parameters
    public static Home newInstance(String param1, String param2) {
        Home fragment = new Home();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        dataInitialize();
        recycleview = view.findViewById(R.id.recyclerview);
        recycleview.setLayoutManager(new LinearLayoutManager(getContext()));
        recycleview.setHasFixedSize(true);
        HaveActivtityAdapter haveActivtityAdapter = new HaveActivtityAdapter(getContext(),newsArrayList);
        recycleview.setAdapter((haveActivtityAdapter));
        haveActivtityAdapter.notifyDataSetChanged();


    }

    private void dataInitialize() {
        newsArrayList = new ArrayList<News>();

        newHedaing = new String[]{
                getString(R.string.haveDo1),
                getString(R.string.haveDo2),
                getString(R.string.haveDo3),
                getString(R.string.haveDo4),
        };

        imageResourceID = new int[]{
                R.mipmap.camp,
                R.mipmap.yesil,
                R.mipmap.lotu,
                R.mipmap.gebekse,
        };
        headId = new String[]{
                getString(R.string.head1),
                getString(R.string.head2),
                getString(R.string.head3),
                getString(R.string.head4)
        };

        for(int i=0; i<newHedaing.length;i++){
            News news = new News(newHedaing[i],headId[i],imageResourceID[i]);
            newsArrayList.add(news);
        }
    }
}