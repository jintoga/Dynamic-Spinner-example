package com.example.dat.dynamicdualspinnertest;

import com.hannesdorfmann.mosby.mvp.MvpPresenter;
import com.hannesdorfmann.mosby.mvp.MvpView;

/**
 * Created by DAT on 23-Apr-16.
 */
public interface MVPContract {
    interface View extends MvpView {

    }

    interface UserActionsListener extends MvpPresenter<View> {
    }
}
