package zorail.rohan.com.subcomponent.component;


import dagger.Subcomponent;
import zorail.rohan.com.subcomponent.MainActivity;
import zorail.rohan.com.subcomponent.SecondActivity;
import zorail.rohan.com.subcomponent.SubComponentBuilder;
import zorail.rohan.com.subcomponent.module.NetModule;
import zorail.rohan.com.subcomponent.scope.UserScope;

/**
 * Created by zorail on 22-May-17.
 */
@UserScope
@Subcomponent(modules = NetModule.class)
public interface NetComponent {
    void inject(MainActivity mainActivity);
    void inject(SecondActivity secondActivity);
    @Subcomponent.Builder
    interface Builder extends SubComponentBuilder<NetComponent> {
        Builder netModule(NetModule netModule);
    }
}

