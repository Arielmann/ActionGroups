package ariel.actiongroups;

import org.junit.rules.MethodRule;
import org.junit.runners.model.FrameworkMethod;
import org.junit.runners.model.Statement;

public class RulesTest implements MethodRule {
    @Override
    public Statement apply(Statement base, FrameworkMethod method, Object target) {
        final String className = method.getMethod().getDeclaringClass().getSimpleName();
        final String methodName = method.getName();
        return new Statement() {
            @Override
            public void evaluate() throws Throwable {
                System.out.println(methodName);
                System.out.println(className);


            }
        };
    }
}
