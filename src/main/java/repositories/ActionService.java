package repositories;

import controllers.DataLoader;
import models.Citizen;
import models.Cyclist;
import models.Dog;

import java.util.stream.Stream;

public class ActionService {

    public static void execute(String... args){
        ServiceMethods serviceMethods = args.length > 2 ? new ServiceMethods(getObjects(args[0]), Integer.parseInt(args[2]))
                : new ServiceMethods(getObjects(args[0]));
        serviceMethods.print_objects(Integer.parseInt(args[1]));
    }

    private static Stream getObjects(String path){
        if (path.contains("ludzie"))
            return DataLoader.loadObjectsFromFile(Citizen.class, path);
        else if (path.contains("rowerzysci"))
            return DataLoader.loadObjectsFromFile(Cyclist.class, path);
        else
            return DataLoader.loadObjectsFromFile(Dog.class, path);
    }

}