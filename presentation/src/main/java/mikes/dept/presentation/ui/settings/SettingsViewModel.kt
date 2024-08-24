package mikes.dept.presentation.ui.settings

import androidx.lifecycle.ViewModel
import mikes.dept.presentation.ui.core.IViewModel
import javax.inject.Inject

interface SettingsViewModel : IViewModel

class SettingsViewModelImpl @Inject constructor() : ViewModel(), SettingsViewModel
