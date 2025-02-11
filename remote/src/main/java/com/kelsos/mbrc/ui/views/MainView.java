package com.kelsos.mbrc.ui.views;

import android.graphics.Bitmap;

import com.kelsos.mbrc.annotations.Repeat;
import com.kelsos.mbrc.annotations.Shuffle;
import com.kelsos.mbrc.domain.TrackPosition;
import com.kelsos.mbrc.dto.player.PlayState;
import com.kelsos.mbrc.dto.track.TrackInfo;
import com.kelsos.mbrc.enums.LfmStatus;

public interface MainView {
  void updateCover(Bitmap bitmap);

  void updateShuffle(@Shuffle.State String state);

  void updateRepeat(@Repeat.Mode String mode);

  void updateScrobbling(boolean enabled);

  void updateLoved(LfmStatus status);

  void updateVolume(int volume);

  void updatePlayState(PlayState playstate);

  void updateMute(boolean enabled);

  void updatePosition(TrackPosition position);

  int getCurrentProgress();

  void setStoppedState();

  void updateTrackInfo(TrackInfo trackInfo);

}
