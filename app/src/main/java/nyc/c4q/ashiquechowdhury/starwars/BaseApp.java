package nyc.c4q.ashiquechowdhury.starwars;

import android.app.Application;

import nyc.c4q.ashiquechowdhury.starwars.deps.DaggerDepsComponent;
import nyc.c4q.ashiquechowdhury.starwars.network.NetModule;

public class BaseApp extends Application {
    public DaggerDepsComponent.Builder depsBuilder;

    @Override
    public void onCreate() {
        super.onCreate();

        depsBuilder = DaggerDepsComponent.builder().netModule(new NetModule("http://swapi.co/api/"));
    }

    public DaggerDepsComponent.Builder getDepsBuilder() {
        return depsBuilder;
    }
}
