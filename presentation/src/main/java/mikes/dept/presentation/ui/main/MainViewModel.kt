package mikes.dept.presentation.ui.main

import androidx.lifecycle.ViewModel
import mikes.dept.presentation.ui.core.IViewModel
import javax.inject.Inject

interface MainViewModel : IViewModel

class MainViewModelImpl @Inject constructor() : ViewModel(), MainViewModel
