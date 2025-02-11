package com.kelsos.mbrc.interactors;

import com.google.inject.Inject;
import com.kelsos.mbrc.annotations.PlayerAction;
import com.kelsos.mbrc.dto.BaseResponse;
import com.kelsos.mbrc.services.api.PlayerService;

import rx.Single;

public class PlayerInteractorImpl implements PlayerInteractor {
  @Inject private PlayerService api;
  @Override
  public Single<BaseResponse> execute(@PlayerAction.Action String action) {
    return api.performPlayerAction(action);
  }
}
