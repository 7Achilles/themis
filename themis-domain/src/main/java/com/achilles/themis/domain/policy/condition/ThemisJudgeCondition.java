//package com.achilles.themis.domain.policy.condition;
//
//import com.achilles.themis.domain.policy.ThemisExecutable;
//import com.achilles.themis.domain.policy.actuator.ThemisBaseActuator;
//import com.achilles.themis.domain.valueObject.ThemisExecutableState;
//
//public class ThemisJudgeCondition extends ThemisCondition{
//
//    private ThemisExecutable judge;
//
//    private ThemisExecutable trueExecute;
//
//    private ThemisExecutable falseExecute;
//
//    @Override
//    protected String doExecute(ThemisBaseActuator actuator) throws Exception {
//        String response;
//        if(judge.getState() == ThemisExecutableState.SUCCESS){
//            response = trueExecute.execute(actuator);
//        }else {
//            response = falseExecute.execute(actuator);
//        }
//        return response;
//    }
//
//
//    public void setJudge(ThemisExecutable judge) {
//        this.judge = judge;
//    }
//
//    public void setTrueExecute(ThemisExecutable trueExecute) {
//        this.trueExecute = trueExecute;
//    }
//
//    public void setFalseExecute(ThemisExecutable falseExecute) {
//        this.falseExecute = falseExecute;
//    }
//}
