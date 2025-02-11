package com.kelsos.mbrc.cache;

import com.kelsos.mbrc.annotations.Repeat;
import com.kelsos.mbrc.dto.player.PlayState;
import com.kelsos.mbrc.dto.player.Shuffle;
import com.kelsos.mbrc.dto.player.Volume;

public class PlayerCacheImpl implements PlayerCache {
  private Shuffle shuffle;
  private Volume volume;
  private PlayState playState;
  private boolean mute;
  @Repeat.Mode private String repeat;

  @Override
  public Shuffle getShuffle() {
    return shuffle;
  }

  @Override
  public void setShuffle(Shuffle shuffle) {
    this.shuffle = shuffle;
  }

  @Override
  public Volume getVolume() {
    return volume;
  }

  @Override
  public void setVolume(Volume volume) {
    this.volume = volume;
  }

  @Override
  public PlayState getPlayState() {
    return playState;
  }

  @Override
  public void setPlayState(PlayState playState) {
    this.playState = playState;
  }

  @Override
  public boolean isMute() {
    return mute;
  }

  @Override
  public void setMute(boolean mute) {
    this.mute = mute;
  }

  @Override
  @Repeat.Mode public String getRepeat() {
    return repeat;
  }

  @Override
  public void setRepeat(@Repeat.Mode String repeat) {
    this.repeat = repeat;
  }
}
