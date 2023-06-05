package com.gbl;

/**
 * 交付单状态
 *
 * @author gbl
 */
public enum DeliveryStatusEnum {
    INIT(0, "初始状态"),
    TO_ALLOCATE(100, "待分配"),
    TO_CONFIRM(101, "待确认"),
    TO_ALLOCATE_CAR(102, "待配车"),
    ALLOCATING(300, "配车中"),
    ALLOCATED_CAR(301, "已配车"),
    PRODUCTION_CAR_TRANSFERRING(302, "一次物流转运中"),
    DELIVERY_RECEIVE_CAR(303, "交付中心已收车"),
    WAIT_PICK_CAR(500, "待用户提车"),
    SCHEDULED(501, "已排程"),
    ARRANGE_COMPLETE(502, "整备完成"),
    SIGN(600, "已签到"),
    CONFIRM_PICK_CAR(601, "用户确认提车"),
    COMPLETE(200, "交付完成"),
    ACTIVATED(201, "车机激活"),
    CONFIRM_FAIL(401, "确认失败"),
    REFUSE_PICK_CAR(402, "用户拒绝提车");

    private Integer state;

    private String stateName;

    public Integer getState() {
        return state;
    }

    public String getStateName() {
        return stateName;
    }

    DeliveryStatusEnum(Integer state, String stateName) {
        this.state = state;
        this.stateName = stateName;
    }
}
