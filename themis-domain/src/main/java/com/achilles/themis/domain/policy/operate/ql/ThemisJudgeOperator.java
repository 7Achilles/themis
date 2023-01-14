//package com.achilles.themis.domain.policy.operate.ql;
//
//import com.achilles.themis.domain.policy.ThemisExecutable;
//import com.achilles.themis.domain.policy.condition.ThemisJudgeCondition;
//
//public class ThemisJudgeOperator extends ThemisBaseOperator<ThemisJudgeCondition>{
//
//    @Override
//    public ThemisJudgeCondition build(Object[] objects) throws Exception {
//        if(objects.length != 3) throw  new Exception("ThemisJudgeCondition only need three parameter!");
//        ThemisJudgeCondition themisJudgeCondition = new ThemisJudgeCondition();
//        themisJudgeCondition.setJudge((ThemisExecutable)objects[0]);
//        themisJudgeCondition.setTrueExecute((ThemisExecutable)objects[1]);
//        themisJudgeCondition.setFalseExecute((ThemisExecutable)objects[2]);
//        return themisJudgeCondition;
//    }
//
//}
