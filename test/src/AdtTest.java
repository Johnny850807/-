import dsa.adt.*;
import org.junit.Test;
import practices.waterball.adt.WbAdtFactory;

import static org.junit.Assert.*;

@SuppressWarnings("ALL")
public class AdtTest {
    AdtFactory adtFactory = new WbAdtFactory();  // replace the factory with yours

    @Test
    public void testStack(){
        assertStack(adtFactory.createArrayStack(1000), 1000, true);
        assertStack(adtFactory.createLinkedListStack(), 1000, false);
    }


    private void assertStack(SingleStack stack, int runSize, boolean hasSizeLimit){
        assertTrue(stack.isEmpty());

        for (int i = 1; i <= runSize; i ++)
            stack.push(i);

        assertTrue(!hasSizeLimit ^ stack.isFull());

        for (int i = runSize; i >= 1; i --)
            assertEquals(i, stack.pop());
    }

    @Test
    public void testMultipleStacks(){
        assertMultipleStack(adtFactory.createDoubleStack(1000), 500, 2);
        assertMultipleStack(adtFactory.createMultipleStack(10, 1000), 100, 10);
    }


    private void assertMultipleStack(MultipleStack stack, int runEachStackSize, int stackCount){
        for (int n = 0; n < stackCount; n ++)
        {
            assertTrue(stack.isEmpty(n));

            for (int i = 1; i <= runEachStackSize; i ++)
                stack.push(n, i);
        }

        for (int n = 0; n < stackCount; n ++)
            assertTrue(stack.isFull(n));

        for (int n = 0; n < stackCount; n ++)
        {
            for (int i = runEachStackSize; i >= 1; i --)
                assertEquals(i, stack.pop(n));
        }
    }

    @Test
    public void testQueues(){
        assertQueue(adtFactory.createCircularArrayQueue(1000), 1000, true);
        assertQueue(adtFactory.createSingleLinkedListQueue(), -1, false);
        assertQueue(adtFactory.createCircularLinkedListQueue(), -1, false);
    }

    private void assertQueue(Queue queue, int runSize, boolean hasSizeLimit){
        assertTrue(queue.isEmpty());

        for (int i = 1; i <= runSize; i ++)
            queue.add(i);

        assertTrue(!hasSizeLimit ^ queue.isFull());

        for (int i = 1; i <= runSize; i ++)
            assertEquals(i, queue.delete());
    }

}
