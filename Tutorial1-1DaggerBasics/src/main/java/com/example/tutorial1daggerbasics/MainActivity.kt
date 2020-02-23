package com.example.tutorial1daggerbasics

import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.tutorial1daggerbasics.model.MyExample
import java.util.*
import javax.inject.Inject

/*
    HOW DAGGER WORKS:

    1- Provider<T> interface has T get() method which provides object to be injected

    public interface Provider<T> {

        /**
         * Provides a fully-constructed and injected instance of {@code T}.
         *
         * @throws RuntimeException if the injector encounters an error while
         *  providing an instance. For example, if an injectable member on
         *  {@code T} throws an exception, the injector may wrap the exception
         *  and throw it to the caller of {@code get()}. Callers should not try
         *  to handle such exceptions as the behavior may vary across injector
         *  implementations and even different configurations of the same injector.
         */
        T get();
    }

    2- Factory<T> extends Provider <T> interface
 */

/*

    MODULE OBJECT FACTORIES:

    3- For each object inside module there is one XModule_YObjFactory class is created

    public final class ApplicationModule_ProvideMyExampleFactory implements Factory<MyExample> {

        private final ApplicationModule module;

        public ApplicationModule_ProvideMyExampleFactory(ApplicationModule module) {
            this.module = module;
        }

        // 🔥 This method returns object from ApplicationModule's @Provides method and
        // 🔥 called by DaggerApplicationComponent's injectMainActivity() method
        @Override
        public MyExample get() {
         return provideMyExample(module);
        }

        public static ApplicationModule_ProvideMyExampleFactory create(ApplicationModule module) {
         return new ApplicationModule_ProvideMyExampleFactory(module);
        }

        // 🔥 Called by DaggerApplicationComponent and calls ApplicationModule's provide method
        public static MyExample provideMyExample(ApplicationModule instance) {
            return Preconditions.checkNotNull(instance.provideMyExample(), "Cannot return null from a non-@Nullable @Provides method");
        }
    }

    3A- create(ApplicationModule module) method creates this Provider implementation in DaggerAApplicationComponent
    and passes ApplicationModule to this class.

    3B- This class calls provideMyExample(ApplicationModule instance) to create object to be injected when it's get():T method is called
 */

/*
    DAGGER COMPONENTS:

    public final class DaggerApplicationComponent implements ApplicationComponent {
        private Provider<MyExample> provideMyExampleProvider;

        private DaggerApplicationComponent(ApplicationModule applicationModuleParam) {

        initialize(applicationModuleParam);
        }

        public static Builder builder() {
            return new Builder();
        }

        // 🔥 Creates ApplicationComponent
        public static ApplicationComponent create() {
            return new Builder().build();
        }

        // 🔥🔥🔥 Passes applicationModule to Provider<MyExample>
        @SuppressWarnings("unchecked")
        private void initialize(final ApplicationModule applicationModuleParam) {
            this.provideMyExampleProvider =
                DoubleCheck.provider(ApplicationModule_ProvideMyExampleFactory.create(applicationModuleParam));
        }

        // 🔥🔥 Method of ApplicationComponent inject(mainActivity: MainActivity) to get injection point
        @Override
        public void inject(MainActivity mainActivity) {
            injectMainActivity(mainActivity);}

        // 🔥🔥 Object in mainActivity is injected via MainActivity_MembersInjector method
        private MainActivity injectMainActivity(MainActivity instance) {
            MainActivity_MembersInjector.injectMyExample(instance, provideMyExampleProvider.get());
            return instance;
        }

        public static final class Builder {
            private ApplicationModule applicationModule;

            private Builder() {
            }

            public Builder applicationModule(ApplicationModule applicationModule) {
              this.applicationModule = Preconditions.checkNotNull(applicationModule);
              return this;
            }

            public ApplicationComponent build() {
              if (applicationModule == null) {
                this.applicationModule = new ApplicationModule();
              }
              return new DaggerApplicationComponent(applicationModule);
            }
        }
    }

 */



/**
 * This tutorial displays that injections through a application with a scope live as long as app is alive
 */
class MainActivity : AppCompatActivity() {


    /*
        This is a singleton object, MainActivity injects same object after device is rotated!
        it's a singleton object if and only it's in a Application level module
        and annotated with @Singleton or any scope
     */
    @Inject
    lateinit var myExample: MyExample

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        (application as MyApplication)
                .applicationComponent
                .inject(this@MainActivity)

        findViewById<TextView>(R.id.tv_date).text = Date(myExample.date).toString()


        Toast.makeText(this, "MyExample: $myExample", Toast.LENGTH_SHORT).show()
    }
}