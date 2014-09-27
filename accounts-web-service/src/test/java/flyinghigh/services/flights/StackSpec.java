package flyinghigh.services.flights;

import com.insightfullogic.lambdabehave.JunitSuiteRunner;
import org.junit.runner.RunWith;

import java.util.Stack;

import static com.insightfullogic.lambdabehave.Suite.describe;

/**
 * Created by john on 26/09/2014.
 */
@RunWith(JunitSuiteRunner.class)
public class StackSpec {
    {

        Stack<Integer> stack = new Stack<>();

        describe("a stack", it -> {

            it.isSetupWith(stack::clear);

            it.isConcludedWith(stack::clear);

            it.should("be empty when created", expect -> {
                expect.that(stack).isEmpty();
            });
        });
    }
}


