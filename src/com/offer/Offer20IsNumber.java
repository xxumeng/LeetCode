package com.offer;

import java.util.HashMap;
import java.util.Map;

enum State{
    STATE_INITIAL,
    STATE_SIGN,
    STATE_INTERGER,
    STATE_POINT_WITH_INT,
    STATE_POINT_WITHOUT_INT,
    STATE_FRACTION, //小数
    STATE_EXP,
    STATE_EXP_SIGN,
    STATE_EXP_NUMBER,
    STATE_END

}
enum CharType{
    CHAR_SPACE,
    CHAR_SIGN,
    CHAR_NUMBER,
    CHAR_POINT,
    CHAR_EXP,
    CHAR_ILLEGAL,

}

public class Offer20IsNumber {
    public CharType toCharType(char ch) {
        if (ch >= '0' && ch <= '9') {
            return CharType.CHAR_NUMBER;
        } else if (ch == 'e' || ch == 'E') {
            return CharType.CHAR_EXP;
        } else if (ch == '.') {
            return CharType.CHAR_POINT;
        } else if (ch == '+' || ch == '-') {
            return CharType.CHAR_SIGN;
        } else if (ch == ' ') {
            return CharType.CHAR_SPACE;
        } else {
            return CharType.CHAR_ILLEGAL;
        }
    }
    public boolean isNumber(String s) {
        //状态 + 字符  -> 下一状态
        Map<State, Map<CharType, State>> transfer = new HashMap<State, Map<CharType, State>>();

        //初始状态转换
        Map<CharType, State> initialMap = new HashMap<CharType, State>(){{
            put(CharType.CHAR_SPACE, State.STATE_INITIAL);
            put(CharType.CHAR_SIGN, State.STATE_SIGN);
            put(CharType.CHAR_NUMBER, State.STATE_INTERGER);
            put(CharType.CHAR_POINT, State.STATE_POINT_WITHOUT_INT);
        }
        };
        transfer.put(State.STATE_INITIAL, initialMap);

        //符号位状态转换
        Map<CharType, State> signMap = new HashMap<CharType, State>(){{
            put(CharType.CHAR_NUMBER, State.STATE_INTERGER);
            put(CharType.CHAR_POINT, State.STATE_POINT_WITHOUT_INT);
        }
        };
        transfer.put(State.STATE_SIGN, signMap);

        //小数点（无整数）状态转换
        Map<CharType, State> pointWithoutIntMap = new HashMap<CharType, State>(){{
            put(CharType.CHAR_NUMBER, State.STATE_FRACTION);
        }
        };
        transfer.put(State.STATE_POINT_WITH_INT, pointWithoutIntMap);

        //整数状态转换
        Map<CharType, State> integerMap = new HashMap<CharType, State>(){{
            put(CharType.CHAR_NUMBER, State.STATE_INTERGER);
            put(CharType.CHAR_POINT, State.STATE_POINT_WITH_INT);
            put(CharType.CHAR_EXP, State.STATE_EXP);
            put(CharType.CHAR_SPACE, State.STATE_END);
        }
        };
        transfer.put(State.STATE_INTERGER, integerMap);

        //小数点（有整数）状态转换
        Map<CharType, State> pointWithIntMap = new HashMap<CharType, State>(){{
            put(CharType.CHAR_EXP, State.STATE_EXP_NUMBER);
            put(CharType.CHAR_NUMBER, State.STATE_FRACTION);
            put(CharType.CHAR_SPACE, State.STATE_END);
        }
        };
        transfer.put(State.STATE_POINT_WITH_INT, pointWithIntMap);

        //小数状态转换
        Map<CharType, State> fractionMap = new HashMap<CharType, State>(){{
            put(CharType.CHAR_EXP, State.STATE_EXP);
            put(CharType.CHAR_NUMBER, State.STATE_FRACTION);
            put(CharType.CHAR_SPACE, State.STATE_END);
        }
        };
        transfer.put(State.STATE_FRACTION, fractionMap);

        //e状态转换
        Map<CharType, State> expMap = new HashMap<CharType, State>(){{
            put(CharType.CHAR_SIGN, State.STATE_EXP_SIGN);
            put(CharType.CHAR_NUMBER, State.STATE_EXP_NUMBER);
            put(CharType.CHAR_SPACE, State.STATE_END);
        }
        };
        transfer.put(State.STATE_EXP, expMap);

        //指数符号状态转换
        Map<CharType, State> expSignMap = new HashMap<CharType, State>(){{
            put(CharType.CHAR_NUMBER, State.STATE_EXP_NUMBER);
        }
        };
        transfer.put(State.STATE_EXP_SIGN, expSignMap);

        //指数数字状态转换
        Map<CharType, State> expNumberMap = new HashMap<CharType, State>(){{
            put(CharType.CHAR_NUMBER, State.STATE_EXP_NUMBER);
            put(CharType.CHAR_SPACE, State.STATE_END);
        }
        };
        transfer.put(State.STATE_EXP_NUMBER, expNumberMap);

        //末尾状态转换
        Map<CharType, State> endMap = new HashMap<CharType, State>(){{
            put(CharType.CHAR_SPACE, State.STATE_END);
        }
        };
        transfer.put(State.STATE_END, endMap);




        State state = State.STATE_INITIAL;
        for(int i=0; i<s.length(); i++){
            CharType type = toCharType(s.charAt(i));
            if(!transfer.get(state).containsKey(type)){
                return false;
            }else {
                state = transfer.get(state).get(type);
            }
        }
        return state==State.STATE_INTERGER || state == State.STATE_POINT_WITH_INT || state == State.STATE_FRACTION || state == State.STATE_EXP_NUMBER || state == State.STATE_END;

    }
}
