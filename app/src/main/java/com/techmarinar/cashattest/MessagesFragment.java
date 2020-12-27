package com.techmarinar.cashattest;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

public class MessagesFragment extends Fragment {


    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PAGE = "ARG_PAGE";

    //var to capture the data that sent to the fragment through the bundle
    private int mPage;

    public MessagesFragment() {
        // Required empty public constructor
    }

    public static MessagesFragment newInstance(int page) {
        //new instance
        MessagesFragment fragment = new MessagesFragment();

        //new bundle to send data with the fragment
        Bundle args = new Bundle();
        args.putInt(ARG_PAGE, page);

        //setting argument
        fragment.setArguments(args);

        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mPage = getArguments().getInt(ARG_PAGE);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_page, container, false);

    }

    @Override
    public void onViewCreated(View view,Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        TextView textView = (TextView) view.findViewById(R.id.mtext_test);
        textView.setText("Fragment #" + mPage);
    }
}