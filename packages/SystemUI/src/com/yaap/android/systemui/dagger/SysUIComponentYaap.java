package com.yaap.android.systemui.dagger;

import com.android.systemui.dagger.DefaultComponentBinder;
import com.android.systemui.dagger.DependencyProvider;
import com.android.systemui.dagger.SysUISingleton;
import com.android.systemui.dagger.SystemUIBinder;
import com.android.systemui.dagger.SysUIComponent;
import com.android.systemui.dagger.SystemUIModule;

import com.yaap.android.systemui.keyguard.KeyguardSliceProviderYaap;
import com.yaap.android.systemui.smartspace.KeyguardSmartspaceController;

import dagger.Subcomponent;

@SysUISingleton
@Subcomponent(modules = {
        DefaultComponentBinder.class,
        DependencyProvider.class,
        SystemUIBinder.class,
        SystemUIModule.class,
        SystemUIYaapModule.class})
public interface SysUIComponentYaap extends SysUIComponent {
    @SysUISingleton
    @Subcomponent.Builder
    interface Builder extends SysUIComponent.Builder {
        SysUIComponentYaap build();
    }

    /**
     * Member injection into the supplied argument.
     */
    void inject(KeyguardSliceProviderYaap keyguardSliceProviderYaap);

    @SysUISingleton
    KeyguardSmartspaceController createKeyguardSmartspaceController();
}
