package cn.smart.manager.enums;

/**
 * Created By victorrrr on 2017/8/9
 */
public class smartEnum {

    /**
     * 设备类型（0：心率带；1：手表）
     */
    public enum DeviceType {

        HEARTRATEMONITOR("心率带", 0),
        WATCH("手表", 1);

        private String name;
        private Integer value;

        DeviceType(String name, Integer value) {
            this.name = name;
            this.value = value;
        }

        public String getName() {
            return name;
        }

        public Integer getValue() {
            return value;
        }
    }

    /**
     * 禁用状态（0绑定，1解绑）
     */
    public enum Status {

        BIND("绑定", 0),
        UNBIND("解绑", 1);

        private String name;
        private Integer value;

        Status(String name, Integer value) {
            this.name = name;
            this.value = value;
        }

        public String getName() {
            return name;
        }

        public Integer getValue() {
            return value;
        }
    }

    /**
     * 性别（0男1女）
     */
    public enum Sex {

        MAN("男", 0),
        FEMALE("女", 1);

        private String name;
        private Integer value;

        Sex(String name, Integer value) {
            this.name = name;
            this.value = value;
        }

        public String getName() {
            return name;
        }

        public Integer getValue() {
            return value;
        }
    }

}
