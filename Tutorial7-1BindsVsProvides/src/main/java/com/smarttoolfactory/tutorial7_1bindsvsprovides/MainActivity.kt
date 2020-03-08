package com.smarttoolfactory.tutorial7_1bindsvsprovides

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.smarttoolfactory.tutorial7_1bindsvsprovides.model.Logger
import javax.inject.Inject
import javax.inject.Named


/**
 * Getting interface from a concrete implementation of a dependency
 * via @Binds has better performance and less generated code than @Provides
 *
 ** ModuleWithProvides module generates the code below:
 *
 * ```
 *
 * public final class ModuleWithProvides_ProvideLoggerFactory implements Factory<Logger> {
 *
 *       private final ModuleWithProvides module;
 *
 *       private final Provider<LoggerImpl> loggerImplProvider;
 *
 *       public ModuleWithProvides_ProvideLoggerFactory(ModuleWithProvides module,
 *
 *      Provider<LoggerImpl> loggerImplProvider) {
 *          this.module = module;
 *          this.loggerImplProvider = loggerImplProvider;
 *      }
 *
 *       @Override
 *       public Logger get() {
 *          return provideLogger(module, loggerImplProvider.get());
 *       }
 *
 *       public static ModuleWithProvides_ProvideLoggerFactory create(ModuleWithProvides module,
 *       Provider<LoggerImpl> loggerImplProvider) {
 *          return new ModuleWithProvides_ProvideLoggerFactory(module, loggerImplProvider);
 *       }
 *
 *       public static Logger provideLogger(ModuleWithProvides instance, LoggerImpl loggerImpl) {
 *          return Preconditions.checkNotNull(instance.provideLogger(loggerImpl), "Cannot return null from a non-@Nullable @Provides method");
 *       }
 *   }
 *
 *
 * ```
 *
 * ModuleWithBinds generates NOTHING
 */
class MainActivity : AppCompatActivity() {

    /**
     * Injected from ModuleWithProvides with @Provides
     */
    @Inject
    @Named("provides")
    lateinit var loggerProvided: Logger

    /**
     * Injected from ModuleWithBinds with @Binds
     */
    @Inject
    @Named("binds")
    lateinit var loggerBound: Logger

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        (application as MyApplication).appComponent.inject(this)

        findViewById<TextView>(R.id.tvInfo).text =
                "Provide logger: ${loggerProvided.hashCode()}\n" +
                        "Bound logger: ${loggerBound.hashCode()}"

    }
}
