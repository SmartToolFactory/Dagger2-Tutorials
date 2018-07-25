package zorail.rohan.com.subcomponent.scope;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Scope;

/**
 * Created by zorail on 22-May-17.
 */
@Scope
@Documented
@Retention(RetentionPolicy.RUNTIME)
public @interface UserScope {
}
