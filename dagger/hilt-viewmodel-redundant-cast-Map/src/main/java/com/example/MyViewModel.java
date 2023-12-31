package com.example;

import androidx.lifecycle.ViewModel;
import javax.inject.Inject;
import dagger.hilt.android.lifecycle.HiltViewModel;

@HiltViewModel
public class MyViewModel extends ViewModel {
	@Inject MyViewModel() {
	}
}
