package com.kelsos.mbrc.di.modules;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.inject.AbstractModule;
import com.google.inject.Singleton;
import com.kelsos.mbrc.cache.PlayerCache;
import com.kelsos.mbrc.cache.PlayerCacheImpl;
import com.kelsos.mbrc.cache.TrackCache;
import com.kelsos.mbrc.cache.TrackCacheImpl;
import com.kelsos.mbrc.di.providers.ApiServiceProvider;
import com.kelsos.mbrc.di.providers.BusProvider;
import com.kelsos.mbrc.di.providers.ObjectMapperProvider;
import com.kelsos.mbrc.di.providers.OkHttpClientProvider;
import com.kelsos.mbrc.di.providers.RetrofitProvider;
import com.kelsos.mbrc.interactors.MuteInteractor;
import com.kelsos.mbrc.interactors.MuteInteractorImpl;
import com.kelsos.mbrc.interactors.NowPlayingListInteractor;
import com.kelsos.mbrc.interactors.NowPlayingListInteractorImpl;
import com.kelsos.mbrc.interactors.PlayerInteractor;
import com.kelsos.mbrc.interactors.PlayerInteractorImpl;
import com.kelsos.mbrc.interactors.PlayerStateInteractor;
import com.kelsos.mbrc.interactors.PlayerStateInteractorImpl;
import com.kelsos.mbrc.interactors.RepeatInteractor;
import com.kelsos.mbrc.interactors.RepeatInteractorImpl;
import com.kelsos.mbrc.interactors.ShuffleInteractor;
import com.kelsos.mbrc.interactors.ShuffleInteractorImpl;
import com.kelsos.mbrc.interactors.TrackCoverInteractor;
import com.kelsos.mbrc.interactors.TrackCoverInteractorImpl;
import com.kelsos.mbrc.interactors.TrackInfoInteractor;
import com.kelsos.mbrc.interactors.TrackInfoInteractorImpl;
import com.kelsos.mbrc.interactors.TrackLyricsInteractor;
import com.kelsos.mbrc.interactors.TrackLyricsInteractorImpl;
import com.kelsos.mbrc.interactors.TrackPositionInteractor;
import com.kelsos.mbrc.interactors.TrackPositionInteractorImpl;
import com.kelsos.mbrc.interactors.TrackRatingInteractor;
import com.kelsos.mbrc.interactors.TrackRatingInteractorImpl;
import com.kelsos.mbrc.models.MainViewModel;
import com.kelsos.mbrc.models.MainViewModelImpl;
import com.kelsos.mbrc.presenters.LyricsPresenter;
import com.kelsos.mbrc.presenters.LyricsPresenterImpl;
import com.kelsos.mbrc.presenters.MainViewPresenter;
import com.kelsos.mbrc.presenters.MiniControlPresenterImpl;
import com.kelsos.mbrc.presenters.interfaces.IMainViewPresenter;
import com.kelsos.mbrc.presenters.MiniControlPresenter;
import com.kelsos.mbrc.repository.NowPlayingRepository;
import com.kelsos.mbrc.repository.NowPlayingRepositoryImpl;
import com.kelsos.mbrc.repository.PlayerRepository;
import com.kelsos.mbrc.repository.PlayerRepositoryImpl;
import com.kelsos.mbrc.repository.TrackRepository;
import com.kelsos.mbrc.repository.TrackRepositoryImpl;
import com.kelsos.mbrc.services.api.LibraryService;
import com.kelsos.mbrc.services.api.NowPlayingService;
import com.kelsos.mbrc.services.api.PlayerService;
import com.kelsos.mbrc.services.api.PlaylistService;
import com.kelsos.mbrc.services.api.TrackService;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.otto.Bus;

import retrofit.Retrofit;
import roboguice.inject.ContextSingleton;

@SuppressWarnings("UnusedDeclaration") public class RemoteModule extends AbstractModule {
  public void configure() {
    bind(ObjectMapper.class).toProvider(ObjectMapperProvider.class).asEagerSingleton();
    bind(OkHttpClient.class).toProvider(OkHttpClientProvider.class).in(Singleton.class);
    bind(Retrofit.class).toProvider(RetrofitProvider.class).in(Singleton.class);
    bind(Bus.class).toProvider(BusProvider.class).in(Singleton.class);
    bind(MiniControlPresenter.class).to(MiniControlPresenterImpl.class).in(ContextSingleton.class);
    bind(IMainViewPresenter.class).to(MainViewPresenter.class).in(ContextSingleton.class);
    bind(MainViewModel.class).to(MainViewModelImpl.class).in(ContextSingleton.class);
    bind(LyricsPresenter.class).to(LyricsPresenterImpl.class).in(ContextSingleton.class);

    bind(TrackInfoInteractor.class).to(TrackInfoInteractorImpl.class);
    bind(TrackRatingInteractor.class).to(TrackRatingInteractorImpl.class);
    bind(TrackCoverInteractor.class).to(TrackCoverInteractorImpl.class);
    bind(TrackLyricsInteractor.class).to(TrackLyricsInteractorImpl.class);
    bind(TrackPositionInteractor.class).to(TrackPositionInteractorImpl.class);
    bind(PlayerInteractor.class).to(PlayerInteractorImpl.class);
    bind(ShuffleInteractor.class).to(ShuffleInteractorImpl.class);
    bind(RepeatInteractor.class).to(RepeatInteractorImpl.class);
    bind(PlayerStateInteractor.class).to(PlayerStateInteractorImpl.class);
    bind(MuteInteractor.class).to(MuteInteractorImpl.class);
    bind(NowPlayingListInteractor.class).to(NowPlayingListInteractorImpl.class);

    bind(TrackRepository.class).to(TrackRepositoryImpl.class).in(Singleton.class);
    bind(PlayerRepository.class).to(PlayerRepositoryImpl.class).in(Singleton.class);
    bind(NowPlayingRepository.class).to(NowPlayingRepositoryImpl.class).in(Singleton.class);

    bind(TrackCache.class).to(TrackCacheImpl.class).in(Singleton.class);
    bind(PlayerCache.class).to(PlayerCacheImpl.class).in(Singleton.class);

    bind(TrackService.class).toProvider(new ApiServiceProvider<>(TrackService.class)).in(Singleton.class);
    bind(PlayerService.class).toProvider(new ApiServiceProvider<>(PlayerService.class)).in(Singleton.class);
    bind(LibraryService.class).toProvider(new ApiServiceProvider<>(LibraryService.class)).in(Singleton.class);
    bind(NowPlayingService.class).toProvider(new ApiServiceProvider<>(NowPlayingService.class)).in(Singleton.class);
    bind(PlaylistService.class).toProvider(new ApiServiceProvider<>(PlaylistService.class)).in(Singleton.class);
  }
}
