package com.gbl;


/**
 * 车辆状态
 *
 * @author gbl
 */
public enum CarStatusEnum {

    PRODUCTION_INIT(0, "初始状态"),
    WAIT_SCHEDULE(100, "待预排"),
    WAIT_PRODUCTION_ISSUE(101, "待排程"),
    WAIT_PRODUCTION(102, "待生产"),
    ASSEMBLER_ONLINE(103, "焊装上线"),
    FINAL_ASSEMBLER_ONLINE(104, "总装上线"),
    CERTIFICATE_COMPLETE(105, "已下线合格"),
    PRODUCTION_CAR_TRANSFERRING(300, "一次物流转运中"),
    DELIVERY_RECEIVE_CAR(301, "交付中心已收车"),
    PDI_CHECK_PASS(500, "PDI检测通过"),
    ARRANGE_COMPLETE(501, "整备完成"),
    ACTIVATED(200, "车机激活"),
    PRODUCTION_CANCEL(401, "取消排产"),
    PDI_CHECK_FAILED(402, "PDI检测未通过");

    private final Integer state;

    private final String stateName;

    public Integer getState() {
        return state;
    }

    public String getStateName() {
        return stateName;
    }

    CarStatusEnum(Integer state, String stateName) {
        this.state = state;
        this.stateName = stateName;
    }
}
