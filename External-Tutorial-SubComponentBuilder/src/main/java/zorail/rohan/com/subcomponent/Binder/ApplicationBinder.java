package zorail.rohan.com.subcomponent.Binder;

import dagger.Binds;
import dagger.Module;
import dagger.multibindings.IntoMap;
import zorail.rohan.com.subcomponent.Key.SubComponentKey;
import zorail.rohan.com.subcomponent.SubComponentBuilder;
import zorail.rohan.com.subcomponent.component.NetComponent;

/**
 * Created by zorail on 22-May-17.
 */
@Module(subcomponents = {NetComponent.class})
public abstract class ApplicationBinder {
    @Binds
    @IntoMap
    @SubComponentKey(NetComponent.Builder.class)
    public abstract SubComponentBuilder myActivity(NetComponent.Builder impl);
}
