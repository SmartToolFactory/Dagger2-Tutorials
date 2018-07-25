package zorail.rohan.com.subcomponent.component;

import android.app.Application;

import java.util.Map;

import javax.inject.Provider;
import javax.inject.Singleton;

import dagger.Component;
import zorail.rohan.com.subcomponent.Binder.ApplicationBinder;
import zorail.rohan.com.subcomponent.SubComponentBuilder;
import zorail.rohan.com.subcomponent.module.AppModule;

/**
 * Created by zorail on 22-May-17.
 */
@Singleton
@Component(modules ={ AppModule.class, ApplicationBinder.class})
public interface AppComponent {
   Map<Class<?>,Provider<SubComponentBuilder>> subcomponentBuilders();
}
