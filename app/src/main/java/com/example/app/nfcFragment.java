package com.example.app;

import android.view.LayoutInflater;
import android.content.Context;
import android.content.SharedPreferences;
import android.widget.VideoView;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import static com.example.app.MainActivity.nfc_discovered;


import androidx.fragment.app.Fragment;

public class nfcFragment extends Fragment {

    /**
     * Called when sample is created. Displays generic UI with welcome text.
     */
    private VideoView videoView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_nfc, container, false);
        SharedPreferences sharedPreferences = getActivity().getSharedPreferences("NFC Tag", Context.MODE_PRIVATE);
        String UID = sharedPreferences.getString("key", "00000000");
        Log.d("Shared_preference", UID);

        videoView = view.findViewById(R.id.videoView);
        int resourceId;

        if (nfc_discovered) {
            resourceId = R.raw.nfc_video;
            String videoPath = "android.resource://" + getActivity().getPackageName() + "/" + resourceId;
            videoView.setVideoURI(Uri.parse(videoPath));

            // Start playing the video
            videoView.start();
            nfc_discovered=false;
        }
        else {
            resourceId = R.raw.black;
            String videoPath = "android.resource://" + getActivity().getPackageName() + "/" + resourceId;
            videoView.setVideoURI(Uri.parse(videoPath));

            // Start playing the video
            videoView.start();
            nfc_discovered=false;
        }
        return view;
    }

    @Override
    public void onPause() {
        super.onPause();
        // Pause video if it's playing
        if (videoView.isPlaying() && nfc_discovered) {
            videoView.pause();
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        // Resume video if it's paused
        if (!videoView.isPlaying() && nfc_discovered) {
            videoView.start();
        }
    }
}