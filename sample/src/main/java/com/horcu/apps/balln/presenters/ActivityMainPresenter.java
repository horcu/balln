package com.horcu.apps.balln.presenters;

import android.content.Context;

import com.horcu.apps.balln.models.Game;
import com.horcu.apps.balln.services.WeeklySchedule;
import com.horcu.apps.balln.views.ListingsView;

import java.util.ArrayList;

import retrofit.RestAdapter;
import rx.Observable;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class ActivityMainPresenter implements Observer<Game> {
    private static final String NFL_WEEKLY_SCHEDULE_API = "http://api.sportradar.us/nfl-t1/2014/REG";

    private final WeeklySchedule service;
    private final ListingsView<Game> view;
    private Context context;
    private ArrayList<Game> games = null;

    public ActivityMainPresenter(final WeeklySchedule service, final ListingsView<Game> view, Context context) {
        this.service = service;
        this.view = view;
        this.context = context;

    }

    public static ActivityMainPresenter create(final ListingsView<Game> view ,Context context) {
        final WeeklySchedule service = ActivityMainPresenter.getRestAdapter().create(WeeklySchedule.class);
        return new ActivityMainPresenter(service, view, context);
    }

    private static RestAdapter getRestAdapter() {
        return new RestAdapter.Builder()
                .setLogLevel(RestAdapter.LogLevel.FULL)
                .setEndpoint(NFL_WEEKLY_SCHEDULE_API)
                .build();
    }

    public void getSchedule(final String week, boolean forceApi) {
        try {
            //TRY TO GET TEH SCHEDULE FROM THE CACHE THEN THE DB THEN THE API.. IN THAT ORDER

            if(!forceApi) {
                //get from the raw file .. this will eventuslly be second resort. for now its the first

                if(true) {


                }
                else {


                    //get from db here
                    getGamesDb(week)
                            .subscribeOn(Schedulers.newThread())
                            .observeOn(AndroidSchedulers.mainThread())
                            .subscribe(this);
                }
            }
            else
            {
                //get from the api here
                this.service.getGames(week)
                        .subscribeOn(Schedulers.newThread())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(this);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }



    private Observable<Game> getGamesDb(String week){
       return null;
    }

    @Override
    public void onCompleted() {
    }

    @Override
    public void onError(final Throwable exception) {
        this.view.toast(exception.getMessage());
    }

    @Override
    public void onNext(final Game game) {
        this.view.clearItems();
        this.view.addItem(game);
    }
}
