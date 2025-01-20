import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;

@Suite
@SelectClasses({
        MonsterBehaviorTest.class,
        MonsterDesignPatternTest.class
})
public class MonsterTestSuite {
  //Test suite version yüzünden çalışmıyor.
}
