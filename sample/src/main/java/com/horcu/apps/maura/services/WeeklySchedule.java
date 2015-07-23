package com.horcu.apps.maura.services;

import com.horcu.apps.maura.models.Game;

import retrofit.http.GET;
import retrofit.http.Path;
import rx.Observable;

public interface WeeklySchedule {

//    @GET("/users/{user}")
//    Observable<User> getUser(@Path("user") final String user);

    @GET("/{week}/schedule.json?api_key=qaywxb79h8jdapzffuqh5jh7")
    Observable<Game> getGames(@Path("week") final String week);



}
