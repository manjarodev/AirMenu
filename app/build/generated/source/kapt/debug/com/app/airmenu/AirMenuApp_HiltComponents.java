package com.app.airmenu;

import androidx.hilt.lifecycle.ViewModelFactoryModules;
import com.app.airmenu.di.Modules;
import com.app.airmenu.service.JavaNotificationService_GeneratedInjector;
import com.app.airmenu.service.NotificationService_GeneratedInjector;
import com.app.airmenu.ui.HomeActivity_GeneratedInjector;
import com.app.airmenu.ui.MainActivity_GeneratedInjector;
import com.app.airmenu.ui.divisionIds.DivisionIdsViewModel_HiltModules;
import com.app.airmenu.ui.divisionIds.DivisionIds_GeneratedInjector;
import com.app.airmenu.ui.home.HomeViewModel_HiltModules;
import com.app.airmenu.ui.login.FragmentLogin_GeneratedInjector;
import com.app.airmenu.ui.login.LoginViewModel_HiltModules;
import com.app.airmenu.ui.notification.FragmentNotificationAccess_GeneratedInjector;
import com.app.airmenu.ui.notification.NotificationAccessViewModel_HiltModules;
import com.app.airmenu.ui.posIds.FragmentPosIds_GeneratedInjector;
import com.app.airmenu.ui.posIds.PosIdsViewModel_HiltModules;
import com.app.airmenu.ui.uberlogin.UberLogin_GeneratedInjector;
import dagger.Binds;
import dagger.Component;
import dagger.Module;
import dagger.Subcomponent;
import dagger.hilt.android.components.ActivityComponent;
import dagger.hilt.android.components.ActivityRetainedComponent;
import dagger.hilt.android.components.FragmentComponent;
import dagger.hilt.android.components.ServiceComponent;
import dagger.hilt.android.components.ViewComponent;
import dagger.hilt.android.components.ViewModelComponent;
import dagger.hilt.android.components.ViewWithFragmentComponent;
import dagger.hilt.android.internal.builders.ActivityComponentBuilder;
import dagger.hilt.android.internal.builders.ActivityRetainedComponentBuilder;
import dagger.hilt.android.internal.builders.FragmentComponentBuilder;
import dagger.hilt.android.internal.builders.ServiceComponentBuilder;
import dagger.hilt.android.internal.builders.ViewComponentBuilder;
import dagger.hilt.android.internal.builders.ViewModelComponentBuilder;
import dagger.hilt.android.internal.builders.ViewWithFragmentComponentBuilder;
import dagger.hilt.android.internal.lifecycle.DefaultViewModelFactories;
import dagger.hilt.android.internal.lifecycle.HiltViewModelFactory;
import dagger.hilt.android.internal.lifecycle.HiltWrapper_DefaultViewModelFactories_ActivityModule;
import dagger.hilt.android.internal.lifecycle.HiltWrapper_HiltViewModelFactory_ActivityCreatorEntryPoint;
import dagger.hilt.android.internal.lifecycle.HiltWrapper_HiltViewModelFactory_ViewModelModule;
import dagger.hilt.android.internal.managers.ActivityComponentManager;
import dagger.hilt.android.internal.managers.FragmentComponentManager;
import dagger.hilt.android.internal.managers.HiltWrapper_ActivityRetainedComponentManager_ActivityRetainedComponentBuilderEntryPoint;
import dagger.hilt.android.internal.managers.HiltWrapper_ActivityRetainedComponentManager_ActivityRetainedLifecycleEntryPoint;
import dagger.hilt.android.internal.managers.HiltWrapper_ActivityRetainedComponentManager_LifecycleModule;
import dagger.hilt.android.internal.managers.ServiceComponentManager;
import dagger.hilt.android.internal.managers.ViewComponentManager;
import dagger.hilt.android.internal.modules.ApplicationContextModule;
import dagger.hilt.android.internal.modules.HiltWrapper_ActivityModule;
import dagger.hilt.android.scopes.ActivityRetainedScoped;
import dagger.hilt.android.scopes.ActivityScoped;
import dagger.hilt.android.scopes.FragmentScoped;
import dagger.hilt.android.scopes.ServiceScoped;
import dagger.hilt.android.scopes.ViewModelScoped;
import dagger.hilt.android.scopes.ViewScoped;
import dagger.hilt.components.SingletonComponent;
import dagger.hilt.internal.GeneratedComponent;
import dagger.hilt.migration.DisableInstallInCheck;
import javax.inject.Singleton;

public final class AirMenuApp_HiltComponents {
  private AirMenuApp_HiltComponents() {
  }

  @Module(
      subcomponents = ServiceC.class
  )
  @DisableInstallInCheck
  abstract interface ServiceCBuilderModule {
    @Binds
    ServiceComponentBuilder bind(ServiceC.Builder builder);
  }

  @Module(
      subcomponents = ActivityRetainedC.class
  )
  @DisableInstallInCheck
  abstract interface ActivityRetainedCBuilderModule {
    @Binds
    ActivityRetainedComponentBuilder bind(ActivityRetainedC.Builder builder);
  }

  @Module(
      subcomponents = ActivityC.class
  )
  @DisableInstallInCheck
  abstract interface ActivityCBuilderModule {
    @Binds
    ActivityComponentBuilder bind(ActivityC.Builder builder);
  }

  @Module(
      subcomponents = ViewModelC.class
  )
  @DisableInstallInCheck
  abstract interface ViewModelCBuilderModule {
    @Binds
    ViewModelComponentBuilder bind(ViewModelC.Builder builder);
  }

