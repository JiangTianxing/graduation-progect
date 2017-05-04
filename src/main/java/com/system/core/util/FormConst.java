package com.system.core.util;

/**
 * Created by jx on 2017/4/26.
 */
public class FormConst {
    public static enum STATUS {
        SAVE(2), CHECK(1), DELETE(0);

        private int key;

        STATUS(int key) {
            this.key = key;
        }

        public int getValue() {
            return this.key;
        }
    }

    public static class NEWS_TYPE {
        public static int getValue(String typeName) {
            int type;
            switch (typeName) {
                case("民法") :
                    type = 4;
                    break;
                case("行政") :
                    type = 3;
                    break;
                case("刑法") :
                    type = 2;
                    break;
                case("法史") :
                    type = 1;
                    break;
                default:
                    type = 0;
                    break;
            }
            return type;
        }
        public static String getKey(int value) {
            String typeName;
            switch (value) {
                case 4:
                    typeName = "民法";
                    break;
                case 3:
                    typeName = "行政";
                    break;
                case 2:
                    typeName = "刑法";
                    break;
                case 1:
                    typeName = "法史";
                    break;
                default:
                    typeName = "错误";
                    break;
            }
            return typeName;
        }
    }

    public static class RULE_PAGE {
        private static int value = 10;
        public static int getValue() {
            return RULE_PAGE.value;
        }
        public static void setValue(int value) {
            RULE_PAGE.value = value;
        }
    }
}