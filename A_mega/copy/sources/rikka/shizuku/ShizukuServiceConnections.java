package rikka.shizuku;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import rikka.shizuku.Shizuku;

class ShizukuServiceConnections {
    private static final Map<String, ShizukuServiceConnection> CACHE = Collections.synchronizedMap(new HashMap());

    ShizukuServiceConnections() {
    }

    static ShizukuServiceConnection get(Shizuku.UserServiceArgs userServiceArgs) {
        return CACHE.get(userServiceArgs.tag != null ? userServiceArgs.tag : userServiceArgs.componentName.getClassName());
    }

    static ShizukuServiceConnection getOrCreate(Shizuku.UserServiceArgs userServiceArgs) {
        String className = userServiceArgs.tag != null ? userServiceArgs.tag : userServiceArgs.componentName.getClassName();
        Map<String, ShizukuServiceConnection> map = CACHE;
        ShizukuServiceConnection shizukuServiceConnection = map.get(className);
        if (shizukuServiceConnection != null) {
            return shizukuServiceConnection;
        }
        ShizukuServiceConnection shizukuServiceConnection2 = new ShizukuServiceConnection(userServiceArgs);
        map.put(className, shizukuServiceConnection2);
        return shizukuServiceConnection2;
    }
}