  @Module(
      subcomponents = ViewC.class
  )
  @DisableInstallInCheck
  abstract interface ViewCBuilderModule {
    @Binds
    ViewComponentBuilder bind(ViewC.Builder builder);
  }

  @Module(
      subcomponents = FragmentC.class
  )
  @DisableInstallInCheck
  abstract interface FragmentCBuilderModule {
    @Binds
    FragmentComponentBuilder bind(FragmentC.Builder builder);
  }

  @Module(
      subcomponents = ViewWithFragmentC.class
  )
  @DisableInstallInCheck
  abstract interface ViewWithFragmentCBuilderModule {
    @Binds
    ViewWithFragmentComponentBuilder bind(ViewWithFragmentC.Builder builder);
  }

  @Component(
      modules = {
          ActivityRetainedCBuilderModule.class,
          ServiceCBuilderModule.class,
          ApplicationContextModule.class,
          Modules.class
      }
  )
  @Singleton
  public abstract static class SingletonC implements AirMenuApp_GeneratedInjector,
      HiltWrapper_ActivityRetainedComponentManager_ActivityRetainedComponentBuilderEntryPoint,
      ServiceComponentManager.ServiceComponentBuilderEntryPoint,
      SingletonComponent,
      GeneratedComponent {
  }

  @Subcomponent
  @ServiceScoped
  public abstract static class ServiceC implements JavaNotificationService_GeneratedInjector,
      NotificationService_GeneratedInjector,
      ServiceComponent,
      GeneratedComponent {
    @Subcomponent.Builder
    abstract interface Builder extends ServiceComponentBuilder {
    }
  }

  @Subcomponent(
      modules = {
          ActivityCBuilderModule.class,
          ViewModelCBuilderModule.class,
          DivisionIdsViewModel_HiltModules.KeyModule.class,
          HiltWrapper_ActivityRetainedComponentManager_LifecycleModule.class,
          HomeViewModel_HiltModules.KeyModule.class,
          LoginViewModel_HiltModules.KeyModule.class,
          NotificationAccessViewModel_HiltModules.KeyModule.class,
          PosIdsViewModel_HiltModules.KeyModule.class
      }
  )
  @ActivityRetainedScoped
  public abstract static class ActivityRetainedC implements ActivityRetainedComponent,
      ActivityComponentManager.ActivityComponentBuilderEntryPoint,
      HiltWrapper_ActivityRetainedComponentManager_ActivityRetainedLifecycleEntryPoint,
      GeneratedComponent {
    @Subcomponent.Builder
    abstract interface Builder extends ActivityRetainedComponentBuilder {
    }
  }

  @Subcomponent(
      modules = {
          FragmentCBuilderModule.class,
          ViewCBuilderModule.class,
          HiltWrapper_ActivityModule.class,
          HiltWrapper_DefaultViewModelFactories_ActivityModule.class,
          ViewModelFactoryModules.ActivityModule.class
      }
  )
  @ActivityScoped
  public abstract static class ActivityC implements HomeActivity_GeneratedInjector,
      MainActivity_GeneratedInjector,
      ActivityComponent,
      DefaultViewModelFactories.ActivityEntryPoint,
      HiltWrapper_HiltViewModelFactory_ActivityCreatorEntryPoint,
      FragmentComponentManager.FragmentComponentBuilderEntryPoint,
      ViewComponentManager.ViewComponentBuilderEntryPoint,
      GeneratedComponent {
    @Subcomponent.Builder
    abstract interface Builder extends ActivityComponentBuilder {
    }
  }

  @Subcomponent(
      modules = {
          DivisionIdsViewModel_HiltModules.BindsModule.class,
          HiltWrapper_HiltViewModelFactory_ViewModelModule.class,
          HomeViewModel_HiltModules.BindsModule.class,
          LoginViewModel_HiltModules.BindsModule.class,
          NotificationAccessViewModel_HiltModules.BindsModule.class,
          PosIdsViewModel_HiltModules.BindsModule.class
      }
  )
  @ViewModelScoped
  public abstract static class ViewModelC implements ViewModelComponent,
      HiltViewModelFactory.ViewModelFactoriesEntryPoint,
      GeneratedComponent {
    @Subcomponent.Builder
    abstract interface Builder extends ViewModelComponentBuilder {
    }
  }

  @Subcomponent
  @ViewScoped
  public abstract static class ViewC implements ViewComponent,
      GeneratedComponent {
    @Subcomponent.Builder
    abstract interface Builder extends ViewComponentBuilder {
    }
  }

  @Subcomponent(
      modules = {
          ViewWithFragmentCBuilderModule.class,
          ViewModelFactoryModules.FragmentModule.class
      }
  )
  @FragmentScoped
  public abstract static class FragmentC implements DivisionIds_GeneratedInjector,
      FragmentLogin_GeneratedInjector,
      FragmentNotificationAccess_GeneratedInjector,
      FragmentPosIds_GeneratedInjector,
      UberLogin_GeneratedInjector,
      FragmentComponent,
      DefaultViewModelFactories.FragmentEntryPoint,
      ViewComponentManager.ViewWithFragmentComponentBuilderEntryPoint,
      GeneratedComponent {
    @Subcomponent.Builder
    abstract interface Builder extends FragmentComponentBuilder {
    }
  }

  @Subcomponent
  @ViewScoped
  public abstract static class ViewWithFragmentC implements ViewWithFragmentComponent,
      GeneratedComponent {
    @Subcomponent.Builder
    abstract interface Builder extends ViewWithFragmentComponentBuilder {
    }
  }
}
