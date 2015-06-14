package es.sergiomartinez.basecleanarchitecture.anotations;

/**
 * Created by Sergio Martinez Rodriguez
 * Date 13/6/15.
 */
import java.lang.annotation.Retention;
import javax.inject.Qualifier;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Qualifier @Retention(RUNTIME)
public @interface RetrofitLog {
}