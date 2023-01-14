//package com.achilles.themis.domain.policy.operate.ql;
//
//import com.achilles.themis.domain.policy.ThemisExecutable;
//import com.achilles.themis.domain.policy.condition.ThemisParallelCondition;
//import com.achilles.themis.domain.policy.condition.ThemisSerialCondition;
//
//public class ThemisParallelOperator extends ThemisBaseOperator<ThemisParallelCondition>{
//
//    @Override
//    public ThemisParallelCondition build(Object[] objects) throws Exception {
//        ThemisParallelCondition themisSerialCondition = new ThemisParallelCondition();
//        themisSerialCondition.setId(ThemisOperatorHelper.createUUID());
//        for(Object o : objects){
//            themisSerialCondition.addExecute(ThemisOperatorHelper.convert(o, ThemisExecutable.class));
//        }
//        return themisSerialCondition;
//    }
//
//}
