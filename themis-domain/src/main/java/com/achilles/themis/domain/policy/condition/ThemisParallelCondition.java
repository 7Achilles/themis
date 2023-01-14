//package com.achilles.themis.domain.policy.condition;
//
//import com.achilles.themis.domain.policy.ThemisExecutable;
//import com.achilles.themis.domain.policy.actuator.ThemisBaseActuator;
//import com.achilles.themis.domain.policy.config.ThreadPool;
//
//import java.util.List;
//import java.util.concurrent.CountDownLatch;
//
//public class ThemisParallelCondition extends ThemisCondition{
//    @Override
//    protected String doExecute(ThemisBaseActuator actuator) throws Exception {
//
//        List<ThemisExecutable> executes = getExecutes();
//
//        CountDownLatch latch = new CountDownLatch(executes.size());
//
//        for(ThemisExecutable execute : executes){
//            ThreadPool.addTask(()->{
//                try {
//                    execute.execute(actuator);
//                    latch.countDown();
//                } catch (Exception e) {
//                    throw new RuntimeException(e);
//                }
//            });
//        }
//        latch.await();
//        return null;
//    }
//
//}
