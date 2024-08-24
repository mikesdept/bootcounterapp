package mikes.dept.presentation.ui.settings

import android.view.View
import androidx.lifecycle.ViewModelProvider
import mikes.dept.presentation.R
import mikes.dept.presentation.databinding.FragmentSettingsBinding
import mikes.dept.presentation.di.SubcomponentProvider
import mikes.dept.presentation.ui.core.BaseBindingFragment

class SettingsFragment : BaseBindingFragment<SettingsViewModel, FragmentSettingsBinding>(R.layout.fragment_settings) {

    override fun initDagger(subcomponentProvider: SubcomponentProvider) = subcomponentProvider
        .provideSettingsSubcomponent()
        .inject(this)

    override fun initViewModel(viewModelProvider: ViewModelProvider): SettingsViewModel = viewModelProvider[SettingsViewModelImpl::class.java]

    override fun initViewBinding(view: View): FragmentSettingsBinding = FragmentSettingsBinding.bind(view)

    override fun setup() {}

    override fun reset() {}

}
