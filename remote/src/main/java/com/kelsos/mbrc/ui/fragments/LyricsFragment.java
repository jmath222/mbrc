package com.kelsos.mbrc.ui.fragments;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.inject.Inject;
import com.kelsos.mbrc.R;
import com.kelsos.mbrc.adapters.LyricsAdapter;
import com.kelsos.mbrc.presenters.LyricsPresenter;
import com.kelsos.mbrc.ui.views.LyricsView;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import roboguice.fragment.RoboFragment;

public class LyricsFragment extends RoboFragment implements LyricsView {

  @Bind(R.id.lyrics_recycler_view)
  RecyclerView recyclerView;
  @Inject
  private LyricsAdapter adapter;
  @Inject private LyricsPresenter presenter;

  @Override
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
  }

  @Override
  public void onViewCreated(View view, Bundle savedInstanceState) {
    super.onViewCreated(view, savedInstanceState);
    presenter.bind(this);
    recyclerView.setHasFixedSize(true);
    RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
    recyclerView.setLayoutManager(layoutManager);
    recyclerView.setAdapter(adapter);
  }

  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container,
                           Bundle savedInstanceState) {
    final View view = inflater.inflate(R.layout.ui_fragment_lyrics, container, false);
    ButterKnife.bind(this, view);
    return view;
  }

  @Override public void onPause() {
    super.onPause();
    presenter.onPause();
  }

  @Override public void onResume() {
    super.onResume();
    presenter.onResume();
  }

  @Override
  public void updateLyrics(List<String> lyrics) {
    adapter.updateData(lyrics);
  }
}
