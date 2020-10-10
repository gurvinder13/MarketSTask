package com.example.marketstask.utils;

import io.reactivex.Scheduler;

public interface ScheduleProvider {

    Scheduler computation();

    Scheduler io();

    Scheduler ui();

}
