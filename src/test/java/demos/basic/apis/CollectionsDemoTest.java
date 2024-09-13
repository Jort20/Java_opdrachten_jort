package demos.basic.apis;

import demos.basic.apis.CollectionsDemo;
import org.junit.jupiter.api.Test;

class CollectionsDemoTest {

    @Test
    void mapOperations() {
        CollectionsDemo cd = new CollectionsDemo();
        cd.mapOperations();
    }

    @Test
    void toStringTest() {
        CollectionsDemo cd = new CollectionsDemo();
        cd.equalsAndHashCode();
    }
}